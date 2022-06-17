package com.wlabs.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.wlabs.qa.base.TestBase;
import com.wlabs.qa.pages.LoginPage;
import com.wlabs.qa.pages.RegistrationPage;

public class LoginPageTest extends TestBase {

	LoginPage loginpage;
	RegistrationPage registrationpage;

	public LoginPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginpage = new LoginPage();
		registrationpage = new RegistrationPage();
	}
	
	//Assignment 1.2: Login as the newly registered user and verify that the most expensive laptop is macbook pro
	@Test
	public void loginSuccessfull() throws InterruptedException {
		
		registrationpage.ClickOnMyAccount();
		loginpage.ClickOnLogin();
		loginpage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		loginpage.ClickOnLaptopNotebooks();
		loginpage.ClickOnAllLaptopNotebooks();
		loginpage.HighestValueLaptop();

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
