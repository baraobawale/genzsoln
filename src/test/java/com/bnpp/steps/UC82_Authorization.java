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
	//SVG elements not supported by Selenium, so for feature file UC82_Authorization step 
	//"And User clicks on CloseWindow_SessionTANAktivieren" has been made unique and we will navigate back
	//to close the SVG popup window"
	@And("User clicks on CloseWindow_SessionTANAktivieren")
	public void User_clicks_on_closewindow_sessionTANAtivieren(){
		commonActions.navigateBack();
	}
	
	@And("User selects Handelsplatz in Handelsplatz_OrderErteilen")
	public void User_selects_Handelsplatz() throws InterruptedException{
		try {
			commonActions.click("Handelsplatz_OrderErteilen");
			commonActions.click("Handelsplatz_Fondsgesellschaft");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			commonActions.logAssert_Fail("User_selects_Handelsplatz failed");
		}
	}
	
	
}