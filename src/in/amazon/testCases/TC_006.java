package in.amazon.testCases;

import org.testng.annotations.Test;

import in.amazon.objectRepo.TestObjects;
import in.amazon.pageObjects.CartAction;
import in.amazon.pageObjects.CommonMethods;
import in.amazon.pageObjects.HomePage;
import in.amazon.pageObjects.SearchResults;
import in.amazon.utilities.BrowserInit;
import in.amazon.utilities.Excel;
import in.amazon.utilities.PageScroll;

import org.testng.annotations.BeforeMethod;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class TC_006 {
	
	ArrayList<String> data;
	WebDriver browser;
	
  @Test
  public void tc_006() throws Exception {
	  
	  browser = BrowserInit.getBrowser(TestObjects.browserName);
	  browser.get(TestObjects.url);
	  
	  HomePage.enterSearchText(browser, data.get(0));
	  HomePage.clickSearch(browser);
	  
	  SearchResults.filterResultByPrice(browser, data.get(1), data.get(2));
	  
	  //PageScroll.byPixel("1200", browser);
	  
	  SearchResults.clickItemWithValue(browser, data.get(3));
	  
	  browser = CommonMethods.switchToTab(browser);
	  
	  CartAction.clickAddToCart(browser);
	  CartAction.viewCart(browser);
	  
	  String qty = CartAction.getCartItemQuantity(browser);
	  String value = CartAction.getCartSubTotalAmount(browser);
	  
	  Assert.assertEquals(qty, data.get(4));
	  Assert.assertEquals(value, data.get(5));
  }
  
  @BeforeMethod
  public void beforeMethod() throws Exception {
	  data = Excel.getRowData("TC_006", 0);
  }

  @AfterMethod
  public void afterMethod() {
  }

}
