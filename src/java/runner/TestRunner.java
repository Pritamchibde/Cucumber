package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.Result;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runner.JUnitCore;
import org.junit.runner.notification.Failure;


@RunWith(Cucumber.class)
@Suite.SuiteClasses({WebBrowser.class})
@CucumberOptions(features = {"features"}
        , tags = {"@Ready"}
        , plugin = {"pretty", "html:target/cucumber"}
        , glue = {"steps", "runner"})

public class TestRunner {

    public static void main(String[] args) {

        System.out.println("Test Started");
        Result result = JUnitCore.runClasses(TestRunner.class);

        for (Failure failure : result.getFailures()) {
            System.out.println(failure.getMessage());
        }

        System.out.println(result.wasSuccessful());
    }
}
