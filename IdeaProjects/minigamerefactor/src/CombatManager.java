public class CombatManager {
    public void fight(Player player, Enemy enemy) {
        System.out.println(player.getName()+" engages in combat with "+enemy.getName());
        player.takeDamage(enemy.getDamage());
        player.gainExperience(enemy.getExperienceReward());
        System.out.println("After combat: Health = " + player.getHealth() + ",  Experience = " + player.getExperience());
    }
}

