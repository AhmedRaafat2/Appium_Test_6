import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;

public class AppiumServer {

	public static AndroidDriver driver;
	public static DesiredCapabilities capabilities = new DesiredCapabilities();
	public static Dimension screenSize;
	public static int screenHeight, screenWidth;
	
	
	
	/*
	 * This method is for turning off Connectivity
	 */
	public static void turnOffConnectivity() {
		if (driver.getConnection().isWiFiEnabled()) {
			driver.toggleWifi();
		}
		if (driver.getConnection().isDataEnabled()) {
			driver.toggleData();
		}
	}

	/*
	 * *****************************************************************************
	 */
	/*
	 * This method is for turning on Connectivity
	 */
	public static void turnOnConnectivity() {
		if (!driver.getConnection().isWiFiEnabled()) {
			driver.toggleWifi();
		}
		if (!driver.getConnection().isDataEnabled()) {
			driver.toggleData();
		}
	}

	/*
	 * *****************************************************************************
	 */
	/*
	 * This Function is for initializing the Mobile Driver with the required
	 * capabilities
	 */
	public static void init() throws MalformedURLException {

		capabilities.setCapability("automationName", "Appium");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("platformVersion", "9");
		capabilities.setCapability("deviceName", "Mi A1");
		capabilities.setCapability("udid", "2543e0560504");
		capabilities.setCapability("appPackage", "com.android.settings");
		capabilities.setCapability("appActivity", "com.android.settings.Settings$NetworkDashboardActivity");
		driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		screenSize = driver.manage().window().getSize();
		screenHeight = screenSize.getHeight();
		screenWidth = screenSize.getWidth();
		turnOffConnectivity();
		driver.closeApp();
		System.out.println("init");
	}

	/*
	 * *****************************************************************************
	 */
	/*
	 * This method is for running an app as required
	 */
	public static void runRequiredApp(String requiredAppPackage, String requiredAppActivity) {
		Activity myActivity = new Activity(requiredAppPackage, requiredAppActivity);
		driver.startActivity(myActivity);
		System.out.println("runRequiredApp");
	}

	/*
	 * *****************************************************************************
	 */
	/*
	 * This method is for closing an app as required
	 */
	public static void closeCurrentApp() {
		driver.quit();
		System.out.println("closeCurrentApp");
	}

	/*
	 * *****************************************************************************
	 */
	public static void main(String args[]) throws MalformedURLException {
		init();
		runRequiredApp("com.madarsoft.thekr", "com.madarsoft.thekr.activities.SplashScreen");
		driver.closeApp();
		runRequiredApp("com.android.settings", "com.android.settings.Settings$NetworkDashboardActivity");
		closeCurrentApp();
	}
}
