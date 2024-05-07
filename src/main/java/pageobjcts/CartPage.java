package pageobjcts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
	
	WebDriver driver;
	 public CartPage(WebDriver driver) {
			this.driver=driver;
			PageFactory.initElements(driver, this);
		}
	    
	
	@FindBy(xpath="//input[@class='a-button-input' and @type='submit' and @aria-labelledby='attach-sidesheet-view-cart-button-announce']")
	WebElement shoppingCart;

	@FindBy(id="quantity")
			WebElement qty;
	
	@FindBy(css="div.a-row > h1")
	WebElement cart;
	
	public WebElement shoppingCat() {
		return shoppingCart;
	}
	
	public WebElement qty() {
		return qty;
	}
	public WebElement cart() {
		return cart;
	}

}
