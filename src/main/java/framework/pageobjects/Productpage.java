package framework.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import framework.Abstractcomponents.Abstractcomponents;


public class Productpage extends Abstractcomponents
{
WebDriver driver;
	
	public Productpage (WebDriver driver)
	
	{
        super(driver);
		this.driver=driver;
		 PageFactory.initElements(driver, this);//intialize elements
	}
	
	@FindBy(css=".mb-3")
	List<WebElement> elementList;
	@FindBy(css=".ng-animating")
	WebElement spinner;
	By productBy=By.cssSelector(".mb-3");
	By addtocart=By.cssSelector(".card-body button:last-of-type");
	By toastmessage=By.cssSelector("#toast-container");
	public List<WebElement> getproductAppear()
	{
		waitforElementtoAppear(productBy);
		return elementList;
		
	}
	public WebElement getProductByName(String productname)
	{
		WebElement prod = getproductAppear().stream()
				.filter(elementlist -> elementlist.findElement(By.cssSelector("b")).getText().equals(productname))
				.findFirst().orElse(null);
		return prod;
	}
	
	public void AddProductToCart(String productname) throws InterruptedException
	{
		WebElement prod=getProductByName(productname);
		prod.findElement(addtocart).click();
		 waitforElementtoAppear(toastmessage);
		 waitforElementtoDisAppear(spinner);

	}

}
