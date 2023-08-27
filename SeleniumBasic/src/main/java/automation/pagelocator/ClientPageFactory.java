package automation.pagelocator;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ClientPageFactory {
	private WebDriver driver;

	@FindBy(xpath = "//a[@title='Add client']")
	private WebElement btnAddClient;
	@FindBy(id = "type_person")
	private WebElement rdnTypePerson;
	@FindBy(id ="company_name")
	private WebElement txtCompanyName;
	//value of Owner
	@FindBy(xpath="//div[@id='s2id_created_by']")
	private WebElement drpOwner;
	@FindBy (xpath = "(//ul[@role='listbox'])[2]/li[3]")
	private WebElement selectchbOwner;
	@FindBy(xpath = "//button[@class='btn btn-primary']")
	private WebElement btnSave;
	@FindBy(xpath="//a[text()='Clients']")
	private WebElement clientTab;
	@FindBy(xpath = "(//input[@placeholder='Search'])[2]")
	private WebElement txtSearch;
	@FindBy(xpath = "//a[text()='Company1']")
	private WebElement searchResult;
	
	public ClientPageFactory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void AddClient(String company) throws InterruptedException
	{
		dashboardPage dashboard = new dashboardPage();
		driver.findElement(dashboard.lblClient).click();
		btnAddClient.click();
		Thread.sleep(3000);
		rdnTypePerson.click();
		txtCompanyName.sendKeys(company);
		drpOwner.click();
		selectchbOwner.click();
		btnSave.click();
		//clientTab.click();
		((JavascriptExecutor) driver).executeScript("arguments[0].click();",clientTab);
		Thread.sleep(4000);
		txtSearch.sendKeys(company);
		Thread.sleep(4000);
		assertTrue(searchResult.isDisplayed());
	}

}
