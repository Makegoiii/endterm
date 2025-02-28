class Monster extends NPC {
    int health;
    int attack;

    public Monster(String name, String description, int health, int attack) {
        super(name, description);
        this.health = health;
        this.attack = attack;
    }

    public void attack() {
        System.out.println(name + " attacks with " + attack + " power!");
    }
    public void describe() {
        System.out.println(name + ": " + description);
    }
}
