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

	@When("User select Art_der_Ueberweisung in ArtDerUeberweisung_UeberweisungAnlegen")
	public void user_select_Art_der_Ueberweisung_in_ArtDerUeberweisung_UeberweisungAnlegen() {
		if (commonActions.getScenarioName().equals("Ueberweisung_Anlegen_SWIFT"))
		{
			try {
				commonActions.click("ArtDerUeberweisung_UeberweisungAnlegen_SWIFT");
			} catch (InterruptedException e) {
				e.printStackTrace();    }		
			}
			else 
			{
				try {
					commonActions.click("ArtDerUeberweisung_UeberweisungAnlegen_SEPA");
				} catch (InterruptedException e) {
					e.printStackTrace();    }	
			}
	}
	
	@Then("Verify details,Message on UeberweisungAnlegen")
	public void verify_details_Message_on_UeberweisungAnlegen() throws FileNotFoundException, IOException, ParseException {
		String str = commonActions.checkGermanCharacters(commonActions.getValueFromJson("Message"));	
		CaptureMsgUeberweisangSEPA = commonActions.getText("CaptureMsgUeberweisangSEPA");
		if(str.equals(CaptureMsgUeberweisangSEPA)) {
			commonActions.logPassStatus("Pass | Valid Messge displayed -"+CaptureMsgUeberweisangSEPA);
		   }	
		else {
			commonActions.logFailStatus("Error | Valid Messge display failed -"+CaptureMsgUeberweisangSEPA);
		     }  
	}
	
	@When("User select Ausfuehrung in Ausfuehrung_UeberweisungAnlegen")
	public void user_select_Ausfuehrung_in_Ausfuehrung_UeberweisungAnlegen() {
	if (commonActions.getScenarioName().equals("Ueberweisung_Anlegen_SEPA")) {
		try {
			commonActions.click("Ausfuehrung_UeberweisungAnlegenSEPA");
		} catch (InterruptedException e) {		
			e.printStackTrace();
		}
	  }
	}
	
	@When("User select Gebuehrenregelung in Gebuehrenregelung_UeberweisungAnlegen")
	public void user_select_Gebuehrenregelung_in_Gebuehrenregelung_UeberweisungAnlegen() {
		if (commonActions.getScenarioName().equals("Ueberweisung_Anlegen_SWIFT")) {
			try {
				commonActions.click("Gebuehrenregelung_UeberweisungAnlegenSWIFT");
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		  } 
	}
}
