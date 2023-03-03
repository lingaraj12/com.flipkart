package com.flipKart;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class testScript {


	@Test
	public void testcase() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.flipkart.com/");
		driver.manage().window().maximize();
		System.out.println("launch the flipkart url");
		driver.findElement(By.name("q")).sendKeys("ipad");
		System.out.println("enter the ipad keyword in search bar");
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		Reporter.log("navigate to ipad page");
		System.out.println("navigate homepage to ipad page");
		Thread.sleep(4000);
		driver.findElement(By.xpath("(//div[@class='_2gmUFU _3V8rao'])")).click();
		Thread.sleep(2000);
		//selecting price feature in filter 
		WebElement element= driver.findElement(By.tagName("select"));
		Select select=new Select(element);
		select.selectByValue("20000");
		Reporter.log("select the min 20000 price in filter features");
		System.out.println("select the min 20000 price in filter features");
		//handeling the windows
		String parentwindow=driver.getWindowHandle();
		System.out.println("parent window :" +parentwindow);
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//div[contains(text(),'APPLE iPad (9th Gen) 64 GB')])[1]")).click();
		System.out.println("navigate to pdp page");
		Thread.sleep(2000);
		Set<String>childwindow=driver.getWindowHandles();
		for(String str:childwindow) {
			if(!str.equals(parentwindow)) {
				Thread.sleep(4000);
				driver.switchTo().window(str).getTitle();
				System.out.println("child :" + str);
				driver.findElement(By.xpath("//button[text()='Buy Now']")).click();
				System.out.println("navigate to checkout page");
				Thread.sleep(2000);
				driver.findElement(By.xpath("//input[@autocomplete='off']")).sendKeys("flipkart123@gmail.com");
				System.out.println("enter mail id flipkart123@gmail.com");
				Thread.sleep(2000);
				driver.findElement(By.xpath("//span[text()='CONTINUE']")).click();
				Thread.sleep(2000);
				System.out.println("enter the random otp 123456");
				driver.findElement(By.xpath("//input[@autocomplete='on']")).sendKeys("123456");
                driver.quit();
			}
		}

	}
















}
