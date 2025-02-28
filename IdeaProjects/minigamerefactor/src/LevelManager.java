import java.util.ArrayList;
import java.util.List;

class LevelManager {
    private int level;
     private List<Enemy> enemies;
     private List<String> items;
     private static final int MAX_LEVEL = 3;
    public LevelManager() {
        this.level = 1;
        this.enemies = new ArrayList<>();
        this.items = new ArrayList<>();
        loadLevel();
    }
    public void loadLevel() {
        enemies.clear();
        items.clear();
        if (level == 1) {
            enemies.add(new Skeleton());
            enemies.add(new Zombie());
            items.add("Gold  Coin");
            items.add("Health  Elixir");
        } else if (level == 2) {
            enemies.add(new Vampire());
            items.add("Magic  Scroll");
        } else if (level == 3) {
            enemies.add(new Vampire());
            enemies.add(new Zombie());
            items.add("Health Elixir");
            items.add("Gold Coin");
        }
    }
    public void nextLevel() {
        if (level <MAX_LEVEL) {
            level++;
            loadLevel();
        } else {
            System.out.println("Congratulations! You completed the game!");
            System.exit(0);
        }
    }
    public int getLevel() {
        return level;
    }
    public List<Enemy> getEnemies() {
        return enemies;
    }
    public List<String> getItems() {
        return items;
    }
}
