package com.bnpp.steps;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import javax.xml.parsers.ParserConfigurationException;

import org.apache.http.client.ClientProtocolException;
import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ISelect;
import org.xml.sax.SAXException;

import com.bnpp.library.CommonActions;
import com.bnpp.mTANResources.MobileTan;
import com.bnpp.utilities.TANGenerator;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
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

	@And("^User enters \"(.*?)\" in \"(.*?)\"$")
	public void type(String dataKey, String locatorKey)
			throws IllegalArgumentException, InterruptedException, IOException, ParseException {
		if (locatorKey.equals("Steueridentifikationsnummer_PersoenlicheEinstellungen")) {
			commonActions.enterText(locatorKey, dataKey);
			// Move the focus out of field to handle the error displayed on
			// clearing the field.
			commonActions.pressTab();
		} 
        else if(locatorKey.equals("Uberweisungslimit_Ueberweisungslimit")) {
            if(commonActions.getScenarioName().equals("Ueberweisungslimit_MaxLimit_Error")) {
                  WebElement text = commonActions.getElement("Max_limit");
                  Ueberweisungslimit_MaxLimit = text.getAttribute("data-evr-max-limit");
                  int cnt = Integer.parseInt(Ueberweisungslimit_MaxLimit);
                  cnt = cnt +1;
                  commonActions.setText(locatorKey, String.valueOf(cnt));
                  // Move the focus out of field to handle the error displayed on
                  // clearing the field.
                  commonActions.pressTab();
            }      
         else if(commonActions.getScenarioName().equals("Ueberweisungslimit_Aendern")) {
                  WebElement text = commonActions.getElement("Max_limit");
                  Ueberweisungslimit_MaxLimit = text.getAttribute("data-evr-max-limit");
                  int cnt = Integer.parseInt(Ueberweisungslimit_MaxLimit);
                  cnt = cnt -1;
                  commonActions.setText(locatorKey, String.valueOf(cnt));
                  commonActions.logPassStatus("Ueberweisungslimit is set to"+cnt);
                  // Move the focus out of field to handle the error displayed on
                  // clearing the field.
                  commonActions.pressTab();
            } 
      else {
            commonActions.enterText(locatorKey, dataKey);
            commonActions.pressTab();
     }
     }      

		else
			commonActions.enterText(locatorKey, dataKey);

	}

	@And("^User clears \"(.*?)\"$")
	public void clear(String locatorKey) {

		commonActions.clearfield(locatorKey);
	}

	@And("^User clicks on \"(.*?)\"$")
	public void click(String locatorKey) throws InterruptedException, Exception, IOException {
		if (locatorKey.equals("Aendern") || locatorKey.equals("Neue_Ueberweisungsvorlage_anlegen")
				|| locatorKey.equals("Vorlagen_UmsaetzeZahlungsverkehr") || locatorKey.equals("Terminueberweisungen_UmsaetzeZahlungsverkehr")) {
			commonActions.moveScrollDown();
			commonActions.waitForVisibilityofElement(locatorKey);
			commonActions.click(locatorKey);
		} else if (locatorKey.equals("UeberweisungsvorlageAnlegen_VorlageAnlegen")) {
			commonActions.click(locatorKey);
			if (commonActions.isElementPresent("New_mobile_tan")) {
				commonActions.enterTokenTan("TAN_field_VorlageAnlegen", TANGenerator.requestTan());
				commonActions.click(locatorKey);
			}
		} else if (locatorKey.equals("ZumZahlungsverkehr_VorlageAnlegen")) {
			commonActions.click(locatorKey);
			commonActions.isElementPresent("Vorlagen_UmsaetzeZahlungsverkehr");
			commonActions.moveScrollDown();
		}
		else if (locatorKey.equals("WeiterZurTanEingabe_Ueberweisungslimit")) {
            commonActions.click(locatorKey);
            commonActions.pressTab();
        }
		else
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
                       || dataKey.equals("Wertpapierkaeufe") || dataKey.equals("Ich_bestaetige")) {
                 System.out.println(dataKey);
                 String str1 = commonActions.getValueFromJson(dataKey);
                 commonActions.clearCheckBox(locatorKey);
                 if (str1.equals("null")) {
                       // System.out.println("checkbox is unchecked");
                 } else {
                       commonActions.click(locatorKey);
                 }
          }
          else if(dataKey.equals("Account_Type")) {
                 commonActions.selectFromDropDownByValue(locatorKey, dataKey);
          }
          else {
                 commonActions.selectFromDropDown(locatorKey, dataKey);
          }
    }


	@And("^User submits generated TAN number in \"(.*?)\"$")
	public void user_submits_the_generated_TAN_number_in(String TanKey)
			throws ClientProtocolException, IOException, InterruptedException, Exception, SAXException {
		if (TanKey.equals("TAN_field_Login")) {
			commonActions.enterTokenTan(TanKey, TANGenerator.requestTan());
			// commonActions.enterTokenTan(TanKey,"931272");
			commonActions.click("BestaetigenButton");
			if (!commonActions.isElementPresent("Mein_Konto_Depot")) {
				if (commonActions.isElementPresent("UsedTanMessage")) {
					commonActions.clearfield(TanKey);
					commonActions.enterTokenTan(TanKey, TANGenerator.requestTan());

					commonActions.click("BestaetigenButton");
				}
			}
		} else {
			Properties prop = new Properties();
			// FileInputStream fis = new
			// FileInputStream("C:\\workspace\\mobileTANTest\\src\\main\\java\\mTANResources\\data.properties");
			FileInputStream fis = new FileInputStream(
					System.getProperty("user.dir") + "\\src\\test\\java\\com\\bnpp\\mTANResources\\data.properties");
			prop.load(fis);
			String customerId = prop.getProperty("userID");
			String customerPin = prop.getProperty("pin");
			String cafeUser = prop.getProperty("cafeUserID");
			String cafePin = prop.getProperty("cafePin");

			// Redirecting Mobile TAN
			MobileTan mt = new MobileTan();
			mt.mTanRedirection(customerId, customerPin, cafeUser, cafePin);

			// String MobileTAN_link_Login = "//a[@id='mobile-tan-request']";
			commonActions.click("MobileTAN_link_Login");

			String mTAN = mt.getMTan(customerId, customerPin, cafeUser, cafePin);
			System.out.println("mTAN is  -" + mTAN);
			commonActions.enterTokenTan(TanKey, mTAN);
			// commonActions.enterTokenTan(TanKey, TANGenerator.requestTan());
		}
		if(TanKey.equals("TAN_field_Ueberweisungslimit")) {
             commonActions.pressTab();
		}
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
	/// New Mobile Tan generation

	@When("User submits generated Mobile TAN number")
	public void user_submits_generated_Mobile_TAN_number_in()
			throws InterruptedException, ParserConfigurationException, SAXException, IOException {

		// Loading property files and its values
		Properties prop = new Properties();
		// FileInputStream fis = new
		// FileInputStream("C:\\workspace\\mobileTANTest\\src\\main\\java\\mTANResources\\data.properties");
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\java\\com\\bnpp\\mTANResources\\data.properties");
		prop.load(fis);
		String customerId = prop.getProperty("userID");
		String customerPin = prop.getProperty("pin");
		String cafeUser = prop.getProperty("cafeUserID");
		String cafePin = prop.getProperty("cafePin");

		// Redirecting Mobile TAN
		MobileTan mt = new MobileTan();
		mt.mTanRedirection(customerId, customerPin, cafeUser, cafePin);

		// String MobileTAN_link_Login = "//a[@id='mobile-tan-request']";
		commonActions.click("MobileTAN_link_Login");

		String mTAN = mt.getMTan(customerId, customerPin, cafeUser, cafePin);
		System.out.println("mTAN is  -" + mTAN);
		commonActions.enterTokenTan("TAN_field_Login", mTAN);
		commonActions.click("BestaetigenButton");

	}

}
