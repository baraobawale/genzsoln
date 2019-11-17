package com.bnpp.runner;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.bnpp.utilities.Configurations;
import com.bnpp.utilities.Log;
import com.dab.xray.Xray;

import cucumber.api.CucumberOptions;
import cucumber.api.Scenario;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)

//@CucumberOptions(monochrome = true,features = "src/test/java/com/bnpp/features_demo/", dryRun= true,glue={"com/bnpp/steps/"},
@CucumberOptions(monochrome = true,features = "src/test/java/com/bnpp/features_demo/", dryRun= false,glue={"com/bnpp/steps/"},
plugin= {
		"json:target/cucumber.json"
		})
public class JunitRunner {
	
	@BeforeClass
	public static void setUp() {
		
		setLogger();


		com.dab.config.PropertiesHandler.setConfigPath("C:\\Bitbucket\\rta\\src\\test\\java\\com\\bnpp\\utilities\\config.properties");
	}

	@AfterClass
	public static void teardown() throws InterruptedException, IOException {

		

		TimeUnit.SECONDS.sleep(5);
		//Runtime.getRuntime().exec("sh ./module-report \"../../../../target/cucumber.json\" \"RTA\" \"../custom_templates/templates.json\" ");
		// *** activating and deacivating in config.properties
		Xray.attachFileToJiraIssue(Configurations.reportPath,
				com.dab.config.PropertiesHandler.getXrayTestExecutionKey());

	}
	
	public static void setLogger() {

		System.setProperty("log-directory", Configurations.loggerPath);
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss");
		System.setProperty("currenttime", dateFormat.format(new Date()));
		Log.info("Log configuration done. Log Dir:" + Configurations.loggerPath);

	}

}
