import java.util.Scanner;

public class MUDController {

    private final Player player;
    private boolean running;
    private final Scanner scanner;

    public  MUDController(Player player) {
        this.player=player;
        this.running=true;
        this.scanner =new Scanner(System.in );
    }

    public MUDController(Player player, Scanner scanner) {
        this.player = player;
        this.scanner =scanner;
    }

    public void runGameLoop() {
        while (running) {
            System.out.print("> ");
            String input = scanner.nextLine().trim();
            handleInput(input);
        }
    }

    public void handleInput(String input) {
        String[] parts = input.split(" ", 2);
        String command = parts[0].toLowerCase();
        String argument = (parts.length > 1) ? parts[1] : "";

        switch (command) {
            case "look" :
                lookAround();
                break;
            case "move":
                move(argument);
                break;
            case "pick" :
                if (argument.startsWith("up ")) {
                    pickUp(argument.substring(3));
                } else {
                    System.out.println("Неверная команда. Используйте 'pick up <item>'.");
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
                System.out.println( "Выход из игры...");
                break;
            default:
                System.out.println("Неизвестная команда. Используйте 'help' для списка команд.");
        }
    }

    private void lookAround() {
        Room currentRoom =player.getCurrentRoom();
        if (currentRoom != null) {
            System.out.println(currentRoom.getDescription() );
            System.out.println( "Предметы в комнате: " + currentRoom.listItems());
        } else {
            System.out.println("Вы находитесь в пустоте...");
        }
    }
    private void move(String direction) {
        if (direction.isEmpty()) {
            System.out.println("Укажите направление (forward, back, left, right).");
            return;
        }
        Room nextRoom = player.getCurrentRoom().getConnectedRoom(direction);

        if (nextRoom != null) {
            player.setCurrentRoom(nextRoom);
            System.out.println("Вы переместились " + direction + ".");
            lookAround();
        } else {
            System.out.println("Вы не можете пойти в этом направлении!");
        }
    }

    private void pickUp(String itemName) {
        Room currentRoom = player.getCurrentRoom();
        Item item = currentRoom.getItem(itemName);
        if (item != null) {
            player.addItemToInventory(item);
            currentRoom.removeItem(item);
            System.out.println("Вы взяли " + itemName + ".");
        } else {
            System.out.println("Предмет '" + itemName + "' не найден!");
        }
    }

    private void checkInventory() {
        if (player.getInventory().isEmpty()) {
            System.out.println("Ваш инвентарь пуст.");
        } else {
            System.out.println("Вы несёте: " + player.listInventory());
        }
    }

    private void showHelp() {
        System.out.println("Доступные команды:" );
        System.out.println("look - Осмотреть комнату");
        System.out.println("move <forward|back|left|right> - Перемещение");
        System.out.println("pick up <item> - Взять предмет" );
        System.out.println("inventory - Посмотреть инвентарь");
        System.out.println("help - Показать список команд");
        System.out.println("quit / exit - Выйти из игры");
    }

    public static void main(String[] args) {
        System.out.println("Привет ты зашел в игру!");
        Room room1 = new Room("Первая комната");
        Room room2 = new Room("Вторая комната");
        Room room3 = new Room("Третья комната");

        room1.connectRoom("forward", room2);
        room2.connectRoom("back", room1);
        room2.connectRoom("left", room3 );
        room3.connectRoom("right", room2);

        Item key = new Item("ключ");
        Item sword = new Item("меч");
        Item lupa = new Item("лупа");
        Item shar = new Item("шар");

        room1.addItem(key);
        room2.addItem(sword);
        room2.addItem(lupa);
        room3.addItem(shar);
        Player player = new Player(room1);
        MUDController game = new MUDController(player);
        game.runGameLoop();
    }
}
