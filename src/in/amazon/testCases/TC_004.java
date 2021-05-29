package in.amazon.testCases;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import in.amazon.objectRepo.TestObjects;
import in.amazon.pageObjects.HomePage;
import in.amazon.pageObjects.SearchResults;
import in.amazon.utilities.BrowserInit;
import in.amazon.utilities.Excel;
import in.amazon.utilities.PageScroll;
import in.amazon.utilities.TestResults;

public class TC_004 {
	
	ArrayList<String> data;
	WebDriver browser;
	Logger log;
	
	@BeforeMethod
	public void before() throws Exception {
		log = LogManager.getLogger("amazon");
		data = Excel.getRowData("TC_004", 0);
	}
  
	@Test
  public void tc_004() throws Exception {
		browser = BrowserInit.getBrowser(TestObjects.browserName);
		browser.get(TestObjects.url);
		HomePage.enterSearchText(browser, data.get(0));
		HomePage.clickSearch(browser);
		PageScroll.byPixel("1500", browser);
		SearchResults.filterResultByRAM(browser, data.get(1));
		SearchResults.filterResultByPrice(browser, data.get(2), data.get(3));
		String text = SearchResults.getFilteredResultText(browser);
		Assert.assertEquals(text, data.get(4));
  }
	
	@AfterMethod
	public void after(ITestResult result) {
		TestResults.verify(result, browser, log);
		browser.close();
	}
	
}
