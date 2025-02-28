import java.util.ArrayList;
import java.util.List;

/**
 * MonolithicAdventureGame encapsulates the entire game logic in a single class.
 *
 * Responsibilities included in this class:
 * - Managing player attributes (name, health, experience, inventory)
 * - Handling combat with enemies (e.g., Skeleton, Zombie, Vampire)
 * - Managing item pickups (e.g., Gold Coin, Health Elixir, Magic Scroll)
 * - Advancing game levels and updating game state
 *
 * This design violates several SOLID principles:
 * - Single Responsibility Principle (SRP): One class handles player management, combat, inventory, and level progression.
 * - Open/Closed Principle (OCP): Adding new enemy types, items, or game behaviors requires modifying this class.
 * - Dependency Inversion Principle (DIP): The high-level game logic is tightly coupled with the specific implementations.
 *
 * Homework Assignment:
 * Refactor this monolithic code base into separate classes (e.g., Player, EnemyManager, ItemManager, LevelManager, ScoreManager)
 * using SOLID principles. Document your changes and include UML diagrams to show the new structure.
 */
public class Main {
    // Player attributes
    private String playerName;
    private int playerHealth;
    private int playerExperience;
    private List<String> inventory;

    // Game state: enemies and items available in the current level
    private List<String> enemies;
    private List<String> items;

    // Current game level
    private int level;

    // Constructor: Initializes game state and starting values.
    public Main() {
        this.playerName = "Adventurer";
        this.playerHealth = 100;
        this.playerExperience = 0;
        this.inventory = new ArrayList<>();
        this.enemies = new ArrayList<>();
        this.items = new ArrayList<>();
        this.level = 1;

        // Initial enemies and items for level 1
        enemies.add("Skeleton");
        enemies.add("Zombie");
        items.add("Gold Coin");
        items.add("Health Elixir");
    }

    /**
     * Simulates combat with a given enemy.
     * Updates the player's health and experience based on enemy type,
     * then removes the enemy from the list.
     */
    public void fightEnemy(String enemy) {
        System.out.println(playerName + " engages in combat with " + enemy + "!");
        // Combat simulation: update health and experience based on enemy type
        if (enemy.equals("Skeleton")) {
            playerHealth -= 10;
            playerExperience += 20;
        } else if (enemy.equals("Zombie")) {
            playerHealth -= 15;
            playerExperience += 30;
        } else if (enemy.equals("Vampire")) {
            playerHealth -= 25;
            playerExperience += 50;
        }
        System.out.println("After combat: Health = " + playerHealth + ", Experience = " + playerExperience);
        enemies.remove(enemy);
    }

    /**
     * Simulates picking up an item.
     * Updates the player's inventory and modifies attributes based on the item type,
     * then removes the item from the list.
     */
    public void pickUpItem(String item) {
        System.out.println(playerName + " picks up " + item + ".");
        if (item.equals("Gold Coin")) {
            playerExperience += 5;
        } else if (item.equals("Health Elixir")) {
            playerHealth += 20;
        } else if (item.equals("Magic Scroll")) {
            playerExperience += 15;
        }
        inventory.add(item);
        items.remove(item);
        System.out.println("Inventory now: " + inventory);
    }

    /**
     * Advances the game to the next level.
     * Resets player's health, increments the level, and adds new enemies and items.
     */
    public void advanceLevel() {
        System.out.println("Advancing to next level...");
        level++;
        playerHealth = 100; // Reset health at the beginning of a new level

        // Clear previous enemies and items, then add new ones for the new level.
        enemies.clear();
        items.clear();
        if (level == 2) {
            enemies.add("Vampire");
            items.add("Magic Scroll");
        } else if (level == 3) {
            enemies.add("Vampire");
            enemies.add("Zombie");
            items.add("Health Elixir");
            items.add("Gold Coin");
        }
        System.out.println("Reached level " + level);
    }

    /**
     * Simulates the game progression.
     * Processes combat, item pickups, and level advancement until the game is over.
     */
    public void playGame() {
        while (level <= 3 && playerHealth > 0) {
            System.out.println("=== Level " + level + " ===");
            // Process all enemy encounters
            while (!enemies.isEmpty() && playerHealth > 0) {
                String enemy = enemies.get(0);
                fightEnemy(enemy);
            }
            // Process all item pickups
            while (!items.isEmpty() && playerHealth > 0) {
                String item = items.get(0);
                pickUpItem(item);
            }
            // Advance to the next level if the player is still alive
            if (playerHealth > 0 && level < 3) {
                advanceLevel();
            }
            else {
                break;  // Выход из цикла после уровня 3
            }
        }
        // End-of-game result
        if (playerHealth <= 0) {
            System.out.println(playerName + " has perished. Game Over.");
        } else {
            System.out.println("Congratulations, " + playerName + "! You completed the adventure with "
                    + playerExperience + " experience points!");
        }
    }

    // Main method to run the game simulation.
    public static void main(String[] args) {
        Main game = new Main();
        game.playGame();
    }
}

