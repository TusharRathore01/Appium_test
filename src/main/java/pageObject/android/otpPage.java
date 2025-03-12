package pageObject.android;

import org.openqa.selenium.By;

import apiResponse.kobilResponse;
import io.appium.java_client.AppiumBy;
import io.restassured.response.Response;
import pageObject.utility;

public class otpPage extends utility implements kobilResponse{
    private final By verifyAccountField = AppiumBy.androidUIAutomator("new UiSelector().text(\"Verify your Account\")");
    private final By codeSentMessageDislayed = AppiumBy.androidUIAutomator("new UiSelector().text(\"Enter the verification code sent to: \")");
    private final By phoneNumberField = AppiumBy.xpath("//android.widget.TextView[contains(@text, '+44')]");
    private final By receivedCodeField = AppiumBy.androidUIAutomator("new UiSelector().text(\"Haven't received the code?\")");
    private final By resendbuttonField = AppiumBy.androidUIAutomator("new UiSelector().text(\"Resend\")");
    private final By CodeInputField = AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"SMS code input\"]/android.view.ViewGroup[14]");
    private final By errorMsgField = AppiumBy.androidUIAutomator("new UiSelector().text(\"Invalid code. Check your SMS for the most recent code.\")");

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

    public boolean verifyMobileNumber(String maskedNumber, String fullNumber){
        String prefix = maskedNumber.split(".")[0].replace(" ", "");
        String suffix = maskedNumber.substring(maskedNumber.lastIndexOf(".")+1);
        return (fullNumber.startsWith(prefix) && fullNumber.endsWith(suffix));
        
    }

    public boolean isReceivedCodeMessageDisplayed()
    {
        return isDisplayed(receivedCodeField);
    }

    public boolean isResendButtonDisplayed()
    {
        return isDisplayed(resendbuttonField);
    }

    public boolean isCodeInputDisplayed(){
        return isDisplayed(CodeInputField);
    }

    public void enterValidOtp(){
        keyPress("DIGIT_1");
        keyPress("DIGIT_2");
        keyPress("DIGIT_3");
        keyPress("DIGIT_4");
        keyPress("DIGIT_5");
        keyPress("DIGIT_6");
    }
    public void enterInvalidOtp(){
        keyPress("DIGIT_1");
        keyPress("DIGIT_1");
        keyPress("DIGIT_1");
        keyPress("DIGIT_1");
        keyPress("DIGIT_1");
        keyPress("DIGIT_1");
    }

    public String isErrorDisplayed()
    {
        return getText(errorMsgField);
    }
}
