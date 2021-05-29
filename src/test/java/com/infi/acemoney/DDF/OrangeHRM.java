package com.infi.acemoney.DDF;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class OrangeHRM {
	WebDriver driver;
	
	@BeforeTest
	public void setUp()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\DELL\\Downloads\\Selenium Backups\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	}
	
	@Test (priority=1, dataProvider = "s1")
	public void login(String username, String password) throws InterruptedException
	{
		driver.findElement(By.id("txtUsername")).sendKeys(username);
		
		driver.findElement(By.id("txtPassword")).sendKeys(password);
		
		driver.findElement(By.id("btnLogin")).click();
		
		Thread.sleep(3000);
		
		driver.findElement(By.id("welcome")).click();
		
		driver.findElement(By.xpath("//a[text()='Logout']")).click();
		
		Thread.sleep(3000);
	}
	
	@AfterTest
	public void close()
	{
		driver.close();
	}
	
	
	@DataProvider(name="s1")
	public Object[][] data()
	{
		ReadExcel r=new ReadExcel("C:\\Users\\DELL\\Desktop\\DDF.xlsx");
		
		int excelrows=r.totalrows("Sheet3");
		
		int excelcols=r.totalcolumns("Sheet3");
		
		Object[][] obj=new Object[excelrows][excelcols];
		
		for(int i=0; i<excelrows; i++)
		{
			for(int j=0; j<excelcols; j++)
			{
				obj[i][j]=r.getData("Sheet3", i, j);
			}
		}
		
		return obj;
	}
	
	
	

}
