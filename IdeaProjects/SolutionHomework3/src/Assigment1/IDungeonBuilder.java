package Assigment1;
import Assigment2.NPC;
import Assigment2.Room;
public interface IDungeonBuilder {
    IDungeonBuilder setDungeonName(String name);
    IDungeonBuilder addRoom(Room room);
    IDungeonBuilder addNPC(NPC npc);
    Dungeon build();
}

