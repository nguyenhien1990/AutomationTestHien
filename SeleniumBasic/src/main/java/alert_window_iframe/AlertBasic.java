package alert_window_iframe;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import automation.common.CommonBase;

public class AlertBasic extends CommonBase{
	@BeforeTest
	public void openPage()
	{
		driver = initChromeDriver("https://demo.guru99.com/test/delete_customer.php");
	}
	
	@Test
	public void TestAlert()
	{
		driver.findElement(By.name("cusid")).sendKeys("12345");
		driver.findElement(By.name("submit")).click();
		pause(2000);
		Alert alert = driver.switchTo().alert();
		String alertMsg = driver.switchTo().alert().getText();
		System.out.println(alertMsg);
		assertEquals(alertMsg, "Do you really want to delete this Customer?");
		pause(2000);
		driver.switchTo().alert().accept();
		String actualMsg = driver.switchTo().alert().getText();
		System.out.println(actualMsg);
		assertEquals(actualMsg, "Customer Successfully Delete!");
		pause(2000);
		driver.switchTo().alert().accept();
	}

}
