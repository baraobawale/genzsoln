package pageObjects;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import library.ApplicationLibraryWeb;


public class LoginPage  extends ApplicationLibraryWeb{
	
	
	@FindBy(xpath = "//input[@name='email']")
	public static WebElement emailTextBox;

	@FindBy(xpath = "//input[@name='password']")
	public static WebElement passwordTextBox;

	@FindBy(xpath = "//input[@id='signInSubmit']")
	public static WebElement signInSubmit;
	
	@FindBy(xpath = "//a[text()='Login']")
	public static WebElement logInButton;
	
	
	
	

	

}
