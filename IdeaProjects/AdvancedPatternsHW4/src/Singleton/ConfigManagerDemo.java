package Singleton;

public class ConfigManagerDemo {
    public static void main(String[] args) {
        ConfigurationManager configManager = ConfigurationManager.getInstance();

        System.out.println("maxPlayers:" + configManager.getConfig("maxPlayers"));
        System.out.println("defaultLanguage: " + configManager.getConfig("defaultLanguage"));
        System.out.println("gameDifficulty:" + configManager.getConfig("gameDifficulty"));

        System.out.println("\nAll Configurations:");
        configManager.printAllConfigs();
    }
}

