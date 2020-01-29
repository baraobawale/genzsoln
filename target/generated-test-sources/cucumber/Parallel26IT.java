import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        strict = true,
        features = {"C:/Users/cs99169/Desktop/test_automation_12.11/rta/src/test/java/com/bnpp/features/rt_115___bdd_test_neukundendepot_feature.feature"},
        plugin = {"json:C:/Users/cs99169/Desktop/test_automation_12.11/rta/target/cucumber-parallel/26.json"},
        monochrome = true,
        tags = {},
        glue = {"com/bnpp/steps/"})
public class Parallel26IT {
}
