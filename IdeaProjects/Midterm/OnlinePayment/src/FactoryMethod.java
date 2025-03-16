import PaymentMethod.PaymentMethod;
import Payments.*;
class PaymentFactory {
    public static PaymentMethod getPaymentMethod(String type) {
        switch (type.toLowerCase()) {
            case "creditcard":
                return new CreditCardPay();
            case "paypal":
                return new PayPalPayment();
            case "crypto":
                return new CryptoPayment();
            default:
                throw new IllegalArgumentException("Invalid payment method.");
        }
    }
}

