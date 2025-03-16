package SmartDevices;

import java.util.ArrayList;
import java.util.List;

public class Floor implements SmartDevice {
    private String name;
    private List<Room> rooms = new ArrayList<>();

    public Floor(String name) {
        this.name = name;
    }

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public void turnOn() {
        System.out.println("Turning on all devices on " + name);
        for (Room room : rooms) {
            room.turnOn();
        }
    }

    public void turnOff() {
        System.out.println("Turning off all devices on " + name);
        for (Room room : rooms) {
            room.turnOff();
        }
    }

    public String getStatus() {
        StringBuilder status = new StringBuilder(name + " status:\n");
        for (Room room : rooms) {
            status.append(room.getStatus()).append("\n");
        }
        return status.toString();
    }
}
