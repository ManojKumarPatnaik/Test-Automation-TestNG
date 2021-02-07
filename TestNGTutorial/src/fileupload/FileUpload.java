package fileupload;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FileUpload {
	private WebDriver driver;
	private String baseURL;

	@BeforeClass
	public void beforeClass() {

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		baseURL = "https://www.gmail.com/";
	}

	@Test
	public void test() throws AWTException, InterruptedException {
		driver.get(baseURL);
		driver.findElement(By.id("Email")).sendKeys("ur mail id");
		driver.findElement(By.id("next")).click();
		driver.findElement(By.id("Passwd")).sendKeys("ur password");

		driver.findElement(By.id("signIn")).click();

		driver.findElement(By.xpath("//div[text()='COMPOSE']")).click();
		driver.findElement(By.xpath("//div[@class='wO nr l1']//textarea")).sendKeys("senders mailid");
		driver.findElement(By.xpath("//input[@name='subjectbox']")).sendKeys("Test File Upload");
		WebElement fileInput = driver.findElement(By.xpath("//div[@class='a1 aaA aMZ']"));
		fileInput.click();

		StringSelection ss = new StringSelection("path to the file to be attached c//users//... ");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);

		// pressing Ctrl v using robot framework

		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		Thread.sleep(4000);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

		driver.findElement(By.xpath("//div[text()='Send']")).click();

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
