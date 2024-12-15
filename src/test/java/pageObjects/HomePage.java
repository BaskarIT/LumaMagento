package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage{

	public HomePage(WebDriver driver)
	{
		super(driver);
	}


@FindBy(xpath="//div[@class='panel header']//a[normalize-space()='Create an Account']")
WebElement lnkCreateAccount;

@FindBy(xpath="//div[@class='panel header']//a[contains(text(),'Sign In')]")
WebElement lnkLogin;

@FindBy(xpath="//div[@class='panel header']//span[@class='logged-in'][normalize-space()='Welcome, Test User!']")
//span[contains(@class, 'base') and contains(text(), 'My Account')]
WebElement msgHeading;

@FindBy(xpath="//div[@class='panel header']//button[@type='button']")
WebElement ddlnkMenu;

@FindBy(xpath="//div[@aria-hidden='false']//a[normalize-space()='Sign Out']")
WebElement lnkLogout;

public void clickCreateAccount()
{
	lnkCreateAccount.click();
}

public void clickLogIn()
{

	lnkLogin.click();
}

public boolean isMyAccountPageExist()
{
	try
	{
	return (msgHeading.isDisplayed());
	}
	catch(Exception e)
	{
		return false;
	}
}

public void clickMenu()
{
	ddlnkMenu.click();
}

public void clickLogout()
{
	lnkLogout.click();
}
}
