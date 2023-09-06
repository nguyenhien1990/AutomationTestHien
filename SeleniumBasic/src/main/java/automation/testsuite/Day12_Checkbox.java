package automation.testsuite;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameter;

import automation.common.CommonBase;
import automation.constant.accountConstant;

import org.testng.Assert;

public class Day12_Checkbox extends CommonBase {
	 @BeforeTest
	 @Parameters("testNGBrowser")
	 public void openPage(String browser)
	 {
		 setupDriver(browser);
		 driver.get(accountConstant.webURL4);
	 }
	 //public void openPage() {
	//driver = initChromeDriver("http://demo.seleniumeasy.com/basic-checkbox-demo.html");
	//}

	
	public void handleCheckbox() {
		driver = initChromeDriver("http://demo.seleniumeasy.com/basic-checkbox-demo.html");
		WebElement thisCheckbox = driver.findElement(By.xpath("//div//input[@id='isAgeSelected']"));
		boolean check = thisCheckbox.isSelected();
		if (check == false) {
			thisCheckbox.click();
			System.out.println("Element is selected: " + thisCheckbox.isSelected());
		}
	}
	@Test
	public void handleRadiobutton() {
		driver = initChromeDriver("http://demo.seleniumeasy.com/basic-radiobutton-demo.html");
		WebElement radioMale = driver.findElement(By.xpath("(//input[@type='radio' and @value='Female'])[1]"));
		boolean isSelected = radioMale.isSelected();
		if (isSelected == false) {
			radioMale.click();
			System.out.println("Radio button FeMale is: " + radioMale.isSelected());
		}
		//else
		//{
		//	WebElement radioFemale = driver.findElement(By.xpath("(//input[@type='radio' and @value='Female'])[1]"));
		//	radioFemale.click();
		//	System.out.println("Radio button Female is: " + radioFemale.isSelected());
		//}
		//driver.close();
	}
	
	
	public void handleDropdownList()
	{
		driver = initChromeDriver("http://demo.seleniumeasy.com/basic-select-dropdown-demo.html");
		Select singleSelect = new Select(driver.findElement(By.id("select-demo")));
		System.out.println("Size of dropdown: "+singleSelect.getOptions().size());
		
		WebElement dropDayWeb = driver.findElement(By.id("select-demo"));
		dropDayWeb.click();
		
		singleSelect.selectByVisibleText("Monday");
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		Assert.assertEquals("Monday", singleSelect.getFirstSelectedOption().getText());
		dropDayWeb.click();
	}
	
	
	public void handleMultiCheckbox()
	{
		List<WebElement> listCheckbox = driver.findElements(By.xpath("(//div[@class='panel-body'])[3]//div[@class='checkbox']//input"));
		System.out.println("Số lượng checkbox: " + listCheckbox.size());
		for(int i=0;i<listCheckbox.size();i++)
		{
			System.out.println("Checkbox ở vị trí: " + (i+1) +" được select " + listCheckbox.get(i).isSelected());
			boolean isCheckboxSelected = listCheckbox.get(i).isSelected();
			if (isCheckboxSelected == false)
			{
				listCheckbox.get(i).click();
				pause(2000);
				System.out.println("Checkbox ở vị trí: " + (i+1) +" đã được checked");
			}
		}
		System.out.println("----------------------------------------");
		for(int i=0;i<listCheckbox.size();i++)
		{
			WebElement itemCheckbox = driver.findElement(By.xpath("((//div[@class='panel-body'])[3]//div[@class='checkbox']//input)["+(i+1)+"]"));
			System.out.println(itemCheckbox.isSelected());
		}
	}

}
