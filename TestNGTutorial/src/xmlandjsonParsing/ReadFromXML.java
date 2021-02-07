package xmlandjsonParsing;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class ReadFromXML {

	public static void main(String[] args) throws Exception {

		File file = new File(System.getProperty("user.dir") + "//xmlParsing.xml");

		DocumentBuilderFactory df = DocumentBuilderFactory.newInstance();
		DocumentBuilder db = df.newDocumentBuilder();
		Document doc = db.parse(file);
		doc.getDocumentElement().normalize();

		// Access Parent Node Name
		String node = doc.getDocumentElement().getNodeName();

		// Get all values for a particular Node
		NodeList nodes = doc.getElementsByTagName("Company");

		for (int i = 0; i < nodes.getLength(); i++) {
			Node eachnode = nodes.item(i);

			System.out.println("Node Name :" + eachnode.getNodeName());

			if (eachnode.getNodeType() == Node.ELEMENT_NODE) {
				Element element = (Element) eachnode;

				System.out.println("company id :" + element.getElementsByTagName("id").item(0).getTextContent());
				System.out
						.println("company name :" + element.getElementsByTagName("firstname").item(0).getTextContent());
				System.out.println(
						"company symbol :" + element.getElementsByTagName("lastname").item(0).getTextContent());
				System.out.println(
						"company Share price :" + element.getElementsByTagName("StockPrice").item(0).getTextContent());
			}

		}

	}

}
