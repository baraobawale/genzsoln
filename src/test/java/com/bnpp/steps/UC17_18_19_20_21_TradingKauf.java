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
	}

	@When("Capture Message on OrderErteilen")
	public void capture_Message_on_OrderErteilen() throws FileNotFoundException, IOException, ParseException {
		// Write code here that turns the phrase above into concrete actions
		String message = commonActions.getText("Message");
		if (message.equals(commonActions.getValueFromJson("message")))
			commonActions.logPassStatus("Pass | Valid message displayed - " + message);

		else {
			commonActions.logFailStatus("Fail | Valid message display failed -" + message + "fomrJson: "
					+ commonActions.getValueFromJson("message"));

		}

	}

	@Then("Verify {string},{string},{string},{string},{string} on OrderUebersicht")
	public void verify_on_OrderUebersicht(String string, String string2, String string3, String string4,
			String string5) {
		// Write code here that turns the phrase above into concrete actions

	}

	@Then("^Verify captured details,Message from OrderErteilen$")
	public void verify_captured_details_Message_from_OrderErteilen() {
		// Write code here that turns the phrase above into concrete actions

	}
	@Then("^Verify Message,details on OrderAendern")
	public void Then_Verify_Message_details_on_OrderAendern(){
		
	}
	@Then("Verify Message on OrderLoeschen")
	public void Then_Verify_Message_on_OrderLoeschen(){
		
	}

}
