package automation.pagelocator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignupFactory {
	private WebDriver driver;
	
	@FindBy(id= "txtFirstname")
	private WebElement txtFirstName;
	@FindBy(id= "txtEmail")
	private WebElement txtEmail;
	@FindBy(id= "txtCEmail")
	private WebElement txtCEmail;
	@FindBy(id= "txtPassword")
	private WebElement txtPassword;
	@FindBy(id= "txtCPassword")
	private WebElement txtCPassword;
	@FindBy(id= "txtPhone")
	private WebElement txtPhone;
	@FindBy(xpath = "//button[@class='btn_pink_sm fs16']")
	private WebElement btnRegister;
	public SignupFactory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void SingupFunction(String firstName, String email, String pass, String phone)
	{
		txtFirstName.sendKeys(firstName);
		txtEmail.sendKeys(email);
		txtCEmail.sendKeys(email);
		txtPassword.sendKeys(pass);
		txtCPassword.sendKeys(pass);
		txtPhone.sendKeys(phone);
		btnRegister.click();
		
	}
	
	

}
