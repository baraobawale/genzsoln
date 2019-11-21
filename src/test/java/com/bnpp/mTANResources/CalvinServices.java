package com.bnpp.mTANResources;

import static org.testng.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Properties;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.InputStreamEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.testng.annotations.Test;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class CalvinServices {

	@Test
	public  String requestLoginV2(String expectedNode) throws ClientProtocolException, IOException, ParserConfigurationException, SAXException {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\java\\com\\bnpp\\mTANResources\\data.properties");
		prop.load(fis);
			
		String sBaseURL = prop.getProperty("baseURL_Calvin");
		
		String endpoint = sBaseURL + "/ws/Login_v2";
		//System.out.println("checking value!!!!!");
		File requestFile = new File(System.getProperty("user.dir")+"\\src\\test\\java\\com\\bnpp\\mTANResources\\Login_v2.xml");
				
		HttpClient client = HttpClientBuilder.create().build();
		HttpPost post = new HttpPost(endpoint);
		post.setEntity(new InputStreamEntity(new FileInputStream(requestFile)));
		post.setHeader("Content-Type", "text/xml");
		HttpResponse response = client.execute(post);
		
		//System.out.println(response.getStatusLine().getStatusCode());
		assertEquals(response.getStatusLine().getStatusCode(), 200); 
		
		BufferedReader br = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
		String line ="";
		StringBuffer sb = new StringBuffer();
		while((line=br.readLine())!=null)
		{
			sb.append(line);
		}
		
		String xmlLocation = System.getProperty("user.dir")+"\\src\\test\\java\\com\\bnpp\\mTANResources\\loginResponse.xml";		
		
		PrintWriter pw = new PrintWriter(xmlLocation);
		pw.write(sb.toString());
		pw.close();
		pw.flush();
		
		xmlParser xml = new xmlParser();
		String sReturnVal = xml.xmlParse(expectedNode, xmlLocation);
		
		/*
		String nodeValue = "";
		if (response.getStatusLine().getStatusCode()==200)
		{
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
	        DocumentBuilder db = dbf.newDocumentBuilder();
	        Document document = db.parse(new File(xmlLocation));
	        NodeList nodeList;
	        System.out.println("expectedNode.contentEquals(\"userid\")" +expectedNode.contentEquals("userid"));
	        if (expectedNode.contentEquals("userid"))
	        {
	        	nodeList = document.getElementsByTagName("response");
	        	
	        }
	        else
	        {
	        	nodeList = document.getElementsByTagName("response");
	        }
	        
	        for(int x=0,size= nodeList.getLength(); x<size; x++) {
	        	nodeValue = nodeList.item(x).getAttributes().getNamedItem(expectedNode).getNodeValue();
	        }
		}
		*/
		return sReturnVal;	        
	}
	
	@Test
	public  String requestLoginV2_getCRM_ID() throws ClientProtocolException, IOException, ParserConfigurationException, SAXException {
		
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\java\\com\\bnpp\\mTANResources\\data.properties");
		prop.load(fis);
			
		String sBaseURL = prop.getProperty("baseURL_Calvin");
		
		String endpoint = sBaseURL + "/ws/Login_v2";
		File requestFile = new File(System.getProperty("user.dir")+"\\src\\test\\java\\com\\bnpp\\mTANResources\\Login_v2.xml");
		
		HttpClient client = HttpClientBuilder.create().build();
		HttpPost post = new HttpPost(endpoint);
		post.setEntity(new InputStreamEntity(new FileInputStream(requestFile)));
		post.setHeader("Content-Type", "text/xml");
		HttpResponse response = client.execute(post);
		
		//System.out.println(response.getStatusLine().getStatusCode());
		assertEquals(response.getStatusLine().getStatusCode(), 200); 
		
		BufferedReader br = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
		String line ="";
		StringBuffer sb = new StringBuffer();
		while((line=br.readLine())!=null)
		{
			sb.append(line);
		}
		
		String xmlLocation = System.getProperty("user.dir")+"\\src\\test\\java\\com\\bnpp\\mTANResources\\loginResponse.xml";
		PrintWriter pw = new PrintWriter(xmlLocation);
		pw.write(sb.toString());
		pw.close();
		pw.flush();
			
		String crmCustID = "";
		if (response.getStatusLine().getStatusCode()==200)
		{
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
	        DocumentBuilder db = dbf.newDocumentBuilder();
	        Document document = db.parse(new File(xmlLocation));
	        NodeList nodeList = document.getElementsByTagName("crmCustomerno");
	     
	        crmCustID = nodeList.item(0).getTextContent();
		}
		return crmCustID;	        
	}

	
	@Test
	public  String requestMTanSmsInq() throws ClientProtocolException, IOException, ParserConfigurationException, SAXException {
		
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\java\\com\\bnpp\\mTANResources\\data.properties");
		prop.load(fis);
			
		String sBaseURL = prop.getProperty("baseURL_Calvin");
		
		String endpoint = sBaseURL + "/ws/MTanSmsInq_v1";
		File requestFile = new File(System.getProperty("user.dir")+"\\src\\test\\java\\com\\bnpp\\mTANResources\\MTanSmsInq_v1.xml");
		
		HttpClient client = HttpClientBuilder.create().build();
		HttpPost post = new HttpPost(endpoint);
		post.setEntity(new InputStreamEntity(new FileInputStream(requestFile)));
		post.setHeader("Content-Type", "text/xml");
		HttpResponse response = client.execute(post);
		
		//System.out.println(response.getStatusLine().getStatusCode());
		assertEquals(response.getStatusLine().getStatusCode(), 200); 
		
		BufferedReader br = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
		String line ="";
		StringBuffer sb = new StringBuffer();
		while((line=br.readLine())!=null)
		{
			sb.append(line);
		}
		
		String xmlLocation = System.getProperty("user.dir")+"\\src\\test\\java\\com\\bnpp\\mTANResources\\MTanSmsInq_v1_Response.xml";
		PrintWriter pw = new PrintWriter(xmlLocation);
		pw.write(sb.toString());
		pw.close();
		pw.flush();
	
		String mTanContent = "";
		if (response.getStatusLine().getStatusCode()==200)
		{
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
	        DocumentBuilder db = dbf.newDocumentBuilder();
	        Document document = db.parse(new File(xmlLocation));
	        NodeList nodeList = document.getElementsByTagName("ns4:mTan");
	        System.out.println(nodeList);
	     
	        mTanContent = nodeList.item(0).getTextContent();
		}
		return mTanContent;	        
	}
	
	@Test
	public  String requestMTanRedirectionInq_v1() throws ClientProtocolException, IOException, ParserConfigurationException, SAXException {
		
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\java\\com\\bnpp\\mTANResources\\data.properties");
		prop.load(fis);
			
		String sBaseURL = prop.getProperty("baseURL_Calvin");
		System.out.println("sBaseURL" + sBaseURL);
		String endpoint = sBaseURL + "/ws/MTanRedirectionInq_v1";
		System.out.println("endpoint" + endpoint);
		File requestFile = new File(System.getProperty("user.dir")+"\\src\\test\\java\\com\\bnpp\\mTANResources\\MTanRedirectionInq_v1.xml");
		
		HttpClient client = HttpClientBuilder.create().build();
		HttpPost post = new HttpPost(endpoint);
		post.setEntity(new InputStreamEntity(new FileInputStream(requestFile)));
		post.setHeader("Content-Type", "text/xml");
		HttpResponse response = client.execute(post);
		
		System.out.println(response.getStatusLine().getStatusCode());
		//assertEquals(response.getStatusLine().getStatusCode(), 200); 
		
		BufferedReader br = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
		String line ="";
		StringBuffer sb = new StringBuffer();
		while((line=br.readLine())!=null)
		{
			sb.append(line);
		}
		
		String xmlLocation = System.getProperty("user.dir")+"\\src\\test\\java\\com\\bnpp\\mTANResources\\MTanRedirectionInq_Response.xml";
		PrintWriter pw = new PrintWriter(xmlLocation);
		pw.write(sb.toString());
		pw.close();
		pw.flush();
	
		String mTanStatus = "";
		if (response.getStatusLine().getStatusCode()==200)
		{
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
	        DocumentBuilder db = dbf.newDocumentBuilder();
	        Document document = db.parse(new File(xmlLocation));
	        NodeList nodeList = document.getElementsByTagName("active");
	     
	        mTanStatus = nodeList.item(0).getTextContent();
		}
		return mTanStatus;	        
	}
	
	@Test
	public  int requestMTanRedirectionAdd_v1() throws ClientProtocolException, IOException, ParserConfigurationException, SAXException {
		
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\java\\com\\bnpp\\mTANResources\\data.properties");
		prop.load(fis);
			
		String sBaseURL = prop.getProperty("baseURL_Calvin");
		
		String endpoint = sBaseURL + "/ws/MTanRedirectionAdd_v1";
		File requestFile = new File(System.getProperty("user.dir")+"\\src\\test\\java\\com\\bnpp\\mTANResources\\MTanRedirectionAdd_v1.xml");
		
		HttpClient client = HttpClientBuilder.create().build();
		HttpPost post = new HttpPost(endpoint);
		post.setEntity(new InputStreamEntity(new FileInputStream(requestFile)));
		post.setHeader("Content-Type", "text/xml");
		HttpResponse response = client.execute(post);
		
		//System.out.println(response.getStatusLine().getStatusCode());
		assertEquals(response.getStatusLine().getStatusCode(), 200); 
		
		BufferedReader br = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
		String line ="";
		StringBuffer sb = new StringBuffer();
		while((line=br.readLine())!=null)
		{
			sb.append(line);
		}
		
		String xmlLocation = System.getProperty("user.dir")+"\\src\\test\\java\\com\\bnpp\\mTANResources\\MTanRedirectionAdd_v1.xml";
		PrintWriter pw = new PrintWriter(xmlLocation);
		pw.write(sb.toString());
		pw.close();
		pw.flush();
	
		int mTanStatus = 0;
		if (response.getStatusLine().getStatusCode()==200)
		{
			mTanStatus = response.getStatusLine().getStatusCode();
		}
		return mTanStatus;	        
	}
	
}
