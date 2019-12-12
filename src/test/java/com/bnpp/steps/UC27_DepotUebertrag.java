package com.bnpp.steps;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.StaleElementReferenceException;

import com.bnpp.library.CommonActions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class UC27_DepotUebertrag {
	CommonActions commonActions;
	String CapturedOrderart;
	String CapturedWKN;
	String CapturedHandelsplatz;
	String CapturedStueck_Betrag;
	String message;
	String ort;
	String Handelsplatz;
	String WKN;
	String Stueck_Betrag;
	String Nominal_Betrag;
	String CapturedNominalBetrag;

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

	@When("Capture entered details on OrderErteilen_kauf")
	public void capture_entered_details_on_OrderErteilen_kauf() {
		try {
			Thread.sleep(7000);
			CapturedOrderart = commonActions.getText("CapturedAnleihe_OrderArt");
			CapturedWKN = commonActions.getText("CapturedAnleihe_WKN");
			CapturedHandelsplatz = commonActions.getText("CapturedAnleihe_Handelsplatz");
			CapturedStueck_Betrag = commonActions.getText("CapturedAnleihe_Stueck_Betrag");
			System.out.println("CapturedStueck_Betrag: " + CapturedStueck_Betrag);
			System.out.println("CapturedOrderart: " + CapturedOrderart);
			System.out.println("CapturedWKN: " + CapturedWKN);
			System.out.println("CapturedHandelsplatz: " + CapturedHandelsplatz);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@When("Capture Message on OrderErteilen_kauf")
	public void capture_Message_on_OrderErteilen_kauf() {
		try {
			message = commonActions.getText("CapturedMessageKauf");
			System.out.println("Message CAPTURED: " + message);

		} catch (StaleElementReferenceException e) {
			e.printStackTrace();
			System.out.println("Element not Captured");
		} catch (Exception e) {
			System.out.println("Message NOT CAPTURED");
			e.printStackTrace();
			// commonActions.logAssert_Fail("Message NOT CAPTURED");
		}
	}

	@Then("Verify {string},{string},{string},{string},{string} on OrderUebersicht_kauf")
	public void verify_on_OrderUebersicht_kauf(String string, String string2, String string3, String string4, String string5) {
		ort = commonActions.getText("Verify_OrderartTable");
		Handelsplatz = commonActions.getText("Verify_Handelsplatz_table");
		WKN = commonActions.getText("Verify_WKN_table");
		System.out.println("Verify_Orderart:" + ort);
		System.out.println("Verify_Handelsplatz:" + Handelsplatz);
		System.out.println("Verify_WKN:" + WKN);

		if (ort.equals(CapturedOrderart)) {
			System.out.println("Valid Ort value displayed");
			commonActions.logPassStatus("Pass | Valid Ort value displayed - " + ort);
		} else {
			System.out.println("ort print failed-");
			commonActions.logFailStatus("Fail | Valid Ort value display failed - " + ort);
		}
		if (Handelsplatz.equals(CapturedHandelsplatz)) {
			System.out.println("Valid Handelsplat value displayed");
			commonActions.logPassStatus("Pass | Valid Handelsplat value displayed - " + Handelsplatz);
		} else {
			System.out.println("Valid Handelsplat value display failed");
			commonActions.logFailStatus("Fail | Valid Handelsplat value display failed - " + Handelsplatz);
		}
		if (CapturedWKN.contains(WKN)) {
			System.out.println("Valid WKN value displayed");
			commonActions.logPassStatus("Pass | Valid WKN value displayed - " + WKN);
		} else {
			System.out.println("Valid WKN value display failed");
			commonActions.logFailStatus("Fail | Valid WKN value display failed - " + WKN);
		}
		Nominal_Betrag = commonActions.getText("Verify_StueckORNominal");
		System.out.println("Nominal_Betrag:" + Nominal_Betrag);
		if (Nominal_Betrag.equals(CapturedStueck_Betrag)) {
			System.out.println("Valid Stop NominalStueck_Betrag displayed");
			commonActions.logPassStatus("Pass | Valid Stop NominalStueck_Betrag displayed - " + Nominal_Betrag);
		} else {
			System.out.println("Valid NominalStueck_Betrag value display failed");
			commonActions.logFailStatus("Fail | Valid NominalStueck_Betrag value display failed - " + Nominal_Betrag);
		}

	}

	@Then("Verify captured details,Message from OrderErteilen_kauf")
	public void verify_captured_details_Message_from_OrderErteilen_kauf() {
		try {
			if (message.equals(commonActions.getValueFromJson("Message"))) {
				System.out.println("Message : " + message);
				commonActions.logPassStatus("Pass | Valid message displayed " + message);
			} else {
				System.out.println("Message verify failed");
				commonActions.logFailStatus("Fail | Valid message display failed" + message);

			}
		} catch (StaleElementReferenceException e) {
			e.printStackTrace();
			System.out.println("Element not Captured");
		} catch (Exception e) {
			e.printStackTrace();
			// commonActions.logAssert_Fail("Failure verifying data");
		}	}

}
