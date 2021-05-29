package in.amazon.utilities;

import java.io.File;
import java.io.IOException;
import java.time.LocalTime;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

import in.amazon.objectRepo.TestObjects;

public class TestResults {
	
	public static void verify(ITestResult result, WebDriver browser, Logger log) {
		if(ITestResult.FAILURE == result.getStatus()) {
			log.fatal("Test case failed, will capture screenshot");
			captureScreenshot(result.getName(), browser, log);
		}
	}
	
	public static void captureScreenshot(String testName, WebDriver browser, Logger log) {
		String fileName = testName + "_" + LocalTime.now().getMinute() + "_" + LocalTime.now().getSecond() + ".jpg";
		TakesScreenshot ss = (TakesScreenshot) browser;
		File temp = ss.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(temp, new File(TestObjects.screenShotDir + fileName));
			log.info("Captured screenshot to file: " + TestObjects.screenShotDir + fileName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.warn("Failed to capture screenshot");
		}
		
		
	}

}
