package extentreports;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentReportTest {

	private WebDriver driver;
	private String baseURL;
	ExtentReports report;
	ExtentTest test;

	@BeforeClass
	public void beforeClass() {
		// report = new ExtentReports(System.getProperty("user.dir") +
		// "//ExtentReports//ExtentReportResults.html");
		// Commented above as we are running multiple testcases using Extent Factory and
		// using xml.If
		// you want to run alone ,then uncomment the above
		report = ExtentFactory.getInstance();

		test = report.startTest("Verify the Welcome Test");
		driver = new ChromeDriver();
		test.log(LogStatus.INFO, "Browser Started");
		baseURL = "https://www.goibibo.com/";
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		test.log(LogStatus.INFO, "Browser Maximized");

	}

	@Test
	public void validLoginTest() throws InterruptedException {
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

		test.log(LogStatus.PASS, "Test Successful");

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
		report.endTest(test);
		report.flush();
	}

}
