package com.bnpp.steps;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;
import com.bnpp.library.CommonActions;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class UC28_29_30_Sparplan {

	CommonActions commonActions;
	String CapturedNameSparplan1 = "";
	String CapturedSparrateSparplan1 = "";
	String CapturedSparrate= "";
	String CapturedMessage="";
	String CapturedLoeschungSparplan="";
	String SparrateFromJson="";
	String NameFromJSON="";
	String capturedWKN1="";
	String WKNfromJSON="";


	public UC28_29_30_Sparplan(CommonActions commonActions) {
		this.commonActions = commonActions;
	}

	@When("Capture entered details on SparplanAnlegen")
	public void capture_entered_details_on_SparplanAnlegen() throws FileNotFoundException, IOException, ParseException {

		CapturedNameSparplan1    = commonActions.getText("CapturedNameSparplan");
		CapturedSparrateSparplan1 = commonActions.getText("CapturedSparrateSparplan");
		capturedWKN1  =  commonActions.getText("capturedWKN");
		System.out.println("Captured-NameSparplan: " + CapturedNameSparplan1);
		System.out.println("Captured-SparrateSparplan: " + CapturedSparrateSparplan1);
		System.out.println("Captured-WKNSparplan: " + capturedWKN1);
		
		NameFromJSON=commonActions.getValueFromJson("Name");
		SparrateFromJson=commonActions.getValueFromJson("Sparrate");
		WKNfromJSON=commonActions.getValueFromJson("WKN/Name/ISIN");
	
	
		try {
			if(CapturedNameSparplan1.contains(NameFromJSON)) {
				System.out.println(" Name Captured for SparplanAnlegen-Successfully");

			} 
			else
				System.out.println("Name Captured for SparplanAnlegen failed");

			if (CapturedSparrateSparplan1.contains(SparrateFromJson)) {
				System.out.println("Sparrate Captured for SparplanAnlegen-successfully");

			}
			else
				System.out.println("Sparrate Captured for SparplanAnlegen failed");
			
			if(capturedWKN1.contains(WKNfromJSON)) {
				System.out.println(" WKN Captured for SparplanAnlegen-Successfully");

			} 
			else
				System.out.println("WKN Captured for SparplanAnlegen failed");

		} catch (Exception e) {
			e.printStackTrace();
			commonActions.logAssert_Fail("capturing Data for SparplanAnlegen failed");
		}
	}

	@When("Capture Message on SparplanAnlegen")
	public void capture_Message_on_SparplanAnlegen() {
		try {

			CapturedMessage = commonActions.getText("CapturedMessageSparplanAnlegen");
			System.out.println("Capture Message on SparplanAnlegen:" + CapturedMessage);

		} catch (Exception e) {
			e.printStackTrace();
			commonActions.logAssert_Fail("capturing Message for SparplanAnlegen failed");
		}
	}

	@Then("Verify {string},{string},{string} on  UebersichtSparplaene")
	public void verify_on_UebersichtSparplaene(String string, String string2, String string3) throws FileNotFoundException, IOException, ParseException {
		try {
			SparrateFromJson=commonActions.getKeyFromJson("Sparrate");
			
			String VerifyNAMESparplanAnlegen=commonActions.getText("VerifyNAMESparplanAnlegen");
			String VerifyWKNSparplanAnlegen=commonActions.getText("VerifyWKNSparplanAnlegen");
			String VerifySPARRATESparplanAnlegen=commonActions.getText("VerifySPARRATESparplanAnlegen");
			
			System.out.println("VerifyNAMESparplanAnlegen :" + VerifyNAMESparplanAnlegen);
			System.out.println("VerifyWKNSparplanAnlegen :" + VerifyWKNSparplanAnlegen);
			System.out.println("VerifySPARRATESparplanAnlegen :" + VerifySPARRATESparplanAnlegen);

			if (VerifyNAMESparplanAnlegen.contains(NameFromJSON)) {
				System.out.println("Verify Name for SparplanAnlegen Successful");
				commonActions.logPassStatus("Pass | Valid message dispayed - " + VerifyNAMESparplanAnlegen);
			} else {
				System.out.println("Verify Name for SparplanAnlegen failed");
				commonActions.logFailStatus("Fail | Valid message display failed - " + VerifyNAMESparplanAnlegen);
			     }
			if (VerifyWKNSparplanAnlegen.contains(WKNfromJSON)) {
				System.out.println("Verify WKN for SparplanAnlegen Successful");
				commonActions.logPassStatus("Pass | Valid message dispayed - " + VerifyWKNSparplanAnlegen);

			} else {
				System.out.println("Verify WKN for SparplanAnlegen failed");
			    commonActions.logFailStatus("Fail | Valid message display failed - " + VerifyWKNSparplanAnlegen);
			     }
			if (VerifySPARRATESparplanAnlegen.contains(SparrateFromJson)) {
				System.out.println("Verify Sparrate for SparplanAnlegen Successful");
				commonActions.logPassStatus("Pass | Valid message dispayed - " + VerifySPARRATESparplanAnlegen);

			}else {
				commonActions.logFailStatus("Fail | Valid message display failed - " + VerifySPARRATESparplanAnlegen);
			     }
			
		} catch (Exception e) {
			e.printStackTrace();
			commonActions.logAssert_Fail("Fail | Data save fail for UebersichtSparplaene");
		}

	}

	@Then("Verify captured details,Message from SparplanAnlegen")
	public void verify_captured_details_Message_from_SparplanAnlegen() {

		try {
			if (CapturedMessage.equalsIgnoreCase(commonActions.getValueFromJson("Message"))) {
				System.out.println("Verify Message for SparplanAnlegen sucess");
				commonActions.logPassStatus("Pass | Valid message dispayed - " + CapturedMessage);

			} 
			else
				commonActions.logFailStatus("Fail | Valid message display failed - " + CapturedMessage);
		} catch (Exception e) {
			e.printStackTrace();
			commonActions.logAssert_Fail("Fail | Data save fail for Captured Message SparplanAnlegen");
		}

	}

	@When("user selects {string} of {string} in {string}")
	public void user_selects_of_in(String string1, String string2, String string3) throws FileNotFoundException, IOException, ParseException {

		String json1 = commonActions.getKeyFromJson(string1);
		System.out.println("jsonValue: "+json1);

		if(string1.equals("Aktionen")) {
			try {
				commonActions.click(string3);
				Thread.sleep(500);

				if(json1.equals("Aenderung/Pause")) {
					commonActions.click("pause");
				}
				else if(json1.equals("Einmalzahlung"))
					commonActions.click("Einmalzahlung");

				else if(json1.equals("Auftragsuebersicht"))
					commonActions.click("Auftragsuebersicht");
				else if(json1.equals("Wertpapierwechsel"))
					commonActions.click("Wertpapierwechsel");

				else
					System.out.println("clicked on dropdown icon FAILED");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	@Then("Verify details,message on SparplanAendern")
	public void verify_details_message_on_SparplanAendern() {
		try {

			String CapturedMessageSparplanAendern=commonActions.getText("CapturedMessageSparplanAendern");
			System.out.println("text Verify for SparplanAendern:" + CapturedMessageSparplanAendern);
			System.out.println(commonActions.getValueFromJson("Message"));
			if (CapturedMessageSparplanAendern.equalsIgnoreCase(commonActions.getValueFromJson("Message"))) {
				System.out.println("Verify Message for SparplanAendern");
				commonActions.logPassStatus("Pass | Valid message dispayed - " + CapturedMessageSparplanAendern);

			} else
				commonActions.logFailStatus("Fail | Valid message display failed - " + CapturedMessageSparplanAendern);
		} catch (Exception e) {
			e.printStackTrace();
			commonActions.logAssert_Fail("Fail | Data save fail for SparplanAendern");
		}
	}


	@When("Capture Message on LoeschungSparplan")
	public void capture_Message_on_LoeschungSparplan() {
		try {

			CapturedLoeschungSparplan = commonActions.getText("CapturedLoeschungSparplan");
			System.out.println("text Verify for LoeschungSparplan:" + CapturedLoeschungSparplan);
		} catch (Exception e) {
			e.printStackTrace();
			commonActions.logAssert_Fail("Fail | Data save fail for LoeschungSparplan");
		}


	}


	@Then("Verify captured Message from LoeschungSparplan")
	public void verify_captured_Message_from_LoeschungSparplan() {

		try {
			System.out.println("text Verify for LoeschungSparplan:" + CapturedLoeschungSparplan);

			System.out.println(commonActions.getValueFromJson("Message"));
			if (CapturedLoeschungSparplan.equalsIgnoreCase(commonActions.getValueFromJson("Message"))) {
				System.out.println("Verify Message for LoeschungSparplan");
				commonActions.logPassStatus("Pass | Valid message dispayed - " + CapturedLoeschungSparplan);

			} else
				commonActions.logFailStatus("Fail | Valid message display failed - " + CapturedLoeschungSparplan);
		} catch (Exception e) {
			e.printStackTrace();
			commonActions.logAssert_Fail("Fail | Data save fail for LoeschungSparplan");
		}

	}

	@Then("Verify Created Sparplan is not displayed")
	public void verify_Created_Sparplan_is_not_displayed() {
		if (!commonActions.isElementPresent("VerifyDeltedSparplan")) {
			System.out.println("Created_Sparplan is deleted");
			commonActions.logPassStatus("Pass | Created Sparplan is not displayed ");
		}
		else
			commonActions.logFailStatus("Fail | Valid message display failed ");


	}
	
	@Then("Verify message,details on WertpapierwechselFuerSparplan")
	public void verify_message_details_on_WertpapierwechselFuerSparplan() {
		
		try {
			String WertpapierwechselFuerSparplanMessage=commonActions.getText("WertpapierwechselFuerSparplanMessage");
			System.out.println("text Verify for WertpapierwechselFuerSparplanMessage:" + WertpapierwechselFuerSparplanMessage);

			System.out.println(commonActions.getValueFromJson("Message"));
			if (WertpapierwechselFuerSparplanMessage.equalsIgnoreCase(commonActions.getValueFromJson("Message"))) {
				System.out.println("Verify Message for WertpapierwechselFuerSparplanMessage");
				commonActions.logPassStatus("Pass | Valid message dispayed - " + WertpapierwechselFuerSparplanMessage);

			} else
				commonActions.logFailStatus("Fail | Valid message display failed - " + WertpapierwechselFuerSparplanMessage);
		} catch (Exception e) {
			e.printStackTrace();
			commonActions.logAssert_Fail("Fail | Data save fail for WertpapierwechselFuerSparplanMessage");
		}
	    
	}
	
	@Then("Verify message,details on EinmalzahlungFuerSparplan")
	public void verify_message_details_on_EinmalzahlungFuerSparplan() {
		try {

			String CapturedMessageEinmalzahlungFuerSparplan=commonActions.getText("CapturedMessageEinmalzahlungFuerSparplan");
			System.out.println("text Verify for EinmalzahlungFuerSparplan:" + CapturedMessageEinmalzahlungFuerSparplan);
			System.out.println(commonActions.getValueFromJson("Message"));
			if (CapturedMessageEinmalzahlungFuerSparplan.equalsIgnoreCase(commonActions.getValueFromJson("Message"))) {
				System.out.println("Verify Message for EinmalzahlungFuerSparplan");
				commonActions.logPassStatus("Pass | Valid message dispayed - " + CapturedMessageEinmalzahlungFuerSparplan);

			} else
				commonActions.logFailStatus("Fail | Valid message display failed - " + CapturedMessageEinmalzahlungFuerSparplan);
		} catch (Exception e) {
			e.printStackTrace();
			commonActions.logAssert_Fail("Fail | Data save fail for EinmalzahlungFuerSparplan");
		}
	}

	@Then("Verify message on LoeschungDerEinmalzahlung")
	public void verify_message_on_LoeschungDerEinmalzahlung() {
		try {

			String CapturedMessageLoeschungDerEinmalzahlung=commonActions.getText("CapturedMessageLoeschungDerEinmalzahlung");
			System.out.println("text Verify for LoeschungDerEinmalzahlung:" + CapturedMessageLoeschungDerEinmalzahlung);
			System.out.println(commonActions.getValueFromJson("Message"));
			if (CapturedMessageLoeschungDerEinmalzahlung.equalsIgnoreCase(commonActions.getValueFromJson("Message"))) {
				System.out.println("Verify Message for LoeschungDerEinmalzahlung");
				commonActions.logPassStatus("Pass | Valid message dispayed - " + CapturedMessageLoeschungDerEinmalzahlung);

			} else
				commonActions.logFailStatus("Fail | Valid message display failed - " + CapturedMessageLoeschungDerEinmalzahlung);
		} catch (Exception e) {
			e.printStackTrace();
			commonActions.logAssert_Fail("Fail | Data save fail for LoeschungDerEinmalzahlung");
		}
	}

}
