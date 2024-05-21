package se.lexicon.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;

// Representing a transaction in the cryptocurrency wallet
public class Transaction {

    // Fields
    private String id;
    private String type;
    private BigDecimal amount;
    private String walletId;
    private String cryptocurrencySymbol;
    private String description;
    private LocalDateTime timestamp;

    // Constructor for creating a transaction with dao
    public Transaction(String type, BigDecimal amount, String walletId, String cryptocurrencySymbol) {
        // Check if the amount is valid
        if (amount.compareTo(BigDecimal.ZERO) < 0) throw new IllegalArgumentException("Amount cannot be negative");
        // Type can be either withdrawal or deposit
        this.type = type;
        this.amount = amount;
        this.walletId = walletId;
        this.cryptocurrencySymbol = cryptocurrencySymbol;
        // Set the timestamp to the current time
        this.timestamp = LocalDateTime.now();
    }

    // Constructor for retrieving a transaction from dao
    public Transaction(String id, String type, BigDecimal amount, String walletId,
                       String cryptocurrencySymbol, String description, LocalDateTime timestamp) {
        this.id = id;
        this.type = type;
        this.amount = amount;
        this.walletId = walletId;
        this.cryptocurrencySymbol = cryptocurrencySymbol;
        this.description = description;
        this.timestamp = timestamp;
    }

    // Setters
    public void setDescription(String description) {
        this.description = description;
    }

    // Getters
    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getWalletId() {
        return walletId;
    }

    public String getCryptocurrencySymbol() {
        return cryptocurrencySymbol;
    }

    public String getDescription() {
        return description;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    // Represent the transaction as a string
    @Override
    public String toString() {
        return "Transaction{" +
                "id='" + id + '\'' +
                ", type='" + type + '\'' +
                ", amount=" + amount +
                ", walletId='" + walletId + '\'' +
                ", cryptocurrencySymbol='" + cryptocurrencySymbol + '\'' +
                ", description='" + description + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}