
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.android.confirmPasscodePage;


public class confirmPasscodePageTest extends createPasscodePageTest {

    @Test(testName="Verify Confirm Passcode page Elements")
    public void verifyConfirmPasscodePage() throws IOException, InterruptedException{
        createpasscode();
        confirmPasscodePage confirmPasscodePage = new confirmPasscodePage();
        Assert.assertTrue(confirmPasscodePage.isconfirmPasscodeDisplayed(),"Confirm passcode header not visible");
        Assert.assertEquals(confirmPasscodePage.isTextDisplayed(), "This is a 4-digit passcode you will use to log in to your app");
    }

    @Test(testName="Enter Valid Digit to Confirm Passcode")
    public void validConfirmPasscode() throws IOException, InterruptedException{
        createpasscode();
        confirmPasscodePage confirmPasscodePage = new confirmPasscodePage();
        Assert.assertTrue(confirmPasscodePage.isconfirmPasscodeDisplayed(),"Confirm passcode header not visible");
        confirmPasscodePage.enterValidPasscode();
        
    }

    @Test(testName="Enter Invalid Digit to Confirm Passcode")
    public void invalidConfirmPasscode() throws IOException, InterruptedException{
        createpasscode();
        confirmPasscodePage confirmPasscodePage = new confirmPasscodePage();
        Assert.assertTrue(confirmPasscodePage.isconfirmPasscodeDisplayed(),"Confirm passcode header not visible");
        confirmPasscodePage.enterInvalidPasscode();
        
    }
}
