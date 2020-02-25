package screens;

import core.WebAutomation;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

/** Extends from WebAutomation.java, this is a Object representation of HomePage.
 * It represents interaction methods from HomePage
 */
public class HomePage extends WebAutomation  {

    private WebDriver driver;


    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    /**
     * Represents web elements such as button, text boxes drop down and more.
     */
    @FindBy(xpath = "//*[@id=\"footer\"]/div/div/div/div[1]/div/div/div[5]/div/div/div[1]/div[3]")
    private WebElement popUp;

    @FindBy(id = "017805297")
    private WebElement searchIcon;

    @FindBy(id = "search_0654282383")
    private WebElement searchField;

    @FindBy(xpath = "//*[@id=\"0781152833\"]/div/div[1]/div/form/button")
    private WebElement searchBtn;

    @FindBy(id = "1393760596")
    private WebElement homeComponentContent;


    /**
     * Enters text on a searchbox and clicks search button
     * @param value
     */
    public void SearchFor(String value){
        Click(searchIcon);
        EnterText(searchField, value);
        Click(searchBtn);
    }

    /**
     * Enters and select value from a dropdown
     * @param id
     */
    public void SelectCheckBox(String id){
        WaitToBeClickable(driver, driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div[1]/div/div/div/div/div/div[2]/form/ul/li[2]/label")));
        Click(driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div[1]/div/div/div/div/div/div[2]/form/ul/li[2]/label")));
    }

    /**
     * Cliks on links with a given text
     * @param driver
     * @param text
     */
    public void ClickLinkByText(WebDriver driver ,String text){
       super.ClickLinkByText(driver,text);
    }

    /**
     * Validates if current screen is Home Screen
     * @return
     */
    public boolean ValidateIsHomeScreen(){
        return ValidateExists(driver ,homeComponentContent);
    }

    /**
     * Close(x) button on popUp window
     */
    public void ClosePopUP(){
        try {

                if (ValidateExists( driver, popUp))
                {
                    WaitToBeClickable(driver,popUp);
                    Click(popUp);
                }

        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
