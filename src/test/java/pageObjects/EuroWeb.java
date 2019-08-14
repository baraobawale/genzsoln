package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EuroWeb {
	
	  @FindBy(xpath = "//input[@title='Ändern']")
      public static WebElement Aendern;
	  
	 // public static String Aendern = "//input[@title='Ändern']";
	  

}
