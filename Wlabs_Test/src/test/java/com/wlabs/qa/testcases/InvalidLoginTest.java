package com.wlabs.qa.testcases;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class InvalidLoginTest {

	public static void main(String[] args) throws IOException, InterruptedException {
		File file = new File(System.getProperty("user.dir") + "/DataSheet.xlsx");
		FileInputStream inputstream = new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(inputstream);
		XSSFSheet sheet = wb.getSheet("LoginSheet");
		/* Open Login page */
		System.setProperty("webdriver.chrome.driver", "/Users/BlacK_BearD/Downloads/chromedriver_1");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=common/home");
		driver.findElement(By.xpath("//span[contains(text(),'My Account')]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Login')]")).click();
		// Storing Values in to Variables ( In this case, Usernames and Passwords )
		XSSFRow row = null;
		XSSFCell cell = null;
		String userName = null;
		String password = null;
		for (int i = 1; i <= sheet.getLastRowNum(); i++) {
			row = sheet.getRow(i);
			for (int j = 0; j < row.getLastCellNum(); j++) {
				cell = row.getCell(j);

				if (j == 0) // We can use Column Name as well, will see in upcoming sessions
				{
					userName = cell.getStringCellValue();
				}
				if (j == 1) // We can use Column Name as well, will see in upcoming sessions
				{
					password = cell.getStringCellValue();
				}
			}

			WebElement EmailField= driver.findElement(By.id("input-email"));
			WebElement PasswordField= driver.findElement(By.id("input-password"));	
			WebElement LoginBtn= driver.findElement(By.xpath("//input[@type='submit']"));
			WebElement LoginLink= driver.findElement(By.xpath("//ul[@class='breadcrumb']/li[3]"));
			
			EmailField.sendKeys(userName);
			PasswordField.sendKeys(password);
			LoginBtn.click();
			Thread.sleep(2000);
			LoginLink.click();
			Thread.sleep(2000);

			System.out.println("User Name : " + userName + " ----> " + "Password : " + password);
			
		}
	}
}