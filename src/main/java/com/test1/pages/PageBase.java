package com.test1.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageBase 
{

	protected WebDriver driver;
	
	public PageBase (WebDriver driver)
	{
		this.driver = driver;
	}
		
	public void waitForElementByID(String elementID) {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		WebElement element = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.id(elementID)));	
	}
	
	public void waitForElementByIDPresense(String elementID) {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		WebElement element = wait.until(
				ExpectedConditions.presenceOfElementLocated(By.id(elementID)));	
	}
	
	public void waitForElementByClass(String elementClass) {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		WebElement element = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.className(elementClass)));
	}
	
	public void waitForElementByXPath(String elementXPath) {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		WebElement element = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.xpath(elementXPath)));
	}
	
	public void waitForElementByXPathPresense(String elementXPath) {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		WebElement element = wait.until(
				ExpectedConditions.presenceOfElementLocated(By.xpath(elementXPath)));
	}
	
	public void waitForElementByClassPresense(String elementClass) {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		WebElement element = wait.until(
				ExpectedConditions.presenceOfElementLocated(By.className(elementClass)));
	}
	
	public void waitForElementByCssSel(String elementCSS) {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		WebElement element = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.cssSelector(elementCSS)));
	}
	
	public void waitForElementByCssSelPresense(String elementCSS) {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		WebElement element = wait.until(
				ExpectedConditions.presenceOfElementLocated(By.cssSelector(elementCSS)));
	}
	
	public void waitForElementByLinkText(String elementLinkText) {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		WebElement element = wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.linkText(elementLinkText)));
	}

}
