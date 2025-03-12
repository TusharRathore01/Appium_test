package pageObject.android;

import org.openqa.selenium.By;

import io.appium.java_client.AppiumBy;
import pageObject.utility;

public class biometricPage extends utility {
    private final By headerField = AppiumBy.androidUIAutomator("new UiSelector().text(\"Enable biometric login?\")");
    private final By textField = AppiumBy.androidUIAutomator("new UiSelector().text(\"You can turn this feature on or off at any time under settings.\")");
    private final By notNowButtonField = AppiumBy.androidUIAutomator("new UiSelector().text(\"Not now\")");
    private final By enableButtonField = AppiumBy.androidUIAutomator("new UiSelector().text(\"Enable\")");
    
    public boolean isHeaderDisplayed(){
        return isDisplayed(headerField);
    }

    public String isTextDisplayed(){
        return getText(textField);
    } 
    
    public boolean isNotNowButtonDisplayed()
    {
        return isDisplayed(notNowButtonField);
    }
    
    public boolean isEnableButtonDisplayed()
    {
        return isDisplayed(enableButtonField);
    }

    public void clickNotNowButton()
    {
        click(notNowButtonField);
    }
    
}
