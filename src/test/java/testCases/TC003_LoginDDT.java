package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import utilities.DataProviders;

public class TC003_LoginDDT extends BaseClass{

	@Test(dataProvider="LoginData", dataProviderClass=DataProviders.class, groups="Datadriven") // getting data provider from different class
	public void verify_LoginDDT(String email, String pwd, String exp) throws InterruptedException
	{
		logger.info("*** Starting TC003_LoginDDT ***");
		
		try
		{
		// HomePage
			HomePage hp = new HomePage(driver);
			hp.clickLogIn();

		// LoginPage
			LoginPage lp = new LoginPage(driver);
			lp.setEmail(email);
			lp.setPassword(pwd);
			lp.clickLogIn();

		//ConfirmMyAccount
			boolean targetPage = hp.isMyAccountPageExist();

		/*	Data is Valid 	- login success - test pass - logout
							  login failed - test fail
			Data is Invalid - login success - test fail - logout
							  login failed - test pass
		*/

			if(exp.equalsIgnoreCase("Valid"))
			{
				if(targetPage)
				{
					Assert.assertTrue(true);
					hp.clickLogout();
				}
				else
				{
					Assert.assertTrue(false);
				}
			}

			if(exp.equalsIgnoreCase("Invalid"))
			{
				if(targetPage)
				{
					hp.clickLogout();
					Assert.assertTrue(false);
				}
				else
				{
					Assert.assertTrue(true);
				}
			}
	} catch(Exception e)
	{
		Assert.fail();
	}

	Thread.sleep(3000);
	logger.info(" *** Finished TC003_LoginDDT *** ");
  }

}
