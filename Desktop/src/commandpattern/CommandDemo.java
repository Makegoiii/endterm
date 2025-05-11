package commandpattern;

public class CommandDemo {
    public static void main(String[] args) {
        Light light = new Light();
        Thermostat thermostat = new Thermostat();

        Command lightOn = new TurnOnLightCommand(light);
        Command setTemp = new SetThermostatCommand(thermostat, 22);

        SmartHomeRemote remote = new SmartHomeRemote();
        remote.setCommand("turnOnLight", lightOn);
        remote.setCommand("setThermostat", setTemp);

        remote.pressButton("turnOnLight");
        remote.pressButton("setThermostat");

        System.out.println("Undo last command:");
        remote.undoButton();
    }
}
