package Assigment3;
import Assigment2.NPC;
import Assigment2.Room;
import Assigment1.Dungeon;
import Assigment1.SimpleDungeonBuilder;
public class MUDCombinedDemo {
    public static void main(String[] args) {
        Room room1 = new Room("Зал", "A dark hall");
        Room room2 = new Room("Палата", "Потайная комната с сокровищами");
        NPC goblin = new NPC("Goblin", "Маленькое, но опасное существо");

        Dungeon dungeon = new SimpleDungeonBuilder()
                .setDungeonName("Темная пещера")
                .addRoom(room1)
                .addRoom(room2)
                .addNPC(goblin)
                .build();

        dungeon.display();
    }
}

