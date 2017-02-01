package com.test1.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountInformationPage extends PageBase{
		
	public AccountInformationPage (WebDriver driver)
	{
		super(driver);
	}
	
	public PhoneVerificationPage fillOutAccountInformation(String email, String fName, String lName, 
			String password, String confirmPassword) throws InterruptedException
	{
		driver.findElement(By.id("email")).sendKeys(email);
		driver.findElement(By.id("firstName")).sendKeys(fName);
		driver.findElement(By.id("lastName")).sendKeys(lName);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.id("passwordConfirm")).sendKeys(confirmPassword);
		
		driver.findElement(By.xpath("//input[@value='Continue']")).click();
		
		waitForElementByIDPresense("sendVerification");
		Thread.sleep(700);
		
		return new PhoneVerificationPage(driver);
	}
	
}
