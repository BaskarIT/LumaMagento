package pageObjects;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductDetailsPage extends BasePage{
	
	public ProductDetailsPage(WebDriver driver)
	{
		super(driver);
	}

@FindBy(xpath="//a[@class='product-item-link'][normalize-space()='Mach Street Sweatshirt']")
WebElement lnkProd;

@FindBy(xpath="//span[@class='base' ]")
WebElement txtTitle;

@FindBy(xpath="//span[@id='product-price-206']//span[@class='price'][normalize-space()='$62.00']")
WebElement txtPrice;

@FindBy(xpath="//div[@class='product-info-price']//span[@class='price-label'][normalize-space()='As low as']")
WebElement txtLabel;

@FindBy(xpath="//span[normalize-space()='In stock']")
WebElement txtStock;

@FindBy(xpath="//div[@class='product attribute sku']")
WebElement txtSKU;

@FindBy(xpath="//div[@class='swatch-attribute size']//div[@role='listbox']")
WebElement sizeOption;

@FindBy(xpath="//div[@option-label=\"Black\"]")
WebElement txtColor;

@FindBy(xpath="//span[normalize-space()='Black']")
WebElement getColor;

@FindBy(xpath="//input[@id=\"qty\"]")
WebElement txtQty;

@FindBy(xpath="//span[normalize-space()='Add to Cart']")
WebElement btnAddToCart;

@FindBy(xpath="//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']")
WebElement successMessage;

@FindBy(xpath="//div[@class='product-addto-links']//span[contains(text(),'Add to Compare')]")
WebElement btnCompare;

@FindBy(xpath="//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']")
WebElement msgAddToCompare;

@FindBy(xpath="//div[@class='product-addto-links']//a[@class='action towishlist']")
WebElement btnAddToWish;

@FindBy(xpath="//div[@data-bind=\"html: $parent.prepareMessageForHtml(message.text)\"]")
WebElement wlSuccMessage;

@FindBy(xpath="//a[@id='tab-label-description-title']")
WebElement tabindex1;

@FindBy(xpath="//div[@id=\"description\"]")
WebElement tabindex1Text;

@FindBy(xpath="//a[@id='tab-label-additional-title']")
WebElement tabindex2;

@FindBy(xpath="//div[@id=\"additional\"]")
WebElement tabindex2Text;

@FindBy(xpath="//a[@id='tab-label-reviews-title']")
WebElement tabindex3;

@FindBy(xpath="//span[text()=\"You're reviewing:\"]")
WebElement revTitle;

@FindBy(xpath="//legend[@class='legend review-legend']/strong")
WebElement txtProdName;

@FindBy(xpath="//div[@class='control review-control-vote']")
WebElement starRatingContainer;

@FindBy(xpath="//div[@class='control review-control-vote']//label[@class='rating-4']")
WebElement startRating;

@FindBy(xpath="//input[@id='nickname_field']")
WebElement txtNickname;

@FindBy(xpath="//input[@id='summary_field']")
WebElement txtSummary;

@FindBy(xpath="//textarea[@id='review_field']")
WebElement txtReview;

@FindBy(xpath="//span[normalize-space()='Submit Review']")
WebElement btnSubmit;

@FindBy(xpath="//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']")
WebElement txtConfirmMsg;

@FindBy(xpath="//a[@class='product-item-link']")
List<WebElement> lnkRelatedProd;

@FindBy(xpath="//div[@class='fotorama__stage__frame magnify-wheel-loaded fotorama__active fotorama_vertical_ratio fotorama__loaded fotorama__loaded--img']//img[@class='fotorama__img']")
WebElement imgProd;

public void clickProduct()
{
	lnkProd.click();
}

public String getProdTitle()
{
	return txtTitle.getText();
}

public String getProdPrice()
{
	return txtPrice.getText();
}

public boolean isProductImageDisplayed()
{
	return imgProd.isDisplayed();
}

public String getLabel()
{
	return txtLabel.getText();
}

public String getStock()
{
	return txtStock.getText();
}

public String getProdSKU()
{
	return txtSKU.getText();
}

public void selectSize(String size)
{
	WebElement sizeElement = driver.findElement(By.xpath("//div[@class='swatch-option text' and text()='" + size + "']"));												 
	sizeElement.click();
}

public void selectColor(String color)
{
	WebElement colorElement = driver.findElement(By.xpath("//div[@class='swatch-option color' and @aria-label='" + color + "']"));										      
	colorElement.click();
	System.out.println("Selected Color is :" + getColor.getText());
}

public boolean validateSelectedColorWithImg()
{
	String color = txtColor.getText();
	String imageSrc = imgProd.getAttribute("src");
	return imageSrc.contains(color.toLowerCase());
}

public void enterProdQuantity()
{
	txtQty.clear();
	txtQty.sendKeys("2");
}

public void clickAddToCart()
{
	btnAddToCart.click();
}

public void clickAddToCompare()
{
	btnCompare.click();
}

public void clickAddToWishList()
{
	btnAddToWish.click();
}

public boolean verifySuccessMessage(String expectedMessage)
{
    return successMessage.getText().contains(expectedMessage);
}

public boolean verifyWLSuccMessage(String expectedMessage)
{
    String actualMessage = wlSuccMessage.getText();
	return actualMessage.contains(expectedMessage);
}

public boolean verifyAddToCompare(String expectedMessage)
{
	String actualMessage = msgAddToCompare.getText();
	return actualMessage.contains(actualMessage);
}

public void clickTabIndexDetails()
{
	tabindex1.click();
}

public String getTabIndex1Description()
{
	return tabindex1Text.getText();
}

public void clickTabIndexInfo()
{
	tabindex2.click();
}

public String getTabIndex2Info()
{
	return tabindex2Text.getText();
}

public void clickTabIndexReview()
{
	tabindex3.click();
}

public boolean verifyReviewTitle(String expectedMessage)
{
	String actualMessage = revTitle.getText();
	return actualMessage.contains(expectedMessage);
}

public String getTextProdName()
{
	return txtProdName.getText();
}

public void mouserHoverToRating()
{
	Actions action = new Actions(driver);
	action.moveToElement(starRatingContainer).perform();
}

public WebElement getStarRatingContainer()
{
	return starRatingContainer;
}

public void clickStartRating()
{
	JavascriptExecutor js = (JavascriptExecutor) driver;
	js.executeScript("arguments[0].click();", startRating);
}

public void sendNickname()
{
	txtNickname.clear();
	txtNickname.sendKeys("Demo User");
}

public void sendSummary()
{
	txtSummary.sendKeys("Overall service is good...");
}

public void sendReview()
{
	txtReview.sendKeys("Quality product and affotable price..");
}

public void clickSubmit()
{
	btnSubmit.click();
}

public boolean verifyReviewSuccMessage(String expectedMessage)
{
	String actualMessage = txtConfirmMsg.getText();
	return actualMessage.contains(expectedMessage);
}

public void VerifyLinks()
{
	System.out.println("Total no of related prod is :" + lnkRelatedProd.size());
	

	for(WebElement link: lnkRelatedProd)
	{
		String href=link.getAttribute("href");
		
		if(href==null || href.isEmpty())
		{
			System.out.println("The link is empty or has no href attribute.");
			continue;
		}
		if(link.isDisplayed() && link.isEnabled())
		{
            System.out.println("Clickable Link: " + href);
		}
		else
		{
			System.out.println("Non-clickable Link: " + href);
		}
	 }
	
  }

}
