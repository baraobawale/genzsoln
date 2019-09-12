package com.bnpp.steps;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.HashMap;
import org.json.simple.parser.ParseException;
import org.junit.Assert;

import com.bnpp.library.CommonActions;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class UC67_68_Stammdaten {

	CommonActions commonActions;

	public UC67_68_Stammdaten(CommonActions con) {
		this.commonActions = con;
	}

	HashMap<String, String> hmap = new HashMap<String, String>();

	@Then("^Verify displayed \"(.*?)\"$")
	public void verify_error_messsages_are_displayed(String ErrorMesssages)
			throws FileNotFoundException, IOException, ParseException {

		try {
			commonActions.verifyErrorMessage("BrancheError").equals(commonActions.getText("Branchie_errorMessage"));
			commonActions.logPassStatus("Branchie message displayed successfully");
			commonActions.verifyErrorMessage("PLZError").equals(commonActions.getText("plz_errorMessage"));
			commonActions.logPassStatus("PLZ message displayed successfully");
			commonActions.verifyErrorMessage("StrabeError").equals(commonActions.getText("StraBe_errorMessage"));
			commonActions.logPassStatus("Strasse message displayed successfully");
			commonActions.verifyErrorMessage("OrtError").equals(commonActions.getText("Ort_errorMessage"));
			commonActions.logPassStatus("Ort message displayed successfully");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Assert.fail();
		}
	}

	@Then("^verify changed data shown on bestaetigung page$")
	public void verify_changed_data_shown_on_bestaetigung_page() {
		try {
			System.out.println(commonActions.getText("PLZ_txtVerify"));
			String[] txtVerify = commonActions.getText("PLZ_txtVerify").split("\\s+");
			System.out.println(commonActions.getValueFromJson("PLZ"));
			if (txtVerify[0].equals(commonActions.getValueFromJson("PLZ")))
				commonActions.logPassStatus("Data save success for PLZ");
			else
				commonActions.logFailStatus("Data save fail for PLZ");

			if (txtVerify[1].equals(commonActions.getValueFromJson("Ort")))
				commonActions.logPassStatus("Data save success for Ort");
			else
				commonActions.logFailStatus("Data save fail for Ort");

			if (commonActions.getText("Land_txtVerify").equals(commonActions.getValueFromJson("Land")))
				commonActions.logPassStatus("Data save success for Land");
			else
				commonActions.logFailStatus("Data save fail for Land");

			if (commonActions.getText("Steueridentifikationsnummer_txtVerify")
					.equals(commonActions.getValueFromJson("Steueridentifikationsnummer")))
				commonActions.logPassStatus("Data save success for Steueridentifikationsnummer");
			else
				commonActions.logFailStatus("Data save fail for Steueridentifikationsnummer");

		} catch (Exception e) {
			e.printStackTrace();
			commonActions.logAssert_Fail("Data save fail");
		}

	}

}
