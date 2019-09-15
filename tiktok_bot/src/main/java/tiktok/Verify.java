package tiktok;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Verify{
	
	private static int get_followercount_by_element(AndroidDriver<MobileElement> driver) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		int temp = 9999;
		try{
			wait.until(ExpectedConditions.visibilityOf(driver.findElementById("com.zhiliaoapp.musically:id/dhd")));
			temp = Integer.parseInt(driver.findElementById("com.zhiliaoapp.musically:id/dhd").getText()); 
		}catch (Exception e) {
			
		}
		return temp;
	}
	
	private static int get_followingcount_by_element(AndroidDriver<MobileElement> driver) {
		int temp = 9999;
		try {
			temp = Integer.parseInt(driver.findElementById("com.zhiliaoapp.musically:id/dhg").getText());
		}catch (Exception e) {
			
		}
		return temp;
	}
	
	public static boolean verify_profile(AndroidDriver<MobileElement> driver) {
		int followercount = Verify.get_followercount_by_element(driver);
		int followingcount = Verify.get_followingcount_by_element(driver);
		double calculated_ratio = ((double) followercount)/followingcount;
		
		boolean result = calculated_ratio < config.max_ratio 
				&& calculated_ratio > config.min_ratio 
				&& followercount < config.max_follower 
				&& followercount > config.min_follower
				&& followingcount < config.max_following
				&& followingcount > config.min_following;
		String check = "wrong";
		if(result) {check = "right";}
		String name = driver.findElementById("com.zhiliaoapp.musically:id/j8c").getText();
		System.out.println("["+name+"] "+check);
		System.out.println("follower:"+followercount);
		System.out.println("following: "+followingcount);
		System.out.println("calculated ratio: "+calculated_ratio);
		System.out.println("");
		return result;
	}
}