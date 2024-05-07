package pageobjcts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OTPPage {
	
	WebDriver driver;
	public OTPPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	 @FindBy(xpath = "//span[@class='a-button a-button-span12 a-button-primary' and @id='a-autoid-0']")

	WebElement otpPage;
	
	public WebElement otpPage() {
		return otpPage;
	}
	
	

}
