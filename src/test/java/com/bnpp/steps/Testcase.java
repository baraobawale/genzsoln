package com.bnpp.steps;

import java.net.MalformedURLException;

import com.bnpp.library.CommonActions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class Testcase {
	
	CommonActions commonActions;
	

	public Testcase(CommonActions commonActions) {
		this.commonActions = commonActions;
	}
	
	@Given("launch appln and open url")
	public void launch_appln_and_open_url() throws MalformedURLException {
			commonActions.launchBrowser();
		
	   
	}

	@Then("provide login and password")
	public void provide_login_and_password() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new cucumber.api.PendingException();
	    
	}

	@Then("close browser")
	public void close_browser() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new cucumber.api.PendingException();
	   // commonActions.quit();
	}


}
