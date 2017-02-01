package com.test1.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class LocationInformationPage extends PageBase{
	
	public LocationInformationPage (WebDriver driver)
		{
			super(driver);
		}
	
	public JobSeekerPage enterBusinessNameExisting(String businessname) throws InterruptedException
	{
		driver.findElement(By.id("query")).sendKeys(businessname);
	
		waitForElementByXPathPresense("//div[@class='pac-container pac-logo']/div");
		Thread.sleep(500);
		
		driver.findElement(By.xpath("//div[@class='pac-container pac-logo']/div")).click();

		return new JobSeekerPage(driver);
	}
	
	public JobSeekerPage enterBusinessNameNonExistant(String businessname, 
			String addressone, String city, String state, String zipcode, String industry,
			String category) throws InterruptedException
	{
		zipcode = zipcode.replaceAll("([0-9])\\.0+([^0-9]|$)", "$1$2");
		driver.findElement(By.id("query")).sendKeys(businessname);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@class='container']/div[2]/div/form/p[4]/a/b")).click();
		
		waitForElementByIDPresense("validateZipCode");		
		driver.findElement(By.xpath("//input[@name='businessLocationName']")).sendKeys(businessname);
		driver.findElement(By.xpath("//input[@name='addressOne']")).sendKeys(addressone);
		driver.findElement(By.xpath("//input[@name='city']")).sendKeys(city);
		driver.findElement(By.xpath("//input[@name='state']")).sendKeys(state);
		driver.findElement(By.xpath("//input[@name='zipCode']")).sendKeys(zipcode);	
		Thread.sleep(500);
		
		Select dropdownIndustry = new Select(driver.findElement(By.id("industry")));
		dropdownIndustry.selectByVisibleText(industry);
		Thread.sleep(500);
		
		Select dropdownCategory = new Select(driver.findElement(By.id("categories")));
		dropdownCategory.selectByVisibleText(category);
		
		driver.findElement(By.xpath("//input[@type='submit'][@value='Create New Location']")).click();
		
		return new JobSeekerPage(driver);
	}

}
