package com.bnpp.steps;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.StaleElementReferenceException;

import com.bnpp.library.CommonActions;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class UC22_23_24_25_26_TradingVerkauf {
	CommonActions commonActions;
	String CaptureOrderart ="";
	String CaptureWKN = "";
	String CaptureStuck = "";
	String CaptureHandelsplatz = "";
	String CaptureMessage = "";
	String ort_TradingVerkauf ="";
	String Handelsplatz_TradingVerkauf ="";
	String WKN_TradingVerkauf ="";
	String Stuck_TradingVerkauf = "";
	String message;
	String ort;
	String Handelsplatz;
	String WKN;
	String Stueck_Betrag;
	String Nominal_Betrag;
	String CapturedNominalBetrag;
	

	public UC22_23_24_25_26_TradingVerkauf(CommonActions con) {
		this.commonActions = con;
	}
	
   
	@When("User selects Handelsplatz in Handelsplatz_OrderErteilen")
	public void user_selects_Handelsplatz_in_Handelsplatz_OrderErteilen() throws InterruptedException {
		if (commonActions.getScenarioName().equals("VerkaufOrder_Anlegen_Fonds")) {
			try {
				commonActions.click("Handelsplatz_OrderErteilen");
				//commonActions.pressTab();
				Thread.sleep(2000);				
				commonActions.click("Handelsplatz_Tradegate");
			//	Thread.sleep(1000);	
				commonActions.pressTab();
				//commonActions.pressEnter();
				System.out.println("Handelsplatz_Tradegate selected");
			}catch (Exception e) {
				e.printStackTrace();
				System.out.println("Handelsplatz_Tradegate not selected");
				commonActions.logAssert_Fail("text not found");
		}
	   }
	}
	
	@When("Capture entered details on OrderErteilen_TradingVerkauf")
	public void capture_entered_details_on_OrderErteilen_TradingVerkauf() {
		try {
		Thread.sleep(5000);
	    CaptureOrderart = commonActions.getText("Anlegen_Fonds_OrderArt");
	    CaptureWKN = commonActions.getText("Anlegen_Fonds_WKN");
	    CaptureStuck = commonActions.getText("Anlegen_Fonds_Stueck");
	    CaptureHandelsplatz = commonActions.getText("Anlegen_Fonds_Handelsplatz");
	    
	    System.out.println("CaptureOrderart:" + CaptureOrderart);
		System.out.println("CaptureWKN:" + CaptureWKN);
		System.out.println("CaptureStuck:" + CaptureStuck);
		System.out.println("CaptureHandelsplatz:" + CaptureHandelsplatz);
		}
		catch (StaleElementReferenceException e) {
			e.printStackTrace();
			System.out.println("element not selected");
			commonActions.logAssert_Fail("text not found");
	}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("element not selected");
			commonActions.logAssert_Fail("text not found");
	}
	}
	
	@When("Capture Message on OrderErteilen_TradingVerkauf")
	public void capture_Message_on_OrderErteilen_TradingVerkauf() {
		CaptureMessage = commonActions.getText("Message");
		
		System.out.println("CaptureMessage:" + CaptureMessage);
	}
	
	@Then("Verify {string},{string},{string},{string},{string} on OrderUebersicht_TradingVerkauf")
	public void verify_on_OrderUebersicht_TradingVerkauf(String string, String string2, String string3, String string4, String string5) {
		ort_TradingVerkauf = commonActions.getText("Verify_OrderartTable_Verkauf");
		Handelsplatz_TradingVerkauf = commonActions.getText("Verify_Handelsplatz_table_Verkauf");
		WKN_TradingVerkauf = commonActions.getText("Verify_WKN_table_Verkauf");
		Stuck_TradingVerkauf = commonActions.getText("Verify_Stuck_table_Verkauf");
		
		System.out.println("ort_TradingVerkauf:" + ort_TradingVerkauf);
		System.out.println("Handelsplatz_TradingVerkauf:" + Handelsplatz_TradingVerkauf);
		System.out.println("WKN_TradingVerkauf:" + WKN_TradingVerkauf);
		System.out.println("Stuck_TradingVerkauf:" + Stuck_TradingVerkauf);
		
		
		if(ort_TradingVerkauf.equals(CaptureOrderart))
		{
		commonActions.logPassStatus("Pass | Valid Ort value displayed - " + ort_TradingVerkauf);
		}else
		{
		commonActions.logFailStatus("Fail | Valid Ort value display failed - " + ort_TradingVerkauf);
		} 
		
		if(Handelsplatz_TradingVerkauf.equals(CaptureHandelsplatz))
		{
		commonActions.logPassStatus("Pass | Valid Handelsplatz value displayed - " + Handelsplatz_TradingVerkauf);
		}else
		{
		commonActions.logFailStatus("Fail | Valid Handelsplatz value display failed - " + Handelsplatz_TradingVerkauf);
		} 
		
		if(CaptureWKN.contains(WKN_TradingVerkauf))
		{
		commonActions.logPassStatus("Pass | Valid WKN value displayed - " + WKN_TradingVerkauf);
		}else
		{
		commonActions.logFailStatus("Fail | Valid WKN value display failed - " + WKN_TradingVerkauf);
		} 
		
		if(Stuck_TradingVerkauf.equals(CaptureStuck))
		{
		commonActions.logPassStatus("Pass | Valid Stuck value displayed - " + Stuck_TradingVerkauf);
		}else
		{
		commonActions.logFailStatus("Fail | Valid Stuck value display failed - " + Stuck_TradingVerkauf);
		} 
	}
	
	@Then("Verify captured details,Message from OrderErteilen_TradingVerkauf")
	public void verify_captured_details_Message_from_OrderErteilen_TradingVerkauf() throws FileNotFoundException, IOException, ParseException {
		if (CaptureMessage.equals(commonActions.getValueFromJson("Message"))) {
			commonActions.logPassStatus("Pass | Valid Messge displayed -"+CaptureMessage);
		} else {
			commonActions.logFailStatus("Error | Valid Messge display failed -"+CaptureMessage);
		}
	}
	
	@When("Capture entered details on OrderErteilen_Kauf")
	public void capture_entered_details_on_OrderErteilen_Kauf() {
		try {
			Thread.sleep(7000);
			CaptureOrderart = commonActions.getText("CapturedAnleihe_OrderArt");
			CaptureWKN = commonActions.getText("CapturedAnleihe_WKN");
			CaptureHandelsplatz = commonActions.getText("CapturedAnleihe_Handelsplatz");
			CaptureStuck = commonActions.getText("CapturedAnleihe_Stueck_Betrag");
			System.out.println("CapturedStueck_Betrag: " + CaptureStuck);
			System.out.println("CapturedOrderart: " + CaptureOrderart);
			System.out.println("CapturedWKN: " + CaptureWKN);
			System.out.println("CapturedHandelsplatz: " + CaptureHandelsplatz);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

	@When("Capture Message on OrderErteilen_Kauf")
	public void capture_Message_on_OrderErteilen_Kauf() {
		try {
			message = commonActions.getText("CapturedMessageKauf");
			System.out.println("Message CAPTURED: " + message);

		} catch (StaleElementReferenceException e) {
			e.printStackTrace();
			System.out.println("Element not Captured");
		} catch (Exception e) {
			System.out.println("Message NOT CAPTURED");
			e.printStackTrace();
			// commonActions.logAssert_Fail("Message NOT CAPTURED");
		}
	}

	@Then("Verify {string},{string},{string},{string},{string} on OrderUebersicht_Kauf")
	public void verify_on_OrderUebersicht_Kauf(String string, String string2, String string3, String string4, String string5) {
		ort = commonActions.getText("Verify_OrderartTable");
		Handelsplatz = commonActions.getText("Verify_Handelsplatz_table");
		WKN = commonActions.getText("Verify_WKN_table");
		System.out.println("Verify_Orderart:" + ort);
		System.out.println("Verify_Handelsplatz:" + Handelsplatz);
		System.out.println("Verify_WKN:" + WKN);

		if (ort.equals(CaptureOrderart)) {
			System.out.println("Valid Ort value displayed");
			commonActions.logPassStatus("Pass | Valid Ort value displayed - " + ort);
		} else {
			System.out.println("ort print failed-");
			commonActions.logFailStatus("Fail | Valid Ort value display failed - " + ort);
		}
		if (Handelsplatz.equals(CaptureHandelsplatz)) {
			System.out.println("Valid Handelsplat value displayed");
			commonActions.logPassStatus("Pass | Valid Handelsplat value displayed - " + Handelsplatz);
		} else {
			System.out.println("Valid Handelsplat value display failed");
			commonActions.logFailStatus("Fail | Valid Handelsplat value display failed - " + Handelsplatz);
		}
		if (CaptureWKN.contains(WKN)) {
			System.out.println("Valid WKN value displayed");
			commonActions.logPassStatus("Pass | Valid WKN value displayed - " + WKN);
		} else {
			System.out.println("Valid WKN value display failed");
			commonActions.logFailStatus("Fail | Valid WKN value display failed - " + WKN);
		}
		Nominal_Betrag = commonActions.getText("Verify_StueckORNominal");
		System.out.println("Nominal_Betrag:" + Nominal_Betrag);
		if (Nominal_Betrag.equals(CaptureStuck)) {
			System.out.println("Valid Stop NominalStueck_Betrag displayed");
			commonActions.logPassStatus("Pass | Valid Stop NominalStueck_Betrag displayed - " + Nominal_Betrag);
		} else {
			System.out.println("Valid NominalStueck_Betrag value display failed");
			commonActions.logFailStatus("Fail | Valid NominalStueck_Betrag value display failed - " + Nominal_Betrag);
		}

	}

	@Then("Verify captured details,Message from OrderErteilen_Kauf")
	public void verify_captured_details_Message_from_OrderErteilen_Kauf() {
		try {
			if (message.equals(commonActions.getValueFromJson("Message"))) {
				System.out.println("Message : " + message);
				commonActions.logPassStatus("Pass | Valid message displayed " + message);
			} else {
				System.out.println("Message verify failed");
				commonActions.logFailStatus("Fail | Valid message display failed" + message);

			}
		} catch (StaleElementReferenceException e) {
			e.printStackTrace();
			System.out.println("Element not Captured");
		} catch (Exception e) {
			e.printStackTrace();
			// commonActions.logAssert_Fail("Failure verifying data");
		}	
	}
	
	}
