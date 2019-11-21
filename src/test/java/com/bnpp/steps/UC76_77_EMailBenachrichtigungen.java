package com.bnpp.steps;

import java.io.FileNotFoundException;
import java.io.IOException;
import org.json.simple.parser.ParseException;
import com.bnpp.library.CommonActions;

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
				commonActions.logPassStatus("Pass | Valid message displayed ");
			else
				commonActions.logFailStatus("Fail | Valid message display failed ");
			
		} catch (Exception e) {
			
		}
	}
		//UC76_77_EmailBenachrichtigungen
	//	@And("User selectscheckbox {string} in {string}")
//		public void User_selects_checkbox_in_field(String dataKey, String locatorKey)
//				throws FileNotFoundException, IOException, ParseException, InterruptedException {
//			
//		}
		
		@Then("Verify Message,Status on Benachrichtigungen")
		public void verify_Message_Status_on_Benachrichtigungen() throws FileNotFoundException, IOException, ParseException {
			   String ScenarioName = commonActions.getScenarioName();
               System.out.println("ScenarioName"+ScenarioName);
               System.out.println("A:"+ commonActions.getText("Message_Benachrichtigungen")+"  "+"B: "+commonActions.getValueFromJson("Message"));
	             if(ScenarioName.equals("EMail_Benachrichtigungen_Select")){
	            	  if (commonActions.getText("Message_Benachrichtigungen").equals(commonActions.getValueFromJson("Message"))) 
	            		  commonActions.logPassStatus("Pass | Valid message displayed: "+commonActions.getText("Message_Benachrichtigungen"));
	 	          else
	 	        	 commonActions.logFailStatus("Fail | Valid message display failed "+commonActions.getText("Message_Benachrichtigungen"));
	             }
			}
		}
		

//	       
//	          
