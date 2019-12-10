package com.bnpp.runner;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import com.bnpp.utilities.Configurations;
import com.bnpp.xray.Log;
import com.dab.config.PropertiesHandler;
import com.dab.xray.TestExecution;
import com.dab.xray.Xray;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)

@CucumberOptions(monochrome = true, features = "src/test/java/com/bnpp/features/", dryRun = false, glue = {
		"com/bnpp/steps/" }, tags = "@TA-120", plugin = { "json:target/cucumber.json" })
public class JunitRunner {

	final static String PATH_TO_CUCUMBER_REPORT = "target/cucumber.json";
	final static String PATH_REPORT_TEAMPLATE = "custom_templates/templates.json";
	public static String currentXrayIssueKey = "";
	public static boolean featureTestPassed = true;
	public static String ExecutionID = "";
	public static String testStart = "";
	public static String testPlanId = "";
	public static String folderNameReport = "";

	@BeforeClass
	public static void setupBeforeClass() {

		com.dab.config.PropertiesHandler.setConfigPath(Configurations.XrayConfigPath);
		setLogger();
		ExecutionID = TestExecution.getExecKey();

		testPlanId = com.dab.config.PropertiesHandler.getXrayTestPlanKey();

		TestExecution.addTestPlanToTestExecution(testPlanId, ExecutionID);

		ZonedDateTime startDateTime = ZonedDateTime.now();
		testStart = startDateTime.truncatedTo(ChronoUnit.SECONDS).format(DateTimeFormatter.ISO_OFFSET_DATE_TIME);
		Log.info("Test Start Time: " + testStart);

	}

	@AfterClass
	public static void teardown() throws Exception {

		generateReport();

		// *** activating and deacivating in config.properties
		Xray.attachFileToJiraIssue("Reports_" + folderNameReport, ExecutionID);

	}

	public static void setLogger() {

		System.setProperty("log-directory", PropertiesHandler.getLogsFolder());
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss");
		System.setProperty("currenttime", dateFormat.format(new Date()));
		Log.info("Log configuration done. Log Dir:" + PropertiesHandler.getLogsFolder());

	}

	public static void generateReport() throws Exception {

		TimeUnit.SECONDS.sleep(5);

		Date currentDate = new Date();
		folderNameReport = currentDate.toString().replace(":", "_").replace(" ", "_");

		String[] arg = { PATH_TO_CUCUMBER_REPORT, folderNameReport, PATH_REPORT_TEAMPLATE };
		com.consorsbank.test.core.report.Main.main(arg);

		removeReportsToReportFolder("Reports_" + folderNameReport, Configurations.REPORT_PATH_NEW);
		deleteOldReportFolders();

	}

	private static void removeReportsToReportFolder(String pathSource, String pathDestination) {

		File srcDir = new File("Reports_" + folderNameReport);
		String destination = pathDestination + "/" + "Reports_" + folderNameReport;
		File destDir = new File(destination);

		try {
			FileUtils.copyDirectory(srcDir, destDir);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private static void deleteOldReportFolders() {

		File directoryFF = new File(System.getProperty("user.dir"));
		for (File f : directoryFF.listFiles()) {
			if (f.getName().startsWith("Reports_") & !(f.getName().contains("Zip"))) {
				try {
					System.out.print("Deleting old Reports folders...");
					FileUtils.cleanDirectory(f);
					FileUtils.forceDelete(f); // delete directory
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} // clean out directory (this is optional -- but good know)

			}
		}

	}

}
