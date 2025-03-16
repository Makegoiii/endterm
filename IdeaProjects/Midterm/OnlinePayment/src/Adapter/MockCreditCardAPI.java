package Adapter;
public class MockCreditCardAPI {
    public boolean validateCard(String cardNumber) {
        return cardNumber.length() == 16; // Simple validation logic
    }

    public boolean chargeCard(String cardNumber, double amount) {
        System.out.println("Charging card: " + cardNumber + " for $" + amount);
        return true;
    }
}

