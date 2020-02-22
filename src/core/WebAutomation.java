package core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

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

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    public void NavigateToUrl(String url){
        driver.navigate().to(url);
    }

    public void CloseBrowser(){
        driver.close();
    }

    public void Wait(WebElement webElement){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    public void Click(WebElement webElement){
        Wait(webElement);
        webElement.click();
    }

    public void EnterText(WebElement webElement, String value){
        Wait(webElement);
        webElement.sendKeys(value);
    }

    public void SelectByValue(WebElement webElement, String value){
        Select dropDown = new Select(webElement);
        dropDown.selectByValue(value);
    }

    public void SelectByIndex(WebElement webElement, int index){
        Select dropDown = new Select(webElement);
        dropDown.selectByIndex(index);
    }

    public boolean ValidateExists(WebElement webElement){
        Wait(webElement);
        return webElement.isDisplayed();
    }

}