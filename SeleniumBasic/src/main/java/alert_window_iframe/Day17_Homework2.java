package alert_window_iframe;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import automation.common.CommonBase;

public class Day17_Homework2 extends CommonBase{
	@BeforeTest
	public void openPage()
	{
		driver = initChromeDriver("https://codestar.vn/");
	}
	
	@Test
	public void handleIframeSendDocument()
	{
		driver.switchTo().frame(3);
		type(By.xpath("//input[@name='account_name']"), "nguyen hien");
		type(By.xpath("(//label[text()='Tên khách hàng']/following::input)[2]"), "1234567890");
		((JavascriptExecutor) driver).executeScript("arguments[0].click();",driver.findElement(By.xpath("//button[text()='Đăng ký ngay']")));
		
		
		String confirm = driver.findElement(By.xpath("//button[text()='Đăng ký ngay']")).getText();
		Assert.assertEquals(confirm, "Đăng ký ngay");
		pause(3000);
		//Alert alert = driver.switchTo().alert();
		//String alertMsg = driver.switchTo().alert().getText();
		//System.out.println(alertMsg);
		//assertEquals(alertMsg, "Vui lòng điền vào trường này.");
	}
	@AfterTest
	public void close()
	{
		driver.close();
	}

}
