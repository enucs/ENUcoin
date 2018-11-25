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

    public BlockDaoImpl() {
        database = new ArrayList<>();
        database.add(new Block(0, Instant.EPOCH, new Transaction(null, null, Instant.EPOCH, 0.00), "0"));
    }

    @Override
    public List<Block> selectAllBlocks() {
        return database;
    }
}
