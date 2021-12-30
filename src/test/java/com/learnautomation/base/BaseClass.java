package com.learnautomation.base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.learnautomation.factory.BrowserFactory;

public class BaseClass

{
	public WebDriver driver;
	
	public WebDriver getDriver() {
		return driver;
	}
	
	@AfterClass
	public void closeBrowser() 
	{
		System.out.println("***** Closing Session *****");
		driver.quit();
		System.out.println("***** Session Closed *****");
	}
	//use this approach only when you have to make changes while running test
	@Parameters({"Browser","url"})
	@BeforeClass
	public WebDriver startBrowser(String browser,String url) {
		 driver = BrowserFactory.startBrowser(browser, url);
		System.out.println("Driver value is "+driver);
		return driver;
	}
	
	
	
	 /* @BeforeClass public WebDriver startBrowser() {
	  
	  System.out.println("***** Strating Session *****"); String browser =
	  ConfigReader.getBrowser(); String url = ConfigReader.getURL(); if
	 (browser.equalsIgnoreCase("Chrome")) {
	  WebDriverManager.chromedriver().setup(); driver = new ChromeDriver(); } else
	  if (browser.equalsIgnoreCase("Firefox") || browser.equalsIgnoreCase("FF")) {
	 
	 try { WebDriverManager.firefoxdriver().setup(); } catch (Error e) {
	 System.out.println("Failed to download driver automatically: " +
	  e.getMessage()); System.getProperty("webdriver.gecko.driver",
	  System.getProperty("user.dir") + "/Driver/geckodriver.exe"); } driver = new
	 FirefoxDriver(); } else if (browser.equalsIgnoreCase("Edge")) {
	 WebDriverManager.edgedriver().setup(); driver = new EdgeDriver(); } else {
	 System.out.println("Sorry -Only Chrome,FF,Edge is supported for execution");
	 } driver.manage().window().maximize();
	 driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
	 driver.get(url);
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	  System.out.println("***** Session Strated *****"); return driver; }
	 */
}
