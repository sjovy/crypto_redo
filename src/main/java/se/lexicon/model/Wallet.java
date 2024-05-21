package se.lexicon.model;

// import se.lexicon.exception.InsufficientBalanceException;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

// Representing a cryptocurrency wallet
public class Wallet {

    // Fields
    private final String id;
    private final String walletName;
    private final Map<Cryptocurrency, BigDecimal> cryptocurrencies;

    // Constructor
    public Wallet(String walletName) {
        // Generate a unique ID for the wallet
        this.id = UUID.randomUUID().toString();
        this.walletName = walletName;
        // Initialize the map of cryptocurrencies
        this.cryptocurrencies = new HashMap<>();
    }

    // Getters
    public String getId() {
        return id;
    }

    public String getWalletName() {
        return walletName;
    }

    public Map<Cryptocurrency, BigDecimal> getCryptocurrencies() {
        return cryptocurrencies;
    }

    // Method to deposit a certain amount of a cryptocurrency into the wallet
    public void deposit(Cryptocurrency cryptocurrency, BigDecimal amount) {
        // Check if the amount is valid
        if (amount.compareTo(BigDecimal.ZERO) <= 0)
            throw new IllegalArgumentException("Deposit must be grater than zero.");
        // Get the current balance of the cryptocurrency
        BigDecimal currentBalance = getBalance(cryptocurrency);
        // Calculate the new balance
        BigDecimal newBalance = currentBalance.add(amount);
        // Update the balance in the cryptocurrencies map
        cryptocurrencies.put(cryptocurrency, newBalance);
    }

    // Method to withdraw a certain amount of a cryptocurrency from the wallet
    public void withdraw(Cryptocurrency cryptocurrency, BigDecimal amount) {
        // Check if the amount is valid
        if (amount.compareTo(BigDecimal.ZERO) <= 0)
            throw new IllegalArgumentException("Withdrawal must be grater than zero.");
        // Get the current balance of the cryptocurrency
        BigDecimal currentBalance = getBalance(cryptocurrency);
        // Check if the balance is sufficient for the withdrawal
        if (currentBalance.compareTo(amount) < 0)
            throw new IllegalArgumentException("Insufficient balance for withdrawal.");
        // Calculate the new balance
        BigDecimal newBalance = currentBalance.subtract(amount);
        // Update the balance in the cryptocurrencies map
        cryptocurrencies.put(cryptocurrency, newBalance);
    }

    // Method to get the balance of a certain cryptocurrency in the wallet
    public BigDecimal getBalance(Cryptocurrency cryptocurrency) {
        // Return the balance or zero if the cryptocurrency is not in the map
        return cryptocurrencies.getOrDefault(cryptocurrency, BigDecimal.ZERO);
    }

    // Represent the wallet as a string
    @Override
    public String toString() {
        return "Wallet{" +
                "id='" + id + '\'' +
                ", walletName='" + walletName + '\'' +
                ", cryptocurrencies=" + cryptocurrencies +
                '}';
    }
}