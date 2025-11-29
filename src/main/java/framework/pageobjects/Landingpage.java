package framework.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import framework.Abstractcomponents.Abstractcomponents;

public class Landingpage extends Abstractcomponents {
	public WebDriver driver;
	
	public Landingpage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		 PageFactory.initElements(driver, this);//intialize elements
	}
	
     @FindBy(id="userEmail")
      WebElement useremail;
     
     @FindBy(id="userPassword")
     WebElement password;
     
     @FindBy(id="login")
     WebElement submit;
    
     @FindBy(css="[class*='flyInOut']")
     WebElement errormessage;
   //div[@class='ng-tns-c4-2 ng-star-inserted ng-trigger ng-trigger-flyInOut ngx-toastr toast-error']

     
     public Productpage loginapp(String email,String pwd)
     {
    	 useremail.sendKeys(email);
    	 password.sendKeys(pwd);
    	 submit.click();
    	 Productpage productpage=new Productpage(driver);
    	 return productpage;
  
     }
     public String getErrorMessage()
     {
    	 waitforWebElementtoAppear(errormessage);
    	 return errormessage.getText();
     }
   
    public void geturl()
    {
     driver.get("https://rahulshettyacademy.com/client");
  
     }

}
