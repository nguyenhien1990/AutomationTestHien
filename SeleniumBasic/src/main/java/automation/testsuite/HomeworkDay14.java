package automation.testsuite;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import automation.common.CommonBase;
import automation.constant.accountConstant;
import automation.pagelocator.ListCouse;
import automation.pagelocator.SignupFactory;
import automation.pagelocator.UpdateInformation;

public class HomeworkDay14 extends CommonBase{
	@BeforeTest
	public void openPage()
	{
		driver = initChromeDriver(accountConstant.webURL2);
	}
	
	@Test
	public void registerAndUpdateInfor()
	{
		//Register
		SignupFactory register = new SignupFactory(driver);
		register.SingupFunction("Nguyen Van A", "maillogin11@yopmai.com", "Test1234", "0123456789");
		
		//Check register success
		ListCouse success = new ListCouse();
		pause(3000);
		WebElement expected = driver.findElement(success.txtNotify);
		assertTrue(expected.isDisplayed());
		
		//Close popup chat
		//WebElement 
		
		//Search button "Tìm kiếm thông tin"
		WebElement avatar = driver.findElement(By.xpath("//div[@class='avatar2']//img"));
		avatar.click();
		WebElement clickupdateInfor = driver.findElement(By.xpath("//a[normalize-space()='Chỉnh sửa thông tin']"));	
		clickupdateInfor.click();
		
		//Update password
		pause(1000);
		UpdateInformation updateInfor = new UpdateInformation(driver);
		updateInfor.UpdateNewPasswork("Test1234", "Test12345");
		
		//Check update passwork success
		assertTrue(ExpectedConditions.alertIsPresent()!= null);
	}

}
