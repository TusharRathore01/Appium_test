package pageObject.android;

import org.openqa.selenium.By;

import io.appium.java_client.AppiumBy;
import pageObject.utility;

public class notificationPage extends utility {
    private final By headerField = AppiumBy.androidUIAutomator("new UiSelector().text(\"Allow push notifications\")");
    private final By textField = AppiumBy.androidUIAutomator("new UiSelector().text(\"Allow push notifications\")");
    private final By notNowButtonField = AppiumBy.androidUIAutomator("new UiSelector().text(\"Not now\")");
    private final By allowButtonField = AppiumBy.androidUIAutomator("new UiSelector().text(\"Allow notifications\")");
    private final By allowPermissionField = AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.android.permissioncontroller:id/permission_allow_button\")");

    public boolean isHeaderDisplayed(){
        return isDisplayed(headerField);
    }
    
    public String isTextDisplayed(){
        return getText(textField);
    }

    public boolean isNotNowButtonDisplayed(){
        return isDisplayed(notNowButtonField);
    }

    public boolean isAllowButtonDisplayed(){
        return isDisplayed(allowButtonField);
    }

    public void clickAllowButton(){
        click(allowButtonField);
    }

    public void clickNotNowButton(){
        click(notNowButtonField);
    }

    public void allowPermission(){
        click(allowPermissionField);
    }
}
