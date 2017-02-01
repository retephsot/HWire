package com.test1.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogInPage extends PageBase{
	
	public LogInPage (WebDriver driver)
	{
		super(driver);
	}
	
	public AccountInformationPage clickIAmABusinessLink()
	{
		driver.findElement(By.xpath("//a[@href='/register/manager/account']")).click();
		
		return new AccountInformationPage(driver);	
	}
	
}
