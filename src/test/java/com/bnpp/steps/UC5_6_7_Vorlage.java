package com.bnpp.steps;

import java.io.IOException;

import org.json.simple.parser.ParseException;

import com.bnpp.library.CommonActions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

public class UC5_6_7_Vorlage {

	CommonActions commonActions;

	public UC5_6_7_Vorlage(CommonActions con) {
		this.commonActions = con;
	}

	
	@And("^User clicks on \"(.*?)\" of \"(.*?)\" field$")
	public void clicksEDITorDELETE(String locatorKey, String Created_Vorlagenname1) throws Exception 
	{
		if(locatorKey.equals("Created_Vorlagenname"))
			commonActions.waitForVisibilityofElement("locatorKey");
		commonActions.click(locatorKey);
		

	}	
	
	@And("^User changes \"(.*?)\" in \"(.*?)\" field$")
	public void user_changes_in_field(String Betrag, String locatorKey) throws Exception, InterruptedException, IOException, ParseException 
	{
		System.out.println("locatorKey+  "+locatorKey);
		System.out.println("Betrag+  "+Betrag);

		commonActions.clearfield(locatorKey);
		commonActions.enterText(locatorKey, Betrag);
	}
	
	
	@Then("^Verify IBAN create message$")
	public void Verify_Message_Ihre_Überweisungsvorlage_wurde_angelegt1(){
		if(commonActions.getText("Ihre_Überweisungsvorlage_wurde").contains("Ihre Überweisungsvorlage wurde angelegt"))
			commonActions.logPassStatus("IBAN create success");
		else
			commonActions.logAssert_Fail("IBAN create fail");
		
	}
	@Then("^Verify IBAN update message$")
	public void Verify_Message_Ihre_Überweisungsvorlage_wurde_angelegt3(){
		if(commonActions.getText("Ihre_Überweisungsvorlage_wurde").contains("Ihre Überweisungsvorlage wurde gespeichert"))
			commonActions.logPassStatus("IBAN update success");
		else
			commonActions.logAssert_Fail("IBAN update fail");
		
	}
	
	@Then("^Verify IBAN delete message$")
	public void Verify_Message_Ihre_Überweisungsvorlage_wurde_angelegt6(){
		if(commonActions.getText("Ihre_Überweisungsvorlage_wurde").contains("Ihre Überweisungsvorlage wurde gelöscht"))
			commonActions.logPassStatus("IBAN delete success");
		else
			commonActions.logAssert_Fail("IBAN delete fail");
	}
	
	@Then("^Verify KontoBLZ create message$")
	public void Verify_Message_Ihre_Überweisungsvorlage_wurde_angelegt2(){
		if(commonActions.getText("Ihre_Überweisungsvorlage_wurde").contains("Ihre Überweisungsvorlage wurde angelegt"))
			commonActions.logPassStatus("KontoBLZ create success");
		else
			commonActions.logAssert_Fail("KontoBLZ create failed");
		
	}

	@Then("^Verify KontoBLZ update message$")
	public void Verify_Message_Ihre_Überweisungsvorlage_wurde_angelegt4(){
		if(commonActions.getText("Ihre_Überweisungsvorlage_wurde").contains("Ihre Überweisungsvorlage wurde gespeichert"))
			commonActions.logPassStatus("KontoBLZ update success");
		else
			commonActions.logAssert_Fail("KontoBLZ update failed");
	}
	@Then("^Verify KontoBLZ delete message$")
	public void Verify_Message_Ihre_Überweisungsvorlage_wurde_angelegt5(){
		if(commonActions.getText("Ihre_Überweisungsvorlage_wurde").contains("Ihre Überweisungsvorlage wurde gelöscht"))
			commonActions.logPassStatus("KontoBLZ delete success");
		else
			commonActions.logAssert_Fail("KontoBLZ delete failed");
		
	}

	
	

}


