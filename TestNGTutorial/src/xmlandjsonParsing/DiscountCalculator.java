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

public class DiscountCalculator { // Do not change the class name

	// use this variable declaration
	public static WebDriver driver;
	private static Document doc;
	private static NodeList nodeList;
	public static XPath xPath;

	public static WebDriver createDriver() { // Do not change the method signature

		/* Create a driver. Assign it to static variable 'driver' and return it */
		/* navigate to 'https://webapps.tekstac.com/CompanyOffersDiscount/' */

		driver = new ChromeDriver();
		driver.get("https://webapps.tekstac.com/CompanyOffersDiscount/");

		return driver;
	}

	public XPath ReadFile(String fileName, String id) { // Do not change the method signature
		// Retrieve the xml file name passed as 'fileName' parameter. Parse the xml and
		// return the xPath
		// Parameter 'id' is the id in the DiscountCalculator.xml
		try {
			File file = new File(fileName);
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			doc = builder.parse(file);

			xPath = XPathFactory.newInstance().newXPath();

			nodeList = doc.getElementsByTagName("Shipmentdetail");
			// System.out.println(nodeList);
			return xPath;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return xPath;

	}

	public Node getWeight(int id) { // Do not change the method signature
		// Parse the xml to get 'Weight' element. Return its node
		// Parameter 'id' is the id in the DiscountCalculator.xml
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

	public Node getDistance(int id) { // Do not change the method signature
		// Parse the xml to get 'Distance' element. Return its node
		// Parameter 'id' is the id in the DiscountCalculator.xml
		for (int i = 0; i < nodeList.getLength(); i++) {
			Node nNode = nodeList.item(i);
			Element elem = (Element) nNode;

			String uid = elem.getAttribute("id");
			if (Integer.parseInt(elem.getAttribute("id")) == id) {
				Node node1 = elem.getElementsByTagName("Distance").item(0);
				// driver.findElement(By.id("firstname")).sendKeys(firstname);
				return node1;
			}

		}
		return null;

	}

	public String getMessage() { // Do not change the method signature

		// Find the web elements in the page. Assign the respective values from xml to
		// the form.
		// Submit the form
		// Locate the 'Datax shipping company offers discount' message and return it

		driver.findElement(By.id("weight")).sendKeys(getWeight(1).getTextContent());
		driver.findElement(By.id("distance")).sendKeys(getDistance(1).getTextContent());
		driver.findElement(By.id("submit")).click();

		return driver.findElement(By.id("result")).getText();

	}

	public static void main(String[] args) {
		DiscountCalculator pagLocator = new DiscountCalculator();
		// Add required code here

		pagLocator.createDriver();
		pagLocator.ReadFile(System.getProperty("user.dir") + "//DiscountCalculator.xml", "1");
		System.out.println(pagLocator.getMessage());
	}
}