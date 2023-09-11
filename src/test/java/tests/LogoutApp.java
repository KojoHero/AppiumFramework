package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;

public class LogoutApp extends BaseClass{
	
	@Test
	public void logout() {
		try {
			driver.findElementById("com.experitest.ExperiBank:id/logoutButton").click();
			Thread.sleep(100);
			MobileElement element = driver.findElementById("com.experitest.ExperiBank:id/loginButton");
			String expectedText = element.getText();
			String actualText = "Login";
			Assert.assertEquals(expectedText, actualText);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
