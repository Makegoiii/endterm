import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MUDController {
    private final Player player;
    private boolean running;
    private final Scanner scanner;

    public MUDController(Player player) {
        System.out.println("Привет! Добро пожаловать в MUD!");
        this.player = player;
        this.running = true;
        this.scanner = new Scanner(System.in);
    }

    public void runGameLoop() {

        while (running) {
            System.out.print("> ");
            String input = scanner.nextLine().trim();
            handleInput(input);
        }

        System.out.println("Game Over. Thanks for playing!");
    }

    private void handleInput(String input) {
        String[] parts = input.split(" ", 2);
        String command = parts[0].toLowerCase();
        String argument = parts.length > 1 ? parts[1] : "";

        switch (command) {
            case "look":
                lookAround();
                break;
            case "move":
                move(argument);
                break;
            case "pick":
                if (argument.startsWith("up ")) {
                    pickUp(argument.substring(3));
                } else {
                    System.out.println("Invalid command format. Use: pick up <itemName>");
                }
                break;
            case "inventory":
                checkInventory();
                break;
            case "help":
                showHelp();
                break;
            case "quit":
            case "exit":
                running = false;
                break;
            default:
                System.out.println("Unknown command. Type 'help' for a list of commands.");
                break;
        }
    }

    private void lookAround() {
        System.out.println(player.getCurrentRoom().describe());
        System.out.println("Предметы в комнате: " + player.getCurrentRoom().listItems());
    }

    private void move(String direction) {
        if (direction.isEmpty()) {
            System.out.println("Move where? Use: move <forward|back|left|right>");
            return;
        }

        Room nextRoom = player.getCurrentRoom().getConnectedRoom(direction);
        if (nextRoom != null) {
            player.setCurrentRoom(nextRoom);
            System.out.println("You moved " + direction + ".");
            lookAround();
        } else {
            System.out.println("You can't go that way!");
        }
    }

    private void pickUp(String itemName) {
        if (itemName.isEmpty()) {
            System.out.println("Pick up what? Use: pick up <itemName>");
            return;
        }

        Room currentRoom = player.getCurrentRoom();
        Item item = currentRoom.getItem(itemName);
        if (item != null) {
            currentRoom.removeItem(item);
            player.addItemToInventory(item);
            System.out.println("You picked up the " + itemName + ".");
        } else {
            System.out.println("No item named '" + itemName + "' here!");
        }
    }

    private void checkInventory() {
        List<Item> inventory = player.getInventory();
        if (inventory.isEmpty()) {
            System.out.println("Your inventory is empty.");
        } else {
            System.out.println("You are carrying:");
            for (Item item : inventory) {
                System.out.println("- " + item.getName());
            }
        }
    }

    private void showHelp() {
        System.out.println("Available commands:");
        System.out.println("look - Describes the current room.");
        System.out.println("move <forward|back|left|right> - Moves in a specified direction if possible.");
        System.out.println("pick up <itemName> - Picks up an item from the ground.");
        System.out.println("inventory - Lists items you are carrying.");
        System.out.println("help - Shows this help menu.");
        System.out.println("quit / exit - Ends the game.");
    }

    public static void main(String[] args) {
        Room room1 = new Room("Первая комната", "Вы в уютной стартовой комнате.");
        Room room2 = new Room("Коридор", "Узкий коридор, ведущий дальше.");
        Room room3 = new Room("Темная комната", "В комнате почти нет света, но что-то блестит на полу.");

        room1.connectRoom("forward", room2);
        room2.connectRoom("back", room1);
        room2.connectRoom("left", room3);
        room3.connectRoom("right", room2);

        room1.addItem(new Item("ключ"));
        room2.addItem(new Item("меч"));
        room2.addItem(new Item("лупа"));
        room3.addItem(new Item("шар"));

        Player player = new Player(room1);
        MUDController controller = new MUDController(player);
        controller.runGameLoop();
    }
}

class Player {
    private Room currentRoom;
    private List<Item> inventory;

    public Player(Room currentRoom) {
        this.currentRoom = currentRoom;
        this.inventory = new ArrayList<>();
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
}

class Room {
    private String name;
    private String description;
    private Map<String, Room> connectedRooms;
    private Map<String, Item> items;

    public Room(String name, String description) {
        this.name = name;
        this.description = description;
        this.connectedRooms = new HashMap<>();
        this.items = new HashMap<>();
    }

    public String describe() {
        return name + " - " + description;
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

    public void removeItem(Item item) {
        items.remove(item.getName());
    }

    public Item getItem(String name) {
        return items.get(name);
    }

    public String listItems() {
        return items.isEmpty() ? "Нет предметов." : String.join(", ", items.keySet());
    }
}

class Item {
    private String name;

    public Item(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
