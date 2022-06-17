package com.wlabs.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.wlabs.qa.base.TestBase;

public class RegistrationPage extends TestBase {

	// PageFactory = Object Repository
	@FindBy(xpath = "//span[contains(text(),'My Account')]")
	WebElement MyAccount;

	@FindBy(xpath = "//a[contains(text(),'Register')]")
	WebElement Register;

	@FindBy(id = "input-firstname")
	WebElement FirstName;

	@FindBy(id = "input-lastname")
	WebElement LastName;

	@FindBy(id = "input-email")
	WebElement Email;

	@FindBy(id = "input-telephone")
	WebElement Telephone;

	@FindBy(id = "input-password")
	WebElement Password;

	@FindBy(id = "input-confirm")
	WebElement ConfirmPassword;

	@FindBy(xpath = "//input[@name='agree']")
	WebElement AgreeTerms;

	@FindBy(xpath = "//input[@value='Continue']")
	WebElement ContinueBtn;

	// Initializing Page Objects:
	public RegistrationPage() {
		PageFactory.initElements(driver, this);

	}

	// Actions

	public String ValidateHomePageTitle() {
		return driver.getTitle();
	}

	public void ClickOnMyAccount() {
		MyAccount.click();

	}

	public RegistrationPage ClickOnRegister() {
		Register.click();

		return new RegistrationPage();

	}

	public void EnterFirstName() {
		FirstName.sendKeys("Chahna");

	}

	public void EnterLastName() {
		LastName.sendKeys("Patel");

	}

	public void EnterEmail() {
		Email.sendKeys("Test2@gmail.com");

	}

	public void EnterTelephone() {
		Telephone.sendKeys("9876543210");

	}

	public void EnterPassword() {
		Password.sendKeys("Test_123!");

	}

	public void EnterConfirmPassword() {
		ConfirmPassword.sendKeys("Test_123!");

	}

	public void AgreeTermsAndConditions() {
		AgreeTerms.click();

	}

	public String ClickOnContinue() {
		ContinueBtn.click();

		return driver.getTitle();
	}

	public String ValidateRegistrationPageTitle() {
		return driver.getTitle();
	}

}
