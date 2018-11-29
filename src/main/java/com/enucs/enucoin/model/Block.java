package com.enucs.enucoin.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.Instant;
import java.util.Base64;

public class Block {
    private int index;
    private Instant timestamp;
    private Transaction transaction;
    private String previousHash;
    private String hash;

    public Block(
            @JsonProperty("index") int index,
            @JsonProperty("timestamp") Instant timestamp,
            @JsonProperty("transaction") Transaction transaction,
            @JsonProperty("previousHash") String previousHash) {
        this.index = index;
        this.timestamp = timestamp;
        this.transaction = transaction;
        this.previousHash = previousHash;
        this.hash = makeHash();
    }

    private String makeHash() {
        MessageDigest digest;
        try {
            digest = MessageDigest.getInstance("SHA-256");
            String fullString = String.format("%s%s%s%s", index, timestamp.toString(), transaction.toString(), previousHash);
            byte[] hash = digest.digest(fullString.getBytes());

            return Base64.getEncoder().encodeToString(hash);

        } catch(NoSuchAlgorithmException e) {
            System.out.println(e.getMessage());
        }

        return "";
    }

    public int getIndex() {
        return index;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public String getPreviousHash() {
        return previousHash;
    }

    public String getHash() {
        return hash;
    }

    @Override
    public String toString() {
        return "Block{" +
                "index=" + index +
                ", timestamp=" + timestamp +
                ", transaction=" + transaction.toString() +
                ", previousHash='" + previousHash + '\'' +
                ", hash='" + hash + '\'' +
                '}';
    }
}