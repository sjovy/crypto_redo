package se.lexicon.dao.impl;

//import org.springframework.stereotype.Component;

import se.lexicon.dao.WalletDao;
import se.lexicon.model.Wallet;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//@Component
public class WalletDaoImpl implements WalletDao {

    // Field: a list named storage for the WalletDao
    private List<Wallet> storage;

    // Constructor to initialize the list for the WalletDao
    public WalletDaoImpl() {
        System.out.println("Wallet list is initialized and ready to use...");
        this.storage = new ArrayList<>();
    }

    // Method to take a previously created wallet and add it to the WalletDao
    @Override
    public Wallet storeWallet(Wallet wallet) {
        storage.add(wallet);
        return wallet;
    }

    // Method to find a wallet by its ID inside the WalletDao
    @Override
    public Optional<Wallet> findWalletById(String id) {
        // Use stream to filter the WalletDao and find the wallet with the given ID
        Optional<Wallet> optionalWallet = storage.stream()
                .filter(wallet -> wallet.getId().equals(id))
                .findFirst();
        return optionalWallet;
    }
}



