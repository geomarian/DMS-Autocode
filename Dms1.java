package com.dms.test;
import java.security.SecureRandom;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.By;  
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
/**
 * @author User
 *
 */
/**
 * @author User
 *
 */
public class Dms1 {
	public static WebDriver driver;
	private static final Random generator = new Random();
	public static final String SOURCE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "abcdefghijklmnopqrstuvwxyz";
	public static final String SOURCE1 = "0123456789";
	static SecureRandom secureRnd = new SecureRandom();
	public static void main(String[] args) {
		// System Property for Chrome Driver
        System.setProperty("webdriver.chrome.driver", "F:\\sandesh velhal\\chromedriver.exe");  
        //System.setProperty("webdriver.gecko.driver","F:\\sandesh velhal\\geckodriver.exe");
        driver=new ChromeDriver();
        //Instantiate a ChromeDriver class.     
        login();
        profile();
        //dash();
        /*catlogues();
        users();
        email();
        question();
        */
       logout();     
	}
	
	//login
	public static void login()
	{
        driver.get("https://dms.chemrtu.com/manage/");
		driver.manage().window().maximize();
		driver.findElement(By.name("email")).sendKeys("milind.mandavkar@gadreinfotech.com");
		driver.findElement(By.name("password")).sendKeys("password");
		driver.findElement(By.name("submit")).click();
		sleep();
	}
	//dashboard
	public static void dash()
	{
		driver.findElement(By.xpath("/html/body/div[6]/div[2]/div[1]/div/div[1]/div/a/span[1]")).click();//catlogues
		sleep();
		driver.findElement(By.xpath("/html/body/nav[1]/div/ul/li[1]/a/span")).click();//dashboard
		sleep();
		driver.findElement(By.xpath("/html/body/div[6]/div[2]/div[1]/div/div[2]/div/div[1]/a/span[1]")).click();//publish
		sleep();
		driver.findElement(By.xpath("/html/body/nav[1]/div/ul/li[1]/a/span")).click();//dashboard
		sleep();
		driver.findElement(By.xpath("/html/body/div[6]/div[2]/div[1]/div/div[2]/div/div[2]/a/span[1]")).click();//unpublish
		sleep();
		driver.findElement(By.xpath("/html/body/nav[1]/div/ul/li[1]/a/span")).click();//dashboard
		sleep();
			
		driver.findElement(By.xpath("/html/body/div[6]/div[2]/div[2]/div/div[1]/div")).click();//users
		sleep();
		driver.findElement(By.xpath("/html/body/nav[1]/div/ul/li[1]/a/span")).click();//dashboard
		sleep();
		driver.findElement(By.xpath("/html/body/div[6]/div[2]/div[2]/div/div[2]/div/div[1]/a/span[1]")).click();//active
		sleep();
		driver.findElement(By.xpath("/html/body/nav[1]/div/ul/li[1]/a/span")).click();//dashboard
		sleep();
		driver.findElement(By.xpath("/html/body/div[6]/div[2]/div[2]/div/div[2]/div/div[2]/a/span[1]")).click();//pending
		sleep();
		driver.findElement(By.xpath("/html/body/nav[1]/div/ul/li[1]/a/span")).click();//dashboard
		sleep();
		driver.findElement(By.xpath("//span[contains(text(),'Delete')]")).click();//Delete
		sleep();
		driver.findElement(By.xpath("/html/body/nav[1]/div/ul/li[1]/a/span")).click();//dashboard
		sleep();
		driver.findElement(By.xpath("/html/body/div[6]/div[2]/div[2]/div/div[2]/div/div[3]/a/span[1]")).click();//inactive
		sleep();
		driver.findElement(By.xpath("/html/body/nav[1]/div/ul/li[1]/a/span")).click();//dashboard
		sleep(); 
	}
	
