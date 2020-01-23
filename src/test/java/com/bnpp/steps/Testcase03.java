package com.bnpp.steps;

import java.net.MalformedURLException;

import com.bnpp.library.CommonActions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Testcase03 {
	CommonActions commonActions;
	public Testcase03(CommonActions commonActions)
	{
		this.commonActions=commonActions;
	}
	
	@Given("launch browser in chrome")
	public void launch_browser_in_chrome() throws MalformedURLException {
		commonActions.launchBrowser();
	    // Write code here that turns the phrase above into concrete actions
	    throw new cucumber.api.PendingException();
	}

	@When("user enters mobile {string} in {string} field")
	public void user_enters_mobile_in_field(String string, String string2) throws InterruptedException {
		commonActions.getElement(string2).sendKeys(string);
		
		System.out.println(string);
		System.out.println(string2);
		Thread.sleep(5000);
		System.out.println(string2);
		
	    // Write code here that turns the phrase above into concrete actions
	    throw new cucumber.api.PendingException();
	}

	@Then("user Enters name of mobilephone")
	public void user_Enters_name_of_mobilephone() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new cucumber.api.PendingException();
	}


}
