package pageobjcts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {
	WebDriver driver;
	
	public SignInPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
		
		@FindBy(id="ap_email")
		WebElement emailField;
		
		@FindBy(xpath="//span[@id='continue' and contains(@class, 'a-button')]")
		WebElement continueButton;
		
		public WebElement emailField() {
			return  emailField;
		}
		


		public WebElement continueButton() {
			return continueButton;
		}
	}


