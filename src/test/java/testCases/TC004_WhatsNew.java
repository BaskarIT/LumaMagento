package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.WhatsNewPage;
import pageObjects.Hoodies_Sweatshirts_Page;

public class TC004_WhatsNew extends BaseClass{

@Test(groups= {"Sanity","Master"})
	
	public void verifyWhatsNew()
	{
		try
		{
			HomePage hp = new HomePage(driver);
			hp.clickLogIn();
			
		//LoginPage
			LoginPage lp = new LoginPage(driver);
			lp.setEmail(p.getProperty("email"));
			lp.setPassword(p.getProperty("password"));
			lp.clickLogIn();
			
		WhatsNewPage lc = new WhatsNewPage(driver);
		
		lc.clickWhatsNew();
		
		String confmsg = lc.getConfirmationMsg();
		System.out.println("New Collection: "+ confmsg);
		
		if(confmsg.equals("What's New"))
		{
			Assert.assertTrue(true);
		}
		else 

		{
			logger.error("Test Failed..");
			logger.debug("Debug logs..");
			Assert.assertTrue(false);
		}

	}
	catch (Exception e)
		{
			Assert.fail();
		}
	
		logger.info("*** Finished TC005_ProductDetailsValidation ***");
	}
	
}
