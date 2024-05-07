package pageobjcts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
WebDriver driver;
	 
    
    public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
    
    @FindBy(xpath="//a[@id='nav-link-accountList']")
    WebElement signIn;
    
    @FindBy(id="twotabsearchtextbox")
    WebElement searchBox;
    
    @FindBy(id="nav-search-submit-button")
    WebElement search;
    
    @FindBy(xpath="//span[@class='a-size-medium a-color-base a-text-normal']")
    WebElement Pcard;
    
   @FindBy(css="div.a-section.a-spacing-small.a-spacing-top-small > span.a-color-state.a-text-bold")
   WebElement tops;
   
   @FindBy(xpath="//span[@class=\"a-button-text a-declarative\" and @id=\"a-autoid-0-announce\"]\r\n"
   		+ "")
   WebElement featureBut;
   

   @FindBy(xpath="//li[@class='a-dropdown-item' and @role='option']/a[@id='s-result-sort-select_1' and contains(text(), 'Price: Low to High')]\r\n"
   		+ "")
   WebElement lth;
   
   @FindBy(xpath="//img[@class='s-image' and @alt='Cread Craft Girls T-Shirt']\r\n"
   		+ "")
   WebElement lthbutton;
    
    public WebElement signIn() {
    	return signIn;
    }
    
    public WebElement searchBox() {
    	return searchBox;
    }
    
    public WebElement search() {
    	return search;
    }
    
    public WebElement Pcard() {
    	return Pcard;
    }
    
    public WebElement tops() {
    	return tops;
    }
    
    public WebElement featureBut() {
    	return featureBut;
    }
    
    public WebElement lthbutton() {
    	return lthbutton;
    }
    
    public WebElement lth() {
    	return lth;
    }
    
   

}
