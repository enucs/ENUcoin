package com.enucs.enucoin.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.Instant;

public class Transaction {
    private String sender;
    private String recipient;
    private Instant paymentTime;
    private Double amount;

    public Transaction(
            @JsonProperty("sender") String sender,
            @JsonProperty("recipient") String recipient,
            @JsonProperty("paymentTime") Instant paymentTime,
            @JsonProperty("amount") Double amount) {
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
}