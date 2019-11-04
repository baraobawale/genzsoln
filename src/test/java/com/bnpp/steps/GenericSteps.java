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

	String Ueberweisungslimit_MaxLimit = "";
	String Ueberweisungslimit_DecreaseMaxLimitByOne = "";
	String Ueberweisungslimit_IncreaseMaxLimitByOne = "";

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
		try {

			if (locatorKey.equals("Steueridentifikationsnummer_PersoenlicheEinstellungen")
					|| locatorKey.equals("TelefonPrivat_AngabenZurPerson") || locatorKey.equals("Ort1_Kontoinhaber")) {
				commonActions.enterText(locatorKey, dataKey);
				// Move the focus out of field to handle the error displayed on
				// clearing the field.
				commonActions.pressTab();
				// Different step definition for tab.
			} else if (locatorKey.equals("Uberweisungslimit_Ueberweisungslimit")) {
				if (commonActions.getScenarioName().equals("Ueberweisungslimit_MaxLimit_Error")) {
					WebElement text = commonActions.getElement("Max_limit");
					Ueberweisungslimit_MaxLimit = text.getAttribute("data-evr-max-limit");
					int cnt = Integer.parseInt(Ueberweisungslimit_MaxLimit);
					cnt = cnt + 1;
					commonActions.setText(locatorKey, String.valueOf(cnt));
					// Move the focus out of field to handle the error displayed
					// on
					// clearing the field.
					commonActions.pressTab();
				} else if (commonActions.getScenarioName().equals("Ueberweisungslimit_Aendern")) {
					WebElement text = commonActions.getElement("Max_limit");
					Ueberweisungslimit_MaxLimit = text.getAttribute("data-evr-max-limit");
					int cnt = Integer.parseInt(Ueberweisungslimit_MaxLimit);
					cnt = cnt - 1;
					commonActions.setText(locatorKey, String.valueOf(cnt));
					commonActions.logPassStatus("Ueberweisungslimit is set to" + cnt);
					// Move the focus out of field to handle the error displayed
					// on
					// clearing the field.
					commonActions.pressTab();
					/// Make scenarios different
				} else if (locatorKey.equals("Limit_OrderErteilen")
						&& commonActions.getScenarioName().equals("KaufOrder_Anlegen_Aktie")) {
					locatorKey = "Stop_OrderErteilen";
					commonActions.enterText(locatorKey, dataKey);
				}else {
					commonActions.enterText(locatorKey, dataKey);
					commonActions.pressTab();
				}
			}else if(locatorKey.equals("Datum_TerminAnlegen")) {
				String noOfDays=commonActions.getKeyFromJson("Datum");
				String inputDate=commonActions.enterFutureDateAddingDays(noOfDays);
				commonActions.enterText(locatorKey,inputDate);
			}

			else
				commonActions.enterText(locatorKey, dataKey);
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
	@And("^User clicks on \"(.*)\"$")
	public void User_clicks_on(String locatorKey) throws InterruptedException, Exception, IOException {
		try {
			// if
			// ((commonActions.getScenarioName().equals("KaufOrder_Anlegen_Aktie")
			// && locatorKey.equals("Handelsplatz_OrderErteilen"))
			// ||
			// (commonActions.getScenarioName().equals("KaufOrder_Anendern_Aktie")
			// && locatorKey.equals("Limithandel_OrderErteilen"))
			// ||
			// (commonActions.getScenarioName().equals("KaufOrder_Anlegen_Fonds1")
			// && locatorKey.equals("Handelsplatz_OrderErteilen"))) {
			// if (commonActions.isElementPresent("RiskoclassePopup")) {
			// commonActions.click("Riskocheckbox");
			// commonActions.click("Riskocalssebutton");
			// }
			// }
			// Add statement for delete template
			

				// Add code to revert to vorlage template display page if
				// not
			
//			if (locatorKey.equals("ZumZahlungsverkehr_VorlageAnlegen")) {
//				commonActions.click(locatorKey);
//				commonActions.isElementPresent("Vorlagen_UmsaetzeZahlungsverkehr");
//			//	commonActions.moveScrollDown();
			 if (locatorKey.equals("WeiterZurTanEingabe_Ueberweisungslimit")) {
				commonActions.click(locatorKey);
				commonActions.pressTab();
			} else if (locatorKey.equals("Bestaetigen_Benachrichtigungen")) {
				System.out.println("Value of loactorkey-----------" + locatorKey);
				commonActions.pressTab();
				commonActions.click(locatorKey);

			} else if (locatorKey.equals("ZumZahlungsverkehr_VorlageAnlegen")) {
				commonActions.click(locatorKey);
				commonActions.isElementPresent("Vorlagen_UmsaetzeZahlungsverkehr");
				//commonActions.moveScrollDown();
				// Check for select drop down
			} else if (locatorKey.equals("Handelsplatz_Tradegate")
					&& commonActions.getScenarioName().equals("KaufOrder_Anlegen_Anleihe")) {
				commonActions.pressEnter();

			} else if (locatorKey.equals("Handelsplatz"))
				commonActions.waitForVisibilityofElement(locatorKey);
			else if (locatorKey.equals("CloseWindow_SessionTANAktivieren")) {
				// commonActions.click(locatorKey);
				Thread.sleep(5000);
				commonActions.refreshPage();
				Thread.sleep(5000);
			
			} else if (locatorKey.equals("WeiterTANEingabe_OrderErteilen")) {
				Thread.sleep(10000);
				commonActions.click(locatorKey);
			} else
				commonActions.click(locatorKey);
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

	@And("^User selects \"(.*?)\" in \"(.*?)\"$")
	public void User_selects(String dataKey, String locatorKey) throws Exception {
		try {
			if (locatorKey.equals("Handelsplatz_OrderErteilen")
					&& commonActions.getFeatureName().equals("UC82_Authorization")) {
				if (commonActions.isElementPresent("RiskoclassePopup")) {
					commonActions.click("Riskocheckbox");
					commonActions.click("Riskocalssebutton");
				}
			}
			if (dataKey.equals("Hinweis_gelesen") || dataKey.equals("Kenntnisse_vorhanden")
					|| dataKey.equals("Wertpapierkaeufe") || dataKey.equals("Orderart")) {

				String str1 = commonActions.getValueFromJson(dataKey);
				commonActions.clearCheckBox(locatorKey);
				if (str1.equalsIgnoreCase("Null")) {
					// System.out.println("checkbox is unchecked");
				} else {
					commonActions.click(locatorKey);
				}
			} else if (dataKey.equals("Name_WKN_ISIN")) {
				commonActions.enterText(locatorKey, dataKey);
				Thread.sleep(3000);
				commonActions.click("NameWKN");
			} else if (dataKey.equals("Ich_bestaetige")) {
				String str1 = commonActions.getValueFromJson(dataKey);
				commonActions.clearCheckBox(locatorKey);
				if (str1.equals("null")) {
					// System.out.println("checkbox is unchecked");
				} else {
					commonActions.click(locatorKey);
				}
			} else if (dataKey.equals("Handelsplatz")) {
				commonActions.click("Handelsplatz_OrderErteilen_1");
				Thread.sleep(2000);
				commonActions.click("Handelsplatz_OrderErteilen_2");
				// Make different functions of Select
			} else if (dataKey.equals("Account_Type")) {
				commonActions.selectFromDropDownByValue(locatorKey, dataKey);
			

			} else if (dataKey.equals("Ordertyp")) {
				commonActions.selectFromDropDown(locatorKey, dataKey);
			} else if (dataKey.equals("Beruf_1")) {
				commonActions.selectFromDropDown(locatorKey, dataKey);
			} else if (dataKey.equals("Branche_1")) {
				commonActions.selectFromDropDown(locatorKey, dataKey);

			} else {
				commonActions.selectFromDropDown(locatorKey, dataKey);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@And("User selects checkbox {string} in {string}")
	public void User_selects_checkbox(String dataKey, String locatorKey)
			throws FileNotFoundException, IOException, ParseException, InterruptedException {

		try {
			if (commonActions.getFeatureName().equals("UC3_Dauerauftraege")) {
				if (locatorKey.equals("Unbegrenzt_gültig")) {
					// commonActions.click(locatorKey);
				}

				String str1 = commonActions.getValueFromJson(dataKey);
				if (str1.equals("select") && dataKey.equals("Als_Vorlage_speichern")) {
					commonActions.click(locatorKey);
				}
			} else if (commonActions.getFeatureName().equals("UC76_77_EMailBenachrichtigungen")) {
				String str1 = commonActions.getValueFromJson(dataKey);
				System.out.println("Value of str1   " + str1);

				if (str1.equals("Check")) {
					commonActions.clearRadioButton(locatorKey);
					commonActions.click(locatorKey);
				} else {
					commonActions.clearRadioButton(locatorKey);
				}
			} else if (dataKey.equals("Mit_sehr_hohem_Risiko")
					&& commonActions.getScenarioName().equals("Einzelkonto_DepotCFD_BestehendesKonto")) {
				commonActions.click(locatorKey);
				commonActions.click(locatorKey);
			} else if (commonActions.getFeatureName().equals("UC71_Datenschutz")) {
				String str1 = commonActions.getValueFromJson(dataKey);
				commonActions.clearCheckBox(locatorKey);
				if (str1.equals("null")) {
					// System.out.println("checkbox is unchecked");
				} else {
					commonActions.click(locatorKey);
				}
			} else if (commonActions.getFeatureName().equals("UC78_79_Aboservice")) {
				String str1 = commonActions.getValueFromJson(dataKey);
				System.out.println("Value of str1   " + str1);

				if (str1.equals("Null")) {

				} else if (str1.equals("Select")) {
					commonActions.click(locatorKey);

				} else {
					commonActions.click(locatorKey);
				}
			}

			else
				commonActions.click(locatorKey);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			commonActions.logAssert_Fail("Clicking failed on: " + locatorKey);
		}

	}

	// User submits generated TAN number using "MobileTanLink_VorlageAnlegen" on
	// "TAN_field_VorlageAnlegen"
	@And("^User submits generated TAN number using \"(.*?)\" on \"(.*?)\"$")
	public void user_submits_the_generated_TAN_number_using(String mobileTanlink,String tanField)

			throws ClientProtocolException, IOException, InterruptedException, Exception, SAXException {
		try {
			//commonActions.clickonMobiletanLinkandEnterTan(mobileTanlink, tanField);
			commonActions.enterLoadenvironmentTan(tanField,"12345678");
//			commonActions.click("BestaetigenButton");
//			if (!commonActions.getFeatureName().equals("UC58_61_EinzelEroeffnet")) {
//				if (!commonActions.isElementPresent("Mein_Konto_Depot")) {
//					if (commonActions.isElementPresent("UsedTanMessage")) {
//						commonActions.clearfield(TanKey);
//						Thread.sleep(60000);
//						commonActions.clickonMobiletanLinkandEnterTan(TanKey, "MobileTAN_link_Login");
//						commonActions.click("BestaetigenButton");
//						if (commonActions.isElementPresent("UsedTanMessage"))
//							commonActions.logAssert_Fail("Unable to login due to reused tan.");
//						commonActions.takeSceenShot();
//					}
//				}
//			}
		}catch (Exception e) {
			e.printStackTrace();
			commonActions.logAssert_Fail("Enter tan failed");
		}
	}

	@And("^User Logs in with \"(.*?)\",\"(.*?)\"$")
	public void User_Logs_in_with(String UserID_Kontonummer, String PIN_Password)
			throws Exception, InterruptedException, IOException, ParseException {
		commonActions.click("Login");
		commonActions.enterText(UserID_Kontonummer, "UserID_Kontonummer");
		commonActions.enterText(PIN_Password, "PIN_Password");
		commonActions.click("Einloggen");
		commonActions.logInfoStatus(
				"Info | Login with Account Number : " + commonActions.getValueFromJson("UserID_Kontonummer"));
		commonActions.takeSceenShot();

	}
	
	@And("^User is redirected to login page to login with \"(.*?)\",\"(.*?)\"$")
	public void User_is_redirected_to_login_page(String UserID_Kontonummer, String PIN_Password)
			throws Exception, InterruptedException, IOException, ParseException {
		commonActions.enterText(UserID_Kontonummer, "UserID_Kontonummer");
		commonActions.enterText(PIN_Password, "PIN_Password");
		commonActions.click("Einloggen");
		commonActions.logInfoStatus(
				"Info | Login with Account Number : " + commonActions.getValueFromJson("UserID_Kontonummer"));
		commonActions.takeSceenShot();

	}

	@When("User \"(.*?)\" in \"(.*?)\" field")
	public void User_unchecked_in_checkbox(String check, String locatorKey) throws InterruptedException {
		try {
			// System.out.println(check);
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
	/// New Mobile Tan generation

	@When("User selects radiobutton {string} in {string}")
	public void User_selects_radiobutton_in(String dataKey, String locatorKey) {
		try {
			String str = commonActions.getValueFromJson(dataKey);
			System.out.println("str for datakey:" + str + " " + dataKey);
			commonActions.clearRadioButton(locatorKey);
			if (str.equals("Nein")) {
				commonActions.click(locatorKey + "_Nein");
			} else if (str.equals("Ja")) {
				commonActions.click(locatorKey + "_Ja");
			} else if (dataKey.equals("Die_eingegebene_Adresse_ist_nicht_eindeutig")
					|| dataKey.equals("Die_eingegebene_Adresse_ist_nicht_eindeutig_1")
					|| dataKey.equals("Die_eingegebene_Adresse_ist_nicht_eindeutig_2")
					|| dataKey.equals("DieEingegebeneAdresseIstNichtEindeutig1_Kontoinhaber")
					|| dataKey.equals("Die_eingegebene_Adresse_ist_nicht_eindeutig_2")
					|| dataKey.equals("Die_eingegebene_Adresse_ist_nicht_eindeutig_3")) {
				commonActions.pressTab();
				Thread.sleep(2000);
				commonActions.click(locatorKey);
			} else {
				commonActions.click(locatorKey);
			}
		} catch (Exception e) {
			e.printStackTrace();
			commonActions.logAssert_Fail("Exception has been thrown");
		}

	}

//	@When("user clicks on {string} in {string}")
//	public void User_clicks_on_in(String locatorKey, String string) {
//		try {
//			commonActions.click(locatorKey);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//
//	}
	
	@And("^User submits generated TAN number in \"(.*?)\"$")
	public void User_submits_generated_TAN_number(String tankey) throws InterruptedException{
		commonActions.enterTexttoken(tankey, "12345678");
		commonActions.click("BestaetigenButton");
	}
	
		
	}


