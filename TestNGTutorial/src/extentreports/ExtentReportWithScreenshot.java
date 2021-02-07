package extentreports;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class ExtentReportWithScreenshot {
	private WebDriver driver;
	private String baseURL;
	ExtentReports report;
	ExtentTest test;

	@BeforeClass
	public void beforeClass() {

		report = new ExtentReports(System.getProperty("user.dir") + "//ExtentReports//ExtentReportResults.html", true);
		test = report.startTest("Verify the Welcome Test");
		driver = new ChromeDriver();
		test.log(LogStatus.INFO, "Browser Started");
		baseURL = "https://www.goibibo.com/";
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		test.log(LogStatus.INFO, "Browser Maximized");
	}

	@Test
	public void testScreenshotwithExtentReport() throws InterruptedException {

		String destination = "Ben";
		String fullDestn = "Bengaluru, India";
		String locator = "//input[@id='gosuggest_inputSrc']";

		driver.get(baseURL);
		test.log(LogStatus.INFO, "Web Application Opened");
		WebElement element = driver.findElement(By.xpath(locator));
		element.click();
		test.log(LogStatus.INFO, "Click on the destination field");
		Thread.sleep(4000);
		element.sendKeys(destination);
		Thread.sleep(4000);
		test.log(LogStatus.INFO, "Entering the destination field");

		Assert.assertTrue(false);// Intentionally failing the testcase to capture screenshot

		test.log(LogStatus.PASS, "Test Successful");

	}

	// Read more about Extent Report and its features from
	// extentreports.relavantcodes.version2.docs.html

	@AfterMethod
	public void afterMethod(ITestResult testResult) throws Exception {

		if (testResult.getStatus() == ITestResult.FAILURE) {
			String path = Screenshot.takeScreenshot(driver, testResult.getName());
			String imgPath = test.addScreenCapture(path);
			test.log(LogStatus.FAIL, "Test has Failed", imgPath);
		}

		driver.quit();
		report.endTest(test);
		report.flush();
	}
}
