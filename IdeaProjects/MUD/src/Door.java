class Door implements IGameEntity {
    boolean locked;
    String leadsTo;
    String description;

    public Door(boolean locked, String leadsTo, String description) {
        this.locked = locked;
        this.leadsTo = leadsTo;
        this.description = description;
    }

    public void lock() {
        locked = true;
        System.out.println("The door is now locked.");
    }

    public void unlock() {
        locked = false;
        System.out.println("The door is now unlocked.");
    }

    public void describe() {
        System.out.println(description);
    }
}
