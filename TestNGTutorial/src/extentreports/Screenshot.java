package extentreports;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshot {
		
	public static String takeScreenshot(WebDriver driver, String fileName)throws Exception {

		 fileName = fileName + ".png";
		String directory = System.getProperty("user.dir") + "//screenshots//";

		File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(sourceFile, new File(directory + fileName));
		driver.quit();
		String destination=directory+fileName;
		return destination;
	}

	public static String getRandomString(int length) {
		StringBuilder sb = new StringBuilder();
		String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";

		for (int i = 0; i < str.length(); i++) {
			int index = (int) (Math.random() * str.length());
			sb.append(str.charAt(index));
		}

		return sb.toString();
	}

	
}
