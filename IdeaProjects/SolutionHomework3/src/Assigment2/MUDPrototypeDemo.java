package Assigment2;

public class MUDPrototypeDemo {
    public static void main(String[] args) {
        Room prototypeRoom = new Room("Library", "Room filled books");
        NPC prototypeNPC = new NPC("Wizard", "A wise old magician");

        Room clonedRoom1 = (Room) prototypeRoom.cloneEntity();
        Room clonedRoom2 = (Room) prototypeRoom.cloneEntity();
        NPC clonedNPC = (NPC) prototypeNPC.cloneEntity();

        System.out.println("Original Room: " + prototypeRoom);
        System.out.println("Cloned Room 1: " + clonedRoom1);
        System.out.println("Cloned Room 2: " + clonedRoom2);
        System.out.println("Original NPC: " + prototypeNPC);
        System.out.println("Cloned NPC: " + clonedNPC);
    }
}

