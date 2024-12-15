package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

	public LoginPage(WebDriver driver)
	{
		super(driver);
	}

	@FindBy(xpath="//input[@id='email']")
	WebElement txtEmailAddress;

	@FindBy(xpath="//fieldset[@class='fieldset login']//input[@id='pass']")
	WebElement txtPassword;

	@FindBy(xpath="//fieldset[@class='fieldset login']//span[contains(text(),'Sign In')]")
	WebElement btnLogin;


	public void setEmail(String email)
	{
		txtEmailAddress.sendKeys(email);
	}

	public void setPassword(String pwd)
	{
		txtPassword.sendKeys(pwd);
	}

	public void clickLogIn()
	{
		btnLogin.click();
	}
}
