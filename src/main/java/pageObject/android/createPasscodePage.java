package pageObject.android;

import org.openqa.selenium.By;

import io.appium.java_client.AppiumBy;
import pageObject.utility;

public class createPasscodePage extends utility {
    private final By passcodeHeaderField = AppiumBy.androidUIAutomator("new UiSelector().text(\"Create passcode\")");
    private final By textField = AppiumBy.androidUIAutomator("new UiSelector().text(\"This is a 4-digit passcode you will use to log in to your app\")");
    private final By digit_1Field = AppiumBy.androidUIAutomator("new UiSelector().text(\"1\")");
    private final By digit_2Field = AppiumBy.androidUIAutomator("new UiSelector().text(\"2\")");
    private final By digit_3Field = AppiumBy.androidUIAutomator("new UiSelector().text(\"3\")");
    private final By digit_4Field = AppiumBy.androidUIAutomator("new UiSelector().text(\"4\")");

    public boolean isCreatePasscodeDisplayed()
    {
        return isDisplayed(passcodeHeaderField);
    }

    public String isTextDisplayed()
    {
        return getText(textField); 
    }
    
    public void enterPasscode()
    {
        click(digit_1Field);
        click(digit_2Field);
        click(digit_3Field);
        click(digit_4Field);
    }
}
