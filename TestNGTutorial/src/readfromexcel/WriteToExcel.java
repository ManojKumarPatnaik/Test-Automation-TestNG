package readfromexcel;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import extentreports.Screenshot;

public class WriteToExcel {

	private WebDriver driver;

	@BeforeClass
	public void beforeClass() throws Exception {
		driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.get(Constants.URL);

		// Tell the code about the location of the excel file
		ExcelUtility.setExcelFile(Constants.File_Path + Constants.File_Name, "LoginTest");

	}

	@Test(dataProvider = "TestData")
	public void test(String TestData1, String TestData2) throws Exception {
		WebElement element = driver.findElement(By.xpath("//input[@id='gosuggest_inputSrc']"));
		element.click();
		Thread.sleep(4000);

		element.sendKeys(TestData1);

		WebElement destination = driver.findElement(By.id("react-autosuggest-1"));
		List<WebElement> liElements = destination.findElements(By.tagName("li"));
		Thread.sleep(3000);
		for (WebElement eachElement : liElements) {
			if (eachElement.getText().contains(TestData2)) {
				eachElement.click();
				Thread.sleep(4000);
				break;
			}

		}

		ExcelUtility.setCellData(2, 4, "Passed");

	}

	@AfterMethod
	public void afterMethod(ITestResult testResult) throws Exception {
		if (testResult.getStatus() == ITestResult.FAILURE) {
			Screenshot.takeScreenshot(driver, "autocompleteFailure");
		}

		ExcelUtility.setCellData(2, 4, "Failed");

	}

	@DataProvider(name = "TestData")
	public Object[][] autoCompleteCheck() {

		Object[][] testData = ExcelUtility.getTestData("Invalid_Data");

		return testData;
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
