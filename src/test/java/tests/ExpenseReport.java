package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;

public class ExpenseReport extends BaseClass{
	
	@Test
	public void addExpenses() {
		driver.findElementById("com.experitest.ExperiBank:id/expenseReportButton").click();
		try {
			Thread.sleep(500);
			String pageSource = driver.getPageSource();
			String expectedText = "Expense : 1";
			Assert.assertTrue(pageSource.contains(expectedText));
			driver.findElementById("com.experitest.ExperiBank:id/addButton").click();
			driver.findElementById("com.experitest.ExperiBank:id/addButton").click();
			Thread.sleep(500);
			java.util.List<MobileElement> elements = driver.findElementsById("com.experitest.ExperiBank:id/detailTextView");
			int textCounted = elements.size();
	        Assert.assertEquals(textCounted, 3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void removeExpenses() {
		driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.ListView/android.widget.LinearLayout[1]/android.widget.TextView[1]").click();
		String pageSource = driver.getPageSource();
		String textCount = "Detail goes here";
        long textCounter = pageSource.chars().filter(ch -> ch == textCount.charAt(0)).count();
        Assert.assertEquals(textCounter, 2);
	}

}
