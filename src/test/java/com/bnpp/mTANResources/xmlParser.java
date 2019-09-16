package com.bnpp.mTANResources;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
//Currently this works only for Login_v2 (for attributes of response tag and UserId)
public class xmlParser {

	public String xmlParse(String expectedNode, String xmlLocation) throws ParserConfigurationException, SAXException, IOException {
		
			String nodeValue = "";
	
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
	        DocumentBuilder db = dbf.newDocumentBuilder();
	        Document document = db.parse(new File(xmlLocation));
	        NodeList nodeList;
	       
	        if (expectedNode.contentEquals("userid"))
	        {
	        	nodeList = document.getElementsByTagName("logins");
	        	
	           	Node nNode = nodeList.item(0);
	       	        	
	        	if (nNode.getNodeType()==Node.ELEMENT_NODE) {
	        		Element eElement= (Element) nNode;
	        		nodeValue = eElement.getElementsByTagName("ns9:userid").item(0).getTextContent();
	        	}	        	
	        }
	        else
	        { //for returning session id from response
	        	nodeList = document.getElementsByTagName("response");
	        	for(int x=0,size= nodeList.getLength(); x<size; x++) {
		        	nodeValue = nodeList.item(x).getAttributes().getNamedItem(expectedNode).getNodeValue();
		        }
	        }
	        
		return nodeValue;		
	}	
}
