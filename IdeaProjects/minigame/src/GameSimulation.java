import java.util.ArrayList;

/**
 * GameSimulation is the main entry point for the simulation.
 *
 * SOLID Applied:
 * - Single Responsibility Principle (SRP): This class sets up and runs the simulation but delegates responsibilities
 *   like score management, enemy management, and player actions to their respective classes.
 * - Dependency Inversion Principle (DIP): The Player class is constructed using the ScoreManager interface,
 *   making it independent of the specific implementation of score management.
 */
public class GameSimulation {
    public static void main(String[] args) {
        // Create a ScoreManager using its abstraction (ScoreManager interface)
        ScoreManager scoreManager = new GameScoreManager();

        // Create the EnemyManager which is responsible for managing enemy entities
        EnemyManager enemyManager = new EnemyManager();

        // Create a Player that interacts with the game.
        // Note: Player depends on the ScoreManager abstraction, demonstrating DIP.
        Player player = new Player("Hero", scoreManager);

        // Spawn some enemies; Enemy objects are simple data holders (SRP)
        enemyManager.spawnEnemy(new Enemy("Goblin", 50));
        enemyManager.spawnEnemy(new Enemy("Orc", 80));

        // Simulate the game loop:
        // Iterate over a copy of the enemy list to avoid concurrent modification issues.
        // The loop demonstrates proper delegation:
        // - Player actions are handled by the Player class.
        // - Score updates are handled by GameScoreManager.
        // - Enemy lifecycle management is handled by EnemyManager.
        for (Enemy enemy : new ArrayList<>(enemyManager.getEnemies())) {
            player.defeatEnemy(enemy);
            enemyManager.removeEnemy(enemy);
        }

        System.out.println("Final Score: " + scoreManager.getScore());
    }
}

