package automation.testsuite;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import automation.common.CommonBase;
import automation.constant.accountConstant;
import automation.pagelocator.LoginPageFactory;
import automation.pagelocator.dashboardPage;

public class LoginTestFactory extends CommonBase{
	
	@BeforeTest
	public void openPage()
	{
		driver = initChromeDriver(accountConstant.webURL);
	}
	
	@Test
	public void loginSuccess()
	{
		LoginPageFactory factory = new LoginPageFactory(driver);
		factory.LoginFunctionFactory("admin@demo.com", "riseDemo");
		
		dashboardPage dashboard = new dashboardPage();
		WebElement expected = driver.findElement(dashboard.lblDash);
		assertTrue(expected.isDisplayed());
		
	}
	@AfterTest
	public void close()
	{
		driver.close();
	}

}
