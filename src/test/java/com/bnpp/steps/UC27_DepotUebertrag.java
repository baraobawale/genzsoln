package com.bnpp.steps;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.apache.http.client.ClientProtocolException;
import org.json.simple.parser.ParseException;
import org.xml.sax.SAXException;

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
			commonActions.logPassStatus("Pass | Valid FromDepotNr displayed "+commonActions.getText("Uebertrag_von"));
		else
			commonActions.logFailStatus("Fail | Valid FromDepotNr display failed "+commonActions.getText("Uebertrag_von"));

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
		
		if (commonActions.getText("Stuecke").equals(commonActions.getValueFromJson("zu_uebertragende_Stueke")+" "))
			commonActions.logPassStatus("Pass | zu_uebertragende_Stueke display success");
		else
			commonActions.logFailStatus("Fail | zu_uebertragende_Stueke display fail");
	}

	@And("^Verify the message$")
	public void Verify_the_message() {

	}

	@And("^Verify the captured details from Depotuebertrag$")
	public void Verify_Captured_details() {

	}
	@And("^User submits generated TAN number using \"(.*?)\" on \"(.*?)\"$")
	public void User_Submits_generated_TAN_number_using(String mobiletanlink,String tanfield) throws InterruptedException, ClientProtocolException, IOException, ParserConfigurationException, SAXException, ParseException{
		commonActions.clickonMobiletanLinkandEnterTan(mobiletanlink, tanfield);
		
	}
			
	

}
