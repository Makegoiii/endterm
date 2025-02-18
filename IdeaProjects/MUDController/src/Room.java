import java.util.HashMap;
import java.util.Map;

public class Room{

    private final String description;
    private final Map<String, Room> connectedRooms;
    private final Map<String, Item> items;

    public Room(String description) {
        this.description = description;
        this.connectedRooms = new HashMap<>();
        this.items = new HashMap<>();
    }

    public String getDescription() {
        return description;
    }

    public void connectRoom(String direction, Room room) {
        connectedRooms.put(direction, room);

    }

    public Room getConnectedRoom(String direction) {
        return connectedRooms.get(direction);
    }

    public void addItem(Item item) {
        items.put(item.getName(), item);
    }

    public Item getItem(String itemName) {
        return items.get(itemName);
    }

    public void removeItem(Item item) {
        items.remove(item.getName());
    }

    public String listItems() {
        return items.isEmpty() ? "нет предметов" : String.join(", ", items.keySet());
    }

}
