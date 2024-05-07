package tests;

import java.io.IOException;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageobjcts.CartPage;
import pageobjcts.HomePage;
import pageobjcts.ProductPage;
import resources.Base;

public class CartTest extends Base {
	public Logger log;
	public WebDriver driver;
	

	@BeforeMethod
	public void open() throws IOException {
		log = LogManager.getLogger(CartTest.class.getName());

		driver = initializeBrowser();
		log.debug("Browser got launched");
		driver.get(prop.getProperty("url"));
		log.debug("Navigated to application URL");
	}

	@Test(dataProvider="getSearchData")
	public void AddToCart(String keyword) throws InterruptedException {

		HomePage page = new HomePage(driver);
		page.searchBox().sendKeys(keyword);
		log.debug("Search entered");
		page.search().click();
		log.debug("Search button clicked");

		if (page.Pcard().isDisplayed())
		{
			page.Pcard().click();
			log.debug("Product opened");

			

		}

		String mainWindowHandle = driver.getWindowHandle();
		Set<String> allWindowHandles = driver.getWindowHandles();

		for (String handle : allWindowHandles) {
			if (!handle.equals(mainWindowHandle)) {
				
				driver.switchTo().window(handle);
				log.debug("Switched to new window");

				break;
			}
		}

		ProductPage Ppage = new ProductPage(driver);

		if (Ppage.breadCrumb().isDisplayed()) {

			Ppage.addToCart().click();
			log.debug("Add to cart button clicked");

			Assert.assertEquals(Ppage.successStatus().getText(), "Added to Cart");
			log.info("Added to cart successfully");
			
			CartPage cPage=new CartPage(driver);
			cPage.shoppingCat().click();
			log.debug("Naviagted to cart");

			
			Assert.assertTrue(cPage.cart().isDisplayed());
			log.debug("Cart is displayed");

//			Select quantity= new Select(cPage.qty());
//			quantity.selectByValue("2");
//			Assert.assertTrue(false);
//			log.debug("More than 1 qty not allowed");

			Thread.sleep(5000);

		}
		
		

	}
	
	
	

	@AfterMethod
	public void closure() {
		driver.close();
		log.debug("Browser got closed");
	}
	@DataProvider

	public Object[] getSearchData() {
		Object[] data = { "One Plus 11R" };
		return data;

	}

}
