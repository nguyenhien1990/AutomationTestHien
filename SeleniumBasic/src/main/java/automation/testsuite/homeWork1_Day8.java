package automation.testsuite;

import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import automation.common.CommonBase;

public final class homeWork1_Day8 extends CommonBase {
	
	@BeforeTest
	public void openPage()
	{
		driver = initChromeDriver("https://selectorshub.com/xpath-practice-page/");
	}
	
	
	public void findByID()
	{
		driver.findElement(By.id("userId"));
		System.out.println("Found User Email by ID");
		driver.findElement(By.id("pass"));
		System.out.println("Found Password by ID");	
	}
	
	
	public void findByName()
	{
		driver.findElement(By.name("email"));
		System.out.println("Found User Email by name");
		driver.findElement(By.name("Password"));
		System.out.println("Found Password by name");
		driver.findElement(By.name("company"));
		System.out.println("Found Company by name");
		driver.findElement(By.name("mobile number"));
		System.out.println("Found Mobile Number by name");
	}
	
	
	public void findByLinkText()
	{
		//driver.findElement(By.linkText("Company"));
		//System.out.println("Found Company by linktext");
		driver.findElement(By.linkText("Mobile Number"));
		System.out.println("Found Mobile Number by linktext");
	}
	
	
	public void findByPartialLinkText()
	{
		//Không tìm thấy do text này ko phải unique
		driver.findElement(By.linkText("Company"));
		System.out.println("Found Company by partiallinktext");
		driver.findElement(By.linkText("Mobile"));
		System.out.println("Found Mobile Number by partiallinktext");
	}
	
	@Test
	public void findByClassName()
	{
		driver.findElement(By.className("selectors-input"));
		System.out.println("Found User Email by class Name");
		driver.findElement(By.className("form-control"));
		System.out.println("Found Mobile Number by class Name");
	}
	
	@AfterTest
	public void quitPage()
	{
		driver.quit();
	}



}
