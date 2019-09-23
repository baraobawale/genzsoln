package com.bnpp.steps;

import java.io.FileNotFoundException;
import java.io.IOException;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebElement;
import com.bnpp.library.CommonActions;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class UC3_Dauerauftraege {

	CommonActions commonActions;

	public UC3_Dauerauftraege(CommonActions commonActions) {
		this.commonActions = commonActions;
	}

	String CaptureErrorMsg = "";
	String CapturedName = "";
	String CapturedIBAN = "";
	String CapturedBetrag = "";
	String CapturedDatum = "";

	@And("^User selects \"(.*?)\" in \"(.*?)\" field$")
	public void select(String dataKey, String locatorKey) throws Exception {

		try {
			commonActions.selectDropDownByIndex(locatorKey, dataKey);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@And("^User clicks on \"(.*?)\" of \"(.*?)\" in \"(.*?)\"$")
	public void user_click_on_of_in(String locatorKey, String datakey,
			String CreatedDauerauftraege_UmsaetzeZahlungsverkehr)
			throws FileNotFoundException, IOException, ParseException, InterruptedException {

		try {
			if (CreatedDauerauftraege_UmsaetzeZahlungsverkehr.equals("Created_Dauerauftraege"))
				commonActions.waitForVisibilityofElement("locatorKey");
			commonActions.click(locatorKey);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@When("Capture entered details on DauerauftrageAnlegen")
	public void capture_entered_details_on_DauerauftrageAnlegen() {
		try {

			CapturedName = commonActions.getText("CapturedName");
			CapturedIBAN = commonActions.getText("CapturedIBAN");
			CapturedBetrag = commonActions.getText("CapturedBetrag");
			CapturedDatum = commonActions.getText("CapturedDatum");

			System.out.println("CapturedName:" + CapturedName);
			System.out.println("CapturedIBAN:" + CapturedIBAN);
			System.out.println("CapturedBetrag:" + CapturedBetrag);
			System.out.println("CapturedDatum:" + CapturedDatum);

		} catch (Exception e) {
			e.printStackTrace();
			commonActions.logAssert_Fail("Data match fail");
		}
	}

	@When("Capture Message on DauerauftrageAnlegen")
	public void capture_Message_on_DauerauftrageAnlegen() {
		try {
			Thread.sleep(5000);
			WebElement text = commonActions.getElement("DauerauftrageAnlegen");
			CaptureErrorMsg = text.getText();
			System.out.println("CaptureErrorMsg " + CaptureErrorMsg);
			commonActions.logPassStatus("Capture Message on DauerauftrageAnlegen");

		} catch (Exception e) {
			e.printStackTrace();
			commonActions.logAssert_Fail("Capture Message on DauerauftrageAnlegen fail");
		}
	}

	@Then("Verify {string},{string} on UmsaetzeZahlungsverkehr")
	public void verify_on_UmsaetzeZahlungsverkehr(String Vorlagenname, String string2) {
		commonActions.moveScrollDown();
		try {
			String txtVerify1 = commonActions.getAttribute("VerifyName", "innerHTML");
			String txtVerify2 = commonActions.getAttribute("VerifyAusfuehrung_Am", "innerText");

			System.out.println("Verify txtVerify1:" + txtVerify1);
			System.out.println("Verify JSON NAME." + commonActions.getValueFromJson("Name"));

			// System.out.println("Verify txtVerify2:"+txtVerify2);
			// System.out.println("Verify JSON
			// Datum."+commonActions.getValueFromJson("Datum"));

			if (txtVerify1.equals(commonActions.getValueFromJson("Name"))) {
				commonActions.logPassStatus("Verify Name on DauerauftrageAnlegen");
			} else {
				commonActions.logFailStatus("Data save fail for DauerauftrageAnlegen");
			}

		} catch (Exception e) {
			e.printStackTrace();
			// commonActions.logAssert_Fail("Data match fail");
		}
	}

	@Then("Verify captured details,Message from DauerauftrageAnlegen")
	public void verify_captured_details_Message_from_DauerauftrageAnlegen() {
		try {

			if (CapturedName.equals(commonActions.getValueFromJson("Name"))) {
				commonActions.logPassStatus("Verified name on DauerauftrageAnlegen");
			} else {
				commonActions.logFailStatus("Data save fail for DauerauftrageAnlegen");
			}
			if (CapturedIBAN.equals(
					commonActions.checkGermanCharacters(commonActions.getValueFromJson("IBAN_oder_Kontonummer")))) {
				commonActions.logPassStatus("Verified IBAN on DauerauftrageAnlegen");
			} else {
				commonActions.logFailStatus("Data save fail for DauerauftrageAnlegen");
			}
			if (CapturedBetrag.contains(commonActions.getValueFromJson("Betrag"))) {
				commonActions.logPassStatus("Verified Betrag on DauerauftrageAnlegen");
			} else {
				commonActions.logFailStatus("Data save fail for DauerauftrageAnlegen");
			}
			if (CapturedDatum.equals(commonActions.getValueFromJson("Startdatum"))) {
				commonActions.logPassStatus("Verified Datum on DauerauftrageAnlegen");
			} else {
				commonActions.logFailStatus("Data save fail for DauerauftrageAnlegen");
			}

			if (CaptureErrorMsg.equals(commonActions.getKeyFromJson("Message"))) {
				commonActions.logPassStatus("Message verified");
			} else {
				System.out.println("MMMM: " + CaptureErrorMsg);
				System.out.println("LLLL: " + commonActions.getKeyFromJson(("Message")));
				commonActions.logFailStatus("Message not matched");

			}
		} catch (Exception e) {
			e.printStackTrace();
			commonActions.logAssert_Fail("text not found");
		}
	}

	@And("^User changes \"(.*?)\" in \"(.*?)\"$")
	public void type(String dataKey, String locatorKey)
			throws IllegalArgumentException, InterruptedException, IOException, ParseException {

		try {
			commonActions.enterText(locatorKey, dataKey);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Then("Verify Message,details on DauerauftrageAndern")
	public void verify_Message_details_on_DauerauftrageAndern() {
		try {

			String txtVerify = commonActions.getText("DauerauftrageAndern");
			System.out.println("PPP: " + txtVerify);
			System.out.println("QQQ: " + commonActions.getKeyFromJson("Message"));
			if (txtVerify.equalsIgnoreCase(commonActions.getKeyFromJson("Message"))) {
				System.out.println("Verify Message on DauerauftrageAndern edit successfully");
				commonActions.logPassStatus("Verify Message on DauerauftrageAndern");

			} else
				commonActions.logFailStatus("Verification of Message on DauerauftrageAndern edit is failed");
			String BetragExpected = commonActions.getText("BetragCaptureDauerauftraege");
			String BetragActual = commonActions.getValueFromJson("Betrag") + " EUR";
			if (BetragExpected.equals(BetragActual))
				commonActions.logPassStatus("Betrag update success");
			else
				commonActions.logFailStatus(
						"Betrag update fail" + "Expected: " + BetragExpected + "Actual: " + BetragActual);

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	@Then("Verify Message on Dauerauftraegeloeschen")
	public void verify_Message_on_Dauerauftraegeloeschen() {
		try {
			System.out
					.println("txtVerify for Dauerauftraegeloeschen:" + commonActions.getText("Dauerauftraegeloeschen"));
			String txtVerify = commonActions.getText("Dauerauftraegeloeschen");
			System.out.println(commonActions.getValueFromJson("Message"));
			if (txtVerify.equalsIgnoreCase(commonActions.getKeyFromJson("Message"))) {
				System.out.println("Verify Message on Dauerauftraegeloeschen SUCCESSFULLY");
				commonActions.logPassStatus("Verify Message on Dauerauftraegeloeschen");

			} else {

				System.out.println("AAA:" + txtVerify);
				System.out.println("BBB: " + commonActions.getKeyFromJson("Message"));
				commonActions.logFailStatus("Verify Message on Dauerauftraegeloeschen is failed" + "Expected: "
						+ commonActions.getKeyFromJson("Message") + "Actual: " + txtVerify);
			}
		} catch (Exception e) {
			e.printStackTrace();
			commonActions.logAssert_Fail("Data save fail for Dauerauftraegeloeschen");
		}

	}
}
