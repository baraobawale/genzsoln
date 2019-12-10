package com.bnpp.steps;

import com.bnpp.library.CommonActions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class UC49_50_53_54_GVKontoKind {

	String CaptureMsgKostenlosesWertpapierdepotBestehendesKind="";
	String CaptureVorgangsnummerKostenlosesWertpapierdepotBestehendesKind="";
	String CaptureMsgTagesgeldkontoBestehendes="";
	String CaptureVorgangsnummerTagesgeldkontoBestehendes="";
	String CaptureVorgangsnummerKostenlosesWertpapierdepotWeiteresKind ="";
	String CaptureMsgKostenlosesWertpapierdepotWeiteresKind="";
	String CaptureMsgTagesgeldkontoWeiteres ="";
	String CaptureVorgangsnummerTagesgeldkontoWeiteres ="";

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

	@Given("Capture then  Vorgangsnummer,Message on KostenlosesWertpapierdepotWeiteresKind")
	public void capture_then_Vorgangsnummer_Message_on_KostenlosesWertpapierdepotWeiteresKind() {
		try {			
			CaptureMsgKostenlosesWertpapierdepotWeiteresKind = commonActions.getText("Capture_Message_KostenlosesWertpapierdepotWeiteresKind");
			CaptureVorgangsnummerKostenlosesWertpapierdepotWeiteresKind = commonActions.getText("Capture_Vorgangsnummer_KostenlosesWertpapierdepotWeiteresKind");

			System.out.println("CaptureMsgKostenlosesWertpapierdepotWeiteresKind: " + CaptureMsgKostenlosesWertpapierdepotWeiteresKind);
			System.out.println("CaptureVorgangsnummerKostenlosesWertpapierdepotWeiteresKind: " + CaptureVorgangsnummerKostenlosesWertpapierdepotWeiteresKind);

		}
		catch (Exception e) {
			e.printStackTrace();
			commonActions.logAssert_Fail("Capture Vorgangsnummer,Message on TagesgeldkontoBestehendes failed");
		}
	}

	@Then("Verify then captured Vorgangsnummer,Message from KostenlosesWertpapierdepotWeiteresKind")
	public void verify_then_captured_Vorgangsnummer_Message_from_KostenlosesWertpapierdepotWeiteresKind() {
		try {
			if (CaptureMsgKostenlosesWertpapierdepotWeiteresKind.equals(commonActions.getValueFromJson("Message"))) {
				commonActions.logPassStatus("Pass | Valid Messge displayed successfully -"+CaptureMsgKostenlosesWertpapierdepotWeiteresKind);

			} else {
				commonActions.logFailStatus("Error | Valid Messge display failed -"+CaptureMsgKostenlosesWertpapierdepotWeiteresKind);
			}
			if (!CaptureVorgangsnummerKostenlosesWertpapierdepotWeiteresKind.equals("")) {
				commonActions.logPassStatus("Pass | captured Vorgangsnummer - "+CaptureVorgangsnummerKostenlosesWertpapierdepotWeiteresKind);
			} else {
				commonActions.logFailStatus("Error | captured Vorgangsnummer - "+CaptureVorgangsnummerKostenlosesWertpapierdepotWeiteresKind);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			commonActions.logAssert_Fail("Verify captured Vorgangsnummer,Message from TagesgeldkontoBestehendes failed");
		}
	}

	@Given("Capture Vorgangsnummer,Message on TagesgeldkontoWeiteres")
	public void capture_Vorgangsnummer_Message_on_TagesgeldkontoWeiteres() {
		try {			
			CaptureMsgTagesgeldkontoWeiteres = commonActions.getText("Capture_Message_TagesgeldkontoWeiteres");
			CaptureVorgangsnummerTagesgeldkontoWeiteres = commonActions.getText("Capture_Vorgangsnummer_TagesgeldkontoWeiteres");

			System.out.println("CaptureMsgKostenlosesWertpapierdepotWeiteresKind: " + CaptureMsgTagesgeldkontoWeiteres);
			System.out.println("CaptureVorgangsnummerKostenlosesWertpapierdepotWeiteresKind: " + CaptureVorgangsnummerTagesgeldkontoWeiteres);

		}
		catch (Exception e) {
			e.printStackTrace();
			commonActions.logAssert_Fail("Capture Vorgangsnummer,Message on TagesgeldkontoBestehendes failed");
		}
	}

	@Then("Verify captured Vorgangsnummer,Message from TagesgeldkontoWeiteres")
	public void verify_captured_Vorgangsnummer_Message_from_TagesgeldkontoWeiteres() {
		try {
			if (CaptureMsgTagesgeldkontoWeiteres.equals(commonActions.getValueFromJson("Message"))) {
				commonActions.logPassStatus("Pass | Valid Messge displayed successfully -"+CaptureMsgTagesgeldkontoWeiteres);

			} else {
				commonActions.logFailStatus("Error | Valid Messge display failed -"+CaptureMsgTagesgeldkontoWeiteres);
			}
			if (!CaptureVorgangsnummerTagesgeldkontoWeiteres.equals("")) {
				commonActions.logPassStatus("Pass | captured Vorgangsnummer - "+CaptureVorgangsnummerTagesgeldkontoWeiteres);
			} else {
				commonActions.logFailStatus("Error | captured Vorgangsnummer - "+CaptureVorgangsnummerTagesgeldkontoWeiteres);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			commonActions.logAssert_Fail("Verify captured Vorgangsnummer,Message from TagesgeldkontoBestehendes failed");
		}
	}

}
