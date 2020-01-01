package testRunner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions( 
		features = "E:\\Jiten newPractice\\com.demomavenpractice\\FeatureFiles\\Login.feature",
        glue ={"stepDefinitions"} 
		)

public class TestRunner {
	
	

}
