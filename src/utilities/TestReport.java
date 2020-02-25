package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

/**
 * Generates extent.html report on root
 * Note: I could'nt get this to work.
 */
public class TestReport {
    public static ExtentHtmlReporter htmlReporter;
    public static ExtentReports report = new ExtentReports();
    public static ExtentTest testCase;


    public void InitReport(){
        htmlReporter = new ExtentHtmlReporter("extent.html");
        report = new ExtentReports();
        report.attachReporter(htmlReporter);
    }

    public static void CreateTestCase(String testCaseName){
        testCase = report.createTest(testCaseName);
    }

//    public static void CreateReport(){
//        report.attachReporter(htmlReporter);
//    }

    public static void CloseReport(){
        report.flush();
    }
}
