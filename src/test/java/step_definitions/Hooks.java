package step_definitions;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.ConfigurationReader;
import utilities.Driver;
import utilities.ExtentReport;
import utilities.Log;


public class Hooks {
    protected WebDriver driver;
    protected Actions action;
    protected WebDriverWait wait;
    protected static ExtentReports report;
    protected static ExtentHtmlReporter htmlReporter;
    protected static ExtentTest extentLogger;
    protected String url;

    @Before
    public void setUp(Scenario scenario){

        //anything that you want to run before each scenario
       // TempDataStorageUtils.clear();

        Log.start(scenario.getName());
        ExtentReport.startTest(scenario.getName());


        //initialize the class
        report = new ExtentReports();
        //create report path
        String projectPath = System.getProperty("user.dir");
        String path = projectPath + "/test-output/report.html";
        //initialize the html reporter with the report path
        htmlReporter = new ExtentHtmlReporter(path);
        //attach the html report to the report object
        report.attachReporter(htmlReporter);
        htmlReporter.config().setReportName("Vytrack smoke test");
        //set environment information
        report.setSystemInfo("Environment", "QA");
        report.setSystemInfo("Browser", ConfigurationReader.getProperty("browser"));
        report.setSystemInfo("OS", System.getProperty("os.name"));



    }



    @After
    public void tearDownScenario(Scenario scenario){

        System.out.println(scenario.getName());
        System.out.println(scenario.getStatus());

        if (scenario.isFailed() && Driver.getReference() != null) {
            byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot,"image/png",scenario.getName());
            ExtentReport.fail();
        } else {
            ExtentReport.pass();
        }
        //after
        report.flush();
        Driver.closeDriver();

    }
    
}
