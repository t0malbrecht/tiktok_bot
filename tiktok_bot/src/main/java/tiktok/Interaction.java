package tiktok;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;


public class Interaction{
	
	private static void like_by_element(AndroidDriver<MobileElement> driver) throws InterruptedException {
		driver.findElementById("com.zhiliaoapp.musically:id/d5h").click();
		System.out.println("Video liked!");
	  }
	
	private static void like_by_tap(AndroidDriver<MobileElement> driver) {
		new TouchAction(driver).tap(PointOption.point(858,1110)).perform();
		config.like_counter++;
	}
	
	private static void follow_by_element(AndroidDriver<MobileElement> driver) {
		if(driver.findElementsById("com.zhiliaoapp.musically:id/i7f").isEmpty()) {
			System.out.println("already followed");
			return;
		}
		driver.findElementById("com.zhiliaoapp.musically:id/i7f").click();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		boolean private_profile = !driver.findElementsById("android:id/button1").isEmpty();
		if(private_profile) {
			driver.findElementById("android:id/button1").click();
		}
		config.following_counter++;
	}
	
	public static void interact_with_follower_of_users(AndroidDriver<MobileElement> driver, ArrayList<String> users){
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//new TouchAction(driver).tap(PointOption.point(858,1110)).perform();
		Interaction.like_by_tap(driver);
		
		System.out.println("----------------------------------------");
		System.out.println("Start interact_with_follower_of_users");
		System.out.println("----------------------------------------");
		System.out.println("");
		config.setInteractionPerUser(users.size());
		for(String user : users) {
			Interaction.interact_with_follower_of_user(driver, user);
		}
		System.out.println("----------------------------------------");
		System.out.println("End interact_with_follower_of_users");
		System.out.println("----------------------------------------");
		System.out.println("");
		System.out.println("Likes "+config.like_counter);
		System.out.println("Followings "+config.following_counter);
	}
	
	public static void interact_with_follower_of_user(AndroidDriver<MobileElement> driver, String user) {
		Orientation.search_for_user_and_click(driver, user);
		Orientation.open_follower_list_by_element(driver);
		int count = config.interaction_per_user;
		for(int i=count; i>0; i--) {
			Orientation.get_Random_Follower_of_List(driver);
			Interaction.interact_with_profile(driver);
			Orientation.goOneBack_by_element(driver);
		}
		Orientation.goWholeBack_by_element(driver);
		System.out.println("___");
		System.out.println("End interacting with Followers of "+user);
		System.out.println("");
		
	}
	
	private static void interact_with_profile(AndroidDriver<MobileElement> driver) {
		if(Verify.verify_profile(driver)) {
			Interaction.follow_by_element(driver);
			if(Orientation.getRandomProfileVideo(driver)) {
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				Interaction.like_by_tap(driver);
				Orientation.goOneBack_by_element(driver);
			}
		}
	}
	
}