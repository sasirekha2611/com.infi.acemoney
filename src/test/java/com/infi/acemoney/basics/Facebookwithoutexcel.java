package com.infi.acemoney.basics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Facebookwithoutexcel {
	
	WebDriver driver;
	@BeforeTest
	public void setup()
	{
		WebDriverManager.firefoxdriver().setup();
		driver=new FirefoxDriver();
		driver.get("http://www.fb.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	@Test
	public void verifyTitle()
	{
		String actualtitle=driver.getTitle();
		Assert.assertEquals(actualtitle, "Facebook – log in or sign up");
	}
	
	@Test(dataProvider = "s1")
	public void login(String username, String password) throws InterruptedException
	{
		driver.findElement(By.id("email")).clear();
		driver.findElement(By.id("pass")).clear();
		driver.findElement(By.id("email")).sendKeys(username);
		Thread.sleep(3000);
		driver.findElement(By.id("pass")).sendKeys(password);
		Thread.sleep(3000);
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
	}

	@DataProvider(name="s1")
	public Object[][] getData()
	{
		Object[][] obj=new Object[3][2]; //0,1,2   //0,1
		
		obj[0][0]="admin";
		obj[0][1]="admin@123";
		
		obj[1][0]="user1";
		obj[1][1]="pass1";
		
		obj[2][0]="user2";
		obj[2][1]="pass2";
		
		return obj;
	}


}
