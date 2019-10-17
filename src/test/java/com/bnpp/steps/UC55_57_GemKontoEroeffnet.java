package com.bnpp.steps;

import java.io.FileNotFoundException;
import java.io.IOException;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebElement;

import com.bnpp.library.CommonActions;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class UC55_57_GemKontoEroeffnet {

	CommonActions commonActions;
	String CaptureKostenlosesWertpapierdepotGemeinschafts = "";
	String CaptureVorgangsnummerKostenlosesWertpapierdepotGemeinschafts = "";
	String CaptureTagesgeldkontoGemeinschafts = "";
	String CaptureVorgangsnummerTagesgeldkontoGemeinschafts = "";
	

	public UC55_57_GemKontoEroeffnet(CommonActions commonActions) {
		this.commonActions = commonActions;
	}
	
	@When("Capture the Vorgangsnummer,Message on KostenlosesWertpapierdepotGemeinschafts")
	public void capture_the_Vorgangsnummer_Message_on_KostenlosesWertpapierdepotGemeinschafts() {
		try {
			CaptureKostenlosesWertpapierdepotGemeinschafts = commonActions.getText("MsgKostenlosesWertpapierdepotGemeinschafts");
			CaptureVorgangsnummerKostenlosesWertpapierdepotGemeinschafts = commonActions.getText("VorgangsnummerKostenlosesWertpapierdepotGemeinschafts");
		
		}
		catch (Exception e) {
			e.printStackTrace();
			commonActions.logAssert_Fail("text not found");
		}
	}

	@Then("Verify the captured Vorgangsnummer,Message from KostenlosesWertpapierdepotGemeinschafts")
	public void verify_captured_Vorgangsnummer_Message_from_KostenlosesWertpapierdepotGemeinschafts() {
try {
			
			if (CaptureKostenlosesWertpapierdepotGemeinschafts.equals(commonActions.getValueFromJson("Message"))) {
				commonActions.logPassStatus("Pass | Valid Messge displayed -"+CaptureKostenlosesWertpapierdepotGemeinschafts);
			} else {
				commonActions.logFailStatus("Error | Valid Messge display failed -"+CaptureKostenlosesWertpapierdepotGemeinschafts);
			}
			if (!CaptureVorgangsnummerKostenlosesWertpapierdepotGemeinschafts.equals("")) {
				commonActions.logPassStatus("Pass | captured Vorgangsnummer - "+CaptureVorgangsnummerKostenlosesWertpapierdepotGemeinschafts);
			} else {
				commonActions.logFailStatus("Error | captured Vorgangsnummer - "+CaptureVorgangsnummerKostenlosesWertpapierdepotGemeinschafts);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			commonActions.logAssert_Fail("text not found");
		}
	}
	
	@When("Capture the Vorgangsnummer,Message on TagesgeldkontoGemeinschafts")
	public void capture_the_Vorgangsnummer_Message_on_TagesgeldkontoGemeinschafts() {
		try {
			CaptureTagesgeldkontoGemeinschafts = commonActions.getText("MsgTagesgeldkontoGemeinschafts");
			CaptureVorgangsnummerTagesgeldkontoGemeinschafts = commonActions.getText("VorgangsnummerTagesgeldkontoGemeinschafts");
		
		}
		catch (Exception e) {
			e.printStackTrace();
			commonActions.logAssert_Fail("text not found");
		}
	}

	@Then("Verify the captured Vorgangsnummer,Message from TagesgeldkontoGemeinschafts")
	public void verify_the_captured_Vorgangsnummer_Message_from_TagesgeldkontoGemeinschafts() {
try {
			
			if (CaptureTagesgeldkontoGemeinschafts.equals(commonActions.getValueFromJson("Message"))) {
				commonActions.logPassStatus("Pass | Valid Messge displayed -"+CaptureTagesgeldkontoGemeinschafts);
			} else {
				commonActions.logFailStatus("Error | Valid Messge display failed -"+CaptureTagesgeldkontoGemeinschafts);
			}
			if (!CaptureVorgangsnummerTagesgeldkontoGemeinschafts.equals("")) {
				commonActions.logPassStatus("Pass | captured Vorgangsnummer - "+CaptureVorgangsnummerTagesgeldkontoGemeinschafts);
			} else {
				commonActions.logFailStatus("Error | captured Vorgangsnummer - "+CaptureVorgangsnummerTagesgeldkontoGemeinschafts);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			commonActions.logAssert_Fail("text not found");
		}
	}


	}

