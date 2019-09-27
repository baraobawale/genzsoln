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

	@And("^User click on \"(.*?)\" of \"(.*?)\"$")
	public void clicksEDITorDELETE(String locatorKey, String Created_Vorlagenname1) throws Exception {
		try {
			if (locatorKey.equals("Edit") && commonActions.getScenarioName().equals("Vorlagen_Aendern_IBAN"))
				locatorKey = "EditIBAN";
			if (locatorKey.equals("Edit") && commonActions.getScenarioName().equals("Vorlagen_Aendern_kontoBLZ"))
				locatorKey = "EditKontoBLZ";
			if (locatorKey.equals("Delete") && commonActions.getScenarioName().equals("Vorlagen_loeschen_IBAN")) {
				locatorKey = "DeleteIBAN";
				}
			if (locatorKey.equals("Delete") && commonActions.getScenarioName().equals("Vorlagen_loeschen_kontoBLZ"))
				locatorKey = "DeleteKontoBLZ";

			if (!commonActions.isElementPresent(locatorKey) && commonActions.isElementPresent("NextPage")) {
				commonActions.click("NextPage");
			}
			commonActions.click(locatorKey);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// @And("^User changes \"(.*?)\" in \"(.*?)\"$")
	// public void user_changes_in_field(String Betrag, String locatorKey)
	// throws Exception, InterruptedException, IOException, ParseException {
	// System.out.println("locatorKey+ " + locatorKey);
	// System.out.println("Betrag+ " + Betrag);
	//
	// commonActions.clearfield(locatorKey);
	// commonActions.enterText(locatorKey, Betrag);
	// }

	@And("^Capture Message on VorlageAnlegen$")
	public void Verify_Message_Ihre_Überweisungsvorlage_wurde_angelegt1()
			throws FileNotFoundException, IOException, ParseException {
		try {
			if (commonActions.getScenarioName().equals("IBANVorlagen_Anlegen")) {
				if (commonActions.getText("Ihre_Überweisungsvorlage_wurde")
						.equals(commonActions.getValueFromJson("Message")))
					commonActions.logPassStatus("IBAN create success");
				else
					commonActions.logAssert_Fail("IBAN create fail");
			}
			if (commonActions.getScenarioName().equals("KontoBLZVorlagen_Anlegen")) {
				if (commonActions.getText("Ihre_Überweisungsvorlage_wurde")
						.equals(commonActions.getValueFromJson("Message")))
					commonActions.logPassStatus("KontoBLZ create success");
				else
					commonActions.logAssert_Fail("KontoBLZ create fail");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Then("^Verify IBAN update message$")
	public void Verify_Message_Ihre_Überweisungsvorlage_wurde_angelegt3() {
		try {
			if (commonActions.getText("Ihre_Überweisungsvorlage_wurde")
					.contains("Ihre Überweisungsvorlage wurde gespeichert"))
				commonActions.logPassStatus("IBAN update success");
			else
				commonActions.logAssert_Fail("IBAN update fail");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// IBAN/KontoBLZ delete
	@Then("^Verify Message on Vorlageloeschen$")
	public void Verify_Message_Ihre_Überweisungsvorlage_wurde_angelegt6()
			throws FileNotFoundException, IOException, ParseException {
		try {
			if (commonActions.getScenarioName().equals("Vorlagen_loeschen_IBAN")) {
				System.out
						.println("Value from Page: " + commonActions.getText("Ihre_Überweisungsvorlage_wurde").trim());
				System.out.println("Value from Json: " + commonActions.getValueFromJson("Message"));
				if (commonActions.getText("Ihre_Überweisungsvorlage_wurde").trim()
						.equalsIgnoreCase(commonActions.getValueFromJson("Message")))
					commonActions.logPassStatus("IBANTemplate delete success");
				else
					commonActions.logAssert_Fail("IBANTemplate delete fail");
			} else if (commonActions.getScenarioName().equals("Vorlagen_loeschen_kontoBLZ")) {
				System.out
						.println("Value from Page: " + commonActions.getText("Ihre_Überweisungsvorlage_wurde").trim());
				System.out.println("Value from json: " + commonActions.getValueFromJson("Message"));
				if (commonActions.getText("Ihre_Überweisungsvorlage_wurde").trim()
						.equalsIgnoreCase(commonActions.getValueFromJson("Message")))
					commonActions.logPassStatus("KontoBLZTemplate delete success");
				else
					commonActions.logAssert_Fail("KontoBLZTemplate delete fail");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Then("^Verify KontoBLZ create message$")
	public void Verify_Message_Ihre_Überweisungsvorlage_wurde_angelegt2() {
		try {
			if (commonActions.getText("Ihre_Überweisungsvorlage_wurde")
					.contains("Ihre Überweisungsvorlage wurde angelegt"))
				commonActions.logPassStatus("KontoBLZ create success");
			else
				commonActions.logAssert_Fail("KontoBLZ create failed");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// Update IBAN, KontoBLZ
	@Then("^Verify Message,details on VorlageAendern$")
	public void Verify_Message_Ihre_Überweisungsvorlage_wurde_angelegt4()
			throws FileNotFoundException, IOException, ParseException {
		try {
			if (commonActions.getScenarioName().equals("Vorlagen_Aendern_IBAN")) {
				String UpdateMessageFromPage = commonActions.getText("Ihre_Überweisungsvorlage_wurde");
				String UpdateMessageFromJson = commonActions.getValueFromJson("Message");

				if (UpdateMessageFromPage.equals(UpdateMessageFromJson))

					commonActions.logPassStatus("IBAN update success");
			
				else
					commonActions.logAssert_Fail("IBAN update failed");

				String BetragUpdateValueFromPage = commonActions.getText("BetragIBANCaptureScreen");
				String BetragUpdateValueFromJson = commonActions.getValueFromJson("Betrag") + " EUR";

				if (BetragUpdateValueFromPage.equals(BetragUpdateValueFromJson))
					commonActions.logPassStatus("Betrag_IBAN update success");
				else
					commonActions.logFailStatus("Betrag_IBAN update fail");

			}
			if (commonActions.getScenarioName().equals("Vorlagen_Aendern_kontoBLZ")) {
				String UpdateMessageFromPage = commonActions.getText("Ihre_Überweisungsvorlage_wurde");
				String UpdateMessageFromJson = commonActions.getValueFromJson("Message");
				if (UpdateMessageFromPage.equals(UpdateMessageFromJson))
					commonActions.logPassStatus("KontoBLZ update message display success" + "Expected:"
							+ UpdateMessageFromJson + "Actual" + UpdateMessageFromJson);
				else
					commonActions.logAssert_Fail("KontoBLZ update message display failed");

				String BetragUpdateValueFromPage = commonActions.getText("BetragKontoBLZCaptureScreen");
				String BetragUpdateValueFromJson = commonActions.getValueFromJson("Betrag") + " EUR";
				if (BetragUpdateValueFromPage.equals(BetragUpdateValueFromJson))
					commonActions.logPassStatus("Betrag_KontoBLZ update success" + "Expected:"
							+ BetragUpdateValueFromPage + "Actual:" + BetragUpdateValueFromJson);
				else
					commonActions.logFailStatus("Betrag_KontoBLZ update fail");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// KontoBLZDelete
	@Then("^Verify Message on Vorlageloeschen1$")
	public void Verify_Message_Ihre_Überweisungsvorlage_wurde_angelegt5() {
		try {
			if (commonActions.getText("Ihre_Überweisungsvorlage_wurde")
					.contains("Ihre Überweisungsvorlage wurde gelöscht"))
				commonActions.logPassStatus("KontoBLZ delete success");
			else
				commonActions.logAssert_Fail("KontoBLZ delete failed");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@And("^Capture entered details on VorlageAnlegen$")
	public void capture_details_on_VorlageAnlegen() throws Exception, IOException, ParseException {
		try {
			commonActions.moveScrollDown();
			if (commonActions.getScenarioName().equals("IBANVorlagen_Anlegen")) {

				if (commonActions.getText("VorlagenameIBANCaptureScreen")
						.equals(commonActions.getValueFromJson("Vorlagenname")))
					commonActions.logPassStatus("Vorlagename_IBAN verify success on VorlageAnlegen");
				else
					commonActions.logFailStatus("Vorlagename_IBAN verify fail on VorlageAnlegen");

				if (commonActions.getText("NameIBANCaptureScreen").equals(commonActions.getValueFromJson("Name")))
					commonActions.logPassStatus("Name_IBAN verify success on VorlageAnlegen");
				else
					commonActions.logFailStatus("Name_IBAN verify fail on VorlageAnlegen");

				if (commonActions.getText("BetragIBANCaptureScreen")
						.equals((commonActions.getValueFromJson("Betrag") + ",00 EUR")))
					commonActions.logPassStatus("Betrag_IBAN verify success on VorlageAnlegen");
				else
					commonActions.logFailStatus("Betrag_IBAN verify fail on VorlageAnlegen");
			}
			if (commonActions.getScenarioName().equals("KontoBLZVorlagen_Anlegen")) {

				if (commonActions.getText("VorlagenameKontoBLZCaptureScreen")
						.equals(commonActions.getValueFromJson("Vorlagenname")))
					commonActions.logPassStatus("Vorlagename_KontoBLZ verify success on VorlageAnlegen");
				else
					commonActions.logFailStatus("Vorlagename_KontoBLZ verify fail on VorlageAnlegen");

				if (commonActions.getText("NameKontoBLZCaptureScreen").equals(commonActions.getValueFromJson("Name")))
					commonActions.logPassStatus("Name_KontoBLZ verify success on VorlageAnlegen");
				else
					commonActions.logFailStatus("Name_KontoBLZ verify fail on VorlageAnlegen");

				if (commonActions.getText("BetragKontoBLZCaptureScreen")
						.equals((commonActions.getValueFromJson("Betrag") + ",00 EUR")))
					commonActions.logPassStatus("Betrag_KontoBLZ verify success on VorlageAnlegen");
				else
					commonActions.logFailStatus("Betrag_KontoBLZ verify fail on VorlageAnlegen");
			} /////// Update
			if (commonActions.getScenarioName().equals("Vorlagen_Aendern_IBAN")) {
				if (commonActions.getText("Ihre_Überweisungsvorlage_wurde")
						.equals(commonActions.getValueFromJson("Message")))
					commonActions.logPassStatus("IBAN update success");
				else
					commonActions.logAssert_Fail("IBAN update fail");

				if (commonActions.getText("BetragIBANCaptureScreen")
						.equals((commonActions.getValueFromJson("Betrag") + ", EUR")))
					commonActions.logPassStatus("Betrag_IBAN update success on VorlageAnlegen");
				else
					commonActions.logFailStatus("Betrag_IBAN update fail on VorlageAnlegen");
			}
			if (commonActions.getScenarioName().equals("Vorlagen_Aendern_kontoBLZ")) {
				if (commonActions.getText("Ihre_Überweisungsvorlage_wurde")
						.equals(commonActions.getValueFromJson("Message")))
					commonActions.logPassStatus("KontoBLZ update success message displayed");
				else
					commonActions.logAssert_Fail("KontoBLZ update success message display fail");

				if (commonActions.getText("BetragKontoBLZCaptureScreen")
						.equals((commonActions.getValueFromJson("Betrag") + ", EUR")))
					commonActions.logPassStatus("Betrag_KontoBLZ update success on VorlageAnlegen");
				else
					commonActions.logFailStatus("Betrag_KontoBLZ update fail on VorlageAnlegen");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Then("^Verify \"(.*?)\",\"(.*?)\" on  UmsaetzeZahlungsverkehr$")
	public void Verify_Vorlagenname_IBAN_oder_Kontonummer(String Vorlagenname, String IBAN_oder_Kontonummer)
			throws Exception, IOException, ParseException {

		try {
			String VorlagennameFromJson = commonActions.getKeyFromJson("Vorlagenname");
			System.out.println("VorlagennameFromJson:" + VorlagennameFromJson);
			System.out.println("VorlagennameFromPage:" + commonActions.getAttribute("CustomerNameIBAN", "title"));
			Thread.sleep(10000);

			if (commonActions.getScenarioName().equals("IBANVorlagen_Anlegen")) {
				if (!commonActions.isElementPresent("CustomerNameIBAN") && commonActions.isElementPresent("NextPage"))
					commonActions.click("NextPage");

				if (VorlagennameFromJson.equals(commonActions.getAttribute("CustomerNameIBAN", "title")))
					commonActions
							.logPassStatus("VorlagennameIBANAccount verified save success on UmsaetzeZahlungsverkehr");
				else
					commonActions
							.logFailStatus("VorlagennameIBANAccount verified save fail on UmsaetzeZahlungsverkehr");

				String IBAN_oder_KontonummerFromJson = commonActions.getKeyFromJson("IBAN_oder_Kontonummer")
						.replaceAll("\\s", "");
				System.out.println("IBAN_oder_KontonummerFromJson:" + IBAN_oder_KontonummerFromJson);
				System.out.println("IBAN_oder_KontonummerFromPage:"
						+ commonActions.getAttribute("IBAN_oder_KontonummerIBAN", "title"));

				if (IBAN_oder_KontonummerFromJson
						.equals(commonActions.getAttribute("IBAN_oder_KontonummerIBAN", "title")))
					commonActions.logPassStatus(
							"IBAN_oder_KontonummerIBANAccount verified save success on UmsaetzeZahlungsverkehr");
				else
					commonActions.logFailStatus(
							"IBAN_oder_KontonummerIBANAccount verified save fail on UmsaetzeZahlungsverkehr");

			}
			if (commonActions.getScenarioName().equals("KontoBLZVorlagen_Anlegen")) {
				if (!commonActions.isElementPresent("CustomerNameKontoBLZ")
						&& commonActions.isElementPresent("NextPage"))
					commonActions.click("NextPage");
				if (VorlagennameFromJson.equals(commonActions.getAttribute("CustomerNameKontoBLZ", "title")))
					commonActions
							.logPassStatus("VorlagennameIBANAccount verified save success on UmsaetzeZahlungsverkehr");
				else
					commonActions
							.logFailStatus("VorlagennameIBANAccount verified save fail on UmsaetzeZahlungsverkehr");

				String IBAN_oder_KontonummerFromJson = commonActions.getKeyFromJson("IBAN_oder_Kontonummer")
						.replaceAll("\\s", "");
				IBAN_oder_KontonummerFromJson = "DE33" + commonActions.getValueFromJson("BLZ")
						+ IBAN_oder_KontonummerFromJson;
				System.out.println("IBAN_oder_KontonummerFromJson:" + IBAN_oder_KontonummerFromJson);
				System.out.println("IBAN_oder_KontonummerFromPage:"
						+ commonActions.getAttribute("IBAN_oder_KontonummerKontoBLZ", "title"));

				if (IBAN_oder_KontonummerFromJson
						.equals(commonActions.getAttribute("IBAN_oder_KontonummerKontoBLZ", "title")))
					commonActions.logPassStatus(
							"IBAN_oder_KontonummerIBANAccount verified save success on UmsaetzeZahlungsverkehr");
				else
					commonActions.logFailStatus(
							"IBAN_oder_KontonummerIBANAccount verified save fail on UmsaetzeZahlungsverkehr");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@And("^Verify captured details,Message from VorlageAnlegen$")
	public void Verify_catured_details() {

	}

}
