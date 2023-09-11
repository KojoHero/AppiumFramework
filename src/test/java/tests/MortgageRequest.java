package tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;



public class MortgageRequest extends BaseClass{
	
	@Test
	public void mortage() {
		try {
			Thread.sleep(500);
			driver.findElementById("com.experitest.ExperiBank:id/mortageRequestButton").click();
			Thread.sleep(500);
			driver.findElementById("com.experitest.ExperiBank:id/nameTextField").sendKeys("Test");
			driver.findElementById("com.experitest.ExperiBank:id/lastNameTextField").sendKeys("Hero");
			driver.findElementById("com.experitest.ExperiBank:id/ageTextField").sendKeys("50");
			driver.findElementById("com.experitest.ExperiBank:id/addressOneTextField").sendKeys("Home");
			driver.findElementById("com.experitest.ExperiBank:id/addressTwoTextField").sendKeys("address");
			driver.findElement(By.id("com.experitest.ExperiBank:id/countryButton")).click();
			driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.ListView/android.widget.TextView[3]")).click();;
			driver.findElement(By.id("com.experitest.ExperiBank:id/nextButton")).click();
			Thread.sleep(500);
			driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.ListView[1]/android.widget.CheckedTextView[1]")).click();
			driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.ListView[2]/android.widget.CheckedTextView[1]")).click();			
			By lastElementLocator = MobileBy.id("com.experitest.ExperiBank:id/yearlyIncomeTextView");

	        while (true) {
	            try {
	                if (driver.findElement(lastElementLocator).isDisplayed()) {
	                    break;
	                }
	            } catch (Exception e) {
	                swipeUp(driver);
	    			
	            }
	        }
	        Thread.sleep(500);	    		
            driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.ListView[1]/android.widget.CheckedTextView[2]")).click();
			driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.ListView[2]/android.widget.CheckedTextView[2]")).click();

	        driver.findElementById("com.experitest.ExperiBank:id/saveButton").click();	

			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void swipeUp(AppiumDriver<MobileElement> driver) {
        int screenHeight = driver.manage().window().getSize().getHeight();
        int screenWidth = driver.manage().window().getSize().getWidth();
        int startx = screenWidth / 2;
        int starty = (int) (screenHeight * 0.8); // Adjust as needed
        int endy = (int) (screenHeight * 0.2); // Adjust as needed

        TouchAction touchAction = new TouchAction(driver);
        touchAction.press(PointOption.point(startx, starty))
                   .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                   .moveTo(PointOption.point(startx, endy))
                   .release()
                   .perform();
    }

}
