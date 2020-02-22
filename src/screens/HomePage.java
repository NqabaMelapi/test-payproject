package screens;

import core.WebAutomation;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends WebAutomation  {

    private WebDriver _driver;
    //private WebAutomation _webAutomation;

    public HomePage(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//*[@id=\"footer\"]/div/div/div/div[1]/div/div/div[5]/div/div/div[1]/div[3]")
    private WebElement popUp;

    @FindBy(id = "017805297")
    private WebElement searchIcon;

    @FindBy(id = "search_0654282383")
    private WebElement searchField;

    @FindBy(xpath = "//*[@id=\"809300322\"]/div/div[1]/div/form/div/button")
    private WebElement searchBtn;

    @FindBy(id = "1393760596")
    private WebElement homeComponentContent;


    public void SearchFor(String value){
        Click(searchIcon);
        EnterText(searchField, value);
        Click(searchBtn);
    }

    public void SelectCheckBox(String id){
        Click(driver.findElement(By.id(id)));

    }

    public void ClickLinkByText(String text){
       super.ClickLinkByText(text);
    }

    public boolean ValidateIsHomeScreen(){
        return ValidateExists(homeComponentContent);
    }

    public void ClosePopUP(){
        if (ValidateExists(popUp)) popUp.click();
    }
}
