package Assigment1;
import Assigment2.NPC;
import Assigment2.Room;
public class MUDBuilderDemo {
    public static void main(String[] args) {
        Room room1 = new Room("Зал", "A dark hall");
        Room room2 = new Room("Палата", "Потайная комната с сокровищами");
        NPC goblin = new NPC("Goblin", "Маленькоено опасное существо");

        Dungeon dungeon = new SimpleDungeonBuilder()
                .setDungeonName("Temnaya peshera")
                .addRoom(room1)
                .addRoom(room2)
                .addNPC(goblin)
                .build();

        dungeon.display();
    }
}
