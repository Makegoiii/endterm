package Tranzaction;

import java.util.ArrayList;
import java.util.List;

public class TransactionLogger {
    private List<Transaction> transactions = new ArrayList<>();

    public void logTransaction(String paymentType, double amount, boolean success) {
        String status = success ? "Completed" : "Failed";
        transactions.add(new Transaction(paymentType, amount, status));
    }

    public void printHistory() {
        System.out.println("Transaction History:");
        for (Transaction t : transactions) {
            System.out.println(t);
        }
    }
}

