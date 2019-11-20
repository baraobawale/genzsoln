package com.bnpp.steps;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Assert;
import com.bnpp.library.CommonActions;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.runtime.CucumberException;

public class UC69_70_Risikoklasse {

	CommonActions commonActions;

	public UC69_70_Risikoklasse(CommonActions commonActions) {
		this.commonActions = commonActions;
	}

	@When("User navigates to {string}")
	public void user_navigates_to(String string) throws InterruptedException {
		try {
			commonActions.mouseover("Mein_Konto_Depot");
			System.out.println(string);
			Thread.sleep(5000);
			commonActions.click(string);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@When("User selects {string} in Risikoklasse {string} field")
	public void user_selects_in_Risikoklasse_field(String locatorKey, String string2) {
		try {
			commonActions.click(locatorKey);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Assert.fail();
		}
	}

	@Then("^Verify displayed ErrorMesssages on RisikoklasseFinanztermingeschaefte$")
	public void Verify_displayed() throws FileNotFoundException, IOException, org.json.simple.parser.ParseException {
		try {
			if (commonActions.isElementPresent("HeadingError"))
				commonActions.logPassStatus("Pass | Valid message displayed HeadingError");
			else
				commonActions.logFailStatus("Fail | Valid message display failed HeadingError");
			if (commonActions.isElementPresent("Hinweis_gelesenError"))
				commonActions.logPassStatus("Pass | Valid message displayed Hinweis_gelesenError");
			else
				commonActions.logFailStatus("Fail | Valid message display failed Hinweis_gelesenError");
			if (commonActions.isElementPresent("ProduktgruppeError"))
				commonActions.logPassStatus("Pass | Valid message displayed ProduktgruppeError");
			else
				commonActions.logFailStatus("Pass | Valid message display failed ProduktgruppeError");
		} catch (CucumberException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			commonActions.logFailStatus(
					"Fail | Valid check step definition and feature file configured correctly with respect to arguments ");
		}

	}

	@Then("verify success message shown on bestaetigung page")
	public void verify_success_message_shown_on_bestaetigung_page() throws InterruptedException {
		// commonActions.getElement("Ihre_Angaben_wurden_erfolgreich_gespeichert_und_ausgewertet");

		try {
			if (commonActions.isElementPresent("Ihre_Angaben_wurden_erfolgreich_gespeichert_und_ausgewertet"))
				commonActions.logPassStatus(
						"Pass | Ihre_Angaben_wurden_erfolgreich_gespeichert_und_ausgewertet message display success");
			else
				commonActions.logFailStatus(
						"Fail | Ihre_Angaben_wurden_erfolgreich_gespeichert_und_ausgewertet message display failed");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			commonActions.logAssert_Fail("verify success message shown on bestaetigung page failed");
		}

	}

}
