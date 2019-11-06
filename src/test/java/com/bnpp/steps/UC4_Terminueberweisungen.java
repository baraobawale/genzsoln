package com.bnpp.steps;

import java.io.FileNotFoundException;
import java.io.IOException;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebElement;
import com.bnpp.library.CommonActions;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class UC4_Terminueberweisungen {

	String CaptureErrorMsg = "";
	String CapturedName = "";
	String CapturedIBAN = "";
	String CapturedBetrag = "";
	String CapturedDatum = "";

	CommonActions commonActions;

	public UC4_Terminueberweisungen(CommonActions commonActions) {
		this.commonActions = commonActions;
	}

	@And("User select checkbox {string} in {string}")
	public void User_selects_checkbox_in_field(String dataKey, String locatorKey)
			throws FileNotFoundException, IOException, ParseException, InterruptedException {
		try {
			String str1 = commonActions.getValueFromJson(dataKey);
			commonActions.clearCheckBox(locatorKey);
			if (str1.equals("select"))
				commonActions.click(locatorKey);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@When("Capture Message on TerminAnlegen")
	public void capture_Message_on_TerminAnlegen()
			throws FileNotFoundException, IOException, ParseException, InterruptedException {

		try {
			Thread.sleep(5000);
			CaptureErrorMsg = commonActions.getText("TerminAnlegen");
			commonActions.logPassStatus("Capture Message on TerminAnlegen");

		} catch (Exception e) {
			e.printStackTrace();
			commonActions.logAssert_Fail("Fail | Valid message display failed - ");
		}
	}

	@When("Capture entered details on TerminAnlegen")
	public void capture_entered_details_on_TerminAnlegen() throws FileNotFoundException, IOException, ParseException {

		try {

			CapturedName = commonActions.getText("CapturedNameTermino");
			CapturedIBAN = commonActions.getText("CapturedIBANTermino");
			CapturedBetrag = commonActions.getText("CapturedBetragTermino");
			CapturedDatum = commonActions.getText("CapturedDatumTermino");

			System.out.println("CapturedName:" + CapturedName);
			System.out.println("CapturedIBAN:" + CapturedIBAN);
			System.out.println("CapturedBetrag:" + CapturedBetrag);
			System.out.println("CapturedDatum:" + CapturedDatum);

		} catch (Exception e) {
			e.printStackTrace();
			commonActions.logAssert_Fail("Fail | Valid message display failed - Data match fail");
		}

	}

	@Then("^Verify \"(.*?)\",\"(.*?)\" under \"(.*?)\"$")
	public void verify_under(String VerifyName, String VerifyAusfuehrung_Am, String locatorKey) {

		commonActions.moveScrollDown();
		try {
			String txtVerify1 = commonActions.getAttribute("VerifyName", "innerHTML");
			String txtVerify2 = commonActions.getText("VerifyAusfuehrung_AmTerm");

			System.out.println("Verify txtVerify1:" + txtVerify1);
			System.out.println("Verify JSON NAME." + commonActions.getValueFromJson("Name"));

			System.out.println("Verify txtVerify2:" + txtVerify2);
			System.out.println("Verify JSON Datum." + commonActions.getValueFromJson("Datum"));

			if (txtVerify1.equals(commonActions.getValueFromJson("Name"))) {
				commonActions.logPassStatus("Pass | Valid name displayed - " + txtVerify1);
			} else {
				commonActions
						.logFailStatus("Fail | Valid name display failed - " + commonActions.getValueFromJson("Name"));
			}
			if (txtVerify2.equals(CapturedDatum)) {
				commonActions.logPassStatus("Pass | Valid Date displayed - " + txtVerify2);
			} else {
				commonActions
						.logFailStatus("Fail | Valid Date display failed - " + txtVerify2);
			}

		} catch (Exception e) {
			e.printStackTrace();
			// commonActions.logAssert_Fail("Data match fail");
		}

	}

	@Then("Verify captured details,Message from TerminAnlegen")
	public void verify_captured_details_Message_from_TerminAnlegen() {
		try {

			if (CapturedName.equals(commonActions.getValueFromJson("Name"))) {
				commonActions.logPassStatus("Pass | Valid name displayed - " + CapturedName);
			} else {
				commonActions.logFailStatus("Fail | Valid name display failed - " + CapturedName);

			}
			if (CapturedIBAN.equals(
					commonActions.checkGermanCharacters(commonActions.getValueFromJson("IBAN_oder_Kontonummer")))) {
				commonActions.logPassStatus("Pass | Valid IBAN_oder_Kontonummer displayed - " + CapturedIBAN);
			} else {
				commonActions.logFailStatus("Fail | Valid IBAN_oder_Kontonummer display failed - " + CapturedIBAN);
			}
			if (CapturedBetrag.contains(commonActions.getValueFromJson("Betrag"))) {
				commonActions.logPassStatus("Pass | Valid Betrag displayed - " + CapturedBetrag);
			} else {
				commonActions.logFailStatus("Fail | Valid Betrag display failed - " + CapturedBetrag);
			}
			if (CapturedDatum.equals(commonActions.getText("VerifyAusfuehrung_AmTerm"))) {
				commonActions.logPassStatus("Pass | Valid Datum displayed - " + CapturedDatum);
			} else {
				commonActions.logFailStatus("Fail | Valid Datum display failed - " + CapturedDatum);
			}

			if (CaptureErrorMsg.equals(commonActions.getValueFromJson("Message"))) {
				commonActions.logPassStatus("Message verified");
			} else {
				commonActions.logFailStatus("Message not matched");

			}
		} catch (Exception e) {
			e.printStackTrace();
			// commonActions.logAssert_Fail("text not found");
		}
	}

	@And("^User click on \"(.*?)\" of \"(.*?)\" in \"(.*?)\" field$")
	public void user_click_on_of_in(String locatorKey, String datakey,
			String CreatedTerminueberweisungen_UmsaetzeZahlungsverkehr)
			throws FileNotFoundException, IOException, ParseException, InterruptedException {

		try {
			if (CreatedTerminueberweisungen_UmsaetzeZahlungsverkehr.equals("Created_Terminueberweisungen"))
				commonActions.waitForVisibilityofElement("locatorKey");
			commonActions.click(locatorKey);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Then("Verify Message on Terminueberweisungloeschen")
	public void verify_Message_on_Terminueberweisungloeschen() {
		try {
			System.out.println(
					"txtVerify for Terminueberweisungloeschen:" + commonActions.getText("Terminueberweisungloeschen"));
			String txtVerify = commonActions.getText("Terminueberweisungloeschen");
			System.out.println(commonActions.getValueFromJson("Message"));
			if (txtVerify.equalsIgnoreCase(commonActions.getValueFromJson("Message"))) {
				System.out.println("Verify Message on Terminueberweisungloeschen SUCCESSFULLY");
				commonActions.logPassStatus("Pass | Valid message displayed - " + txtVerify);

			} else
				commonActions.logFailStatus("Fail | Valid message display failed - " + txtVerify);
		} catch (Exception e) {
			e.printStackTrace();
			commonActions.logAssert_Fail("Fail | Data save fail for Terminueberweisungloeschen");
		}

	}

	@Then("Verify Message,details on TerminAendern")
	public void verify_Message_details_on_TerminAendern() {
		try {
			System.out.println("txtVerify for TerminAendern" + commonActions.getText("TerminAendern"));
			String txtVerify = commonActions.getText("TerminAendern");
			System.out.println(commonActions.getValueFromJson("Message"));
			if (txtVerify.equalsIgnoreCase(commonActions.getValueFromJson("Message"))) {
				System.out.println("Verify Message on TerminAendern edit successfully");
				commonActions.logPassStatus("Pass | Valid message displayed - " + txtVerify);

			} else
				commonActions.logFailStatus("Fail | Valid message display failed - " + txtVerify);

		} catch (Exception e) {
			e.printStackTrace();
			commonActions.logAssert_Fail("Data save fail for TerminAendern");
		}
	}
	@And("^User clicks on NeuesTerminueberweisungenAnlengen_UmsaetzeZahlungsverkehr to create template$")
	public void user_delete_existing_templates_on_Terminueberweisungen_UmsaetzeZahlungsverkehr()
			throws InterruptedException {
		if (commonActions.isElementPresent("TerminoUberWise_04")) {
			commonActions.click("DeleteTerminoUberwise_04");
			// String token = TANGenerator.requestTan();
			// commonActions.enterNewMobileTan("TAN_field_Vorlageloeschen",
			// token);
			commonActions.enterLoadenvironmentTan("TAN_field_Vorlageloeschen", "12345678");
			commonActions.click("UeberweisungsVorlageloeschen_Vorlageloeschen");
			commonActions.click("ZumZahlungsverkehr_VorlageAnlegen");
			commonActions.click("Vorlagen_UmsaetzeZahlungsverkehr");
			if(commonActions.isElementPresent("TerminoUberWise_04OnVorlagen")){
				commonActions.click("TerminoUberWise_04OnVorlagenDelete");
				commonActions.enterLoadenvironmentTan("TAN_field_Vorlageloeschen","12345678");
				commonActions.click("UeberweisungsVorlageloeschen_Vorlageloeschen");
				commonActions.click("ZumZahlungsverkehr_VorlageAnlegen");
				Thread.sleep(5000);
				commonActions.moveScrollDown();
				commonActions.click("Terminueberweisungen_UmsaetzeZahlungsverkehr");
			}
			Thread.sleep(5000);
			commonActions.moveScrollDown();
			
		}
		commonActions.click("Terminueberweisungen_UmsaetzeZahlungsverkehr");
		commonActions.click("NeuesTerminueberweisungenAnlengen_UmsaetzeZahlungsverkehr");
	}
	@And("^User enters future date in Datum_TerminAnlegen$")
	public void user_selects_future_date() throws InterruptedException{
		commonActions.click("Datum_TerminAnlegen");
		commonActions.click("Future_date_Datum_TerminAnlegen");
		Thread.sleep(2000);
	}
}
