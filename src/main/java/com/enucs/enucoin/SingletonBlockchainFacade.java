package com.enucs.enucoin;

import com.enucs.enucoin.model.Block;
import com.enucs.enucoin.model.Transaction;
import org.json.JSONObject;

import java.time.Instant;
import java.util.ArrayList;

public class SingletonBlockchainFacade {
    private static SingletonBlockchainFacade facade;
    private ArrayList<Block> blockchain = new ArrayList<>();
    private Block previousBlock;

    private SingletonBlockchainFacade() {
        previousBlock = new Block(0, Instant.EPOCH, new Transaction(null, null, Instant.EPOCH, null), "0");
        blockchain.add(previousBlock);
    }

    public static SingletonBlockchainFacade Instance() {
        if (facade == null) {
            facade = new SingletonBlockchainFacade();
        }

        return facade;
    }
}
