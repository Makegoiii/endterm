class Game {
    private Player player;
    private LevelManager levelManager;
    private CombatManager combatManager;
    private ItemManager itemManager;
    public Game() {
        this.player = new Player("Adventurer");
        this.levelManager = new LevelManager();
        this.combatManager = new CombatManager();
        this.itemManager = new ItemManager();
    }
    public void play() {
        while  (player.isAlive ()) {
            System.out.println("=== Level " + levelManager.getLevel() + " ===");
            for (Enemy enemy : levelManager.getEnemies()) {
                combatManager.fight(player,enemy );
                if (!player.isAlive()) {
                    System.out.println("Game Over ");
                    return;
                 }
            }

            for (String item : levelManager.getItems()) {
                itemManager.useItem(player, item );
            }
             levelManager.nextLevel();
        }
        System.out.println(" Game completed with "+player.getExperience()+" XP!");
    }
}
