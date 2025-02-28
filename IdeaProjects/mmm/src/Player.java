class Player {
    private String name;
    private Room currentRoom;
    private List<Item> inventory = new ArrayList<>();

    public Player(String name, Room startRoom) {
        this.name = name;
        this.currentRoom = startRoom;
    }

    public String getName() {
        return name;
    }

    public Room getRoom() {
        return currentRoom;
    }

    public boolean move(String direction) {
        Room newRoom = currentRoom.getExit(direction);
        if (newRoom != null) {
            currentRoom = newRoom;
            return true;
        }
        return false;
    }

    public boolean pickUp(String itemName) {
        // Ищем предмет в комнате
        for (Item it : currentRoom.getItems()) {
            if (it.getName().equalsIgnoreCase(itemName)) {
                inventory.add(it);
                currentRoom.removeItem(it);
                return true;
            }
        }
        return false;
    }

    public String getInventory() {
        if (inventory.isEmpty()) {
            return "ничего";
        }
        StringBuilder sb = new StringBuilder();
        for (Item item : inventory) {
            sb.append(item.getName()).append(", ");
        }
        return sb.toString();
    }
}