	//catlogues (add multiple names)
	private static void catlogues() {
		driver.findElement(By.xpath("/html/body/div[6]/div[2]/div[1]/div/div[1]/div/a/span[1]")).click();//catlogues
		sleep();
		//filter
		String[] status = {"All", "Unpublished","Published"};
		String[] user_uid = {"All", "Milind Mane","Chris Turner"};
		for(int i=0; i<3; i++)
		{
			for(int j=0; j<3; j++)
			{
				driver.findElement(By.name("status")).sendKeys(status[i]);
				driver.findElement(By.name("user_uid")).sendKeys(user_uid[j]);
				driver.findElement(By.name("search")).click();
				sleep();
			}
		}
	//OR below code is for filter
		
	/*Select select1 = new Select(driver.findElement(By.xpath("//select[@name='status']")));
	List<WebElement> list1 = select1.getOptions();
	Select select2 = new Select(driver.findElement(By.xpath("//select[@name='user_uid']")));
	List<WebElement> list2 = select2.getOptions();
	try {
		for(WebElement we1:list1)
		{
			for(WebElement we2:list2)
			{
				System.out.println("Test");
				driver.findElement(By.xpath("//select[@name='status']")).sendKeys(we1.getText());
				sleep();
				System.out.println("Test");
				driver.findElement(By.xpath("//select[@name='user_uid']")).sendKeys(we2.getText());
				driver.findElement(By.xpath("/html[1]/body[1]/div[6]/div[2]/div[1]/div[1]/div[1]/form[1]/div[3]/button[1]")).click();
				sleep();
			}
		}
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		driver.quit();
	}
		 */
		
		//Add catlogues
		
		driver.findElement(By.xpath("/html/body/div[6]/div[2]/div[1]/div/div/button")).click();//add catlogues
		driver.findElement(By.xpath("//input[@id='title']")).sendKeys("SOFTWARE TESTING is defined as an activity to check whether the actual results match the expected results and to ensure that the software system is Defect free.");
		driver.findElement(By.name("description")).sendKeys("SOFTWARE TESTING is defined as an activity to check whether the actual results match the expected results and to ensure that the software system is Defect free. It involves execution of a software component or system component to evaluate one or more properties of interest.");
		//driver.findElement(By.xpath("//input[@placeholder='Select Admin']")).sendKeys("Jio mariaan");
		//driver.findElement(By.xpath("//input[@placeholder='Select Admin']")).click();
		Select cadmin = new Select(driver.findElement(By.xpath("//input[@placeholder='Select Admin']")));
		cadmin.selectByVisibleText("Jio mariaan");
		//cadmin.selectByIndex(1); */
		
		//driver.findElement(By.xpath("//*[@id=\"catalogue-form\"]/div[2]/button[1]")).click();
		
		
		//driver.findElement(By.xpath("/html/body/nav[1]/div/ul/li[1]/a/span")).click();//dashboard
		driver.findElement(By.xpath("//span[contains(text(),'Excel')]")).click();
		sleep();
		driver.findElement(By.xpath("//span[contains(text(),'PDF')]")).click();
		sleep();
		driver.findElement(By.xpath("//span[contains(text(),'Print')]")).click();
		sleep();
		driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys("gipl");
		sleep();
		
		//manual catlogue entries
		driver.findElement(By.xpath("/html/body/div[6]/div[2]/div[1]/div/div[1]/div/a/span[1]")).click();//catlogues
		sleep();
		driver.findElement(By.xpath("//a[contains(text(),'GIPL-TESTER')]")).click();
		sleep(); 
		driver.findElement(By.xpath("//a[@id='file-tab']")).click();
		sleep();
		
		//addfolder manual
		driver.findElement(By.xpath("//button[@class='btn btn-info add-folder-btn']")).click();
		sleep();
		driver.findElement(By.xpath("//input[@id='folder-title']")).sendKeys("testing");
		sleep();
				driver.findElement(By.xpath("//textarea[@id='add-folder-description']")).sendKeys("testing");
				sleep();
				driver.findElement(By.xpath("//div[@id='add-folder-modal']//div[3]//div[1]//div[1]")).click();
				sleep();
				driver.findElement(By.xpath("//button[@name='submit']")).click();
				sleep();
				
		//add file manual
				driver.findElement(By.xpath("//a[@class='btn btn-info']")).click();
				sleep();
				driver.findElement(By.xpath("//input[@id='file-title']")).sendKeys("testing");
				sleep(); 
				driver.findElement(By.xpath("//input[@placeholder='Enter reference code']")).sendKeys("01");
				sleep();
				driver.findElement(By.xpath("//textarea[@name='description']")).sendKeys("testing");
				sleep();
				//pdf upload
				driver.findElement(By.xpath("//label[contains(text(),'Upload PDF')]")).click();
				sleep();
				driver.findElement(By.xpath("//div[@class='form-group panel-block pdf-block']//span[@class='custom-file-control form-control'][contains(text(),'Choose file...')]")).click();
				sleep();
				
				//create document
				driver.findElement(By.xpath("//div[contains(@class,'col-sm-6')]//div//label[2]")).click();
				sleep();
				driver.findElement(By.xpath("//div[contains(@class,'note-editable')]")).sendKeys("testing");
				sleep();
				
				driver.findElement(By.xpath("//option[contains(text(),'Unpublished')]")).click();
				sleep();
				driver.findElement(By.xpath("//button[@id='file-submit-btn']")).click();
				sleep(); 
				
				driver.findElement(By.xpath("//a[@id='basic-details-tab']")).click();
				sleep();
				driver.findElement(By.xpath("//a[@id='tree-file-tab']")).click();
				sleep();
	}

