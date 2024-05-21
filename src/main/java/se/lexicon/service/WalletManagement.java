package se.lexicon.service;

import se.lexicon.model.Wallet;

// Interface defining the operations that can be performed on a Wallet.
public interface WalletManagement {

    // Creates a new Wallet with the given walletName.
    Wallet create(String walletName);

    // To retrieve a Wallet by its id from WalletDao.
    Wallet getById(String id);

    // Define more methods as needed . . .
}