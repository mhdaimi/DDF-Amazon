package in.amazon.testCases;

import org.testng.annotations.Test;

import in.amazon.objectRepo.TestObjects;
import in.amazon.pageObjects.HomePage;
import in.amazon.pageObjects.SearchResults;
import in.amazon.utilities.BrowserInit;
import in.amazon.utilities.Excel;
import in.amazon.utilities.TestResults;

import org.testng.annotations.BeforeMethod;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

public class Prajakta_001 {
	ArrayList<String> data;
	 WebDriver browser;
	 Logger log;
	
  @Test
  public void praju_001() throws Exception {
	  browser = BrowserInit.getBrowser(TestObjects.browserName);
	  browser.get(TestObjects.url);
	  HomePage.enterSearchText(browser, data.get(0));
	  HomePage.clickSearch(browser);
	  Assert.assertEquals(SearchResults.getSearchResultText(browser), data.get(1));
  
  }
	@Test
  public void praju_001() throws Exception {
	  browser = BrowserInit.getBrowser(TestObjects.browserName);
	  browser.get(TestObjects.url);
	  HomePage.enterSearchText(browser, data.get(3));
	  HomePage.clickSearch(browser);
	  Assert.assertEquals(SearchResults.getSearchResultText(browser), data.get(4));

  }
  
  @BeforeMethod
  public void beforeMethod() throws Exception {
	  log = LogManager.getLogger("amazon");
		data = Excel.getRowData("Praju_001", 0);
	}
  

  @AfterMethod
  public void afterMethod(ITestResult result) {
	  TestResults.verify(result, browser, log);
		browser.close();
	
  }

}
