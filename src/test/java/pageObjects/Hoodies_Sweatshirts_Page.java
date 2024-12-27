package pageObjects;

import java.time.Duration;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Hoodies_Sweatshirts_Page extends BasePage{
    public static final Logger logger = LogManager.getLogger(Hoodies_Sweatshirts_Page.class);
	
	public Hoodies_Sweatshirts_Page(WebDriver driver)
	{
		super(driver);
	}

@FindBy(xpath="//a[@id='ui-id-3']//span[1]")
WebElement lnkWhatsNew;
	
 @FindBy(xpath="//span[@class='base']")
 WebElement txtTitle;
 
 @FindBy(xpath="//li[@class='item']//a[@href=\"https://magento.softwaretestingboard.com/men/tops-men/hoodies-and-sweatshirts-men.html\"]")
 WebElement lnkHoodies;
 
 @FindBy(xpath="//span[@class='base' and text()='Hoodies & Sweatshirts']")
 WebElement txtHeading;
 
 @FindBy(xpath="//div[@class='product-item-info']")
List<WebElement> listProd;

/*
 * @FindBy(xpath="//li[@class='item product product-item']") List<WebElement>
 * hoodieProd;
 */

@FindBy(xpath="//button[@type='submit']//span[text()='Add to Cart']")
WebElement addToCart;

 @FindBy(xpath="//strong[@class=\"product name product-item-name\"]")
 List<WebElement> nameProd;
 
 @FindBy(xpath="//span[@class=\"normal-price\"]")
 List<WebElement> priceProd;
 

@FindBy(xpath="//div[@class=\"swatch-attribute size\"]")
List<WebElement> sizeProd;

@FindBy(xpath="//div[@class=\"swatch-attribute color\"]")
List<WebElement> clrProd;

@FindBy(xpath="//div[@class=\"rating-summary\"]")
List<WebElement> rateProd;

@FindBy(xpath="//span[contains(text(),'Reviews')]")
List<WebElement> reviewProd;

@FindBy(xpath="//img[@src=\"https://magento.softwaretestingboard.com/pub/media/catalog/product/cache/7c4c1ed835fbbf2269f24539582c6d44/m/h/mh13-blue_main_2.jpg\"]")
WebElement lnkHoodie;

public void clickWhatsNew()
{
	lnkWhatsNew.click();
}

public void clickHoodie()
{
	lnkHoodies.click();
}

 public String getConfirmationMsg() {
		try {
			return (txtHeading.getText());
		} catch (Exception e) {
			return (e.getMessage());
		}
	 }
 
 public List<WebElement> getAllProductList()
 {
	 return listProd;
 }
 
 public void printProductDetails() 
 {
	 boolean hasNextPage = true;
	 int pageIndex=1;
	 
	 while(hasNextPage)
	 {
	 // System.out.println("Processing Page: "+ pageIndex); //Instead Use -> logger.info("Processing Page: {}", pageIndex);
	 List<WebElement> products = getAllProductList();
     // System.out.println("Total Products Found: " + products.size()); // Use structured logging to improve readability and debugging
     
     logger.info("Processing Page: {}", pageIndex);
	 logger.info("Total Products Found: {}", products.size());
		
     for(WebElement product: products)
     {
		//String productName = product.findElement(By.xpath(".//strong[@class='product name product-item-name']")).getText(); String
		//productPrice=product.findElement(By.xpath(".//span[@class='normal-price']")).getText();
		//System.out.println("Product Name: " + productName + ", Price: " + productPrice);
		System.out.println("---------------");	 
    	
		//String productInfo=product.findElement(By.xpath(".//div[@class='product-item-info']")).getText();
		String productInfo=product.findElement(By.xpath(".//div[@class='product details product-item-details']")).getText();
    	System.out.println(productInfo);
    	System.out.println("------Page" + pageIndex + "-------");
     }
     
     try
     {
    	 WebElement nextButton=driver.findElement(By.xpath("//div[4]//div[2]//ul[1]//li[3]//a[1]"));
    			 if(nextButton.isDisplayed())
    			 {
    				 nextButton.click();
    				 pageIndex++;
    				 
    				 Thread.sleep(1000);
    			 }
    			 else
    			 {
    				 hasNextPage=false;
    			 }
     }
     catch(Exception e)
     {
    	 hasNextPage=false;
    	 
     }
  }
	 try {
	        WebElement firstPageButton = driver.findElement(By.xpath("//div[4]//div[2]//ul[1]//li[2]//a[1]//span[2]")); // XPath for the "First" button
	        if (firstPageButton.isDisplayed()) {
	            firstPageButton.click();
	            logger.info("Navigated back to the first page.");
	        } else {
	            logger.warn("First page button is not visible.");
	        }
	     	
	    } catch (Exception e) {
	        logger.error("Failed to navigate back to the first page: {}", e.getMessage());
	    }
	 
	 	System.out.println("Finished processing all pages.");
	 	JavascriptExecutor js = (JavascriptExecutor) driver;
  		js.executeScript("window.scrollBy(0,500)", "");
  		System.out.println("Page scrolling up...");
	}

 	
 // Check Add to cart button displayed or not
 public void clickAddtoCart()
 {
	 // Mouse hover action on the product
	 	Actions action = new Actions(driver);
        System.out.println("Total Hoodies Found: " + listProd.size());
        int productIndex=0, displayedCount=0, notDisplayedCount=0;
        
        List<WebElement> products = getAllProductList();
        
        for(WebElement product: products)
        {
        	
            action.moveToElement(product).perform();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement atc = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@type='submit']")));
            
            if(atc.isDisplayed())
            {
            	displayedCount++;
            	productIndex++;
           //	addToCart.click();
           	//  System.out.println("Clicked Add to Cart button.");
            }
            else
            {
            	notDisplayedCount++;
            	System.out.println("Add to Cart button is not visible for product.");
            }
            
        }
        System.out.println("Total no of ATC button visible: "+ displayedCount);
        System.out.println("Total no of ATC button NOT visible: "+ notDisplayedCount);
        // System.out.println("Add to Cart button is visible for: "+ productIndex);
        System.out.println("Finished checking 'Add to Cart' visibility for all products.");
   }
 	
}
