package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features/",glue="apiStepDef",dryRun = false,
        tags = "@updateEMP",
        monochrome = true, plugin = {"pretty"})


public class APIRunner {
}
