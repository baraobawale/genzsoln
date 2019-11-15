package com.bnpp.runner;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import com.bnpp.utilities.Configurations;
import com.bnpp.utilities.Log;
import com.dab.config.PropertiesHandler;
import com.dab.xray.Xray;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)

@CucumberOptions(monochrome = true, features = "src/test/java/com/bnpp/features/", dryRun = false, glue = {
		"com/bnpp/steps/" }, tags = "@TA-120", plugin = { "json:target/cucumber.json" })
public class JunitRunner {

	@BeforeClass
	public static void setupBeforeClass() {
		setLogger();

		com.dab.config.PropertiesHandler.setConfigPath(Configurations.XrayConfigPath);

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
		Xray.attachFileToJiraIssue(Configurations.reportPath,
				com.dab.config.PropertiesHandler.getXrayTestExecutionKey());

	}

	public static void setLogger() {

		System.setProperty("log-directory", PropertiesHandler.getLogsFolder());
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss");
		System.setProperty("currenttime", dateFormat.format(new Date()));
		Log.info("Log configuration done. Log Dir:" + PropertiesHandler.getLogsFolder());

	}

}
