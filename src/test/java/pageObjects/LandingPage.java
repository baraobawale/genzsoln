package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import library.ApplicationLibraryWeb;

public class LandingPage extends ApplicationLibraryWeb {

               @FindBy(xpath = "//a[@title='Mehr erfahren']")
               public static WebElement knowMore;
               
               // :  //nav/aside/ul/li/a[@href='/ev/Mein-Konto-und-Depot/Uebersicht#Kontouebersicht']
               @FindBy(xpath = "//nav//ul//li//a")
               public static WebElement Mein_Konto_Depot;
               
               @FindBy(xpath = "//input[@title='Ändern']")
               public static WebElement Andern;
               
               @FindBy(xpath="//input[@name='street']")
               public static WebElement Straße;
               
               @FindBy(xpath="//table/tbody/tr[13]/td[2]")
               public static WebElement Straße_txtVerify;
               
               @FindBy(xpath="//input[@name='zipCode']")
               public static WebElement PLZ;    
               
               @FindBy(xpath="//table/tbody/tr[13]/td[2]")
               public static WebElement PLZ_txtVerify;
               
               @FindBy(xpath="//input[@name='city']")
               public static WebElement Ort;
               
               @FindBy(xpath="//table/tbody/tr[13]/td[2]")
               public static WebElement Ort_txtVerify;
             //euroWebDe/-?$part=Monalisa.defaultPageAddressChange&$event=addressChangeEntry
             //a[@href='/euroWebDe/-?$part=Monalisa.defaultPageAddressChange&$event=addressChangeEntry']
               
              // @FindBy(linkText = "Persönliche Einstellungen")
                                        
              @FindBy(xpath = "//a[@href='/euroWebDe/-?$part=Monalisa.defaultPageAddressChange&$event=addressChangeEntry']")
              // @FindBy(xpath = "//nav//ul//li//div[3]//li[2]")
               public static WebElement Persönliche_Einstellungen;
               
               @FindBy(xpath="//select[@name='selectionInListCountries']")
               public static WebElement Land;
               
               @FindBy(xpath="//table/tbody/tr[14]/td[2]")
               public static WebElement Land_txtVerify;
               
               
               @FindBy(xpath="//input[@name='fiscalDomicileCountryTin']")
               public static WebElement Steueridentifikationsnummer;
               
               @FindBy(xpath="//table/tbody/tr[15]/td[2]")
               public static WebElement Steueridentifikationsnummer_txtVerify;
               
               @FindBy(xpath="//select[@name='selectionInListProfession']")
               public static WebElement Beruf; //Arbeiter(in)
               
               @FindBy(xpath="//table/tbody/tr[23]/td[2]")
               public static WebElement Beruf_txtVerify;
                              
               @FindBy(xpath="//select[@name='selectionInListLinesOfBusiness']")
               public static WebElement Branche; //Chemie, Pharma 
               
               @FindBy(xpath="//table/tbody/tr[24]/td[2]")
               public static WebElement Branche_txtVerify;
               
               @FindBy(xpath="//input[@title='Weiter']")
               public static WebElement Weiter;
               
               @FindBy(xpath="//span//input[@name='$$event_confirm' and @title='Bestätigen']")
               public static WebElement Bestätigen;
               
               @FindBy(xpath="//input[@name='t0']")
               public static WebElement Mobile_TAN;
               
               
               //Error messages
               @FindBy(xpath="//*[@id=\"addressChangeConfigure\"]/div[1]/ul/li[1]")
               public static WebElement Branchie_errorMessage;
               
               
               @FindBy(xpath="//*[@id=\"addressChangeConfigure\"]/div[1]/ul/li[2]")
                                            public static WebElement plz_errorMessage;
               
               @FindBy(xpath="//*[@id=\"addressChangeConfigure\"]/div[1]/ul/li[3]")
               public static WebElement StraBe_errorMessage;
               
               @FindBy(xpath="//*[@id=\"addressChangeConfigure\"]/div[1]/ul/li[4]")
               public static WebElement Ort_errorMessage;
}

               
