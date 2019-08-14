
package library;

import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import configurations.ConfigWeb;
import library.ExtentManager;
import pageObjects.EuroWeb;
import pageObjects.HomePage;
import pageObjects.LandingPage;
import pageObjects.LoginPage;

public class ApplicationLibraryWeb {
               public ExtentReports rep;
               public ExtentTest scenario;
               public WebDriver driver;
               
               public void clickElement( WebElement elem) {
                              try {
 
                                    Thread.sleep(1000);
                                    elem.click();  
                                    //infoLog("Clicking on :"+ elem);
                            
                              } catch (Exception e) {
                            	  System.out.println("Element not found"); 
                            	
                              }
                              }
                              
               /**
               * @author Chetana Kolgiri
               * Description: Common method to Enter text  in textbox 
                */
               public  void setTextBox(WebElement elem, String texttoEnter) {
            	   System.out.println("texttoEnter:" + texttoEnter);
                              try {
                                            if (elem.isEnabled()) {
                                                          // infoLog("Entering text in :"+ elem.getText());
                                                           elem.clear();
                                                           elem.sendKeys(texttoEnter);
                                            }
                                            else{
                                                           System.out.println(elem.getText() + " : Element not found");         
                                            
                                                           }
                              } catch (Exception e) {
                                            // TODO Auto-generated catch block
                                            e.printStackTrace();
                              }
                              }
               public  void setTextBoxInt(WebElement elem, int texttoEnter) {
                   try {
                                 
                                                Thread.sleep(1000);
                                                elem.sendKeys(Integer.toString(texttoEnter));
                                                // infoLog("Entering text in :"+ elem.getText());
                                                         
                                 
                                                
                   } catch (Exception e) {
                	   System.out.println(" Element not found");
                                 e.printStackTrace();
                   }
               }
                   
               
               /**
               * @author Ganesh Babar
               * @param elem Description: Common method to clear text in textbox
               */
public  void clearTextBox(WebElement elem) {
                              try {
                                            if (elem.isEnabled()) {
                                            	//  infoLog("Clearing text in :"+elem.getText());
                                                           elem.clear();
                                            } else {
                                                           System.out.println(elem.getText() + " : Element not found");
                                            }
                              } catch (Exception e) {
                            	  System.out.println( "Element not found");
                                            e.printStackTrace();
                              }
               }

public  String getText(WebElement elem) {
               String str="";
               try {
                              if (elem.isEnabled()) {
                              str=elem.getText();
                              //infoLog("Get text in :"+elem.getText());
                              } else {
                                            System.out.println(elem.getText() + " : Get text failed");
                              }
               } catch (Exception e) {
                              // TODO Auto-generated catch block
                              e.printStackTrace();
               }
               return str;
}

public  void submitform(WebElement elem) {
               try {
                              if (elem.isEnabled()) {
                                            elem.click();
                                            //         infoLog("Submit form :"+elem.getText());
                              } else {
                                            System.out.println(elem.getText() + " : Element not found");
                              }
               } catch (Exception e) {
                              // TODO Auto-generated catch block
                              e.printStackTrace();
               }
}
public  void pause(int pauseTimeinSec) {
               try {
                              Thread.sleep(pauseTimeinSec*1000);
                              } catch (Exception e) {
                              // TODO Auto-generated catch block
                              e.printStackTrace();
               }
}

public  void selectOptionByIndex(WebElement ele, int elementIndex) {
               try {
                              if(ele.isEnabled()) {
                                            Select sel=new Select(ele);
                                            sel.selectByIndex(elementIndex);
                              }
               } catch (Exception e) {
                              // TODO Auto-generated catch block
                              e.printStackTrace();
               }
}             


public  void selectoptionByVisibleText(WebElement ele, String visibleText) {
               try {
                              if(ele.isEnabled()) {
                                            Select sel=new Select(ele);
                                            //   infoLog("Selecting value in :"+ ele);
                                            sel.selectByVisibleText(visibleText);
                                            
                              }
               } catch (Exception e) {
                              // TODO Auto-generated catch block
                              e.printStackTrace();
               }             
}

public  void selectByValue(WebElement ele, String value) {
               if(ele.isEnabled()) {
                              Select sel=new Select(ele);
                              sel.selectByVisibleText(value);
               }             
}

public  void movetoChildWindow() {
               Set<String> handles=driver.getWindowHandles();

               String handle=driver.getWindowHandle();
               for(String a:handles) {
                              if(!a.equals(handle)) {
                                            driver.switchTo().window(a);
                              }
               }
}

public void mouseover(WebElement ele) {
               try {
                              Actions act=new Actions(driver);
                              act.moveToElement(ele).build().perform();
                              //  infoLog("Mouseover :"+ ele);
               } catch (Exception e) {
                              // TODO Auto-generated catch block
                              e.printStackTrace();
               }
               
}

public  void movescrolldown() {
               Actions act=new Actions(driver);
               act.moveByOffset(-10, -10).click().build().perform();
}


