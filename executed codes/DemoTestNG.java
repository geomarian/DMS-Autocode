package com.testn.demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DemoTestNG {
	public static WebDriver driver;
	@Test(priority=1)
	  public static void Connection() {
		  System.out.println("test start A");
		  System.setProperty("webdriver.chrome.driver", "E:\\eclipse1\\Demo testng\\chromedriver.exe"); 
		  driver=new ChromeDriver();
	  }
	@Test(priority=2)
	public static void login()
	{
        driver.get("https://dms.chemrtu.com/manage/");
		driver.manage().window().maximize();
		driver.findElement(By.name("email")).sendKeys("milind.mandavkar@gadreinfotech.com");
		driver.findElement(By.name("password")).sendKeys("password");
		driver.findElement(By.name("submit")).click();
		sleep();
	}
	@Test(priority=3)
	private static void profile() {
		driver.findElement(By.xpath("//a[@class='dropdown-toggle']")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Profile')]")).click();
		sleep();
		//basic details
		driver.findElement(By.xpath("//a[contains(text(),'Basic Details')]")).click();
		driver.findElement(By.xpath("//input[@id='full_name']")).sendKeys("Milind Mane");
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("milind.mandavkar@gadreinfotech.com");
		driver.findElement(By.xpath("//form[@id='profile-form']//button[@name='submit'][contains(text(),'Update')]")).click();
		sleep();
		
		//Change password
		driver.findElement(By.xpath("//a[contains(text(),'Change Password')]")).click();
		sleep();
		driver.findElement(By.xpath("//button[@id='file-submit-btn']")).click();
		sleep();
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("password");
		driver.findElement(By.xpath("//input[@id='new_password']")).sendKeys("password");
		driver.findElement(By.xpath("//input[@id='confirm_password']")).sendKeys("password");
		driver.findElement(By.xpath("//button[@id='file-submit-btn']")).click();
		sleep();
		driver.findElement(By.xpath("/html/body/nav[1]/div/ul/li[1]/a/span")).click();//dashboard
		sleep();
	}
	@Test(priority=4)
	private static void logout() {
		driver.findElement(By.xpath("//a[@class='dropdown-toggle']")).click();
		sleep();
		sleep();
		driver.findElement(By.xpath("//a[contains(text(),'Logout')]")).click();
	}
	@BeforeTest
	public void beforeTest() {
		System.out.println("Before Test");
	}

	@AfterTest
	public void afterTest() {
		System.out.println("After Test");
	}
	  
	public static void sleep()
	{
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException ie) {
		    Thread.currentThread().interrupt();
		}
	}
}