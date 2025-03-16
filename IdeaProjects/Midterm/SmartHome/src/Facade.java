import SmartDevices.SmartDevice;

import java.util.ArrayList;
import java.util.List;

class SmartHomeController {
    private List<SmartDevice> devices = new ArrayList<>();

    public void addDevice(SmartDevice device) {
        devices.add(device);
    }

    public void turnAllLightsOn() {
        for (SmartDevice device : devices) {
            device.turnOn();
        }
    }

    public void turnAllLightsOff() {
        for (SmartDevice device : devices) {
            device.turnOff();
        }
    }

    public void getSystemStatus() {
        for (SmartDevice device : devices) {
            System.out.println(device.getStatus());
        }
    }
}
