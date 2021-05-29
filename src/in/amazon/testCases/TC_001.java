package in.amazon.testCases;

import java.util.ArrayList;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import in.amazon.objectRepo.TestObjects;
import in.amazon.utilities.BrowserInit;
import in.amazon.utilities.Excel;
import in.amazon.utilities.TestResults;

public class TC_001 {
	
	ArrayList<String> data;
	WebDriver browser;
	Logger log;
	
	@BeforeMethod
	public void before() throws Exception {
		log = LogManager.getLogger("amazon");
		log.info("Starting to read data from excel file");
		data = Excel.getRowData("TC_001", 0);
		log.info("Successfully retrieved data from excel file");
	}

	@Test
	  public void tc_001() throws Exception {
			log.info("Creating browser object");
			browser = BrowserInit.getBrowser(TestObjects.browserName);
			log.info("Browser object created successfully");
			log.info("Open url :" + TestObjects.url);
			browser.get(TestObjects.url);
			String title = browser.getTitle();
			log.info("Asserting the title");
			Assert.assertEquals(title, data.get(0));
	  }
	
	@AfterMethod
	public void after(ITestResult result) throws Exception {
		TestResults.verify(result, browser, log);
		browser.close();
	}
	
	
	
}
