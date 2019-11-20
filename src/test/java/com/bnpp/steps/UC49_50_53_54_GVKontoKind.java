package com.bnpp.steps;

import com.bnpp.library.CommonActions;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class UC49_50_53_54_GVKontoKind {

	String CaptureMsgKostenlosesWertpapierdepotBestehendesKind="";
	String CaptureVorgangsnummerKostenlosesWertpapierdepotBestehendesKind="";
	String CaptureMsgTagesgeldkontoBestehendes="";
	String CaptureVorgangsnummerTagesgeldkontoBestehendes="";

	CommonActions commonActions;

	public UC49_50_53_54_GVKontoKind(CommonActions commonActions) {
		this.commonActions = commonActions;
	}

	@When("Capture Vorgangsnummer,Message on KostenlosesWertpapierdepotBestehendesKind")
	public void capture_Vorgangsnummer_Message_on_KostenlosesWertpapierdepotBestehendesKind() {
		try {
			CaptureMsgKostenlosesWertpapierdepotBestehendesKind = commonActions.getText("Capture_Message_KostenlosesWertpapierdepotBestehendesKind");
			CaptureVorgangsnummerKostenlosesWertpapierdepotBestehendesKind = commonActions.getText("Capture_Vorgangsnummer_KostenlosesWertpapierdepotBestehendesKind");
			}
		catch (Exception e) {
			e.printStackTrace();
			commonActions.logAssert_Fail("Capture Vorgangsnummer,Message on KostenlosesWertpapierdepotBestehendesKind failed");
		}
	}

	@Then("Verify captured Vorgangsnummer,Message from KostenlosesWertpapierdepotBestehendesKind")
	public void verify_captured_Vorgangsnummer_Message_from_KostenlosesWertpapierdepotBestehendesKind() {
		try {
			if (CaptureMsgKostenlosesWertpapierdepotBestehendesKind.equals(commonActions.getValueFromJson("Message"))) {
				commonActions.logPassStatus("Pass | Valid Messge displayed successfully -"+CaptureMsgKostenlosesWertpapierdepotBestehendesKind);

			} else {
				commonActions.logFailStatus("Error | Valid Messge display failed -"+CaptureMsgKostenlosesWertpapierdepotBestehendesKind);
			}if (!CaptureVorgangsnummerKostenlosesWertpapierdepotBestehendesKind.equals("")) {
				commonActions.logPassStatus("Pass | Valid Vorgangsnummer displayed successfully  - "+CaptureVorgangsnummerKostenlosesWertpapierdepotBestehendesKind);
			} else {
				commonActions.logFailStatus("Error | captured Vorgangsnummer - "+CaptureVorgangsnummerKostenlosesWertpapierdepotBestehendesKind);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			commonActions.logAssert_Fail("Verify captured Vorgangsnummer,Message from KostenlosesWertpapierdepotBestehendesKind failed");
		}
	}


	@When("Capture Vorgangsnummer,Message on TagesgeldkontoBestehendes")
	public void capture_Vorgangsnummer_Message_on_TagesgeldkontoBestehendes() {

		try {			
			CaptureMsgTagesgeldkontoBestehendes = commonActions.getText("Capture_Message_TagesgeldkontoBestehendes");
			CaptureVorgangsnummerTagesgeldkontoBestehendes = commonActions.getText("Capture_Vorgangsnummer_TagesgeldkontoBestehendes");

			System.out.println("CaptureMsgTagesgeldkontoBestehendes: " + CaptureMsgTagesgeldkontoBestehendes);
			System.out.println("CaptureVorgangsnummerTagesgeldkontoBestehendes: " + CaptureVorgangsnummerTagesgeldkontoBestehendes);

		}
		catch (Exception e) {
			e.printStackTrace();
			commonActions.logAssert_Fail("Capture Vorgangsnummer,Message on TagesgeldkontoBestehendes failed");
		}
	}

	@Then("Verify captured Vorgangsnummer,Message from TagesgeldkontoBestehendes")
	public void verify_captured_Vorgangsnummer_Message_from_TagesgeldkontoBestehendes() {
		try {
			if (CaptureMsgTagesgeldkontoBestehendes.equals(commonActions.getValueFromJson("Message"))) {
				commonActions.logPassStatus("Pass | Valid Messge displayed successfully -"+CaptureMsgTagesgeldkontoBestehendes);

			} else {
				commonActions.logFailStatus("Error | Valid Messge display failed -"+CaptureMsgTagesgeldkontoBestehendes);
			}
			if (!CaptureVorgangsnummerTagesgeldkontoBestehendes.equals("")) {
				commonActions.logPassStatus("Pass | captured Vorgangsnummer - "+CaptureVorgangsnummerTagesgeldkontoBestehendes);
			} else {
				commonActions.logFailStatus("Error | captured Vorgangsnummer - "+CaptureVorgangsnummerTagesgeldkontoBestehendes);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			commonActions.logAssert_Fail("Verify captured Vorgangsnummer,Message from TagesgeldkontoBestehendes failed");
		}
	}


}
