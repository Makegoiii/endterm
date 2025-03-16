package Factory;

import SmartDevices.Light;
import SmartDevices.SmartDevice;

public class BasicSmartHome implements SmartHomeFactory {
    public SmartDevice createLight(String name) {
        return new Light(name);
    }
}