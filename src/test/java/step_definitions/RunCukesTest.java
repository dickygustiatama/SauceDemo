package step_definitions;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        tags = {"@CheckOut"},//identitas cucumber class
        features = {"classpath:features/"},//package class cucumber
        glue = { "classpath:step_definitions"},//menjalankan method final
        plugin= {"pretty","html:target/site/cucumber-pretty","json:target/cucumber/cucumber.json"}
)

public class RunCukesTest {

}
