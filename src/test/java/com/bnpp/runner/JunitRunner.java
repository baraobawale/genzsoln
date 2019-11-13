package com.bnpp.runner;

import org.junit.runner.RunWith;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)

@CucumberOptions(monochrome = true,features = "src/test/java/com/bnpp/features/", dryRun=false,glue={"com/bnpp/steps/"},tags="@UC67",
plugin= {
		"json:target/cucumber.json"
		})
public class JunitRunner {

}
