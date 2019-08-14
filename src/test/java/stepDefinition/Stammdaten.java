package stepDefinition;


import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.http.client.ClientProtocolException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;

import configurations.ConfigWeb;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import library.ApplicationLibraryWeb;
import library.TANGenerator;
import pageObjects.LoginPage;
import pageObjects.HomePage;
import pageObjects.LandingPage;
import pageObjects.EuroWeb;
import cucumber.api.Scenario;

public class Stammdaten {

       WebDriver dr;
       ApplicationLibraryWeb lib;
       public Stammdaten(ApplicationLibraryWeb lib) {
       this.lib=lib;
       }
       
       HashMap<String, String> hmap = new HashMap<String, String>();
       
      

       @After
              public void after() {
                    try {
                           System.out.println("Report flushing");
                           lib.quit();
                           System.out.println("Report flushed: ");
                    } catch (Exception e) {
                           // TODO Auto-generated catch block
                           e.printStackTrace();
                    }

              }

              @Before
              public void before(Scenario s) throws Exception {
                    try {
                           System.out.println("In before: " + s.getName());
                           lib.initReports(s.getName());
                    } catch (Exception e) {
                           // TODO Auto-generated catch block
                           e.printStackTrace();
                    }
              }

       @When("User Logs in with {int} , {int}")
       public void user_Logs_in_with(int double1,int double2) {
    	   lib.launchBrowser("chrome");

   		//this.dr = ConfigWeb.dr;
   	//	PageFactory.initElements(dr, HomePage.class);
   		//PageFactory.initElements(dr, LoginPage.class);
   		//PageFactory.initElements(dr, HomePage.class);
   		//PageFactory.initElements(dr, LandingPage.class);
       // lib.takeSceenShot();
    	   lib.clickElement(HomePage.logInButton);
             lib.setTextBoxInt(HomePage.Kontonummer_UserID, double1);
             lib.setTextBoxInt(HomePage.Kontonummer_Passwort, double2);
             lib.clickElement(HomePage.Einloggen);
          
       }

       @And("^User submits the generated TAN number in \"(.*?)\"$")
       public void user_submits_the_generated_TAN_number_in(String string) throws ClientProtocolException, IOException {
          //lib.takeSceenShot();
          lib.setTextBox(HomePage.Tan,TANGenerator.requestTan());
          lib.clickElement(HomePage.BestaetigenButton);
       }

       @And("^User navigates to \"(.*?)\"$")
       public void clickson (String string) throws InterruptedException {
    	  Thread.sleep(10000);
            lib.mouseover(LandingPage.Mein_Konto_Depot);
            //Thread.sleep(1000);
            //Actions action = new Actions(lib.driver);
           // action.doubleClick(LandingPage.Persönliche_Einstellungen).perform();
            //lib.clickElement(LandingPage.Persönliche_Einstellungen);
            
            //lib.mouseover(LandingPage.Mein_Konto_Depot);
           // Thread.sleep(1000);
            LandingPage.Persönliche_Einstellungen.click();
            
            lib.driver.get("https://int-acc-ewev.consorsbank.de/home/euroWebDe/-?$part=Monalisa.defaultPageAddressChange&$event=addressChangeEntry");
            
           // JavascriptExecutor jsexec = (JavascriptExecutor) lib.driver; 
          //  jsexec.executeScript("document.getElementByTagName('Persönliche Einstellungen').click();");
            Thread.sleep(1000);
            
                   
         
       }

       @And("^clicks on \"(.*?)\"$")
       public void clicks_on(String string) throws InterruptedException {
    	  // System.out.println(EuroWeb. + string);
    	 //  System.out.println(EuroWeb.Aendern);
         //  System.out.println(string);
          // lib.driver.findElement(By.xpath(string));
           
          // lib.clickElement(lib.driver.findElement(By.xpath("" + "EuroWeb." + string + "")));
            lib.clickElement(EuroWeb.Aendern); 
           
           //Thread.sleep(1000);
            // lib.takeSceenShot();
       }

       @And("^User enters \"(.*?)\" in Straße, Hausnr. field$")
       public void user_enters_house_no_in_Straße_Hausnr_field(String Strasse) {
          if(Strasse.equalsIgnoreCase("null")){
        	  lib.setTextBox(LandingPage.Straße,Strasse);
              hmap.put("newStreet", Strasse); 
              }
          else {
        	  lib.setTextBox(LandingPage.Straße,Strasse);
              hmap.put("newStreet", Strasse); 
        	  
          }
          
       }

