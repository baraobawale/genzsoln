package com.bnpp.runner;

import java.io.FileInputStream;
import java.util.Properties;

import com.bnpp.mTANResources.MobileTan;

public class Test {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		Properties prop = new Properties();
		// FileInputStream fis = new
		// FileInputStream("C:\\workspace\\mobileTANTest\\src\\main\\java\\mTANResources\\data.properties");
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\java\\com\\bnpp\\mTANResources\\data.properties");
		prop.load(fis);
		String customerId = prop.getProperty("userID");
		String customerPin = prop.getProperty("pin");
		String cafeUser = prop.getProperty("cafeUserID");
		String cafePin = prop.getProperty("cafePin");
		
		// Redirecting Mobile TAN
		MobileTan mt = new MobileTan();
		mt.mTanRedirection(customerId, customerPin, cafeUser, cafePin);

		// String MobileTAN_link_Login = "//a[@id='mobile-tan-request']";
		//commonActions.click("MobileTAN_link_Login");

		String mTAN = mt.getMTan(customerId, customerPin, cafeUser, cafePin);
		System.out.println("mTAN is  -" + mTAN);
		Thread.sleep(3000);
		//commonActions.enterTokenTan(TanKey, mTAN);
	}

}
