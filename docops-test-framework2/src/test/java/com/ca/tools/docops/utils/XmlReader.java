/**
 * This script  lists the methods required to  read the XML files
 */

package com.ca.tools.docops.utils;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XmlReader {

	private static File configurationXmlFile;
	private static DocumentBuilderFactory configXmlFactory;
	private static DocumentBuilder configXmlBuilder;
	private static Document configDoc;
	private static NodeList configNodeList;
	private static Node configNode;
	private static Element configElement;

	
	private XmlReader(){
		
	}
	
	private static String xmlTagReader(String tagName, String elementTag) {
		try {
			configurationXmlFile = new File("target/test-classes/objectRepository/locators.xml");
			configXmlFactory = DocumentBuilderFactory.newInstance();
			configXmlBuilder = configXmlFactory.newDocumentBuilder();
			configDoc = configXmlBuilder.parse(configurationXmlFile);
			configDoc.getDocumentElement().normalize();
			configNodeList = configDoc.getElementsByTagName(tagName);
			configNode = configNodeList.item(0);
			configElement = (Element) configNode;
			return configElement.getElementsByTagName(elementTag).item(0).getTextContent();
		}
		catch(Exception e) {
			return "";
			
		}
	}
	
	public static String readXmlTag(String tagName, String elementName) {
		return xmlTagReader(tagName, elementName);
	}
	
}
