package se.lexicon.dao.impl;

//import org.springframework.stereotype.Component;

import se.lexicon.dao.TransactionDao;
import se.lexicon.model.Transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

//@Component
public class TransactionDaoImpl implements TransactionDao {

    // Field: a list named storage for the TransactionDao
    private List<Transaction> storage;

    // Constructor to initialize the list for the TransactionDao
    public TransactionDaoImpl() {
        this.storage = new ArrayList<>();
    }

    // Method to take a previously created transaction and add it to the TransactionDao
    @Override
    public Transaction storeTransaction(Transaction transaction) {
        storage.add(transaction);
        return transaction;
    }

    // Method to find a transaction by its ID in the TransactionDao
    @Override
    public Optional<Transaction> findById(String transactionId) {
        // Use stream to filter the TransactionDao and find the transaction with the given ID
        return storage.stream()
                .filter(transaction -> transaction.getId().equals(transactionId))
                .findFirst();
    }

    // Method to find all transactions associated with a specific wallet ID in the TransactionDao
    // (each transaction object contains info about wallet id)
    @Override
    public List<Transaction> findTransactionsByWalletId(String walletId) {
        // Use stream to filter the TransactionDao for transactions with the given wallet ID
        return storage.stream()
                .filter(transaction -> transaction.getWalletId().equals(walletId))
                .collect(Collectors.toList());
    }
}


