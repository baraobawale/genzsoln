import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        strict = true,
        features = {"C:/Users/cs99169/Desktop/test_automation_12.11/rta/src/test/java/com/bnpp/features/UC62_63_CFDHandel.feature"},
        plugin = {"json:C:/Users/cs99169/Desktop/test_automation_12.11/rta/target/cucumber-parallel/17.json"},
        monochrome = true,
        tags = {},
        glue = {"com/bnpp/steps/"})
public class Parallel17IT {
}
