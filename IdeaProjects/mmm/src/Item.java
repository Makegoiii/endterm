class Item implements IGameEntity {
    private String name;
    private String description;

    public Item(String name, String description) {
        this.name = name;
        this.description = description;
    }

    // Метод из интерфейса
    @Override
    public String describe() {
        return name + ": " + description;
    }

    public String getName() {
        return name;
    }
}