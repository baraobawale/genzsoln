package com.bnpp.steps;

import java.io.FileNotFoundException;
import java.io.IOException;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebElement;

import com.bnpp.library.CommonActions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class UC82_Authorization {

	CommonActions commonActions;
	String SessionActivate_Link="";
	

	public UC82_Authorization(CommonActions commonActions) {
		this.commonActions = commonActions;
	}
	
	@And("User select in checkbox {string} in {string}")
	public void User_selects_checkbox_in_field(String dataKey, String locatorKey)
			throws FileNotFoundException, IOException, ParseException, InterruptedException {
		try {
			String str1 = commonActions.getValueFromJson(dataKey);
			//commonActions.clearCheckBox(locatorKey);
			if (str1.equals("Select"))
				commonActions.click(locatorKey);
				
			}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
	

	@Then("Verify {string} is displayed on MeinKontoDepot")
	public void verify_is_displayed_on_MeinKontoDepot(String dataKey) {
		try {
			WebElement text = commonActions.getElement(dataKey);
			SessionActivate_Link = text.getText();
			if (SessionActivate_Link.equals(commonActions.getValueFromJson("SessionActivate_Link"))) {
				commonActions.logPassStatus("Pass | Valid link displayed -"+SessionActivate_Link);
			}else {
				commonActions.logFailStatus("Error | Valid link display failed -"+SessionActivate_Link);
			}
		}
				catch (Exception e) {
					e.printStackTrace();
//					commonActions.logAssert_Fail("text not found");goo
				}

		}
	
	
}