package com.enucs.enucoin.dao;

import com.enucs.enucoin.model.Block;
import com.enucs.enucoin.model.Transaction;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;


@Repository("dao")
public class BlockDaoImpl implements BlockDAO {
    private final List<Block> database;
    private Block previousBlock;

    public BlockDaoImpl() {
        database = new ArrayList<>();
        previousBlock = new Block(0, Instant.EPOCH, new Transaction(null, null, Instant.EPOCH, 0.00), "0");
        database.add(previousBlock);
    }

    @Override
    public List<Block> selectAllBlocks() {
        return database;
    }

    @Override
    public void insertTransaction(Transaction transaction) {
        Block newBlock = new Block(previousBlock.getIndex()+1, Instant.now(), transaction, previousBlock.getHash());
        database.add(newBlock);
        previousBlock = newBlock;
    }
}
