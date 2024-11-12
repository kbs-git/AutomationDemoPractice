package qapitolKDD.testCase;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import qapitolKDD.keyEngines.KeyEngine;

import java.io.IOException;


public class LoginTest {
    KeyEngine keyEngine;
    static ExtentTest test;
    static ExtentReports report;


    @BeforeTest
    public void signUp(){
        keyEngine=new KeyEngine();
        report= new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter("target/Spark.html");
        report.attachReporter(spark);
    }

    @Test
    public void loginTesting() throws IOException, InterruptedException {
        report.createTest("MyFirstTest")
                .log(Status.PASS, "This is a logging event for MyFirstTest, and it passed!");
       // String fileLocation=System.getProperty("user.dir")+"//src//main//resources//Files//Book.xlsx";
        String fileLocation="C:\\Users\\Qapitol QA\\Desktop\\KDD\\Book.xlsx";
        keyEngine.service(fileLocation);

    }

    @AfterTest
    public void afterTest(){
        report.flush();
        keyEngine.tearDown();
    }
}
