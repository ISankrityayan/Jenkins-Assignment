package pageobjcts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
	
WebDriver driver;
	 
    
    public ProductPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
    
    @FindBy(xpath="//a[@id='breadcrumb-back-link']")
   WebElement breadCrumb;
    
    @FindBy(xpath="//input[@id='add-to-cart-button' and @type='submit']")
    WebElement addToCart;
    
     @FindBy(css="div[id='attachDisplayAddBaseAlert'][class='a-box a-alert a-alert-success added-to-cart-message-box'] > "
     		+ "div[class='a-box-inner a-alert-container'] > h4[class='a-alert-heading']")
    		WebElement successStatus;
     
     public WebElement breadCrumb() {
    	 return breadCrumb;
     }
     
     public WebElement addToCart() {
    	 return addToCart;
     }
     
     public WebElement successStatus() {
    	 return successStatus;
     }


}
