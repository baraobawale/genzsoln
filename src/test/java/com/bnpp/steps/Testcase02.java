package com.bnpp.steps;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;

import org.json.simple.parser.ParseException;

import com.bnpp.library.CommonActions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Testcase02 {
	CommonActions commonAction;
	
	public Testcase02(CommonActions commonAction)
	{
		this.commonAction=commonAction;
	}
	@Given("launch browser")
	public void launch_browser() throws MalformedURLException {
		
			commonAction.launchBrowser();
			System.out.println("********launch Browser*****");
		
	    // Write code here that turns the phrase above into concrete actions
	   // throw new cucumber.api.PendingException();
	}
	@When("user enters Amazon {string}")
	public void user_enters_Amazon(String string) throws FileNotFoundException, IOException, ParseException {
		System.out.println("**************user enters Amazon**********");
		System.out.println(string);
		System.out.println(commonAction.getElement(string));
		commonAction.getElement(string).sendKeys("mi mobile phone ");
		
		System.out.println("********user Enters name of mobile*********");
		String firstname = commonAction.getKeyFromJson("firstname");
		String lastname = commonAction.getKeyFromJson("lastname");
		System.out.println(firstname);
		System.out.println(lastname);
		
		System.out.println("********user Enters name of mobile*********");
	    // Write code here that turns the phrase above into concrete actions
	    throw new cucumber.api.PendingException();
	}

	@Then("user Enters name of mobile")
	public void user_Enters_name_of_mobile() throws FileNotFoundException, IOException, ParseException {
//		System.out.println("********user Enters name of mobile*********");
//		String firstname = commonAction.getKeyFromJson("firstname");
//		String lastname = commonAction.getKeyFromJson("lastname");
//		System.out.println(firstname);
//		System.out.println(lastname);
//		
//		System.out.println("********user Enters name of mobile*********");
	    // Write code here that turns the phrase above into concrete actions
	    throw new cucumber.api.PendingException();
	}

	


}
