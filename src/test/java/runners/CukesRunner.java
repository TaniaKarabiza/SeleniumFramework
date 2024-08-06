package runners;



import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import utilities.ExtentReport;

@RunWith(Cucumber.class)           //This line forces CukesRunner class to run with Cucumber
@CucumberOptions(
        plugin = {"html:target/cucumber-reports", "json:target/cucumber-reports.json","rerun:target/rerun.txt"},
        features = "src/test/resources/features",    //you DO NOT want to change this; it will look into features directory and it will be recognized by tags
        glue = "step_definitions",                  //you DO NOT want to change this; it will look into features directory and it will be recognized by tags
        //features and glue are MANDATORY to run the program
       dryRun = false,                 //when it is true, it does not open the browser, but checks the steps
        //when it is false, it does open the browser and checks the steps
       tags = "@expediaAirportSearch"            //by doing that, you are saying run this group of cases
        //you can pass more that 1 tag:  tags = "@smokeTest", "@Regression"
)




public class CukesRunner {



    @AfterClass
    public static void tearDown(){
        ExtentReport.endReport();
    }


}
