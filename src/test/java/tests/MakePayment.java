package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
//import org.openqa.selenium.support.ui.Select;


public class MakePayment extends BaseClass{
	
	@Test
	public void payment() {
		try {
			Thread.sleep(500);
			driver.findElement(By.id("com.experitest.ExperiBank:id/makePaymentButton")).click();
			Thread.sleep(500);
			driver.findElement(By.id("com.experitest.ExperiBank:id/phoneTextField")).sendKeys("+234801234567");
			driver.findElement(By.id("com.experitest.ExperiBank:id/nameTextField")).sendKeys("Hero");
			driver.findElement(By.id("com.experitest.ExperiBank:id/amountTextField")).sendKeys("1");
			driver.findElement(By.id("com.experitest.ExperiBank:id/countryButton")).click();
			driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.ListView/android.widget.TextView[1]")).click();
			driver.findElement(By.id("com.experitest.ExperiBank:id/sendPaymentButton")).click();
			Thread.sleep(500);
			driver.findElement(By.id("android:id/button1")).click();
			Thread.sleep(500);
			String pageSource = driver.getPageSource();
			String expectedText = "Your balance is: 99.00$";
			Assert.assertTrue(pageSource.contains(expectedText));
			
			} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
