package alert_window_iframe;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import automation.common.CommonBase;

public class AlertSendKey extends CommonBase{
	@BeforeTest
	public void openPage()
	{
		driver = initChromeDriver("https://demo.automationtesting.in/Alerts.html");
	}
	
	@Test
	public void textAlert()
	{
		driver.findElement(By.xpath("//a[normalize-space()='Alert with Textbox']")).click();
		pause(2000);
		driver.findElement(By.xpath("//button[normalize-space()='click the button to demonstrate the prompt box']")).click();
		driver.switchTo().alert().sendKeys("Thu Hien");
		pause(2000);
		driver.switchTo().alert().accept();
		WebElement element = getElementPresentDOM(By.id("demo1"));
		String actualAlert = element.getText();
		assertEquals(actualAlert, "Hello Thu Hien How are you today");
	}

}
