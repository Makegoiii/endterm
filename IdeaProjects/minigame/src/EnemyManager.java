import java.util.ArrayList;
import java.util.List;

/**
 * EnemyManager is responsible for managing enemy entities (spawning and removal).
 *
 * SOLID Applied:
 * - Single Responsibility Principle (SRP): This class is dedicated solely to managing enemy lifecycle operations.
 * - Open/Closed Principle (OCP): If new enemy management behaviors are needed, you can extend this class without modifying its existing code.
 */
public class EnemyManager {
    private List<Enemy> enemies;

    public EnemyManager() {
        enemies = new ArrayList<>();
    }

    public void spawnEnemy(Enemy enemy) {
        enemies.add(enemy);
        System.out.println("Spawned enemy: " + enemy.getType());
    }

    public List<Enemy> getEnemies() {
        return enemies;
    }

    public void removeEnemy(Enemy enemy) {
        enemies.remove(enemy);
        System.out.println("Removed enemy: " + enemy.getType());
    }
}