               public WebDriver launchBrowser(String browsername) {
                              try {
                            	  
                                            if(browsername.equalsIgnoreCase("chrome")) {
                                            System.setProperty("webdriver.chrome.driver", ConfigWeb.chromeDriverPath);
                                            driver = new ChromeDriver();
                                            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
                                            driver.manage().window().maximize();
                                            driver.get(ConfigWeb.url);
                                       		PageFactory.initElements(driver, HomePage.class);
                                       		PageFactory.initElements(driver, LoginPage.class);
                                       		PageFactory.initElements(driver, HomePage.class);
                                       		PageFactory.initElements(driver, LandingPage.class);
                                       		PageFactory.initElements(driver, EuroWeb.class);
                                            }
                                            else
                                                           System.out.println("Invalid browser name");
                              } catch (Exception e) {
                                            // TODO Auto-generated catch block
                                            e.printStackTrace();
                              }
                              return driver;

               }

               /********** logging **************/
               public void infoLog(String msg) {
                              scenario.log(Status.INFO, msg);
               }

               public void pass(String msg) {
                              scenario.log(Status.PASS, msg);
               }

               public void reportFailure(String errMsg) {
                              // fail in extent reports
                              System.out.println("Please Fail report");
                              scenario.log(Status.FAIL, errMsg);
                              System.out.println("Report failed");
                              takeSceenShot();
                              // take screenshot and put in repots
                              // fail in cucumber as well
                              // assertThat(false);
                              //assertTrue(false);
               }

               public void takeSceenShot() {
                              // fileName of the screenshot
                              Date d = new Date();
                              String screenshotFile = d.toString().replace(":", "_").replace(" ", "_") + ".png";
                              // take screenshot
                              File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                              try {
                                            // get the dynamic folder name
                                            FileUtils.copyFile(srcFile, new File(ExtentManager.screenshotFolderPath + screenshotFile));
                                            // put screenshot file in reports
                                            scenario.log(Status.FAIL, "Screenshot-> "
                                                                          + scenario.addScreenCaptureFromPath(ExtentManager.screenshotFolderPath + screenshotFile));
                              } catch (IOException e) {
                                            // TODO Auto-generated catch block
                                            e.printStackTrace();
                              }

               }

               
               public void initReports(String scenarioName) throws Exception {
                              try {
                                            rep = ExtentManager.getInstance(System.getProperty("user.dir") + "\\src\\test\\java\\reports\\");
                                            scenario = rep.createTest(scenarioName);
                                            System.out.println("Starting init report");
                                            scenario.log(Status.INFO, "Starting " + scenarioName);
                              } catch (Exception e) {
                                            // TODO Auto-generated catch block
                                            throw e;
                              }
               }

               public void quit() {
                             // if (rep != null)
                                            rep.flush();
                            //  if (driver != null)
                                            driver.quit();
               }

}

