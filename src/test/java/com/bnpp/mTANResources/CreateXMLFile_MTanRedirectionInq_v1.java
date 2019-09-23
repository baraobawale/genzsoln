package com.bnpp.mTANResources;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.testng.annotations.Test;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
 
public class CreateXMLFile_MTanRedirectionInq_v1  {
 
    public String xmlFilePath = System.getProperty("user.dir") + "\\src\\test\\java\\com\\bnpp\\mTANResources\\MTanRedirectionInq_v1.xml";
 
    @Test
    public void MtanRedirection_XmlBuilder(String feId, String sessionId, String crmCustId) {
 
        try {
 
            DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
 
            DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
 
            Document document = documentBuilder.newDocument();
 
            // root element
            Element root = document.createElement("Envelope");
            document.appendChild(root);
 
            // set an attribute to staff element
            Attr attr = document.createAttribute("xmlns");
            attr.setValue("http://schemas.xmlsoap.org/soap/envelope/");
            root.setAttributeNode(attr);

            Element Body = document.createElement("Body");
 
            root.appendChild(Body);

           
            Element run = document.createElement("run");
            Body.appendChild(run);
            
            Attr attr2 = document.createAttribute("xmlns");
            attr2.setValue("http://www.consorsbank.de/middleware/mtan/redirection/inq/v1_0");
            run.setAttributeNode(attr2);
 
            // request element
            Element request = document.createElement("request");
            run.appendChild(request);
            
            Attr attr5 = document.createAttribute("language");
            attr5.setValue("DE");
            request.setAttributeNode(attr5);
            
            Attr attr4 = document.createAttribute("feid");
            attr4.setValue(feId);
            request.setAttributeNode(attr4);
            
            Attr attr3 = document.createAttribute("sessionId");
            attr3.setValue(sessionId);
            request.setAttributeNode(attr3);
            
            // userid element
            Element userid = document.createElement("userId");
            userid.appendChild(document.createTextNode(crmCustId));
            request.appendChild(userid);
   
            // create the xml file
            //transform the DOM Object to an XML File
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource domSource = new DOMSource(document);
            StreamResult streamResult = new StreamResult(new File(xmlFilePath));
 
            transformer.transform(domSource, streamResult);
 
           // System.out.println("Done creating XML File for MTanRedirectionInq");
 
        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (TransformerException tfe) {
            tfe.printStackTrace();
        }
    }
}