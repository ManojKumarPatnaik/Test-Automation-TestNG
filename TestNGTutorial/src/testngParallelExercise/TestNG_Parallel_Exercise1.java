package testngParallelExercise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNG_Parallel_Exercise1 {

	private WebDriver driver;
	private String baseURL;

	@BeforeMethod
	@Parameters({ "browser" })
	public void beforeMethod(String browser) {
		if (browser.equals("Chrome")) {
			driver = new ChromeDriver();
		} else {
			driver = new FirefoxDriver();
		}
		baseURL = "https://www.goibibo.com/";

	}

	@Test
	public void test() throws InterruptedException {

		driver.get(baseURL);

		String clickXpath = "//input[@id='gosuggest_inputSrc']";
		String inputSearch = "delhi";
		String type = "xpath";
		WebElement element = driver.findElement(By.xpath(clickXpath));
		element.click();
		Thread.sleep(3000);
		element.sendKeys(inputSearch);
		Thread.sleep(3000);

	}
}
