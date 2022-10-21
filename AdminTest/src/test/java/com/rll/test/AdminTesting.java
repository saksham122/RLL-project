package com.rll.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class AdminTesting {

	@Test
	public void Admin() {
		System.setProperty("webdriver.chrome.driver", "D:\\phase 5\\chrome driver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		
		driver.manage().window().maximize();
		
		
		driver.get("http://localhost:4200");
		waitForSeconds(2);
		
		//Admin login
		
		driver.get("http://localhost:4200/adminregister");
		
		
		driver.findElement(By.cssSelector("input[ng-reflect-name=email]")).sendKeys("admin");
		driver.findElement(By.cssSelector("input[ng-reflect-name=password]")).sendKeys("Admin@123");
		
		driver.findElement(By.xpath("//button[normalize-space()='Register']")).click();
		
		waitForSeconds(2);
		driver.switchTo().alert().accept(); 
		waitForSeconds(1);
		
		
		//admin login
		driver.findElement(By.cssSelector("input[ng-reflect-name=email]")).sendKeys("admin");
		driver.findElement(By.cssSelector("input[ng-reflect-name=password]")).sendKeys("Admin@123");
		
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
		
		waitForSeconds(2);
		driver.switchTo().alert().accept(); 
		waitForSeconds(1);
		
		
		//Add food
		driver.findElement(By.xpath("//button[normalize-space()='Add FOOD']")).click();
		
		waitForSeconds(2);
		driver.findElement(By.id("exampleInputEmail1")).sendKeys("Dosa");
		driver.findElement(By.cssSelector("input[ng-reflect-name=category]")).sendKeys("veg");
		driver.findElement(By.cssSelector("input[ng-reflect-name=cuisinename]")).sendKeys("Indian");
		driver.findElement(By.cssSelector("input[ng-reflect-name=description]")).sendKeys("south indian breakfast");
		driver.findElement(By.cssSelector("input[ng-reflect-name=offers]")).sendKeys("5");
		driver.findElement(By.cssSelector("input[ng-reflect-name=price]")).sendKeys("100");
		driver.findElement(By.cssSelector("input[ng-reflect-name=status]")).sendKeys("available");
		
		driver.findElement(By.xpath("//button[normalize-space()='Add']")).click();
		
		waitForSeconds(2);
		driver.switchTo().alert().accept(); 
		waitForSeconds(1);
		
		//edit food
		driver.findElement(By.xpath("//button[normalize-space()='Edit']")).click();
		waitForSeconds(1);
		driver.findElement(By.id("exampleInputEmail1")).sendKeys("Paneer tika");
		driver.findElement(By.cssSelector("input[ng-reflect-name=category]")).sendKeys("veg");
		driver.findElement(By.cssSelector("input[ng-reflect-name=cuisinename]")).sendKeys("Indian");
		driver.findElement(By.cssSelector("input[ng-reflect-name=description]")).sendKeys("north indian receipe");
		driver.findElement(By.cssSelector("input[ng-reflect-name=offers]")).sendKeys("7");
		driver.findElement(By.cssSelector("input[ng-reflect-name=price]")).sendKeys("200");
		driver.findElement(By.cssSelector("input[ng-reflect-name=status]")).sendKeys("available");
		driver.findElement(By.xpath("//button[normalize-space()='Add']")).click();
		
		waitForSeconds(2);
		driver.switchTo().alert().accept(); 
		waitForSeconds(1);
		
		driver.findElement(By.xpath("//button[normalize-space()='Delete']")).click();
		waitForSeconds(1);
		driver.switchTo().alert().accept(); 
		//Add admin
		driver.findElement(By.xpath("//button[normalize-space()='Add Admin']")).click();
		driver.findElement(By.cssSelector("input[ng-reflect-name=email]")).sendKeys("xyz");
		driver.findElement(By.cssSelector("input[ng-reflect-name=password]")).sendKeys("xyz@123");
		driver.findElement(By.xpath("//button[normalize-space()='Register']")).click();
		waitForSeconds(2);
		driver.switchTo().alert().accept(); 
		waitForSeconds(1);
		//Admin login
		driver.findElement(By.cssSelector("input[ng-reflect-name=email]")).sendKeys("admin");
		driver.findElement(By.cssSelector("input[ng-reflect-name=password]")).sendKeys("Admin@123");
		
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
		
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
