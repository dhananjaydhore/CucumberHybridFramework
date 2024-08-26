package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilsPackage.CommonUtils;
import utilsPackage.ElementUtils;

public class RegisterPage {

	WebDriver driver;
	ElementUtils elementUtils;
	
	public RegisterPage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementUtils = new ElementUtils(driver);
	}
	
	@FindBy(id = "input-firstname")
	private WebElement firstNameField;
	
	@FindBy(id = "input-lastname")
	private WebElement lastNameField;
	
	@FindBy(id = "input-email")
	private WebElement emailField;
	
	@FindBy(id = "input-telephone")
	private WebElement telephoneField;
	
	@FindBy(id = "input-password")
	private WebElement passwordField;
	
	@FindBy(id = "input-confirm")
	private WebElement confirmPasswordField;
	
	@FindBy(name = "agree")
	private WebElement privacyPolicyCheckbox;
	
	@FindBy(xpath = "//input[@value='Continue']")
	private WebElement continueButton;
	
	@FindBy(xpath = "//input[@name='newsletter'][@value='1']")
	private WebElement newsLetterYesOption;
	
	@FindBy(xpath = "//div[contains(@class,'alert-dismissible')]")
	private WebElement duplicateEmailWarningMessage;
	
	@FindBy(xpath = "//div[contains(@class,'alert-dismissible')]")
	private WebElement privacyPolicyWarningMessage;
	
	@FindBy(xpath = "//input[@id='input-firstname']//following-sibling::div")
	private WebElement firstNameWarningMessage;
	
	@FindBy(xpath = "//input[@id='input-lastname']//following-sibling::div")
	private WebElement lastNameWarningMessage;
	
	@FindBy(xpath = "//input[@id='input-email']//following-sibling::div")
	private WebElement emailWarningMessage;
	
	@FindBy(xpath = "//input[@id='input-telephone']//following-sibling::div")
	private WebElement telephoneWarningMessage;
	
	@FindBy(xpath = "//input[@id='input-password']//following-sibling::div")
	private WebElement passwordWarningMessage;
	
	
	
	public void enterFirstNameField(String firstName) {
		
		elementUtils.typeTextIntoElement(firstNameField, firstName, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	
		
	}
	
    public void enterlastNameField(String lastName) {
		
    	elementUtils.typeTextIntoElement(lastNameField, lastName, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
    	
		
	}

    public void enterEmailField(String emailText) {
	
    	elementUtils.typeTextIntoElement(emailField, emailText, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
    	
	
    }

    public void entertelephoneField(String telephone) {
	
    	elementUtils.typeTextIntoElement(telephoneField, telephone, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	
    }

    public void enterPasswordField(String password) {
	
    	elementUtils.typeTextIntoElement(passwordField, password, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
    	
    }
    
    public void enterconfirmPasswordField(String confirmPassword) {
    	
    	elementUtils.typeTextIntoElement(confirmPasswordField, confirmPassword, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
    	
    }
    
    public void selectPrivacyPolicyCheckbox() {
    
    	elementUtils.clickOnElement(privacyPolicyCheckbox, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
    	
    }
    
    public AccountSuccessPage selectContinueButton() {
    	
    	elementUtils.clickOnElement(continueButton, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
    	return new AccountSuccessPage(driver);
    	
    }
    
    public void selectNewsLetterYesOption() {
    	
    	elementUtils.clickOnElement(newsLetterYesOption, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
    	
    }
    
    public String getDuplicateEmailWarningMessage() {
    	
    	return duplicateEmailWarningMessage.getText();
    	
    }
    
    public String getPrivacyPolicyWarningMessage() {
    	
    	return privacyPolicyWarningMessage.getText();
    	
    }
    
    public String getFirstNameWarningMessage() {
    	
    	return firstNameWarningMessage.getText();
    	
    }
    
    public String getLastNameWarningMessage() {
    	
    	return lastNameWarningMessage.getText();
    	
    }

    public String getEmailWarningMessage() {
	
	    return emailWarningMessage.getText();
	
    }

    public String getTelephoneWarningMessage() {
	
	    return telephoneWarningMessage.getText();
	
    }

    public String getPasswordWarningMessage() {
	
	    return passwordWarningMessage.getText();
	
}
	
}