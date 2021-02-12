package xmlandjsonParsing;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.By;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPath.*;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class UserDetails { // Do not change the class name

	// use this variable declaration
	public static WebDriver driver;
	public XPath xpath;
	public Document doc;
	NodeList nodeList;

	public static WebDriver createDriver() { // Do not change the method signature
		// DriverSetup ds=new DriverSetup();
		// driver=ds.getWebDriver();

		/* Create a driver. Assign it to static variable 'driver' and return it */
		/*
		 * navigate to
		 */
		driver = new ChromeDriver();
		driver.get("http://webapps.tekstac.com/FormRegistration/UserRegistration.html");

		return driver;
	}

	public XPath ReadFile(String fileName, String id) { // Do not change the method signature
		// Retrieve the xml file name passed as 'fileName' parameter. Parse the xml and
		// return the xPath
		// Parameter 'id' is the id in the Userdetails.xml
		try {
			File file = new File(fileName);
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			doc = builder.parse(file);

			xpath = XPathFactory.newInstance().newXPath();
			String expression = "//User";// [@id=" + id + "]";
			// nodeList = (NodeList) xpath.compile(expression).evaluate(doc,
			// XPathConstants.NODESET);
			nodeList = doc.getElementsByTagName("User");
			System.out.println(nodeList);
			return xpath;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return xpath;

	}

	public Node getName(int id) { // Do not change the method signature
		// Parse the xml to get 'Name' element. Return its node
		// Parameter 'id' is the id in the Userdetails.xml
		Node node1=null;
		for (int i = 0; i < nodeList.getLength(); i++) {
			Node nNode = nodeList.item(i);
			Element elem = (Element) nNode;

			String uid = elem.getAttribute("id");
			if (Integer.parseInt(elem.getAttribute("id")) == id) {
				 node1 = elem.getElementsByTagName("Name").item(0);
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				driver.findElement(By.id("uname")).sendKeys(node1.getTextContent());
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				return node1;
			}

		}
		return node1;

	}

	public Node getEmail(int id) { // Do not change the method signature
		// Parse the xml to get 'Email' element. Return its node
		// Parameter 'id' is the id in the Userdetails.xml
		for (int i = 0; i < nodeList.getLength(); i++) {
			Node nNode = nodeList.item(i);
			Element elem = (Element) nNode;

			if (Integer.parseInt(elem.getAttribute("id")) == id) {
				Node node1 = elem.getElementsByTagName("Email").item(0);
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				driver.findElement(By.id("uemail")).sendKeys(node1.getTextContent());
				return node1;
			}

		}
		return null;
	}

	public Node getPhone(int id) { // Do not change the method signature
		// Parse the xml to get 'Phone' element. Return its node
		// Parameter 'id' is the id in the Userdetails.xml
		for (int i = 0; i < nodeList.getLength(); i++) {
			Node nNode = nodeList.item(i);
			Element elem = (Element) nNode;

			if (Integer.parseInt(elem.getAttribute("id")) == id) {
				Node node1 = elem.getElementsByTagName("Phone").item(0);
				driver.findElement(By.id("phone")).sendKeys(node1.getTextContent());
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				return node1;
			}

		}
		return null;
	}

	public Node getAge(int id) { // Do not change the method signature
		// Parse the xml to get 'Age' element. Return its node
		// Parameter 'id' is the id in the Userdetails.xml
		for (int i = 0; i < nodeList.getLength(); i++) {
			Node nNode = nodeList.item(i);
			Element elem = (Element) nNode;

			if (Integer.parseInt(elem.getAttribute("id")) == id) {
				Node node1 = elem.getElementsByTagName("Age").item(0);
				driver.findElement(By.id("age")).sendKeys(node1.getTextContent());
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				return node1;
			}

		}
		return null;
	}

	public Node getPassword(int id) { // Do not change the method signature
		// Parse the xml to get 'Password' element. Return its node
		// Parameter 'id' is the id in the Userdetails.xml
		for (int i = 0; i < nodeList.getLength(); i++) {
			Node nNode = nodeList.item(i);
			Element elem = (Element) nNode;

			String uid = elem.getAttribute("id");
			if (Integer.parseInt(elem.getAttribute("id")) == id) {
				Node node1 = elem.getElementsByTagName("Password").item(0);
				driver.findElement(By.id("pass")).sendKeys(node1.getTextContent());
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				return node1;
			}

		}
		return null;
	}

	public Node getHobbies(int id) { // Do not change the method signature
		// Parse the xml to get 'Hobbies' element. Return its node
		// Parameter 'id' is the id in the Userdetails.xml
		for (int i = 0; i < nodeList.getLength(); i++) {
			Node nNode = nodeList.item(i);
			Element elem = (Element) nNode;

			if (Integer.parseInt(elem.getAttribute("id")) == id) {
				Node node1 = elem.getElementsByTagName("Hobbies").item(0);
				if (node1.getTextContent().equals("Cricket")) {
					driver.findElement(By.id("option1")).click();
					driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				} else {
					driver.findElement(By.id("option2")).click();
					driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				}
				return node1;
			}

		}
		return null;
	}

	public Node getGender(int id) { // Do not change the method signature
		// Parse the xml to get 'Gender' element. Return its node
		// Parameter 'id' is the id in the Userdetails.xml
		for (int i = 0; i < nodeList.getLength(); i++) {
			Node nNode = nodeList.item(i);
			Element elem = (Element) nNode;

			if (Integer.parseInt(elem.getAttribute("id")) == id) {
				Node node1 = elem.getElementsByTagName("Gender").item(0);
				if (node1.getTextContent().equals("Male")) {
					driver.findElement(By.id("male")).click();
					driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				} else {
					driver.findElement(By.id("female")).click();
					driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				}
				return node1;
			}

		}
		return null;
	}

	public Node getCity(int id) { // Do not change the method signature
		// Parse the xml to get 'City' element. Return its node
		// Parameter 'id' is the id in the Userdetails.xml
		for (int i = 0; i < nodeList.getLength(); i++) {
			Node nNode = nodeList.item(i);
			Element elem = (Element) nNode;

			if (Integer.parseInt(elem.getAttribute("id")) == id) {
				Node node1 = elem.getElementsByTagName("City").item(0);
				Select select = new Select(driver.findElement(By.id("city")));
				select.selectByVisibleText(node1.getTextContent());
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

				return node1;
			}

		}
		return null;
	}

	public Node getAddress(int id) { // Do not change the method signature
		// Parse the xml to get 'Address' element. Return its node
		// Parameter 'id' is the id in the Userdetails.xml
		for (int i = 0; i < nodeList.getLength(); i++) {
			Node nNode = nodeList.item(i);
			Element elem = (Element) nNode;

			if (Integer.parseInt(elem.getAttribute("id")) == id) {
				Node node1 = elem.getElementsByTagName("Address").item(0);
				driver.findElement(By.name("address")).sendKeys(node1.getTextContent());
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				return node1;
			}

		}
		return null;
	}

	public String getMessage() { // Do not change the method signature

		// Find the web elements in the page. Assign the respective values from xml to
		// the form.
		// Submit the form
		// Locate the 'Registered Successfully' message and return it
//		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//		driver.findElement(By.id("uname")).sendKeys(getName(1).getTextContent());
//		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		
		
		driver.findElement(By.id("submit")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		return driver.findElement(By.xpath("//h2")).getText();

	}

	public static void main(String[] args) {
		UserDetails pagLocator = new UserDetails();
		// Add required code here
		pagLocator.ReadFile(System.getProperty("user.dir") + "//UserDetails.xml", "2");
		pagLocator.createDriver();
		System.out.println(pagLocator.getName(2));
		System.out.println(pagLocator.getEmail(2).getNodeName());
		System.out.println(pagLocator.getAddress(2).getNodeName());
		System.out.println(pagLocator.getAge(2).getNodeName());
		System.out.println(pagLocator.getCity(2).getNodeName());
		System.out.println(pagLocator.getHobbies(2).getNodeName());
		System.out.println(pagLocator.getGender(2).getNodeName());
		System.out.println(pagLocator.getPassword(2).getNodeName());
		System.out.println(pagLocator.getPhone(2).getNodeName());
		 System.out.println(pagLocator.getMessage());
	}
}