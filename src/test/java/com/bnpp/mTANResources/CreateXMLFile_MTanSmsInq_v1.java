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
 
public class CreateXMLFile_MTanSmsInq_v1 {
 
    public String xmlFilePath = System.getProperty("user.dir") + "\\src\\test\\java\\com\\bnpp\\mTANResources\\MTanSmsInq_v1.xml";
 
    @Test
    public void MTanSmsInqXMLBuilder(String sessionId, String crmCustomerNo, String dateTime) {
 
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
            attr2.setValue("http://cortalconsors.com/middleware/mtan/sms/inq/v1_0");
            run.setAttributeNode(attr2);
 
            // request element
            Element request = document.createElement("request");
            run.appendChild(request);
                    
            Attr attr3 = document.createAttribute("sessionId");
            attr3.setValue(sessionId);
            request.setAttributeNode(attr3);
            
            Attr attr4 = document.createAttribute("feid");
            attr4.setValue("CAFE");
            request.setAttributeNode(attr4);
            
            Attr attr5 = document.createAttribute("language");
            attr5.setValue("DE");
            request.setAttributeNode(attr5);
 
          
            Element userid = document.createElement("customerNo");
            userid.appendChild(document.createTextNode("CID_DE:"+crmCustomerNo));
            request.appendChild(userid);
 
            // pin element
            Element pin = document.createElement("startDate");
            pin.appendChild(document.createTextNode(dateTime));
            request.appendChild(pin);
           
            // create the xml file
            //transform the DOM Object to an XML File
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource domSource = new DOMSource(document);
            StreamResult streamResult = new StreamResult(new File(xmlFilePath));
  
            transformer.transform(domSource, streamResult);
 
 
        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (TransformerException tfe) {
            tfe.printStackTrace();
        }
    }
}