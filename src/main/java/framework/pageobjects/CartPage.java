package framework.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import framework.Abstractcomponents.Abstractcomponents;


public class CartPage extends Abstractcomponents 
{
	WebDriver driver;
	
	@FindBy(css=".totalRow button")
	WebElement checkoutEle;
	
	@FindBy(css=".cartSection h3")
	private List<WebElement> cartproduct;
	
	public CartPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		 PageFactory.initElements(driver, this);
		
	}
	public Boolean VerifyProductDisplay(String productname)
	{
		Boolean match = cartproduct.stream()
				.anyMatch(cartproducts -> cartproducts.getText().equalsIgnoreCase(productname));
		return match;
	}
	public CheckoutPage GoToCheckOut()
	{
		checkoutEle.click();
		   return new CheckoutPage(driver);
	}
	

}
