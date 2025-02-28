import java.io.*;
import java.net.*;
import java.util.*;



// 2) Класс предмета (Item)


// 3) Класс неигрового персонажа (NPC)


// 4) Класс комнаты (Room)


// 5) Класс игрока (Player)


// 6) Основной сервер
public class MudGameServer {
    private static final int PORT = 5555;
    // Карта доступных комнат
    private static Map<String, Room> rooms = new HashMap<>();
    // Список игроков по имени
    private static Map<String, Player> players = new HashMap<>();

    public static void main(String[] args) {
        // Инициализируем комнаты и наполняем их
        setupRooms();

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Сервер запущен на порту " + PORT);
            while (true) {
                Socket socket = serverSocket.accept();
                new Thread(new ClientHandler(socket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void setupRooms() {
        // Создаём комнаты
        Room start = new Room("Старт", "Ты находишься в тёмной комнате. Есть дверь на север.");
        Room hallway = new Room("Коридор", "Ты в длинном коридоре. Запад ведёт в библиотеку, юг — обратно.");
        Room library = new Room("Библиотека", "Ты в старой библиотеке. Полки покрыты пылью.");

        // Связываем комнаты
        start.addExit("north", hallway);
        hallway.addExit("south", start);
        hallway.addExit("west", library);
        library.addExit("east", hallway);

        // Добавляем предметы
        start.addItem(new Item("Фонарь", "Старый фонарь, покрытый пылью."));
        library.addItem(new Item("Старый ключ", "Потрёпанный ключ с выгравированным узором."));

        // Добавляем NPC (пример)
        library.addNPC(new NPC("Библиотекарь", "Старик, который ищет пропавшую книгу."));

        // Кладём в глобальную карту
        rooms.put("start", start);
        rooms.put("hallway", hallway);
        rooms.put("library", library);
    }

    // Обработчик клиента
    private static class ClientHandler implements Runnable {
        private Socket socket;
        private PrintWriter out;
        private BufferedReader in;
        private Player player;

        public ClientHandler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);

                out.println("Введите ваше имя: ");
                String name = in.readLine().trim();
                // Создаём игрока в начальной комнате
                player = new Player(name, rooms.get("start"));
                players.put(name, player);

                out.println("Добро пожаловать, " + name + "! " + player.getRoom().describe());

                String command;
                while ((command = in.readLine()) != null) {
                    String response = processCommand(command.toLowerCase().trim());
                    out.println(response);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (player != null) {
                    players.remove(player.getName());
                }
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        private String processCommand(String command) {
            if (command.equals("look")) {
                return player.getRoom().describe();

            } else if (command.startsWith("go ")) {
                String direction = command.substring(3);
                if (player.move(direction)) {
                    return player.getRoom().describe();
                } else {
                    return "Ты не можешь идти в этом направлении.";
                }

            } else if (command.startsWith("pick up ")) {
                String itemName = command.substring(8).trim();
                if (player.pickUp(itemName)) {
                    return "Ты взял " + itemName + ".";
                } else {
                    return "Здесь этого нет.";
                }

            } else if (command.equals("inventory")) {
                return "У тебя есть: " + player.getInventory();

            } else if (command.equals("help")) {
                return "Доступные команды: look, go <направление>, pick up <предмет>, inventory, help";

            } else {
                return "Неизвестная команда. Введите 'help' для списка команд.";
            }
        }
    }
}
