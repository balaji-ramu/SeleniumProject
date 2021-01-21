package com.testing.one;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class loginLogout {
	
	

	public static void main(String[] args) throws IOException  {


		FileInputStream fis = new FileInputStream(".\\configuration\\config.properties");
		Properties prop = new Properties();
		prop.load(fis);
		
		System.setProperty("webdriver.chrome.driver",prop.getProperty("Path"));
		WebDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		
		
		driver.manage().window().maximize();
		driver.get(prop.getProperty("URL"));
		
		
		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS) ;
	
		driver.findElement(By.xpath("//a[text()='Login']")).click();
		
		
		driver.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS) ;
		driver.findElement(By.xpath("/html/body/div/div[2]/div/button")).click();
		
		
		driver.findElement(By.id("email")).sendKeys(prop.getProperty("UserName"));
		driver.findElement(By.id("password")).sendKeys(prop.getProperty("Pwd"));
		
		driver.findElement(By.tagName("button")).click();
		
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS) ;
		
		driver.findElement(By.xpath("//*[@id=\"menuLinks-avatar\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div[2]/div/a[2]")).click();
		
		System.out.println("\n Logout is successful");
		
		
		
		
	

		
	
	}
	}
