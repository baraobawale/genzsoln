package com.bnpp.steps;

import com.bnpp.library.CommonActions;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class UC78_79_Aboservice {

	CommonActions commonActions;
	String CapturedMessagewurden = "";
	String CapturedMessageAbonnement = "";
	String CapturedMessagePreis = "";
	String CapturedMessageKuendigung = "";

	public UC78_79_Aboservice(CommonActions commonActions) {
		this.commonActions = commonActions;
	}

	@Then("Verify displayed {string}")
	public void verify_displayed(String ErrorMesssages) {
		commonActions.getElement("ErrorMesssages");
		try {
			if (commonActions.isElementPresent("ErrorMesssages")) {
			commonActions.logPassStatus("Pass | Valid message displayed -"+commonActions.getText("ErrorMesssages"));
			} else {
				commonActions.logFailStatus("Error | Valid message display failed -"+commonActions.getText("ErrorMesssages"));
			}
			
		}
		catch (Exception e) {
			e.printStackTrace();
			commonActions.logAssert_Fail("text not found");
		}
	   
	}
	
	@Then("Verify Message on NewsLetter")
	public void verify_Message_on_NewsLetter() {
		commonActions.getElement("Message_Setzen");
		try {
			if (commonActions.isElementPresent("Message_Setzen")) {
			commonActions.logPassStatus("Pass | Valid message displayed -"+commonActions.getText("Message_Setzen"));
			} else {
				commonActions.logFailStatus("Error | Valid message display failed -"+commonActions.getText("Message_Setzen"));
			}
			
		}
		catch (Exception e) {
			e.printStackTrace();
			commonActions.logAssert_Fail("text not found");
		}
	}
	


	@Then("Verify {string} in {string}")
	public void verify_in(String dataKey, String locatorKey) {
		commonActions.getElement(locatorKey);
		try {
			if (commonActions.isElementPresent(locatorKey)){
			commonActions.logPassStatus("Pass | Valid message displayed -"+commonActions.getText(locatorKey));
			} else {
				commonActions.logFailStatus("Error | Valid message display failed -"+commonActions.getText(locatorKey));
			}
			
		}
		catch (Exception e) {
			e.printStackTrace();
			commonActions.logAssert_Fail("text not found");
		}
		
	}
	
	
	
	@When("Capture Message on NewsletterMeineAbos")
	public void capture_Message_on_NewsletterMeineAbos() {
		try {

			CapturedMessagewurden = commonActions.getText("MessageCap");
			
			System.out.println("CapturedMessagewurden:" + CapturedMessagewurden);
		} catch (Exception e) {
			e.printStackTrace();
			commonActions.logAssert_Fail("Get text for MessageCap is failed");
		}
	}

	@When("Capture {string} on {string}")
	public void capture_on(String dataKey, String locatorKey) {
		try {
			if(dataKey.equals("Abonnement")) {
				CapturedMessageAbonnement = commonActions.getText("Abonnement_NewsletterMeineAbos");
				System.out.println("CapturedMessageAbonnement:" + CapturedMessageAbonnement);
			}
			else if(dataKey.equals("Preis")) {
				CapturedMessagePreis = commonActions.getText("Preis_NewsletterMeineAbos");
				System.out.println("CapturedMessagePreis:" + CapturedMessagePreis);
			}
			else if(dataKey.equals("Kuendigung_zum")) {
				CapturedMessageKuendigung = commonActions.getText("KuendigungZum_NewsletterMeineAbos");
				System.out.println("CapturedMessageKuendigung:" + CapturedMessageKuendigung);
			}
		} catch (Exception e) {
			e.printStackTrace();
			commonActions.logAssert_Fail("Get text for CapturedMessageAbonnement and CapturedMessagePreis is failed");
		}
	}

	@Then("Verify {string} on NewsletterMeineAbos")
	public void verify_on_NewsletterMeineAbos(String string) {
		commonActions.getElement("Gekündigt_zum");
		try {
			if (commonActions.isElementPresent("Gekündigt_zum")){
			commonActions.logPassStatus("Pass | Valid message displayed -"+commonActions.getText("Gekündigt_zum"));
			} else {
				commonActions.logFailStatus("Error | Valid message display failed -"+commonActions.getText("Gekündigt_zum"));
			}
		}catch (Exception e) {
			e.printStackTrace();
			commonActions.logAssert_Fail("text not found");
		}
	}	

	@Then("Verify captured Message, details from NewsletterMeineAbos")
	public void verify_captured_Message_details_from_NewsletterMeineAbos() {
		try {
			if (CapturedMessagewurden.equals(commonActions.getValueFromJson("Message"))) {
				commonActions.logPassStatus("Pass | Valid message displayed -"+CapturedMessagewurden);
			} else {
				commonActions.logFailStatus("Error | Valid message display failed -"+CapturedMessagewurden);
			}
			if (CapturedMessageAbonnement.equals(commonActions.getValueFromJson("Abonnement"))) {
				commonActions.logPassStatus("Pass | Valid message displayed -"+CapturedMessageAbonnement);
			} else {
				commonActions.logFailStatus("Error | Valid message display failed -"+CapturedMessageAbonnement);
			}
			if (CapturedMessagePreis.equals(commonActions.getValueFromJson("Preis"))) {
				commonActions.logPassStatus("Pass | Valid message displayed -"+CapturedMessagePreis);
			} else {
				commonActions.logFailStatus("Error | Valid message display failed -"+CapturedMessagePreis);
			}
			if (!CapturedMessageKuendigung.equals("")) {
				commonActions.logPassStatus("Pass | Valid message displayed -"+CapturedMessageKuendigung);
			} else {
				commonActions.logFailStatus("Error | Valid message display failed -"+CapturedMessageKuendigung);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			commonActions.logAssert_Fail("text not found");
		}
	}

	
}
