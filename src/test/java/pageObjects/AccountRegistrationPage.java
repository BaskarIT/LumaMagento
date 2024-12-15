package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {

	public AccountRegistrationPage(WebDriver driver)
	{
		super(driver);
	}

@FindBy(xpath="//input[@id='firstname']")
WebElement txtFirstName;

@FindBy(xpath="//input[@id='lastname']")
WebElement txtLastName;

@FindBy(xpath="//input[@id='email_address']")
WebElement txtEmail;

@FindBy(xpath="//input[@id='password']")
WebElement txtPassword;

@FindBy(xpath="//input[@id='password-confirmation']")
WebElement txtConfirmPassword;

@FindBy(xpath="//button[@title='Create an Account']//span[contains(text(),'Create an Account')]")
WebElement btnCreateAccount;

@FindBy(xpath="//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']")
WebElement msgConfirmation;


public void setFirstName(String fname) {
	txtFirstName.sendKeys(fname);
}

public void setLastName(String lname) {
	txtLastName.sendKeys(lname);
}

public void setEmail(String email) {
	txtEmail.sendKeys(email);
}

public void setPassword(String pwd) {
	txtPassword.sendKeys(pwd);
}

public void setConfirmPassword(String pwd) {
	txtConfirmPassword.sendKeys(pwd);
}

public void clickCreateAccount() {
	btnCreateAccount.click();

//sol2
//btnContinue.submit();

//sol3
//Actions act = new Actions(driver);
//act.moveToElement(btnContinue).click().perform();

//sol4
//JavaScriptExecutor js = (JavascriptExecutor)driver;
//js.executeScript("arguments[0].click();", btnContinue);

//sol5
//WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(10));
//mywait.until(ExpectedConditions.elementToBeClickable(btnContiue)).Click();
}

public String getConfirmationMsg() {
	try {
		return (msgConfirmation.getText());
	} catch (Exception e) {
		return (e.getMessage());
	}
  }
}
