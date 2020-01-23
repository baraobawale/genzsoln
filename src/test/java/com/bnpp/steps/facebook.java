package com.bnpp.steps;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;

import org.json.simple.parser.ParseException;

import com.bnpp.library.CommonActions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class facebook {
	

	CommonActions commonActions;
	

	public facebook(CommonActions commonActions) {
		this.commonActions = commonActions;
	}
	@Given("launch browser and open facebook")
	
	public void launch_browser_and_open_facebook() throws MalformedURLException {
		commonActions.launchBrowser();
	    // Write code here that turns the phrase above into concrete actions
	    throw new cucumber.api.PendingException();
	}

	@When("enterusers {string} and {string}")
	public void enterusers_and(String string, String string2) throws FileNotFoundException, IOException, ParseException {
		String firstname = commonActions.getKeyFromJson(string);
		String lastname = commonActions.getKeyFromJson(string2);
		System.out.println(commonActions.getKeyFromJson(string));
		System.out.println(commonActions.getKeyFromJson(string2));
		System.out.println(firstname);
		System.out.println(lastname);
	    // Write code here that turns the phrase above into concrete actions
	    //throw new cucumber.api.PendingException();
	}

	@Then("click submit button")
	public void click_submit_button() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new cucumber.api.PendingException();
	}


}
