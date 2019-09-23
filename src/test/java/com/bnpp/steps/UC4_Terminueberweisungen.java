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
			WebElement text = commonActions.getElement("TerminAnlegen");
			CaptureErrorMsg = text.getText();
			System.out.println("CaptureErrorMsg " + CaptureErrorMsg);
			commonActions.logPassStatus("Capture Message on TerminAnlegen");

		} catch (Exception e) {
			e.printStackTrace();
			commonActions.logAssert_Fail("Capture Message on TerminAnlegen fail");
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
			commonActions.logAssert_Fail("Data match fail");
		}

	}

	@Then("^Verify \"(.*?)\",\"(.*?)\" under \"(.*?)\"$")
	public void verify_under(String VerifyName, String VerifyAusfuehrung_Am, String locatorKey) {

		commonActions.moveScrollDown();
		try {
			String txtVerify1 = commonActions.getAttribute("VerifyName", "innerHTML");
			String txtVerify2 = commonActions.getAttribute("VerifyAusfuehrung_AmTerm", "innerText");

			System.out.println("Verify txtVerify1:" + txtVerify1);
			System.out.println("Verify JSON NAME." + commonActions.getValueFromJson("Name"));

			System.out.println("Verify txtVerify2:" + txtVerify2);
			System.out.println("Verify JSON Datum." + commonActions.getValueFromJson("Datum"));

			if (txtVerify1.equals(commonActions.getValueFromJson("Name"))) {
				commonActions.logPassStatus("Verify Name on Terminueberweisung");
			} else {
				commonActions.logFailStatus("Data save fail for Terminueberweisung");
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
				commonActions.logPassStatus("Verified name on Terminueberweisung");
			} else {
				commonActions.logFailStatus("Data save fail for Terminueberweisung");
			}
			if (CapturedIBAN.equals(
					commonActions.checkGermanCharacters(commonActions.getValueFromJson("IBAN_oder_Kontonummer")))) {
				commonActions.logPassStatus("Verified IBAN on Terminueberweisung");
			} else {
				commonActions.logFailStatus("Data save fail for Terminueberweisung");
			}
			if (CapturedBetrag.contains(commonActions.getValueFromJson("Betrag"))) {
				commonActions.logPassStatus("Verified Betrag on Terminueberweisung");
			} else {
				commonActions.logFailStatus("Data save fail for Terminueberweisung");
			}
			if (CapturedDatum.equals(commonActions.getValueFromJson("Datum"))) {
				commonActions.logPassStatus("Verified Datum on Terminueberweisung");
			} else {
				commonActions.logFailStatus("Data save fail for Terminueberweisung");
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
				commonActions.logPassStatus("Verify Message on Terminueberweisungloeschen");

			} else
				commonActions.logFailStatus("Verify Message on Terminueberweisungloeschen is failed");

		} catch (Exception e) {
			e.printStackTrace();
			commonActions.logAssert_Fail("Data save fail for Terminueberweisungloeschen");
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
				commonActions.logPassStatus("Verify Message on TerminAendern");

			} else
				commonActions.logFailStatus("Verification of Message on TerminAendern edit is failed");

		} catch (Exception e) {
			e.printStackTrace();
			commonActions.logAssert_Fail("Data save fail for TerminAendern");
		}
	}

}
