import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class openMobileApp {
    public static void openApp() throws MalformedURLException {
        DesiredCapabilities cap = new DesiredCapabilities();

        cap.setCapability("appium:deviceName", "Galaxy S22");
        cap.setCapability("appium:udid", "RZCW129B48P");
        cap.setCapability("platformName", "Android");
        cap.setCapability("appium:platformVersion", "11");
        cap.setCapability("appium:automationName", "uiAutomator2");
        cap.setCapability("appium:appPackage", "com.reevomoney.uat");
        cap.setCapability("appium:appActivity", "com.reevo.MainActivity");

        URL url = new URL("http://127.0.0.1:4723/");
        AndroidDriver driver = new AndroidDriver(url, cap);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiSelector().text(\"example@mail.com\")")).sendKeys("testingapp@yopmail.com");
        driver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiSelector().text(\"your password\")")).sendKeys("Test@123");
        driver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiSelector().description(\"checkbox\")")).click();
        driver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiSelector().text(\"Log in\").instance(1)")).click();
        driver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiSelector().className(\"android.view.ViewGroup\").instance(14)")).isDisplayed();
        try {
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        AndroidKey[] keys={
                AndroidKey.DIGIT_1,
                AndroidKey.DIGIT_2,
                AndroidKey.DIGIT_3,
                AndroidKey.DIGIT_4,
                AndroidKey.DIGIT_5,
                AndroidKey.DIGIT_6
        };
        for(AndroidKey i : keys)
        {
            driver.pressKey(new KeyEvent(i));
            try {
                Thread.sleep(2);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        driver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiSelector().text(\"Create passcode\")")).isDisplayed();
        for(int i=0;i<4;i++) {
            driver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiSelector().description(\"1\")")).click();
        }

        driver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiSelector().text(\"Confirm passcode\")")).isDisplayed();
        for(int i=0;i<4;i++) {
            driver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiSelector().description(\"1\")")).click();
        }
        driver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiSelector().text(\"Allow notifications\")")).isDisplayed();
        driver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiSelector().text(\"Allow notifications\")")).click();
        driver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiSelector().resourceId(\"com.android.permissioncontroller:id/permission_allow_button\")")).isDisplayed();
        driver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiSelector().resourceId(\"com.android.permissioncontroller:id/permission_allow_button\")")).click();

        System.out.println("Application Started");

    }
}
