import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import core.WebAutomation;
import org.junit.jupiter.api.*;
import org.testng.Assert;
import utilities.DataSheet;
import screens.HomePage;
import  screens.IslamicPremiumBankingPage;

import utilities.TestReport;

class IslamicPremiumBankingApplicationTest {

    WebAutomation webAutomation;
    TestReport testReport;
    DataSheet data;


    static ExtentHtmlReporter htmlReporter;
    static ExtentReports report;
    static ExtentTest testCase;

    @BeforeEach
    void setUp() {
        htmlReporter = new ExtentHtmlReporter("./report/extent.html");
        report = new ExtentReports();
        report.attachReporter(htmlReporter);

        webAutomation = new WebAutomation();
        webAutomation.OpenBrowser(WebAutomation.Browser.Chrome);


        data = new DataSheet("C:/TestData/TestData.xls");
        data.SetTestData();
    }

    @BeforeAll
    static void setUpOnce(){
//        htmlReporter = new ExtentHtmlReporter("./report/extent.html");
//        report = new ExtentReports();
//        report.attachReporter(htmlReporter);
        //CreateReport();

    }

    @BeforeEach
    void tearDownAfterll(){
        //report.flush();
        //CloseReport();
    }

    @AfterEach
    void tearDown() {
        report.flush();
        webAutomation.CloseBrowser();
    }

    @Test
    public void IslamicPremiumBankingApplicationWithIncorrectId(){


        webAutomation.NavigateToUrl("https://www.absa.co.za/personal/");

        HomePage homePage = new HomePage(webAutomation.driver);
        homePage.ClosePopUP();
        homePage.ValidateIsHomeScreen();
        homePage.SearchFor("Online Banking");
        homePage.SelectCheckBox("product");
        homePage.ClickLinkByText(webAutomation.driver,"Islamic Premium Banking");

        IslamicPremiumBankingPage islamicPremiumBankingPage = new IslamicPremiumBankingPage(webAutomation.driver, testCase);

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
        islamicPremiumBankingPage.ClickLetsContinue();

        Assert.assertTrue(islamicPremiumBankingPage.IdNumberInvaliTextExists());
    }
}