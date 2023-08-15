package automation.pagelocator;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class loginPage {
	private By txtemail = By.id("email");
	private By txtpassword = By.id("password");
	private By buttonLogin = By.xpath("//button[text()='Sign in']");
	private WebDriver driver;
	
	public By authenFailText = By.xpath("//div[normalize-space()='Authentication failed!' and @role='alert']");
	
	public loginPage(WebDriver _driver) {
		this.driver = _driver;
	}
	
	public void LoginFunction (String email, String password)
	{
		WebElement txtEmail = driver.findElement(txtemail);
		if (txtEmail.isDisplayed())
		{
			txtEmail.clear();
			txtEmail.sendKeys(email);
			driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		}
		WebElement txtPass = driver.findElement(txtpassword);
		if (txtPass.isDisplayed())
		{
			txtPass.clear();
			txtPass.sendKeys(password);
			driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		}
		WebElement btnLogin = driver.findElement(buttonLogin);
		if (btnLogin.isDisplayed())
		{
			btnLogin.click();
		}
	}

}
