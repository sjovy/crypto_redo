package se.lexicon.service.impl;

//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;

import se.lexicon.dao.WalletDao;

//import se.lexicon.exception.WalletNotFoundException;
//import se.lexicon.exception.WalletValidationException;

import se.lexicon.model.Wallet;
import se.lexicon.service.WalletManagement;

import java.util.Optional;

//@Component
public class WalletManagementImpl implements WalletManagement {

    // Field: WalletDao interacts with the data layer for Wallet related operations.
    private WalletDao walletDao;

    // Constructor with Dependency injection:
    // The WalletDao is injected into the WalletManagementImpl via the constructor and stored as property (Field).
    //@Autowired
    public WalletManagementImpl(WalletDao walletDao) {
        this.walletDao = walletDao;
    }

    // Creates a new Wallet and stores it using the WalletDao.
    @Override
    public Wallet create(String walletName) {
        if (walletName == null) throw new IllegalArgumentException("Parameter, wallet name, is not valid");
        // TODO: add more logics: if the wallet name exists or not
        Wallet wallet = new Wallet(walletName);
        return walletDao.storeWallet(wallet);
    }

    // Retrieves a Wallet by its id from the WalletDao
    @Override
    public Wallet getById(String id) {
        Optional<Wallet> optionalWallet = walletDao.findWalletById(id);
        if (optionalWallet.isPresent()) {
            return optionalWallet.get();
        }
        throw new IllegalArgumentException("Wallet not found.");
    }
}