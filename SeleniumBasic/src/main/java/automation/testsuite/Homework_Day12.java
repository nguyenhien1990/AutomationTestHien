package automation.testsuite;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import automation.common.CommonBase;

public class Homework_Day12 extends CommonBase{
	@BeforeTest
	public void openPage()
	{
		driver = initChromeDriver("http://demo.seleniumeasy.com/input-form-demo.html");
	}
	
	@Test
	public void handleSelect()
	{
		//Handle Dropdown
		Select singleSelect = new Select(driver.findElement(By.name("state")));
		System.out.println("Size của dropdown: "+singleSelect.getOptions().size());
		WebElement dropdownSelect = driver.findElement(By.name("state"));
		dropdownSelect.click();
		singleSelect.selectByIndex(3);
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		Assert.assertEquals("Arizona", singleSelect.getFirstSelectedOption().getText());
		dropdownSelect.click();
		
		//Handle Checkbox
		WebElement checkNo = driver.findElement(By.xpath("(//input[@name='hosting'])[2]"));
		boolean isSelected = checkNo.isSelected();
		if (isSelected == false)
		{
			checkNo.click();
			System.out.println("No được select: "+checkNo.isSelected());
		}
		
	}

}
