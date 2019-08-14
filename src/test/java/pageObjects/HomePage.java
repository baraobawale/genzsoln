package pageObjects;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import library.ApplicationLibraryWeb;



public class HomePage  extends ApplicationLibraryWeb {
               
               //WebDriver dr  = ConfigWeb.dr;

               @FindBy(xpath = "//input[@id='user-id']")
               public static WebElement Kontonummer_UserID;
               
               @FindBy(xpath = "//input[@id='password']")
               public static WebElement Kontonummer_Passwort;
               
               @FindBy(xpath = "//button[@id='login']")
               public static WebElement Einloggen;
               
               @FindBy(xpath = "//input[@id='tan']")
               public static WebElement Tan;
               
           	@FindBy(xpath = "//*[@id=\"header-login-button\"]")
        	public static WebElement logInButton;
           	
          	@FindBy(xpath = "//button[@title='Bestätigen']")
        	public static WebElement BestaetigenButton;
           	
            
               
               
               
               
               
               
               
               
               
               
               
               
               
               
               
               

               
               
}
