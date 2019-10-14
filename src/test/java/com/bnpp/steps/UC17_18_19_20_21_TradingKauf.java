package com.bnpp.steps;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;

import com.bnpp.library.CommonActions;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class UC17_18_19_20_21_TradingKauf {
	CommonActions commonActions;

	public UC17_18_19_20_21_TradingKauf(CommonActions con) {
		this.commonActions = con;
	}

	@When("Capture entered details on OrderErteilen")
	public void capture_entered_details_on_OrderErteilen() throws FileNotFoundException, IOException, ParseException {
		// Write code here that turns the phrase above into concrete actions
		if (commonActions.getScenarioName().equals("KaufOrder_Anlegen_Anleihe")) {
			String orderart = commonActions.getText("OrderArt");
			if (orderart.equals("Kauf"))
				commonActions.logPassStatus("Pass | Valid Orderart value displayed - " + "Kauf");
			else
				commonActions.logFailStatus("Fail | Valid Orderart value display failed - " + "Kauf");

			String limit = commonActions.getText("Limit");
			if (limit.equals(commonActions.getValueFromJson("Limit") + ",00%"))
				commonActions.logPassStatus("Pass | Valid Limit value displayed - " + limit);
			else
				commonActions.logFailStatus("Fail | Valid Limit value display failed - " + limit);

			String wkn = commonActions.getText("WKN");
			if (wkn.contains(commonActions.getValueFromJson("Name_WKN_ISIN")))
				commonActions.logPassStatus("Pass | Valid WKN value displayed - " + wkn);
			else
				commonActions.logFailStatus("Fail | Valid WKN value display failed - " + wkn);

			String nominal = commonActions.getText("Nominal");
			if (nominal.equals(commonActions.getValueFromJson("NominalStueck_Betrag") + ",00"))
				commonActions.logPassStatus("Pass | Valid Nominal value displayed - " + nominal);
			else
				commonActions.logFailStatus("Fail | Valid Nominal value display failed - " + nominal);
		} else if (commonActions.getScenarioName().equals("KaufOrder_Anlegen_Aktie")) {
			String orderart = commonActions.getText("OrderArt");
			if (orderart.equals("Kauf"))
				commonActions.logPassStatus("Pass | Valid Orderart value displayed - " + "Kauf");
			else
				commonActions.logFailStatus("Fail | Valid Orderart value display failed - " + "Kauf");

			String stop = commonActions.getText("Stop");
			if (stop.equals(commonActions.getValueFromJson("Limit") + " EUR"))
				commonActions.logPassStatus("Pass | Valid Stop value displayed - " + stop);
			else
				commonActions.logFailStatus("Fail | Valid Stop value display failed - " + stop);

			String wkn = commonActions.getText("WKN");
			if (wkn.contains(commonActions.getValueFromJson("Name_WKN_ISIN")))
				commonActions.logPassStatus("Pass | Valid WKN value displayed - " + wkn);
			else
				commonActions.logFailStatus("Fail | Valid WKN value display failed - " + wkn);

			String Stuck = commonActions.getText("Stuck");
			if (Stuck.equals(commonActions.getValueFromJson("NominalStueck_Betrag") + ",00"))
				commonActions.logPassStatus("Pass | Valid Stuck value displayed - " + Stuck);
			else
				commonActions.logFailStatus("Fail | Valid Stuck value display failed - " + Stuck);
		} else if (commonActions.getScenarioName().equals("KaufOrder_Anlegen_Fonds2")) {
			String orderart = commonActions.getText("OrderArt");
			if (orderart.equals("Kauf"))
				commonActions.logPassStatus("Pass | Valid Orderart value displayed - " + "Kauf");
			else
				commonActions.logFailStatus("Fail | Valid Orderart value display failed - " + "Kauf");

			String stop = commonActions.getText("Stop");
			if (stop.equals(commonActions.getValueFromJson("Stop") + " EUR"))
				commonActions.logPassStatus("Pass | Valid Stop value displayed - " + stop);
			else
				commonActions.logFailStatus("Fail | Valid Stop value display failed - " + stop);

			String wkn = commonActions.getText("WKN");
			if (wkn.contains(commonActions.getValueFromJson("Name_WKN_ISIN")))
				commonActions.logPassStatus("Pass | Valid WKN value displayed - " + wkn);
			else
				commonActions.logFailStatus("Fail | Valid WKN value display failed - " + wkn);

			String Stuck = commonActions.getText("Stuck");
			if (Stuck.equals(commonActions.getValueFromJson("NominalStueck_Betrag") + ",00"))
				commonActions.logPassStatus("Pass | Valid Stuck value displayed - " + Stuck);
			else
				commonActions.logFailStatus("Fail | Valid Stuck value display failed - " + Stuck);
		}
	}

	@When("Capture Message on OrderErteilen")
	public void capture_Message_on_OrderErteilen() throws FileNotFoundException, IOException, ParseException {
		// Write code here that turns the phrase above into concrete actions
		try {
			String message = commonActions.getText("Message");
			if (message.equals(commonActions.getValueFromJson("Message")))
				commonActions.logPassStatus("Pass | Valid message displayed - " + message);

			else {
				commonActions.logFailStatus("Fail | Valid message display failed -" + message + "fomrJson: "
						+ commonActions.getValueFromJson("Message"));

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			commonActions.logAssert_Fail("Please check correct key used while calling value from json");
		}

	}

	@Then("Verify {string},{string},{string},{string},{string} on OrderUebersicht")
	public void verify_on_OrderUebersicht(String string, String string2, String string3, String string4, String string5)
			throws FileNotFoundException, IOException, ParseException {
		if (commonActions.getScenarioName().equals("KaufOrder_Anlegen_Aktie")) {
			String ort = commonActions.getText("OrderartTable");
			System.out.println(ort);
			if (ort.equals("Kauf"))
				commonActions.logPassStatus("Pass | Valid Ort value displayed - " + ort);
			else
				commonActions.logFailStatus("Fail | Valid Ort value display failed - " + ort);

			String Handelsplat = commonActions.getText("Handelsplatz_table");
			if (Handelsplat.equals(commonActions.getValueFromJson("Handelsplatz")))
				commonActions.logPassStatus("Pass | Valid Handelsplat value displayed - " + Handelsplat);
			else
				commonActions.logFailStatus("Fail | Valid Handelsplat value display failed - " + Handelsplat);

			String NominalStueck_Betrag = commonActions.getText("StuckORNominal");
			if (NominalStueck_Betrag.equals(commonActions.getValueFromJson("NominalStueck_Betrag") + ",00"))
				commonActions
						.logPassStatus("Pass | Valid Stop NominalStueck_Betrag displayed - " + NominalStueck_Betrag);
			else
				commonActions.logFailStatus(
						"Fail | Valid NominalStueck_Betrag value display failed - " + NominalStueck_Betrag);

			String WKN = commonActions.getText("WKN_table");
			if (WKN.contains(commonActions.getValueFromJson("Name_WKN_ISIN")))
				commonActions.logPassStatus("Pass | Valid WKN value displayed - " + WKN);
			else
				commonActions.logFailStatus("Fail | Valid WKN value display failed - " + WKN);

			String Ordertyp = commonActions.getText("OrderTyp");
			if (Ordertyp.equals(commonActions.getValueFromJson("Ordertyp") + " Market"))
				commonActions.logPassStatus("Pass | Valid Ordertyp value displayed - " + Ordertyp);
			else
				commonActions.logFailStatus("Fail | Valid Ordertyp value display failed - " + Ordertyp);
		}
		if (commonActions.getScenarioName().equals("KaufOrder_Anlegen_Fonds2")) {
			String ort = commonActions.getText("OrderartTable");
			System.out.println(ort);
			if (ort.equals("Kauf"))
				commonActions.logPassStatus("Pass | Valid Ort value displayed - " + ort);
			else
				commonActions.logFailStatus("Fail | Valid Ort value display failed - " + ort);

			String Handelsplat = commonActions.getText("Handelsplatz_table");
			if (Handelsplat.equals(commonActions.getValueFromJson("Handelsplatz")))
				commonActions.logPassStatus("Pass | Valid Handelsplat value displayed - " + Handelsplat);
			else
				commonActions.logFailStatus("Fail | Valid Handelsplat value display failed - " + Handelsplat);

			String NominalStueck_Betrag = commonActions.getText("StuckORNominal");
			if (NominalStueck_Betrag.equals(commonActions.getValueFromJson("NominalStueck_Betrag") + ",00"))
				commonActions
						.logPassStatus("Pass | Valid Stop NominalStueck_Betrag displayed - " + NominalStueck_Betrag);
			else
				commonActions.logFailStatus(
						"Fail | Valid NominalStueck_Betrag value display failed - " + NominalStueck_Betrag);

			String WKN = commonActions.getText("WKN_table");
			if (WKN.contains(commonActions.getValueFromJson("Name_WKN_ISIN")))
				commonActions.logPassStatus("Pass | Valid WKN value displayed - " + WKN);
			else
				commonActions.logFailStatus("Fail | Valid WKN value display failed - " + WKN);

			String Ordertyp = commonActions.getText("OrderTyp");
			if (Ordertyp.equals(commonActions.getValueFromJson("Ordertyp") + " Buy Limit"))
				commonActions.logPassStatus("Pass | Valid Ordertyp value displayed - " + Ordertyp);
			else
				commonActions.logFailStatus("Fail | Valid Ordertyp value display failed - " + Ordertyp);
		}

	}

	@Then("^Verify captured details,Message from OrderErteilen$")
	public void verify_captured_details_Message_from_OrderErteilen() {
		// Write code here that turns the phrase above into concrete actions

	}

	@Then("^Verify Message,details on OrderAendern")
	public void Then_Verify_Message_details_on_OrderAendern() {
		try {
			String message = commonActions.getText("Message");
			if (message.equals(commonActions.getValueFromJson("Message")))
				commonActions.logPassStatus("Pass | Valid message displayed - " + message);
			else {
				commonActions.logFailStatus("Fail | Valid message display failed -" + message + "fomrJson: "
						+ commonActions.getValueFromJson("Message"));

			String changedlimit = commonActions.getText("Limit");
			if (changedlimit.equals(commonActions.getValueFromJson("Limit") + " EUR"))
					commonActions.logPassStatus("Pass | Valid Limit value displayed - " + changedlimit);
			else
				commonActions.logFailStatus("Fail | Valid Limit value displayed - " + changedlimit);

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			commonActions.logAssert_Fail("Please check correct key used while calling value from json");
		}

	}

	@Then("Verify Message on OrderLoeschen")
	public void Then_Verify_Message_on_OrderLoeschen() throws FileNotFoundException, IOException, ParseException {
		commonActions.moveScrollUp();
		String message=commonActions.getText("DeleteMessageAnktie");
		System.out.println("My message: "+message);
		if(message.equals(commonActions.getValueFromJson("Message")))
				commonActions.logPassStatus("Pass | Valid message displayed - " + message);
		else {
			commonActions.logFailStatus("Fail | Valid message display failed -" + message + " From Json: "
					+ commonActions.getValueFromJson("Message"));
	}

	}
	}
