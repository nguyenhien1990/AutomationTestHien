package automation.pagelocator;

import java.awt.RenderingHints.Key;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import net.bytebuddy.asm.MemberSubstitution.FieldValue;

public class SearchFlightFactory {
	private WebDriver driver;
	
	@FindBy (id="one-way-tab")
	private WebElement rdoOneWay;
	@FindBy (xpath ="(//input[@placeholder='City or airport'])[1]")
	private WebElement txtFrom;
	@FindBy(xpath = "(//input[@placeholder='City or airport'])[2]")
	private WebElement txtTo;
	@FindBy (xpath = "(//input[@class='date-range form-control'])[1]")
	private WebElement dpdFlyDate;

	@FindBy (xpath = "(//a[@data-toggle='dropdown'])[1]")
	private WebElement btnPassenger;
	@FindBy (xpath = "(//div[@class='qtyInc'])[1]")
	private WebElement btnNumberPassenger;
	@FindBy (xpath = "(//div[@class='filter-option-inner-inner'])[3]")
	private WebElement dpdCoach;
	@FindBy (xpath = "//a[@id='bs-select-3-1']")
	private WebElement sltCoach;
	@FindBy (xpath = "(//a[text()='Search Now'])[1]")
	private WebElement btnSearch;
	public SearchFlightFactory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void SearchFlight(String flyFrom, String flyTo, String flyDate) throws InterruptedException
	{
		//rdoOneWay.click();
		txtFrom.clear();
		txtFrom.sendKeys(flyFrom);
		txtTo.clear();
		txtTo.sendKeys(flyTo);
		((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('readonly','readonly')", dpdFlyDate);
		dpdFlyDate.clear();
		dpdFlyDate.sendKeys(flyDate);
		dpdFlyDate.sendKeys(Keys.TAB);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();",btnPassenger);
		//btnPassenger.click();
		Thread.sleep(2000);
		btnNumberPassenger.click();
		((JavascriptExecutor) driver).executeScript("arguments[0].click();",btnPassenger);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();",dpdCoach);
		//dpdCoach.click();
		sltCoach.click();
		btnSearch.click();
	}
	

}
