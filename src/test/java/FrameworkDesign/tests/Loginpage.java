package FrameworkDesign.tests;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.idealized.Javascript;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

import SeleniumFrameworkNew.testcomponents.BaseTest;
import framework.pageobjects.CartPage;
import framework.pageobjects.CheckoutPage;
import framework.pageobjects.ConfirmationPage;
import framework.pageobjects.Landingpage;
import framework.pageobjects.OrderPage;
import framework.pageobjects.Productpage;

public class Loginpage extends BaseTest 
{
	
	String productname = "ZARA COAT 3";
	String productname1 = "ADIDAS ORIGINAL";
	

@Test(dataProvider="getData",groups={"Purchase"})
public void submitorder(HashMap<String,String> input) throws IOException, InterruptedException
{
	  
		//String productname = "ZARA COAT 3";
		
		Productpage productpage = landing.loginapp(input.get("email"),input.get("password"));
		List<WebElement> elementList  = productpage.getproductAppear();
        productpage.AddProductToCart(input.get("product"));
        productpage.AddProductToCart(input.get("product"));
		CartPage cartpage = productpage.GoToCartPage();
		Boolean match = cartpage.VerifyProductDisplay(input.get("product"));
		Assert.assertTrue(match);
		Thread.sleep(2000);
		CheckoutPage checkoutpage = cartpage.GoToCheckOut();
		checkoutpage.selectCountry("India");
		Thread.sleep(2000);
		
        ConfirmationPage confirmationpage = checkoutpage.submitOrder();
        String confirmpage = confirmationpage.getConfirmationpage();
		Assert.assertTrue(confirmpage.equalsIgnoreCase("Thankyou for the order."));
	
		}
//Create test methods with dependency

@Test(dependsOnMethods="submitorder")
public void OrderHistoryTest()
{
	
	//Productpage productpage = landing.loginapp("testuser0590@gmail.com", "Test@123");
	Productpage productpage = landing.loginapp("rahulshetty@gmail.com", "Iamking@000");
	OrderPage orderpage=productpage.GoToOrderPage();
	Assert.assertTrue(orderpage.VerifyOrderDisplay(productname));
}



  @DataProvider
public Object[][] getData() throws IOException
{
	
	
	  HashMap<String,String> map=new HashMap<String,String>(); 
	  map.put("email","rahulshetty@gmail.com");
	  map.put("password", "Iamking@000");
	  map.put("product","ZARA COAT 3");
	 
	  
	  HashMap<String,String> map1=new HashMap<String,String>();
	  map1.put("email","rahulshetty@gmail.com"); 
	  map1.put("password", "Iamking@000");
	  map1.put("product", "ADIDAS ORIGINAL");
	 
	  return new Object[][] {{map} , {map1}};
	/*
	 * List<HashMap<String,String>> data=getjsonDataToMap(System.getProperty(
	 * "C:\\Users\\Tajinder\\eclipse-workspace\\PageObjectModel\\src\\test\\java\\FrameworkDesign\\data\\PurchaseOrder.json"
	 * )); return new Object[][] { {data.get(0)} , {data.get(1)} };
	 */
	 
	 
	 //return new Object[][] { {"anshika@gmail.com","Iamking@000","ZARA COAT 3"} , {"rahulshetty@gmail.com","Iamking@00","ADIDAS ORIGINAL"} };
}
  
}