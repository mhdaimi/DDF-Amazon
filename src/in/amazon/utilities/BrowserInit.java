package in.amazon.utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserInit {
	
	static WebDriver browser;
		
	public static WebDriver getChromeBrowser() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Data\\Jars-Exe\\chromedriver_win32\\chromedriver.exe");
		WebDriver browser = new ChromeDriver();
		browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		browser.manage().window().maximize();
		
		return browser;
		
		
	}
	
	public static WebDriver getFirefoxBrowser() {
		
		System.setProperty("webdriver.gecko.driver", "C:\\Data\\Jars-Exe\\geckodriver-v0.29.1-win64\\geckodriver.exe");
		WebDriver browser = new FirefoxDriver();
		browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		browser.manage().window().maximize();
		
		return browser;
		
		
	}
	
	
	public static WebDriver getBrowser(String browserName) throws Exception {
		
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Data\\Jars-Exe\\chromedriver_win32\\chromedriver.exe");
			browser = new ChromeDriver();		
		}
		else if(browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Data\\Jars-Exe\\geckodriver-v0.29.1-win64\\geckodriver.exe");
			browser = new FirefoxDriver();
		}
		else {
			throw new Exception("Invalid Browser Name");
		}
		
		browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		browser.manage().window().maximize();
		
		return browser;
	}
	
	
	

}
