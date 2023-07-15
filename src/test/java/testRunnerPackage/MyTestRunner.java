package testRunnerPackage;

import org.junit.runner.RunWith;
import org.testng.annotations.Test;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@Test
//@RunWith(SpringJUnit4ClassRunner.class)
@CucumberOptions(
		features = {"src/test/resources/featureFilesPackage"}, 
		
		glue = {"stepDefinitionsPackage", 
				"appsHooksPackage"},
		
		//tags = "@MyAccount_Feature",
		
		plugin = {"pretty","json:target/MyReports/report.json", 
				"junit:target/MyReports/report.xml", 
				"html:target/MyReports/report.html", 
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
		
		dryRun = false//, // to check whether all scenarios have step definitions or not
		//publish = true // to generate web report
        )	

public class MyTestRunner extends AbstractTestNGCucumberTests{

}
