import java.util.*;













public class Main {
    public static void main(String[] args) {
        Room room = new Room("Dungeon Entrance", "A dark and eerie entrance to the dungeon.");
        Monster monster = new Monster("Goblin", "A small green goblin with sharp teeth.", 30, 5);
        Merchant merchant = new Merchant("Trader", "A wandering trader with various goods.", 100, Arrays.asList("Potion", "Sword"));
        Door door = new Door(true, "Hallway", "A heavy wooden door with iron reinforcements.");

        room.describe();
        monster.describe();
        merchant.describe();
        merchant.trade();
        door.describe();
        door.unlock();
    }
}
