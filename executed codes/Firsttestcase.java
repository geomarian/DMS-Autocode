//creating excel sheet
package com.wintest;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.SecureRandom;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.winium.DesktopOptions;
import org.openqa.selenium.winium.WiniumDriver;

public class Firsttestcase {
	public static final String SOURCE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	public static final String SOURCE1 = "0123456789";
	static SecureRandom secureRnd = new SecureRandom();
	public static void main (String args[]) throws InterruptedException, MalformedURLException, AWTException
	{
		String[] GST;
		GST = new String[50];
		String s = null;
		DesktopOptions option = new DesktopOptions();
		option.setApplicationPath("C:\\Program Files (x86)\\Microsoft Office\\Office12\\EXCEL.exe");
		WiniumDriver driver = new WiniumDriver(new URL("http://localhost:9999"), option);
		Thread.sleep(5000);
		Robot robot1= new Robot();
		
		driver.findElement(By.id("1001")).click();
		driver.findElement(By.id("1001")).sendKeys("A1");
		robot1.keyPress(KeyEvent.VK_ENTER);
		driver.findElement(By.className("EXCEL<")).sendKeys("Roll No");
		robot1.keyPress(KeyEvent.VK_TAB);
		driver.findElement(By.className("EXCEL<")).sendKeys("Name");
		robot1.keyPress(KeyEvent.VK_TAB);
		driver.findElement(By.className("EXCEL<")).sendKeys("GST");
		robot1.keyPress(KeyEvent.VK_ENTER);
		
		for(int i=0; i<5; i++)
		{
			String seq=null;
			seq=String.format("%02d",i+1);
			driver.findElement(By.className("EXCEL<")).sendKeys(seq);
			Thread.sleep(2000);
			robot1.keyPress(KeyEvent.VK_TAB);
			String alpha5 = randomString(4);
			Thread.sleep(2000);
			driver.findElement(By.className("EXCEL<")).sendKeys(alpha5);
			robot1.keyPress(KeyEvent.VK_TAB);
		
			Thread.sleep(2000);
			Random t = new Random();
			//number
			String s1= (String.format("%02d", t.nextInt(37)));
			//alphabet
			String alpha1 = randomString(5);
			//number
			String alpha =randomString1(4);
			//alphabet
			String alpha2 = randomString(1);
			//number
			String s2= (String.format("%01d", t.nextInt(10)));
			//alphabet
			String alpha3 = randomString(1);
			//number
			String s3= (String.format("%01d", t.nextInt(10)));
			s= s1+alpha1+alpha+alpha2+s2+alpha3+s3;
			
			if(s!=GST[i])
			{
				if(GST[i]==null)
				{
					GST[i]=s;
				}
			}
			driver.findElement(By.className("EXCEL<")).sendKeys(s);
			robot1.keyPress(KeyEvent.VK_ENTER);
		}
		driver.findElement(By.name("Save")).click();
		
		
		/*//radom unique string generator
		 for(int i=0;i<50; i++)
		{
			String alpha2 = randomString1(5);
			if(alpha2!=GST[i])
			{
				if(GST[i]==null)
				{
					GST[i]=alpha2;
				}
			}
		}
		
		for(int i=0;i<GST.length; i++)
		{
			System.out.println(GST[i]);
		}
		 *
		 */

		//driver.quit();
		//String output = driver.findElement(By.id("DateDiffAllUnitsResultLabe")).getAttribute("Name");
		//System.out.println("Result is: "+output);
		
		//Calculator
		/*option.setApplicationPath("C:\\Windows\\System32\\calc.exe");
		driver.findElement(By.name("Seven")).click();
		driver.findElement(By.name("Plus")).click();
		driver.findElement(By.name("Eight")).click();
		driver.findElement(By.name("Equals")).click();
		Thread.sleep(5000);
		String output = driver.findElement(By.id("CalculatorResults")).getAttribute("Name");
		System.out.println("Result after addition is: "+output);
		
		driver.findElement(By.name("Five")).click();
		for(int i=0; i<5;i++)
		{
		driver.findElement(By.name("Maximize")).click();
		driver.findElement(By.name("Restore Calculator")).click();
		String output = driver.findElement(By.id("CalculatorResults")).getAttribute("Name");
		System.out.println("Result is: "+output);
		//driver.close();
		}*/
	}
	public static String randomString(int length) {
	    StringBuilder sb = new StringBuilder(length);
	    for (int i = 0; i < length; i++)
	      sb.append(SOURCE.charAt(secureRnd.nextInt(SOURCE.length())));
	    return sb.toString();
	  }
	public static String randomString1(int length) {
	    StringBuilder sb = new StringBuilder(length);
	    for (int i = 0; i < length; i++)
	      sb.append(SOURCE1.charAt(secureRnd.nextInt(SOURCE1.length())));
	    return sb.toString();
	  }
}
