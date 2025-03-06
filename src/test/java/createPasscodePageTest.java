
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.android.createPasscodePage;


public class createPasscodePageTest extends otpPageTest{

    @Test(testName="Verify the passcode page elements")
    public void verifyCreatePasscodePage() throws IOException, InterruptedException{
        verifyValidOtp();
        createPasscodePage passcodePage = new createPasscodePage();
        Assert.assertTrue(passcodePage.isCreatePasscodeDisplayed(),"Create passcode header not visible");
        Assert.assertEquals(passcodePage.isTextDisplayed(), "This is a 4-digit passcode you will use to log in to your app");
        
    }

    @Test(testName="Enter Digit to Create Passcode")
    public void createpasscode() throws IOException, InterruptedException
    {
        verifyValidOtp();
        createPasscodePage passcodePage = new createPasscodePage();
        Assert.assertTrue(passcodePage.isCreatePasscodeDisplayed(),"Create passcode header not visible");
        passcodePage.enterPasscode();
    }
}




