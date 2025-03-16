package Adapter;

import PaymentMethod.PaymentMethod;

public class CreditCardAdapter implements PaymentMethod {
    private MockCreditCardAPI creditCardAPI;
    private String cardNumber;

    public CreditCardAdapter(String cardNumber) {
        this.creditCardAPI = new MockCreditCardAPI();
        this.cardNumber = cardNumber;
    }

    @Override
    public boolean processPayment(double amount) {
        if (!creditCardAPI.validateCard(cardNumber)) {
            System.out.println("Invalid credit card number.");
            return false;
        }
        return creditCardAPI.chargeCard(cardNumber, amount);
    }
}

