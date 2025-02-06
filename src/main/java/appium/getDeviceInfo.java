package appium;

import java.io.IOException;

import com.testinium.deviceinformation.DeviceInfo;
import com.testinium.deviceinformation.DeviceInfoImpl;
import com.testinium.deviceinformation.device.DeviceType;
import com.testinium.deviceinformation.exception.DeviceNotFoundException;
import com.testinium.deviceinformation.model.Device;

public class getDeviceInfo {
    public static Device androidDeviceInfo() throws IOException, DeviceNotFoundException{
        DeviceInfo deviceInfo = new DeviceInfoImpl(DeviceType.ANDROID);
        return deviceInfo.getFirstDevice();
    }

    public static Device iosDeviceInfo() throws IOException, DeviceNotFoundException{
        DeviceInfo androidInfo = new DeviceInfoImpl(DeviceType.ANDROID);
        DeviceInfo iosInfo = new DeviceInfoImpl(DeviceType.IOS);
        if(androidInfo.anyDeviceConnected()){
            return androidInfo.getFirstDevice();
        }
        else{
            return iosInfo.getFirstDevice();
        }
    }
    
}

