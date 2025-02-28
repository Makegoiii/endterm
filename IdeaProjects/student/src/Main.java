//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<Integer> numbers = new ArrayList<>();
        HashSet<Integer> nonUniqueNumbers = new HashSet<>();
        int num=0;
        while ((num = in.nextInt()) != 0) {
            numbers.add(num);
        }
        for (int i = 0; i < numbers.size(); i++) {
            int currentNumber = numbers.get(i);
            if (numbers.subList(i + 1, numbers.size()).contains(currentNumber)) {
                nonUniqueNumbers.add(currentNumber);
            }
        }
        for (Integer number : nonUniqueNumbers) {
            System.out.print(number + " ");
        }
    }
}