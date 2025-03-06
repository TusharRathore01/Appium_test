
import java.io.IOException;

import org.testng.annotations.BeforeSuite;

import appium.capability;



public class launch {
    @BeforeSuite
    protected void setup(){
        try {
            capability.setCapability();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // @AfterSuite
    // void teardown()
    // {
    //     appiumSetup.service.stop();
    //     capability.driver.quit();

    // }
    
}
