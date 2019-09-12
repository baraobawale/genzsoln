package com.bnpp.steps;

import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.bnpp.library.CommonActions;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;

public class UC71_Datenschutz {
 
    CommonActions commonActions;
    public UC71_Datenschutz(CommonActions commonActions) {
    this.commonActions=commonActions;
    }
    
    HashMap<String, String> hmap = new HashMap<String, String>();
       

	
//	@When("^User Logs in with account \"(.*?)\"$")
//	public void logs_in_with_account_Depot(String AccountName) throws MalformedURLException, InterruptedException {
//		con.openBrowser();
//   		con.navigate("urlKey");
//   		con.click("logInButton");
//   		if(AccountName.equals("Depot")){			
//   		con.type("Kontonummer_UserID", "880589404");
//   		con.type("Kontonummer_Passwort", "12345");
//   		}
//
//   		con.click("Einloggen");
//
//
//	}
//	
//	@Then("Verify error messages displayed on Mein Datenchutz")
//	public void verify_error_messages_displayed_on_Mein_Datenchutz(DataTable dataTable) throws InterruptedException {
//		String str1="";
//		String str2="";
//	    	List<Map<Object, Object>> list = dataTable.asMaps(String.class,String.class);
//	    	for(int i=0;i<list.size();i++) {
////	    		System.out.println(list.get(i).get("Mark"));
////	    		System.out.println(list.get(i).get("Messages"));
//	    		str1 = (String) list.get(i).get("Mark");
//	    		str2 = (String) list.get(i).get("Messages");
//	    		System.out.println(str1);
//	    		System.out.println(str2);
//	    		commonActions.isElementPresent(str1);
//	    		Thread.sleep(1000);
//	    		commonActions.isElementPresent(str2);
//	    		}
//	}
    
    @Then("Verify error messages with selected mark displayed on Mein Datenchutz")
	public void verify_error_messages_with_selected_mark_displayed_on_Mein_Datenchutz() throws InterruptedException {
    			try {
    			commonActions.waitForVisibilityofElement("selected_Mark_1");
    			commonActions.waitForVisibilityofElement("e-mail_msg_1");
	    		commonActions.waitForVisibilityofElement("selected_Mark_2");
	    	    commonActions.waitForVisibilityofElement("phone_msg_2");
	    		commonActions.waitForVisibilityofElement("selected_Mark_3");
	    	    commonActions.waitForVisibilityofElement("website_msg_3");
	    		
	    		}
    			catch(Exception e) {
    				System.out.println("element is not present");
    			}
    }			
    
    @Then("Verify error messages with unselected mark displayed on Mein Datenchutz")
	public void verify_error_messages_with_unselected_mark_displayed_on_Mein_Datenchutz() throws InterruptedException {
    	try {
			commonActions.waitForVisibilityofElement("unselected_Mark_1");
			commonActions.waitForVisibilityofElement("e-mail_msg_1");
    		commonActions.waitForVisibilityofElement("unselected_Mark_2");
    	    commonActions.waitForVisibilityofElement("phone_msg_2");
    		commonActions.waitForVisibilityofElement("unselected_Mark_3");
    	    commonActions.waitForVisibilityofElement("website_msg_3");
    		
    		}
			catch(Exception e) {
				System.out.println("element is not present");
			}
	}
}    
