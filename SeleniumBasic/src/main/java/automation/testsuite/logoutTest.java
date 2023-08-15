package automation.testsuite;

import static org.testng.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import automation.common.CommonBase;
import automation.constant.accountConstant;
import automation.pagelocator.dashboardPage;
import automation.pagelocator.loginPage;
import automation.pagelocator.logoutPage;
import io.opentelemetry.api.trace.Span;

public class logoutTest extends CommonBase{
	@BeforeTest
	public void openPage()
	{
		driver = initChromeDriver(accountConstant.webURL);
	}
	@Test
	public void logout()
	{
		//login success
		loginPage page = new loginPage(driver);
		page.LoginFunction("admin@demo.com", "riseDemo");
		
		dashboardPage dashboard = new dashboardPage();
		WebElement expected = driver.findElement(dashboard.lblDash);
		assertTrue(expected.isDisplayed());
		
		//Logout
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		WebElement clickAcc = driver.findElement(By.id("user-dropdown"));
		clickAcc.click();
		pause(3000);
		driver.manage().timeouts().implicitlyWait(4,TimeUnit.SECONDS);
		WebElement selectLogOut = driver.findElement(By.xpath("//a[@class='dropdown-item' and normalize-space()='Sign Out']"));
		selectLogOut.click();
		
		//confirm logout success
		logoutPage signin = new logoutPage();
		WebElement logoutSuccess = driver.findElement(signin.lblLogin);
		assertTrue(logoutSuccess.isDisplayed());
	}

}
