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

public class ExtentReportTest2 {

	private WebDriver driver;
	private String baseURL;
	ExtentReports report;
	ExtentTest test;

	@BeforeClass
	public void beforeClass() {
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

		driver.get(baseURL);

		test.log(LogStatus.PASS, "Test Successful");

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
		report.endTest(test);
		report.flush();
	}

}
