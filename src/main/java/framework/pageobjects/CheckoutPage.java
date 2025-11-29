package framework.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import framework.Abstractcomponents.Abstractcomponents;

public class CheckoutPage extends Abstractcomponents {
	WebDriver driver;

	public CheckoutPage(WebDriver driver) {
		super(driver);

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = ".action__submit")
	WebElement submit;

	@FindBy(css = "[placeholder='Select Country']")
	WebElement country;

	@FindBy(xpath = "//button[contains(@class,'ta-item')][2]")
	WebElement selectCountry;

	By results = By.cssSelector(".ta-results");

	public void selectCountry(String countryName) {

		Actions a = new Actions(driver);
		a.sendKeys(country, countryName).build().perform();
		waitforElementtoAppear(By.cssSelector(".ta-results"));
		selectCountry.click();
	}

	public ConfirmationPage submitOrder() {
		Actions a = new Actions(driver);
		a.scrollToElement(submit).perform();
		submit.click();
		return new ConfirmationPage(driver);
	}
}
