package com.bnpp.steps;

import java.io.IOException;

import org.json.simple.parser.ParseException;

import com.bnpp.library.CommonActions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class UC31_32_33_NeukundenDepot {

	CommonActions commonActions;
	String CaptureMsgKostenlosesWertpapierdepotEinzel = "";
	String CaptureKostenlosesWertpapierdepotEinzel = "";
	String CaptureKostenlosesWertpapierdepotMinderjaehrigen = "";
	String CaptureVorgangsnummerKostenlosesWertpapierdepotEinzel ="";
	String CaptureMessageGemeinschafts="";
	String CaptureVorgangsnummerGemeinschafts="";

	public UC31_32_33_NeukundenDepot(CommonActions commonActions) {
		this.commonActions = commonActions;
	}

	@When("Capture Vorgangsnummer,Message on KostenlosesWertpapierdepotEinzel_{int}")
	public void capture_Vorgangsnummer_Message_on_KostenlosesWertpapierdepotEinzel_(Integer int1) {
		try {
			CaptureMsgKostenlosesWertpapierdepotEinzel = commonActions.getText("MsgKostenlosesWertpapierdepotEinzel");
			CaptureKostenlosesWertpapierdepotEinzel = commonActions.getText("CaptureKostenlosesWertpapierdepotEinzel");

		}
		catch (Exception e) {
			e.printStackTrace();
			commonActions.logAssert_Fail("Capture Vorgangsnummer,Message on KostenlosesWertpapierdepotEinzel failed");
		}
	}

	@Then("Verify captured Vorgangsnummer,Message from KostenlosesWertpapierdepotEinzel_{int}")
	public void verify_captured_Vorgangsnummer_Message_from_KostenlosesWertpapierdepotEinzel_(Integer int1) {
		try {

			if (CaptureMsgKostenlosesWertpapierdepotEinzel.equals(commonActions.getValueFromJson("Message"))) {
				commonActions.logPassStatus("Pass | Valid Messge displayed -"+CaptureMsgKostenlosesWertpapierdepotEinzel);
			} else {
				commonActions.logFailStatus("Error | Valid Messge display failed -"+CaptureMsgKostenlosesWertpapierdepotEinzel);
			}
			if (!CaptureKostenlosesWertpapierdepotEinzel.equals("")) {
				commonActions.logPassStatus("Pass | captured Vorgangsnummer - "+CaptureKostenlosesWertpapierdepotEinzel);
			} else {
				commonActions.logFailStatus("Error | captured Vorgangsnummer - "+CaptureKostenlosesWertpapierdepotEinzel);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			commonActions.logAssert_Fail("Verify captured Vorgangsnummer,Message from KostenlosesWertpapierdepotEinzel");
		}
	}

	@When("Capture Vorgangsnummer,Message on KostenlosesWertpapierdepotGemeinschafts_{int}")
	public void capture_Vorgangsnummer_Message_on_KostenlosesWertpapierdepotGemeinschafts_(Integer int1) {
		try {
			CaptureMessageGemeinschafts= commonActions.getText("MsgKostenlosesWertpapierdepotEinzel");
			CaptureVorgangsnummerGemeinschafts = commonActions.getText("CaptureKostenlosesWertpapierdepotEinzel");	
		}
		catch (Exception e) {
			e.printStackTrace();
			commonActions.logAssert_Fail("Capture Vorgangsnummer,Message on KostenlosesWertpapierdepotGemeinschafts failed");
		}

	}

	@Then("Verify captured Vorgangsnummer,Message from KostenlosesWertpapierdepotGemeinschafts_{int}")
	public void verify_captured_Vorgangsnummer_Message_from_KostenlosesWertpapierdepotGemeinschafts_(Integer int1) {
		try {

			if (CaptureMessageGemeinschafts.equals(commonActions.getValueFromJson("Message"))) {
				commonActions.logPassStatus("Pass | Valid Messge displayed -"+CaptureMessageGemeinschafts);
			} else {
				commonActions.logFailStatus("Error | Valid Messge display failed -"+CaptureMessageGemeinschafts);
			}
			if (!CaptureVorgangsnummerGemeinschafts.equals("")) {
				commonActions.logPassStatus("Pass | captured Vorgangsnummer - "+CaptureVorgangsnummerGemeinschafts);
			} else {
				commonActions.logFailStatus("Error | captured Vorgangsnummer - "+CaptureVorgangsnummerGemeinschafts);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			commonActions.logAssert_Fail("Verify captured Vorgangsnummer,Message from KostenlosesWertpapierdepotGemeinschafts Failed");
		}

	}

	@When("Capture Vorgangsnummer,Message on KostenlosesWertpapierdepotMinderjaehrigen")
	public void capture_Vorgangsnummer_Message_on_KostenlosesWertpapierdepotMinderjaehrigen() {
		try {
			CaptureKostenlosesWertpapierdepotMinderjaehrigen = commonActions.getText("MsgKostenlosesWertpapierdepotMinderjaehrigen");
			CaptureVorgangsnummerKostenlosesWertpapierdepotEinzel = commonActions.getText("VorgangsnummerKostenlosesWertpapierdepotEinzel");

		}
		catch (Exception e) {
			e.printStackTrace();
			commonActions.logAssert_Fail("Capture Vorgangsnummer,Message on KostenlosesWertpapierdepotMinderjaehrigen failed");
		}
	}

	@Then("Verify captured Vorgangsnummer,Message from KostenlosesWertpapierdepotMinderjaehrigen_3")
	public void verify_captured_Vorgangsnummer_Message_from_KostenlosesWertpapierdepotMinderjaehrigen() {
		try {

			if (CaptureKostenlosesWertpapierdepotMinderjaehrigen.equals(commonActions.getValueFromJson("Message"))) {
				commonActions.logPassStatus("Pass | Valid Messge displayed -"+CaptureKostenlosesWertpapierdepotMinderjaehrigen);
			} else {
				commonActions.logFailStatus("Error | Valid Messge display failed -"+CaptureKostenlosesWertpapierdepotMinderjaehrigen);
			}
			if (!CaptureVorgangsnummerKostenlosesWertpapierdepotEinzel.equals("")) {
				commonActions.logPassStatus("Pass | captured Vorgangsnummer - "+CaptureVorgangsnummerKostenlosesWertpapierdepotEinzel);
			} else {
				commonActions.logFailStatus("Error | captured Vorgangsnummer - "+CaptureVorgangsnummerKostenlosesWertpapierdepotEinzel);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			commonActions.logAssert_Fail("Verify captured Vorgangsnummer,Message from KostenlosesWertpapierdepotMinderjaehrigen");
		}
	}



	@And("User clicks on Weiter_GesetzlicherVertreter1Page")
	public void User_clicks_on_Weiter_GesetzlicherVertreter1Page() throws IllegalArgumentException, InterruptedException, IOException, ParseException{
		commonActions.click("Weiter_GesetzlicherVertreter1Page"); 
		commonActions.clearfield("maintaxrasidance");
		String locatorKey="EMail2_GesetzlicherVertreter1Page"; 
		String textToEnter = commonActions.getValueFromJson("EMail_2");
		if (textToEnter.equals("")) {
			commonActions.clearfield(locatorKey);
		} else
			commonActions.enterText(locatorKey, textToEnter);
		commonActions.click("Weiter_GesetzlicherVertreter1Page");
	}
}
