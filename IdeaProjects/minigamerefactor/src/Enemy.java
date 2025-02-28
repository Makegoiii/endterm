public interface Enemy {
     String getName() ;
    int getDamage();
    int getExperienceReward();
}

class Skeleton implements Enemy  {
    public String getName() { return  "Skeleton"; }
    public int getDamage() { return 10; }
    public int getExperienceReward( ) { return 20; }
}
class  Zombie implements Enemy {
    public String getName(){ return "Zombie";}
    public int getDamage() {return 15; }
    public int getExperienceReward() {return 30; }
}
class Vampire implements Enemy {
    public String  getName() {return "Vampire"; }
    public int getDamage() { return 25; }
    public int getExperienceReward() { return 50; }
}
