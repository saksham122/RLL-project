package com.rll.test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


public class UserTesting {
	@Test
	public void User() {
		System.setProperty("webdriver.chrome.driver", "D:\\phase 5\\chrome driver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
driver.get("http://localhost:4200");
		
		waitForSeconds(2);
		//User SignUp
		
		driver.get("http://localhost:4200/register");
		driver.findElement(By.cssSelector("input[ng-reflect-name=email]")).sendKeys("rgoyal");
		driver.findElement(By.cssSelector("input[ng-reflect-name=password]")).sendKeys("rahul@123");
		driver.findElement(By.cssSelector("input[ng-reflect-name=address]")).sendKeys("kolkata");
		driver.findElement(By.cssSelector("input[ng-reflect-name=mobilenumber]")).sendKeys("1234567892");
		
		driver.findElement(By.className("clearfix")).click();
		  
		  waitForSeconds(2);
		  driver.switchTo().alert().accept(); 
		  waitForSeconds(2);
		  
		//User Login
		driver.get("http://localhost:4200/userlogin");
		driver.findElement(By.cssSelector("input[ng-reflect-name=email]")).sendKeys("rgoyal");
		driver.findElement(By.cssSelector("input[ng-reflect-name=password]")).sendKeys("rahul@123");
		
		driver.findElement(By.xpath("//button[normalize-space()='Log In']")).click();
		  
		  waitForSeconds(2);
		  driver.switchTo().alert().accept(); 
		  waitForSeconds(1);
		
		  
  }
		  
		
		  private void waitForSeconds(int sec) {
			  try {
			   Thread.sleep(sec*1000);
			  } catch (InterruptedException e) {
			   // TODO Auto-generated catch block
			   e.printStackTrace();
			  }
	}
		
		
		
	

}
