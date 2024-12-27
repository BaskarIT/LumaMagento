package testCases;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.Hoodies_Sweatshirts_Page;


public class TC005_Hoodies_Sweatshirts extends BaseClass {
	
	@Test(groups= {"Sanity","Master"})
	
	public void verifyHoodies_Sweatshirts()
	{
		try
		{
		// Initialize the HomePage
			HomePage hp = new HomePage(driver);
			hp.clickLogIn();
			
		//LoginPage
			LoginPage lp = new LoginPage(driver);
			lp.setEmail(p.getProperty("email"));
			lp.setPassword(p.getProperty("password"));
			lp.clickLogIn();
	        logger.info("Login to application..");

	    // Initialize the Page Class
		Hoodies_Sweatshirts_Page hs = new Hoodies_Sweatshirts_Page(driver);
		
		// Navigate to What's New Page..
		hs.clickWhatsNew();
        logger.info("WhatsNew test passed.");
		
        // Navigate to Hoodies Page..
		hs.clickHoodie();
        logger.info("Hoodie Product List test passed.");
		
        // Validate the Page Title...
		String confmsg = hs.getConfirmationMsg();
		System.out.println("Hoodies View Title: " + confmsg);
		
		if(confmsg.equals("Hoodies & Sweatshirts"))
		{
			Assert.assertTrue(true);
		}
		else
		{
			logger.error("Test Failed..");
			logger.debug("Debug logs..");
			Assert.assertTrue(false, "Expected 'Hoodies & Sweatshirts', but got: " + confmsg);
		}
		
		hs.printProductDetails();
		
		hs.clickAddtoCart();
        logger.info("Add to Cart button test passed.");
	}
	catch (Exception e)
		{
			Assert.fail();
		}
	
		logger.info("*** Finished TC005_ProductDetailsValidation ***");
	}
		
}
