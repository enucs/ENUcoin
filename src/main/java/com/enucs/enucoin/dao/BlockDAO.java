package com.enucs.enucoin.dao;

import com.enucs.enucoin.model.Block;
import com.enucs.enucoin.model.Transaction;

import java.util.List;

public interface BlockDAO {
    List<Block> selectAllBlocks();

    void insertTransaction(Transaction transaction);
}
