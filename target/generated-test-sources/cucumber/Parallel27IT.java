import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        strict = true,
        features = {"C:/Users/cs99169/Desktop/test_automation_12.11/rta/src/test/java/com/bnpp/features/rt_117___bdd_test_neukundentagesgeld1_feature.feature"},
        plugin = {"json:C:/Users/cs99169/Desktop/test_automation_12.11/rta/target/cucumber-parallel/27.json"},
        monochrome = true,
        tags = {},
        glue = {"com/bnpp/steps/"})
public class Parallel27IT {
}
