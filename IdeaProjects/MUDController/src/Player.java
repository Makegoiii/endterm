import java.util.ArrayList;
import java.util.List;

public class Player {

    private Room currentRoom;
    private final List<Item> inventory;

    public Player(Room startRoom) {
        this.currentRoom = startRoom;
        this.inventory = new ArrayList<>();
    }

    public Player(String name, List<Item> inventory) {
        this.inventory = inventory;
        this.currentRoom = null;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room room) {
        this.currentRoom = room;
    }

    public void addItemToInventory(Item item) {
        inventory.add(item);
    }

    public List<Item> getInventory() {
        return inventory;
    }

    public String listInventory() {
        if (inventory.isEmpty()) {
            return "ничего";
        }
        StringBuilder items = new StringBuilder();
        for (Item item : inventory) {
            items.append(item.getName()).append(", ");
        }
        return items.substring(0, items.length() - 2);
    }
}
