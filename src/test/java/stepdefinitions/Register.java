package stepdefinitions;

import java.util.Date;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import pages.AccountSuccessPage;
import pages.HomePage;
import pages.RegisterPage;
import utilsPackage.CommonUtils;

public class Register {
	
	WebDriver driver;
	HomePage homePage;
	RegisterPage registerPage;
	AccountSuccessPage accountSuccessPage;
	CommonUtils commonUtils;


	@Given("User navigates to Register Account page")
	public void user_navigates_to_register_account_page() {
		
		driver = DriverFactory.getDriver();
		homePage = new HomePage(driver);
		homePage.clickOnMyAccount();
//		driver.findElement(By.xpath("//span[text()='My Account']")).click();
	    registerPage = homePage.selectRegisterOption();
//		driver.findElement(By.linkText("Register")).click();
		
	}

	@When("User enters the details into below fields")
	public void user_enters_the_details_into_below_fields(DataTable dataTable) {
	   
		Map<String, String> dataMap = dataTable.asMap(String.class, String.class);
		
		registerPage.enterFirstNameField(dataMap.get("firstName"));
//		driver.findElement(By.id("input-firstname")).sendKeys(dataMap.get("firstName"));
		
		registerPage.enterlastNameField(dataMap.get("lastName"));
//		driver.findElement(By.id("input-lastname")).sendKeys(dataMap.get("lastName"));
		
		commonUtils = new CommonUtils();
		registerPage.enterEmailField(commonUtils.getEmailTimeStamp());
//		driver.findElement(By.id("input-email")).sendKeys(CommonUtils.getEmailTimeStamp());
		
		registerPage.entertelephoneField(dataMap.get("telephone"));
//		driver.findElement(By.id("input-telephone")).sendKeys(dataMap.get("telephone"));
		
		registerPage.enterPasswordField(dataMap.get("password"));
//		driver.findElement(By.id("input-password")).sendKeys(dataMap.get("password"));
		
		registerPage.enterconfirmPasswordField(dataMap.get("password"));
//		driver.findElement(By.id("input-confirm")).sendKeys(dataMap.get("password"));
	}
	
	@When("User enters the details into below fields with duplicate email")
	public void user_enters_the_details_into_below_fields_with_duplicate_email(DataTable dataTable) {
	   
		Map<String, String> dataMap = dataTable.asMap(String.class, String.class);
		
		registerPage.enterFirstNameField(dataMap.get("firstName"));
//		driver.findElement(By.id("input-firstname")).sendKeys(dataMap.get("firstName"));
		
		registerPage.enterlastNameField(dataMap.get("lastName"));
//		driver.findElement(By.id("input-lastname")).sendKeys(dataMap.get("lastName"));
		
		registerPage.enterEmailField(dataMap.get("email"));
//		driver.findElement(By.id("input-email")).sendKeys(dataMap.get("email"));
		
		registerPage.entertelephoneField(dataMap.get("telephone"));
//		driver.findElement(By.id("input-telephone")).sendKeys(dataMap.get("telephone"));
		
		registerPage.enterPasswordField(dataMap.get("password"));
//		driver.findElement(By.id("input-password")).sendKeys(dataMap.get("password"));
		
		registerPage.enterconfirmPasswordField(dataMap.get("password"));
//		driver.findElement(By.id("input-confirm")).sendKeys(dataMap.get("password"));
		
	}

	@And("User selects Privacy Policy")
	public void user_selects_privacy_policy() {
	    
		registerPage.selectPrivacyPolicyCheckbox();
//		driver.findElement(By.name("agree")).click();
		
	}

	@And("User clicks on continue button")
	public void user_clicks_on_continue_button() {
	   
		accountSuccessPage = registerPage.selectContinueButton();
//		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		
	}

	@Then("User account should get created successfully")
	public void user_account_should_get_created_successfully() {
	    
		Assert.assertEquals("Your Account Has Been Created!", accountSuccessPage.getAccountCreatedText());
//		Assert.assertEquals("Your Account Has Been Created!", driver.findElement(By.xpath("//div[@id='content']//h1")).getText());
	}

	@And("User selects Yes for Newsletter")
	public void user_selects_yes_for_newsletter() {
	    
		registerPage.selectNewsLetterYesOption();
//		driver.findElement(By.xpath("//input[@name='newsletter'][@value='1']")).click();
		
	}

	@Then("User should get a proper warning about duplicate email")
	public void user_should_get_a_proper_warning_about_duplicate_email() {
	    
		Assert.assertTrue(registerPage.getDuplicateEmailWarningMessage().contains("Warning: E-Mail Address is already registered!"));
//		Assert.assertTrue(driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText().contains("Warning: E-Mail Address is already registered!"));
	}

	@When("User dont enter any details into fields")
	public void user_dont_enter_any_details_into_fields() {
	   
		//Intentionally kept blank
	}

	@Then("User should get proper warning messages for every mandatory field")
	public void user_should_get_proper_warning_messages_for_every_mandatory_field() {
	    
		Assert.assertTrue(registerPage.getPrivacyPolicyWarningMessage().contains("Warning: You must agree to the Privacy Policy!"));
//		Assert.assertTrue(driver.findElement(By.xpath("//div[contains(@class,'alert-dismissible')]")).getText().contains("Warning: You must agree to the Privacy Policy!"));
	    
		Assert.assertTrue(registerPage.getFirstNameWarningMessage().contains("First Name must be between 1 and 32 characters!"));
//		Assert.assertTrue(driver.findElement(By.xpath("//input[@id='input-firstname']//following-sibling::div")).getText().contains("First Name must be between 1 and 32 characters!"));
	   
		Assert.assertTrue(registerPage.getLastNameWarningMessage().contains("Last Name must be between 1 and 32 characters!"));
//		Assert.assertTrue(driver.findElement(By.xpath("//input[@id='input-lastname']//following-sibling::div")).getText().contains("Last Name must be between 1 and 32 characters!"));
	    
		Assert.assertTrue(registerPage.getEmailWarningMessage().contains("E-Mail Address does not appear to be valid!"));
//		Assert.assertTrue(driver.findElement(By.xpath("//input[@id='input-email']//following-sibling::div")).getText().contains("E-Mail Address does not appear to be valid!"));
	    
		Assert.assertTrue(registerPage.getTelephoneWarningMessage().contains("Telephone must be between 3 and 32 characters!"));
//		Assert.assertTrue(driver.findElement(By.xpath("//input[@id='input-telephone']//following-sibling::div")).getText().contains("Telephone must be between 3 and 32 characters!"));
	   
		Assert.assertTrue(registerPage.getPasswordWarningMessage().contains("Password must be between 4 and 20 characters!"));
//		Assert.assertTrue(driver.findElement(By.xpath("//input[@id='input-password']//following-sibling::div")).getText().contains("Password must be between 4 and 20 characters!"));
	}
	
}
