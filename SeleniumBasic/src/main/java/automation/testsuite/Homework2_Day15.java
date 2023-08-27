package automation.testsuite;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import automation.common.CommonBase;
import automation.constant.accountConstant;
import automation.pagelocator.SearchFlightFactory;
import automation.pagelocator.dashboardPage;

public class Homework2_Day15 extends CommonBase{
	@BeforeTest
	public void openApp()
	{
		driver = initChromeDriver(accountConstant.webURL3);
	}
	
	@Test
	public void SearchFlights() throws InterruptedException
	{
		SearchFlightFactory search = new SearchFlightFactory(driver);
		search.SearchFlight("HCM", "HAN", "27082023");
		dashboardPage success = new dashboardPage();
		pause(3000);
		WebElement expected = driver.findElement(success.lblSearch);
		assertTrue(expected.isDisplayed());
	}

}
