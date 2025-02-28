class Item implements IGameEntity {
    String name;
    String description;

    public Item(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public void describe() {
        System.out.println(name + ": " + description);
    }
}
