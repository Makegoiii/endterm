class NPC implements IGameEntity {
    private String name;
    private String description;

    public NPC(String name, String description) {
        this.name = name;
        this.description = description;
    }

    @Override
    public String describe() {
        return name + ": " + description;
    }

    public String getName() {
        return name;
    }
}
