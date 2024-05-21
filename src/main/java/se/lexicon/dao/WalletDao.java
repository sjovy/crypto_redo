package se.lexicon.dao;

import se.lexicon.model.Wallet;
import java.util.Optional;
// Optional = A container that may or may not contain a non-null value, to represent the absence of a value without using null.

// Interface for the data access object (DAO) of the Wallet
public interface WalletDao {

    // Method to store a wallet object
    Wallet storeWallet(Wallet wallet);

    // Method to find a wallet by its ID and return an Optional of the wallet
    Optional<Wallet> findWalletById(String id);
}