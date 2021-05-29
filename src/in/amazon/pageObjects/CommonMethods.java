package in.amazon.pageObjects;

import java.util.Set;

import org.openqa.selenium.WebDriver;

public class CommonMethods {
	
	static String parentWindow;
	
	public static WebDriver switchToTab(WebDriver browser) {
		 parentWindow = browser.getWindowHandle();

		 Set<String> allWindows = browser.getWindowHandles();
		 for (String windowID : allWindows) {
			  if(! windowID.equals(parentWindow)) {
				  browser.switchTo().window(windowID);
			  }
		 }
		 
		return browser; 
		
	}
	
	public static WebDriver switchToparentWindow(WebDriver browser) {
		browser.switchTo().window(parentWindow);
		return browser;
	}

}
