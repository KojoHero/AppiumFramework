package tests;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class BaseClass {
	static AppiumDriver<MobileElement> driver;

	@BeforeTest
	public void setup() {
		try {
			DesiredCapabilities caps = new DesiredCapabilities();

			caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Galaxy S21 FE 5G");
			caps.setCapability(MobileCapabilityType.UDID, "R5CRC2405JM");
			caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
			caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "13");
			caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 60);
//			caps.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");
			caps.setCapability("appPackage", "com.experitest.ExperiBank");
			caps.setCapability("appActivity", "com.experitest.ExperiBank.LoginActivity");
//			caps.setCapability("chromedriverExecutable","/usr/local/bin/chromedriver");
//	        caps.setCapability("automationName", "UiAutomator2");
//	        caps.setCapability(MobileCapabilityType.APP, "/path/to/app");

			URL url = new URL("http://127.0.0.1:4723/wd/hub/");
			driver = new AppiumDriver<MobileElement>(url, caps);

		} catch (Exception exp) {
			System.out.println(exp.getMessage());
			System.out.println(exp.getCause());
			exp.printStackTrace();
		}
	}

	@Test
	public void login() {
		System.out.println("Application started");
		driver.findElement(By.id("com.android.permissioncontroller:id/continue_button")).click();
		try {
			Thread.sleep(1000);

			driver.findElement(By.id("android:id/button1")).click();
			driver.findElement(By.id("com.experitest.ExperiBank:id/usernameTextField")).sendKeys("company");
			driver.findElement(By.id("com.experitest.ExperiBank:id/passwordTextField")).sendKeys("company");
			driver.findElement(By.id("com.experitest.ExperiBank:id/loginButton")).click();
			Thread.sleep(1000);
			driver.findElement(By.id("android:id/autofill_save_no")).click();
			String pageSource = driver.getPageSource();
			String expectedText = "Your balance is: 100.00$";
			Assert.assertTrue(pageSource.contains(expectedText));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@AfterSuite
	public void teardown() {
		driver.close();
		driver.quit();
	}

}
