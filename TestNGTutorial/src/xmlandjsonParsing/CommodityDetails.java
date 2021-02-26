package xmlandjsonParsing;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class CommodityDetails { // Do not change the class name

	// Use the below declarations
	public static WebDriver driver;
	private static Document doc;
	private static NodeList nodeList;
	private static XPath xpath;
	private static int count = 2;

	public static String name, weight, length, width, height;

	public static WebDriver createDriver() { // Do not change the method signature
		// Create the driver using the class 'DriverSetup'. Assign it to the variable
		// 'driver' and return it.
		// Use URL, "http://webapps.tekstac.com/CommodityDetails/"

		driver = new ChromeDriver();

		driver.get("https://webapps.tekstac.com/CommodityDetails/");
		return driver;

	}

	public static XPath readFile(String fileName, String id) { // Do not change the method signature
		// Pass fileName and commodity id as parameter
		// Parse the xml file. Return the xpath reference
		try {
			File file = new File(fileName);
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			doc = builder.parse(file);

			xpath = XPathFactory.newInstance().newXPath();

			nodeList = doc.getElementsByTagName("Commodity");
			// System.out.println(nodeList);
			return xpath;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return xpath;

	}

	public static Node getName(int id) { // Do not change the method signature
		// Pass the commodity id as parameter. Parse name and return it node.
		for (int i = 0; i < nodeList.getLength(); i++) {
			Node nNode = nodeList.item(i);
			Element elem = (Element) nNode;

			String uid = elem.getAttribute("id");
			if (Integer.parseInt(elem.getAttribute("id")) == id) {
				Node node1 = elem.getElementsByTagName("Name").item(0);
				// driver.findElement(By.id("firstname")).sendKeys(firstname);
				return node1;
			}

		}
		return null;

	}

	public static Node getWeight(int id) { // Do not change the method signature
		// Pass the commodity id as parameter. Parse weight and return it node.
		for (int i = 0; i < nodeList.getLength(); i++) {
			Node nNode = nodeList.item(i);
			Element elem = (Element) nNode;

			String uid = elem.getAttribute("id");
			if (Integer.parseInt(elem.getAttribute("id")) == id) {
				Node node1 = elem.getElementsByTagName("Weight").item(0);
				// driver.findElement(By.id("firstname")).sendKeys(firstname);
				return node1;
			}

		}
		return null;

	}

	public static Node getLength(int id) { // Do not change the method signature
		// Pass the commodity id as parameter. Parse length and return it node.
		for (int i = 0; i < nodeList.getLength(); i++) {
			Node nNode = nodeList.item(i);
			Element elem = (Element) nNode;

			String uid = elem.getAttribute("id");
			if (Integer.parseInt(elem.getAttribute("id")) == id) {
				Node node1 = elem.getElementsByTagName("Length").item(0);
				// driver.findElement(By.id("firstname")).sendKeys(firstname);
				return node1;
			}

		}
		return null;

	}

	public static Node getWidth(int id) { // Do not change the method signature
		// Pass the commodity id as parameter. Parse width and return it node.
		for (int i = 0; i < nodeList.getLength(); i++) {
			Node nNode = nodeList.item(i);
			Element elem = (Element) nNode;

			String uid = elem.getAttribute("id");
			if (Integer.parseInt(elem.getAttribute("id")) == id) {
				Node node1 = elem.getElementsByTagName("Width").item(0);
				// driver.findElement(By.id("firstname")).sendKeys(firstname);
				return node1;
			}

		}
		return null;

	}

	public static Node getHeight(int id) { // Do not change the method signature
		// Pass the commodity id as parameter. Parse heigth and return it node.
		for (int i = 0; i < nodeList.getLength(); i++) {
			Node nNode = nodeList.item(i);
			Element elem = (Element) nNode;

			String uid = elem.getAttribute("id");
			if (Integer.parseInt(elem.getAttribute("id")) == id) {
				Node node1 = elem.getElementsByTagName("Height").item(0);
				// driver.findElement(By.id("firstname")).sendKeys(firstname);
				return node1;
			}

		}
		return null;

	}

	public static void readInsertedData() { // Do not change the method signature
		// Locate the row displayed on the page after submit.
		// Find the text of of name,weight,height,width and length and store it in
		// respective variables declared above

		name = driver.findElement(By.xpath("//tbody[1]/tr[" + count + "]/td[1]")).getText();
		weight = driver.findElement(By.xpath("//tbody[1]/tr[" + count + "]/td[2]")).getText();
		length = driver.findElement(By.xpath("//tbody[1]/tr[" + count + "]/td[3]")).getText();
		width = driver.findElement(By.xpath("//tbody[1]/tr[" + count + "]/td[4]")).getText();
		height = driver.findElement(By.xpath("//tbody[1]/tr[" + count + "]/td[5]")).getText();

		System.out.println(name + " " + weight + " " + length + " " + width + " " + height);
		System.out.println(CommodityDetails.getCommodityCount());
		System.out.println(CommodityDetails.getTotalComWeight());
		count++;
	}

	public static String getCommodityCount() { // Do not change the method signature
		// Locate commodity count value after submit and return it

		String count = driver.findElement(By.id("count")).getText();
		System.out.println(count);

		return count;

	}

	public static String getTotalComWeight() { // Do not change the method signature
		// Locate total weight value after submit and return it

		String total = driver.findElement(By.id("total")).getText();
		System.out.println(total);

		return total;
	}

	public static void submitForm(int id) { // Do not change the method signature
		// Locate the form elements and send the values parsed from xml.
		// Submit the form.
		// Pass commodity id as parameter

		driver.findElement(By.id("name")).sendKeys(getName(id).getTextContent());
		driver.findElement(By.id("weight")).sendKeys(getWeight(id).getTextContent());
		driver.findElement(By.id("length")).sendKeys(getLength(id).getTextContent());
		driver.findElement(By.id("width")).sendKeys(getWidth(id).getTextContent());
		driver.findElement(By.id("height")).sendKeys(getHeight(id).getTextContent());

		driver.findElement(By.id("add")).click();

	}

	public static void main(String[] args) {
		CommodityDetails commodity = new CommodityDetails();
		// Implement code here
		commodity.createDriver();
		commodity.readFile(System.getProperty("user.dir") + "//commodity.xml", "1");
		commodity.submitForm(1);
		commodity.readInsertedData();


	}

}