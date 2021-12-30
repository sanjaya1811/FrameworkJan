package com.learnautomation.testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.learnautomation.base.BaseClass;
import com.learnautomation.dataprovider.DataGenerators;
import com.learnautomation.pages.LoginPage;
import com.learnautomation.pages.Logout;

public class LoginTest extends BaseClass {
	
	WebDriver driver;
	
	@BeforeMethod
	public void setup() 
	{
		driver=getDriver();
	}

	@Test(priority =1,description="Validaing admin login functionality",dataProviderClass =DataGenerators.class,dataProvider="Login")
	public void adminLoginTest (String username,String password)
	{
		
		LoginPage login = PageFactory.initElements(driver,LoginPage.class);
		String url =login.loginApplication(username,password);
		Assert.assertTrue(url.contains("dashboard"));
		
	}
	
	@Test(priority=2,dependsOnMethods="adminLoginTest",description="Validaing admin logout functionality")
	public void logoutTest() 
	{
		Logout logout =PageFactory.initElements(driver,Logout.class);
		Assert.assertTrue(logout.logoutFromApplication().contains("login1111"));
	}
}
