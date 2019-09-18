package com.bnpp.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(monochrome = true,features = "src/test/java/com/bnpp/features/", glue={"com/bnpp/steps/"},tags="@567Create")

public class JunitRunner {

}
