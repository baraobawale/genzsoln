package com.bnpp.runner;

import java.io.IOException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.bnpp.library.CommonActions;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)

@CucumberOptions(monochrome = true, features = "src/test/java/com/bnpp/features/", dryRun = false, glue = {
		"com/bnpp/steps/" }, tags = "@Jith", plugin = { "json:target/cucumber.json" })

public class JunitRunner {

	@AfterClass
	public static void teardown() throws InterruptedException, IOException {

		Date d = new Date();
		String fileName = d.toString().replace(":", "_");
		fileName = fileName.replace(" ", "_");

		TimeUnit.SECONDS.sleep(5);
		//CommonActions ca = new CommonActions();
		
		String os = System.getProperty("os.name").toLowerCase();
		if (os.indexOf("win") >= 0) {
			Runtime.getRuntime()
			.exec("sh ./module-report/module-report/module-report/bin/module-report \"target/cucumber.json\" \""
					+ fileName
					+ "\" \"./module-report/module-report/module-report/custom_templates/templates.json\"");
			TimeUnit.SECONDS.sleep(8);
			// Runtime.getRuntime().exec("cp -r ./Reports_RTA/ ./Reports");
			Process p = Runtime.getRuntime().exec("cp -r ./Reports_" + fileName + "/ ./Reports");
			TimeUnit.SECONDS.sleep(3);
			Runtime.getRuntime().exec("rm -r ./Reports_" + fileName);
			TimeUnit.SECONDS.sleep(5);
		}else if (os.indexOf("nix") >= 0 || os.indexOf("nux") >= 0 || os.indexOf("aix") > 0 )
		{
			Runtime.getRuntime()
			.exec("./module-report/module-report/module-report/bin/module-report \"target/cucumber.json\" \""
					+ fileName
					+ "\" \"./module-report/module-report/module-report/custom_templates/templates.json\"");
			TimeUnit.SECONDS.sleep(5);
			// Runtime.getRuntime().exec("cp -r ./Reports_RTA/ ./Reports");
			Process p = Runtime.getRuntime().exec("cp -r ./Reports_" + fileName + "/ ./Reports");
			TimeUnit.SECONDS.sleep(5);
	
		}
		
		//ca.generateReport(fileName);
		/**	
		Runtime.getRuntime()
				.exec("sh ./module-report/module-report/module-report/bin/module-report \"target/cucumber.json\" \""
						+ fileName
						+ "\" \"./module-report/module-report/module-report/custom_templates/templates.json\"");
		TimeUnit.SECONDS.sleep(5);
		// Runtime.getRuntime().exec("cp -r ./Reports_RTA/ ./Reports");
		Process p = Runtime.getRuntime().exec("cp -r ./Reports_" + fileName + "/ ./Reports");
		TimeUnit.SECONDS.sleep(5);
		 **/
		
		// *** activating and deacivating in config.properties
		// Xray.attachFileToJiraIssue(Configurations.reportPath,
		// com.dab.config.PropertiesHandler.getXrayTestExecutionKey());

	}
}
