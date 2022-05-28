import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources"},
        glue = {"StepDefinition"},
        tags = "@ddt or @smoke",
        // "and" -> TC with both tags
        // "or" -> TC with one or other tag
        // "not" -> TC with one tag but not other
        // Documentation: https://cucumber.io/docs/cucumber/api/#tags
        plugin = {"pretty", "html:reports/default.html"}

        /*
          If you want to supply tags form the command line
          comment tags line in the testRunner file, and use below command:
              mvn clean test -Dcucumber.options="--tags @tag1,@tag2"
       */
)

public class TestRunner {
}
