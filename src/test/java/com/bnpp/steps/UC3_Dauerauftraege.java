package com.bnpp.steps;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import javax.xml.parsers.ParserConfigurationException;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebElement;
import org.xml.sax.SAXException;

import com.bnpp.library.CommonActions;
import com.bnpp.mTANResources.MobileTan;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class UC3_Dauerauftraege {
	
	CommonActions commonActions;

	public UC3_Dauerauftraege(CommonActions commonActions) {
		this.commonActions = commonActions;
	}
	
	String CaptureErrorMsg = "";
	String CapturedName = "";
	String CapturedIBAN = "";
	String CapturedBetrag = "";
	String CapturedDatum = "";
	
	@When("User submits generated Mobile TAN number in {string}")
public void user_submits_generated_Mobile_TAN_number_in(String locatorKey) throws InterruptedException, ParserConfigurationException, SAXException, IOException {

	Properties prop = new Properties();
	FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\java\\com\\bnpp\\mTANResources\\data.properties");
	prop.load(fis);
	String customerId = prop.getProperty("userID");
	String customerPin = prop.getProperty("pin");
	String cafeUser  = prop.getProperty("cafeUserID");
	String cafePin  = prop.getProperty("cafePin");

	
	MobileTan mt = new MobileTan();
	mt.mTanRedirection(customerId, customerPin, cafeUser, cafePin);
	Thread.sleep(3000);
	commonActions.click(locatorKey);

	String mTAN = mt.getMTan(customerId, customerPin, cafeUser, cafePin);
	System.out.println("mTAN is  -" + mTAN);
	commonActions.enterTokenTan("TAN_field_Login", mTAN);
	//commonActions.click("BestaetigenButton");
}

	@And("^User selects \"(.*?)\" in \"(.*?)\" field$")
	public void select(String dataKey, String locatorKey) throws Exception {


		commonActions.selectDropDownByIndex(locatorKey, dataKey);

	}
	
	@And("^User clicks on \"(.*?)\" of \"(.*?)\" in \"(.*?)\"$")
	public void user_click_on_of_in(String locatorKey, String datakey,String CreatedDauerauftraege_UmsaetzeZahlungsverkehr) throws FileNotFoundException, IOException, ParseException, InterruptedException {

		if(CreatedDauerauftraege_UmsaetzeZahlungsverkehr.equals("Created_Dauerauftraege"))
			commonActions.waitForVisibilityofElement("locatorKey");
		commonActions.click(locatorKey);
	}

	
	@When("Capture entered details on DauerauftrageAnlegen")
	public void capture_entered_details_on_DauerauftrageAnlegen() {
		try {
			
						CapturedName = commonActions.getText("CapturedName");
						CapturedIBAN= commonActions.getText("CapturedIBAN");
						CapturedBetrag = commonActions.getText("CapturedBetrag");
						CapturedDatum = commonActions.getText("CapturedDatum");
			
						System.out.println("CapturedName:"+CapturedName);
						System.out.println("CapturedIBAN:"+CapturedIBAN);
						System.out.println("CapturedBetrag:"+CapturedBetrag);
						System.out.println("CapturedDatum:"+CapturedDatum);
			
			
					} catch (Exception e) {
						e.printStackTrace();
						commonActions.logAssert_Fail("Data match fail");
					}
	}

	@When("Capture Message on DauerauftrageAnlegen")
	public void capture_Message_on_DauerauftrageAnlegen() 
	{
		try {			
			Thread.sleep(5000);
			WebElement text = commonActions.getElement("DauerauftrageAnlegen");
			CaptureErrorMsg = text.getText();
			System.out.println("CaptureErrorMsg "+CaptureErrorMsg);
			commonActions.logPassStatus("Capture Message on DauerauftrageAnlegen");

		} catch (Exception e) {
			e.printStackTrace();
			commonActions.logAssert_Fail("Capture Message on DauerauftrageAnlegen fail");
		}    
	}
	

	@Then("Verify {string},{string} on UmsaetzeZahlungsverkehr")
	public void verify_on_UmsaetzeZahlungsverkehr(String Vorlagenname, String string2) {
		commonActions.moveScrollDown();
        try {
                      String txtVerify1 = commonActions.getAttribute("VerifyName", "innerHTML");
                      String txtVerify2 = commonActions.getAttribute("VerifyAusfuehrung_Am", "innerText");

                      System.out.println("Verify txtVerify1:"+txtVerify1);
                      System.out.println("Verify JSON NAME."+commonActions.getValueFromJson("Name"));

//                      System.out.println("Verify txtVerify2:"+txtVerify2);
//                      System.out.println("Verify JSON Datum."+commonActions.getValueFromJson("Datum"));

                      if (txtVerify1.equals(commonActions.getValueFromJson("Name"))) {
                                     commonActions.logPassStatus("Verify Name on DauerauftrageAnlegen");
                      }
                      else {
                                     commonActions.logFailStatus("Data save fail for DauerauftrageAnlegen");
                      }

        } catch (Exception e) {
                      e.printStackTrace();
                      commonActions.logAssert_Fail("Data match fail");
        }
	}

	@Then("Verify captured details,Message from DauerauftrageAnlegen")
	public void verify_captured_details_Message_from_DauerauftrageAnlegen() {
	try {
		
					if (CapturedName.equals(commonActions.getValueFromJson("Name"))) {
						commonActions.logPassStatus("Verified name on DauerauftrageAnlegen");
					}
					else {
						commonActions.logFailStatus("Data save fail for DauerauftrageAnlegen");
					}			
					if (CapturedIBAN.equals(commonActions.checkGermanCharacters(commonActions.getValueFromJson("IBAN_oder_Kontonummer")))) {
						commonActions.logPassStatus("Verified IBAN on DauerauftrageAnlegen");
					}
					else {
						commonActions.logFailStatus("Data save fail for DauerauftrageAnlegen");
					}
					if (CapturedBetrag.contains(commonActions.getValueFromJson("Betrag"))) {
						commonActions.logPassStatus("Verified Betrag on DauerauftrageAnlegen");
					}
					else {
						commonActions.logFailStatus("Data save fail for DauerauftrageAnlegen");
					}
					if (CapturedDatum.equals(commonActions.getValueFromJson("Datum"))) {
						commonActions.logPassStatus("Verified Datum on DauerauftrageAnlegen");
					}
					else {
						commonActions.logFailStatus("Data save fail for DauerauftrageAnlegen");
					}
		
		
					if (CaptureErrorMsg.equals(commonActions.getValueFromJson("Message"))) {
						commonActions.logPassStatus("Message verified");
					}
					else {
						commonActions.logFailStatus("Message not matched");
		
					}}
				catch (Exception e) {
					e.printStackTrace();
					commonActions.logAssert_Fail("text not found");
				}
	}


	@And("^User changes \"(.*?)\" in \"(.*?)\"$")
	public void type(String dataKey, String locatorKey)
			throws IllegalArgumentException, InterruptedException, IOException, ParseException {
		
			commonActions.enterText(locatorKey, dataKey);
	}

	@Then("Verify Message,details on DauerauftrageAndern")
	public void verify_Message_details_on_DauerauftrageAndern() {
		try {
			System.out.println("txtVerify for DauerauftrageAndern"+commonActions.getText("DauerauftrageAndern"));
			String txtVerify = commonActions.getText("DauerauftrageAndern");
			System.out.println(commonActions.getValueFromJson("Message"));
			if (txtVerify.equalsIgnoreCase(commonActions.getValueFromJson("Message"))) {
				System.out.println("Verify Message on DauerauftrageAndern edit successfully");
				commonActions.logPassStatus("Verify Message on DauerauftrageAndern");

			}
			else
				commonActions.logFailStatus("Verification of Message on DauerauftrageAndern edit is failed");

		} catch (Exception e) {
			e.printStackTrace();
			commonActions.logAssert_Fail("Data save fail for DauerauftrageAndern");
		}
	}
	
	@Then("Verify Message on Dauerauftraegeloeschen")
	public void verify_Message_on_Dauerauftraegeloeschen() {
		try {
			System.out.println("txtVerify for Dauerauftraegeloeschen:"+commonActions.getText("Dauerauftraegeloeschen"));
			String txtVerify = commonActions.getText("Dauerauftraegeloeschen");
			System.out.println(commonActions.getValueFromJson("Message"));
			if (txtVerify.equalsIgnoreCase(commonActions.getValueFromJson("Message"))) {
				System.out.println("Verify Message on Dauerauftraegeloeschen SUCCESSFULLY");
				commonActions.logPassStatus("Verify Message on Dauerauftraegeloeschen");

			}
			else
				commonActions.logFailStatus("Verify Message on Dauerauftraegeloeschen is failed");

		} catch (Exception e) {
			e.printStackTrace();
			commonActions.logAssert_Fail("Data save fail for Dauerauftraegeloeschen");
		}

	}
}
