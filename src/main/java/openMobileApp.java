import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import io.appium.java_client.android.nativekey.PressesKey;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class openMobileApp {

    public static AndroidDriver android_driver;
    public static IOSDriver ios_driver;
    public static void openApp() throws IOException {
        DesiredCapabilities cap = new DesiredCapabilities();

        String platform = detectPlatform();

        if(platform.equalsIgnoreCase("android")) {
            cap.setCapability("appium:deviceName", "Galaxy S22");
            cap.setCapability("appium:udid", "RZCW129B48P");
            cap.setCapability("platformName", "Android");
            cap.setCapability("appium:platformVersion", "11");
            cap.setCapability("appium:automationName", "uiAutomator2");
            cap.setCapability("appium:appPackage", "com.reevomoney.uat");
            cap.setCapability("appium:appActivity", "com.reevo.MainActivity");

            URL url = new URL("http://127.0.0.1:4723/");
            android_driver = new AndroidDriver(url, cap);
        }

        else {
            cap.setCapability("appium:deviceName", "iPhone 13");
            cap.setCapability("appium:udid", "00008110-0009345222F2201E");
            cap.setCapability("platformName", "ios");
            cap.setCapability("appium:platformVersion", "18.0.1");
            cap.setCapability("appium:automationName", "XCUITest");
            cap.setCapability("appium:bundleId", "com.reevomoney.uat");

            URL url = new URL("http://127.0.0.1:4723/");
            ios_driver = new IOSDriver(url, cap);
        }

        if(platform.equalsIgnoreCase("android")) {
            android_driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
            android_driver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiSelector().text(\"example@mail.com\")")).sendKeys("testingapp@yopmail.com");
            android_driver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiSelector().text(\"your password\")")).sendKeys("Test@123");
            android_driver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiSelector().description(\"checkbox\")")).click();
            android_driver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiSelector().text(\"Log in\").instance(1)")).click();
            android_driver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiSelector().className(\"android.view.ViewGroup\").instance(14)")).isDisplayed();
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            AndroidKey[] keys = {
                    AndroidKey.DIGIT_1,
                    AndroidKey.DIGIT_2,
                    AndroidKey.DIGIT_3,
                    AndroidKey.DIGIT_4,
                    AndroidKey.DIGIT_5,
                    AndroidKey.DIGIT_6
            };
            for (AndroidKey i : keys) {
                android_driver.pressKey(new KeyEvent(i));
                try {
                    Thread.sleep(2);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            android_driver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiSelector().text(\"Create passcode\")")).isDisplayed();
            for (int i = 0; i < 4; i++) {
                android_driver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiSelector().description(\"1\")")).click();
            }

            android_driver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiSelector().text(\"Confirm passcode\")")).isDisplayed();
            for (int i = 0; i < 4; i++) {
                android_driver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiSelector().description(\"1\")")).click();
            }
            android_driver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiSelector().text(\"Allow notifications\")")).isDisplayed();
            android_driver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiSelector().text(\"Allow notifications\")")).click();
            android_driver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiSelector().resourceId(\"com.android.permissioncontroller:id/permission_allow_button\")")).isDisplayed();
            android_driver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiSelector().resourceId(\"com.android.permissioncontroller:id/permission_allow_button\")")).click();
        }

        else {
            ios_driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
            ios_driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeTextField[`name == \"Email input field\"`]")).isDisplayed();
            ios_driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeTextField[`name == \"Email input field\"`]")).sendKeys("testingapp@yopmail.com");
            ios_driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeOther[`name == \"Password input field Show password\"`][2]")).sendKeys("Test@123");
            ios_driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeStaticText[`name == \"Log in\"`]")).click();
            ios_driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeOther[`name == \"checkbox\"`]")).click();
            ios_driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeButton[`name == \"Log in\"`]")).click();

            for(int i=1;i<=6;i++)
            {
                ios_driver.findElement(AppiumBy.accessibilityId(""+i)).click();
            }
            for(int i=1;i<=4;i++)
            {
                ios_driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeKey[`name == \"1\"`]")).click();
            }
            for(int i=1;i<=4;i++)
            {
                ios_driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeKey[`name == \"1\"`]")).click();
            }

            ios_driver.findElement(AppiumBy.accessibilityId("Not now")).click();
            ios_driver.findElement(AppiumBy.accessibilityId("Allow notifications")).click();
        }

        System.out.println("Application Started");

    }

    public static String detectPlatform() throws IOException {
        Process androidCheck = Runtime.getRuntime().exec("adb devices");
        BufferedReader androidReader = new BufferedReader(new InputStreamReader(androidCheck.getInputStream()));
        String line;
        while((line = androidReader.readLine()) != null){
            if(line.contains("device") && !line.contains("List of devices attached")){
                return "Android";
            }
        }

        Process iosCheck = Runtime.getRuntime().exec("ideviceinfo");
        BufferedReader iosReader = new BufferedReader(new InputStreamReader(iosCheck.getInputStream()));
        while((line = iosReader.readLine()) != null){
            if(line.contains("DeviceName")){
                return "ios";
            }
        }
        return "None";
    }

}
