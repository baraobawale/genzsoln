package com.bnpp.library;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.bnpp.reports.ExtentManager;
import com.bnpp.utilities.Configurations;
import com.bnpp.utilities.TANGenerator;

public class CommonActions {
	WebDriver driver;
	public ExtentReports report;
	public ExtentTest scenario;
	Properties properties;
	public FileInputStream fis;
	public static String featurename;
	public static String scenarioname;

	public CommonActions() {

		if (properties == null) {
			try {
				properties = new Properties();
				fis = new FileInputStream(
						System.getProperty("user.dir") + "/src/test/resources/ObjectRepository/Object.properties");
				properties.load(fis);
			} catch (Exception e) {
				e.printStackTrace();
				Assert.fail();
			}
		}
	}

	/**
	 * Description: Open the desired browser reading from properties file
	 * 
	 * @throws MalformedURLException
	 */
	public void launchBrowser() throws MalformedURLException {
		try {
			if ((Configurations.RunOnBrowserStack).equals("Y")) {
				DesiredCapabilities capability = DesiredCapabilities.chrome();
				capability.setPlatform(Platform.WINDOWS);
				capability.setCapability("name", "Bstack-[Java] JUnit Single Test");
				capability.setCapability("build", "JUnit - Sample");
				capability.setCapability("browserstack.local", "true");
				System.out.println(Configurations.URL_BS);
				driver = new RemoteWebDriver(new URL(Configurations.URL_BS), capability);
			} else {
				if ((Configurations.BrowserName).equals("Chrome")) {
					System.setProperty("webdriver.chrome.driver", Configurations.chromeDriverPath);
					driver = new ChromeDriver(loadChromeOptions());
				} else if ((Configurations.BrowserName).equals("IE")) {
					System.setProperty("webdriver.ie.driver", properties.getProperty("ieDriverPath"));
					driver = new InternetExplorerDriver();
				}
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
				driver.get(Configurations.Appurl);

			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Invalid browser name or configuration");
			Assert.fail();
		}
	}

	public ChromeOptions loadChromeOptions() {
		ChromeOptions ops = null;
		try {
			System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "null");
			System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
			ops = new ChromeOptions();
			ops.addArguments("--disable-notifications");
			ops.addArguments("disable-infobars");
			ops.addArguments("--start-maximized");
			ops.setExperimentalOption("useAutomationExtension", false);
			// Setting new download directory path
			Map<String, Object> prefs = new HashMap<String, Object>();
			// prefs.put("download.default_directory",
			// System.getProperty("user.dir") + "/Downloads");
			ops.setExperimentalOption("prefs", prefs);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ops;
	}

	/**
	 * Description Refresh the page
	 */
	public void refreshPage() {
		driver.navigate().refresh();
	}

	/**
	 * 
	 */

	public void waitForVisibilityofElement(String ObjectKey) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 50);
			wait.until(ExpectedConditions.visibilityOf(getElement(ObjectKey)));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logAssert_Fail("Element not visible within given time limit: " + ObjectKey);
		}
	}

	public void waitForInvisibilityofElement(String ObjectKey) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.invisibilityOf(getElement(ObjectKey)));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logAssert_Fail("Element still visible within given time limit: " + ObjectKey);
		}
	}

	/**
	 * @param objectKey
	 * @return WebElement Description: Central function to extract objects
	 */
	public WebElement getElement(String objectKey) throws IllegalArgumentException {
		WebElement e = null;
		WebDriverWait wait = new WebDriverWait(driver, 40);
		try {
			e = driver.findElement(By.xpath(properties.getProperty(objectKey)));// present
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", e);
			
		} catch (IllegalArgumentException ex) {
			ex.printStackTrace();
			System.out.println("\r\n" + "Locator key missing in object repository file: " + objectKey);
			logAssert_Fail("\r\n" + "Locator key missing in object repository file: " + objectKey);
		} catch (NoSuchElementException ex) {
			ex.printStackTrace();
			System.out.println("Element not present on the page: " + objectKey);
			logAssert_Fail("\r\n" + "Element not present on the page: " + objectKey);
		} catch (ElementNotInteractableException ex) {
			ex.printStackTrace();
			logAssert_Fail("\r\n" + "Element not visible on the page: " + objectKey);
		}catch(InvalidSelectorException ex){
			ex.printStackTrace();
			logAssert_Fail("Invalid xpath selector");
		} catch (Exception ex) {
			ex.printStackTrace();
			System.out.println("Object identification failed: " + objectKey);
			logAssert_Fail("\r\n" + "Object identification failed: " + objectKey);
		}
		return e;
	}

	/**
	 * @param objectKey
	 * @return true if element is present false if not found. Description: Check
	 *         if element is present and used as a checkpoint. true - present
	 */
	public boolean isElementPresent(String objectKey) {
		List<WebElement> e = null;
		e=driver.findElements(By.xpath(properties.getProperty(objectKey)));
		if (e.size() == 0) {
			System.out.println("element not present: "+objectKey);
			return false;
		} else{
			System.out.println("Elements present:Count "+objectKey+":"+e.size());
			return true;
		}
	}

	/**
	 * 
	 * @param objectKey
	 *            Description: Common action click
	 * @throws InterruptedException
	 */
	public void click(String objectKey) throws InterruptedException {
		try {
			Thread.sleep(2000);
			getElement(objectKey).click();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * @param objectKey
	 * @param strValue
	 *            Description: Common action type
	 * @throws IllegalArgumentException
	 * @throws InterruptedException
	 * @throws ParseException
	 * @throws IOException
	 */
	public void enterText(String objectKey, String datakey)
			throws IllegalArgumentException, InterruptedException, IOException, ParseException {
		getElement(objectKey).clear();
		getElement(objectKey).sendKeys(getValueFromJson(datakey));
		if (objectKey.equals("Steueridentifikationsnummer"))
			getElement("Weiter").click();

	}

	/**
	 * 
	 * @param objectKey
	 * @param strValue
	 *            Description Type Tan no
	 * @throws InterruptedException
	 */
	public void enterTokenTan(String objectKey, String strValue) throws InterruptedException {
		// TODO Auto-generated method stub
		Thread.sleep(2000);
		getElement(objectKey).sendKeys(strValue);

	}

	/**
	 * @param objectKey
	 *            Description Common action clear
	 */
	public void clearfield(String objectKey) {
		getElement(objectKey).clear();
	}

	/**
	 * @param objectKey
	 * @return string Description Common action gettext
	 */
	public String getText(String objectKey) {
		String str = "";
		return str = getElement(objectKey).getText();
	}

	/**
	 * @param objectKey
	 * @param data
	 * @throws Exception
	 *             Description Common action select from combo box by visible
	 *             text
	 */
	public void selectFromDropDown(String objectKey, String datakey) throws Exception {
		Select s = new Select(getElement(objectKey));
		String myData = getValueFromJson(datakey);
		try {
			s.selectByVisibleText(myData);
		} catch (Exception e) {
			logAssert_Fail("Select by visble text failed on: " + objectKey);
		}

	}
	/**
	 * Description Press escape key
	 */
	public void pressTab(){
		Actions act=new Actions(driver);
		act.sendKeys(Keys.TAB).build().perform();
	}

	/**
	 * 
	 * @param objectKey
	 * @param data
	 * @throws Exception
	 *             Description Common action select from combo box by Index
	 */
	public void selectDropDownByIndex(String objectKey, String data) throws Exception {
		Select s = new Select(getElement(objectKey));
		Thread.sleep(5000);
		s.selectByIndex(Integer.parseInt(data));
	}

	/**
	 * Description Common action move to a child window or new window
	 */

	public void movetoChildWindow() {
		Set<String> handles = driver.getWindowHandles();
		String handle = driver.getWindowHandle();
		for (String a : handles) {
			if (!a.equals(handle)) {
				driver.switchTo().window(a);
			}
		}
	}

	/**
	 * 
	 * @param objectKey
	 *            Description Common action mouse over the element
	 */
	public void mouseover(String objectKey) {
		try {
			Actions act = new Actions(driver);
			act.moveToElement(getElement(objectKey)).build().perform();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Description Common action to move scroll down
	 */

	public void moveScrollDown() {

		// Actions act=new Actions(driver);
		// act.moveByOffset(-100,-100).build().perform();

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");

	}

	/**
	 * Description Reporting function to message the information step
	 */
	public void logInfoStatus(String msg) {
		scenario.log(Status.INFO, msg);
	}

	/**
	 * 
	 * @param msg
	 *            Description Reporting function to pass the step
	 */
	public void logPassStatus(String msg) {
		scenario.log(Status.PASS, msg);
	}

	/**
	 * @param errMsg
	 *            Description Common function to fail the report and stop
	 *            execution
	 */
	public void logAssert_Fail(String errMsg) {
		// fail in extent reports
		scenario.log(Status.FAIL, errMsg);
		if ((Configurations.takeScreenshots).equals("Y")) {
			takeSceenShot();
		}
		// take screenshot and put in repots
		// fail in cucumber as well
		Assert.fail();
	}

	/**
	 * 
	 * @param msg
	 *            Description Reporting function to fail the step and continue
	 *            execution
	 */
	public void logFailStatus(String msg) {
		scenario.log(Status.FAIL, msg);
	}

	/**
	 * Description Common function to take the screenshots of failure steps
	 */

	public void takeSceenShot() {
		if ((Configurations.takeScreenshots).equals("Y")) {
			Date d = new Date();
			String screenshotFile = d.toString().replace(":", "_").replace(" ", "_") + ".png";
			// take screenshot
			File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			try {
				// get the dynamic folder name
				FileUtils.copyFile(srcFile, new File(ExtentManager.screenshotFolderPath + screenshotFile));
				// put screenshot file in reports
				scenario.log(Status.DEBUG, "Screenshot-> "
						+ scenario.addScreenCaptureFromPath(ExtentManager.screenshotFolderPath + screenshotFile));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	/**
	 * Description Common function for quitting the browser and reports.
	 */
	public void quit() {
		if (report != null)
			report.flush();
		if (driver != null)
			driver.quit();
	}

	/**
	 * 
	 * @param scenarioName
	 *            Description Common function to initialize the reports
	 */
	public void initReports(String scenarioName) {
		report = ExtentManager.getInstance(Configurations.reportPath);
		scenario = report.createTest(scenarioName);
		scenario.log(Status.INFO, "Starting " + scenarioName);
	}

	public String getValueFromJson(String objectKey) throws FileNotFoundException, IOException, ParseException {
		String datakey = null;
		try {
			datakey = getKeyFromJson(objectKey);
			datakey = checkGermanCharacters(datakey);
			System.out.println(objectKey + ":" + datakey);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logAssert_Fail(objectKey + " :ObjectKey not present in json file");
		}
		return datakey;
	}

	public String getKeyFromJson(String objectKey) throws FileNotFoundException, IOException, ParseException {

		String data = null;
		JSONParser parser = new JSONParser();
		JSONObject getFeatureName = (JSONObject) parser
				.parse(new FileReader("./src/test/java/com/bnpp/TestData/" + featurename + ".json"));
		JSONObject featureName = (JSONObject) getFeatureName.get(featurename);
		Map<String, String> getScenarioName = (Map<String, String>) featureName.get(scenarioname);
		Iterator it = getScenarioName.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry pair = (Map.Entry) it.next();
			if (pair.getKey().toString().equals(objectKey)) {
				data = pair.getValue().toString();
				break;
			}
			System.out.println(pair.getKey() + ":" + pair.getValue().toString());
		}
		return data;

	}

	public String verifyErrorMessage(String messageKey) throws FileNotFoundException, IOException, ParseException {
		String data = null;
		try {
			JSONParser parser = new JSONParser();
			JSONObject getFeatureName = (JSONObject) parser
					.parse(new FileReader("./src/test/java/com/bnpp/TestData/" + featurename + ".json"));
			JSONObject featureName = (JSONObject) getFeatureName.get(featurename);
			JSONObject scenario = (JSONObject) featureName.get(scenarioname);
			Map<String, String> getmessagename = (Map<String, String>) scenario.get("ErrorMesssages");
			Iterator it = getmessagename.entrySet().iterator();
			while (it.hasNext()) {
				Map.Entry pair = (Map.Entry) it.next();
				if (pair.getKey().toString().equals(messageKey)) {
					data = pair.getValue().toString();
					break;
				}
				System.out.println(pair.getKey() + ":" + pair.getValue().toString());
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			Assert.fail();
		}
		return data;
	}

	public String checkGermanCharacters(String data) {
		try {
			if (!data.equals("")) {
				if (data.contains("ae"))
					data = data.replace("ae", "ä");
				else if (data.contains("oe"))
					data = data.replace("oe", "ö");
				else if (data.contains("ue"))
					data = data.replace("ue", "ü");

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;

	}

	public void setfaturefilenameandsceanrio(String id, String name) {
		featurename = id;
		String[] d = featurename.split("/features_wip/");
		System.out.println(d[0] + " " + d[1]);
		String[] d2 = d[1].split(".feature");
		System.out.println(d2[0]);
		featurename = d2[0];
		scenarioname = name;

	}

	public void deleteExistingTemplates(String DeleteTemplates) throws Exception {
		List<WebElement> ele = driver.findElements(By.xpath(DeleteTemplates));// TODO
																				// Auto-generated
																				// method
																				// stub
		try {
			if (isElementPresent(DeleteTemplates)) {
				for (int i = 0; i < ele.size(); i++) {
					click(DeleteTemplates);
					enterTokenTan("Mobile_TAN_field_Bhavini", TANGenerator.requestTan());
					click("Delete_confirmation");
					System.out.println("Deleting element" + ele.get(0));
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("All existing templates cleared");
		}
	}
	
	public void clearCheckBox(String objectKey){
        WebElement e;
        
        try {
        e = driver.findElement(By.xpath(properties.getProperty(objectKey+"_checkbox")));// present
        System.out.println(e.isSelected());
        if(e.isSelected()) {
               Thread.sleep(1000);
               System.out.println("checkbox was selected");
               driver.findElement(By.xpath(properties.getProperty(objectKey))).click();
        }
        else {
               System.out.println("checkbox was unselected");
        }
        }
        catch(Exception ex) {
               
        }
  }

		public void selectCheckBox(String objectKey) throws Exception {
		WebElement checkbox = getElement(objectKey);
		if (!checkbox.isSelected())
		{
			checkbox.click();
		}
		
		Thread.sleep(2000);
	}


}
