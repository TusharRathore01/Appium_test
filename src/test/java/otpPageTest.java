import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.android.otpPage;

public class otpPageTest extends loginPageTest{ 
    @Test(testName="Verify the OTP Page Elements")
    public void verifyOtpPage() throws IOException, InterruptedException{
        verifyValidLogin();
        otpPage otpPage = new otpPage();
        Assert.assertTrue(otpPage.isVerifyAccountDisplayed(),"verify your Account Header not Displayed");
        Assert.assertTrue(otpPage.isCodeSentMessageDisplayed(),"Verification Code sent Message not Displayed");
        String maskedNumber= otpPage.getPhoneNumber();
        String fullNumber= otpPage.getNumberFromKobil("loanapptest03@yopmail.com");
        Assert.assertTrue(otpPage.verifyMobileNumber(maskedNumber,fullNumber),"Mobile NUmber is different");
        Assert.assertTrue(otpPage.isCodeInputDisplayed(),"Mobile Number Input Box is not Displayed");
        Assert.assertTrue(otpPage.isReceivedCodeMessageDisplayed(),"Haven't received the code? is not Displayed");
        Assert.assertTrue(otpPage.isResendButtonDisplayed(),"Resend button is not Visible");
    
    }

    @Test(testName="Verify the successfull OTP Verification")
    public void verifyValidOtp() throws IOException, InterruptedException
    {
        verifyValidLogin();
        otpPage otpPage = new otpPage();
        Assert.assertTrue(otpPage.isVerifyAccountDisplayed(),"verify your Account Header not Displayed");
        otpPage.enterValidOtp();
        
    }

    @Test(testName="Verify the Invalid OTP Verification")
    public void verifyInvalidOtp() throws InterruptedException, IOException
    {
        verifyValidLogin();
        otpPage otpPage = new otpPage();
        Assert.assertTrue(otpPage.isVerifyAccountDisplayed(),"verify your Account Header not Displayed");
        otpPage.enterInvalidOtp();
        Assert.assertEquals(otpPage.isErrorDisplayed(),"Invalid code. Check your SMS for the most recent code.");

    }
}

