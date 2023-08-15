package automation.testsuite;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import automation.common.CommonBase;
import automation.constant.accountConstant;
import automation.pagelocator.dashboardPage;
import automation.pagelocator.loginPage;

public class loginTest extends CommonBase {
	@BeforeTest
	public void openPage()
	{
		driver = initChromeDriver(accountConstant.webURL);
	}
	
	public void loginSuccess()
	{
		loginPage page = new loginPage(driver);
		page.LoginFunction("admin@demo.com", "riseDemo");
		
		dashboardPage dashboard = new dashboardPage();
		WebElement expected = driver.findElement(dashboard.lblDash);
		assertTrue(expected.isDisplayed());
	}
	
	public void loginFail_EmailIncorrect()
	{
		loginPage page = new loginPage(driver);
		page.LoginFunction("failadmin@demo.com", "riseDemo");
				
		WebElement expected = driver.findElement(page.authenFailText);
		assertTrue(expected.isDisplayed());
	}
	
	public void loginFail_PassIncorrect()
	{
		loginPage page = new loginPage(driver);
		page.LoginFunction("admin@demo.com", "riseDemo123");
				
		WebElement expected = driver.findElement(page.authenFailText);
		assertTrue(expected.isDisplayed());
	}
	
	public void loginFail_UserAndPassIncorrect()
	{
		loginPage page = new loginPage(driver);
		page.LoginFunction("123admin@demo.com", "riseDemo123");
				
		WebElement expected = driver.findElement(page.authenFailText);
		assertTrue(expected.isDisplayed());
	}
	

}
