package automation.testsuite;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import automation.common.CommonBase;
import automation.constant.accountConstant;
import automation.pagelocator.ClientPageFactory;
import automation.pagelocator.LoginPageFactory;
import automation.pagelocator.dashboardPage;

public class Homework1_Day15 extends CommonBase{
	
	@BeforeTest
	public void openApp()
	{
		driver = initChromeDriver(accountConstant.webURL);
	}
	
	@Test
	public void addClientSuccess() throws InterruptedException
	{
		LoginPageFactory login = new LoginPageFactory(driver);
		login.LoginFunctionFactory("admin@demo.com", "riseDemo");
		dashboardPage dashboard = new dashboardPage();
		pause(3000);
		WebElement expected = driver.findElement(dashboard.lblDash);
		assertTrue(expected.isDisplayed());
		
		ClientPageFactory client = new ClientPageFactory(driver);
		client.AddClient("Company1");
	}

}
