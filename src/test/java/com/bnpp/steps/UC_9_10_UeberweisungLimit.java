package com.bnpp.steps;

import java.io.FileNotFoundException;
import java.io.IOException;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebElement;

import com.bnpp.library.CommonActions;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class UC_9_10_UeberweisungLimit {

	CommonActions commonActions;
	String CaptureErrorMsg = "";
	String Ueberweisungslimit_details = "";
	String Ueberweisungslimit_message = "";

	public UC_9_10_UeberweisungLimit(CommonActions commonActions) {
		this.commonActions = commonActions;
	}

	@Then("Verify displayed ErrorMesssages on Ueberweisungslimit")
	public void verify_displayed_ErrorMesssages_on_Ueberweisungslimit() {
		try {
			if (commonActions.isElementPresent("UberweisungslimitMessage"))
				commonActions.logPassStatus("Bitte fuellen Sie das Pflichtfeld aus message is displayed successfully");
			else
				commonActions.logFailStatus("Bitte fuellen Sie das Pflichtfeld aus message display fail");
			
			if (commonActions.isElementPresent("IchBestaetigeMessage"))
				commonActions.logPassStatus("Bitte bestaetigen Sie, dass Sie die Hinweise gelesen haben message is displayed successfully");
			else
				commonActions.logFailStatus("Bitte bestaetigen Sie, dass Sie die Hinweise gelesen haben message display fail");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	
	@When("Capture Error Message on Ueberweisungslimit")
	public void capture_Error_Message_on_Ueberweisungslimit() {
		try {
			WebElement text = commonActions.getElement("Ueberweisungslimit");
			CaptureErrorMsg = text.getText();
			System.out.println("CaptureErrorMsg "+CaptureErrorMsg);
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Then("Verify captured Error Message from Ueberweisungslimit")
	public void verify_captured_Error_Message_from_Ueberweisungslimit() throws FileNotFoundException, IOException, ParseException {
		try {
			String str = commonActions.checkGermanCharacters(commonActions.getValueFromJson("Message"));
            System.out.println("data from JSON to verify: "+str);
            System.out.println("CaptureErrorMsg for comparison "+CaptureErrorMsg); 
            if(str.equals(CaptureErrorMsg)) {
                  //commonActions.logPassStatus("captured Error Message from Ueberweisungslimit is verified successfully");
                  commonActions.logPassStatus("Pass | Valid error message displayed - " + CaptureErrorMsg);
                  
            }      
            else {
                  commonActions.logFailStatus("Error | Valid error message display failed -" + CaptureErrorMsg);

			}    
		}
		catch(Exception e) {
			throw new cucumber.api.PendingException();
		}
	}
	
	@When("Capture entered details on Ueberweisungslimit")
	public void capture_entered_details_on_Ueberweisungslimit() {
		try {
			WebElement text = commonActions.getElement("Ueberweisungslimit_value");
			Ueberweisungslimit_details = text.getAttribute("value");
			System.out.println("Ueberweisungslimit_details "+Ueberweisungslimit_details);
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@When("Capture Message on Ueberweisungslimit")
	public void capture_Message_on_Ueberweisungslimit() {
		try {
			WebElement text = commonActions.getElement("Ueberweisungslimit_message");
			Ueberweisungslimit_message = text.getText();
			System.out.println("Ueberweisungslimit_message "+Ueberweisungslimit_message);
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Then("Verify details on Ueberweisungslimit")
	public void verify_details_on_Ueberweisungslimit() {
		try {
//			String str1 = commonActions.getValueFromJson("Uberweisungslimit");
//			System.out.println("data from JSON to verify: "+str1);
//			System.out.println("Ueberweisungslimit_details for comparison "+Ueberweisungslimit_details);	
//			if(str1.equals(Ueberweisungslimit_details)) {
//				commonActions.logPassStatus("captured value from Ueberweisungslimit is verified successfully");
//			}	
//			else {
//				commonActions.logFailStatus("captured value from Ueberweisungslimit is not matching with JSON data");
//			}  
			String str2 = commonActions.checkGermanCharacters(commonActions.getValueFromJson("Message"));
			System.out.println("data from JSON to verify: "+str2);
			System.out.println("Ueberweisungslimit_message for comparison "+Ueberweisungslimit_message);	
			if(str2.equals(Ueberweisungslimit_message)) {
				commonActions.logPassStatus("captured Message from Ueberweisungslimit is verified successfully");
			}	
			else {
				commonActions.logFailStatus("captured Message from Ueberweisungslimit is not matching with JSON data");
			}    
		}
		catch(Exception e) {
			throw new cucumber.api.PendingException();
		}
	}
	@Then("Download PDF generated in New Tab")
	public void download_PDF_generated_in_New_Tab() throws InterruptedException {
		try {
			commonActions.VerifyifFilePresent();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
