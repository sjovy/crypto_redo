package se.lexicon.model;

// Enum representing different types of cryptocurrencies
public enum Cryptocurrency {
    // Each enum constant is a type of cryptocurrency
    BTC("Bitcoin"),
    ETH("Ethereum"),
    USDT("TetherUs"),
    BNB("BNB");

    // Field to store the name of the cryptocurrency
    private final String name;

    // Constructor to initialize the name of the cryptocurrency
    Cryptocurrency(String name) {
        this.name = name;
    }

    // Getter to retrieve the name of the cryptocurrency
    public String getName() {
        return name;
    }
}