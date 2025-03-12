package appium;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class appiumSetup {

    public static AppiumDriverLocalService service;

    public static void startAppiumServer() throws IOException {

        AppiumServiceBuilder builder = new AppiumServiceBuilder();
        String platform= System.getProperty("os.name");
        //String platform = detectPlatform.getPlatform();
        if(platform.contains("Windows")){
        builder.withIPAddress("127.0.0.1")
                .usingPort(4723)
                .withTimeout(Duration.ofSeconds(60));
        }
        else if(platform.contains("Mac")){
                builder.withIPAddress("127.0.0.1")
                        .usingPort(4723) 
                        .withTimeout(Duration.ofSeconds(60));   
        }
        else{
            throw new IOException("OS Failed to Detect");
        }

        service = AppiumDriverLocalService.buildService(builder);
        service.start();
        if(service.isRunning())
        {
            System.out.println("✅ Appium Server started successfully");
        }
        else{
            throw new IOException("❌ Failed to start Appium Server!");
        }
    }

}

