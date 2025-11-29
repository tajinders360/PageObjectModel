package FrameworkDesign.tests;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import SeleniumFrameworkNew.testcomponents.BaseTest;
import SeleniumFrameworkNew.testcomponents.Retry;
import framework.pageobjects.CartPage;
import framework.pageobjects.CheckoutPage;
import framework.pageobjects.ConfirmationPage;
import framework.pageobjects.Productpage;

public class ErrorValidations extends  BaseTest
{
	@Test(groups={"ErrorHandling"},retryAnalyzer=Retry.class)

	public void LoginErrorValidation() throws IOException, InterruptedException
	{
		  
			//String productname = "ZARA COAT 3";
			
		   landing.loginapp("rahulshetty@gmail.com", "Iamki@000");
			Assert.assertEquals("Incorrect email or password.",landing.getErrorMessage());
			
}

 @Test
 public void ProductErrorValidation() throws IOException, InterruptedException {
  
  String productname = "ZARA COAT 3";
  
  Productpage productpage = landing.loginapp("rahulshetty@gmail.com", "Iamking@000");
  List<WebElement> elementList =productpage.getproductAppear();
  
  productpage.AddProductToCart(productname); CartPage cartpage =
  productpage.GoToCartPage(); 
  Boolean match = cartpage.VerifyProductDisplay("ZARA COAT 33"); 
  Assert.assertFalse(match);
  
  }
 
	
	
}