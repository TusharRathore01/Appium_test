package appium;

import java.io.IOException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.remote.DesiredCapabilities;

import com.testinium.deviceinformation.model.Device;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;


public class capability {

    public static AppiumDriver driver;

    public static void setCapability() throws IOException{
        
        //appiumSetup.startAppiumServer();
        DesiredCapabilities cap = new DesiredCapabilities();
        URL url = new URL("http://127.0.0.1:4723/");
        String platform= System.getProperty("os.name");
        try{
            if(platform.contains("Window")){
                Device device = getDeviceInfo.androidDeviceInfo();
                cap.setCapability("appium:deviceName", device.getDeviceProductName());
                cap.setCapability("appium:udid", device.getUniqueDeviceID());
                cap.setCapability("platformName", "Android");
                cap.setCapability("appium:automationName", "uiAutomator2");
                cap.setCapability("appium:appPackage", "com.reevomoney.uat");
                cap.setCapability("appium:appActivity", "com.reevo.MainActivity");
                
                driver = new AndroidDriver(url,cap);
            }
            else if(platform.contains("Mac")){
                Device device = getDeviceInfo.iosDeviceInfo();
                cap.setCapability("appium:deviceName", device.getDeviceProductName());
                cap.setCapability("appium:udid", device.getUniqueDeviceID());
                cap.setCapability("platformName", "ios");
                cap.setCapability("appium:platformVersion", device.getBuildVersion());
                cap.setCapability("appium:automationName", "XCUITest");
                cap.setCapability("appium:bundleId", "com.reevomoney.uat");
                cap.setCapability("wdaLaunchTimeout", 1000);

                driver = new IOSDriver(url,cap);
            }
        }catch(Exception e) {
            e.printStackTrace();
        }
        
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        //driver.getCapabilities().getCapability()
          
    }
    
}
