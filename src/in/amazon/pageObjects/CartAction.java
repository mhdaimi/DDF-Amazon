package in.amazon.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartAction {
	
	public static void clickAddToCart(WebDriver browser) {
		browser.findElement(By.id("add-to-cart-button")).click();
	}

	public static void viewCart(WebDriver browser) {
		browser.findElement(By.id("hlb-view-cart-announce")).click();
	}
	
	public static String getCartItemQuantity(WebDriver browser) {
		String qty = browser.findElement(By.cssSelector("span.a-dropdown-prompt")).getText();
		return qty;
	}
	
	public static String getCartSubTotalAmount(WebDriver browser) {
		String subTotalVal = browser.findElement(By.id("sc-subtotal-amount-activecart")).getText();
		return subTotalVal.trim();
	}
	
}
