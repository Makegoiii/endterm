package SmartDevices;

public class Light implements SmartDevice {
    private String name;

    public Light(String name) {
        this.name = name;
    }

    public void turnOn() {
        System.out.println(name + " is ON");
    }

    public void turnOff() {
        System.out.println(name + " is OFF");
    }

    public String getStatus() {
        return name + " is " + (Math.random() > 0.5 ? "ON" : "OFF");
    }
}
