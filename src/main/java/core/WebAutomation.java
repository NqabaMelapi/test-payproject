package main.java.core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class WebAutomation {

    public WebDriver driver;

    public enum  Browser{
        Chrome,
        FireFox,
        Safari,
        IE
    }

    public void OpenBrowser(Browser browser){
        switch (browser.toString()){
            case "Chrome":
                System.setProperty("webdriver.chrome.driver","C:\\WebDriver\\Chrome\\ChromeDriver 80.0.3987.106\\chromedriver.exe");
                driver = new ChromeDriver();
                break;
            case "FireFox":
                System.setProperty("webdriver.gecko.driver","C:\\WebDriver\\FireFox\\geckodriver-v0.26.0-win64\\geckodriver.exe");
                driver  = new FirefoxDriver();
                break;
//            default:
//                System.getProperty("","");
//                break;
        }

        driver.manage().timeouts().pageLoadTimeout(120,TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
    }

    public void NavigateToUrl(String url){
        driver.navigate().to(url);
    }

    public void CloseBrowser(){
        driver.close();
    }

    protected void WaitToBeClickable(WebDriver driver ,WebElement webElement){
        WebDriverWait wait = new WebDriverWait(driver, 120);
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    protected void WaitToBeDisplayed(WebDriver driver ,WebElement webElement){
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }

    protected void Click(WebElement webElement){
//        Wait(webElement);
        webElement.click();
    }

    protected void ClickLinkByText(WebDriver driver ,String text){
//        Wait(driver.findElement(By.linkText(text)));
        WaitToBeClickable(driver, driver.findElement(By.linkText(text)));
        driver.findElement(By.linkText(text)).click();
    }

    protected void EnterText(WebElement webElement, String value){
//        Wait(webElement);
        webElement.sendKeys(value);
    }

    protected void SelectByValue(WebElement webElement, String value){
        Select dropDown = new Select(webElement);
        dropDown.selectByValue(value);
    }

    protected void SelectByIndex(WebElement webElement, int index){
        Select dropDown = new Select(webElement);
        dropDown.selectByIndex(index);
    }

    protected boolean ValidateExists( WebDriver driver,WebElement webElement){
        //Wait(webElement);
        WaitToBeClickable(driver, webElement);
        return webElement.isDisplayed();
    }

    protected void SwitchToNextTab(WebDriver driver){
//        driver.SwitchTo().Window(driver.WindowHandles.Last());
//        driver.switchTo().window(driver.getWindowHandle().
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
    }

}