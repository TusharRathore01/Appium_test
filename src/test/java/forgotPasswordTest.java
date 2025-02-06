// import java.io.IOException;
// import java.time.Duration;

// import org.testng.annotations.Test;

// import appium.capability;
// import appium.detectPlatform;
// import io.appium.java_client.AppiumBy;
// import io.appium.java_client.android.AndroidDriver;
// import io.appium.java_client.ios.IOSDriver;


// public class forgotPasswordTest extends launch {
//     @Test
//     public static void forgetPassword() throws IOException, InterruptedException{
//         AndroidDriver android_driver = capability.androidDriver;
//         IOSDriver   ios_driver = capability.iosDriver;
//         String platform = detectPlatform.getPlatform();
        
//         if(platform=="Android"){
//             android_driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//             android_driver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiSelector().text(\"Log in\").instance(0)")).isDisplayed();
//             android_driver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiSelector().text(\"Forgot password?\")")).click();
//             Thread.sleep(2);
//             android_driver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiSelector().text(\"Trouble logging in?\")")).isDisplayed();
//             android_driver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiSelector().text(\"Enter your email\")")).sendKeys("demotest001@yopmail.com");
//             android_driver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiSelector().text(\"Send\")")).click();
//         }
//     }
    
// }
