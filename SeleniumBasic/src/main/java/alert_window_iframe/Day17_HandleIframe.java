package alert_window_iframe;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import automation.common.CommonBase;

public class Day17_HandleIframe extends CommonBase{
	@BeforeTest
	public void openPage()
	{
		driver = initChromeDriver("https://codestar.vn/");
	}
	
	//@Test(priority=2)
	public void handleIframe()
	{
		System.out.println("iframe total: "+driver.findElements(By.tagName("iframe")).size());
		scrollToElement(By.xpath("//h2[text()='Đội ngũ giảng viên']"));
		driver.switchTo().frame(1);
		type(By.id("account_phone"), "1234567890");
		//click(By.xpath("//button[text()='Gửi ngay']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();",driver.findElement(By.xpath("//button[text()='Gửi ngay']")));
	}
	
	@Test
	public void findIframe1()
	{
		//driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
		//pause(5000);
		int size = driver.findElements(By.tagName("iframe")).size();
		System.out.println("Number of iframe: "+size);
		for (int i=0; i < size; ++i)
		{
			driver.switchTo().frame(i);
			int numberOfIFrame = driver.findElements(By.xpath("//span[text()='Bắt đầu chat']")).size();
			if (numberOfIFrame != 0)
			{
				System.out.println("element can tim o vi tri thu i: "+i);
				return;
			}
			System.out.println("Ko tim thay");
			driver.switchTo().defaultContent();
		}
	}

}
