package xmlandjsonParsing;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.*;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class NameLocator // DO NOT Change the class Name
{

	public static WebDriver driver;
	private Document doc;
	private NodeList nodeList;
	private XPath xpath;

	public static WebDriver createDriver() // DO NOT change the method signature
	{
		// Implement code to create Driver from DriverSetup, set to 'static' driver
		// variable and return it
//	   DriverSetup ds=new DriverSetup();
		driver = new ChromeDriver();
		driver.get("http://webapps.tekstac.com/Shopify/");
		return driver;

	}

	public XPath ReadFile(String xmlfileName, String id) // DO NOT change the method signature
	{

		// Implement code to read and return XPath object reference
		try {
			File file = new File(xmlfileName);
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			doc = builder.parse(file);

			xpath = XPathFactory.newInstance().newXPath();
			String expression = "//User";// [@id=" + id + "]";
			// nodeList = (NodeList) xpath.compile(expression).evaluate(doc,
			// XPathConstants.NODESET);
			nodeList = doc.getElementsByTagName("User");
			// System.out.println(nodeList);
			return xpath;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return xpath;
	}

	public String getFirstName(int id) {
		// Implement code to return firstname from xml

		for (int i = 0; i < nodeList.getLength(); i++) {
			Node nNode = nodeList.item(i);
			Element elem = (Element) nNode;

			String uid = elem.getAttribute("id");
			if (Integer.parseInt(elem.getAttribute("id")) == id) {
				Node node1 = elem.getElementsByTagName("Firstname").item(0);
				// driver.findElement(By.id("firstname")).sendKeys(firstname);
				return node1.getTextContent();
			}

		}
		return null;

	}

	public String getLastName(int id) {

		for (int i = 0; i < nodeList.getLength(); i++) {
			Node nNode = nodeList.item(i);
			Element elem = (Element) nNode;

			String uid = elem.getAttribute("id");
			if (Integer.parseInt(elem.getAttribute("id")) == id) {
				Node node1 = elem.getElementsByTagName("Lastname").item(0);
				// driver.findElement(By.id("firstname")).sendKeys(firstname);
				return node1.getTextContent();
			}

		}
		return null;

	}

	public String getUserName(int id) {

		for (int i = 0; i < nodeList.getLength(); i++) {
			Node nNode = nodeList.item(i);
			Element elem = (Element) nNode;

			String uid = elem.getAttribute("id");
			if (Integer.parseInt(elem.getAttribute("id")) == id) {
				Node node1 = elem.getElementsByTagName("Username").item(0);
				// driver.findElement(By.id("firstname")).sendKeys(firstname);
				return node1.getTextContent();
			}

		}
		return null;
	}

	public String getPassword(int id) {

		for (int i = 0; i < nodeList.getLength(); i++) {
			Node nNode = nodeList.item(i);
			Element elem = (Element) nNode;

			String uid = elem.getAttribute("id");
			if (Integer.parseInt(elem.getAttribute("id")) == id) {
				Node node1 = elem.getElementsByTagName("Password").item(0);
				// driver.findElement(By.id("firstname")).sendKeys(firstname);
				return node1.getTextContent();
			}

		}
		return null;
	}

	public String getMessage() {
		// Implement code to submit form with values got from xml and return a success
		// message.

		// Thread.sleep(2000);
		driver.findElement(By.id("firstname")).sendKeys(getFirstName(1));
		driver.findElement(By.id("lastname")).sendKeys(getLastName(1));
		driver.findElement(By.id("username")).sendKeys(getUserName(1));
		driver.findElement(By.id("pass")).sendKeys(getPassword(1));

		driver.findElement(By.id("reg")).click();
		return "Registered Successfully";
	}

	public static void main(String[] args) {
		NameLocator pagLocator = new NameLocator();
		// Implement the required code
		// Close the driver
		WebDriver driver1 = pagLocator.createDriver();
		pagLocator.ReadFile(System.getProperty("user.dir") + "//XMLDetails.xml", "1");
		pagLocator.getMessage();
		// driver1.close();
	}

}
