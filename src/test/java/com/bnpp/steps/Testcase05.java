package com.bnpp.steps;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Set;

import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.bnpp.library.CommonActions;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Testcase05 {
	CommonActions commonAction;
	WebDriverWait wait;
	public Testcase05(CommonActions commonAction)
	{
		this.commonAction=commonAction;
	}
	WebDriver driver;
	
	@When("user launches browser and open Flipkart")
	public void user_launches_browser_and_open_Flipkart() throws MalformedURLException {
		commonAction.launchBrowser();
	    // Write code here that turns the phrase above into concrete actions
	    //throw new cucumber.api.PendingException();
	}

	@Then("user close login {string}")
	public void user_close_login(String string) {
		commonAction.getElement(string).click();
	    // Write code here that turns the phrase above into concrete actions
	    //throw new cucumber.api.PendingException();
	}

//	@Then("Enter {string} in {string} and Enter seach button")
//	public void enter_in_and_Enter_seach_button(String string, String string2) throws FileNotFoundException, IOException, ParseException {
//		String mobname = commonAction.getKeyFromJson(string);
//		commonAction.getElement(string2).sendKeys(mobname);
//		commonAction.pressEnter();
//	    // Write code here that turns the phrase above into concrete actions
//	    //throw new cucumber.api.PendingException();
//	}
//	
	@Then("Enter {string} in {string} and {string} seach button")
	public void enter_in_and_seach_button(String string, String string2, String string3) throws InterruptedException, FileNotFoundException, IOException, ParseException {
		
		String mobname = commonAction.getKeyFromJson(string);
		commonAction.getElement(string2).sendKeys(mobname);
		commonAction.getElement(string3).click();
		
		
		Thread.sleep(10000);
		String title1 = commonAction.getDriver().getTitle();
		System.out.println("second page title"+title1);
		String win = commonAction.getDriver().getWindowHandle();
		System.out.println("1st window Id ="+win);
		
	    // Write code here that turns the phrase above into concrete actions
	   // throw new cucumber.api.PendingException();
	}
	@Then("click on {string} and verify {string} name")
	public void click_on_and_verify_name(String string, String string2) throws InterruptedException {
		Thread.sleep(10000);
		commonAction.moveScrollUp();
		commonAction.waitForVisibilityofElement(string);
		commonAction.moveScrollUp();
		commonAction.getElement(string).click();
		String win = commonAction.getDriver().getWindowHandle();
		System.out.println(win);
		String title = commonAction.getDriver().getTitle();
		System.out.println("First page title"+title);
		Thread.sleep(10000);
		
		
//		Actions act = new Actions(commonAction.getDriver());
//		act.keyDown(Keys.CONTROL).sendKeys(Keys.TAB).build().perform();
		//commonAction.keyDown(Keys.CONTROL).sendKeys(Keys.TAB).build().perform();
		//commonAction.getDriver().navigate().forward();
		//commonAction.getDriver().switchTo().window(availableWindows.get(1));
	    // Write code here that turns the phrase above into concrete actions
	    //throw new cucumber.api.PendingException();
	}

	

	@Then("click on {string}")
	public void click_on(String string) throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
	   // throw new cucumber.api.PendingException();
		commonAction.moveScrollDown();
		Thread.sleep(10000);
		
		///////*****Tabs handeling*****////////////
		Set<String> allwindow = commonAction.getDriver().getWindowHandles();
		
		int sz = allwindow.size();
		System.out.println("Size of allwindow= "+sz);
		System.out.println("allWindow= " +allwindow);
		ArrayList<String> tabs=new ArrayList<>(allwindow);
		int sz1 = tabs.size();
		System.out.println("size of array= "+sz1);
		System.out.println("Tabs= "+tabs);
		
		commonAction.getDriver().switchTo().window(tabs.get(1));
		
		Thread.sleep(10000);
		
		String title3 = commonAction.getDriver().getTitle();
		System.out.println("3rd page title"+title3);
		commonAction.getElement(string).click();
		Thread.sleep(10000);
		
		
	}

	@Then("verify {string} is added into cart")
	public void verify_is_added_into_cart(String string) throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
	   // throw new cucumber.api.PendingException();
		Thread.sleep(10000);
		//Assert asert = new Assert();
		String str4 = commonAction.getElement(string).getText().substring(0, 16);
		System.out.println(str4);
		Assert.assertEquals(str4, "Redmi Note 8 Pro");
		
		

	}

}
