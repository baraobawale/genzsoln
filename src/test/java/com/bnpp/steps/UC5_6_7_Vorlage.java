package com.bnpp.steps;

import java.io.FileNotFoundException;
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
	public void clicksEDITorDELETE(String locatorKey, String Created_Vorlagenname1) throws Exception {
		if (locatorKey.equals("Edit") && commonActions.getScenarioName().equals("Vorlagen_Aendern_IBAN"))
			locatorKey = "EditIBAN";
		if (locatorKey.equals("Edit") && commonActions.getScenarioName().equals("Vorlagen_Aendern_kontoBLZ"))
			locatorKey = "EditKontoBLZ";
		if (locatorKey.equals("Delete") && commonActions.getScenarioName().equals("Vorlagen_loeschen_IBAN"))
			locatorKey = "DeleteIBAN";
		if (locatorKey.equals("Delete") && commonActions.getScenarioName().equals("Vorlagen_loeschen_kontoBLZ"))
			locatorKey = "DeleteKontoBLZ";
		commonActions.click(locatorKey);

	}

	@And("^User changes \"(.*?)\" in \"(.*?)\"$")
	public void user_changes_in_field(String Betrag, String locatorKey)
			throws Exception, InterruptedException, IOException, ParseException {
		System.out.println("locatorKey+  " + locatorKey);
		System.out.println("Betrag+  " + Betrag);

		commonActions.clearfield(locatorKey);
		commonActions.enterText(locatorKey, Betrag);
	}

	@And("^Capture Message on VorlageAnlegen$")
	public void Verify_Message_Ihre_Überweisungsvorlage_wurde_angelegt1() {

	}

	@Then("^Verify IBAN update message$")
	public void Verify_Message_Ihre_Überweisungsvorlage_wurde_angelegt3() {
		if (commonActions.getText("Ihre_Überweisungsvorlage_wurde")
				.contains("Ihre Überweisungsvorlage wurde gespeichert"))
			commonActions.logPassStatus("IBAN update success");
		else
			commonActions.logAssert_Fail("IBAN update fail");

	}

	// IBAN/KontoBLZ delete
	@Then("^Verify Message on Vorlageloeschen$")
	public void Verify_Message_Ihre_Überweisungsvorlage_wurde_angelegt6() throws FileNotFoundException, IOException, ParseException {
		if(commonActions.getScenarioName().equals("Vorlagen_loeschen_IBAN")){
			System.out.println("Value from Page: "+commonActions.getText("Ihre_Überweisungsvorlage_wurde").trim());
			System.out.println("Value from Json: "+commonActions.getValueFromJson("Message"));
		if (commonActions.getText("Ihre_Überweisungsvorlage_wurde").trim().equalsIgnoreCase(commonActions.getValueFromJson("Message")))
			commonActions.logPassStatus("IBANTemplate delete success");
		else
			commonActions.logAssert_Fail("IBANTemplate delete fail");
		}
		else if (commonActions.getScenarioName().equals("Vorlagen_loeschen_kontoBLZ")){
			System.out.println("Value from Page: "+commonActions.getText("Ihre_Überweisungsvorlage_wurde").trim());
			System.out.println("Value from json: "+commonActions.getValueFromJson("Message"));
			if (commonActions.getText("Ihre_Überweisungsvorlage_wurde").trim().equalsIgnoreCase(commonActions.getValueFromJson("Message")))
				commonActions.logPassStatus("KontoBLZTemplate delete success");
			else
				commonActions.logAssert_Fail("KontoBLZTemplate delete fail");
		}
	}

	@Then("^Verify KontoBLZ create message$")
	public void Verify_Message_Ihre_Überweisungsvorlage_wurde_angelegt2() {
		if (commonActions.getText("Ihre_Überweisungsvorlage_wurde").contains("Ihre Überweisungsvorlage wurde angelegt"))
			commonActions.logPassStatus("KontoBLZ create success");
		else
			commonActions.logAssert_Fail("KontoBLZ create failed");

	}

	@Then("^Verify KontoBLZ update message$")
	public void Verify_Message_Ihre_Überweisungsvorlage_wurde_angelegt4() {
		if (commonActions.getText("Ihre_Überweisungsvorlage_wurde")
				.contains("Ihre Überweisungsvorlage wurde gespeichert"))
			commonActions.logPassStatus("KontoBLZ update success");
		else
			commonActions.logAssert_Fail("KontoBLZ update failed");
	}

	// KontoBLZDelete
	@Then("^Verify Message on Vorlageloeschen1$")
	public void Verify_Message_Ihre_Überweisungsvorlage_wurde_angelegt5() {
		if (commonActions.getText("Ihre_Überweisungsvorlage_wurde").contains("Ihre Überweisungsvorlage wurde gelöscht"))
			commonActions.logPassStatus("KontoBLZ delete success");
		else
			commonActions.logAssert_Fail("KontoBLZ delete failed");

	}

	@And("^Capture entered details on VorlageAnlegen$")
	public void capture_details_on_VorlageAnlegen() throws Exception, IOException, ParseException {

		if (commonActions.getText("Ihre_Überweisungsvorlage_wurde").contains("Ihre Überweisungsvorlage wurde angelegt"))
			commonActions.logPassStatus("IBAN create success");
		else
			commonActions.logAssert_Fail("IBAN create fail");

		if (commonActions.isElementPresent("VorlagenameIBANCaptureScreen"))
			commonActions.logPassStatus("Vorlagename_IBAN verify success on VorlageAnlegen");
		else
			commonActions.logFailStatus("Vorlagename_IBAN verify fail on VorlageAnlegen");

		if (commonActions.isElementPresent("NameIBANCaptureScreen"))
			commonActions.logPassStatus("Name_IBAN verify success on VorlageAnlegen");
		else
			commonActions.logFailStatus("Name_IBAN verify fail on VorlageAnlegen");

		if (commonActions.isElementPresent("BetragIBANCaptureScreen"))
			commonActions.logPassStatus("Betrag_IBAN verify success on VorlageAnlegen");
		else
			commonActions.logFailStatus("Betrag_IBAN verify fail on VorlageAnlegen");

	}

	@Then("^Verify \"(.*?)\",\"(.*?)\" on  UmsaetzeZahlungsverkehr$")
	public void Verify_Vorlagenname_IBAN_oder_Kontonummer(String Vorlagenname, String IBAN_oder_Kontonummer)
			throws Exception, IOException, ParseException {

		String VorlagennameFromJson = commonActions.getKeyFromJson("Vorlagenname");
		System.out.println("VorlagennameFromJson:" + VorlagennameFromJson);
		System.out.println("VorlagennameFromPage:" + commonActions.getAttribute("CustomerNameIBAN", "title"));
		Thread.sleep(10000);

		if (commonActions.getScenarioName().equals("IBANVorlagen_Anlegen")) {
			if (VorlagennameFromJson.equals(commonActions.getAttribute("CustomerNameIBAN", "title")))
				commonActions.logPassStatus("VorlagennameIBANAccount verified save success on UmsaetzeZahlungsverkehr");
			else
				commonActions.logFailStatus("VorlagennameIBANAccount verified save fail on UmsaetzeZahlungsverkehr");

			String IBAN_oder_KontonummerFromJson = commonActions.getKeyFromJson("IBAN_oder_Kontonummer")
					.replaceAll("\\s", "");
			System.out.println("IBAN_oder_KontonummerFromJson:" + IBAN_oder_KontonummerFromJson);
			System.out.println("IBAN_oder_KontonummerFromPage:"
					+ commonActions.getAttribute("IBAN_oder_KontonummerIBAN", "title"));

			if (IBAN_oder_KontonummerFromJson.equals(commonActions.getAttribute("IBAN_oder_KontonummerIBAN", "title")))
				commonActions.logPassStatus("IBAN_oder_KontonummerIBANAccount verified save success on UmsaetzeZahlungsverkehr");
			else
				commonActions.logFailStatus("IBAN_oder_KontonummerIBANAccount verified save fail on UmsaetzeZahlungsverkehr");

		}
		if(commonActions.getScenarioName().equals("KontoBLZVorlagen_Anlegen")){
			if (VorlagennameFromJson.equals(commonActions.getAttribute("CustomerNameKontoBLZ", "title")))
				commonActions.logPassStatus("VorlagennameIBANAccount verified save success on UmsaetzeZahlungsverkehr");
			else
				commonActions.logFailStatus("VorlagennameIBANAccount verified save fail on UmsaetzeZahlungsverkehr");

			String IBAN_oder_KontonummerFromJson = commonActions.getKeyFromJson("IBAN_oder_Kontonummer")
					.replaceAll("\\s", "");
			System.out.println("IBAN_oder_KontonummerFromJson:" + IBAN_oder_KontonummerFromJson);
			System.out.println("IBAN_oder_KontonummerFromPage:"
					+ commonActions.getAttribute("IBAN_oder_KontonummerIBAN", "title"));

			if (IBAN_oder_KontonummerFromJson.equals(commonActions.getAttribute("IBAN_oder_KontonummerKontoBLZ", "title")))
				commonActions.logPassStatus("IBAN_oder_KontonummerIBANAccount verified save success on UmsaetzeZahlungsverkehr");
			else
				commonActions.logFailStatus("IBAN_oder_KontonummerIBANAccount verified save fail on UmsaetzeZahlungsverkehr");
		}
	}

	@And("^Verify captured details,Message from VorlageAnlegen$")
	public void Verify_catured_details() {

	}

}
