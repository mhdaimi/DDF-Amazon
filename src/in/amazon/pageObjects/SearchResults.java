package in.amazon.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResults {
	
	public static String getSearchResultText(WebDriver browser) {
		String value = browser.findElement(By.cssSelector("span.a-color-state")).getText();
		return value;
	}
	
	public static void filterResultByRAM(WebDriver browser, String value) {
		browser.findElement(By.xpath("//li[@aria-label='" + value + "']/span/a/div/label/i")).click();
	}
	
	public static void filterResultByPrice(WebDriver browser, String lowPrice, String highPrice) {
		browser.findElement(By.id("low-price")).sendKeys(lowPrice);
		browser.findElement(By.id("high-price")).sendKeys(highPrice);
		browser.findElement(By.cssSelector("input.a-button-input")).click();
	}
	
	public static String getFilteredResultText(WebDriver browser) {
		String value = browser.findElement(By.cssSelector("div.a-spacing-top-small > span")).getText();
		return value;
	}
	
	public static void clickItemWithValue(WebDriver browser, String value) {
		browser.findElement(By.partialLinkText(value)).click();
	}

}
