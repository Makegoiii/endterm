import java.util.ArrayList;
import java.util.List;

public class Player {
    private String name;
    private int health ;
     private int experience ;
     private List<String> inventory;
    public Player(String  name) {
        this.name=name;
        this.health=100;
        this.experience=0;
        this.inventory =new ArrayList<>();
    }
    public void takeDamage(int damage) {
        health -= damage;
        if (health < 0) {
            health=0;
        }
    }
    public void gainExperience(int exp) {
        experience += exp;
    }
    public void pickUpItem(String  item) {
        inventory.add(item );
    }
    public boolean isAlive() {
        return health > 0;
    }
    public int getHealth() {
        return health;
    }
    public int getExperience() {
        return experience;
    }
    public String getName() {
        return name;
    }
    public void health(int amount) {
        health += amount;
        if (health > 100) {
            health = 100;
        }
    }
}
