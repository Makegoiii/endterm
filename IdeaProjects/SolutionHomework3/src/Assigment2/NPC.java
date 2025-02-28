package Assigment2;

public class NPC implements CloneableGameEntity {
    private String name;
    private String description;

    public NPC(String name, String description) {
        this.name = name;
        this.description = description;
    }

    @Override
    public CloneableGameEntity cloneEntity() {
        return new NPC(name, description);
    }

    @Override
    public String toString() {
        return name + " - " + description;
    }
}

