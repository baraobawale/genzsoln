package com.bnpp.steps;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.By;

import com.bnpp.library.CommonActions;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class UC69_70_Risikoklasse {
	
	CommonActions commonActions;
	
	public UC69_70_Risikoklasse(CommonActions commonActions) {
		this.commonActions = commonActions;
	}

	@When("User navigates to {string}")
	public void user_navigates_to(String string) throws InterruptedException {
		commonActions.mouseover("Mein_Konto_Depot");
	       System.out.println(string);
	       Thread.sleep(5000);
	       commonActions.click(string);

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
	
//	@Then("Verify if {string} are displayed")
//	public void verify_if_are_displayed(String string) {
//
//			try {
////				System.out.println(commonActions.getText("Risikoklasse_text1"));
////				commonActions.verifyErrorMessage("Risikoklasse_msg_1").equals(commonActions.getText("Risikoklasse_text1"));
////				commonActions.logPassStatus("Risikoklasse_msg_1 message displayed successfully");
////				commonActions.verifyErrorMessage("Risikoklasse_msg_2").equals(commonActions.getText("Risikoklasse_text2"));
////				commonActions.logPassStatus("Risikoklasse_msg_2 message displayed successfully");
////				commonActions.verifyErrorMessage("Risikoklasse_msg_3").equals(commonActions.getText("Risikoklasse_text3"));
////				commonActions.logPassStatus("Risikoklasse_msg_3 message displayed successfully");
//				
//				commonActions.waitForVisibilityofElement("Risikoklasse_text1");
//				commonActions.waitForVisibilityofElement("Risikoklasse_text2");
//				commonActions.waitForVisibilityofElement("Risikoklasse_text3");
//				
//				
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//				Assert.fail();
//			}
//	}
	
	@Then("Verify if ErrorMesssages are displayed on Risikoklasse")
	public void verify_if_ErrorMesssages_are_displayed_on_Risikoklasse() throws InterruptedException  {
	    // Write code here that turns the phrase above into concrete actions
		commonActions.waitForVisibilityofElement("Risikoklasse_text1");
		commonActions.waitForVisibilityofElement("Risikoklasse_text2");
		commonActions.waitForVisibilityofElement("Risikoklasse_text3");
		
//	   throw new cucumber.api.PendingException();
	}
}
