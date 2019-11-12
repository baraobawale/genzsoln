package com.bnpp.steps;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Assert;
import com.bnpp.library.CommonActions;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.runtime.CucumberException;

public class UC62_63_CFDHandel {

	CommonActions commonActions;
	String CapturedCFDKontoEinzel = "";
	String CapturedIVorgangsnummer = "";


	public UC62_63_CFDHandel(CommonActions commonActions) {
		this.commonActions = commonActions;
	}

	@When("Capture Vorgangsnummer,Message on CFDKontoEinzel")
	public void capture_Vorgangsnummer_Message_on_CFDKontoEinzel() {
		try {

			CapturedCFDKontoEinzel = commonActions.getText("CFDKontoEinzel_Message");
			CapturedIVorgangsnummer = commonActions.getText("Vorgangsnummer");
			
			System.out.println("CapturedCFDKontoEinzel:" + CapturedCFDKontoEinzel);
			System.out.println("CapturedIVorgangsnummer:" + CapturedIVorgangsnummer);
		} catch (Exception e) {
			e.printStackTrace();
			commonActions.logAssert_Fail("Get text for CFDKontoEinzel_Message and Vorgangsnummer is failed");
		}
	}

	@Then("Verify captured Vorgangsnummer,Message from CFDKontoEinzel")
	public void verify_captured_Vorgangsnummer_Message_from_CFDKontoEinzel() {
		try {
			if (CapturedCFDKontoEinzel.equals(commonActions.getValueFromJson("Message"))) {
				commonActions.logPassStatus("Pass | Valid message displayed -"+CapturedCFDKontoEinzel);
			} else {
				commonActions.logFailStatus("Error | Valid message display failed -"+CapturedCFDKontoEinzel);
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
	
	@And("User submits generated TAN number using MobileTanLink_AngabenZurPerson on TAN_field_AngabenZurPerson$")
	public void Submit_TAN_for_CFHandle() throws InterruptedException{
		commonActions.enterLoadenvironmentTan("TAN_field_AngabenZurPerson", "12345678");
		commonActions.click("BestigenCFHandle");
	}


}
