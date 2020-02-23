import core.WebAutomation;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utilities.DataSheet;
import screens.HomePage;
import  screens.IslamicPremiumBankingPage;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.lang.invoke.SwitchPoint;

import static org.junit.jupiter.api.Assertions.*;

class IslamicPremiumBankingApplicationTest {

    WebAutomation webAutomation;
    DataSheet data;

    @BeforeEach
    void setUp() {
        webAutomation = new WebAutomation();
        webAutomation.OpenBrowser(WebAutomation.Browser.Chrome);


        data = new DataSheet("C:/TestData/TestData.xls");
        data.SetTestData();
    }

    @AfterEach
    void tearDown() {
        webAutomation.CloseBrowser();
    }

    @Test
    public void IslamicPremiumBankingApplicationWithIncorrectId(){

        webAutomation.NavigateToUrl("https://www.absa.co.za/personal/");

        HomePage homePage = new HomePage(webAutomation.driver);
        //WebElement webElement = webAutomation.driver.findElement(By.xpath("//*[@id=\"footer\"]/div/div/div/div[1]/div/div/div[5]/div/div/div[1]/div[3]"));
        //webElement.click();
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