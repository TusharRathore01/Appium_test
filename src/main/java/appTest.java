
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

import java.io.File;
import java.net.MalformedURLException;


public class appTest {
    public static void main(String[] args) throws MalformedURLException {
        AppiumServiceBuilder builder = new AppiumServiceBuilder();
        builder.withIPAddress("127.0.0.1")
                        .usingPort(4723)
                                .withAppiumJS(new File("C:\\Users\\TusharRathore\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"));

        AppiumDriverLocalService service = AppiumDriverLocalService.buildService(builder);
        service.start();
        openMobileApp.openApp();
        service.stop();
    }

}
