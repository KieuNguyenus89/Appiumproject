package driver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;

import java.net.MalformedURLException;
import java.net.URL;

import org.testng.SkipException;

import base.AppData;

public class AppFactory {
	
static AppiumDriver driver;
	
	public static void android_launchApp() throws MalformedURLException {
		UiAutomator2Options options = new UiAutomator2Options();		
		
			options.setDeviceName("Pixel 5 API 31")
				   .setPlatformVersion("12.0")
				   .setApp(System.getProperty("user.dir")+"\\src\\test\\java\\resources\\Android-MyDemoAppRN.1.3.0.build-244.apk" );
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"),options);		
		AppDriver.setDriver(driver);
	}
	
	
	public static void ios_launchApp() throws MalformedURLException {
		XCUITestOptions options = new XCUITestOptions();
		options.setDeviceName("iphone 15")
				 .setPlatformVersion("17.2")
				 .setBundleId("com.saucelabs.mydemoapp.rn");
		driver = new IOSDriver(new URL("http://127.0.0.1:4723/"), options);
		AppDriver.setDriver(driver);
	}
	
	public static void launchApp() throws MalformedURLException {
		System.out.println("entering into launchapp");
		if(AppData.platForm.equalsIgnoreCase("Android")) {
			android_launchApp();
			System.out.println("Android launched...");
		}else
			if(AppData.platForm.equalsIgnoreCase("ios")){
				ios_launchApp();
				System.out.println("iOS launched...");
			
			}else
				throw new SkipException("Eneter valid platform value,android/ios");	
		
	}
	

}
