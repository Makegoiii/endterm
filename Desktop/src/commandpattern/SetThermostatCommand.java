package commandpattern;

public class SetThermostatCommand implements Command {
    private Thermostat thermostat;
    private int temp;

    public SetThermostatCommand(Thermostat t, int temp) {
        this.thermostat = t;
        this.temp = temp;
    }

    public void execute() {
        thermostat.setTemperature(temp);
    }

    public void undo() {
        thermostat.revert();
    }
}
