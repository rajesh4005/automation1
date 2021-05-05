package com.testscript;

import org.openqa.selenium.interactions.Actions;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import com.pages.AlibabaPage;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestBase {
	WebDriver driver;
	SoftAssert SAssert;
	AlibabaPage alibaba;

	Actions action;

	@BeforeClass
	@Parameters({ "Url" })
	public void setUp(String Url) {

		System.setProperty("webdriver.chrome.driver", "F:\\Virtusa. softwares\\driver\\chromedriver.exe");
		driver = new ChromeDriver();

		alibaba = new AlibabaPage(driver);
		action = new Actions(driver);
		driver.get(Url);
		SAssert = new SoftAssert();

	}

	public void CaptureScreenshot(WebDriver driver, String name) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File Source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(
				System.getProperty("user.dir") + "/Screenshots/" + name + System.currentTimeMillis() + ".png");
		FileUtils.copyFile(Source, target);
		System.out.println("Screenshot captured");

	}

	@AfterClass
	public void tearDown() {
		driver.close();
	}

}
