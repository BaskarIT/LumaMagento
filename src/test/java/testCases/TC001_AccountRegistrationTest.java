package testCases;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;

public class TC001_AccountRegistrationTest extends BaseClass {

	@Test(groups={"Regression","Master"})
	public void verify_account_registration ()
	{

		logger.info("***Starting TC001_AccountRegistrationTest ***");

		try
		{
		HomePage hp = new HomePage(driver);
		hp.clickCreateAccount();
		logger.info("***Clicked on CreateAccount Link ***");
		
		AccountRegistrationPage regpage = new AccountRegistrationPage(driver);
		
		logger.info("Providing customer details...");
		regpage.setFirstName(randomString().toUpperCase());
		regpage.setLastName(randomString().toUpperCase());
		regpage.setEmail(randomString()+"@gmail.com");

		String password=randomeAlphaNumeric();

		regpage.setPassword(password);
		regpage.setConfirmPassword(password);

		regpage.clickCreateAccount();
		
		logger.info("Validating expected message..");
		String confmsg = regpage.getConfirmationMsg();
		
		if(confmsg.equals("Thank you for registering with Main Website Store."))
		{
			Assert.assertTrue(true);
		}
		else
		{
			logger.error("Test Failed..");
			logger.debug("Debug logs..");
			Assert.assertTrue(false);
		}

		// Assert.assertEquals(confmsg, "Thank you for registering with Main Website Store.");

		}
		catch (Exception e)
		{

			Assert.fail();
		}

		logger.info("*** Finished TC001_AccountRegistrationTest ***");
	}

	@Override
	public String randomString()
	{
		String generatedString = RandomStringUtils.randomAlphabetic(5);
		return generatedString;
	}

	public String randomeAlphaNumeric()
	{
		String generatedString = RandomStringUtils.randomAlphabetic(5);
		String generatedNumber = RandomStringUtils.randomNumeric(3);
		return (generatedString+"@"+generatedNumber+"$");
	}

}
