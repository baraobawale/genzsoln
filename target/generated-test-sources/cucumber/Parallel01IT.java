import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        strict = true,
        features = {"C:/workspace/RTA/src/test/java/features/UC67_68_Stammdaten.feature:28"},
        plugin = {"json:C:/workspace/RTA/target/cucumber-parallel/1.json", "html:C:/workspace/RTA/target/cucumber-parallel/1"},
        monochrome = true,
        glue = {"stepDefinition"})
public class Parallel01IT extends AbstractTestNGCucumberTests {
}
