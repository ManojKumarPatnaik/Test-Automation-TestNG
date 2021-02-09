package xmlandjsonParsing;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.Locator;

public class XMLExercise {

	private NodeList nodeList;
	private Document doc;
	private XPath xpath;
	private XPathExpression expr;
	private Object result;

	public XPath ReadFile(String xmlFileName, String id) {

		try {
			DocumentBuilderFactory df = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = df.newDocumentBuilder();
			doc = db.parse(System.getProperty("user.dir") + "//" + xmlFileName);

			XPathFactory xfactory = XPathFactory.newInstance();
			xpath = xfactory.newXPath();

			return xpath;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;

	}

	public String getFirstName(int id) {
		String firstname;
		try {

			expr = xpath.compile("//User[@id=" + id + "]/FirstName/text()");
			result = expr.evaluate(doc, XPathConstants.NODESET);

			nodeList = (NodeList) result;

			firstname = nodeList.item(0).getTextContent();

			return firstname;
		} catch (XPathExpressionException e) {
			e.printStackTrace();
		}
//		first = doc.getElementsByTagName("FirstName");
//		String firstname = first.item(0).getTextContent();
//		return firstname;
		return null;
	}

	public String getLastName(int id) {

		try {

			expr = xpath.compile("//User[@id=" + id + "]/LastName/text()");
			result = expr.evaluate(doc, XPathConstants.NODESET);

			nodeList = (NodeList) result;

			String lastname = nodeList.item(0).getTextContent();

			return lastname;
		} catch (XPathExpressionException e) {
			e.printStackTrace();
		}

		return null;
	}

	public String getuserName(int id) {
		try {

			expr = xpath.compile("//User[@id=" + id + "]/Username/text()");
			result = expr.evaluate(doc, XPathConstants.NODESET);

			nodeList = (NodeList) result;

			String username = nodeList.item(0).getTextContent();

			return username;
		} catch (XPathExpressionException e) {
			e.printStackTrace();
		}

		return null;
	}

	public String getPassword(int id) {
		try {

			expr = xpath.compile("//User[@id=" + id + "]/Password/text()");
			result = expr.evaluate(doc, XPathConstants.NODESET);

			nodeList = (NodeList) result;

			String password = nodeList.item(0).getTextContent();

			return password;
		} catch (XPathExpressionException e) {
			e.printStackTrace();
		}

		return null;
	}

	public String getLocator(String locatorname) {
		String xpathOfLocator = null;

		try {
			expr = xpath.compile("//element[@name='" + locatorname + "']/@*");
			NodeList result = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);
			for (int i = 0; i < result.getLength(); i++) {
				Attr attr = (Attr) result.item(i);
				return attr.getNodeValue();
//				if (attr.getNodeName().equals("name")) {
//					return (String) result.item(i+1).getTextContent();
//				}
			}

//			NodeList nl = (NodeList) xpath.evaluate("//Element1/@*", doc, XPathConstants.NODESET);
//			int length = nl.getLength();
//			for( int i=0; i<length; i++) {
//			    Attr attr = (Attr) nl.item(i);
//			    String name = attr.getName();
//			    String value = attr.getValue();
//			}

//			
//			expr = xpath.compile("//element[@name='"+locatorname+"']");
//			NodeList result = (NodeList) expr.evaluate(doc, XPathConstants.NODESET);
//			
//			//System.out.println(result.getLength());
//			return result.item(0).getTextContent();

//			expr = xpath.compile("//element[@name='"+locatorname+"']");
//			Object result = expr.evaluate(doc, XPathConstants.STRING);
//			
////			//System.out.println(result.getLength());
//			return result.toString();

		} catch (XPathExpressionException e) {
			System.out.println("check the locatorname input value");
			e.printStackTrace();
		}

		return "wrong";
	}

	public static void main(String[] args) {
		XMLExercise xml = new XMLExercise();
		xml.ReadFile("XMLExercise.xml", "1");
		System.out.println(xml.getFirstName(1));
		System.out.println(xml.getLastName(1));
		System.out.println(xml.getuserName(1));
		System.out.println(xml.getPassword(1));
		xml.ReadFile("XMLExercise.xml", "2");
		System.out.println(xml.getFirstName(2));
		System.out.println(xml.getLastName(2));
		System.out.println(xml.getuserName(2));
		System.out.println(xml.getPassword(2));
		//System.out.println(xml.getLocator("homepage-from"));
	}

}
