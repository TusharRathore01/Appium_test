package pageObject.android;

import org.openqa.selenium.By;

import io.appium.java_client.AppiumBy;
import pageObject.utility;

public class loginPage extends utility {

    private final By logInTextField= AppiumBy.androidUIAutomator("new UiSelector().text(\"Log in\").instance(0)");
    private final By emailTextField= AppiumBy.androidUIAutomator("new UiSelector().text(\"Email\")");
    private final By bannerTextField= AppiumBy.androidUIAutomator("new UiSelector().text(\"Enter the email you used during the application process on our website.\")");
    private final By passwordTextField= AppiumBy.androidUIAutomator("new UiSelector().text(\"Password\")");
    private final By eyeElementField= AppiumBy.androidUIAutomator("new UiSelector().text(\"\")");
    private final By footerElementField = AppiumBy.androidUIAutomator("new UiSelector().text(\"I accept the Mobile Terms & Conditions and the Privacy Policy.\")");

    private final By usernameField= AppiumBy.androidUIAutomator("new UiSelector().text(\"example@mail.com\")");
    private final By passwordField= AppiumBy.androidUIAutomator("new UiSelector().text(\"your password\")");
    private final By checkboxField= AppiumBy.androidUIAutomator("new UiSelector().description(\"checkbox\")");
    private final By buttonField=   AppiumBy.androidUIAutomator("new UiSelector().text(\"Log in\").instance(1)");
    private final By errorMessageField = AppiumBy.androidUIAutomator("new UiSelector().text(\"There's no account associated with this email.\")");
    private final By termsAndConditions = AppiumBy.xpath("//android.widget.TextView[contains(@text, 'Mobile Terms & Conditions')]");


    public void enterUsername(String username){
        sendKeys(usernameField, username);
    }

    public void enterPassword(String password){
        sendKeys(passwordField, password);
    }

    public void clickCheckbox()
    {
        click(checkboxField);
    }

    public void clickButton()
    {
        click(buttonField);
    }

    public String getErrorMessage(){
        return getText(errorMessageField);
    }

    public boolean islogInDisplayed(){
        return isDisplayed(logInTextField);
    }

    public boolean isEmailHeadingDisplayed(){
        return isDisplayed(emailTextField);
    }

    public String getBannerMessage(){
        return getText(bannerTextField);
    }

    public boolean isPasswordHeadingDisplayed(){
        return isDisplayed(passwordTextField);
    }

    public boolean isVisibleElementDisplayed(){
        return isDisplayed(eyeElementField);
    }

    public String isPrivacyPolicyFooterDisplayed(){
        return getText(footerElementField);
    }

    public void clickTermsConditions(){
        click(termsAndConditions);
    }

    public void getAllText()
    {
        scrollable();
        
    }
}
