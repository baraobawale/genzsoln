package com.bnpp.steps;

import java.io.FileNotFoundException;
import java.io.IOException;
<<<<<<< HEAD
=======
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
>>>>>>> RTA_OFF_SCRIPT

import org.json.simple.parser.ParseException;

import com.bnpp.library.CommonActions;

<<<<<<< HEAD
=======
import cucumber.api.java.en.And;
>>>>>>> RTA_OFF_SCRIPT
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class UC16_Dauerlastschrift {


	CommonActions commonActions;
	String MessageJson;
	String MessageDauerlastschrift;
	String CapturedNameDauerlastschrift;
	String CapturedIBANDauerlastschrift;
	String CapturedStartdatumDauerlastschrift;
	String VerifyStartdatumDauerlastschrift;
	String VerifyIBANDauerlastschrift;	
	String DauerlastschriftAnlengenDATE;

	public UC16_Dauerlastschrift(CommonActions commonActions)
			throws FileNotFoundException, IOException, ParseException {
		this.commonActions = commonActions;
	}

	@When("User clicks on Edit_Dauerlastschrift of CreatedDauerlastschrift_UmsaetzeZahlungsverkehr")
	public void user_clicks_on_Edit_Dauerlastschrift_of_CreatedDauerlastschrift_UmsaetzeZahlungsverkehr() {
		try {
			commonActions.click("Edit_Dauerlastschrift");
			System.out.println("Edit_Dauerlastschrift clicked");
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("Element could not be clicked");
			commonActions.logAssert_Fail("Element could not be clicked");
		}
	}

	@When("User clicks on Delete_Dauerlastschrift of CreatedDauerlastschrift_Dauerlastschriftloeschen")
	public void user_clicks_on_Delete_Dauerlastschrift_of_CreatedDauerlastschrift_Dauerlastschriftloeschen() {
		try {
			commonActions.click("Delete_Dauerlastschrift");
			System.out.println("Delete_Dauerlastschrift clicked");
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("Element could not be clicked");
			commonActions.logAssert_Fail("Element could not be clicked");
		}
	}
	@When("Capture entered details on DauerlastschriftAnlengen")
	public void capture_entered_details_on_DauerlastschriftAnlengen() {
		try {
			CapturedIBANDauerlastschrift= commonActions.getText("CapturedIBANDauerlastschrift");
			CapturedStartdatumDauerlastschrift= commonActions.getText("CapturedStartdatumDauerlastschrift");
			System.out.println("CapturedStartdatumDauerlastschrift: " + CapturedStartdatumDauerlastschrift);
			System.out.println("CapturedIBANDauerlastschrift: " +  CapturedIBANDauerlastschrift);
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("DATA NOT CAPTURED");
			commonActions.logAssert_Fail("Failure Capturing data");
		}			

	}
	@Then("Verify {string},{string} under LaufendenZahlungenVorlagen_UmsaetzeZahlungsverkehr")
	public void verify_under_LaufendenZahlungenVorlagen_UmsaetzeZahlungsverkehr(String string, String string2) {

		VerifyStartdatumDauerlastschrift= commonActions.getText("VerifyStartdatumDauerlastschrift");
		VerifyIBANDauerlastschrift= commonActions.getText("VerifyIBANDauerlastschrift");

		System.out.println("Verify Startdatum Dauerlastschrift:"+VerifyStartdatumDauerlastschrift);
		System.out.println("Verify IBAN Dauerlastschrift:"+VerifyIBANDauerlastschrift);

		if(VerifyStartdatumDauerlastschrift.equals(CapturedStartdatumDauerlastschrift))
		{ System.out.println("Valid Startdatum value displayed");
		commonActions.logPassStatus("Pass | Valid Startdatum value displayed - " + VerifyStartdatumDauerlastschrift);
		}
		else
		{
			commonActions.logFailStatus("Fail | Valid Startdatum value display failed - " + VerifyStartdatumDauerlastschrift);
		}
		if (VerifyIBANDauerlastschrift.equals(CapturedIBANDauerlastschrift))
		{System.out.println("Valid IBAN value displayed");
		commonActions.logPassStatus("Pass | Valid IBAN value displayed - " + VerifyIBANDauerlastschrift);
		}else	
		{ 
			commonActions.logFailStatus("Fail | Valid IBAN value display failed - " + VerifyIBANDauerlastschrift);
		}
	}


	@When("Capture Message on DauerlastschriftAnlengen")
	public void capture_Message_on_DauerlastschriftAnlengen() {
		try {
			MessageDauerlastschrift = commonActions.getText("MessageDauerlastschrift");
			System.out.println("Message CAPTURED: "+MessageDauerlastschrift);
		} catch (Exception e) {
			System.out.println("Message NOT CAPTURED");
			e.printStackTrace();
			commonActions.logAssert_Fail("Message NOT CAPTURED");
		}
	}

	@Then("Verify captured details,Message from DauerlastschriftAnlengen")
	public void verify_captured_details_Message_from_DauerlastschriftAnlengen() {
		try {

			System.out.println("MessageDauerlastschrift CAPTURED: "+MessageDauerlastschrift);
			MessageJson=commonActions.getValueFromJson("Message");
			System.out.println("MessageDauerlastschrift : "+MessageDauerlastschrift);
			System.out.println("MessageJson : "+MessageJson);
			if(MessageJson.equals(MessageDauerlastschrift))
			{	
				System.out.println("Message Pass : "+MessageDauerlastschrift);	
				commonActions.logPassStatus("Pass | Valid MessageDauerlastschrift displayed " + MessageDauerlastschrift);
			}
			else {
				System.out.println("Message Fail ");
				commonActions.logFailStatus("Fail | Valid MessageDauerlastschrift display failed -" + MessageDauerlastschrift);
			}
		} catch (Exception e) {
			e.printStackTrace();
			commonActions.logAssert_Fail("Verify Message,details on DauerlastschriftAnlengen Failed");
		}
	}


	@Then("Verify captured details,Message on DauerlastschriftAndern")
	public void verify_captured_details_Message_on_DauerlastschriftAndern() {
		try {
			MessageDauerlastschrift = commonActions.getText("MessageDauerlastschrift");
			MessageJson=commonActions.getValueFromJson("Message");
			if(MessageJson.equals(MessageDauerlastschrift))
			{	
				System.out.println("Message Pass : "+MessageDauerlastschrift);	
				commonActions.logPassStatus("Pass | Valid MessageDauerlastschrift displayed " + MessageDauerlastschrift);
			}
			else {
				System.out.println("Message Fail ");
				commonActions.logFailStatus("Fail | Valid MessageDauerlastschrift display failed -" + MessageDauerlastschrift);
			}
		} catch (Exception e) {
			e.printStackTrace();
			commonActions.logAssert_Fail("Verify Message,details on DauerlastschriftAndern Failed");
		}
	}

	@Then("Verify Message on Dauerlastschriftloeschen")
	public void verify_Message_on_Dauerlastschriftloeschen() {
		try {
			MessageDauerlastschrift = commonActions.getText("MessageDauerlastschrift");
			MessageJson=commonActions.getValueFromJson("Message");
			System.out.println("Message  : "+MessageDauerlastschrift);	
			System.out.println("Message Json : "+MessageJson);	
			if(MessageJson.equals(MessageDauerlastschrift))
			{	
				System.out.println("Message Pass : "+MessageDauerlastschrift);	
				commonActions.logPassStatus("Pass | Valid MessageDauerlastschrift displayed " + MessageDauerlastschrift);
			}
			else {
				System.out.println("Message Fail : ");
				commonActions.logFailStatus("Fail | Valid MessageDauerlastschrift display failed -" + MessageDauerlastschrift);
			}
		} catch (Exception e) {
			e.printStackTrace();
			commonActions.logAssert_Fail("Verify Message,details on Dauerlastschriftloeschen Failed");
		}
	}

	@And("^User clicks on NeuesDauerlastschriftenAnlengen_UmsaetzeZahlungsverkehr to create template$")
	public void user_clicks_on_NeuesDauerlastschriftenAnlengen_UmsaetzeZahlungsverkehr() throws InterruptedException{
		try {
			if (commonActions.isElementPresent("VerifyIBANDauerlastschrift")) {
				commonActions.click("Delete_Dauerlastschrift");
				commonActions.enterLoadenvironmentTan("TAN_field_Dauerlastschriftloeschen","12345678");
				commonActions.click("Dauerlastschriftenloeschen_Dauerlastschriftloeschen");
				commonActions.click("ZumZahlungsverkehr_DauerlastschriftAnlengen");
			}
			Thread.sleep(3000);
			commonActions.moveScrollDown();
			commonActions.click("Dauerlastschriften_UmsaetzeZahlungsverkehr");
			commonActions.click("NeuesDauerlastschriftenAnlengen_UmsaetzeZahlungsverkehr");
		} catch (Exception e) {
			e.printStackTrace();
		}}
}
