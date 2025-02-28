/**
 * Player handles user interactions (e.g., defeating enemies).
 *
 * SOLID Applied:
 * - Single Responsibility Principle (SRP): This class is only responsible for player actions and interactions.
 * - Dependency Inversion Principle (DIP): It depends on the ScoreManager abstraction, not a concrete implementation.
 *   This allows for flexible substitution of different scoring strategies without modifying the Player class.
 */
public class Player {
    private String name;
    private ScoreManager scoreManager;

    public Player(String name, ScoreManager scoreManager) {
        this.name = name;
        this.scoreManager = scoreManager;
    }

    public String getName() {
        return name;
    }

    // When the player defeats an enemy, it delegates the score update to the ScoreManager,
    // ensuring that the responsibility for scoring is separated.
    public void defeatEnemy(Enemy enemy) {
        System.out.println(name + " defeated enemy: " + enemy.getType());
        scoreManager.updateScore(enemy.getPoints());
    }
}

