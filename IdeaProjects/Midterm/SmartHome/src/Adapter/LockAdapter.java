package Adapter;

import SmartDevices.SmartDevice;

public class LockAdapter implements SmartDevice {
    private LockSystem lock;

    public LockAdapter(LockSystem lock) {
        this.lock = lock;
    }

    public void turnOn() { lock.activate(); }
    public void turnOff() { lock.deactivate(); }
    public String getStatus() { return "Lock system status: Secure"; }
}
