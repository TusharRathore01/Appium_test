package pageObject;

import org.openqa.selenium.By;

import appium.capability;

public class utility{

    protected void sendKeys(By by, String value) {
        capability.driver.findElement(by).sendKeys(value);
    }
    
    protected void click(By by){
        capability.driver.findElement(by).click();
    }

    protected String getText(By by){
        String text = capability.driver.findElement(by).getText();
        return text;
    }

    protected boolean isDisplayed(By by){
        return capability.driver.findElement(by).isDisplayed();
    }
}
