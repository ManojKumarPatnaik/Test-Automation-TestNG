package readfromexcel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;

class WriteExcel { // Do not change the class name
	public static void writeexcel(String data[]) throws Exception {
		XSSFSheet sheet;
		String path = System.getProperty("user.dir") + "//TestData//Shipment.xlsx";
		FileInputStream file = new FileInputStream(path);
		XSSFWorkbook excel = new XSSFWorkbook(file);
		sheet = excel.getSheet("ShipmentData");
		if (sheet == null) {
			sheet = excel.createSheet("ShipmentData");
		}
		int eachValue = 0; // there are total 22 values in the data and we loop over 11 times to create 12
							// rows.So this is to keep track for values in data array.
		for (int i = 0; i < 12; i++) {
			XSSFRow row = sheet.createRow(i);
			int count = 0;
			// for 11 th and 12 th row we have single values so we directly set values.
			if (i == 10 || i == 11) {
				XSSFCell cell = row.createCell(count);
				cell.setCellValue(data[eachValue]);
				eachValue++;
				count++;
				continue;
			}
			// for 1 to 10th row we are looping 2 times as we have to set values in 2
			// columns unlike in row 11 and 12.
			while (count < 2) {
				XSSFCell cell = row.createCell(count);
				cell.setCellValue(data[eachValue]);
				eachValue++; // we are incrementing values of dataPosition in everyloop after value is
								// entered in array.
				count++;
			}

		}

		FileOutputStream fos = new FileOutputStream(path);
		excel.write(fos);
		fos.flush();
		fos.close();

	}
}

public class Main { // Do not change the class name

	public static WebDriver driver;
	public static WebElement element;
	public static String data[] = new String[22]; // Note, this is only single dimension dataay

	public static WebDriver setDriver() { // Method to invoke the driver
		// Create the driver using 'getDriver'. Assign it to static variable 'driver'
		// and return it

		/*
		 * Setting up Driver
		 */
		driver = new ChromeDriver();
		driver.get("https://webapps.tekstac.com/shippingDetails/");

		return driver;

	}

	public static void shipmentIDClick(int linkNo) throws Exception {
		// Method to locate value under the 'ShipmentID' column in table using Absolute
		// xpath & click it
		// 'linkNo' tells the number of the link to be clicked (among the 3 links)
		driver.findElement(By.xpath("//a[contains(text(),'" + linkNo + "')]")).click();

	}

	public static String[] storeData() throws Exception {

		int count = 0;

		// getting all the values using xpath into a list
		List<WebElement> list = driver.findElements(By.xpath("//div[@id='result']//td"));

		list.remove(21);// removing the element at 21 because it is empty and we have data array of size
						// 22 only
		for (int i = 0; i < data.length; i++) {
			data[i] = list.get(i).getText();// getting text from the each webelement and storing in String array
		}
//
//		for (String a : data) {
//			System.out.println(a);
//		}
		return data;

	}

	public static void closeBrowser() {
		// Method to close the Browser
		driver.close();
	}

	public static void main(String[] args) throws Exception {
		// Invoke all the above methods
		setDriver();
		shipmentIDClick(1);
		WriteExcel excel = new WriteExcel();
		String[] data = storeData();
		closeBrowser();
		excel.writeexcel(data);
	}
}
