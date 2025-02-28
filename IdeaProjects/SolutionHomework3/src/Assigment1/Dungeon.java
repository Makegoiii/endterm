package Assigment1;
import Assigment2.NPC;
import Assigment2.Room;
import java.util.List;

public class Dungeon {
    private String name;
    private List<Room> rooms;
    private List<NPC> npcs;

    public Dungeon(String name, List<Room> rooms, List<NPC> npcs) {
        this.name = name;
        this.rooms = rooms;
        this.npcs = npcs;
    }

    public void display() {
        System.out.println("Dungeon: " + name);
        System.out.println("Rooms:");
        for (Room room : rooms) {
            System.out.println(" - " + room);
        }
        System.out.println("NPCs:");
        for (NPC npc : npcs) {
            System.out.println(" - " + npc);
        }
    }
}
