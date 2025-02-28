import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        ArrayList<Item> items = new ArrayList<>();
        Collections.addAll(
                items,
                new Item("IPhone", "13 Pro Max", 1200),
                new Item("XIAOMI", "Redmi Note 8", 300),
                new Item("Samsung", "Galaxy Note 18", 800),
                new Item("NOKIA", "3110", 100)
        );

        items.stream()
                .flatMap(item -> Stream.of(
                        item.getName() + " for " + item.getPrice() + " USD",
                        item.getName() + " for " + item.getPrice()*420 + " KZT"
                ))
                .forEach(item -> System.out.println(item));
    }
}