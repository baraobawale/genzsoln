package com.bnpp.mTANResources;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import javax.xml.parsers.ParserConfigurationException;

import org.openqa.selenium.By;
import org.xml.sax.SAXException;



public class mTanSmsText  {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException, InterruptedException {
		String outText = test(args[0], args[1], args[2]);
		System.out.println(outText);
	}
	
	public static String test(String customerId, String customerPin, String baseURL ) throws ParserConfigurationException, SAXException, IOException, InterruptedException {
		
		//Loading property files and its values		
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\java\\com\\bnpp\\mTANResources\\data.properties");
		prop.load(fis);

		String cafeUser  = prop.getProperty("cafeUserID");
		String cafePin  = prop.getProperty("cafePin");
		
		MobileTan mt = new MobileTan();
		
		// retrieve the tan
		Thread.sleep(3000);
		String mTAN = mt.getMTan(customerId, customerPin, cafeUser, cafePin);
		System.out.println("mTAN is  -" + mTAN);
		
		return mTAN;
	}
			
}
