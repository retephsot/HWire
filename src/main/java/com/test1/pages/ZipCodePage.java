package com.test1.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ZipCodePage extends PageBase{
	
	public ZipCodePage (WebDriver driver)
		{
			super(driver);
		}
	
	public LocationInformationPage enterZipCode(String zipcode) throws InterruptedException
	{
		zipcode = zipcode.replaceAll("([0-9])\\.0+([^0-9]|$)", "$1$2");
		driver.findElement(By.id("zipCode")).sendKeys(zipcode);
	
		driver.findElement(By.xpath("//form[@id='validateZipCode']/p[3]")).click();
		Thread.sleep(500);

		return new LocationInformationPage(driver);
	}



}
