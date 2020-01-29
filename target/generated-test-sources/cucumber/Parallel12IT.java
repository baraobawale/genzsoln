import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        strict = true,
        features = {"C:/Users/cs99169/Desktop/test_automation_12.11/rta/src/test/java/com/bnpp/features/UC49_50_53_54_GVKontoKind.feature"},
        plugin = {"json:C:/Users/cs99169/Desktop/test_automation_12.11/rta/target/cucumber-parallel/12.json"},
        monochrome = true,
        tags = {},
        glue = {"com/bnpp/steps/"})
public class Parallel12IT {
}
