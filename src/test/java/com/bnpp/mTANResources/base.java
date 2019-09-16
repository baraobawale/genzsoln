package com.bnpp.mTANResources;
/*
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
*/
public class base {
	
	//public static WebDriver driver;
/*	public String sBasePath =  System.getProperty("user.dir");
	private void sysout() {
		// TODO Auto-generated method stub

	}
	//public static final String testDataExcelFileName = "Test_Data_Tagesgeld Direkt_Einzelkonto.xlsx";
*//*
	public WebDriver initializeDriver() throws IOException
	{
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(sBasePath + "\\src\\main\\java\\mTANResources\\data.properties");
		prop.load(fis);
			
		String browserName = prop.getProperty("browser");
		
		if (browserName.equals("chrome"))  {
			System.setProperty("webdriver.chrome.driver", sBasePath+"\\src\\main\\java\\mTANResources\\chromedriver.exe");
			driver = new ChromeDriver();
			
		}else if (browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", sBasePath+"\\src\\main\\java\\mTANResources\\geckodriver.exe");
			FirefoxOptions options = new FirefoxOptions();
			options.setCapability("marionette", false);
			driver = new FirefoxDriver(options);
			//driver = new FirefoxDriver();
			
		}else if (browserName.equals("IE")) {
			System.setProperty("webdriver.ie.driver", sBasePath+"\\src\\main\\java\\mTANResources\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();		
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
	
	public void closeBrowsers()
	{
		driver.close();
	}
	
	public void getScreenshot(String result) throws IOException
	{
		File src =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File(sBasePath+"\\src\\main\\java\\mTANResources\\"+result+"screenshot.png"));
	}
	*/
	
	
}

