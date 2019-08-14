import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        strict = true,
        features = {"C:/workspace/RTA/src/test/java/features/UC67_68_Stammdaten.feature:51"},
        plugin = {"json:C:/workspace/RTA/target/cucumber-parallel/2.json", "html:C:/workspace/RTA/target/cucumber-parallel/2"},
        monochrome = true,
        glue = {"stepDefinition"})
public class Parallel02IT extends AbstractTestNGCucumberTests {
}
