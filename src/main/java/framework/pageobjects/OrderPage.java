package framework.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import framework.Abstractcomponents.Abstractcomponents;



	public class OrderPage extends Abstractcomponents 
	{
       WebDriver driver;
		
		@FindBy(css=".totalRow button")
		WebElement checkoutEle;
		
		@FindBy(css="tr td:nth-child(3)")
		private List<WebElement> productNames;
		
	
		public OrderPage(WebDriver driver)
		{
			super(driver);
			this.driver=driver;
			 PageFactory.initElements(driver, this);
		}



		public Boolean VerifyOrderDisplay(String productname)
		{
			Boolean match = productNames.stream()
					.anyMatch(cartproducts -> cartproducts.getText().equalsIgnoreCase(productname));
		
			return match;
		}
		public CheckoutPage GoToCheckOut()
		{
			checkoutEle.click();
			   return new CheckoutPage(driver);
		}
		

	

}
