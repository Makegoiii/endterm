import java.util.List;

class Merchant extends NPC {
    int gold;
    List<String> items;

    public Merchant(String name, String description, int gold, List<String> items) {
        super(name, description);
        this.gold = gold;
        this.items = items;
    }

    public void trade() {
        System.out.println(name + " offers: " + items);
    }
    public void describe() {
        System.out.println(name + ": " + description);
    }
}