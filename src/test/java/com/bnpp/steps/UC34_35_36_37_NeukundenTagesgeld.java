package com.bnpp.steps;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;

import com.bnpp.library.CommonActions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class UC34_35_36_37_NeukundenTagesgeld {

	CommonActions commonActions;
	String CaptureMsgTagesgeldkontoEinzel = "";
	String CaptureMsgVorgangsnummer ="";
	String CaptureMsgTagesgeldkontoGemeinschafts2 = "";
	String CaptureMsgVorgangsnummer2 = "";
	String CaptureMsgTagesgeldkontoMinderjaehrigen = "";
	String CaptureMsgTagesgeldkontoMinderjaehrigen3 = "";

	public UC34_35_36_37_NeukundenTagesgeld(CommonActions commonActions) {
		this.commonActions = commonActions;
	}
	
	@When("Capture Vorgangsnummer,Message on TagesgeldkontoEinzel")
	public void capture_Vorgangsnummer_Message_on_TagesgeldkontoEinzel() {
		try {
			CaptureMsgTagesgeldkontoEinzel = commonActions.getText("TagesgeldkontoEinzel");
			CaptureMsgVorgangsnummer = commonActions.getText("CaptureVorgangsnummer");
			
			}
		catch (Exception e) {
			e.printStackTrace();
			commonActions.logAssert_Fail("Capture Vorgangsnummer,Message on TagesgeldkontoEinzel failed");
		}
	}
	
	@Then("Verify captured Vorgangsnummer,message from TagesgeldkontoEinzel")
	public void verify_captured_Vorgangsnummer_message_from_TagesgeldkontoEinzel() {
		try {
			
			if (CaptureMsgTagesgeldkontoEinzel.trim().equals(commonActions.getValueFromJson("Message"))) {
				commonActions.logPassStatus("Pass | Valid Messge displayed -"+CaptureMsgTagesgeldkontoEinzel);
			} else {
				commonActions.logFailStatus("Error | Valid Messge display failed -"+CaptureMsgTagesgeldkontoEinzel);
			}
			if (!CaptureMsgVorgangsnummer.equals("")) {
				commonActions.logPassStatus("Pass | captured Vorgangsnummer - "+CaptureMsgVorgangsnummer);
			} else {
				commonActions.logFailStatus("Error | captured Vorgangsnummer - "+CaptureMsgVorgangsnummer);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			commonActions.logAssert_Fail("Verify captured Vorgangsnummer,message from TagesgeldkontoEinzel failed");
		}
	}
	
	@When("Capture Vorgangsnummer,Message on TagesgeldkontoGemeinschafts")
	public void capture_Vorgangsnummer_Message_on_TagesgeldkontoGemeinschafts() {
		try {
			CaptureMsgTagesgeldkontoGemeinschafts2 = commonActions.getText("CaptureMsgTagesgeldkontoGemeinschafts");
			CaptureMsgVorgangsnummer2 = commonActions.getText("CaptureVorgangsnummer2");
			
			System.out.println("CaptureMsgTagesgeldkontoGemeinschafts2:" + CaptureMsgTagesgeldkontoGemeinschafts2);
		
		}
		catch (Exception e) {
			e.printStackTrace();
			commonActions.logAssert_Fail("Capture Vorgangsnummer,Message on TagesgeldkontoGemeinschafts");
		}
	}

	@Then("Verify captured Vorgangsnummer,Message from TagesgeldkontoGemeinschafts")
	public void verify_captured_Vorgangsnummer_Message_from_TagesgeldkontoGemeinschafts() {
		try {
			if (CaptureMsgTagesgeldkontoGemeinschafts2.trim().equals(commonActions.getValueFromJson("Message"))) {
				commonActions.logPassStatus("Pass | Valid Messge displayed -"+CaptureMsgTagesgeldkontoGemeinschafts2);
	
			} else {
				commonActions.logFailStatus("Error | Valid Messge display failed -"+CaptureMsgTagesgeldkontoGemeinschafts2);
			}if (!CaptureMsgVorgangsnummer2.equals("")) {
				commonActions.logPassStatus("Pass | captured Vorgangsnummer - "+CaptureMsgVorgangsnummer2);
			} else {
				commonActions.logFailStatus("Error | captured Vorgangsnummer - "+CaptureMsgVorgangsnummer2);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			commonActions.logAssert_Fail("Verify captured Vorgangsnummer,Message from TagesgeldkontoGemeinschafts failed");
		}
	}
	@When("Capture Vorgangsnummer,Message on TagesgeldkontoMinderjaehrigen{int}")
	public void capture_Vorgangsnummer_Message_on_TagesgeldkontoMinderjaehrigen(Integer int1) {
		try {
			CaptureMsgTagesgeldkontoMinderjaehrigen = commonActions.getText("CaptureMsgTagesgeldkontoMinderjaehrigen3");
			CaptureMsgTagesgeldkontoMinderjaehrigen3 = commonActions.getText("CaptureTagesgeldkontoMinderjaehrigen3");
			
			System.out.println("CaptureMsgTagesgeldkontoMinderjaehrigen:" + CaptureMsgTagesgeldkontoMinderjaehrigen);
		
		}
		catch (Exception e) {
			e.printStackTrace();
			commonActions.logAssert_Fail("Capture Vorgangsnummer,Message on TagesgeldkontoMinderjaehrigen failed");
		}
	}

	@Then("Verify captured Vorgangsnummer,Message from TagesgeldkontoMinderjaehrigen{int}")
	public void verify_captured_Vorgangsnummer_Message_from_TagesgeldkontoMinderjaehrigen(Integer int1) {
		try {
			if (CaptureMsgTagesgeldkontoMinderjaehrigen.trim().equals(commonActions.getValueFromJson("Message"))) {
				commonActions.logPassStatus("Pass | Valid Messge displayed -"+CaptureMsgTagesgeldkontoMinderjaehrigen);
				
			} else {
				commonActions.logFailStatus("Error | Valid Messge display failed -"+CaptureMsgTagesgeldkontoMinderjaehrigen);
			}
			if (!CaptureMsgTagesgeldkontoMinderjaehrigen3.equals("")) {
				commonActions.logPassStatus("Pass | captured Vorgangsnummer - "+CaptureMsgTagesgeldkontoMinderjaehrigen3);
			} else {
				commonActions.logFailStatus("Error | captured Vorgangsnummer - "+CaptureMsgTagesgeldkontoMinderjaehrigen3);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			commonActions.logAssert_Fail("Verify captured Vorgangsnummer,Message from TagesgeldkontoMinderjaehrigen failed");
		}
	}
	@And("User clicks on Zum2GesetzlVertreter_Kontoinhaber")
	public void User_clicks_on_Zum2GesetzlVertreter_Kontoinhaber() throws FileNotFoundException, IOException, ParseException, IllegalArgumentException, InterruptedException{
		commonActions.click("Zum2GesetzlVertreter_Kontoinhaber");
		commonActions.clearfield("maintaxrasidance");
		String locatorKey="EMail2_GesetzlicherVertreter1";
		String textToEnter = commonActions.getValueFromJson("EMail_2");
		if (textToEnter.equals("")) {
			commonActions.clearfield(locatorKey);
		} else
			commonActions.enterText(locatorKey, textToEnter);
		commonActions.click("Zum2GesetzlVertreter_Kontoinhaber");
	}
	
	@And("User clicks on Weiter_GesetzlicherVertreter2")
	public void User_clicks_on_Weiter_GesetzlicherVertreter2() throws IllegalArgumentException, InterruptedException, IOException, ParseException{
		commonActions.click("Weiter_GesetzlicherVertreter2");
		commonActions.clearfield("maintaxrasidance2");
		String locatorKey="EMail2_GesetzlicherVertreter";
		String textToEnter = commonActions.getValueFromJson("EMail_3");
		if (textToEnter.equals("")) {
			commonActions.clearfield(locatorKey);
		} else
			commonActions.enterText(locatorKey, textToEnter);
		commonActions.click("Weiter_GesetzlicherVertreter2");
	}
	
}
