package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WhatsNewPage extends BasePage{
	
	public WhatsNewPage(WebDriver driver)
	{
		super(driver);
	}

@FindBy(xpath="//a[@id='ui-id-3']//span[1]")
	WebElement lnkWhatsNew;
		
@FindBy(xpath="//span[@class='base' and @data-ui-id='page-title-wrapper']")
	 WebElement txtTitle;
	 

public void clickWhatsNew()
{
	lnkWhatsNew.click();
}

public String getConfirmationMsg() {
	try {
		return (txtTitle.getText());
	} catch (Exception e) {
		return (e.getMessage());
	}
 }


}
