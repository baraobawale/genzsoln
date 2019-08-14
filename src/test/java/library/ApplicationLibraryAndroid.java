package library;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import configurations.ConfigAndroid;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class ApplicationLibraryAndroid
{
	
	public AppiumDriver launchDriver() throws MalformedURLException
	{
		
		DesiredCapabilities capabilities = new DesiredCapabilities();
		
		
		capabilities.setCapability("platformName", ConfigAndroid.platformName);
		capabilities.setCapability("platformVersion",ConfigAndroid.platformVersion);
		capabilities.setCapability("deviceName", ConfigAndroid.deviceName);
		capabilities.setCapability("udid", ConfigAndroid.deviceName);
		capabilities.setCapability("app",ConfigAndroid.app);
		capabilities.setCapability("appPackage",ConfigAndroid.appPackage);
		capabilities.setCapability("appActivity",ConfigAndroid.appActivity);
		
		AppiumDriver dr = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
		
		return dr;
		
	}
	

}
