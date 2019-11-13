package com.bnpp.steps;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;
import java.util.Properties;

import javax.xml.parsers.ParserConfigurationException;

import org.apache.http.client.ClientProtocolException;
import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

import org.xml.sax.SAXException;

import com.bnpp.library.CommonActions;
import com.bnpp.mTANResources.MobileTan;
import com.bnpp.utilities.Configurations;
import com.bnpp.utilities.TANGenerator;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
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
		if ((Configurations.RunOnBrowserStack).equals("Y")) {
			commonActions.initReports(s.getName()+"_"+System.getProperty("browser"));
		}
		commonActions.initReports(s.getName()+"_"+"chrome");
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

	@Given("^User launches Consorsbank web application$")
	public void User_launches_consorsbank_web_application() {
		try {
			commonActions.launchBrowser();
			Thread.sleep(10000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
	}

	@And("^User enters \"(.*?)\" in \"(.*?)\"$")
	public void User_enters(String dataKey, String locatorKey)
			throws IllegalArgumentException, InterruptedException, IOException, ParseException {
		try{
			String textToEnter = commonActions.getValueFromJson(dataKey);
			if(textToEnter.equals("")){
				commonActions.clearfield(locatorKey);
			}else
			commonActions.enterText(locatorKey, textToEnter);
			commonActions.pressTab();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			commonActions.logAssert_Fail("Fail | Enter text failed -" + locatorKey);
		}

	}

	@And("^User clears \"(.*?)\"$")
	public void User_clears(String locatorKey) {

		try {
			commonActions.clearfield(locatorKey);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			commonActions.logAssert_Fail("Fail | Clear text failed -" + locatorKey);
		}
	}

	// @And("^User clicks on \"([a-zA-Z0-9_]*)\"$")
	@And("User clicks on {string}")
	public void User_clicks_on(String locatorKey) throws InterruptedException, Exception, IOException {
		try {
			commonActions.pressTab();
			commonActions.click(locatorKey);
			commonActions.pressTab();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			commonActions.logAssert_Fail("Fail | Clicking failed -" + locatorKey);
		}
	}

	@And("^User navigates to \"(.*?)\" in \"(.*?)\"$")
	public void User_mouseovers_and_navigates_to(String clickElementKey, String mouseoverelementKey)
			throws InterruptedException {
		try {
			Thread.sleep(5000);
			commonActions.mouseover(mouseoverelementKey);
			commonActions.click(clickElementKey);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			commonActions.logAssert_Fail("Fail | User navigates to failed -" + clickElementKey);
		}

	}

	// User submits generated TAN number using "MobileTanLink_VorlageAnlegen" on
	// "TAN_field_VorlageAnlegen"
	@And("^User submits generated TAN number using \"(.*?)\" on \"(.*?)\"$")
	public void user_submits_the_generated_TAN_number_using(String mobileTanlink, String tanField)

			throws ClientProtocolException, IOException, InterruptedException, Exception, SAXException {
		try {
			// commonActions.clickonMobiletanLinkandEnterTan(mobileTanlink,
			// tanField);
			commonActions.enterLoadenvironmentTan(tanField, "12345678");
			// commonActions.click("BestaetigenButton");
			// if
			// (!commonActions.getFeatureName().equals("UC58_61_EinzelEroeffnet"))
			// {
			// if (!commonActions.isElementPresent("Mein_Konto_Depot")) {
			// if (commonActions.isElementPresent("UsedTanMessage")) {
			// commonActions.clearfield(TanKey);
			// Thread.sleep(60000);
			// commonActions.clickonMobiletanLinkandEnterTan(TanKey,
			// "MobileTAN_link_Login");
			// commonActions.click("BestaetigenButton");
			// if (commonActions.isElementPresent("UsedTanMessage"))
			// commonActions.logAssert_Fail("Unable to login due to reused
			// tan.");
			// commonActions.takeSceenShot();
			// }
			// }
			// }
		} catch (Exception e) {
			e.printStackTrace();
			commonActions.logAssert_Fail("Enter tan failed");
		}
	}

	@And("^User Logs in with \"(.*?)\",\"(.*?)\"$")
	public void User_Logs_in_with(String UserID_Kontonummer, String PIN_Password)
			throws Exception, InterruptedException, IOException, ParseException {
		commonActions.click("Login");
		commonActions.enterTextToLogin(UserID_Kontonummer, "UserID_Kontonummer");
		commonActions.enterTextToLogin(PIN_Password, "PIN_Password");
		commonActions.click("Einloggen");
		commonActions.logInfoStatus(
				"Info | Login with Account Number : " + commonActions.getValueFromJson("UserID_Kontonummer"));
		commonActions.takeSceenShot();

	}

	@And("^User is redirected to login page to login with \"(.*?)\",\"(.*?)\"$")
	public void User_is_redirected_to_login_page(String UserID_Kontonummer, String PIN_Password)
			throws Exception, InterruptedException, IOException, ParseException {
		commonActions.enterTextToLogin(UserID_Kontonummer, "UserID_Kontonummer");
		commonActions.enterTextToLogin(PIN_Password, "PIN_Password");
		commonActions.click("Einloggen");
		commonActions.logInfoStatus(
				"Info | Login with Account Number : " + commonActions.getValueFromJson("UserID_Kontonummer"));
		commonActions.takeSceenShot();

	}

//	@When("User \"(.*?)\" in \"(.*?)\" field")
//	public void User_unchecked_in_checkbox(String check, String locatorKey) throws InterruptedException {
//		try {
//			// System.out.println(check);
//			String str1 = commonActions.getValueFromJson(check);
//			commonActions.clearCheckBox(locatorKey);
//			if (str1.equals("null")) {
//				// System.out.println("checkbox is unchecked");
//			} else {
//				commonActions.click(locatorKey);
//			}
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			Assert.fail();
//		}
//
//	}

	@When("User selects radiobutton {string} in {string}")
	public void User_selects_radiobutton(String dataKey, String locatorKey) {
		try {
			String str = commonActions.getValueFromJson(dataKey);
			if (str.equalsIgnoreCase("Nein")) {
				commonActions.click(locatorKey + "_Nein");
			} else if (str.equalsIgnoreCase("Ja")) {
				commonActions.click(locatorKey + "_Ja");
			} else if (dataKey.equals("Die_eingegebene_Adresse_ist_nicht_eindeutig")
					|| dataKey.equals("Die_eingegebene_Adresse_ist_nicht_eindeutig_1")
					|| dataKey.equals("Die_eingegebene_Adresse_ist_nicht_eindeutig_2")
					|| dataKey.equals("DieEingegebeneAdresseIstNichtEindeutig1_Kontoinhaber")
					|| dataKey.equals("Die_eingegebene_Adresse_ist_nicht_eindeutig_2")
					|| dataKey.equals("Die_eingegebene_Adresse_ist_nicht_eindeutig_3")) {

				Thread.sleep(2000);
				commonActions.click(locatorKey);
			} else if (str.equals("")) {

			} else {
				commonActions.pressTab();
				commonActions.click(locatorKey);

			}
		} catch (Exception e) {
			e.printStackTrace();
			commonActions.logAssert_Fail("Exception has been thrown");
		}

	}

	@And("^User selects \"(.*?)\" in \"(.*?)\"$")
	public void User_selects(String dataKey, String locatorKey) throws Exception {
		try {
			if (dataKey.equals("Account_Type")) {
				commonActions.selectFromDropDownByValue(locatorKey, dataKey);
			} else {
				commonActions.selectFromDropDown(locatorKey, dataKey);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			commonActions.logAssert_Fail("User selects failed");
		}
	}

	@And("User selects checkbox {string} in {string}")
	public void User_selects_checkbox(String dataKey, String locatorKey)
			throws FileNotFoundException, IOException, ParseException, InterruptedException {
		try {
			String str = commonActions.getValueFromJson(dataKey);
			commonActions.clearRadioButton(locatorKey);
			if (str.equals("Check") || str.equalsIgnoreCase("Select")) {
				commonActions.click(locatorKey);
			} else if (str.equals("")) {

			}
		} catch (Exception e) {
			e.printStackTrace();
			commonActions.logAssert_Fail("Clicking failed on: " + locatorKey);
		}

	}

	@And("^User submits generated TAN number in \"(.*?)\"$")
	public void User_submits_generated_TAN_number(String tankey) throws InterruptedException {
		if (commonActions.isElementPresent("SecurePlusLink")) {
			commonActions.click("SecurePlusLink");
		}
		commonActions.enterTexttoken(tankey, "12345678");
		commonActions.click("BestaetigenButton");
	}

}
