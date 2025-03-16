package Decorator;

import SmartDevices.SmartDevice;

public class LoggingDecorator extends DeviceDecorator {
    public LoggingDecorator(SmartDevice device) {
        super(device);
    }

    public void turnOn() {
        System.out.println("[LOG] Turning on device.");
        super.turnOn();
    }

    public void turnOff() {
        System.out.println("[LOG] Turning off device.");
        super.turnOff();
    }
}
