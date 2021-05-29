package in.amazon.testCases;

import org.testng.annotations.Test;

import in.amazon.objectRepo.TestObjects;
import in.amazon.pageObjects.CartAction;
import in.amazon.pageObjects.CommonMethods;
import in.amazon.pageObjects.HomePage;
import in.amazon.pageObjects.SearchResults;
import in.amazon.utilities.BrowserInit;
import in.amazon.utilities.Excel;

import org.testng.annotations.BeforeMethod;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class TC_005 {
	
	ArrayList<String> data;
	WebDriver browser;
	
  @Test
  public void tc_005() throws Exception {
	  browser = BrowserInit.getBrowser(TestObjects.browserName);
	  browser.get(TestObjects.url);
	  
	  HomePage.enterSearchText(browser, data.get(0));
	  HomePage.clickSearch(browser);
	  
	  SearchResults.filterResultByPrice(browser, data.get(1), data.get(2));
	  
	  //browser.findElement(By.partialLinkText(data.get(3))).click();
	  SearchResults.clickItemWithValue(browser, data.get(3));
	  browser = CommonMethods.switchToTab(browser);
	  CartAction.clickAddToCart(browser);
	  CartAction.viewCart(browser);
	  String qty = CartAction.getCartItemQuantity(browser);
	  String cartValue = CartAction.getCartSubTotalAmount(browser);
	  Assert.assertEquals(qty, data.get(4));
	  Assert.assertEquals(cartValue, data.get(5));
	  //browser = CommonMethods.switchToparentWindow(browser);
	  
//	  String parentWindow = browser.getWindowHandle();
//	  Set<String> allWindows = browser.getWindowHandles();
//	  
//	  for (String windowID : allWindows) {
//		  if(! windowID.equals(parentWindow)) {
//			  browser.switchTo().window(windowID);
//			  browser.findElement(By.id("add-to-cart-button")).click();
//			  browser.findElement(By.id("hlb-view-cart-announce")).click();
//			  String qty = browser.findElement(By.cssSelector("span.a-dropdown-prompt")).getText();
//			  System.out.println(qty);
//			  Assert.assertEquals(qty, data.get(4));
//			  String subTotalVal = browser.findElement(By.id("sc-subtotal-amount-activecart")).getText();
//			  System.out.println(subTotalVal);
//			  Assert.assertEquals(subTotalVal.trim(), data.get(5));
//		  }
//		  
//	}
  }
  
  @BeforeMethod
  public void beforeMethod() throws Exception {
	  data = Excel.getRowData("TC_005", 0);
	  
  }

  @AfterMethod
  public void afterMethod() {
	  browser.quit();
  }

}
