package com.testscript;

import org.testng.annotations.Test;

import com.utility.ExcelUtility;

import java.io.IOException;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;

public class AlibabaTest extends TestBase {

	@Test(dataProvider = "getData", priority = 1)
	public void signIn(String Input1, String Input2) throws InterruptedException, IOException {

		alibaba.getSigninlink().click();

		alibaba.getUserId().sendKeys(Input1);
		alibaba.getPassword().sendKeys(Input2);
		alibaba.getChechinbox().isSelected();
		alibaba.getSigninbutton().click();
		CaptureScreenshot(driver, "signIn");
		Thread.sleep(5000);

	}

	@Test(dataProvider = "getValue", priority = 2)
	public void SearchForItems(String Input) throws InterruptedException, IOException

	{
		alibaba.getSearchItem().clear();
		alibaba.getSearchItem().sendKeys(Input);
		CaptureScreenshot(driver, "SearchForItems");
		alibaba.getSearchItem().submit();
		Thread.sleep(3000);

	}

	@Test(priority = 3)
	public void SignOutAlibaba() throws InterruptedException, IOException {

		WebElement ele = alibaba.getMyaccountaction();
		action.moveToElement(ele).perform();
		Thread.sleep(2000);
		CaptureScreenshot(driver, "SignOutAlibaba");
		WebElement ele1 = alibaba.getSignOut();
		action.moveToElement(ele1).perform();
		alibaba.getSignOut().click();
		Thread.sleep(2000);
	}

	@DataProvider
	public String[][] getData() throws IOException {
		String xlPath = "F:\\Eclipse WrokSpace\\automation1\\src\\test\\java\\com\\qa\\testdata\\TestData.xlsx";

		String xlSheet = "Sheet1";

		int rowCount = ExcelUtility.getRowCount(xlPath, xlSheet);

		int cellCount = ExcelUtility.getCellCount(xlPath, xlSheet, rowCount);

		String[][] data = new String[rowCount][cellCount];

		for (int i = 1; i <= rowCount; i++) {
			for (int j = 0; j < cellCount; j++) {
				data[i - 1][j] = ExcelUtility.getCellData(xlPath, xlSheet, i, j);

			}
		}

		return data;

	}

	@DataProvider
	public String[][] getValue() throws IOException {
		String xlPath = "F:\\Eclipse WrokSpace\\AutomationTest\\src\\test\\java\\com\\qa\\testdata\\TestData1.xlsx";

		String xlSheet = "Sheet1";

		int rowCount = ExcelUtility.getRowCount(xlPath, xlSheet);

		int cellCount = ExcelUtility.getCellCount(xlPath, xlSheet, rowCount);

		String[][] data = new String[rowCount][cellCount];

		for (int i = 1; i <= rowCount; i++) {
			for (int j = 0; j < cellCount; j++) {
				data[i - 1][j] = ExcelUtility.getCellData(xlPath, xlSheet, i, j);

			}
		}

		return data;
	}

}