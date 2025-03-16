package Payments;
import PaymentMethod.PaymentMethod;
public class CreditCardPay implements PaymentMethod {
    @Override
    public boolean processPayment(double amount) {
        System.out.println("Processing credit card payment of $" + amount);
        // Simulate interaction with a credit card validation API
        return true;
    }
}
