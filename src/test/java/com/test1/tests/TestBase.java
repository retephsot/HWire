package com.test1.tests;

import java.awt.Toolkit;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import com.test1.pages.LogInPage;
import com.test1.util.DataDrivenHelper;
import com.test1.util.SendMail;
import com.test1.util.WebDriverHelper;

public class TestBase {

	protected WebDriver driver;
	protected LogInPage loginpage;
	protected Properties testConfig;
	public String baseUrl;

	@BeforeSuite()
	public void beforSuite() throws FileNotFoundException, IOException {
		testConfig = new Properties();
		testConfig.load(new FileInputStream("TestConfig.properties"));
	}

	@BeforeMethod
	public void beforeMethod() {

		driver = WebDriverHelper.createDriver(testConfig.getProperty("browser"));
		baseUrl = testConfig.getProperty("baseUrl");
		driver.get(baseUrl);

		loginpage = new LogInPage(driver);

	}

	@DataProvider()
	public Object[][] dataProvider(Method method) {

		DataDrivenHelper ddh = new DataDrivenHelper(testConfig.getProperty("mastertestdatafile"));
		Object[][] testData = ddh.getTestCaseDataSets(testConfig.getProperty("testdatasheet"), method.getName());

		return testData;
	}

	@AfterMethod
	public void afterMethod() {

		WebDriverHelper.quitDriver(driver);
	}
}