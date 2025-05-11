package commandpattern;

public class Thermostat {
    private int currentTemp = 20;

    public void setTemperature(int temp) {
        System.out.println("[Thermostat] Setting temperature to " + temp + "°C");
        currentTemp = temp;
    }

    public void revert() {
        System.out.println("[Thermostat] Reverting to previous temperature");
    }
}
