package com.test1.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class JobSeekerPage extends PageBase{
	
	public JobSeekerPage (WebDriver driver)
		{
			super(driver);
		}
	
	public void isCreateBusinessAccountSuccessful(String businessname, String addressone) throws InterruptedException
	{	
		Thread.sleep(6000);
		waitForElementByXPath("//a[@id='nav-locations']/li/div/span");
		WebElement businessInfo = driver.findElement(By.xpath("//a[@id='nav-locations']/li/div/span"));
		Thread.sleep(500);
	    String businessInfoText = businessInfo.getText();
		System.out.println("The business information includes " + businessInfoText);
		System.out.println("The businessname value is " + businessname);
		Assert.assertTrue(businessInfo.getText().contains(businessname));
		System.out.println("Assertion -> text assertion executed. Result is true");
		Thread.sleep(400);
		System.out.println("The address value is " + addressone);
		Assert.assertTrue(businessInfo.getText().contains(addressone));
		System.out.println("Assertion -> 2nd text assertion executed. Result is true");

	}

}
