package tiktok;

import static io.appium.java_client.touch.offset.PointOption.point;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileElement;
import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;

public class Basics{
	
	public static void launchTikTok(AndroidDriver<MobileElement> driver) throws InterruptedException {
	    driver.resetApp();
	  }
	
	public static void login(AndroidDriver<MobileElement> driver) throws InterruptedException {
		driver.findElementByXPath("//android.widget.ImageView[@bounds='[783,1530][837,1584]']").click();
		
		//Click Login Button
		driver.findElementByXPath("//android.widget.TextView[@text='Anmelden']").click();
	  
		//perform Login
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOf(driver.findElementById("com.zhiliaoapp.musically:id/dal")));
		driver.findElementById("com.zhiliaoapp.musically:id/dal").sendKeys(config.username);
		Thread.sleep((long) (Math.random() * 2000));
		driver.findElementById("com.zhiliaoapp.musically:id/daz").sendKeys(config.password);
		Thread.sleep((long) (Math.random() * 2000));
		driver.findElementById("com.zhiliaoapp.musically:id/cpq").click();
		System.out.println("----------------------------------------");
		System.out.println("Login performed");
		System.out.println("----------------------------------------");
		System.out.println("");
	  }
	
}