public class ItemManager {
    public void useItem(Player player, String item) {
        System.out.println(player.getName() + " picks up " + item);
        if (item.equals("Gold Coin ")) {
            player.gainExperience(5);
        } else if (item.equals("Health  Elixir")) {
            player.health(20 );
        }

        else if (item.equals("Magic Scroll ")) {
            player.gainExperience(15);
        }
        player.pickUpItem(item);
    }
}

