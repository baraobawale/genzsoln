package com.bnpp.steps;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.StaleElementReferenceException;
import org.xml.sax.SAXException;

import com.bnpp.library.CommonActions;
import com.bnpp.utilities.Configurations;

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
			commonActions.initReports(s.getName() + "_" + System.getProperty("browser"));
		} else {
			commonActions.initReports(s.getName() + "_" + "chrome");
		}
		commonActions.setfeaturefilenameandsceanrio(s.getId(), s.getName());
		commonActions.setScenario(s);
	}

	/**
	 * Description Closing the resources after execution of each scenario
	 * 
	 * @throws IOException
	 */

	@After
	public void after(Scenario s) throws IOException {
		// ZonedDateTime finishDateTime = ZonedDateTime.now();
		// testFinish =
		// finishDateTime.truncatedTo(ChronoUnit.SECONDS).format(DateTimeFormatter.ISO_OFFSET_DATE_TIME);
		//
		// if (s.isFailed()) {
		// Xray.writeResultsForSingleTest(ExecutionID, XrayIssueKey,
		// XRAY_CONFIG.TEST_STATUS_FAIL, testStart,
		// testFinish);
		// } else {
		// Xray.writeResultsForSingleTest(ExecutionID, XrayIssueKey,
		// XRAY_CONFIG.TEST_STATUS_PASS, testStart,
		// testFinish);
		// }

		/*
		 * WebDriver dr = commonActions.getDriver(); TakesScreenshot scrShot =
		 * ((TakesScreenshot)dr); File SrcFile =
		 * scrShot.getScreenshotAs(OutputType.FILE); File DestFile=new
		 * File("C:\\Bitbucket\\rta\\scrn.png"); FileUtils.copyFile(SrcFile, DestFile);
		 * //byte[] data = FileUtils.readFileToByteArray(DestFile); byte[] data =
		 * scrShot.getScreenshotAs(OutputType.BYTES); String testName = s.getName();
		 * s.embed(data,"image/png"); s.write(testName);
		 */
		commonActions.quit();

	}

	// ********Common step definitions ************//
	/*
	 * private String getTestIdFromFileName(String path) { String result = ""; File
	 * f = new File(path); //System.out.println("File Name1: " +
	 * f.getName().toString().toUpperCase().replace("_", "-").trim()); result =
	 * f.getName().toString().toUpperCase().replace("_",
	 * "-").trim().split(".FEATURE")[0]; System.out.println("File Name: " + result);
	 * // result = f.getName().toString().toUpperCase().replace("_", "-").trim();
	 * return result; }
	 * 
	 */
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
			String textToEnter = commonActions.getValueFromJson(dataKey);
			/************ for testing purpose */
			// if(locatorKey.equals("EMail2_GesetzlicherVertreter1Page")) {
			// commonActions.click(locatorKey);
			// }

			/*******************************************/
			if (textToEnter.equals("")) {
				commonActions.clearfield(locatorKey);
			} else {
				// commonActions.click(locatorKey);
				commonActions.enterText(locatorKey, textToEnter);
			}
			commonActions.pressTab();

		} catch (ElementNotInteractableException e) {
			commonActions.logAssert_Fail(
					"Enter text failed on:- " + locatorKey + " :Please check element is visible on the page");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			commonActions.logAssert_Fail("Fail | Enter text failed on -" + locatorKey + ":" + dataKey);
		}

	}

	@And("^User clears \"(.*?)\"$")
	public void User_clears(String locatorKey) {

		try {
			commonActions.clearfield(locatorKey);
		} catch (ElementNotInteractableException e) {
			commonActions.logAssert_Fail("Please check element is visible on the page");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			commonActions.logAssert_Fail("Fail | Clear text failed on -" + locatorKey);
		}
	}

	@And("User clicks on {string}")
	public void User_clicks_on(String locatorKey) throws InterruptedException, Exception, IOException {
		try {
			commonActions.pressTab();
			commonActions.click(locatorKey);
			commonActions.pressTab();
		} catch (ElementNotInteractableException e) {
			// commonActions.logAssert_Fail(
			// "Clicking failed on:-" + locatorKey + " :Please check element is visible on
			// the page-");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			commonActions.logAssert_Fail("Fail | Clicking failed on -" + locatorKey);
		}
	}

	@And("^User navigates to \"(.*?)\" in \"(.*?)\"$")
	public void User_mouseovers_and_navigates_to(String clickElementKey, String mouseoverelementKey)
			throws InterruptedException {
		try {
			commonActions.mouseover(mouseoverelementKey);
			commonActions.click(clickElementKey);
		} catch (ElementNotInteractableException e) {
			commonActions.logAssert_Fail("Please check element is visible on the page: " + clickElementKey);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			commonActions.logAssert_Fail("Fail | User navigates to failed -" + clickElementKey);
		}

	}

	// Currently mobile tan simulator not working 13.11.2019
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
		} catch (ElementNotInteractableException e) {
			commonActions.logAssert_Fail(
					"Enter tan failed on:-" + tanField + " :Please check element is visible on the page: ");
		} catch (StaleElementReferenceException e) {

		} catch (Exception e) {
			e.printStackTrace();
			commonActions.logAssert_Fail("Enter tan failed: " + tanField);

		}
	}

	// 13-11Ganesh B: This step defninition is
	@And("^User Logs in with \"(.*?)\",\"(.*?)\"$")
	public void User_Logs_in_with(String UserID_Kontonummer, String PIN_Password)
			throws Exception, InterruptedException, IOException, ParseException {
		try {
			commonActions.click("Login");
			commonActions.enterTextToLogin(UserID_Kontonummer, "UserID_Kontonummer");
			commonActions.enterTextToLogin(PIN_Password, "PIN_Password");
			commonActions.click("Einloggen");
			commonActions.logInfoStatus(
					"Info | Login with Account Number : " + commonActions.getValueFromJson("UserID_Kontonummer"));
			commonActions.takeSceenShot();
		} catch (ElementNotInteractableException e) {
			commonActions.logAssert_Fail("Please check element is visible on the page");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			commonActions.logAssert_Fail("Login failed");
		}

	}

	@And("^User is redirected to login page to login with \"(.*?)\",\"(.*?)\"$")
	public void User_is_redirected_to_login_page(String UserID_Kontonummer, String PIN_Password)
			throws Exception, InterruptedException, IOException, ParseException {
		try {
			commonActions.enterTextToLogin(UserID_Kontonummer, "UserID_Kontonummer");
			commonActions.enterTextToLogin(PIN_Password, "PIN_Password");
			commonActions.click("Einloggen");
			commonActions.logInfoStatus(
					"Info | Login with Account Number : " + commonActions.getValueFromJson("UserID_Kontonummer"));
			commonActions.takeSceenShot();
		} catch (ElementNotInteractableException e) {
			e.printStackTrace();
			commonActions.logAssert_Fail("Please check element is visible on the page");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			commonActions.logAssert_Fail("User is redirected login page failed");
		}

	}

	// @When("User \"(.*?)\" in \"(.*?)\" field")
	// public void User_unchecked_in_checkbox(String check, String locatorKey)
	// throws InterruptedException {
	// try {
	// // System.out.println(check);
	// String str1 = commonActions.getValueFromJson(check);
	// commonActions.clearCheckBox(locatorKey);
	// if (str1.equals("null")) {
	// // System.out.println("checkbox is unchecked");
	// } else {
	// commonActions.click(locatorKey);
	// }
	// } catch (Exception e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// Assert.fail();
	// }
	//
	// }

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
				// Check the steps in feature file
			} else if (str.equals("")) {

			} else {
				commonActions.pressTab();
				commonActions.click(locatorKey);

			}
		} catch (ElementNotInteractableException e) {
			e.printStackTrace();
			commonActions.logAssert_Fail("Please check element is visible on the page: " + locatorKey + ":" + dataKey);
		} catch (Exception e) {
			e.printStackTrace();
			commonActions.logAssert_Fail("User selects radio button failed: " + locatorKey + ":" + dataKey);
		}
	}

	@And("^User selects \"(.*?)\" in \"(.*?)\"$")
	public void User_selects(String dataKey, String locatorKey) throws Exception {
		try {
			if (dataKey.equals("Account_Type") || dataKey.equals("Kategorie")) {
				commonActions.selectFromDropDownByValue(locatorKey, dataKey);
			} else {
				commonActions.selectFromDropDown(locatorKey, dataKey);
			}
		} catch (ElementNotInteractableException e) {
			e.printStackTrace();
			commonActions.logAssert_Fail("Please check element is visible on the page: " + locatorKey + ":" + dataKey);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			commonActions.logAssert_Fail("User selects failed: " + locatorKey + ":" + dataKey);
		}
	}

	@When("User selects value {string} in {string}")
	public void user_selects_value_in(String valueKey, String DropdownKey) {
		try {
			commonActions.click(DropdownKey);
			Thread.sleep(2000);
			commonActions.click(valueKey);
			Thread.sleep(1000);
			commonActions.pressTab();
			System.out.println("Element selected");
		} catch (ElementClickInterceptedException e) {
			e.printStackTrace();
			// System.out.println("Element could not be selected");

		} catch (ElementNotInteractableException e) {
			e.printStackTrace();
			// System.out.println("Element could not be selected");

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Element could not be selected");
			// commonActions.logAssert_Fail("Element could not be selected");
		}

	}

	@And("User selects checkbox {string} in {string}")
	public void User_selects_checkbox(String dataKey, String locatorKey)
			throws FileNotFoundException, IOException, ParseException, InterruptedException {
		try {
			String str = commonActions.getValueFromJson(dataKey);
			commonActions.clearRadioButton(locatorKey);
			// Make it uniform
			if (str.equalsIgnoreCase("Select")) {
				commonActions.click(locatorKey);
				// check feature file steps for blank
			} else {
			}

		} catch (ElementNotInteractableException e) {
			e.printStackTrace();
			commonActions.logAssert_Fail("Please check element is visible on the page: " + locatorKey + ":" + dataKey);
		} catch (Exception e) {
			e.printStackTrace();
			commonActions.logAssert_Fail("User selects checkbox failed: " + locatorKey + ":" + dataKey);
		}

	}

	@And("^User submits generated TAN number in \"(.*?)\"$")
	public void User_submits_generated_TAN_number(String tankey) throws InterruptedException {
		try {
			if (commonActions.getFeatureName().equals("UC49_50_53_54_GVKontoKind")) {
				commonActions.click("SecurePlusLink");
				commonActions.enterTexttoken(tankey, "12345678");
				commonActions.click("BestaetigenButton");
			}
		} catch (ElementNotInteractableException e) {
			e.printStackTrace();
			commonActions.logAssert_Fail("Please check element is visible on the page");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			commonActions.logAssert_Fail("User submits generated TAN number failed: " + tankey);
		}
	}

	@Then("Download PDF generated in New Tab")
	public void download_PDF_generated_in_New_Tab() throws InterruptedException {
		try {
			Thread.sleep(7000);
			commonActions.VerifyifFilePresent();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			// commonActions.logAssert_Fail(commonActions.getScenarioName()+ "failed");
		}
	}
}
