package automation.pagelocator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UpdateInformation {
	private WebDriver driver;
	
	@FindBy(id="txtpassword")
	private WebElement txtOldPass;
	@FindBy(id="txtnewpass")
	private WebElement txtNewPass;
	@FindBy(id="txtrenewpass")
	private WebElement txtRenewPass;
	@FindBy(xpath = "//button[normalize-space()='Lưu mật khẩu mới']")
	private WebElement btnUpdateNewPass;
	public UpdateInformation(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void UpdateNewPasswork(String oldPass, String newPass)
	{
		txtOldPass.sendKeys(oldPass);
		txtNewPass.sendKeys(newPass);
		txtRenewPass.sendKeys(newPass);
		btnUpdateNewPass.click();
	}
	
	

}
