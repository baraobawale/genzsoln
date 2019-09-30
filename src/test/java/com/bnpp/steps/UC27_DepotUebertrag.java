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
		System.out.println("ABC:::" + commonActions.getText("Uebertrag_von"));
		// System.out.println("ToDepot_Nr
		// :"+commonActions.getText("Bankleitzahl"));

		if (commonActions.getText("Uebertrag_von").contains(commonActions.getValueFromJson("FromDepot_Nr")))
			commonActions.logPassStatus("Uebertrag_von/From	Depot_Nr display success");
		else
			commonActions.logPassStatus("Uebertrag_von/From	Depot_Nr display fail");

		String forename = commonActions.getValueFromJson("Depotinhaber_Vorname");
		String surname = commonActions.getValueFromJson("Depotinhaber_Nachname");

		String compare = forename + " " + surname;
		if (compare.equals(commonActions.getText("VornameNachname")))
			commonActions.logPassStatus("Vorname Nachname display success");
		else
			commonActions.logFailStatus("Vorname Nachname display fail");
					commonActions.logPassStatus("Stuecke display fail");
		if (commonActions.getText("Depot-Nr").contains(commonActions.getValueFromJson("ToDepot_Nr")))
			commonActions.logPassStatus("Depot-Nr display success");
		else
			commonActions.logPassStatus("Depot-Nr display fail");
		if (commonActions.getText("Stuecke").equals(commonActions.getValueFromJson("zu_uebertragende_Stueke")))
			commonActions.logPassStatus("zu_uebertragende_Stueke display success");
		else
			commonActions.logPassStatus("zu_uebertragende_Stueke display fail");
	}

	@And("^Verify the message$")
	public void Verify_the_message() {

	}

	@And("^Verify the captured details from Depotuebertrag$")
	public void Verify_Captured_details() {

	}

}
