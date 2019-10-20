package com.bnpp.steps;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.apache.http.client.ClientProtocolException;
import org.json.simple.parser.ParseException;
import org.xml.sax.SAXException;

import com.bnpp.library.CommonActions;
import com.bnpp.utilities.TANGenerator;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

public class UC58_61_EinzelEroeffnet {
	CommonActions commonActions;

	public UC58_61_EinzelEroeffnet(CommonActions con) {
		this.commonActions = con;
	}

	@Then("^Verify captured Vorgangsnummer,Message from KostenlosesWertpapierdepotEinzel$")
	public void Verify_captured_message() throws FileNotFoundException, IOException, ParseException {
		try {
			System.out.println(
					commonActions.getText("Verify_Message") + "   :   " + commonActions.getValueFromJson("Message"));

			if (commonActions.getText("Verify_Message").equals(commonActions.getValueFromJson("Message")))
				commonActions.logPassStatus("Pass | Valid message displayed - "+commonActions.getText("Verify_Message"));
			else
				commonActions.logFailStatus("Fail | Valid message display failed - " +commonActions.getText("Verify_Message"));
			if (!commonActions.getText("VorlageNumber").equals(""))
				commonActions.logPassStatus("Pass | Valid Vorlagenumber displayed - " +commonActions.getText("VorlageNumber"));
			else
				commonActions.logFailStatus("Fail | Valid Vorlagenumber display failed - "+commonActions.getText("VorlageNumber"));

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			commonActions.logAssert_Fail("UC58_61_EinzelEroeffnet scenario failed");
		}
	}

	@Then("^Verify captured Vorgangsnummer,Message from TagesgeldkontoEinzel$")
	public void Verify_captured_message_from_TagesgeldkontoEinzel()
			throws FileNotFoundException, IOException, ParseException {

		try {
			System.out.println(
					commonActions.getText("Verify_Message") + "   :   " + commonActions.getValueFromJson("Message"));
			if (commonActions.getText("Verify_Message").equals(commonActions.getValueFromJson("Message")))
				commonActions.logPassStatus("Pass | Valid message displayed - " +commonActions.getText("Verify_Message"));
			else
				commonActions.logFailStatus("Fail | Valid message display failed - " +commonActions.getText("Verify_Message"));
			if (!commonActions.getText("VorlageNumber").equals(""))
				commonActions.logPassStatus("Pass | Valid message displayed - "+commonActions.getText("VorlageNumber"));
			else
				commonActions.logFailStatus("Fail | Valid message display failed - "+commonActions.getText("VorlageNumber"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			commonActions.logAssert_Fail("Verify captured Vorgangsnummer,Message failed");
		}
	}

	@And("^User submits generated TAN number in \"(.*?)\" for new customer$")
	public void submit_tan_for_new_customer(String TanKey) throws ClientProtocolException, IOException,
			InterruptedException, ParserConfigurationException, SAXException {
		try {
			String token = TANGenerator.requestTan();
			commonActions.clickonMobiletanLinkandEnterTan(TanKey, token);
			commonActions.click("BestaetigenButtonNewCustomer");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			commonActions.logAssert_Fail("Input new mobile tan step failed");
		}
	}

}
