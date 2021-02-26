package readfromexcel;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FetchFromExcelExxercise {

	public static WebDriver driver;

	public void createDriver() { // Do not change the method signature
		// Implement code to create driver and assign it to 'static' driver variable

		driver = new ChromeDriver();
		driver.get("http://webapps.tekstac.com/CustomerRegistration/");

	}

	public void testSeleniumTestForm() { // Do not change the method signature
		// Read the data from excel sheet. Sheet name is 'customervalid'
		// find the elements in the form and set values parsed from excel sheet. Submit
		// the form for registration
		try {
			CusRegExcel cus = new CusRegExcel();

			String[] data = new String[5];
			data = cus.readExcelData("CustReg.xlsx");

			// driver.findElement(By.name("reset")).click();
			driver.findElement(By.name("cname")).sendKeys(data[0]);
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			// Thread.sleep(4000);
			driver.findElement(By.name("age")).sendKeys(data[1]);
			driver.findElement(By.name("address")).sendKeys(data[2]);
			driver.findElement(By.name("phonenumber")).sendKeys(data[3]);
			driver.findElement(By.name("email")).sendKeys(data[4]);
			driver.findElement(By.id("submit")).click();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void closeBrowser() {
		// close the browser

		driver.close();
	}

	public static void main(String[] args) throws Exception {
		CusRegExcel customer = new CusRegExcel();
		// Add required code
		FetchFromExcelExxercise testform = new FetchFromExcelExxercise();
		testform.createDriver();
		testform.testSeleniumTestForm();
		// testform.closeBrowser();
	}

}
