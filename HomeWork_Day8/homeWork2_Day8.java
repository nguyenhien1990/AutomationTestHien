package automation.testsuite;

import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import automation.common.CommonBase;

public class homeWork2_Day8 extends CommonBase{
	@BeforeTest
	public void openPage()
	{
		driver = initChromeDriver("https://automationfc.github.io/basic-form/index.html");
	}
	
	@Test
	public void findName()
	{
		driver.findElement(By.id("name"));
		System.out.println("Found Name by ID");
		driver.findElement(By.name("name"));
		System.out.println("Found Name by name");
		//driver.findElement(By.linkText("Name:"));
		//System.out.println("Found Name by link text");
	}
	
	@Test
	public void findAddress()
	{
		driver.findElement(By.id("address"));
		System.out.println("Found Address by ID");
		driver.findElement(By.name("address"));
		System.out.println("Found Address by name");
		//driver.findElement(By.linkText("Address:"));
		//System.out.println("Found Address by linkText");
	}
	
	@Test
	public void findEmail()
	{
		driver.findElement(By.id("email"));
		System.out.println("Found Email by ID");
		driver.findElement(By.name("email"));
		System.out.println("Found Email by name");
	}
	
	@Test
	public void findPassword()
	{
		driver.findElement(By.id("password"));
		System.out.println("Found Password by ID");
		driver.findElement(By.name("password"));
		System.out.println("Found Password by name");
	}
	
	@AfterTest
	public void closePage()
	{
		driver.close();
	}

}
