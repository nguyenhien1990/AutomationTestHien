package alert_window_iframe;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import automation.common.CommonBase;

public class Day17_Homework1 extends CommonBase{
	@BeforeTest
	public void openPage()
	{
		driver = initChromeDriver("https://codestar.vn/");
	}
	
	@Test 
	public void switchIFrameChat()
	{
		//By iFrame = By.xpath("//span[text()='Bắt đầu chat']");
		//boolean wait = isElementPresent(iFrame);
		pause(10000);
		//scrollToElement(By.xpath("//span[text()='Bắt đầu chat']"));
		driver.switchTo().frame(5);
		click(By.xpath("//span[text()='Bắt đầu chat']"));
		
		String confirm = driver.findElement(By.xpath("//div[text()='Đăng nhập']")).getText();
		Assert.assertEquals(confirm, "Đăng nhập");
		pause(3000);
	}
	
	@AfterTest
	public void close()
	{
		driver.close();
	}
	
	

}
