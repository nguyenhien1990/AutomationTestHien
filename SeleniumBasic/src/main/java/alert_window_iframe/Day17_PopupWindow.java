package alert_window_iframe;

import java.util.Set;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import automation.common.CommonBase;

public class Day17_PopupWindow extends CommonBase{
	@BeforeTest
	public void openPage()
	{
		driver = initChromeDriver("https://demo.guru99.com/popup.php");
	}
	
	@Test
	public void testPopupWindow()
	{
		click(By.xpath("//a[text()='Click Here']"));
		
		//Save main windown
		String mainwindow = driver.getWindowHandle();
		
		//Get all windown and add to array
		Set<String> windowns = driver.getWindowHandles();
		for(String element : windowns)
		{
			if (!mainwindow.equals(element))
					{
				driver.switchTo().window(element);
				pause(2000);
				System.out.println("Current URL: "+driver.switchTo().window(element).getCurrentUrl());
				type(By.name("emailid"),"testPopup@gmail.com");
				click(By.name("btnLogin"));
				
				String text =driver.findElement(By.xpath("//h2[text()='Access details to demo site.']")).getText();
				Assert.assertEquals(text, "Access details to demo site.");
				
				
					}
		}
		
	}

}
