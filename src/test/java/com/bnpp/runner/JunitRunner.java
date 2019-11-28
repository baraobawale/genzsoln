package com.bnpp.runner;

import java.text.SimpleDateFormat;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import com.bnpp.utilities.Configurations;
import com.bnpp.xray.Log;
import com.bnpp.xray.XrayHelper;
import com.dab.config.PropertiesHandler;
import com.dab.xray.TestExecution;
import com.dab.xray.Xray;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)

@CucumberOptions(monochrome = true, features = "src/test/java/com/bnpp/features/", dryRun = false, glue = {
		"com/bnpp/steps/" }, tags = "@TA-120", plugin = { "json:target/cucumber.json" })
public class JunitRunner {

	public static String currentXrayIssueKey = "";
	public static boolean featureTestPassed = true;
	public static String ExecutionID = "";
	public static String testStart = "";

	@BeforeClass
	public static void setupBeforeClass() {
		
		com.dab.config.PropertiesHandler.setConfigPath(Configurations.XrayConfigPath);
		setLogger();
		ExecutionID = TestExecution.getExecKey(); 
		

		ZonedDateTime startDateTime = ZonedDateTime.now();
		testStart = startDateTime.truncatedTo(ChronoUnit.SECONDS).format(DateTimeFormatter.ISO_OFFSET_DATE_TIME);
		Log.info("Test Start Time: " + testStart);

		// exporting report should not be added at before tag, first FFs
		// will be exported from JIRA to our system with the help of different command
		// in same framework and
		// then tests can be executed.
		// com.dab.qa.ExportTests.export();

	}

	@AfterClass
	public static void teardown() throws InterruptedException {

		TimeUnit.SECONDS.sleep(5);

		// *** activating and deacivating in config.properties
		Xray.attachFileToJiraIssue(Configurations.reportPath, ExecutionID);

	}

	public static void setLogger() {

		System.setProperty("log-directory", PropertiesHandler.getLogsFolder());
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss");
		System.setProperty("currenttime", dateFormat.format(new Date()));
		Log.info("Log configuration done. Log Dir:" + PropertiesHandler.getLogsFolder());

	}

}
