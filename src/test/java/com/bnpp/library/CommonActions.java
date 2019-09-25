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

import javax.xml.parsers.ParserConfigurationException;

import org.apache.commons.io.FileUtils;
import org.apache.http.client.ClientProtocolException;
import org.assertj.core.api.SoftAssertions;
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
import org.openqa.selenium.PageLoadStrategy;
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
import org.xml.sax.SAXException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.bnpp.mTANResources.MobileTan;
import com.bnpp.reports.ExtentManager;
import com.bnpp.utilities.Configurations;

public class CommonActions {
	WebDriver driver;
	public ExtentReports report;
	public ExtentTest scenario;
	Properties properties;
	public FileInputStream fis;
	public static String featurename;
	public static String scenarioname;
	public SoftAssertions softAssertions;

	public CommonActions() {

		if (properties == null) {
			try {
				properties = new Properties();
				fis = new FileInputStream(
						System.getProperty("user.dir") + "\\src\\test\\resources\\ObjectRepository\\Object.properties");
				properties.load(fis);
				softAssertions = new SoftAssertions();
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
	            DesiredCapabilities caps = new DesiredCapabilities();
	            System.getProperties().put("https.proxyHost", "proxyclient.corp.dir");
	            System.getProperties().put("https.proxyPort", "8080");
	            caps.setCapability("browser", "Chrome");
	            caps.setCapability("browser_version", "75.0");
	            caps.setCapability("os", "Windows");
	            caps.setCapability("os_version", "10");
	            caps.setCapability("resolution", "1024x768");
	            caps.setCapability("name", "BNPP 25.09 UC69_70_Risikoklasse");
	            caps.setCapability("browserstack.local", "true");
	            System.out.println(Configurations.URL_BS);
				driver = new RemoteWebDriver(new URL(Configurations.URL_BS), caps);
			} else {
				if ((Configurations.BrowserName).equals("Chrome")) {
					System.setProperty("webdriver.chrome.driver", Configurations.chromeDriverPath);
					driver = new ChromeDriver(loadChromeOptions());
					logInfoStatus("Info | Browser : " + (Configurations.BrowserName));
				} else if ((Configurations.BrowserName).equals("IE")) {
					System.setProperty("webdriver.ie.driver", properties.getProperty("ieDriverPath"));
					driver = new InternetExplorerDriver();
				}
			}
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	        driver.get(Configurations.Appurl);
	        logInfoStatus("Info | Environment Name: " + Configurations.Appurl);
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
			ops.setPageLoadStrategy(PageLoadStrategy.NORMAL);
			// Setting new download directory path
			Map<String, Object> prefs = new HashMap<String, Object>();
			// prefs.put("download.default_directory",
			// System.getProperty("user.dir") + "\\Downloads");
			prefs.put("plugins.plugins_disabled", new String[] { "Chrome PDF Viewer" });
			prefs.put("plugins.always_open_pdf_externally", true);
			prefs.put("profile.default_content_settings.popups", 0);
			Date d = new Date();
			String folderName = d.toString().replace(":", "_");
			new File(Configurations.downloadPath).mkdirs();
			Configurations.downloadPath = Configurations.downloadPath + folderName;

			// directory of the report folder
			new File(Configurations.downloadPath).mkdirs();
			prefs.put("download.default_directory", Configurations.downloadPath);

			ops.setExperimentalOption("prefs", prefs);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ops;
	}

	/**
	 * Description set text to the field
	 */
	public void setText(String objectKey, String datakey)
			throws IllegalArgumentException, InterruptedException, IOException, ParseException {
		try {
			getElement(objectKey).clear();
			getElement(objectKey).sendKeys(datakey);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @param objectKey
	 *            Description Common verify file is Present
	 * @throws InterruptedException
	 */
	public void VerifyifFilePresent() throws InterruptedException {
		try {
			Thread.sleep(10000);
			File Files = new File(Configurations.downloadPath);
			System.out.println("download path" + Configurations.downloadPath);
			int Count = Files.list().length;
			System.out.println("No. Of Files: " + Count);
			if (Count == 1) {
				// logPassStatus("PDF is downloaded successfully at
				// "+Configurations.downloadPath);
				logPassStatus("Pass | PDF is downloaded successfully at - " + Configurations.downloadPath);

			} else {
				logFailStatus("Error | PDF download failed, PLease check");

				logFailStatus("Pdf is not downloaded");
			}
			// put download file path in reports
			// scenario.debug(Configurations.downloadPath);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @param objectKey
	 * @param data
	 * @throws Exception
	 *             Description Common action select from combo box by value text
	 */
	public void selectFromDropDownByValue(String objectKey, String datakey) throws Exception {
		Select s = new Select(getElement(objectKey));
		String myData = getValueFromJson(datakey);
		if (datakey.equals("Account_Type")) {
			myData = "880589404";
		}
		try {
			s.selectByValue(myData);
		} catch (Exception e) {
			logAssert_Fail("Select by visble text failed on: " + objectKey);
		}

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
			WebDriverWait wait = new WebDriverWait(driver, 20);
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
		} catch (InvalidSelectorException ex) {
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
		e = driver.findElements(By.xpath(properties.getProperty(objectKey)));
		if (e.size() == 0) {
			System.out.println("element not present: " + objectKey);
			return false;
		} else {
			System.out.println("Elements present:Count " + objectKey + ":" + e.size());
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
			logInfoStatus("Info | Clicked on : " + objectKey);
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
		try {
			getElement(objectKey).clear();
//			getElement(objectKey).sendKeys(getValueFromJson(datakey));
			String text = getValueFromJson(datakey);
			if(text.equals("null")) {
				//do nothing
			}
			else {
				getElement(objectKey).sendKeys(text);
			}
			if (objectKey.equals("Steueridentifikationsnummer"))
				getElement("Weiter").click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

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
		try {
			Thread.sleep(2000);
			getElement(objectKey).sendKeys(strValue);
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * @param objectKey
	 *            Description Common action clear
	 */
	public void clearfield(String objectKey) {
		try {
			getElement(objectKey).clear();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @param objectKey
	 * @return string Description Common action gettext
	 */
	public String getText(String objectKey) {
		String str = "";
		return str = getElement(objectKey).getText();
	}

	public String getAttribute(String objectKey, String attributeName) {
		String str = "";
		return str = getElement(objectKey).getAttribute(attributeName);
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

	public void selectAccountType(String dataKey, String locatorKey) throws Exception, IOException, Exception {
		Select s = new Select(getElement(locatorKey));
		String myData = getValueFromJson(dataKey);
		myData = myData + " " + "| " + getKeyFromJson("UserID_Kontonummer");
		// System.out.println(myData);
		try {
			s.selectByVisibleText(myData);
		} catch (Exception e) {
			logAssert_Fail("Select by visble text failed on: " + locatorKey);
		}

	}

	/**
	 * Description Press escape key
	 */
	public void pressTab() {
		try {
			Actions act = new Actions(driver);
			act.sendKeys(Keys.TAB).build().perform();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
		if (data.equals("Intervall")) {
			Thread.sleep(3000);
			s.selectByIndex(2);
			System.out.println("dropdown condition success-MONATLICH selected");
		} else if (data.equals("Immer_am")) {
			System.out.println("dropdown condition success");
			Thread.sleep(3000);
			s.selectByIndex(9);
			System.out.println("dropdown condition success-10. des montas selected");
		} else {

			Thread.sleep(5000);
			s.selectByIndex(Integer.parseInt(data));
		}

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

		softAssertions.assertThat(true);

		// assertEquals(true, true);
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
		softAssertions.assertThat(false);
		takeSceenShot();

		// assertEquals(false, true);
	}

	/**
	 * Description Common function to take the screenshots of failure steps
	 */

	public void takeSceenShot() {
		if ((Configurations.takeScreenshots).equals("Y")) {
			Date d = new Date();
			try {
				String screenshotFile = d.toString().replace(":", "_").replace(" ", "_") + ".png";
				// take screenshot
				File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

				// get the dynamic folder name
				FileUtils.copyFile(srcFile, new File(ExtentManager.screenshotFolderPath + screenshotFile));
				String PathofScreenShot = System.getProperty("user.dir") + "\\" + ExtentManager.screenshotFolderPath
						+ screenshotFile;
				// put screenshot file in reports
				scenario.info("Screenshot", MediaEntityBuilder.createScreenCaptureFromPath(PathofScreenShot).build());
			} catch (IOException e) {
				e.printStackTrace();
				Assert.fail();
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
		softAssertions.assertAll();
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

	public String getValueFromJson(String dataKeyInJson) throws FileNotFoundException, IOException, ParseException {
		String datakey = null;
		try {
			datakey = getKeyFromJson(dataKeyInJson);
			datakey = checkGermanCharacters(datakey);
			// System.out.println(dataKeyInJson + ":" + datakey);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logAssert_Fail(dataKeyInJson + " :ObjectKey not present in json file");
		}
		return datakey;
	}

	public String getKeyFromJson(String dataKey) throws FileNotFoundException, IOException, ParseException {

		String data = null;
		JSONParser parser = new JSONParser();
		JSONObject getFeatureName = (JSONObject) parser
				.parse(new FileReader(".\\src\\test\\java\\com\\bnpp\\TestData\\" + featurename + ".json"));
		JSONObject featureName = (JSONObject) getFeatureName.get(featurename);
		Map<String, String> getScenarioName = (Map<String, String>) featureName.get(scenarioname);
		Iterator it = getScenarioName.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry pair = (Map.Entry) it.next();
			if (pair.getKey().toString().equals(dataKey)) {
				data = pair.getValue().toString();
				break;
			}
			// System.out.println(pair.getKey() + ":" +
			// pair.getValue().toString());
		}
		return data;

	}

	public String verifyErrorMessage(String messageKey) throws FileNotFoundException, IOException, ParseException {
		String data = null;
		try {
			JSONParser parser = new JSONParser();
			JSONObject getFeatureName = (JSONObject) parser
					.parse(new FileReader(".\\src\\test\\java\\com\\bnpp\\TestData\\" + featurename + ".json"));
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
				// System.out.println(pair.getKey() + ":" +
				// pair.getValue().toString());
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
				if (data.contains("oe"))
					data = data.replace("oe", "ö");
				if (data.contains("ue"))
					data = data.replace("ue", "ü");
				if (data.contains("Ae"))
					data = data.replace("Ae", "Ä");
				if (data.contains("Oe"))
					data = data.replace("Oe", "Ö");
				if (data.contains("Ue"))
					data = data.replace("Ue", "Ü");

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;

	}

	public void setfaturefilenameandsceanrio(String id, String name) {
		featurename = id;
		String[] d = featurename.split("/features/");
		// System.out.println(d[0] + " " + d[1]);
		String[] d2 = d[1].split(".feature");
		// System.out.println(d2[0]);
		featurename = d2[0];
		scenarioname = name;

	}

	public String getScenarioName() {
		return scenarioname;
	}

	// public void deleteExistingTemplates(String DeleteTemplates) throws
	// Exception {
	// List<WebElement> ele = driver.findElements(By.xpath(DeleteTemplates));
	// try {
	// if (isElementPresent(DeleteTemplates)) {
	// for (int i = 0; i < ele.size(); i++) {
	// click(DeleteTemplates);
	// enterTokenTan("Mobile_TAN_field_Bhavini", TANGenerator.requestTan());
	// click("Delete_confirmation");
	// System.out.println("Deleting element" + ele.get(0));
	// }
	// }
	// } catch (Exception e) {
	// // TODO Auto-generated catch block
	// System.out.println("All existing templates cleared");
	// }
	// }

	public void clearCheckBox(String objectKey) {
		WebElement e;

		try {
			e = driver.findElement(By.xpath(properties.getProperty(objectKey + "_checkbox")));// present
			System.out.println(e.isSelected());
			if (e.isSelected()) {
				Thread.sleep(1000);
				System.out.println("checkbox was selected");
				driver.findElement(By.xpath(properties.getProperty(objectKey))).click();
			} else {
				System.out.println("checkbox was unselected");
			}
		} catch (Exception ex) {

		}
	}

	public void formXpathofRelativeEditElementandClickonit(String PersonNametitle) {
		int index = 0;
		String a = "//tr/td[";
		// String counter="1";
		String b = "]/div/a[@title='";
		String d = "']";
		String c = PersonNametitle;
		// System.out.println((a+counter+b+c+d));
		for (int counter = 0; counter <= 20; counter++) {
			List<WebElement> lst = driver.findElements(By.xpath(a + counter + b + c + d));
			if (lst.size() != 0)
				index = counter;

		}
		String Xpath = "//tr[" + index + "]//div[1]/a[@title='Anzeigen und bearbeiten']";
		// WebElement Editelement=driver.findElement(By.xpath(EditXpath));
		driver.findElement(By.xpath(Xpath)).click();

	}

	public boolean compareTextWithJsonDataKeyValue(String ObjectKey, String jsonDataKey)
			throws FileNotFoundException, IOException, ParseException {
		if (getText(ObjectKey).equals(getValueFromJson(jsonDataKey)))
			return true;
		else
			return false;

	}

	public boolean compareAtrributeWithJson(String ObjectKey, String AttributeName, String jsonDataKey)
			throws FileNotFoundException, IOException, ParseException {
		if (getAttribute(ObjectKey, AttributeName).equals(getValueFromJson(jsonDataKey)))
			return true;
		else
			return false;
	}

	public void enterNewMobileTan(String tanKey, String token) throws InterruptedException, ClientProtocolException, IOException, ParserConfigurationException, SAXException {
		Properties prop = new Properties();
		// FileInputStream fis = new
		// FileInputStream("C:\\workspace\\mobileTANTest\\src\\main\\java\\mTANResources\\data.properties");
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\java\\com\\bnpp\\mTANResources\\data.properties");
		prop.load(fis);
		String customerId = prop.getProperty("userID");
		String customerPin = prop.getProperty("pin");
		String cafeUser = prop.getProperty("cafeUserID");
		String cafePin = prop.getProperty("cafePin");

		// Redirecting Mobile TAN
		MobileTan mt = new MobileTan();
		mt.mTanRedirection(customerId, customerPin, cafeUser, cafePin);

		// String MobileTAN_link_Login = "//a[@id='mobile-tan-request']";
		if(tanKey.equals("mobile_TAN_field")) {
			click("MobileTan_anfordern");
		}
		else {
			click("MobileTAN_link_Login");
		}	

		String mTAN = mt.getMTan(customerId, customerPin, cafeUser, cafePin);
		// System.out.println("mTAN is -" + mTAN);
		Thread.sleep(3000);
		enterTokenTan(tanKey, mTAN);
		if (tanKey.equals("TAN_field_Ueberweisungslimit")) {
			pressTab();
		}
		logInfoStatus("Info | Token used : " + token);

		// commonActions.enterTokenTan(TanKey, TANGenerator.requestTan());
	}
		
	}

