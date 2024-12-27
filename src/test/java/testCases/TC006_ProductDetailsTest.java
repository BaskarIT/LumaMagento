package testCases;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.Hoodies_Sweatshirts_Page;
import pageObjects.LoginPage;
import pageObjects.ProductDetailsPage;

public class TC006_ProductDetailsTest extends BaseClass {
	
	@Test(groups = { "Sanity","Master" })
	
	public void verifyProductDetailsPage() {
		logger.info("** Starting TC006_ProductDetailsTest **");
		
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		
		try
		{
		HomePage hp = new HomePage(driver);
		hp.clickLogIn();
		
		//LoginPage
		LoginPage lp = new LoginPage(driver);
		lp.setEmail(p.getProperty("email"));
		lp.setPassword(p.getProperty("password"));
		lp.clickLogIn();
		
		Hoodies_Sweatshirts_Page hs = new Hoodies_Sweatshirts_Page(driver);
		
		hs.clickWhatsNew();
        logger.info("WhatsNew test passed.");
		
		hs.clickHoodie();
        logger.info("Hoodie Product List test passed.");
		
        //Click Product
        ProductDetailsPage prodDetails = new ProductDetailsPage(driver);
        prodDetails.clickProduct();
        
		// Verify product title
		String title = prodDetails.getProdTitle();
		Assert.assertNotNull(title, "Product title is not displayed.");
		System.out.println("Product Title: " + title);
		
		// Verify product price
		String price = prodDetails.getProdPrice();
		Assert.assertNotNull(price, "Product price is not displayed.");
		System.out.println("Product Price: " + price);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,400)", "");

		/*
		 * Long pageHeight = (Long)
		 * js.executeScript("return document.body.scrollHeight"); Long viewportHeight =
		 * (Long) js.executeScript("return window.innerHeight"); Long centerPosition =
		 * (pageHeight - viewportHeight) / 2; js.executeScript("window.scrollTo(0, " +
		 * centerPosition + ");");
		 */
		
		//js.executeScript("window.scrollBy(0,350)", "");
		
		// Verify product image
		//Assert.assertTrue(prodDetails.isProductImageDisplayed(), "Product image is not displayed.");
				
		// Select product price label
		String label = prodDetails.getLabel();
		Assert.assertNotNull(label, "Label is not displayed.");
		System.out.println("Price Label: " + label);

		// Verify product Stock
		String Stock = prodDetails.getStock();
		Assert.assertNotNull(Stock, "Stock Details is not displayed.");
		System.out.println("Product Stock Availability: " + Stock);
		
		// Verify product price
		String sku = prodDetails.getProdSKU();
		Assert.assertNotNull(sku, "Stock Details is not displayed.");
		System.out.println("Product SKU Number: " + sku);
		
		// Verify product size
		prodDetails.selectSize("M");
		
		// Select size and color
		prodDetails.selectColor("Black");
		
		// Validate that the selected color matches the product image
		boolean isValid = prodDetails.validateSelectedColorWithImg();
		Assert.assertTrue(isValid, "The selected color does not match the product image.");
		
		
		// Select Quantity
		prodDetails.enterProdQuantity();
		
		// Click "Add to Cart"
		prodDetails.clickAddToCart();
		
		// Verify success message
		Assert.assertTrue(prodDetails.verifySuccessMessage("You added"), "Add-to-Cart Success message is not displayed.");
		System.out.println("Success message is displayed after adding the product to the Cart.");
		logger.info("Validating Add-to-Cart expected message..");
		
		//Click "Add to Compare.."
		prodDetails.clickAddToCompare();
		
		//Verify success message..
		Assert.assertTrue(prodDetails.verifyAddToCompare("You added product "), "Add-to-Wish-List Success message is not displayed.");
		System.out.println("Success message is displayed after adding the product to the Compare List.");
		logger.info("Validating Add-to-Compare expected message..");
		
		js.executeScript("window.scrollBy(0,800)", "");
		System.out.println("Scrolled down by 800 pixels.");
		
		//Click "Details TabIndex.."
		prodDetails.clickTabIndexDetails();
		System.out.println("Details Tab view working..");
		
		// Verify text is present or not in the TabIndex..
		Assert.assertNotEquals("", prodDetails.getTabIndex1Description(), "Description is empty!");
		System.out.println("Details Tab view has content..");
		
		//Click "Details TabIndex.."
		prodDetails.clickTabIndexInfo();
		System.out.println("Description Tab view working..");
		
		// Verify text is present or not in the TabIndex..
		Assert.assertNotEquals("", prodDetails.getTabIndex2Info(), "Product Info is empty!");
		//Assert.assertTrue(prodDetails.isTabIndex2InfoPresent("Value is required and can't be empty"), "Msg is absent/wrong/misspelled");
		System.out.println("Product More Info Tab view has content..");
		
		//Click Review TabIndex..
		prodDetails.clickTabIndexReview();
		
		// Verify Review heading text is present 
		Assert.assertTrue(prodDetails.verifyReviewTitle("You're reviewing:"), "Reivew Tab Titile is not displayed.");
		
		// Verify Review product name showing as actual product name
		String actualTitle = prodDetails.getTextProdName();
		String expectedTitle = title;
		Assert.assertEquals(actualTitle,expectedTitle, "Page title does not match!");
		
		// Verify is Rating Present]
		prodDetails.mouserHoverToRating();
		/*
		 * boolean isRatingContainerDisplayed =
		 * prodDetails.getStarRatingContainer().isDisplayed();
		 * Assert.assertTrue(isRatingContainerDisplayed,
		 * "Rating Container is not displayed!");
		 */
		// Click Star Rating
		prodDetails.clickStartRating();
		
		// Enter the Nick Name
		prodDetails.sendNickname();
		
		// Enter the Summary
		prodDetails.sendSummary();
		
		// Enter the product review
		prodDetails.sendReview();
		
		// Submit the Review
		prodDetails.clickSubmit();
		
		// Verify success message..
		Assert.assertTrue(prodDetails.verifyReviewSuccMessage("You submitted your review for moderation."), "Review Success message is not displayed..");
		System.out.println("Success message is displayed after reviewing the product..");
		logger.info("Validating Product Review Success Message..");
		
		
		//Click "Add to Wish List.."
		prodDetails.clickAddToWishList();
				
		// Verify success message..
		Assert.assertTrue(prodDetails.verifyWLSuccMessage("added to your Wish List"), "Add-to-Wish-List Success message is not displayed.");
		System.out.println("Success message is displayed after adding the product to the Wish List.");
		logger.info("Validating Add-to-Wish-List expected message..");
				
		// Go back to previous page..
		driver.navigate().back();
		
		js.executeScript("window.scrollBy(0,1000)", "");
		System.out.println("Scrolled down by 1000 pixels.");
		
		// Verify Related product count and clickable..
		prodDetails.VerifyLinks();
		
		}
		catch(Exception e)
		{
            // Log the exception
            logger.error("An error occurred during the test execution: " + e.getMessage());
            e.printStackTrace();
            
            // Mark the test as failed
            Assert.fail("Test case failed due to an unexpected exception.");
		}
		
	}
		
}
