package com.testscript;


import java.io.IOException;


import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.utility.ExcelUtility;



public class AlibabaTest1 extends TestBase{
	@Test(dataProvider = "getInput")
	public void signInFail(String Input3, String Input4) throws InterruptedException, IOException {
		

		alibaba.getSigninlink().click();

		alibaba.getUserId().sendKeys(Input3);
		alibaba.getPassword().sendKeys(Input4);
		alibaba.getChechinbox().isSelected();
		alibaba.getSigninbutton().click();
		CaptureScreenshot(driver,"signInFail");
		Thread.sleep(5000);
		
	
	}
	@DataProvider
	public String[][] getInput() throws IOException {
		String xlPath = "F:\\Eclipse WrokSpace\\automation1\\src\\test\\java\\com\\qa\\testdata\\TestData.xlsx";

		String xlSheet = "Sheet2";

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
