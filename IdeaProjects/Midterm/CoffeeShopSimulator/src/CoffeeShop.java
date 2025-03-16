
import java.util.Scanner;

public class CoffeeShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Coffee Shop!");
        System.out.println("Choose your coffee:Espresso,Cappuccino,Latte,Americano ");
        String coffeeType = scanner.nextLine();
        Coffee coffee = CoffeeFactory.createCoffee(coffeeType);

        boolean addingIngredients = true;
        while (addingIngredients) {
            System.out.println("Add toppings: Milk, Caramel, Whipped Cream, Chocolate (Dlya zavershenie napishite done)");
            String topping = scanner.nextLine().trim().toLowerCase();
            switch (topping) {
                case "milk" -> coffee = new MilkDecorator(coffee);
                case "caramel" -> coffee = new CaramelDecorator(coffee);
                case "whipped cream" -> coffee = new WhippedCreamDecorator(coffee);
                case "chocolate" -> coffee = new ChocolateDecorator(coffee);
                case "done" -> {
                    addingIngredients = false;
                    break;
                }
                default -> System.out.println("Invalid topping, please try again.");
            }
        }
        System.out.println("\nYour order: " + coffee.getDescription());
        System.out.println("Total cost: $" + coffee.getCost());
        scanner.close();
    }
}