package com.rll.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

@Test
public class XAddCartTesting {
	public void XCart() {
		System.setProperty("webdriver.chrome.driver", "D:\\phase 5\\chrome driver\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		//add to cart
		driver.get("http://localhost:4200/home");
		waitForSeconds(1);
		driver.findElement(By.xpath("//button[normalize-space()='Add to Cart']")).click();
		waitForSeconds(2);
		
		//payment
				driver.findElement(By.xpath("//button[normalize-space()='Proceed to Payment']")).click();
				waitForSeconds(1);
				

				driver.findElement(By.name("name")).sendKeys("batch6@gmail.com");
				driver.findElement(By.name("card-num")).sendKeys("123456");
				driver.findElement(By.name("exp")).sendKeys("05/27");
				driver.findElement(By.name("cvv")).sendKeys("123");
				
				driver.findElement(By.xpath("//button[normalize-space()='PAY']")).click();
				waitForSeconds(1);
				driver.switchTo().alert().accept();
				
				//redirect to home page for logout
				driver.get("http://localhost:4200/home");
				waitForSeconds(1);
				driver.findElement(By.xpath("//button[normalize-space()='Logout']")).click();
				
				
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
