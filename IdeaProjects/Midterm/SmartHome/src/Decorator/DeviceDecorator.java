package Decorator;

import SmartDevices.SmartDevice;
abstract class DeviceDecorator implements SmartDevice {
    protected SmartDevice device;

    public DeviceDecorator(SmartDevice device) {
        this.device = device;
    }

    public void turnOn() { device.turnOn(); }
    public void turnOff() { device.turnOff(); }
    public String getStatus() { return device.getStatus(); }
}