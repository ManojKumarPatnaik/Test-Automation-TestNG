package performancetesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestPerformance {

	private WebDriver driver;
	private String baseURL;

	private long start;
	private long end;
	private double duration;

	@Test
	public void test() {

		driver = new ChromeDriver();
		baseURL = "https://www.goibibo.com/";

		start = System.nanoTime();
		driver.get(baseURL);

		String clickXpath = "//input[@id='gosuggest_inputSrc']";
		String inputSearch = "delhi";
		String type = "xpath";
		WebElement element = driver.findElement(By.xpath(clickXpath));
		element.click();
		element.sendKeys(inputSearch);

		driver.quit();
		end = System.nanoTime();
		duration = (double) end - start / 1000000000;
		System.out.println("Time taken to execute the testcase is: " + duration + " seconds");

	}
	/*
	 * This can be also done by using the Stopwatch class from apache commons time
	 * api
	 */

}
