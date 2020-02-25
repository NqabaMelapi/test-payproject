import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
//import freemarker.template.Configuration;
//import freemarker.template.Template;
//import freemarker.template.TemplateException;
//import freemarker.template.Version;
import main.java.core.WebAutomation;
import org.junit.jupiter.api.*;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
import main.java.utilities.DataSheet;
import main.java.screens.HomePage;
import  main.java.screens.IslamicPremiumBankingPage;

import utilities.TestReport;


//import java.lang.invoke.SwitchPoint;
//
//
//import static org.junit.jupiter.api.Assertions.*;
//import static utilities.TestReport.*;

class IslamicPremiumBankingApplicationTest {

    WebAutomation webAutomation;
    TestReport testReport;
    DataSheet data;

    static ExtentHtmlReporter htmlReporter;
    static ExtentReports report;
    static ExtentTest testCase;

    @BeforeEach
    void setUp() {

        webAutomation = new WebAutomation();
        webAutomation.OpenBrowser(WebAutomation.Browser.Chrome);

        data = new DataSheet("C:/TestData/TestData.xls");
        data.SetTestData();
    }

    @BeforeAll
    static void setUpOnce(){
        htmlReporter = new ExtentHtmlReporter("../../extent.html");
        report = new ExtentReports();
        report.attachReporter(htmlReporter);
        //CreateReport();
    }

    @AfterAll
    static void tearDownAfterll(){
        report.flush();
        //CloseReport();
    }

    @AfterEach
    void tearDown() {
        webAutomation.CloseBrowser();
    }

    @Test
    public void IslamicPremiumBankingApplicationWithIncorrectId(){

        testCase = report.createTest("IslamicPremiumBankingApplicationWithIncorrectId");
        //CreateTestCase("IslamicPremiumBankingApplicationWithIncorrectId");

        webAutomation.NavigateToUrl("https://www.absa.co.za/personal/");

        HomePage homePage = new HomePage(webAutomation.driver);

        homePage.ClosePopUP();
        homePage.ValidateIsHomeScreen();
        homePage.SearchFor("Online Banking");
        homePage.SelectCheckBox("product");
        homePage.ClickLinkByText(webAutomation.driver,"Islamic Premium Banking");

        IslamicPremiumBankingPage islamicPremiumBankingPage = new IslamicPremiumBankingPage(webAutomation.driver);
        islamicPremiumBankingPage.ClickApplyNow();
        islamicPremiumBankingPage.SwitchToIslamicPremiumBankingApplicationTab();
        islamicPremiumBankingPage.SelectNewCustomer();
        islamicPremiumBankingPage.ClickLetsContinue();
        islamicPremiumBankingPage.GetToolTipInfo();
        islamicPremiumBankingPage.ClickLetsContinue();
        islamicPremiumBankingPage.ClickNoNotInsolvent();
        islamicPremiumBankingPage.ClickNoNeverBeenInsolvent();
        islamicPremiumBankingPage.ClickLetsContinue();
        islamicPremiumBankingPage.GiveConsent();
        islamicPremiumBankingPage.ClickLetsContinue();
        islamicPremiumBankingPage.ClickLetsContinueIfRewardsAreMoreThan(22.20);
        islamicPremiumBankingPage.EnterPersonalDetails(data.testData);


    }
}