package com.wlabs.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.wlabs.qa.base.TestBase;
import com.wlabs.qa.pages.RegistrationPage;

public class RegistrationPageTest extends TestBase {

	RegistrationPage registrationpage;

	public RegistrationPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		registrationpage = new RegistrationPage();
	}

	// Assignment 1.1: Verifying HomePage Title and completes the Registration as a new user
	@Test
	public void clickOnMyAccountTest() throws InterruptedException {
		String homepage_title = registrationpage.ValidateHomePageTitle();
		Assert.assertEquals(homepage_title, "Your Store");
		registrationpage.ClickOnMyAccount();
		registrationpage.ClickOnRegister();
		registrationpage.EnterFirstName();
		registrationpage.EnterLastName();
		registrationpage.EnterEmail();
		registrationpage.EnterTelephone();
		registrationpage.EnterPassword();
		registrationpage.EnterConfirmPassword();
		registrationpage.AgreeTermsAndConditions();
		registrationpage.ClickOnContinue();
		String Registration_title = registrationpage.ValidateRegistrationPageTitle();
		Assert.assertEquals(Registration_title, "Your Account Has Been Created!");
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
