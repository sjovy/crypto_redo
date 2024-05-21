package se.lexicon.dao;

import se.lexicon.model.Transaction;

import java.util.List;
import java.util.Optional;
// Optional = A container that may or may not contain a non-null value, to represent the absence of a value without using null.

// Interface for the data access object (DAO) of the Transaction
public interface TransactionDao {

    // Method to store a transaction object
    Transaction storeTransaction(Transaction transaction);

    // Method to find a transaction by its ID and return an Optional of the transaction
    Optional<Transaction> findById(String transactionId);

    // Method to return a list of all transactions associated with a specific wallet ID
    List<Transaction> findTransactionsByWalletId(String walletId);
}