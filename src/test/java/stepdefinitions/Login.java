package stepdefinitions;

import java.util.Date;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.AccountPage;
import pages.HomePage;
import pages.LoginPage;
import utilsPackage.CommonUtils;

public class Login {
	
	WebDriver driver;
	HomePage homePage;
	LoginPage loginPage;
	AccountPage accountPage;
	CommonUtils commonUtils;

	@Given("User has navigates to login page")
	public void User_has_navigates_to_login_page() {
		
		driver = DriverFactory.getDriver();
		homePage = new HomePage(driver);
		homePage.clickOnMyAccount();
//		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		loginPage = homePage.selectLoginOption();
//		driver.findElement(By.linkText("Login")).click();
	}
	
	@When("^User enters valid email address (.+) into the emmail field$")
	public void User_enters_valid_email_address_into_the_emmail_field(String emailText) {
		
		loginPage.enterEmailAddress(emailText);
//		driver.findElement(By.id("input-email")).sendKeys(emailText);
		
	}
	
	@And("^User enters valid password (.+) into the password feild$")
	public void user_enters_valid_password_into_the_password_feild(String passwordText) {
	    
		loginPage.enterPassword(passwordText);
//		driver.findElement(By.id("input-password")).sendKeys(passwordText);
		
	}

	@And("User clicks on Login button")
	public void user_clicks_on_login_button() {
	   
		accountPage = loginPage.clickOnLogin();
//		driver.findElement(By.xpath("//input[@value='Login']")).click();
		
	}

	@Then("User should get successfully logged in")
	public void user_should_get_successfully_logged_in() {
//	    int no = 10/0;
		Assert.assertTrue(accountPage.displayStatusOfEditYourAccountInformationOption());
//		Assert.assertTrue(driver.findElement(By.linkText("Edit your account information")).isDisplayed());
		
	}

	@When("User enters invalid email address into the email field")
	public void user_enters_invalid_email_address_into_the_email_field() {
	    
		commonUtils = new CommonUtils();
		loginPage.enterEmailAddress(commonUtils.getEmailTimeStamp());
//		driver.findElement(By.id("input-email")).sendKeys(getEmailTimeStamp());
		
	}

	@And("User enters invalid password {string} into the password field")
	public void user_enters_invalid_password_into_the_password_field(String invalidPasswordText) {
	    
		loginPage.enterPassword(invalidPasswordText);
//		driver.findElement(By.id("input-password")).sendKeys(invalidPasswordText);
		
	}

	@Then("User should get a proper warning message about credentials mismatch")
	public void user_should_get_a_proper_warning_message_about_credentials_mismatch() {
	    
		Assert.assertTrue(loginPage.getWarningMessageText().contains("Warning: No match for E-Mail Address and/or Password."));
//		Assert.assertTrue(driver.findElement(By.xpath("//div[@class='alert alert-danger alert-dismissible']")).getText().contains("Warning: No match for E-Mail Address and/or Password."));
		
	}

	@When("User dont enter email address into email field")
	public void user_dont_enter_email_address_into_email_field() {
	    
		loginPage.enterEmailAddress("");
//		driver.findElement(By.id("input-email")).sendKeys("");
		
	}

	@When("User dont enter password into password field")
	public void user_dont_enter_password_into_password_field() {
	    
		loginPage.enterPassword("");
//		driver.findElement(By.id("input-password")).sendKeys("");
		
	}

}
