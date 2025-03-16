import Adapter.LockAdapter;
import Adapter.LockSystem;
import Decorator.LoggingDecorator;
import Factory.BasicSmartHome;
import Factory.SmartHomeFactory;
import SmartDevices.Floor;
import SmartDevices.Room;
import SmartDevices.SmartDevice;

import java.util.Scanner;

public class SmartHome {
        public static void main(String[] args) {
            SmartHomeFactory factory = new BasicSmartHome();
            SmartHomeController controller = new SmartHomeController();
            Scanner scanner = new Scanner(System.in);

            SmartDevice light1 = factory.createLight("Living Room Light");
            SmartDevice light2 = factory.createLight("Bedroom Light");

            Room livingRoom = new Room("Living Room");
            livingRoom.addDevice(light1);
            livingRoom.addDevice(light2);

            Floor firstFloor = new Floor("First Floor");
            firstFloor.addRoom(livingRoom);

            controller.addDevice(firstFloor);

            while (true) {
                System.out.println("\nCommands: ON, OFF, STATUS, EXIT");
                System.out.print("Enter command: ");
                String command = scanner.nextLine().toUpperCase();

                switch (command) {
                    case "ON":
                        controller.turnAllLightsOn();
                        break;
                    case "OFF":
                        controller.turnAllLightsOff();
                        break;
                    case "STATUS":
                        controller.getSystemStatus();
                        break;
                    case "EXIT":
                        System.out.println("Exiting Smart Home System...");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Invalid command. Try again.");
                }
            }
        }
    }

