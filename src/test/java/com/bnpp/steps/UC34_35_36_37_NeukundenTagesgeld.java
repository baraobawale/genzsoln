package com.bnpp.steps;

import java.io.FileNotFoundException;
import java.io.IOException;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebElement;

import com.bnpp.library.CommonActions;

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
			
			System.out.println("CaptureMsgTagesgeldkontoEinzel:" + CaptureMsgTagesgeldkontoEinzel);
		
		}
		catch (Exception e) {
			e.printStackTrace();
			commonActions.logAssert_Fail("text not found");
		}
	}
	
	@Then("Verify captured Vorgangsnummer,message from TagesgeldkontoEinzel")
	public void verify_captured_Vorgangsnummer_message_from_TagesgeldkontoEinzel() {
		try {
			if (commonActions.isElementPresent("CaptureVorgangsnummer")){
				commonActions.logPassStatus("Pass | Valid transaction number displayed -"+commonActions.getText("CaptureVorgangsnummer"));
				System.out.println("CaptureMsgVorgangsnummer:" + CaptureMsgVorgangsnummer);
			} else {
				commonActions.logFailStatus("Error | Valid transaction display failed -"+commonActions.getText("CaptureVorgangsnummer"));
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			commonActions.logAssert_Fail("text not found");
		}
	}
	
	@When("Capture Vorgangsnummer,Message on TagesgeldkontoGemeinschafts")
	public void capture_Vorgangsnummer_Message_on_TagesgeldkontoGemeinschafts() {
		try {
			CaptureMsgTagesgeldkontoGemeinschafts2 = commonActions.getText("CaptureMsgTagesgeldkontoGemeinschafts");
			
			System.out.println("CaptureMsgTagesgeldkontoGemeinschafts2:" + CaptureMsgTagesgeldkontoGemeinschafts2);
		
		}
		catch (Exception e) {
			e.printStackTrace();
			commonActions.logAssert_Fail("text not found");
		}
	}

	@Then("Verify captured Vorgangsnummer,Message from TagesgeldkontoGemeinschafts")
	public void verify_captured_Vorgangsnummer_Message_from_TagesgeldkontoGemeinschafts() {
		try {
			if (commonActions.isElementPresent("CaptureVorgangsnummer2")){
				commonActions.logPassStatus("Pass | Valid transaction number displayed -"+commonActions.getText("CaptureVorgangsnummer2"));
				System.out.println("CaptureMsgVorgangsnummer2:" + CaptureMsgVorgangsnummer2);
			} else {
				commonActions.logFailStatus("Error | Valid transaction number display failed -"+commonActions.getText("CaptureVorgangsnummer2"));
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			commonActions.logAssert_Fail("text not found");
		}
	}
	@When("Capture Vorgangsnummer,Message on TagesgeldkontoMinderjaehrigen{int}")
	public void capture_Vorgangsnummer_Message_on_TagesgeldkontoMinderjaehrigen(Integer int1) {
		try {
			CaptureMsgTagesgeldkontoMinderjaehrigen = commonActions.getText("CaptureMsgTagesgeldkontoMinderjaehrigen3");
			
			System.out.println("CaptureMsgTagesgeldkontoMinderjaehrigen:" + CaptureMsgTagesgeldkontoMinderjaehrigen);
		
		}
		catch (Exception e) {
			e.printStackTrace();
			commonActions.logAssert_Fail("text not found");
		}
	}

	@Then("Verify captured Vorgangsnummer,Message from TagesgeldkontoMinderjaehrigen{int}")
	public void verify_captured_Vorgangsnummer_Message_from_TagesgeldkontoMinderjaehrigen(Integer int1) {
		try {
			if (commonActions.isElementPresent("CaptureTagesgeldkontoMinderjaehrigen3")){
				commonActions.logPassStatus("Pass | Valid transaction number displayed -"+commonActions.getText("CaptureTagesgeldkontoMinderjaehrigen3"));
				System.out.println("CaptureMsgTagesgeldkontoMinderjaehrigen3:" + CaptureMsgTagesgeldkontoMinderjaehrigen3);
			} else {
				commonActions.logFailStatus("Error | Valid transaction number display failed -"+commonActions.getText("CaptureTagesgeldkontoMinderjaehrigen3"));
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			commonActions.logAssert_Fail("text not found");
		}
	}
}
