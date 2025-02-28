import java.util.*;

// Класс, представляющий игрока
class Player {
    private String name;
    private int health;
    private int experience;
    private List<String> inventory;

    public Player(String name) {
        this.name = name;
        this.health = 100;
        this.experience = 0;
        this.inventory = new ArrayList<>();
    }

    public void takeDamage(int damage) {
        health -= damage;
    }

    public void gainExperience(int exp) {
        experience += exp;
    }

    public void addItem(String item) {
        inventory.add(item);
    }

    public int getHealth() {
        return health;
    }

    public boolean isAlive() {
        return health > 0;
    }

    public void resetHealth() {
        health = 100;
    }

    public String getName() {
        return name;
    }
}

// Абстрактный класс для врагов
abstract class Enemy {
    protected String name;
    protected int damage;
    protected int experienceReward;

    public Enemy(String name, int damage, int experienceReward) {
        this.name = name;
        this.damage = damage;
        this.experienceReward = experienceReward;
    }

    public void attack(Player player) {
        player.takeDamage(damage);
    }

    public int getExperienceReward() {
        return experienceReward;
    }

    public String getName() {
        return name;
    }
}

// Конкретные классы врагов
class Skeleton extends Enemy {
    public Skeleton() {
        super("Skeleton", 10, 20);
    }
}

class Zombie extends Enemy {
    public Zombie() {
        super("Zombie", 15, 30);
    }
}

class Vampire extends Enemy {
    public Vampire() {
        super("Vampire", 25, 50);
    }
}

// Менеджер врагов
class EnemyManager {
    public static Enemy createEnemy(String type) {
        return switch (type) {
            case "Skeleton" -> new Skeleton();
            case "Zombie" -> new Zombie();
            case "Vampire" -> new Vampire();
            default -> throw new IllegalArgumentException("Unknown enemy type: " + type);
        };
    }
}

// Класс предметов
class Item {
    private String name;
    private int healthBoost;
    private int experienceBoost;

    public Item(String name, int healthBoost, int experienceBoost) {
        this.name = name;
        this.healthBoost = healthBoost;
        this.experienceBoost = experienceBoost;
    }

    public void applyEffect(Player player) {
        player.takeDamage(-healthBoost);
        player.gainExperience(experienceBoost);
    }

    public String getName() {
        return name;
    }
}

// Менеджер предметов
class ItemManager {
    public static Item createItem(String type) {
        return switch (type) {
            case "Gold Coin" -> new Item("Gold Coin", 0, 5);
            case "Health Elixir" -> new Item("Health Elixir", 20, 0);
            case "Magic Scroll" -> new Item("Magic Scroll", 0, 15);
            default -> throw new IllegalArgumentException("Unknown item type: " + type);
        };
    }
}

// Менеджер уровней
class LevelManager {
    private int level;
    private List<Enemy> enemies;
    private List<Item> items;

    public LevelManager() {
        this.level = 1;
        enemies = new ArrayList<>();
        items = new ArrayList<>();
        loadLevel();
    }

    private void loadLevel() {
        enemies.clear();
        items.clear();
        switch (level) {
            case 1 -> {
                enemies.add(EnemyManager.createEnemy("Skeleton"));
                enemies.add(EnemyManager.createEnemy("Zombie"));
                items.add(ItemManager.createItem("Gold Coin"));
                items.add(ItemManager.createItem("Health Elixir"));
            }
            case 2 -> {
                enemies.add(EnemyManager.createEnemy("Vampire"));
                items.add(ItemManager.createItem("Magic Scroll"));
            }
            case 3 -> {
                enemies.add(EnemyManager.createEnemy("Vampire"));
                enemies.add(EnemyManager.createEnemy("Zombie"));
                items.add(ItemManager.createItem("Health Elixir"));
                items.add(ItemManager.createItem("Gold Coin"));
            }
        }
    }

    public List<Enemy> getEnemies() {
        return enemies;
    }

    public List<Item> getItems() {
        return items;
    }

    public void nextLevel() {
        level++;
        loadLevel();
    }

    public int getLevel() {
        return level;
    }
}

// Основной класс игры
public class Main {
    private Player player;
    private LevelManager levelManager;

    public Main() {
        this.player = new Player("Adventurer");
        this.levelManager = new LevelManager();
    }

    public void playGame() {
        while (levelManager.getLevel() <= 3 && player.isAlive()) {
            System.out.println("=== Level " + levelManager.getLevel() + " ===");
            for (Enemy enemy : new ArrayList<>(levelManager.getEnemies())) {
                System.out.println(player.getName() + " fights " + enemy.getName());
                enemy.attack(player);
                player.gainExperience(enemy.getExperienceReward());
                if (!player.isAlive()) break;
            }

            for (Item item : new ArrayList<>(levelManager.getItems())) {
                System.out.println(player.getName() + " picks up " + item.getName());
                item.applyEffect(player);
            }

            if (player.isAlive() && levelManager.getLevel() < 3) {
                levelManager.nextLevel();
                player.resetHealth();
            }
        }
        if (!player.isAlive()) {
            System.out.println(player.getName() + " has perished. Game Over.");
        } else {
            System.out.println("Congratulations, " + player.getName() + "! You completed the adventure with " + player.getHealth() + " experience points!");
        }
    }

    public static void main(String[] args) {
        Main game = new Main();
        game.playGame();
    }
}
