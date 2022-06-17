package com.wlabs.qa.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.wlabs.qa.base.TestBase;

public class LoginPage extends TestBase {

	// PageFactory = Object Repository

	@FindBy(xpath = "//a[contains(text(),'Login')]")
	WebElement Login;

	@FindBy(id = "input-email")
	WebElement LoginEmail;

	@FindBy(id = "input-password")
	WebElement LoginPassword;

	@FindBy(xpath = "//input[@type='submit']")
	WebElement LoginBtn;

	@FindBy(xpath = "//li[@class='dropdown']/a[contains(text(),'Laptops & Notebooks')]")
	WebElement LaptopNotebooks;

	@FindBy(xpath = "//div[@class='dropdown-menu']/a[contains(text(),'Show All Laptops & Notebooks')]")
	WebElement AllLaptopNotebooks;
	

	// Initializing Page Objects:
	public LoginPage() {
		PageFactory.initElements(driver, this);

	}

	// Actions

	public LoginPage ClickOnLogin()  {
		Login.click();
		
		return new LoginPage();

	}

	public LoginPage login(String un, String pwd)  {
		LoginEmail.sendKeys(un);
		LoginPassword.sendKeys(pwd);
		LoginBtn.click();
		
		return new LoginPage();
	}

	public void ClickOnLaptopNotebooks()  {
		LaptopNotebooks.click();
		
	}

	public void ClickOnAllLaptopNotebooks()  {
		AllLaptopNotebooks.click();
		
	}

	public void HighestValueLaptop() {

		List<WebElement> priceList = driver.findElements(By.xpath("//div[@class='caption']/p[2]/span"));

		double maxPrice = priceList.stream().mapToDouble(e -> Double.parseDouble(e.getText().trim().replace("$", "")))
				.max().getAsDouble();

		System.out.println("The most expensive laptop is Macbook Pro with price of "+maxPrice);

	}

}
