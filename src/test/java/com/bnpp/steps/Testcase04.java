package com.bnpp.steps;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.bnpp.library.CommonActions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class Testcase04 {
	CommonActions commonAction;
	public Testcase04(CommonActions commonAction)
	{
		this.commonAction=commonAction;
	}
	
	@Given("launch broser and open fb")
	public void launch_broser_and_open_fb() throws MalformedURLException {
		commonAction.launchBrowser();
		System.out.println("**********launch browser******");
	    // Write code here that turns the phrase above into concrete actions
	    //throw new cucumber.api.PendingException();
	}

	@When("fb page open")
	public void fb_page_open() {
		System.out.println("**********fb open******");
		System.out.println("fb page is open");
	    // Write code here that turns the phrase above into concrete actions
	    //throw new cucumber.api.PendingException();
	}

	@Then("Enter {string} in {string}")
	public void enter_in(String string, String string2) throws FileNotFoundException, IOException, ParseException {
		System.out.println(string);
		System.out.println(string2);
		String str = commonAction.getKeyFromJson(string);
		System.out.println(str);
		commonAction.getElement(string2).sendKeys(str);
		System.out.println(commonAction.getElement(string2));
	    // Write code here that turns the phrase above into concrete actions
	    //throw new cucumber.api.PendingException();
	}

	@Then("Enterl {string} in {string}")
	public void enterl_in(String string, String string2) throws FileNotFoundException, IOException, ParseException {
		String str2 = commonAction.getKeyFromJson(string);
		System.out.println(str2);
		commonAction.getElement(string2).sendKeys(str2);
		System.out.println(commonAction.getElement(string2));
	    // Write code here that turns the phrase above into concrete actions
	    //throw new cucumber.api.PendingException();
	}
	@Then("Enterm {string} in {string}")
	public void enterm_in(String string, String string2) throws FileNotFoundException, IOException, ParseException, InterruptedException {
		String str3 = commonAction.getKeyFromJson(string);
		System.out.println(str3);
		System.out.println(commonAction.getElement(string2));
		commonAction.getElement(string2).sendKeys(str3);
		Thread.sleep(5000);
	    // Write code here that turns the phrase above into concrete actions
	    //throw new cucumber.api.PendingException();
		Thread.sleep(5000);
		commonAction.pressTab();
		
	}
	@Then("click {string} and {string}")
	public void click_and(String string, String string2) throws Exception {
		String str3 = commonAction.getKeyFromJson(string);
		System.out.println(str3);
		System.out.println(commonAction.getElement(string2));
		System.out.println(string2);
		commonAction.selectFromDropDown(string2, string);
		
		Thread.sleep(5000);
		

	    // Write code here that turns the phrase above into concrete actions
	    //throw new cucumber.api.PendingException();
	}
	
	@Then("clickmm {string} and {string}")
	public void clickmm_and(String string, String string2) throws Exception {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new cucumber.api.PendingException();
		commonAction.selectFromDropDown(string2, string);

	}

	@Then("clickyy {string} and {string}")
	public void clickyy_and(String string, String string2) throws Exception {
	    // Write code here that turns the phrase above into concrete actions
	   // throw new cucumber.api.PendingException();
		commonAction.selectFromDropDown(string2, string);

	}
	
	@Then("select {string}")
	public void select(String string) {
	    // Write code here that turns the phrase above into concrete actions
	   // throw new cucumber.api.PendingException();
		commonAction.getElement(string).click();
	}

	@Then("click {string}")
	public void click(String string) throws InterruptedException {
		
		commonAction.getElement(string).click();
		Thread.sleep(5000);
		
		
		
	    // Write code here that turns the phrase above into concrete actions
	   // throw new cucumber.api.PendingException();
	}


	
}
