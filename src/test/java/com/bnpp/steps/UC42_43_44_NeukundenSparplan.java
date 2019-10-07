package com.bnpp.steps;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Assert;
import com.bnpp.library.CommonActions;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.runtime.CucumberException;

public class UC42_43_44_NeukundenSparplan {

	CommonActions commonActions;
	String CapturedKostenlosesWertpapierdepotEinzel = "";
	String CapturedIVorgangsnummer = "";
	String CapturedKostenlosesWertpapierdepotGemeinschafts= "";
	String CapturedKostenlosesWertpapierdepotMinderjaehrigen="";


	public UC42_43_44_NeukundenSparplan(CommonActions commonActions) {
		this.commonActions = commonActions;
	}

	@Then("Verify captured Vorgangsnummer,Message from laden_KostenlosesWertpapierdepotEinzel")
	public void verify_captured_Vorgangsnummer_Message_from_CFDKontoEinzel() {
		try {
			if (CapturedKostenlosesWertpapierdepotEinzel.equals(commonActions.getValueFromJson("Message"))) {
				commonActions.logPassStatus("Pass | Valid message displayed -"+CapturedKostenlosesWertpapierdepotEinzel);
			} else {
				commonActions.logFailStatus("Error | Valid message display failed -"+CapturedKostenlosesWertpapierdepotEinzel);
			}
			if (!CapturedIVorgangsnummer.equals("")) {
				commonActions.logPassStatus("Pass | captured Vorgangsnummer - "+CapturedIVorgangsnummer);
			} else {
				commonActions.logFailStatus("Error | captured Vorgangsnummer - "+CapturedIVorgangsnummer);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
//			commonActions.logAssert_Fail("text not found");
		}
	}

	@When("Capture Vorgangsnummer,Message on KostenlosesWertpapierdepotEinzel")
	public void capture_Vorgangsnummer_Message_on_KostenlosesWertpapierdepotEinzel() {
		try {

			CapturedKostenlosesWertpapierdepotEinzel = commonActions.getText("CFDKontoEinzel_Message");
			CapturedIVorgangsnummer = commonActions.getText("Vorgangsnummer");
			
			System.out.println("CapturedCFDKontoEinzel:" + CapturedKostenlosesWertpapierdepotEinzel);
			System.out.println("CapturedIVorgangsnummer:" + CapturedIVorgangsnummer);
		} catch (Exception e) {
			e.printStackTrace();
			commonActions.logAssert_Fail("Get text for CFDKontoEinzel_Message and Vorgangsnummer is failed");
		}
	}
	
	@Then("Capture Vorgangsnummer,Message on KostenlosesWertpapierdepotGemeinschafts")
	public void verify_captured_Vorgangsnummer_Message_from_KostenlosesWertpapierdepotGemeinschafts() {
		try {
			if (CapturedKostenlosesWertpapierdepotGemeinschafts.equals(commonActions.getValueFromJson("Message"))) {
				commonActions.logPassStatus("Pass | Valid message displayed -"+CapturedKostenlosesWertpapierdepotGemeinschafts);
			} else {
				commonActions.logFailStatus("Error | Valid message display failed -"+CapturedKostenlosesWertpapierdepotEinzel);
			}
			if (!CapturedIVorgangsnummer.equals("")) {
				commonActions.logPassStatus("Pass | captured Vorgangsnummer - "+CapturedIVorgangsnummer);
			} else {
				commonActions.logFailStatus("Error | captured Vorgangsnummer - "+CapturedIVorgangsnummer);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
//			commonActions.logAssert_Fail("text not found");
		}
	}

	@When("Verify captured Vorgangsnummer,Message from KostenlosesWertpapierdepotGemeinschafts")
	public void capture_Vorgangsnummer_Message_on_KostenlosesWertpapierdepotGemeinschafts() {
		try {

			CapturedKostenlosesWertpapierdepotGemeinschafts = commonActions.getText("KostenlosesWertpapierdepotGemeinschafts");
			CapturedIVorgangsnummer = commonActions.getText("Vorgangsnummer");
			
			System.out.println("CapturedCFDKontoEinzel:" + CapturedKostenlosesWertpapierdepotGemeinschafts);
			System.out.println("CapturedIVorgangsnummer:" + CapturedIVorgangsnummer);
		} catch (Exception e) {
			e.printStackTrace();
			commonActions.logAssert_Fail("Get text for CFDKontoEinzel_Message and Vorgangsnummer is failed");
		}
	}
	
	@When("Capture Vorgangsnummer,Message on KostenlosesWertpapierdepotMinderjaehrigen_{int}GV")
	public void capture_Vorgangsnummer_Message_on_KostenlosesWertpapierdepotMinderjaehrigen__GV(Integer int1) {
		try {

			CapturedKostenlosesWertpapierdepotMinderjaehrigen = commonActions.getText("KostenlosesWertpapierdepotMinderjaehrigen");
			CapturedIVorgangsnummer = commonActions.getText("Vorgangsnummer");
			
			System.out.println("CapturedCFDKontoEinzel:" + CapturedKostenlosesWertpapierdepotEinzel);
			System.out.println("CapturedIVorgangsnummer:" + CapturedIVorgangsnummer);
		} catch (Exception e) {
			e.printStackTrace();
			commonActions.logAssert_Fail("Get text for CFDKontoEinzel_Message and Vorgangsnummer is failed");
		}
	}

	@Then("Verify captured Vorgangsnummer,Message from KostenlosesWertpapierdepotMinderjaehrigen_{int}GV")
	public void verify_captured_Vorgangsnummer_Message_from_KostenlosesWertpapierdepotMinderjaehrigen__GV(Integer int1) {
		try {
			if (CapturedKostenlosesWertpapierdepotMinderjaehrigen.equals(commonActions.getValueFromJson("Message"))) {
				commonActions.logPassStatus("Pass | Valid message displayed -"+CapturedKostenlosesWertpapierdepotMinderjaehrigen);
			} else {
				commonActions.logFailStatus("Error | Valid message display failed -"+CapturedKostenlosesWertpapierdepotMinderjaehrigen);
			}
			if (!CapturedIVorgangsnummer.equals("")) {
				commonActions.logPassStatus("Pass | captured Vorgangsnummer - "+CapturedIVorgangsnummer);
			} else {
				commonActions.logFailStatus("Error | captured Vorgangsnummer - "+CapturedIVorgangsnummer);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
//			commonActions.logAssert_Fail("text not found");
		}
	}

}
