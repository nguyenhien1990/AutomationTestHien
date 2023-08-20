package automation.testsuite;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import automation.common.CommonBase;
import automation.constant.accountConstant;
import automation.pagelocator.ListCouse;
import automation.pagelocator.SignupFactory;
import automation.pagelocator.dashboardPage;

public class LoginTestFactory_2 extends CommonBase{
	@BeforeTest
	public void openPage()
	{
		driver = initChromeDriver(accountConstant.webURL2);
	}
	
	@Test
	public void loginSuccess()
	{
		SignupFactory login = new SignupFactory(driver);
		login.SingupFunction("Nguyen Van A", "maillogin2@yopmai.com", "Test1234", "0123456789");
		ListCouse success = new ListCouse();
		
		pause(4000);
		WebElement expected = driver.findElement(success.txtNotify);
		assertTrue(expected.isDisplayed());
	}

}