	//User 
	private static void users() {
		driver.findElement(By.xpath("/html/body/div[6]/div[2]/div[2]/div/div[1]/div/a/span[1]")).click();//users
		
		//filter
		Select select1 = new Select(driver.findElement(By.xpath("//select[@id='status-drpdown']")));
		List<WebElement> list1 = select1.getOptions();
		Select select2 = new Select(driver.findElement(By.xpath("//select[@id='role-drpdown']")));
		List<WebElement> list2 = select2.getOptions();
		for(WebElement we1:list1)
		{
			for(WebElement we2:list2)
			{
				driver.findElement(By.name("status")).sendKeys(we1.getText());
				driver.findElement(By.name("role")).sendKeys(we2.getText());
				driver.findElement(By.xpath("/html/body/div[6]/div[2]/div[1]/div/div/div[3]/button")).click();
				sleep();
			}
		}
		
		//add multiple user
		driver.findElement(By.xpath("/html/body/div[6]/div[2]/div[2]/div/div[1]/div/a/span[1]")).click();//users 
		sleep();
		driver.findElement(By.xpath("/html/body/div[6]/div[1]/div/div[2]/a")).click();//add user
		sleep();sleep();sleep();sleep();
		for(int i=0;i<2;i++) //will add two users
		{
		String alpha1 = randomString(4); //with 4 character
		driver.findElement(By.xpath("//input[@placeholder='Enter Full Name']")).sendKeys(alpha1);
		sleep();
		String alpha2 = randomString(4);//with 4 character
	    String alpha3 = randomString1(2);//with 2 numbers
		driver.findElement(By.xpath("//input[@placeholder='Enter Email']")).sendKeys(alpha2+alpha3+"@mailinator.com");
		sleep();
		//dropdown selection
		Select select = new Select(driver.findElement(By.xpath("//select[@id='role-drpdown']")));
		List<WebElement> list = select1.getOptions();
		for(WebElement we1:list)
		{
			if(we1.getText()=="Business User")
			{
				driver.findElement(By.xpath("//select[@id='role-drpdown']")).sendKeys(we1.getText());
				String alpha = randomString(4);
				sleep();
				driver.findElement(By.name("organisation")).sendKeys(alpha);
				sleep();
				driver.findElement(By.name("submit")).click();
			}
			else
			{
				driver.findElement(By.xpath("//select[@id='role-drpdown']")).sendKeys(we1.getText());
				driver.findElement(By.name("submit")).click();
				sleep();
			}
		}
		sleep();
		}
		
		driver.findElement(By.xpath("/html/body/nav[1]/div/ul/li[1]/a/span")).click();//will navigate to dashboard
		sleep();
		
	}

