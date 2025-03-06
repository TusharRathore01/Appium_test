
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.android.notificationPage;

public class notificationPageTest extends biometricPageTest {

    @Test(testName="Verify Push Notification Page Elements")
    public void verifyNotififcationPageElement() throws IOException, InterruptedException{
        skipBiometricLogin();
        notificationPage notificationPage = new notificationPage();
        Assert.assertTrue(notificationPage.isHeaderDisplayed(),"Allow push notifications | Header is not visible");
        Assert.assertEquals(notificationPage.isTextDisplayed(), "Receive alerts | text is not visible");
        Assert.assertTrue(notificationPage.isNotNowButtonDisplayed(),"Not Now | Button is not visible");
        Assert.assertTrue(notificationPage.isAllowButtonDisplayed(),"Allow Notification | Button is not visible");
        
    }
    
    @Test(testName="Verify Allow Notification Case")
    public void verifyAllowNotififcation() throws IOException, InterruptedException{
        skipBiometricLogin();
        notificationPage notificationPage = new notificationPage();
        Assert.assertTrue(notificationPage.isHeaderDisplayed(),"Allow push notifications | Header is not visible");
        notificationPage.clickAllowButton();
        notificationPage.allowPermission();

    }

    @Test(testName="Verify Not Now Notification Case")
    public void verifyNotNowNotififcation() throws IOException, InterruptedException{
        skipBiometricLogin();
        notificationPage notificationPage = new notificationPage();
        Assert.assertTrue(notificationPage.isHeaderDisplayed(),"Allow push notifications | Header is not visible");
        notificationPage.clickNotNowButton();

    }
}
