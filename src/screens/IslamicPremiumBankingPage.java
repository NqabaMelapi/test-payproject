package screens;

import core.WebAutomation;
import models.PersonalDetailsModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class IslamicPremiumBankingPage extends WebAutomation {

    public IslamicPremiumBankingPage(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "firstName")
    private WebElement firstName;

    @FindBy(id = "lastName")
    private WebElement suranme;

    @FindBy(id = "identityNo")
    private WebElement idNumner;

    @FindBy(id = "homeLanguage")
    private WebElement homeLanguage;

    @FindBy(xpath = "//*[@id=\"dspApplication\"]/div[2]/div[1]/div/ui-view/ca-your-details-personal/cb-form/form/div[1]/div/div/fieldset/div[4]/div[1]/form-tabbed-search/div/div[2]/div/span[2]/span")
    private WebElement nationalityDropdownBtn;

    @FindBy(id = "searchOptionNationality")
    private WebElement searchOptionNationality;

    @FindBy(xpath = "//*[@id=\"dspApplication\"]/div[2]/div[1]/div/ui-view/ca-your-details-personal/cb-form/form/div[1]/div/div/fieldset/div[4]/div[2]/form-tabbed-search/div/div[2]/div/span[2]")
    private WebElement countryOfBirthDropdownBtn;

    @FindBy(id = "searchOptionBirth")
    private WebElement searchOptionCountryOfBirth;

    @FindBy(xpath = "//*[@id=\"dspApplication\"]/div[2]/div[1]/div/ui-view/ca-your-details-personal/cb-form/form/div[1]/div/div/fieldset/div[5]/div[1]/form-tabbed-search/div/div[2]/div/span[2]")
    private WebElement countryOfResidenceDropdownBtn;

    @FindBy(id = "searchOption")
    private WebElement searchOptionCountryOfResidence;

    @FindBy(xpath = "//*[@id=\"dspApplication\"]/div[2]/div[1]/div/ui-view/ca-your-details-personal/cb-form/form/div[1]/div/div/fieldset/div[6]/div/form-radio/fieldset/div/div/label[1]/span[2]")
    private WebElement MaritalStatusNotMarried;

    @FindBy(id = "kinFullName")
    private WebElement kinFirstName;

    @FindBy(id = "kinSurname")
    private WebElement kinSurname;

    @FindBy(id = "kinContactNumber")
    private WebElement kinContactNumber;

    @FindBy(id = "kinEmailAddress")
    private WebElement kinEmailAddress;

    @FindBy(xpath = "//*[@id=\"kinRelationship\"]/div[2]/span")
    private WebElement kinRelationshipDropdownBtn;

    @FindBy(xpath = "//*[@id=\"dspApplication\"]/div[2]/div[1]/div/ui-view/ca-your-details-personal/cb-form/form/div[1]/div/div/fieldset/div[1]/div/form-tabbed-radio/div/div[2]/div/span")
    private WebElement titleDropDown;

    @FindBy(xpath = "//*[@id=\"dspApplication\"]/div[2]/div[1]/div/ui-view/ca-account-features/cb-form/form/div[1]/div/div/div[2]/div[2]/div[2]/span")
    private WebElement absaRewards;

    @FindBy(id = "tnc_label-container")
    private WebElement acceptAllCheckbox;

    @FindBy(id = "insolvent0")
    private WebElement noNeverBeenInsolvent;

    @FindBy(id = "debtReview1")
    private WebElement noNotInsolvent;

    @FindBy(xpath = "/html/body/dsp-core/div[1]/ui-view/ca-welcome-main/div/div/ui-view/ca-documents/div/div/div[2]/div/div[1]/div/span/div/tooltip/div/div/div[1]")
    private WebElement toolTipContent;

    @FindBy(xpath = "/html/body/dsp-core/div[1]/ui-view/ca-welcome-main/div/div/ui-view/ca-documents/div/div/div[2]/div/div[1]/div/span/div/a")
    private WebElement infoIcon;

    //Let's continue
    @FindBy(xpath = "/html/body/dsp-core/div[1]/ui-view/dsp-decision-tree/cb-form/form/div/div/div[2]/div/div[2]/form-button/div/button")
    private WebElement letsContinueBtn;

    @FindBy(id = "makeDecision0")
    private WebElement newCustomerRadioBtn;

    @FindBy(xpath = "//*[@id=\"0416381654\"]/div/div[1]/div/div/p[2]/a")
    private WebElement applyNowBtn;

    @FindBy(xpath = "//*[h1() = 'Islamic Premium Banking application']")
    private WebElement islamicPremiumBankingTitle;

    public void ClickApplyNow(){
        Click(applyNowBtn);
    }

    private String GetAbsaRewardsAmount(){
        Wait(absaRewards);
        return absaRewards.getText().replace("R", "").replace("pm","").trim();
    }

    private boolean CheckAbsaRewardAreMoreThan(double amount){
        double rewards = Double.parseDouble(GetAbsaRewardsAmount());

        if(rewards > amount) return true;
        else return  false;
    }

    public void ClickLetsContinueIfRewardsAreMoreThan(double amount){
        if(CheckAbsaRewardAreMoreThan(amount)) ClickLetsContinue();
    }

    private void SelectTitle(String title) {
        Wait(driver.findElement(By.xpath("//*[contains(@value, '{title}')]".replace("{title}",title))));
        driver.findElement(By.xpath("//*[contains(@value, '{title}')]".replace("{title}",title))).click();
    }

    private void SelectNextOfKinRelationship(String relationship) {
        Wait(driver.findElement(By.xpath("//*[contains(text(),'{relationship}')]".replace("{relationship}",relationship))));
        driver.findElement(By.xpath("//*[contains(text(),'{relationship}')]".replace("{relationship}",relationship))).click();
    }

    public boolean ValidateIsIslamicPremiumBankingPage(){
        return ValidateExists(islamicPremiumBankingTitle);
    }

    public void SelectNewCustomer(){
        Click(newCustomerRadioBtn);
    }

    public void ClickLetsContinue(){
        Click(letsContinueBtn);
    }

    public String GetToolTipInfo(){
        Click(infoIcon);
        return toolTipContent.getText();
    }

    public void ClickNoNotInsolvent(){
        Click(noNotInsolvent);
    }


    public void ClickNoNeverBeenInsolvent(){
        Click(noNeverBeenInsolvent);
    }

    public void GiveConsent(){
        Click(acceptAllCheckbox);
    }

    public void EnterPersonalDetails(PersonalDetailsModel personalDetails){
        SelectTitle(personalDetails.title);
        EnterText(firstName, personalDetails.firstName );
        EnterText(suranme, personalDetails.surname);
        EnterText(idNumner, personalDetails.idNumber );
        EnterText(homeLanguage, personalDetails.homeLanguage);
        EnterText(searchOptionNationality, personalDetails.nationality);
        EnterText(searchOptionCountryOfBirth, personalDetails.countryOfBirth);
        EnterText(searchOptionCountryOfResidence, personalDetails.countryOfResidence );
        if (personalDetails.maritalStatus.equals("No")) Click(MaritalStatusNotMarried);

        EnterText(kinFirstName, personalDetails.kinFirstName );
        EnterText(kinSurname, personalDetails.kinSurname);
        EnterText(kinContactNumber, personalDetails.kinContactNumber );
        EnterText(kinEmailAddress, personalDetails.kinEmailAddress);

        Click(kinRelationshipDropdownBtn);
        SelectNextOfKinRelationship(personalDetails.kinRelationship);
    }

}