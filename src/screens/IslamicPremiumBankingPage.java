package screens;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import core.WebAutomation;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.TestReport;


import java.util.Hashtable;


/** Extends from WebAutomation.java, this is a Object representation of Islamic Premium Banking Page.
 */
public class IslamicPremiumBankingPage extends WebAutomation {

    private WebDriver driver;
    private  ExtentTest testCase;

    public IslamicPremiumBankingPage(WebDriver driver, ExtentTest testCase){
        this.driver = driver;
        this.testCase = testCase;
        PageFactory.initElements(this.driver, this);
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

    @FindBy(xpath = "//*[@id=\"dspApplication\"]/div[2]/div[1]/div/ui-view/ca-your-details-personal/cb-form/form/div[1]/div/div/fieldset/div[6]/div[2]/form-dropdown/div/div/div/form-dropdown-option[1]/a/span[1]/div")
    private  WebElement maritalSingle;

    @FindBy(xpath = "//*[@id=\"yourStatus\"]/div[2]")
    private WebElement maritalContracDropdownButton;

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

    //@FindBy(id = "insolvent0")
    @FindBy(xpath = "//*[@id=\"questionTwo\"]/div[1]/fieldset/form-radio/fieldset/div/div/label[1]")
    private WebElement noNeverBeenInsolvent;

    //@FindBy(id = "debtReview1")
    @FindBy(xpath = "//*[@id=\"insolvensy-container\"]/div/div[2]/div/div/div[1]/div/div/div/div[1]/fieldset/form-radio/fieldset/div/div/label[2]")
    private WebElement noNotInsolvent;

    @FindBy(xpath = "/html/body/dsp-core/div[1]/ui-view/ca-welcome-main/div/div/ui-view/ca-documents/div/div/div[2]/div/div[1]/div/span/div/tooltip/div/div/div[1]")
    private WebElement toolTipContent;

    @FindBy(xpath = "/html/body/dsp-core/div[1]/ui-view/ca-welcome-main/div/div/ui-view/ca-documents/div/div/div[2]/div/div[1]/div/span/div/a")
    private WebElement infoIcon;

    @FindBy(xpath = "//button[@class='btn btn-primary btn-lg']")
    private WebElement letsContinueBtn;

    @FindBy(xpath = "/html/body/dsp-core/div[1]/ui-view/dsp-decision-tree/cb-form/form/div/div/div[2]/div/div[1]/form-radio/fieldset/div/div/label[1]/span[2]")
    private WebElement newCustomerRadioBtn;

    @FindBy(xpath = "//*[@id=\"0416381654\"]/div/div[1]/div/div/p[2]/a")
    private WebElement applyNowBtn;

    @FindBy(xpath = "//*[h1() = 'Islamic Premium Banking application']")
    private WebElement islamicPremiumBankingTitle;

    @FindBy(xpath = "//*[@id=\"dspApplication\"]/div[2]/div[1]/div/ui-view/ca-your-details-personal/cb-form/form/div[1]/div/div/div/alert/div/div/div[2]/div/ul/li")
    private WebElement IdNumberInvalidText;

    /**
     * Uses method  WaitToBeClickable(driver, applyNowBtn), to click to Apply Now button
     *
     */
    public void ClickApplyNow(){
        WaitToBeClickable(driver, applyNowBtn);
        Click(applyNowBtn);
    }


    /**Clicks Single on Marital Contract Dropdown
     *
     */
    public void ClickMarritalContactSingle(){

        Click(maritalContracDropdownButton);
        WaitToBeClickable(driver, maritalSingle);
        Click(maritalSingle);
    }
    /** Gets rewards contents from the UI
     */
    private String GetAbsaRewardsAmount(){
        WaitToBeClickable(driver, absaRewards);
       String value = absaRewards.getText().replace("R", "").replace("pm","").trim();
        return absaRewards.getText().replace("R", "").replace("pm","").trim();
    }

    /** Checks if rewards are more than amount
     * @param amount
     */
    private boolean CheckAbsaRewardAreMoreThan(double amount){
        double rewards = Double.parseDouble(GetAbsaRewardsAmount());

        if(rewards > amount) return true;
        else return  false;
    }

    /** Clicks Let's Continue if the Rewards are more than amount
     * @param amount
     */
    public void ClickLetsContinueIfRewardsAreMoreThan(double amount){
        if(CheckAbsaRewardAreMoreThan(amount)) {
            //ClickLetsContinue();
            ClickLetsContinue();
        }
    }

    /** Selects Clients Title
     */
    private void SelectTitle(String title) {
        Click(titleDropDown);
        driver.findElement(By.xpath("//*[@id=\"dspApplication\"]/div[2]/div[1]/div/ui-view/ca-your-details-personal/cb-form/form/div[1]/div/div/fieldset/div[1]/div/form-tabbed-radio/div/div[3]/label[2]")).click();
    }

    /** Selects Next of Skin Relationship from Dropdown
     */
    private void SelectNextOfKinRelationship(String relationship) {
///        Wait(driver.findElement(By.xpath("//*[contains(text(),'{relationship}')]".replace("{relationship}",relationship))));
        driver.findElement(By.xpath("//*[contains(text(),'{relationship}')]".replace("{relationship}",relationship))).click();
    }
    /** Validates if user is on Islamic Premium Banking Page
     */
    public boolean ValidateIsIslamicPremiumBankingPage(){
        return ValidateExists( driver,islamicPremiumBankingTitle);
    }

    /** Selects New Customer Checkbox
     */
    public void SelectNewCustomer(){
        WaitToBeClickable(driver, newCustomerRadioBtn);
        Click(newCustomerRadioBtn);
    }


    /** Clicks Let's Continue Button
     */
    public void ClickLetsContinue(){
        WaitToBeClickable(driver, letsContinueBtn);
        Click(letsContinueBtn);
    }

    /** Gets the content from a ToolTipInfo
     */
    public String GetToolTipInfo(){
       // WaitToBeClickable(driver, toolTipContent);
        Click(infoIcon);
        return toolTipContent.getText();
    }

    /** Switches to the next tab of the browser
     */
    public void SwitchToIslamicPremiumBankingApplicationTab(){
        SwitchToNextTab(driver);
    }

    /** Clicks No Not Insolvent Check Box
     */
    public void ClickNoNotInsolvent(){
        WaitToBeClickable(driver, noNotInsolvent);
        Click(noNotInsolvent);
    }

    /** Clicks No Never Been Insolvent Check Box
     */
    public void ClickNoNeverBeenInsolvent(){
        WaitToBeClickable(driver, noNeverBeenInsolvent);
        Click(noNeverBeenInsolvent);
    }

    /** Clicks accept checkbox on terms and conditions
     */
    public void GiveConsent(){
        WaitToBeClickable(driver, acceptAllCheckbox);
        Click(acceptAllCheckbox);
    }


    /** Validate is invalid id number text is displayed
     * returns true if text exist. False if text does not exist
     */
    public boolean IdNumberInvaliTextExists(){

        return ValidateExists(driver, IdNumberInvalidText);
    }


    /** Enters and selects client nationality from web page
     *
     * @param testData contains key value pair e.g name, surname
     */
    public void SelectNationality(Hashtable testData){

        WaitToBeClickable(driver, nationalityDropdownBtn);
        Click(nationalityDropdownBtn);
        EnterText(searchOptionNationality, testData.get("Nationality").toString());
        Click(driver.findElement(By.xpath("//*[@id=\"dspApplication\"]/div[2]/div[1]/div/ui-view/ca-your-details-personal/cb-form/form/div[1]/div/div/fieldset/div[4]/div[1]/form-tabbed-search/div/div[3]/div/form-dropdown-search/div/div/div[2]/form-dropdown-option/a")));
    }


    /** Enters and selects country of birth from web page
     *
     * @param testData contains key value pair e.g name, surname
     */
    public void SelectCountryOfBirth(Hashtable testData){
        WaitToBeClickable(driver, countryOfBirthDropdownBtn);
        Click(countryOfBirthDropdownBtn);
        EnterText(searchOptionCountryOfBirth, testData.get("Country of Birth").toString());
        //SelectCountryOfBirth();
        Click(driver.findElement(By.xpath("//*[@id=\"dspApplication\"]/div[2]/div[1]/div/ui-view/ca-your-details-personal/cb-form/form/div[1]/div/div/fieldset/div[4]/div[2]/form-tabbed-search/div/div[3]/div/form-dropdown-search/div/div/div[2]/form-dropdown-option/a")));
    }

    /** Enters and selects country of residence from web page
     *
     * @param testData contains key value pair e.g name, surname
     */
    public void SelectCountryOfResidence(Hashtable testData){
        WaitToBeClickable(driver, countryOfResidenceDropdownBtn);
        Click(countryOfResidenceDropdownBtn);
        EnterText(searchOptionCountryOfResidence, testData.get("Country of Residence").toString());
        Click(driver.findElement(By.xpath("//*[@id=\"dspApplication\"]/div[2]/div[1]/div/ui-view/ca-your-details-personal/cb-form/form/div[1]/div/div/fieldset/div[5]/div[1]/form-tabbed-search/div/div[3]/div/form-dropdown-search/div/div/div[2]/form-dropdown-option/a")));
    }

    public void SelectHomeLanguage(Hashtable testData ){

        EnterText(homeLanguage, testData.get("Language").toString());
        driver.findElement(By.xpath("//*[@id=\"dspApplication\"]/div[2]/div[1]/div/ui-view/ca-your-details-personal/cb-form/form/div[1]/div/div/fieldset/div[3]/div[2]/form-dropdown-search/div/div/div[2]/form-dropdown-option/a/span[1]/div")).click();
    }

    /** Enter client personal details
     *
     * @param testData contains key value pair e.g name, surname
     */
    public void EnterPersonalDetails(Hashtable testData){
        SelectTitle(testData.get("Title").toString());
        EnterText(firstName, testData.get("First name").toString());
        EnterText(suranme, testData.get("Last name").toString());
        EnterText(idNumner, testData.get("ID number").toString());
        SelectHomeLanguage(testData);

        SelectNationality(testData);
        SelectCountryOfBirth(testData);
        SelectCountryOfResidence(testData);

        if (testData.get("Marital status").toString().equals("No")){
            Click(MaritalStatusNotMarried);
            ClickMarritalContactSingle();
        }

        EnterText(kinFirstName, testData.get("Kin First name").toString());
        EnterText(kinSurname, testData.get("Kin Surname").toString());
        EnterText(kinContactNumber, testData.get("Kin Contact number").toString() );
        EnterText(kinEmailAddress, testData.get("Kin Email address").toString());

        Click(kinRelationshipDropdownBtn);
        SelectNextOfKinRelationship(testData.get("Kin Relationship").toString());
    }
}