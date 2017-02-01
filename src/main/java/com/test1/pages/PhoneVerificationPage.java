package com.test1.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PhoneVerificationPage extends PageBase{
	
	public PhoneVerificationPage (WebDriver driver)
		{
			super(driver);
		}
	
	public ZipCodePage enterPhoneNumber(String phoneNumber, String verificationCode) throws InterruptedException
		{
			verificationCode = verificationCode.replaceAll("([0-9])\\.0+([^0-9]|$)", "$1$2");
			driver.findElement(By.id("phoneNumber")).sendKeys(phoneNumber);
		
			driver.findElement(By.xpath("//form[@id='sendVerification']/p[3]")).click();
	
			waitForElementByIDPresense("verificationCode");
			Thread.sleep(500);
	
			driver.findElement(By.id("verificationCode")).sendKeys(verificationCode);
			driver.findElement(By.xpath("//input[@type='submit'][@value='Create Your Account']")).click();
	
			return new ZipCodePage(driver);
		}

}
