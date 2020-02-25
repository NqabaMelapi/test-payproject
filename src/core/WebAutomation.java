package core;

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

/**Automation core class, this class contains
 * methods with steps to perform actions on a wen page e.g.
 *
 */
public class WebAutomation {

    public WebDriver driver;

    public enum  Browser{
        Chrome
    }

    /**
     * Opens a given browser, sets waits for Page loading and element finding time.
     * @param browser
     */
    public void OpenBrowser(Browser browser){
        switch (browser.toString()){
            case "Chrome":
                System.setProperty("webdriver.chrome.driver","C:\\Dependencies\\ChromeDriver 80.0.3987.106\\chromedriver.exe");
                driver = new ChromeDriver();
                break;
        }

        driver.manage().timeouts().pageLoadTimeout(120,TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
    }

    /**
     * Navigate to a given web page
     * @param url
     */
    public void NavigateToUrl(String url){
        driver.navigate().to(url);
    }

    /**
     * Close web browser or tab
     */
    public void CloseBrowser(){
        driver.close();
    }

    /**
     * Waits for web element to be clickable
     * @param driver
     * @param webElement
     */
    public void WaitToBeClickable(WebDriver driver ,WebElement webElement){
        WebDriverWait wait = new WebDriverWait(driver, 120);
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    /**
     * Clicks on given web element
     * @param webElement
     */
    public void Click(WebElement webElement){
//        Wait(webElement);
        webElement.click();
    }

    /**
     * Click on a link with text @param : text
     * @param driver
     * @param text
     */
    public void ClickLinkByText(WebDriver driver ,String text){
//        Wait(driver.findElement(By.linkText(text)));
        WaitToBeClickable(driver, driver.findElement(By.linkText(text)));
        driver.findElement(By.linkText(text)).click();
    }

    /**
     * Enters text to a web field e.g. textbox
     * @param webElement
     * @param value
     */
    public void EnterText(WebElement webElement, String value){
//        Wait(webElement);
        webElement.sendKeys(value);
    }

    /**
     * Selects value from a dropdown using value.
      * @param webElement
     * @param value
     */
    public void SelectByValue(WebElement webElement, String value){
        Select dropDown = new Select(webElement);
        dropDown.selectByValue(value);
    }

    /**
     * Selects value from a drop down using index
     * @param webElement
     * @param index
     */
    public void SelectByIndex(WebElement webElement, int index){
        Select dropDown = new Select(webElement);
        dropDown.selectByIndex(index);
    }

    /**
     * Validate if a given element exists then return true or false
     * @param driver
     * @param webElement
     * @return boolean
     */
    public boolean ValidateExists( WebDriver driver,WebElement webElement){
        WaitToBeClickable(driver, webElement);
        return webElement.isDisplayed();
    }

    /**
     * Switches to the next browser tab
     * @param driver
     */
    public void SwitchToNextTab(WebDriver driver){
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
    }

}