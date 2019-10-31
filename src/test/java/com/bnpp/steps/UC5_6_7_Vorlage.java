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
			if (commonActions.getFeatureName().equals("UC5_6_7_Vorlage")) {
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
			}
			if (commonActions.getFeatureName().equals("UC17_18_19_20_21_TradingKauf")) {
				if (commonActions.getScenarioName().equals("KaufOrder_Loeschen_Aktie") && locatorKey.equals("Delete"))
					locatorKey = "DeleteAktie";
				if (commonActions.getScenarioName().equals("KaufOrder_Loeschen_Aktie") && locatorKey.equals("Delete"))
					locatorKey = "DeleteFonds";
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
					commonActions.logPassStatus("Pass | Valid message displayed - "
							+ commonActions.getText("Ihre_Überweisungsvorlage_wurde"));
				else
					commonActions.logFailStatus("Fail | Valid message display failed - "
							+ commonActions.getText("Ihre_Überweisungsvorlage_wurde"));
			}
			if (commonActions.getScenarioName().equals("KontoBLZVorlagen_Anlegen")) {
				if (commonActions.getText("Ihre_Überweisungsvorlage_wurde")
						.equals(commonActions.getValueFromJson("Message")))
					commonActions.logPassStatus("Pass | Valid message displayed - "
							+ commonActions.getText("Ihre_Überweisungsvorlage_wurde"));
				else
					commonActions.logFailStatus("Fail | Valid message display failed - "
							+ commonActions.getText("Ihre_Überweisungsvorlage_wurde"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			commonActions.logAssert_Fail("Fail | Valid message display failed");
		}
	}

	@Then("^Verify IBAN update message$")
	public void Verify_Message_Ihre_Überweisungsvorlage_wurde_angelegt3() {
		try {
			if (commonActions.getText("Ihre_Überweisungsvorlage_wurde")
					.contains("Ihre Überweisungsvorlage wurde gespeichert"))
				commonActions.logPassStatus(
						"Pass | Valid message displayed - " + commonActions.getText("Ihre_Überweisungsvorlage_wurde"));
			else
				commonActions.logAssert_Fail("Fail | Valid message display failed - "
						+ commonActions.getText("Ihre_Überweisungsvorlage_wurde"));
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
						.equals(commonActions.getValueFromJson("Message")))
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
				commonActions.logPassStatus(
						"Pass | Valid message displayed - " + commonActions.getText("Ihre_Überweisungsvorlage_wurde"));
			else
				commonActions.logAssert_Fail("Fail | Valid message display failed - "
						+ commonActions.getText("Ihre_Überweisungsvorlage_wurde"));
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
					commonActions.logPassStatus("Pass | Valid message displayed- " + UpdateMessageFromPage);
				else
					commonActions.logFailStatus("Fail | Valid message display failed - " + UpdateMessageFromPage);

				String BetragUpdateValueFromPage = commonActions.getText("BetragIBANCaptureScreen");
				String BetragUpdateValueFromJson = commonActions.getValueFromJson("Betrag") + " EUR";

				if (BetragUpdateValueFromPage.equals(BetragUpdateValueFromJson))
					commonActions.logPassStatus("Pass | Valid Betrag updated- " + BetragUpdateValueFromPage);
				else
					commonActions.logFailStatus("Fail | Valid Betrag update failed - " + BetragUpdateValueFromPage);

			}
			if (commonActions.getScenarioName().equals("Vorlagen_Aendern_kontoBLZ")) {
				String UpdateMessageFromPage = commonActions.getText("Ihre_Überweisungsvorlage_wurde");
				String UpdateMessageFromJson = commonActions.getValueFromJson("Message");
				if (UpdateMessageFromPage.equals(UpdateMessageFromJson))
					commonActions.logPassStatus("Pass | Valid message displayed- " + UpdateMessageFromPage);
				else
					commonActions.logFailStatus("Fail | Valid message display failed - " + UpdateMessageFromPage);

				String BetragUpdateValueFromPage = commonActions.getText("BetragKontoBLZCaptureScreen");
				String BetragUpdateValueFromJson = commonActions.getValueFromJson("Betrag") + " EUR";
				if (BetragUpdateValueFromPage.equals(BetragUpdateValueFromJson))
					commonActions.logPassStatus("Pass | Valid Betrag updated - " + BetragUpdateValueFromPage);
				else
					commonActions.logAssert_Fail("Fail | Valid Betrag update failed - " + BetragUpdateValueFromPage);
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
				commonActions.logPassStatus(
						"Pass | Valid message displayed - " + commonActions.getText("Ihre_Überweisungsvorlage_wurde"));
			else
				commonActions.logFailStatus(
						"Fail | Valid message displayed - " + commonActions.getText("Ihre_Überweisungsvorlage_wurde"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@And("^Capture entered details on VorlageAnlegen$")
	public void capture_details_on_VorlageAnlegen() throws Exception, IOException, ParseException {
		try {
			if (commonActions.getScenarioName().equals("IBANVorlagen_Anlegen")) {

				if (commonActions.getText("VorlagenameIBANCaptureScreen")
						.equals(commonActions.getValueFromJson("Vorlagenname")))
					commonActions.logPassStatus("Pass | Valid Vorlagename displayed - "
							+ commonActions.getText("VorlagenameIBANCaptureScreen"));
				else
					commonActions.logFailStatus("Fail | Valid Vorlagename display failed - "
							+ commonActions.getText("VorlagenameIBANCaptureScreen"));

				if (commonActions.getText("NameIBANCaptureScreen").equals(commonActions.getValueFromJson("Name")))
					commonActions.logPassStatus(
							"Pass | Valid name displayed - " + commonActions.getText("NameIBANCaptureScreen"));
				else
					commonActions.logFailStatus(
							"Fail | Valid name display failed - " + commonActions.getText("NameIBANCaptureScreen"));

				if (commonActions.getText("BetragIBANCaptureScreen")
						.equals((commonActions.getValueFromJson("Betrag") + ",00 EUR")))
					commonActions.logPassStatus(
							"Pass | Valid betrag displayed - " + commonActions.getText("BetragIBANCaptureScreen"));
				else
					commonActions.logFailStatus(
							"Fail | Valid betrag display failed - " + commonActions.getText("BetragIBANCaptureScreen"));
			}
			if (commonActions.getScenarioName().equals("KontoBLZVorlagen_Anlegen")) {

				if (commonActions.getText("VorlagenameKontoBLZCaptureScreen")
						.equals(commonActions.getValueFromJson("Vorlagenname")))
					commonActions.logPassStatus("Pass | Valid Vorlagename displayed - "
							+ commonActions.getText("VorlagenameKontoBLZCaptureScreen"));
				else
					commonActions.logFailStatus("Fail | Valid Vorlagename display failed - "
							+ commonActions.getText("VorlagenameKontoBLZCaptureScreen"));

				if (commonActions.getText("NameKontoBLZCaptureScreen").equals(commonActions.getValueFromJson("Name")))
					commonActions.logPassStatus(
							"Pass | Valid name displayed - " + commonActions.getText("NameKontoBLZCaptureScreen"));
				else
					commonActions.logFailStatus(
							"Fail | Valid name display failed - " + commonActions.getText("NameKontoBLZCaptureScreen"));

				if (commonActions.getText("BetragKontoBLZCaptureScreen")
						.equals((commonActions.getValueFromJson("Betrag") + ",00 EUR")))
					commonActions.logPassStatus(
							"Pass | Valid betrag displayed - " + commonActions.getText("BetragKontoBLZCaptureScreen"));
				else
					commonActions.logFailStatus("Fail | Valid betrag display failed - "
							+ commonActions.getText("BetragKontoBLZCaptureScreen"));
			} /////// Update
			if (commonActions.getScenarioName().equals("Vorlagen_Aendern_IBAN")) {
				if (commonActions.getText("Ihre_Überweisungsvorlage_wurde")
						.equals(commonActions.getValueFromJson("Message")))
					commonActions.logPassStatus("Pass | Valid message displayed - "
							+ commonActions.getText("Ihre_Überweisungsvorlage_wurde"));
				else
					commonActions.logFailStatus("Fail | Valid message display failed - "
							+ commonActions.getText("Ihre_Überweisungsvorlage_wurde"));

				if (commonActions.getText("BetragIBANCaptureScreen")
						.equals((commonActions.getValueFromJson("Betrag") + ", EUR")))
					commonActions.logPassStatus(
							"Pass | Valid betrag displayed - " + commonActions.getText("BetragIBANCaptureScreen"));
				else
					commonActions.logFailStatus(
							"Fail | Valid betrag display failed - " + commonActions.getText("BetragIBANCaptureScreen"));
			}
			if (commonActions.getScenarioName().equals("Vorlagen_Aendern_kontoBLZ")) {
				if (commonActions.getText("Ihre_Überweisungsvorlage_wurde")
						.equals(commonActions.getValueFromJson("Message")))
					commonActions.logPassStatus("Pass | Valid message displayed - "
							+ commonActions.getText("Ihre_Überweisungsvorlage_wurde"));
				else
					commonActions.logFailStatus("Fail | Valid message displayed - "
							+ commonActions.getText("Ihre_Überweisungsvorlage_wurde"));

				if (commonActions.getText("BetragKontoBLZCaptureScreen")
						.equals((commonActions.getValueFromJson("Betrag") + ", EUR")))
					commonActions.logPassStatus(
							"Pass | Valid betrag displayed - " + commonActions.getText("BetragIBANCaptureScreen"));
				else
					commonActions.logFailStatus(
							"Fail | Valid betrag display failed - " + commonActions.getText("BetragIBANCaptureScreen"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			commonActions.logAssert_Fail("Fail | Valid values display failed");
		}

	}

	@Then("^Verify \"(.*?)\",\"(.*?)\" on  UmsaetzeZahlungsverkehr$")
	public void Verify_Vorlagenname_IBAN_oder_Kontonummer(String Vorlagenname, String IBAN_oder_Kontonummer)
			throws Exception, IOException, ParseException {

		try {
			commonActions.moveScrollDown();
			String VorlagennameFromJson = commonActions.getKeyFromJson("Vorlagenname");
			System.out.println("VorlagennameFromJson:" + VorlagennameFromJson);
			System.out.println("VorlagennameFromPage:" + commonActions.getAttribute("CustomerNameIBAN", "title"));
			Thread.sleep(10000);

			if (commonActions.getScenarioName().equals("IBANVorlagen_Anlegen")) {
				if (!commonActions.isElementPresent("CustomerNameIBAN") && commonActions.isElementPresent("NextPage"))
					commonActions.click("NextPage");

				if (VorlagennameFromJson.equals(commonActions.getAttribute("CustomerNameIBAN", "title")))
					commonActions.logPassStatus("Pass | VorlagennameIBANAccount verify success "
							+ commonActions.getAttribute("CustomerNameIBAN", "title"));
				else
					commonActions.logFailStatus("Fail | VorlagennameIBANAccount verify failed "
							+ commonActions.getAttribute("CustomerNameIBAN", "title"));

				String IBAN_oder_KontonummerFromJson = commonActions.getKeyFromJson("IBAN_oder_Kontonummer")
						.replaceAll("\\s", "");
				System.out.println("IBAN_oder_KontonummerFromJson:" + IBAN_oder_KontonummerFromJson);
				System.out.println("IBAN_oder_KontonummerFromPage:"
						+ commonActions.getAttribute("IBAN_oder_KontonummerIBAN", "title"));

				if (IBAN_oder_KontonummerFromJson
						.equals(commonActions.getAttribute("IBAN_oder_KontonummerIBAN", "title")))
					commonActions.logPassStatus("Pass | IBAN_oder_KontonummerIBAN verify success "
							+ commonActions.getAttribute("IBAN_oder_KontonummerIBAN", "title"));
				else
					commonActions.logFailStatus("Fail | IBAN_oder_KontonummerIBAN verify success failed "
							+ commonActions.getAttribute("IBAN_oder_KontonummerIBAN", "title"));

			}
			if (commonActions.getScenarioName().equals("KontoBLZVorlagen_Anlegen")) {
				if (!commonActions.isElementPresent("CustomerNameKontoBLZ")
						&& commonActions.isElementPresent("NextPage"))
					commonActions.click("NextPage");
				if (VorlagennameFromJson.equals(commonActions.getAttribute("CustomerNameKontoBLZ", "title")))
					commonActions.logPassStatus("Pass | VorlagennameKontoBLZAccount verify success "
							+ commonActions.getAttribute("CustomerNameKontoBLZ", "title"));
				else
					commonActions.logPassStatus("Fail | VorlagennameKontoBLZAccount verify failed "
							+ commonActions.getAttribute("CustomerNameKontoBLZ", "title"));

				String IBAN_oder_KontonummerFromJson = commonActions.getKeyFromJson("IBAN_oder_Kontonummer")
						.replaceAll("\\s", "");
				IBAN_oder_KontonummerFromJson = "DE33" + commonActions.getValueFromJson("BLZ")
						+ IBAN_oder_KontonummerFromJson;
				System.out.println("IBAN_oder_KontonummerFromJson:" + IBAN_oder_KontonummerFromJson);
				System.out.println("IBAN_oder_KontonummerFromPage:"
						+ commonActions.getAttribute("IBAN_oder_KontonummerKontoBLZ", "title"));

				if (IBAN_oder_KontonummerFromJson
						.equals(commonActions.getAttribute("IBAN_oder_KontonummerKontoBLZ", "title")))
					commonActions.logPassStatus("Pass | IBANOrder_KontoBLZAccount verify success "
							+ commonActions.getAttribute("CustomerNameKontoBLZ", "title"));
				else
					commonActions.logFailStatus("Fail | IBANOrder_KontoBLZAccount verify failed "
							+ commonActions.getAttribute("CustomerNameKontoBLZ", "title"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			commonActions.logAssert_Fail("Verify Vorlagenname and IBANOrder failed");
		}
	}

	@And("^Verify captured details,Message from VorlageAnlegen$")
	public void Verify_catured_details() {

	}
	
	@And("^User deletes existing templates on Vorlagen_UmsaetzeZahlungsverkehr$")
		public void delete_existing_template() throws InterruptedException{
			if (commonActions.isElementPresent("CustomerNameIBAN")){
					commonActions.logInfoStatus("Vorlagename '001 DELTA BUERICZUEK' template already exists.");
					commonActions.logInfoStatus("Deleting the template");
					commonActions.click("DeleteIBAN");
					commonActions.enterLoadenvironmentTan("TAN_field_Vorlageloeschen","12345678");
					commonActions.click("UeberweisungsVorlageloeschen_Vorlageloeschen");
					commonActions.click("ZumZahlungsverkehr_VorlageAnlegen");
					Thread.sleep(5000);
					commonActions.moveScrollDown();
					// commonActions.waitForVisibilityofElement("NeueUeberweisungsvorlageAnlegen_UmsaetzeZahlungsverkehr");
				}

				if (commonActions.isElementPresent("CustomerNameKontoBLZ")) {
					commonActions.logInfoStatus("Vorlagename '002 DELTA BUERICZUEK' template already exists.");
					commonActions.logInfoStatus("Deleting the template");
					commonActions.click("DeleteKontoBLZ");
					commonActions.enterLoadenvironmentTan("TAN_field_Vorlageloeschen","12345678");
					// Use new mobile tan and rename function entertokentan
					commonActions.click("UeberweisungsVorlageloeschen_Vorlageloeschen");
					commonActions.click("ZumZahlungsverkehr_VorlageAnlegen");
					Thread.sleep(5000);
					commonActions.moveScrollDown();
					
				}
	}

}
