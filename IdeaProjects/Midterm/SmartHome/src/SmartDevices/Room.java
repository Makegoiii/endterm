package SmartDevices;

import java.util.ArrayList;
import java.util.List;

public class Room implements SmartDevice {
    private String name;
    private List<SmartDevice> devices = new ArrayList<>();

    public Room(String name) {
        this.name = name;
    }

    public void addDevice(SmartDevice device) {
        devices.add(device);
    }

    public void turnOn() {
        System.out.println("Turning on all devices in " + name);
        for (SmartDevice device : devices) {
            device.turnOn();
        }
    }

    public void turnOff() {
        System.out.println("Turning off all devices in " + name);
        for (SmartDevice device : devices) {
            device.turnOff();
        }
    }

    public String getStatus() {
        StringBuilder status = new StringBuilder(name + " status:\n");
        for (SmartDevice device : devices) {
            status.append(device.getStatus()).append("\n");
        }
        return status.toString();
    }
}
