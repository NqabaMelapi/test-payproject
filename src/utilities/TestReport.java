package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class TestReport {
    static ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extent.html");
    static ExtentReports report = new ExtentReports();
    static ExtentTest testCase;

    public static void CreateReport(){
        report.attachReporter(htmlReporter);
    }

    public static void CreateTestCase(String testCaseName){
        testCase = report.createTest(testCaseName);
    }

    public static void CloseReport(){
        report.flush();
    }
}
