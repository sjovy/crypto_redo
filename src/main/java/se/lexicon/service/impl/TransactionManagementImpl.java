package se.lexicon.service.impl;

//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;

import se.lexicon.dao.TransactionDao;
import se.lexicon.dao.WalletDao;

//import se.lexicon.exception.WalletNotFoundException;

import se.lexicon.model.Cryptocurrency;
import se.lexicon.model.Transaction;
import se.lexicon.model.Wallet;
import se.lexicon.service.TransactionManagement;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

//@Component
public class TransactionManagementImpl implements TransactionManagement {

    // Field: WalletDao interacts with the data layer for Wallet related operations.
    private WalletDao walletDao;

    // Field: TransactionDao interacts with the data layer for Transaction related operations.
    private TransactionDao transactionDao;

    // Constructor with Dependency injection:
    // The WalletDao and TransactionDao are injected into the TransactionManagementImpl via the constructor and stored as properties (Fields).
    //@Autowired
    public TransactionManagementImpl(WalletDao walletDao, TransactionDao transactionDao) {
        this.walletDao = walletDao;
        this.transactionDao = transactionDao;
    }

    // Creates a deposit transaction for a specific wallet.
    @Override
    public Transaction createDepositTransaction(String walletId, Cryptocurrency cryptocurrency, BigDecimal amount, String description) {
        //1. Validate params
        //2. Check if wallet id exists
        //3. Call the deposit method on the wallet object
        //4. Create transaction
        //5. Save it to the storage
        if (walletId == null || cryptocurrency == null || amount == null)
            throw new IllegalArgumentException("Wallet params are not valid.");
        Optional<Wallet> optionalWallet = walletDao.findWalletById(walletId);
        if (!optionalWallet.isPresent()) throw new IllegalArgumentException("Wallet not found.");
        Wallet wallet = optionalWallet.get();
        wallet.deposit(cryptocurrency, amount);
        Transaction transaction = new Transaction("DEPOSIT", amount, walletId, cryptocurrency.getName());
        transaction.setDescription(description);
        return transactionDao.storeTransaction(transaction);
    }

    // Creates a withdrawal transaction for a specific wallet.
    // TODO: Implement this method.
    @Override
    public Transaction createWithdrawTransaction(String walletId, Cryptocurrency cryptocurrency, BigDecimal amount, String description) {
        return null;
    }

    // Method to retrieve all transactions associated with a specific wallet from the TransactionDao.
    // TODO: Implement this method.
    @Override
    public List<Transaction> getTransactionsByWalletId(String walletId) {
        return null;
    }
}