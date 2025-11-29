package framework.Abstractcomponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import framework.pageobjects.CartPage;
import framework.pageobjects.OrderPage;

public class Abstractcomponents {
	
	WebDriver driver;

	public Abstractcomponents(WebDriver driver) {
		
		this.driver=driver;
		 PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(css="[routerlink*='cart']")
	WebElement cartheader;
	
	@FindBy(css="[routerlink*='myorders']")
	WebElement orderHeader;
	
	public void waitforElementtoAppear(By findBy)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
	public void waitforWebElementtoAppear(WebElement findBy)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(findBy));
	}
	public CartPage GoToCartPage()
	{
		cartheader.click();
		   CartPage cartpage=new CartPage(driver);
		   return cartpage;
	}
	
	public OrderPage GoToOrderPage()
	{
		orderHeader.click();
		OrderPage orderpage=new OrderPage(driver);
		return orderpage;
	}
	public void waitforElementtoDisAppear(WebElement ele) throws InterruptedException
	{
		Thread.sleep(2000);
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		//wait.until(ExpectedConditions.invisibilityOf(ele));
	}

}
