package tiktok;

import java.time.Duration;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static io.appium.java_client.touch.WaitOptions.waitOptions;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;
public class Orientation{
	
	private static String getRandomVideo(int[][] columnOfVideo,int[][] rowOfVideo) {
		Random random = new Random();
		int[] column = columnOfVideo[random.nextInt(columnOfVideo.length)];
		int[] row = rowOfVideo[random.nextInt(rowOfVideo.length)];
		
		String result = "";
		result = "["+column[0]+","+row[0]+"]["+column[1]+","+row[1]+"]";
		return result;
	}
	
	public static void getRandomSearchPageVideo(AndroidDriver<MobileElement> driver) {
		String randomSearchPageVideo = getRandomVideo(config.columnOfHashtagVideo, config.rowOfHashtagVideo);
	    driver.findElementByXPath("//android.widget.ImageView[@bounds='"+randomSearchPageVideo+"']").click();
	}
	
	public static boolean getRandomProfileVideo(AndroidDriver<MobileElement> driver) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<MobileElement> temp = driver.findElementsById("com.zhiliaoapp.musically:id/d2a");
		if(temp.size() == 0){return false;}
		Random random = new Random();
		int rand = random.nextInt(temp.size());
	    temp.get(rand).click();
	    return true;
	}
	
	public static void goWholeBack_by_element(AndroidDriver<MobileElement> driver) {
		Boolean canGoBack = !driver.findElementsById("com.zhiliaoapp.musically:id/clb").isEmpty();
	    while(canGoBack) {
	    	if(!driver.findElementsById("com.zhiliaoapp.musically:id/clb").isEmpty()){	
	    		driver.findElementById("com.zhiliaoapp.musically:id/clb").click();
	    	}
	    	canGoBack = !driver.findElementsById("com.zhiliaoapp.musically:id/clb").isEmpty();
	    }
	    if(!driver.findElementsById("com.zhiliaoapp.musically:id/cle").isEmpty()) {
	    	driver.findElementById("com.zhiliaoapp.musically:id/cle").click();
	    }

		
	}
	
	public static void goOneBack_by_element(AndroidDriver<MobileElement> driver) {
		driver.navigate().back();
	}
	
	public static void open_follower_list_by_element(AndroidDriver<MobileElement> driver) {
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOf(driver.findElementById("com.zhiliaoapp.musically:id/dhd")));
		driver.findElementById("com.zhiliaoapp.musically:id/dhd").click();
	}
	
	public static void get_Random_Follower_of_List(AndroidDriver<MobileElement> driver) {
		Random random = new Random();
		WebDriverWait wait = new WebDriverWait(driver, 5);
		try{
			wait.until(ExpectedConditions.visibilityOf(driver.findElementByXPath("//android.widget.RelativeLayout[@index='2'][@clickable='true']")));
		}catch (Exception e) {
			Orientation.goOneBack_by_element(driver);
		}
		new TouchAction(driver).press(PointOption.point(115, 650)).waitAction(waitOptions(Duration.ofSeconds(1))).moveTo(PointOption.point(115,350)).release().perform();
		int rand = random.nextInt(13);
	    driver.findElementByXPath("//android.widget.RelativeLayout[@index='"+rand+"'][@clickable='true']").click();
	}
	
	public static void search_for_user_and_click(AndroidDriver<MobileElement> driver, String user) {
		new TouchAction(driver).tap(PointOption.point(858,1110)).perform();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Orientation.goWholeBack_by_element(driver);
		driver.findElementByXPath("//*[@bounds='[243,1530][297,1584]']").click();
		driver.findElementById("com.zhiliaoapp.musically:id/db6").click();
		driver.findElementById("com.zhiliaoapp.musically:id/db6").sendKeys(user);
		driver.findElementById("com.zhiliaoapp.musically:id/j39").click();
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOf(driver.findElementById("com.zhiliaoapp.musically:id/e6m")));
		driver.findElementsById("com.zhiliaoapp.musically:id/e6m").get(0).click();
	}
}