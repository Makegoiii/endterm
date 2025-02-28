class Room implements IGameEntity {
    private String name;
    private String description;
    private Map<String, Room> exits = new HashMap<>();
    private List<Item> items = new ArrayList<>();
    private List<NPC> npcs = new ArrayList<>();

    public Room(String name, String description) {
        this.name = name;
        this.description = description;
    }

    // Реализация метода из интерфейса
    @Override
    public String describe() {
        StringBuilder sb = new StringBuilder();
        sb.append(name).append(": ").append(description).append("\\n");

        if (!items.isEmpty()) {
            sb.append("Предметы: ");
            for (Item item : items) {
                sb.append(item.getName()).append(", ");
            }
            sb.append("\\n");
        }

        if (!npcs.isEmpty()) {
            sb.append("NPC: ");
            for (NPC npc : npcs) {
                sb.append(npc.getName()).append(", ");
            }
            sb.append("\\n");
        }

        sb.append("Выходы: ");
        if (!exits.isEmpty()) {
            for (String direction : exits.keySet()) {
                sb.append(direction).append(", ");
            }
        } else {
            sb.append("нет");
        }
        return sb.toString();
    }

    // Методы для управления выходами
    public void addExit(String direction, Room room) {
        exits.put(direction, room);
    }

    public Room getExit(String direction) {
        return exits.get(direction);
    }

    // Методы для управления предметами
    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(Item item) {
        items.remove(item);
    }

    public List<Item> getItems() {
        return items;
    }

    // Методы для управления NPC
    public void addNPC(NPC npc) {
        npcs.add(npc);
    }

    public void removeNPC(NPC npc) {
        npcs.remove(npc);
    }

    public List<NPC> getNPCs() {
        return npcs;
    }
}
