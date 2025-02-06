package pageObject.android;

import org.openqa.selenium.By;

import apiResponse.kobilResponse;
import io.appium.java_client.AppiumBy;
import io.restassured.response.Response;
import pageObject.utility;

public class otpPage extends utility implements kobilResponse{
    public final By verifyAccountField = AppiumBy.androidUIAutomator("new UiSelector().text(\"Verify your Account\")");
    public final By codeSentMessageDislayed = AppiumBy.androidUIAutomator("new UiSelector().text(\"Enter the verification code sent to: \")");
    public final By phoneNumberField = AppiumBy.xpath("//android.widget.TextView[contains(@text, '+44')]");

    public boolean isVerifyAccountDisplayed(){
        return isDisplayed(verifyAccountField);
    }

    public boolean isCodeSentMessageDisplayed(){
        return isDisplayed(codeSentMessageDislayed);
    }

    public String getPhoneNumber(){
        return getText(phoneNumberField);
    }

    public String getNumberFromKobil(String username)
    {
        Response response = getUserData(username);
        return response.jsonPath().getString("data.userList[0].attributes.phone_number[0]");

    }
}
