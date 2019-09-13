package com.bnpp.steps;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.json.simple.parser.ParseException;
import org.junit.Assert;

import com.bnpp.library.CommonActions;
import com.bnpp.utilities.TANGenerator;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class GenericSteps {

	CommonActions commonActions;

	public GenericSteps(CommonActions con) {
		this.commonActions = con;
	}

	/**
	 * 
	 * @param s
	 * @throws Exception
	 *             Description Initialization before starting of each scenario
	 *             execution
	 */
	@Before
	public void before(Scenario s) throws Exception {
		commonActions.initReports(s.getName());
		commonActions.setfaturefilenameandsceanrio(s.getId(), s.getName());

	}

	/**
	 * Description Closing the resources after execution of each scenario
	 */
	@After
	public void after() {
		commonActions.quit();
	}

	// ********Common step definitions ************//

	@And("^User enters \"(.*?)\" in \"(.*?)\"$")
	public void type(String dataKey, String locatorKey)
			throws IllegalArgumentException, InterruptedException, IOException, ParseException {
		if (locatorKey.equals("Steueridentifikationsnummer_PersoenlicheEinstellungen")) {
			commonActions.enterText(locatorKey, dataKey);
			// Move the focus out of field to handle the error displayed on
			// clearing the field.
			commonActions.pressTab();
		} else
			commonActions.enterText(locatorKey, dataKey);

	}

	@And("^User clears \"(.*?)\"$")
	public void clear(String locatorKey) {

		commonActions.clearfield(locatorKey);
	}

	@And("^User clicks on \"(.*?)\"$")
	public void click(String locatorKey) throws InterruptedException, Exception, IOException {
		if (locatorKey.equals("Aendern") || locatorKey.equals("Neue_Ueberweisungsvorlage_anlegen")
				|| locatorKey.equals("Vorlagen_UmsaetzeZahlungsverkehr")) {
			commonActions.moveScrollDown();
			commonActions.click(locatorKey);
		} else if (locatorKey.equals("Ueberweisungsvorlage_speichern")) {
			commonActions.click(locatorKey);
			if (commonActions.isElementPresent("New_mobile_tan")) {
				commonActions.enterTokenTan("Mobile_TAN_field1", TANGenerator.requestTan());
				commonActions.click(locatorKey);
			}
		} else
			commonActions.click(locatorKey);

	}

	@And("^User navigates to \"(.*?)\" in \"(.*?)\"$")
	public void User_mouseOvers_and_navigates_to(String clickElementKey, String mouseoverelementKey)
			throws InterruptedException {
		Thread.sleep(5000);
		commonActions.mouseover(mouseoverelementKey);
		commonActions.click(clickElementKey);

	}

	@And("^User selects \"(.*?)\" in \"(.*?)\"$")
	public void select(String dataKey, String locatorKey) throws Exception {
		if (dataKey.equals("Hinweis_gelesen") || dataKey.equals("Kenntnisse_vorhanden")
				|| dataKey.equals("Wertpapierkaeufe")) {
			System.out.println(dataKey);
			String str1 = commonActions.getValueFromJson(dataKey);
			commonActions.clearCheckBox(locatorKey);
			if (str1.equals("null")) {
				// System.out.println("checkbox is unchecked");
			} else {
				commonActions.click(locatorKey);
			}
		} else {
			commonActions.selectFromDropDown(locatorKey, dataKey);
		}
	}
	
	
	@And("^User selects checkbox \"(.*?)\"")
	public void selectCheckbox(String locatorKey) throws Exception {
		commonActions.selectCheckBox(locatorKey);
	}

	@And("^User submits generated TAN number in \"(.*?)\"$")
	public void user_submits_the_generated_TAN_number_in(String TanKey)
			throws ClientProtocolException, IOException, InterruptedException {
		 if (TanKey.equals("TAN_field_Login")) {
			commonActions.enterTokenTan(TanKey, TANGenerator.requestTan());
			commonActions.click("BestaetigenButton");
			if (!commonActions.isElementPresent("Mein_Konto_Depot")) {
				if (commonActions.isElementPresent("NewTan")) {
					commonActions.clearfield("TAN_field_Login");
					commonActions.enterTokenTan("TAN_field_PersoenlicheEinstellungen", TANGenerator.requestTan());
					commonActions.click("BestaetigenButton");
				}
			}
		}else
			commonActions.enterTokenTan(TanKey, TANGenerator.requestTan());

	}

	@And("^User Logs in with \"(.*?)\",\"(.*?)\"$")
	public void abc(String UserID_Kontonummer, String PIN_Password)
			throws Exception, InterruptedException, IOException, ParseException {
		commonActions.launchBrowser();
		commonActions.click("logInButton");
		commonActions.enterText(UserID_Kontonummer, "UserID_Kontonummer");
		commonActions.enterText(PIN_Password, "PIN_Password");
		click("Einloggen");
	}

	@When("User \"(.*?)\" in \"(.*?)\" field")
	public void user_unchecked_in_checkbox(String check, String locatorKey) throws InterruptedException {
		try {
			System.out.println(check);
			String str1 = commonActions.getValueFromJson(check);
			commonActions.clearCheckBox(locatorKey);
			if (str1.equals("null")) {
				// System.out.println("checkbox is unchecked");
			} else {
				commonActions.click(locatorKey);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Assert.fail();
		}

	}

	@Then("{string} is present")
	public void is_present(String objectKey) {
		commonActions.getElement(objectKey);

	}

}
