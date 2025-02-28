class NPC implements IGameEntity {
    String name;
    String description;

    public NPC(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public void describe() {
        System.out.println(name + ": " + description);
    }
}
