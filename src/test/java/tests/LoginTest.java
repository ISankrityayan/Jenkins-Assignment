package tests;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageobjcts.HomePage;
import pageobjcts.OTPPage;
import pageobjcts.SignInPage;
import resources.Base;

public class LoginTest extends Base {

	public Logger log;
	public WebDriver driver;
	

	@Test(dataProvider = "getLoginData")

	public void login(String email, String status) throws IOException {

		HomePage homePage = new HomePage(driver);
		homePage.signIn().click();
		log.debug("Clicked on SignIn dropdown");

		SignInPage signin = new SignInPage(driver);
		signin.emailField().sendKeys(email);
		log.debug("Email addressed got entered");

		signin.continueButton().click();
		log.debug("Clicked on continue option");

		OTPPage otp = new OTPPage(driver);
		String actualRes = null;
		
		if (email.isEmpty()) {
	        log.error("Email is empty. Test case failed.");
	        Assert.assertEquals("Fail", status);
	    } else {
	        try {
	            if (otp.otpPage().isDisplayed()) {
	                log.debug("Email entered successfully");
	                actualRes = "Success";
	            }
	        } catch (Exception e) {
	            log.debug("User didn't log in");
	            actualRes = "Fail";
	        }

	        if (actualRes.equals(status)) {
	            log.info("Login Test passed");
	        } else {
	            log.error("Login Test failed");
	            Assert.fail("Login Test failed");
	        }
	    }


	}

	@BeforeMethod

	public void open() throws IOException {
		log = LogManager.getLogger(LoginTest.class.getName());

		driver = initializeBrowser();
		log.debug("Browser got launched");
		driver.get(prop.getProperty("url"));
		log.debug("Navigated to application URL");

	}

	@AfterMethod
	public void closure() {
		driver.close();
		log.debug("Browser got closed");
	}

	@DataProvider
	public Object[] getLoginData() {
		Object[] data =  { "ishita@gmail.com", "Success" };
		return data;

	}

}