	//Emailtemplete
	private static void email() {
		driver.findElement(By.xpath("/html/body/nav[1]/div/ul/li[4]/a")).click();//emailtemplete
		sleep();
		driver.findElement(By.xpath("/html/body/div[6]/div[2]/div/div/div[1]/a")).click();
		sleep();
		driver.findElement(By.xpath("/html/body/nav[1]/div/ul/li[4]/a")).click();//emailtemplete
		sleep();
		driver.findElement(By.xpath("/html/body/div[6]/div[2]/div/div/div[2]/a")).click();
		sleep();
		driver.findElement(By.xpath("/html/body/nav[1]/div/ul/li[4]/a")).click();//emailtemplete
		sleep();
		driver.findElement(By.xpath("/html/body/div[6]/div[2]/div/div/div[3]/a")).click();
		sleep();
		driver.findElement(By.xpath("/html/body/nav[1]/div/ul/li[4]/a")).click();//emailtemplete
		sleep();
		driver.findElement(By.xpath("/html/body/div[6]/div[2]/div/div/div[4]/a")).click();
		sleep();
		driver.findElement(By.xpath("/html/body/nav[1]/div/ul/li[4]/a")).click();//emailtemplete
		sleep();
		driver.findElement(By.xpath("/html/body/nav[1]/div/ul/li[1]/a/span")).click();//dashboard
		sleep();
	}

	//Question group
	private static void question() {
		driver.findElement(By.xpath("/html/body/nav[1]/div/ul/li[5]/a/span")).click();
		driver.findElement(By.xpath("/html/body/div[6]/div[1]/div/div[2]/button[1]")).click();//Question Group
		driver.findElement(By.name("title")).sendKeys("imp");	
		driver.findElement(By.name("status")).sendKeys("Active");
		driver.findElement(By.name("submit")).click();
		sleep();
				
		driver.findElement(By.xpath("//html/body/div[6]/div[1]/div/div[2]/button[2]")).click();//bulk upload
		driver.findElement(By.xpath("//*[@id=\"que-upload-form\"]/div[1]/div/div/div/label[2]/span")).click();
		sleep();
				
		driver.findElement(By.xpath("/html/body/div[6]/div[1]/div/div[2]/a")).click();//sample download
				
		driver.findElement(By.xpath("/html/body/nav[1]/div/ul/li[1]/a/span")).click();//dashboard
		sleep();
	}


	//profile
	private static void profile() {
		driver.findElement(By.xpath("//a[@class='dropdown-toggle']")).click();
		driver.findElement(By.xpath("//span[contains(text(),'Profile')]")).click();
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

	//logout
	private static void logout() {
		driver.findElement(By.xpath("//a[@class='dropdown-toggle']")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Logout')]")).click();
	}
	
	//alphabate sequence generator
	public static String randomString(int length) {
	    StringBuilder sb = new StringBuilder(length);
	    for (int i = 0; i < length; i++)
	      sb.append(SOURCE.charAt(secureRnd.nextInt(SOURCE.length())));
	    return sb.toString();
	  }
	//number sequence generator
	public static String randomString1(int length) {
	    StringBuilder sb = new StringBuilder(length);
	    for (int i = 0; i < length; i++)
	      sb.append(SOURCE1.charAt(secureRnd.nextInt(SOURCE1.length())));
	    return sb.toString();
	  }
	//Sleep
	public static void sleep()
	{
		try {
		    TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException ie) {
		    Thread.currentThread().interrupt();
		}
	}
}
