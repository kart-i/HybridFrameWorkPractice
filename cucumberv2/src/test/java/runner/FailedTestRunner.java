package runner;

import org.testng.annotations.DataProvider;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;



@CucumberOptions( 
				 features = "@target/failed_scenarios.txt",
				 glue = {"stepDefinitions","hooks"},
				 dryRun = false
		
		        )
public class FailedTestRunner extends AbstractTestNGCucumberTests {
	

}

