import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.android.otpPage;

public class otpPageTest extends loginPageTest{ 
    @Test
    public void verifyOtpPage() throws IOException, InterruptedException{
        verifyValidLogin();
        otpPage otpPage = new otpPage();
        //Assert.assertTrue(otpPage.isVerifyAccountDisplayed(),"verify your Account Header not Displayed");
        //Assert.assertTrue(otpPage.isCodeSentMessageDisplayed(),"Verification Code sent Message not Displayed");
        System.out.println(otpPage.getPhoneNumber());
        System.out.println(otpPage.getNumberFromKobil("loanapptest03@yopmail.com"));
    
    }
}


























//     Assert.assertTrue(android_driver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiSelector().className(\"android.view.ViewGroup\").instance(14)")).isDisplayed());

//             Thread.sleep(10000);
            
//             AndroidKey[] keys = {
//                     AndroidKey.DIGIT_1,
//                     AndroidKey.DIGIT_2,
//                     AndroidKey.DIGIT_3,
//                     AndroidKey.DIGIT_4,
//                     AndroidKey.DIGIT_5,
//                     AndroidKey.DIGIT_6
//             };
//             for (AndroidKey i : keys) {
//                 android_driver.pressKey(new KeyEvent(i));
//                 Thread.sleep(2);
//             }
// }
