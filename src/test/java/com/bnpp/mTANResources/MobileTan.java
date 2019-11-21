package com.bnpp.mTANResources;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Properties;
import javax.xml.parsers.ParserConfigurationException;

import org.apache.http.client.ClientProtocolException;
import org.testng.annotations.Test;
import org.xml.sax.SAXException;

public class MobileTan  {

	@Test
	public String getMTan(String customerId, String customerPin,String cafeUser,String cafePin) throws IOException, InterruptedException, ParserConfigurationException, SAXException
	{	
		// Loading the properties file
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\java\\com\\bnpp\\mTANResources\\data.properties");
		
		prop.load(fis);
		
		// Login to WEB and getting CRM Customer number
		CreateXMLFile_Loginv2 xmlLogin = new CreateXMLFile_Loginv2();
		xmlLogin.LoginXMLBuilder("WEB", customerId, customerPin);
		CalvinServices calServ = new CalvinServices();
		String crmUserId = getCrmUserID(customerId, customerPin);	
		String sessionId = loginCafe(cafeUser,cafePin);
		
		// Getting the present time for requesting the MTAN from database
		// Considering the delay between requesting MTan from website and fetching mtan from db, time is calculated as "present time -1" minute 
		ZoneId z = ZoneId.of("CET");
		LocalDateTime today = LocalDateTime.now(z).minusMinutes(1);
		DateTimeFormatter form1 = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss", Locale.ENGLISH);
		String dateTimestamp = form1.format(today);

        // Create XML request file and send request for retrieving SMS data
		CreateXMLFile_MTanSmsInq_v1 MTanSmsInq = new CreateXMLFile_MTanSmsInq_v1();		
		MTanSmsInq.MTanSmsInqXMLBuilder(sessionId,crmUserId, dateTimestamp);
		
		String mTan = calServ.requestMTanSmsInq();
		
		// Logout from Cafe after retrieving SMS content
		CreateXMLFile_LogoutV1 xmlLogout = new CreateXMLFile_LogoutV1();
		xmlLogout.LogoutXMLBuilder(sessionId,"CAFE");
		
		Request_LogoutV1 reqLogout = new Request_LogoutV1();
		reqLogout.requestLogoutV1();
				
		//System.out.println("MTan is - "+mTan);
		return mTan;	
	}
	
	
	public String mTanRedirection(String customerId, String customerPin, String cafeUser, String cafePin) throws ClientProtocolException, IOException, ParserConfigurationException, SAXException {
		
		String crmUserId = getCrmUserID(customerId, customerPin);
		String sessionId = loginCafe(cafeUser,cafePin);
		
		
		//If 'active = true' is yes, then check 'mTanStatus='U''
		// If it is yes, then report to activate MTan/SMS service in Cafe
		// If it is no, then call service MTanRedirectionAdd_v1 (SessionID - Cafe, FEID - Cafe), UserID - userid from WEB Login response
		
		// Create xml file required for the service
		CreateXMLFile_MTanRedirectionInq_v1 xmlRedirection = new CreateXMLFile_MTanRedirectionInq_v1();
		xmlRedirection.MtanRedirection_XmlBuilder("CAFE", sessionId, crmUserId);

		//Call MTanRedirectionInq and check the status of 'active = true' and 'mTanStatus'
		CalvinServices calServ = new CalvinServices();
		String mtanStatus = calServ.requestMTanRedirectionInq_v1();
		//System.out.println("MTan status - "+mtanStatus);
		//int status = 0;
		String sStatus = "";
		
		// If mTAN of the account is not yet redirected, then redirect it
		if (mtanStatus.contentEquals("false"))
		{
			// Create XML file for MTanRedirectionAdd
			CreateXMLFile_MTanRedirectionAdd_v1 redirectionAdd = new CreateXMLFile_MTanRedirectionAdd_v1();
			redirectionAdd.MtanRedirectionAdd_XmlBuilder("CAFE", sessionId, crmUserId);
			int status = calServ.requestMTanRedirectionAdd_v1();
			sStatus =  "MTan redirection added with HTTP status -" + Integer.toString(status);
			
			//System.out.println("MTan redirection Add status - " + status);
		}
		else sStatus = "MTan redirection already active for the user: "+customerId ;
		return sStatus;
		
	}

	public String getCrmUserID(String customerId, String customerPin) throws ClientProtocolException, IOException, ParserConfigurationException, SAXException {
				
			// Login to WEB and getting CRM Customer number
			CreateXMLFile_Loginv2 xmlLogin = new CreateXMLFile_Loginv2();
			xmlLogin.LoginXMLBuilder("WEB", customerId, customerPin);
			
			CalvinServices calServ = new CalvinServices();
			String crmUserId = calServ.requestLoginV2("userid");
				
			return crmUserId;
		}
	public String loginCafe(String cafeUser, String cafePin) throws ClientProtocolException, IOException, ParserConfigurationException, SAXException {
			// Login to CAFE and get Cafe SessionID
				CreateXMLFile_Loginv2 xmlLogin = new CreateXMLFile_Loginv2();
				xmlLogin.LoginXMLBuilder("CAFE", cafeUser, cafePin);
				CalvinServices calServ = new CalvinServices();
				String sessionId = calServ.requestLoginV2("sessionId");
				return sessionId;
	}
}
