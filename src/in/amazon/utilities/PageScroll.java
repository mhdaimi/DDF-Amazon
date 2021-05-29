package in.amazon.utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class PageScroll {
	
	public static void byPixel(String pixels, WebDriver browser) {
		JavascriptExecutor js = (JavascriptExecutor) browser;
		js.executeScript("window.scrollBy(0," + pixels + ")");
		
	}

}
