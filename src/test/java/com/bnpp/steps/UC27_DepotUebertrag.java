package com.bnpp.steps;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;

import com.bnpp.library.CommonActions;

import cucumber.api.java.en.And;

public class UC27_DepotUebertrag {
	CommonActions commonActions;

	public UC27_DepotUebertrag(CommonActions con) {
		this.commonActions = con;
	}

	@And("^Capture entered details on Depotuebertrag$")
	public void capture_entered_details() throws FileNotFoundException, IOException, ParseException {
		
		String forename = commonActions.getValueFromJson("Depotinhaber_Vorname");
		String surname = commonActions.getValueFromJson("Depotinhaber_Nachname");

		String compare = forename + " " + surname;
		if (compare.equals(commonActions.getText("VornameNachname")))
			commonActions.logPassStatus("Pass | Valid Vorname Nachname displayed");
		else
			commonActions.logFailStatus("Fail | Valid Vorname Nachname display failed "+compare);
					
		if (commonActions.getText("Depot-Nr").contains(commonActions.getValueFromJson("ToDepot_Nr")))
			commonActions.logPassStatus("Pass | Valid Depot-Nr displayed ");
		else
			commonActions.logFailStatus("Fail | Depot-Nr display fail");
		
		if (commonActions.getText("Stuecke").trim().equals(commonActions.getValueFromJson("zu_uebertragende_Stueke")))
			commonActions.logPassStatus("Pass | zu_uebertragende_Stueke display success");
		else
			commonActions.logFailStatus("Fail | zu_uebertragende_Stueke display fail");
		
		if (commonActions.getText("Uebertrag_von").contains(commonActions.getValueFromJson("FromDepot_Nr")))
			commonActions.logPassStatus("Pass | Valid FromDepotNr displayed "+commonActions.getText("Uebertrag_von"));
		else
			commonActions.logFailStatus("Fail | Valid FromDepotNr display failed "+commonActions.getText("Uebertrag_von"));		
	}

	@And("^Verify the message$")
	public void Verify_the_message() {

	}

	@And("^Verify the captured details from Depotuebertrag$")
	public void Verify_Captured_details() throws FileNotFoundException, IOException, ParseException {
		
	}
	@And("^User selects first option \"(.*?)\" in \"(.*?)\"$")
	public void User_selects_first_option(String dataKey,String locatorKey) throws Exception{
		commonActions.selectDropDownByIndex(locatorKey, "0");
	}

}
