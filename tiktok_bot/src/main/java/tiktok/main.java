package tiktok;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class main{
	
	public static URL url;
	public static DesiredCapabilities capabilities;
	public static AndroidDriver<MobileElement> driver;
	
	public static void setupAppium() throws MalformedURLException {
	    
	    final String URL_STRING = "http://127.0.0.1:4723/wd/hub";
	    url = new URL(URL_STRING);
	
	    capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
		//capabilities.setCapability(CapabilityType.BROWSER_NAME, "Android");
		//capabilities.setCapability(CapabilityType.VERSION, "7.1.1");
		capabilities.setCapability(MobileCapabilityType.NO_RESET, true);
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiAutomator2");
	    capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "60");
	    	
		capabilities.setCapability("appPackage", "com.zhiliaoapp.musically");
		capabilities.setCapability("appActivity", "com.ss.android.ugc.aweme.splash.SplashActivity");
	    
	    
	    driver = new AndroidDriver<MobileElement>(url, capabilities);
	    driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
	    driver.resetApp();
	  }
	
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		setupAppium();
		Basics.launchTikTok(driver);
		Basics.login(driver);
		ArrayList<String> users = new ArrayList<String>();
		users.add("tk.pham");
		users.add("taekwondojin");
		Interaction.interact_with_follower_of_users(driver, users);
	}
	
}