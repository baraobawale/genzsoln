import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        strict = true,
        features = {"C:/Users/Lenovo/Desktop/Genz/rta/rta/src/test/java/com/bnpp/features/facebook.feature"},
        plugin = {"json:C:/Users/Lenovo/Desktop/Genz/rta/rta/target/cucumber-parallel/7.json"},
        monochrome = true,
        tags = {},
        glue = {"com/bnpp/steps/"})
public class Parallel07IT {
}
