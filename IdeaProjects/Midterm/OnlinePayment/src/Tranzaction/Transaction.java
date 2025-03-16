package Tranzaction;

import java.util.Date;

public class Transaction {
    private String paymentType;
    private double amount;
    private String status;
    private Date date;

    public Transaction(String paymentType, double amount, String status) {
        this.paymentType = paymentType;
        this.amount = amount;
        this.status = status;
        this.date = new Date();
    }

    @Override
    public String toString() {
        return date + " | " + paymentType + " | $" + amount + " | Status: " + status;
    }
}
