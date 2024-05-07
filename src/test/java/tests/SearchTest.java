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
import resources.Base;

public class SearchTest extends Base {
	Logger log;
	WebDriver driver;
	
	
	@BeforeMethod
	public void open() throws IOException {
		log = LogManager.getLogger(SearchTest.class.getName());

		driver = initializeBrowser();
		log.debug("Browser got launched");
		driver.get(prop.getProperty("url"));
		log.debug("Navigated to application URL");
		
	}
	
	@Test(dataProvider="getSearchData")
	public void Search(String keyword,String expectedRes) throws InterruptedException {
		HomePage page=new HomePage(driver);
		page.searchBox().sendKeys(keyword);
		log.debug("Search entered");

		page.search().click();
		log.debug("Search button clicked");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String actualRes = null;
		
		try {
			if(page.Pcard().isDisplayed())
				actualRes="Success";
		}
		catch(Exception e)
		{
			actualRes="Fail";
		}
		
		Assert.assertEquals(actualRes, expectedRes);
		log.info("Search Test passed");

	}
	
	@AfterMethod
	public void closure() {
		driver.close();
		log.debug("Browser got closed");
	}
	@DataProvider

	public Object[][] getSearchData() {
		Object[][] data= {{"One Plus 11R", "Success"} ,{" ", "Fail"}} ;
		return data;
		
	}
	
	

}
