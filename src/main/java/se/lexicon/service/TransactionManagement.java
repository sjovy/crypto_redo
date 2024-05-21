package se.lexicon.service;

import se.lexicon.model.Cryptocurrency;
import se.lexicon.model.Transaction;

import java.math.BigDecimal;
import java.util.List;

public interface TransactionManagement {
    // Create deposit and withdrawal transactions
    Transaction createDepositTransaction(String walletId, Cryptocurrency cryptocurrency, BigDecimal amount, String description);
    Transaction createWithdrawTransaction(String walletId, Cryptocurrency cryptocurrency, BigDecimal amount, String description);

    // Retrieve all transactions associated with a specific wallet, from TransactionDao.
    // // (each transaction object contains info about wallet id)
    List<Transaction> getTransactionsByWalletId(String walletId);

    // Define more methods as needed for transaction management.
}