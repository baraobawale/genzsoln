import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        strict = true,
        features = {"C:/Users/Lenovo/Desktop/Genz/rta/rta/src/test/java/com/bnpp/features/TC01.feature"},
        plugin = {"json:C:/Users/Lenovo/Desktop/Genz/rta/rta/target/cucumber-parallel/1.json"},
        monochrome = true,
        tags = {},
        glue = {"com/bnpp/steps/"})
public class Parallel01IT {
}
