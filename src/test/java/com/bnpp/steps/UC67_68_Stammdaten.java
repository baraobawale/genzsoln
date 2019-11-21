package com.bnpp.steps;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import org.json.simple.parser.ParseException;
import com.bnpp.library.CommonActions;
import cucumber.api.java.en.Then;

public class UC67_68_Stammdaten {

	CommonActions commonActions;

	public UC67_68_Stammdaten(CommonActions con) {
		this.commonActions = con;
	}

	HashMap<String, String> hmap = new HashMap<String, String>();

	@Then("^Verify displayed \"(.*?)\" on PersoenlicheEinstellungen$")
	public void verify_error_messsages_are_displayed(String ErrorMesssages)
			throws FileNotFoundException, IOException, ParseException {
				
			if (commonActions.verifyErrorMessage("PLZError").equals(commonActions.getText("plz_errorMessage")))
				commonActions.logPassStatus("Pass | Valid PLZ message displayed "+commonActions.getText("plz_errorMessage"));
			else
				commonActions.logFailStatus("Fail | Valid PLZ message display fail "+commonActions.getText("plz_errorMessage"));
			
			if (commonActions.verifyErrorMessage("StrabeError").equals(commonActions.getText("StraBe_errorMessage")))
				commonActions.logPassStatus("Pass | Valid message displayed "+commonActions.getText("StraBe_errorMessage"));
			else
				commonActions.logFailStatus("Fail | Valid message display failed "+commonActions.getText("StraBe_errorMessage"));
			
			if (commonActions.verifyErrorMessage("OrtError").equals(commonActions.getText("Ort_errorMessage")))
				commonActions.logPassStatus("Pass | Valid message displayed "+commonActions.getText("Ort_errorMessage"));
			else
				commonActions.logFailStatus("Fail | Valid message display failed "+commonActions.getText("OrtError"));
			if (commonActions.verifyErrorMessage("BrancheError").equals(commonActions.getText("Branchie_errorMessage")))
				commonActions.logPassStatus("Pass | Valid message displayed "+commonActions.getText("Branchie_errorMessage"));
			else
				commonActions.logFailStatus("Fail | Valid message display failed "+commonActions.getText("Branchie_errorMessage"));
		
	}

	@Then("^verify changed data shown on bestaetigung page$")
	public void verify_changed_data_shown_on_bestaetigung_page() {
		try {
			System.out.println(commonActions.getText("PLZ_txtVerify"));
			String[] txtVerify = commonActions.getText("PLZ_txtVerify").split("\\s+");
			System.out.println(commonActions.getValueFromJson("PLZ"));
			if (txtVerify[0].equals(commonActions.getValueFromJson("PLZ")))
				commonActions.logPassStatus("Pass | Data save success for PLZ");
			else
				commonActions.logFailStatus("Fail | Data save fail for PLZ");

			if (txtVerify[1].equals(commonActions.getValueFromJson("Ort")))
				commonActions.logPassStatus("Pass | Data save success for Ort");
			else
				commonActions.logFailStatus("Fail | Data save fail for Ort");

			if (commonActions.getText("Land_txtVerify").equals(commonActions.getValueFromJson("Land")))
				commonActions.logPassStatus("Pass | Data save success for Land");
			else
				commonActions.logFailStatus("Fail | Data save fail for Land");

			if (commonActions.getText("Steueridentifikationsnummer_txtVerify")
					.equals(commonActions.getValueFromJson("Steueridentifikationsnummer")))
				commonActions.logPassStatus("Pass | Data save success for Steueridentifikationsnummer");
			else
				commonActions.logFailStatus("Fail | Data save fail for Steueridentifikationsnummer");

		} catch (Exception e) {
			e.printStackTrace();
			commonActions.logAssert_Fail("Data save fail");
		}

	}

}
