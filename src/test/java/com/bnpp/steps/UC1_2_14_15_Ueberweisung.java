package com.bnpp.steps;

import java.io.FileNotFoundException;
import java.io.IOException;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebElement;

import com.bnpp.library.CommonActions;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class UC1_2_14_15_Ueberweisung {

	CommonActions commonActions;
	String CaptureMsgUeberweisangSEPA ="";
	String CaptureMsgUeberweisangSWIFT ="";

	public UC1_2_14_15_Ueberweisung(CommonActions commonActions) {
		this.commonActions = commonActions;
	}

	@When("User selects Art_der_Ueberweisung in ArtDerUeberweisung_UeberweisungAnlegen")
	public void user_selects_Art_der_Ueberweisung_in_ArtDerUeberweisung_UeberweisungAnlegen() {
		try {
			if (commonActions.getScenarioName().equals("Ueberweisung_Anlegen_SWIFT")) 
			{
				commonActions.click("ArtDerUeberweisung_UeberweisungAnlegen_SWIFT");
			}else 	
				commonActions.click("ArtDerUeberweisung_UeberweisungAnlegen_SEPA");
		} catch (InterruptedException e) {
			e.printStackTrace();    
		}}	

	@Then("Verify details,Message on UeberweisungAnlegen")
	public void verify_details_Message_on_UeberweisungAnlegen() throws FileNotFoundException, IOException, ParseException {
		try {
			String str = commonActions.checkGermanCharacters(commonActions.getValueFromJson("Message"));	
			CaptureMsgUeberweisangSEPA = commonActions.getText("CaptureMsgUeberweisangSEPA");
			if(str.equals(CaptureMsgUeberweisangSEPA)) {
				System.out.println("message: "+CaptureMsgUeberweisangSEPA);
				commonActions.logPassStatus("Pass | Valid Messge displayed -"+CaptureMsgUeberweisangSEPA);
			}	
			else {
				commonActions.logFailStatus("Error | Valid Messge display failed -"+CaptureMsgUeberweisangSEPA);
			}  
		} catch (Exception e) {
			e.printStackTrace();
			commonActions.logAssert_Fail("Fail | Data save fail for UeberweisungAnlegen");
		}}

	@When("User selects Ausfuehrung in Ausfuehrung_UeberweisungAnlegen")
	public void user_selects_Ausfuehrung_in_Ausfuehrung_UeberweisungAnlegen() {
		try {
			if (commonActions.getScenarioName().equals("Ueberweisung_Anlegen_SEPA")) {
				commonActions.click("Ausfuehrung_UeberweisungAnlegenSEPA");
			}} catch (InterruptedException e) {		
				e.printStackTrace();			
			}}

	@When("User selects Gebuehrenregelung in Gebuehrenregelung_UeberweisungAnlegen")
	public void user_selects_Gebuehrenregelung_in_Gebuehrenregelung_UeberweisungAnlegen() {
		try {
			if (commonActions.getScenarioName().equals("Ueberweisung_Anlegen_SWIFT")) {
				commonActions.click("Gebuehrenregelung_UeberweisungAnlegenSWIFT");
			}} catch (InterruptedException e) {
				e.printStackTrace();
			}}
}