       @And("^User enters \"(.*?)\" in PLZ field$")
       public void user_enters_PLZ_in_PLZ_field(String Plz) {
    	   if(Plz.equalsIgnoreCase("null")){
         	  lib.setTextBox(LandingPage.PLZ,Plz);
               hmap.put("newPLZ", Plz); 
               }
           else {
         	  lib.setTextBox(LandingPage.PLZ,Plz);
               hmap.put("newPLZ", Plz); 
         	  
           }
         }

       @And("^User enters \"(.*?)\" in Ort field$")
       public void user_enters_Ort_in_Ort_field(String Ort) {
       	   if(Ort.equalsIgnoreCase("null")){
          	  lib.setTextBox(LandingPage.Ort,Ort);
                hmap.put("newOrt", Ort); 
                }
            else {
          	  lib.setTextBox(LandingPage.Ort,Ort);
                hmap.put("newPLZ", Ort);    	  
            }
       }
       
            
       @When("User selects \"(.*?)\" in Branche Field")
       public void user_selects_Bitte_auswaehlen_in_Branche_Field(String Brache) {
    	   System.out.println(Brache);
    	   lib.selectoptionByVisibleText(LandingPage.Branche, Brache);
           hmap.put("newBeruf", Brache);
       }

       @When("User clicks on {string} to continue")
       public void user_clicks_on_to_continue(String strButton) {
    	   System.out.println(strButton);
    	   //lib.takeSceenShot();
           lib.clickElement(LandingPage.Weiter);
          
       }

       @Then("Verify error {string} are displayed")
       public void verify_error_is_displayed(String errorString) {
    	 System.out.println(errorString);
       }
       

       @SuppressWarnings("unlikely-arg-type")
	@Then("Verify <ErrorMesssages> are displayed")
public void verify_error_messsages_are_displayed(DataTable dataTable) {
	try {
		List<List<String>> list = dataTable.asLists(String.class);
		
		System.out.println(lib.getText(LandingPage.StraBe_errorMessage));
		System.out.println(list.get(4).toString());
			if((list.get(2).toString()).contains(lib.getText(LandingPage.Branchie_errorMessage))) {

				lib.pass("Branchie message displayed successfully");
				}
			else {
				lib.reportFailure("Branchie error message display: Error");
			}
			
			
			if((list.get(3).toString()).contains(lib.getText(LandingPage.plz_errorMessage))) {

				lib.pass("PLZ message displayed successfully");
				}
			else {
				lib.reportFailure("PLZ error message display: Error");
			}
			
			if((list.get(4).toString()).contains(lib.getText(LandingPage.StraBe_errorMessage))) {

				lib.pass("Strasse message displayed successfully");
				}
			else {
				lib.reportFailure("Strasse error message display: Error");
			}
			
			if((list.get(5).toString()).contains(lib.getText(LandingPage.Ort_errorMessage))) {

				lib.pass("Ort message displayed successfully");
				}
			else {
				lib.reportFailure("Ort error message display: Error");
			}
	               
	        
        /* 
        lib.takeSceenShot();*/
  } catch (Exception e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
        lib.reportFailure("Error message display fail");
  }

}

    
       
      /* @Then("^verify changed data shown on bestaetigung page$")
       public void verify_changed_data_shown_on_bestaetigung_page() {
           // Write code here that turns the phrase above into concrete actions
          if(lib.getText(LandingPage.Straße_txtVerify).equals(hmap.get("newStreet")))
             lib.pass("Street verified success");
           
               if(lib.getText(LandingPage.PLZ_txtVerify).equals(hmap.get("newPLZ")));
                    lib.pass("PLZ verified success");
                    
                     if(lib.getText(LandingPage.Ort_txtVerify).equals(hmap.get("newOrt")));
                    lib.pass("Ort verified success");
                    
                     if(lib.getText(LandingPage.Land_txtVerify).equals(hmap.get("newLand")));
                    lib.pass("Land verified success");
                    
                     if(lib.getText(LandingPage.Steueridentifikationsnummer_txtVerify).equals(hmap.get("newSteueridentifikationsnummer")));
                    lib.pass("newSteueridentifikationsnummer verified success");
                    
                if(lib.getText(LandingPage.Beruf_txtVerify).equals(hmap.get("newBeruf")));
                    lib.pass("Beruf verified success");
                    
                     if(lib.getText(LandingPage.Branche_txtVerify).equals(hmap.get("newChemie")));
                    lib.pass("Branche verified success");
                  */  
                    
          
       
     
   
         
       

       


}
