package runner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;



@CucumberOptions( features = "./src/test/resources/features/VerifyDownload.feature",
				  glue = {"stepDefinitions","hooks"},
				  dryRun = false,
				  monochrome = true,
				  plugin = {"rerun:target/failed_scenarios.txt",
						    "pretty","html:target/reports.html"
						   }
						  				
                )

public class Runner extends AbstractTestNGCucumberTests {
	    
		
}

/*@Override
@DataProvider(parallel = true)  // Enables parallel execution at Scenario level
public Object[][] scenarios() {
    return super.scenarios();
}*/