package differentAccount;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(plugin= {"pretty"}, 
tags= {"@account"}
/*features= {"src/test/resources"}*/)
public class TestRunCukes {

}
