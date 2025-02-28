import java.util.ArrayList;
import java.util.List;

interface IDungeonBuilder {
    IDungeonBuilder setDungeonName(String name);
    IDungeonBuilder addRoom(Room room);
    IDungeonBuilder addNPC(NPC npc);
    Dungeon build();
}

class SimpleDungeonBuilder implements IDungeonBuilder {
    private String name;
    private List<Room> rooms = new ArrayList<>();
    private List<NPC> npcs = new ArrayList<>();

    public IDungeonBuilder setDungeonName(String name) {
        this.name = name;
        return this;
    }

    public IDungeonBuilder addRoom(Room room) {
        rooms.add(room);
        return this;
    }

    public IDungeonBuilder addNPC(NPC npc) {
        npcs.add(npc);
        return this;
    }

    public Dungeon build() {
        return new Dungeon(name, rooms, npcs);
    }
}

class Dungeon {
    private String name;
    private List<Room> rooms;
    private List<NPC> npcs;

    public Dungeon(String name, List<Room> rooms, List<NPC> npcs) {
        this.name = name;
        this.rooms = new ArrayList<>(rooms);
        this.npcs = new ArrayList<>(npcs);
    }

    public void display() {
        System.out.println("Dungeon: " + name);
        System.out.println("Rooms: ");
        for (Room room : rooms) {
            System.out.println(" - " + room.getName());
        }
        System.out.println("NPCs: ");
        for (NPC npc : npcs) {
            System.out.println(" - " + npc.getName());
        }
    }
}

interface CloneableGameEntity {
    CloneableGameEntity cloneEntity();
}

class Room implements CloneableGameEntity {
    private String name;
    private String description;

    public Room(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public CloneableGameEntity cloneEntity() {
        return new Room(name, description);
    }
}

class NPC implements CloneableGameEntity {
    private String name;
    private String description;

    public NPC(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public CloneableGameEntity cloneEntity() {
        return new NPC(name, description);
    }
}

class MUDBuilderDemo {
    public static void main(String[] args) {
        SimpleDungeonBuilder builder = new SimpleDungeonBuilder();
        Dungeon dungeon = builder.setDungeonName("Dark Caverns")
                .addRoom(new Room("Entrance", "A dark and damp entrance."))
                .addRoom(new Room("Treasure Room", "A room filled with gold!"))
                .addNPC(new NPC("Goblin King", "The fierce ruler of goblins."))
                .build();

        dungeon.display();
    }
}

class MUDPrototypeDemo {
    public static void main(String[] args) {
        Room originalRoom = new Room("Hallway", "A long dark hallway.");
        Room clonedRoom = (Room) originalRoom.cloneEntity();

        NPC originalNPC = new NPC("Orc Warrior", "A strong green warrior.");
        NPC clonedNPC = (NPC) originalNPC.cloneEntity();

        System.out.println("Cloned Room: " + clonedRoom.getName());
        System.out.println("Cloned NPC: " + clonedNPC.getName());
    }
}

class MUDCombinedDemo {
    public static void main(String[] args) {
        SimpleDungeonBuilder builder = new SimpleDungeonBuilder();
        Room templateRoom = new Room("Hall", "A grand hall.");
        Dungeon dungeon = builder.setDungeonName("Haunted Fortress")
                .addRoom(templateRoom)
                .addRoom((Room) templateRoom.cloneEntity())
                .addRoom((Room) templateRoom.cloneEntity())
                .addNPC(new NPC("Ghost King", "The spectral ruler."))
                .build();

        dungeon.display();
    }
}
