package configurations;

import org.openqa.selenium.WebDriver;

public class ConfigWeb {
	public final static String chromeDriverPath= System.getProperty("user.dir") + "\\Resources\\chromedriver.exe" ;
	public final static String url="https://int-acc-ewev.consorsbank.de/home";
	public static  WebDriver dr;
	public final static String testDataResourcePath = System.getProperty("user.dir") + "\\Rersources";
	public static final String USERNAME = "ganesh472";
	public static final String AUTOMATE_KEY = "PfvhgPrJGpSuEX4yuoKY";
	public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
	public static boolean cloud = false ;

}
