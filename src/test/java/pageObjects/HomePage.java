package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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

@FindBy(xpath="//img[@src='https://magento.softwaretestingboard.com/pub/media/wysiwyg/home/home-main.jpg']")
WebElement imgHomeBanner;



public void clickCreateAccount()
{
	lnkCreateAccount.click();
}

public void clickLogIn()
{

	lnkLogin.click();
}

public void ClickHomeBanner()
{
	imgHomeBanner.click();
}


public boolean isMyAccountPageExist()
{
	try
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		wait.until(ExpectedConditions.visibilityOf(msgHeading));
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
