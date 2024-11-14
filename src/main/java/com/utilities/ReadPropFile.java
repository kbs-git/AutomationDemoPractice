package com.utilities;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

public class ReadPropFile {
    private static Properties prop;
    private final static String propertFilePath = "C:\\Users\\Qapitol QA\\IdeaProjects\\bck\\DemoAutomation\\src\\main\\resources\\config\\data.properties";

    private static void loadData() throws IOException, FileNotFoundException {
        prop = new Properties();
        //System.getProperty("user.dir")+"propertFilePath";
      //  File f=new File(System.setpropert(user.dir)+"propertFilePath");
        File f = new File(propertFilePath);

        FileReader obj = new FileReader(f);
        prop.load(obj);
    }

    public static String getObject(String data) throws IOException {
        loadData();
        return prop.getProperty(data);
    }

    public static class ExtentSetup {

        private static ExtentReports extent;
        private static ThreadLocal<ExtentTest> test = new ThreadLocal<>(); // ThreadLocal to support parallel execution

        // Initialize ExtentReports
        public static ExtentReports setupExtentReport() {
            SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");
            Date date = new Date();
            String actualDate = format.format(date);

            // Define the report path
            String reportPath = System.getProperty("user.dir") + "/target/ExecutionReport_" + actualDate + ".html";
            ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportPath);

            extent = new ExtentReports();
            extent.attachReporter(sparkReporter);
            if (extent != null) {
                System.out.println("ExtentReports is initialized.");
            }

            // Configure the report
            sparkReporter.config().setDocumentTitle("Automation Test Report");
            sparkReporter.config().setTheme(Theme.DARK);
            sparkReporter.config().setReportName("Test Case Execution");

            return extent;
        }

        // Start a new test
        public static void startTest(String testName, String description) {
            ExtentTest extentTest = extent.createTest(testName, description);
            test.set(extentTest);
        }

        // Create a new node under the current test
        public static ExtentTest createNode(String nodeName, String description) {
            ExtentTest subTest = test.get().createNode(nodeName, description);
            return subTest;
        }

        // Log a pass message
        public static void logPass(String message) {
            if (test.get() != null) {
                test.get().pass(message);
            } else {
                System.out.println("Test not initialized for logPass");
            }
        }

        // Log a fail message
        public static void logFail(String message) {
            if (test.get() != null) {
                test.get().fail(message);
            } else {
                System.out.println("Test not initialized for logFail");
            }
        }

        // Log an info message
        public static void logInfo(String message) {
            if (test.get() != null) {
                test.get().info(message);
            } else {
                System.out.println("Test not initialized for logInfo");
            }
        }

        // End the current test
        public static void endTest() {
            if (test.get() != null) {
                System.out.println("Ending test: " + test.get().getModel().getName());  // Debugging line
                extent.removeTest(test.get());
            }
        }

        // Flush the report (write data to disk)
        public static void flushReport() {
            if (extent != null) {
                extent.flush();
            } else {
                System.out.println("ExtentReports not initialized for flushReport");
            }
        }

        // Close the report
        public static void closeReport() {
            if (extent != null) {
                extent.flush();  // Ensure the final report is written to disk
            } else {
                System.out.println("ExtentReports not initialized for closeReport");
            }
        }

        // Add a screenshot to the report
        public static void addScreenshot(String screenshotPath) {
            try {
                if (test.get() != null) {
                    test.get().addScreenCaptureFromPath(screenshotPath);
                } else {
                    System.out.println("Test not initialized for addScreenshot");
                }
            } catch (Exception e) {
                logFail("Failed to add screenshot: " + e.getMessage());
            }
        }
    }
}
