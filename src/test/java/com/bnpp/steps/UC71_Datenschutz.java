package com.bnpp.steps;

import com.bnpp.library.CommonActions;

import cucumber.api.java.en.Then;

public class UC71_Datenschutz {

	CommonActions commonActions;

	public UC71_Datenschutz(CommonActions commonActions) {
		this.commonActions = commonActions;
	}

	@Then("Verify messages displayed on Mein Datenchutz")
	public void Verify_messages_displayed_on_Mein_Datenchutz() {
		try {
			String ScenarioName = commonActions.getScenarioName();
			System.out.println("ScenarioName" + ScenarioName);
			if (ScenarioName.equals("Datenschutz_select_All_Unselected")) {
				if (commonActions.isElementPresent("e-mail_msg_1")
						&& commonActions.isElementPresent("unselected_Mark_1"))
					commonActions.logPassStatus("Pass | Email message display success with unchecked mark");
				else
					commonActions.logFailStatus("Fail | Email message display fail");

				if (commonActions.isElementPresent("phone_msg_2")
						&& commonActions.isElementPresent("unselected_Mark_2"))
					commonActions.logPassStatus("Pass | Phone message display success with unchecked mark");
				else
					commonActions.logFailStatus("Fail | Phone message display fail");

				if (commonActions.isElementPresent("website_msg_3")
						&& commonActions.isElementPresent("unselected_Mark_3"))
					commonActions.logPassStatus("Pass | WebSite message display success with unchecked mark");
				else
					commonActions.logFailStatus("Fail | WebSite message display fail");
			} else {
				if (commonActions.isElementPresent("e-mail_msg_1") && commonActions.isElementPresent("selected_Mark_1"))
					commonActions.logPassStatus("Pass | Email message display success with checked mark");
				else
					commonActions.logFailStatus("Fail | Email message display fail");

				if (commonActions.isElementPresent("phone_msg_2") && commonActions.isElementPresent("selected_Mark_2"))
					commonActions.logPassStatus("Pass | Phone message display success with checked mark ");
				else
					commonActions.logFailStatus("Fail | Phone message display fail");

				if (commonActions.isElementPresent("website_msg_3")
						&& commonActions.isElementPresent("selected_Mark_3"))
					commonActions.logPassStatus("Pass | WebSite message display success with checked mark");
				else
					commonActions.logFailStatus("Fail | WebSite message display fail");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
