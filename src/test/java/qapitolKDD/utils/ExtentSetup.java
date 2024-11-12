package qapitolKDD.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentSetup {
    public static ExtentReports setupExtentReport(){
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");
        Date date = new Date();
        String actualDate = format.format(date);

        String reportPath = System.getProperty("user.dir")+ "/target/ExecutionReport_"+actualDate+".html";
        ExtentSparkReporter spark = new ExtentSparkReporter(reportPath);

        ExtentReports extent = new ExtentReports();
        extent.attachReporter(spark);

        spark.config().setDocumentTitle("My Automation Report");
        spark.config().setTheme(Theme.DARK);
        spark.config().setReportName("Test Case Execution");

        return extent;
    }
}
