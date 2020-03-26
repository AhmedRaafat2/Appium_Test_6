import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.touch.offset.PointOption;

public class AppiumTest {
	public static AndroidDriver driver;
	public static DesiredCapabilities capabilities = new DesiredCapabilities();
	public static Dimension screenSize;
	public static int screenHeight, screenWidth;
	public static AppiumServiceBuilder xxx;


	
	
	
	
	
	/*
	 * This Function is for inititalizing the Mobile Driver with the required
	 * capabilities
	 */
	public static void init() throws MalformedURLException {

		capabilities.setCapability("automationName", "Appium");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("platformVersion", "9");
		capabilities.setCapability("deviceName", "Mi A1");
		capabilities.setCapability("udid", "2543e0560504");
		capabilities.setCapability("appPackage", "com.madarsoft.thekr");
		capabilities.setCapability("appActivity", "com.madarsoft.thekr.activities.SplashScreen");
		driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		screenSize = driver.manage().window().getSize();
		screenHeight = screenSize.getHeight();
		screenWidth = screenSize.getWidth();

	}

	/*
	 * *****************************************************************************
	 */

	/*
	 * This method is for scrolling through an activity screen with specified
	 * cooridnates passed as point option parameters
	 */

	public static void scrollByPoints(PointOption options1, PointOption options2) {
		TouchAction action = new TouchAction(driver);
		action.longPress(options1);
		action.moveTo(options2);
		action.release();
		action.perform();
	}

	/*
	 * *****************************************************************************
	 */
	/*
	 * *****************************************************************************
	 */
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
	public static void main(String[] args) throws MalformedURLException {
		init();
		turnOffConnectivity();
		init();

		MobileElement hesnElMuslimIcon = (MobileElement) driver.findElementByXPath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.HorizontalScrollView/android.widget.LinearLayout/androidx.appcompat.app.ActionBar.Tab[3]/android.widget.ImageView");
		hesnElMuslimIcon.click();

		MobileElement hesnElMuslimIcon_AzkaarList = (MobileElement) driver
				.findElementById("com.madarsoft.thekr:id/categories_list");

		List<MobileElement> hesnElMuslimIcon_AzkaarList_List = hesnElMuslimIcon_AzkaarList
				.findElementsByClassName("android.widget.LinearLayout");

		MobileElement hesnElMuslimIcon_AzkaarList_List_FirstElement = hesnElMuslimIcon_AzkaarList_List.get(0);

		MobileElement hesnElMuslimIcon_AzkaarList_List_FirstElement_TextView = hesnElMuslimIcon_AzkaarList_List_FirstElement
				.findElementByClassName("android.widget.TextView");

		String hesnElMuslimIcon_AzkaarList_List_FirstElement_TextView_Text = hesnElMuslimIcon_AzkaarList_List_FirstElement_TextView
				.getText();

		MobileElement hesnElMuslimIcon_AzkaarList_List_LastElement = hesnElMuslimIcon_AzkaarList_List
				.get(hesnElMuslimIcon_AzkaarList_List.size() - 1);

		MobileElement hesnElMuslimIcon_AzkaarList_List_LastElement_TextView = hesnElMuslimIcon_AzkaarList_List_LastElement
				.findElementByClassName("android.widget.TextView");

		String hesnElMuslimIcon_AzkaarList_List_LastElement_TextView_Text = hesnElMuslimIcon_AzkaarList_List_LastElement_TextView
				.getText();

//		while (!(hesnElMuslimIcon_AzkaarList_List_LastElement_TextView.getText().contentEquals("Ø£Ø°ÙƒØ§Ø± Ù…ØªÙ�Ø±Ù‚Ø©"))) {
//			PointOption option1 = new PointOption().withCoordinates((int) (screenWidth / 2), (int) (screenHeight * .8));
//			PointOption option2 = new PointOption().withCoordinates((int) (screenWidth / 2), (int) (screenHeight * .2));
//			scrollByPoints(option1, option2);
//		}

//		hesnElMuslimIcon_AzkaarList_List_LastElement.click();

		/*
		 * The following section is for searching for a specific element in a list of
		 * activities, can be in any position first, last or in the middle
		 */
		String requiredString = "Ø£Ø°ÙƒØ§Ø± Ø§Ù„Ø³Ù�Ø±";
		MobileElement requiredElement;
		while (!(hesnElMuslimIcon_AzkaarList_List_LastElement_TextView.getText().contentEquals("Ø£Ø°ÙƒØ§Ø± Ù…ØªÙ�Ø±Ù‚Ø©"))) {
			boolean foundFlag = false;
			for (int i = 0; i < hesnElMuslimIcon_AzkaarList_List.size(); i++) {
				requiredElement = hesnElMuslimIcon_AzkaarList_List.get(i);
				if (requiredElement.findElementByClassName("android.widget.TextView").getText()
						.contentEquals(requiredString)) {
					requiredElement.click();
					foundFlag = true;
					break;
				}
			}
			if (foundFlag == true) {
				break;
			} else {
				PointOption option1 = new PointOption().withCoordinates((int) (screenWidth / 2),
						(int) (screenHeight * .80));
				PointOption option2 = new PointOption().withCoordinates((int) (screenWidth / 2),
						(int) (screenHeight * .25));
				scrollByPoints(option1, option2);
			}
		}
		System.out.println("Done Successfully");
	}

}
