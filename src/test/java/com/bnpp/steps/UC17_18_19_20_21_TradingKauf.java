package com.bnpp.steps;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.StaleElementReferenceException;


import com.bnpp.library.CommonActions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class UC17_18_19_20_21_TradingKauf {
	CommonActions commonActions;
	String CapturedOrderart;
	String CapturedWKN;
	String CapturedNominalBetrag;
	String CapturedHandelsplatz;
	String CapturedOrdertyp;
	String message;
	String messageAendernORLoeschen;
	String CapturedStueck_Betrag;
	String ort;
	String Handelsplatz;
	String Nominal_Betrag;
	String WKN;
	String Stueck_Betrag;

	public UC17_18_19_20_21_TradingKauf(CommonActions con) {
		this.commonActions = con;
	}

	@When("User clicks on KostenpflichtigKaufen_OrderErteilen")
	public void user_clicks_on_KostenpflichtigKaufen_OrderErteilen() {
		try {
			commonActions.pressTab();
			//	commonActions.waitForVisibilityofElement("KostenpflichtigKaufen_OrderErteilen");
			commonActions.click("KostenpflichtigKaufen_OrderErteilen");
		}catch(ElementClickInterceptedException e) {
			e.printStackTrace();

		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("element not Clicked");
			//	commonActions.logAssert_Fail("element not Clicked");
		}
	}
	@When("user enters {string} in {string}")
	public void user_enters_in(String dataKey, String locatorKey) {
		try {
			if(dataKey.equals("Limit"))
			{
				System.out.println("locatorKey"+locatorKey);
				commonActions.waitForVisibilityofElement(locatorKey);
				commonActions.click(locatorKey);
				Thread.sleep(2000);
				commonActions.clearfield(locatorKey);
				Thread.sleep(2000);
				commonActions.enterText(locatorKey, dataKey);
				System.out.println("Limit entered");
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("Limit not entered");
			//	commonActions.logAssert_Fail("Data could not be entered");
		}
	}

	@When("Capture entered details on OrderErteilen")
	public void capture_entered_details_on_OrderErteilen() throws FileNotFoundException, IOException, ParseException {
		try {
			Thread.sleep(7000);
			CapturedOrderart    = commonActions.getText("CapturedAnleihe_OrderArt");
			CapturedWKN = commonActions.getText("CapturedAnleihe_WKN");
			CapturedHandelsplatz    = commonActions.getText("CapturedAnleihe_Handelsplatz");
			System.out.println("CapturedOrderart: " + CapturedOrderart);
			System.out.println("CapturedWKN: " + CapturedWKN);
			System.out.println("CapturedHandelsplatz: " + CapturedHandelsplatz);

			if (commonActions.getScenarioName().equals("KaufOrder_Anlegen_Anleihe")) {
				CapturedNominalBetrag  =  commonActions.getText("CapturedAnleihe_Nominal_Betrag");
				System.out.println("capturedNominalStueck_Betrag: " + CapturedNominalBetrag);
			}

			else if (commonActions.getScenarioName().equals("KaufOrder_Anlegen_Aktie")||commonActions.getScenarioName().equals("KaufOrder_Anlegen_Fonds1")||commonActions.getScenarioName().equals("KaufOrder_Anlegen_Fonds2")) {
				System.out.println("getScenarioName: " + commonActions.getScenarioName());
				CapturedStueck_Betrag= commonActions.getText("CapturedAnleihe_Stueck_Betrag");
				System.out.println("CapturedStueck_Betrag: " + CapturedStueck_Betrag);

			}
			else
			{
				System.out.println("Data couldnt be Captured for betrag");
			}
			System.out.println("DATA CAPTURED");
		}catch (StaleElementReferenceException e) {
			e.printStackTrace();
			System.out.println("Element not Captured");

		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("Element NOT CAPTURED");
			//	commonActions.logAssert_Fail("Failure Capturing data");
		}
	}

	@When("Capture Message on OrderErteilen")
	public void capture_Message_on_OrderErteilen() throws FileNotFoundException, IOException, ParseException {
		try {
			message = commonActions.getText("CapturedMessageKauf");
			System.out.println("Message CAPTURED: "+message);

		}catch (StaleElementReferenceException e) {
			e.printStackTrace();
			System.out.println("Element not Captured");
		}
		catch (Exception e) {
			System.out.println("Message NOT CAPTURED");
			e.printStackTrace();
			//	commonActions.logAssert_Fail("Message NOT CAPTURED");
		}}

	@Then("Verify {string},{string},{string},{string},{string} on OrderUebersicht")
	public void verify_on_OrderUebersicht(String string, String string2, String string3, String string4, String string5)
			throws FileNotFoundException, IOException, ParseException {
		try{
			ort = commonActions.getText("Verify_OrderartTable");
			Handelsplatz = commonActions.getText("Verify_Handelsplatz_table");		
			WKN = commonActions.getText("Verify_WKN_table");
			System.out.println("Verify_Orderart:"+ort);
			System.out.println("Verify_Handelsplatz:"+Handelsplatz);
			System.out.println("Verify_WKN:"+WKN);

			if(ort.equals(CapturedOrderart))
			{System.out.println("Valid Ort value displayed");
			commonActions.logPassStatus("Pass | Valid Ort value displayed - " + ort);
			}else
			{System.out.println("ort print failed-");
			commonActions.logFailStatus("Fail | Valid Ort value display failed - " + ort);
			}
			if (Handelsplatz.equals(CapturedHandelsplatz))
			{System.out.println("Valid Handelsplat value displayed");
			commonActions.logPassStatus("Pass | Valid Handelsplat value displayed - " + Handelsplatz);
			}else	
			{ System.out.println("Valid Handelsplat value display failed");
			commonActions.logFailStatus("Fail | Valid Handelsplat value display failed - " + Handelsplatz);
			}
			if (CapturedWKN.contains(WKN))
			{System.out.println("Valid WKN value displayed");
			commonActions.logPassStatus("Pass | Valid WKN value displayed - " + WKN);
			}else	
			{ System.out.println("Valid WKN value display failed");
			commonActions.logFailStatus("Fail | Valid WKN value display failed - " + WKN);
			}

			if (commonActions.getScenarioName().equals("KaufOrder_Anlegen_Anleihe")) {
				Nominal_Betrag = commonActions.getText("Verify_StueckORNominal");
				System.out.println("Nominal_Betrag:"+Nominal_Betrag);
				if (Nominal_Betrag.equals(CapturedNominalBetrag))
				{System.out.println("Valid Stop NominalStueck_Betrag displayed");
				commonActions.logPassStatus("Pass | Valid Stop NominalStueck_Betrag displayed - " + Nominal_Betrag);
				}else	
				{ System.out.println("Valid NominalStueck_Betrag value display failed");
				commonActions.logFailStatus("Fail | Valid NominalStueck_Betrag value display failed - " + Nominal_Betrag);
				}
			}
			else if (commonActions.getScenarioName().equals("KaufOrder_Anlegen_Aktie")||commonActions.getScenarioName().equals("KaufOrder_Anlegen_Fonds1")||commonActions.getScenarioName().equals("KaufOrder_Anlegen_Fonds2"))
			{
				System.out.println("Scenario Name:"+commonActions.getScenarioName());
				Stueck_Betrag = commonActions.getText("Verify_StueckORNominal");
				System.out.println("Stueck_Betrag:"+Stueck_Betrag);

				if (Stueck_Betrag.equals(CapturedStueck_Betrag))
				{System.out.println("Valid Stop NominalStueck_Betrag displayed");
				commonActions.logPassStatus("Pass | Valid Stop NominalStueck_Betrag displayed - " + Stueck_Betrag);
				}else	
				{ System.out.println("Valid NominalStueck_Betrag value display failed");
				commonActions.logFailStatus("Fail | Valid NominalStueck_Betrag value display failed - " + Stueck_Betrag);
				}
			}
			else
			{System.out.println("Verify captured details from OrderErteilen failed");
			commonActions.logFailStatus("Verify captured from OrderErteilen FAILED");
			}

		}catch (StaleElementReferenceException e) {
			e.printStackTrace();
			System.out.println("Stale Element not Captured");
		} 
		catch (Exception e) {
			e.printStackTrace();
			//	commonActions.logAssert_Fail("Failure verifying data");
		}}

	@Then("^Verify captured details,Message from OrderErteilen$")
	public void verify_captured_details_Message_from_OrderErteilen() {
		try{
			if (message.equals(commonActions.getValueFromJson("Message")))
			{	System.out.println("Message : "+message);	
			commonActions.logPassStatus("Pass | Valid message displayed " + message);
			}else
			{System.out.println("Message verify failed");
			commonActions.logFailStatus("Fail | Valid message display failed" + message);

			}
		}catch (StaleElementReferenceException e) {
			e.printStackTrace();
			System.out.println("Element not Captured");
		}catch (Exception e) {
			e.printStackTrace();
			//	commonActions.logAssert_Fail("Failure verifying data");
		}
	}

	@Then("^Verify Message,details on OrderAendern")
	public void Then_Verify_Message_details_on_OrderAendern() {
		try {
			String messageAendern=commonActions.getText("messageAendern");
			if (messageAendern.equals(commonActions.getValueFromJson("Message")))
			{	System.out.println("Message OrderAendern "+ messageAendern);
			commonActions.logPassStatus("Pass | Valid message displayed - " + messageAendern);
			}else {
				commonActions.logFailStatus("Fail | Valid message display failed -" + messageAendern);
			}
		} catch (Exception e) {
			e.printStackTrace();
			//	commonActions.logAssert_Fail("Verify Message,details on OrderAendern Failed");
		}
	}

	@Then("Verify Message on OrderLoeschen")
	public void Then_Verify_Message_on_OrderLoeschen() throws FileNotFoundException, IOException, ParseException {
		try {
			commonActions.moveScrollUp();
			messageAendernORLoeschen=commonActions.getText("AendernORLoeschenMessage");
			System.out.println("My message: "+messageAendernORLoeschen);
			if(messageAendernORLoeschen.equals(commonActions.getValueFromJson("Message")))
				commonActions.logPassStatus("Pass | Valid message displayed - " + messageAendernORLoeschen);
			else {
				commonActions.logFailStatus("Fail | Valid message display failed -" + messageAendernORLoeschen);
			}
		} catch (Exception e) {
			e.printStackTrace();
			//	commonActions.logAssert_Fail("Verify Message,details on OrderLoeschen Failed");
		}
	}

	@When("User clicks on {string} of Created_WKN,Status in CreatedWKN_OrderUebersicht with Status_OrderUebersicht")
	public void user_clicks_on_of_Created_WKN_Status_in_CreatedWKN_OrderUebersicht_with_Status_OrderUebersicht(String locatorKey) throws FileNotFoundException, IOException, ParseException {
		String Status=commonActions.getValueFromJson("Status");
		System.out.println("Status "+Status);
		try {
			if (commonActions.getScenarioName().equals("KaufOrder_Anendern_Aktie") && Status.equals(commonActions.getText("Status_KaufOrder_Anendern_Aktie")))
			{	locatorKey = "KaufOrder_Anendern";
			commonActions.click(locatorKey);
			System.out.println("Anendern SUCCESSFUL ");
			}
			if (commonActions.getScenarioName().equals("KaufOrder_Loeschen_Aktie") && Status.equals(commonActions.getText("Status_OrderUebersicht_Loeschen_Aktie")))
			{	locatorKey = "DeleteAktie";
			commonActions.click(locatorKey);
			if(commonActions.isElementPresent("OrderExecuted")) {
				commonActions.logPassStatus("Order is executed and cannot be deleted");
			    System.out.println("Loeschen SUCCESSFUL ");
			}
			}
			
			if (commonActions.getScenarioName().equals("KaufOrder_Loeschen_Fond")&& Status.equals(commonActions.getText("Status_OrderUebersicht_Loeschen_Fond")))
			{	
				locatorKey = "DeleteFonds";
				commonActions.waitForVisibilityofElement(locatorKey);
				if (commonActions.isElementPresent(locatorKey))
				commonActions.click(locatorKey);
				System.out.println("Loeschen SUCCESSFUL ");}

		} catch(ElementClickInterceptedException e) {
			e.printStackTrace();
			System.out.println("Element not Clicked");
		}catch (Exception e) {

			e.printStackTrace();
		}
	}
	
	@And("^User enters Limit in Limit_OrderAendern$")
	public void User_Enters_Limit() throws InterruptedException, IllegalArgumentException, IOException, ParseException {
		try {
			
			String locatorKey="LimitToEnter";
			String textvalue = commonActions.getValueFromJson("Limit");
			double i=Double.parseDouble(textvalue.replace(",", "."));
			i=(double) (i+Math.random()*1);
			double f=Math.round(i*100.0)/100.0;
			String valueToInput=String.valueOf(f);
			valueToInput=valueToInput.replace(".", ",");
			System.out.println(valueToInput);
			//commonActions.click(locatorKey);
			commonActions.enterText(locatorKey, valueToInput);
			
		} catch (Exception e) {
			e.printStackTrace();
		commonActions.logAssert_Fail("Entering limit value failed");
		}

}
}


