package com.bnpp.mTANResources;

import java.io.*;
import java.net.URL;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;



public class mTanRedirectionAdd extends base {

	public String test(String customerId, String customerPin, String baseURL ) throws ParserConfigurationException, SAXException, IOException, InterruptedException {
		
		//Loading property files and its values		
	//	Properties prop = new Properties();
		//FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\mTANResources\\data.properties");
		//FileInputStream fis = (FileInputStream) this.getClass().getResourceAsStream("data.properties");
		//prop.load(fis);
		//String customerId = prop.getProperty("userID");
		//String customerPin = prop.getProperty("pin");
		//String cafeUser  = prop.getProperty("cafeUserID");
		//String cafePin  = prop.getProperty("cafePin");
		String cafeUser  = "qtp01";
		String cafePin  = "Qtp_0001";
		
		URL url=getClass().getClassLoader().getResource("mTANResources/data.properties");
		//System.out.println("url - "+ url);
		
		//Redirecting Mobile TAN
		MobileTan mt = new MobileTan();
		String statusMsg = mt.mTanRedirection(customerId, customerPin, cafeUser, cafePin);
		return statusMsg;	
		// 
	
	}
	public void checkFile() throws IOException {
		File file = null;
	    String resource = "/mTANResources/data.properties";
	   // System.out.println("resource = "+resource);
	    URL res = getClass().getResource(resource);

	    if (res.getProtocol().equals("jar")) {
	        try {
	            InputStream input = getClass().getResourceAsStream(resource);
	            
	    	    //System.out.println("GETCLASS = "+getClass().getResourceAsStream(resource));

	            file = File.createTempFile("tempfile", ".tmp");
	            OutputStream out = new FileOutputStream(file);
	            int read;
	            byte[] bytes = new byte[1024];

	            while ((read = input.read(bytes)) != -1) {
	                out.write(bytes, 0, read);
	            }
	            out.close();
	            file.deleteOnExit();
	        } catch (IOException ex) {
	           ex.printStackTrace();        }
	    } else {
	        //this will probably work in your IDE, but not from a JAR
	        file = new File(res.getFile());
		 // System.out.println("file - " + file);
	    }

	    if (file != null && !file.exists()) {
	        throw new RuntimeException("Error: File " + file + " not found!");
	    }

	}
	
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, InterruptedException {
		mTanRedirectionAdd oTest = new mTanRedirectionAdd();
//		String outText = oTest.test(args[0], args[1], args[2]);
		oTest.checkFile();
//		System.out.println(outText);

	}
	
	

}
