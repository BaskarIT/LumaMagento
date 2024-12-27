package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;

public class TC002_LoginTest extends BaseClass{

	@Test(groups= {"Sanity","Master"})
	public void verify_Login()
	{
		logger.info("** Starting TC002_LoginTest **");
		
		try
		{
		//HomePage
		HomePage hp = new HomePage(driver);
		hp.clickLogIn();
		
		//LoginPage
		LoginPage lp = new LoginPage(driver);
		lp.setEmail(p.getProperty("email"));
		lp.setPassword(p.getProperty("password"));
		lp.clickLogIn();
		
		//ConfirmMyAccount
		// MyAccountPage macc = new MyAccountPage(driver);
		boolean targetPage = hp.isMyAccountPageExist();

		Assert.assertTrue(targetPage);	// OR Assert.assertEquals(targetPage, true, "Login Failed");
		}
		catch (Exception e)
		{
			Assert.fail();
		}
		logger.info("*** Finished TC002_LoginTest ***");
	}

}
