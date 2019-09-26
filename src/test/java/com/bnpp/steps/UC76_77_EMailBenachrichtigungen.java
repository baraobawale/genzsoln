package com.bnpp.steps;

import java.io.FileNotFoundException;
import java.io.IOException;
import org.json.simple.parser.ParseException;
import com.bnpp.library.CommonActions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

public class UC76_77_EMailBenachrichtigungen {

	CommonActions commonActions;

	public UC76_77_EMailBenachrichtigungen(CommonActions commonActions) {
		this.commonActions = commonActions;
	}
	

	@Then("Verify displayed ErrorMesssages on Benachrichtigungen")
	public void verify_displayed_ErrorMesssages_on_Benachrichtigungen() {
		commonActions.getElement("Messages_confirm");
		
		try {
			if (commonActions.isElementPresent("Messages_confirm"))
				commonActions.logPassStatus("Display success message with confirm by ticking not that you read");
			else
				commonActions.logFailStatus("Display failure message");
			
		} catch (Exception e) {
			
		}
	}
		
		@And("User selects  checkbox {string} in {string}")
		public void User_selects_checkbox_in_field(String dataKey, String locatorKey)
				throws FileNotFoundException, IOException, ParseException, InterruptedException {
			String str1 = commonActions.getValueFromJson(dataKey);
			System.out.println("Value of str1   "+str1);
			
				if (str1.equals("Check")) {
					commonActions.clearRadioButton(locatorKey);
					commonActions.click(locatorKey);
				}
				else {
					commonActions.clearRadioButton(locatorKey);
				}
		}
		
		@Then("Verify Message,Status on Benachrichtigungen")
		public void verify_Message_Status_on_Benachrichtigungen() {
			   String ScenarioName = commonActions.getScenarioName();
               System.out.println("ScenarioName"+ScenarioName);
	             if(ScenarioName.equals("EMail_Benachrichtigungen_Select")){
	            	  if (commonActions.isElementPresent("Message_Select")) 
	                 commonActions.logPassStatus("Email Select message display successfully");
	 	          else
	 	                 commonActions.logFailStatus("Email Select message display fail");
	             }
	             if(ScenarioName.equals("EMail_Benachrichtigungen_Unselect")) {
	             if (commonActions.isElementPresent("Message_Unselect"))
	                 commonActions.logPassStatus("Email Unselect message display successfully");
	            else
	                 commonActions.logFailStatus("Email unselect message display fail");
	             }
			}
		}
		

//	       
//	          
