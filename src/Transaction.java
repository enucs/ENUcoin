import org.json.JSONObject;

import java.time.Instant;

public class Transaction {
    private String sender;
    private String recipient;
    private Instant paymentTime;
    private Double amount;

    public Transaction(String sender, String recipient, Instant paymentTime, Double amount) {
        this.sender = sender;
        this.recipient = recipient;
        this.paymentTime = paymentTime;
        this.amount = amount;
    }

    public String getSender() {
        return sender;
    }

    public String getRecipient() {
        return recipient;
    }

    public Instant getPaymentTime() {
        return paymentTime;
    }

    public double getAmount() {
        return amount;
    }

    public JSONObject toJSON() {
        return new JSONObject()
                .put("sender", sender)
                .put("recipient", recipient)
                .put("paymentTime", paymentTime)
                .put("amount", amount);
    }
}