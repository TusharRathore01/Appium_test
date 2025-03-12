import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObject.android.loginPage;

public class loginPageTest extends launch {

    @Test(testName="Verify Login Page Elements")
    public void verifyLoginPage(){
        loginPage loginPage = new loginPage();
        Assert.assertTrue(loginPage.islogInDisplayed(),"Heading not Displayed");
        Assert.assertTrue(loginPage.isEmailHeadingDisplayed(),"Email Heading not Displayed");
        Assert.assertEquals(loginPage.getBannerMessage(),"Enter the email you used during the application process on our website.");
        Assert.assertTrue(loginPage.isPasswordHeadingDisplayed(),"Password Heading not Displayed");
        Assert.assertTrue(loginPage.isVisibleElementDisplayed(),"Password visible element not Displayed");
        Assert.assertEquals(loginPage.isPrivacyPolicyFooterDisplayed(), "I accept the Mobile Terms & Conditions and the Privacy Policy.");

    }

    @Test(testName="Verify Valid Login Details")
    public void verifyValidLogin() throws IOException, InterruptedException{
        
        loginPage loginPage = new loginPage();

        loginPage.enterUsername("kamil1001@yopmail.com");
        loginPage.enterPassword("Test@1234");
        loginPage.clickCheckbox();
        loginPage.clickButton();  
        
    }
    @Test(testName="Verify Invalid Login Details")
    public void verifyInvalidLogin(){
        loginPage loginPage = new loginPage();

        loginPage.enterUsername("abc@abc.com");
        loginPage.enterPassword("1234");
        loginPage.clickCheckbox();
        loginPage.clickButton(); 
        Assert.assertEquals(loginPage.getErrorMessage(),"There's no account associated with this email.");

    }
    
}
