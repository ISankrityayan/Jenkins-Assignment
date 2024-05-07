package tests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageobjcts.HomePage;
import resources.Base;

public class SortTest extends Base {

public Logger log;
public WebDriver driver;

	
	@BeforeMethod
	public void open() throws IOException {
		log = LogManager.getLogger(SortTest.class.getName());

		driver = initializeBrowser();
		log.debug("Browser got launched");
		driver.get(prop.getProperty("url"));
		log.debug("Navigated to application URL");
		
		
	}
	
	@Test(dataProvider="getSearchData")
	public void Search(String keyword) throws InterruptedException {
		HomePage page=new HomePage(driver);
		page.searchBox().sendKeys(keyword);
		log.debug("Search entered");
		page.search().click();
		log.debug("Search button clicked");
		
		if(page.tops().isDisplayed()) {
			
			page.featureBut().click();
			page.lth().click();
			
			
			
			Assert.assertTrue(page.lthbutton().isDisplayed());
			log.info("Sort test passed");
			
			
			
		}
		
		
		
	}
	
	@AfterMethod
	public void closure() {
		driver.close();
		log.debug("Browser got closed");
	}
	@DataProvider

	public Object[]getSearchData() {
		Object[] data= {"Women Tops"} ;
		return data;
		
	}
	

}
