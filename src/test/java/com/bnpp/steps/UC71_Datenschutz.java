package com.bnpp.steps;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.bnpp.library.CommonActions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;

public class UC71_Datenschutz {

	CommonActions commonActions;

	public UC71_Datenschutz(CommonActions commonActions) {
		this.commonActions = commonActions;
	}

	@And("User selects checkbox {string} in {string}")
	public void User_selects_checkbox_in_field(String dataKey, String locatorKey)
			throws FileNotFoundException, IOException, ParseException, InterruptedException {
		String str1 = commonActions.getValueFromJson(dataKey);
		commonActions.clearCheckBox(locatorKey);
		if (str1.equals("null")) {
			// System.out.println("checkbox is unchecked");
		} else {
			commonActions.click(locatorKey);
		}
	}

	@Then("Verify messages displayed on Mein Datenchutz")
	public void Verify_messages_displayed_on_Mein_Datenchutz() {
		// commonActions.waitForVisibilityofElement("e-mail_msg_1");
		// commonActions.waitForVisibilityofElement("phone_msg_2");
		// commonActions.waitForVisibilityofElement("website_msg_3");
		if (commonActions.isElementPresent("e-mail_msg_1"))
			commonActions.logPassStatus("Email message display success");
		else
			commonActions.logFailStatus("Email message display fail");
		
		if (commonActions.isElementPresent("phone_msg_2"))
			commonActions.logPassStatus("Phone message display success");
		else
			commonActions.logFailStatus("Phone message display fail");
		
		if (commonActions.isElementPresent("website_msg_3"))
			commonActions.logPassStatus("WebSite message display success");
		else
			commonActions.logFailStatus("WebSite message display fail");

	}
}
