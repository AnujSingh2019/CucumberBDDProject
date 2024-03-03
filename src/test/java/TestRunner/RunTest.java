package TestRunner;

//import org.junit.runner.RunWith;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


//import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;


//@RunWith(Cucumber.class)
@CucumberOptions(
		features = "./src/test/resources/Features/Customer.feature",
		//features = {".//Features/Customer.feature",".//Features/Login.feature"},
		glue = {"Stepdefinition"},
		dryRun=false,
		monochrome=true,
		tags="@Sanity",
		plugin= {"pretty","html:target/HTMLReports/report.htm"}
	
		
		)



public class RunTest extends AbstractTestNGCucumberTests {
	
	

}
