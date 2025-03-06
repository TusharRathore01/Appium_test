
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.android.biometricPage;


public class biometricPageTest extends confirmPasscodePageTest{

    @Test(testName="Verify the Biometric Page elements")
    public void verifyBiometricPage() throws IOException, InterruptedException{
        validConfirmPasscode();
        biometricPage biometricPage = new biometricPage();
        Assert.assertTrue(biometricPage.isHeaderDisplayed(),"Enable biometric login? is not  visible");
        Assert.assertEquals(biometricPage.isTextDisplayed(), "You can turn this feature on or off at any time under settings.");
        Assert.assertTrue(biometricPage.isNotNowButtonDisplayed(),"Not Now Button is not visible");
        Assert.assertTrue(biometricPage.isEnableButtonDisplayed(),"Enable Button is not Displayed");
  
    }

    @Test(testName="Skip the Biometric Login")
    public void skipBiometricLogin() throws IOException, InterruptedException
    {
        validConfirmPasscode();
        biometricPage biometricPage = new biometricPage();
        Assert.assertTrue(biometricPage.isHeaderDisplayed(),"Enable biometric login? is not  visible");
        biometricPage.clickNotNowButton();
    }
}