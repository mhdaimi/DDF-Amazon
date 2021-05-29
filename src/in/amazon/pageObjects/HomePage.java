package in.amazon.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
	
	public static void enterSearchText(WebDriver browser, String inputText) {
		browser.findElement(By.id("twotabsearchtextbox")).sendKeys(inputText);
	}

	public static void clickSearch(WebDriver browser) {
		browser.findElement(By.id("nav-search-submit-button")).click();
	}
}
