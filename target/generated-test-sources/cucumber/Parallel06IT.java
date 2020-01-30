import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        strict = true,
        features = {"C:/Users/Lenovo/Desktop/Genz/rta/rta/src/test/java/com/bnpp/features/UC_9_10_UeberweisungLimit.feature"},
        plugin = {"json:C:/Users/Lenovo/Desktop/Genz/rta/rta/target/cucumber-parallel/6.json"},
        monochrome = true,
        tags = {},
        glue = {"com/bnpp/steps/"})
public class Parallel06IT {
}
