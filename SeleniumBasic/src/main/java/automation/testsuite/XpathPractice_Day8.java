package automation.testsuite;

import org.openqa.selenium.By;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import automation.common.CommonBase;

public final class XpathPractice_Day8 extends CommonBase{
	@BeforeMethod
	public void openPage()
	{
		driver = initChromeDriver("https://selectorshub.com/xpath-practice-page/");
	}
	
	public void findByID()
	{
		driver.findElement(By.id("email"));
		System.out.println("Found element email");
		driver.findElement(By.id("password"));
		System.out.println("Found element password");
	}
	
	public void findByName()
	{
		driver.findElement(By.name("email"));
		System.out.println("Found element email by name");
		driver.findElement(By.name("password"));
		System.out.println("Found element password by name");
	}
	//Máy Hút Mùi Ống Khói
	@Test
	public void findByLinkText()
	{
		driver.findElement(By.linkText("Máy Hút Mùi Ống Khói"));
		System.out.println("Found element ống khói by linktext");
		driver.findElement(By.partialLinkText("Ống Khói"));
		System.out.println("Found element ống khói by partialtext");
		//Tìm element có text "Máy Hút Mùi Cổ Điển"
		driver.findElement(By.linkText("Máy Hút Mùi Cổ Điển"));
		System.out.println("Found element cổ điển by linktext");
	}
	
	public void findByClassTabName()
	{
		driver.findElement(By.className("cursor-pointer"));
		System.out.println("Found element checkbox england by classname");
		driver.findElement(By.tagName("input"));
		System.out.println("Found element input by tag name");
	}
	
	//https://selectorshub.com/xpath-practice-page/
	public void findElement()
	{
		driver.findElement(By.id("userId"));
		
		//driver.findElement(By.name("))
	}
	
	@AfterTest
	public void quitDriver()
	{
		driver.close();
	}

}
