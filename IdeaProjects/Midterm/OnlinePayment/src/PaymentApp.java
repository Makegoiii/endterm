import Adapter.CreditCardAdapter;
import PaymentMethod.PaymentMethod;
import Tranzaction.TransactionLogger;

import java.util.Scanner;

public class PaymentApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TransactionLogger logger = new TransactionLogger();

        while (true) {
            System.out.println("\nSelect Payment Method: (creditcard / paypal / crypto)");
            String type = scanner.nextLine().toLowerCase();

            System.out.print("Enter Amount: ");
            double amount = scanner.nextDouble();
            scanner.nextLine(); // Consume newline

            PaymentMethod paymentMethod;

            if (type.equals("creditcard")) {
                System.out.print("Enter Credit Card Number: ");
                String cardNumber = scanner.nextLine();
                paymentMethod = new PaymentMethod() {
                    @Override
                    public boolean processPayment(double amount) {
                        return false;
                    }
                };
            } else {
                paymentMethod = PaymentFactory.getPaymentMethod(type);
            }

            boolean success = paymentMethod.processPayment(amount);
            logger.logTransaction(type, amount, success);

            System.out.println("Do you want to view transaction history? (yes/no)");
            if (scanner.nextLine().equalsIgnoreCase("yes")) {
                logger.printHistory();
            }

            System.out.println("Do you want to make another transaction? (yes/no)");
            if (!scanner.nextLine().equalsIgnoreCase("yes")) {
                break;
            }
        }

        scanner.close();
    }
}

