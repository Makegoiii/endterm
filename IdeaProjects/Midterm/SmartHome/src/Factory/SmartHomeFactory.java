package Factory;
import SmartDevices.*;
public interface SmartHomeFactory {
    SmartDevice createLight(String name);
}
