package com.enucs.enucoin.dao;

import com.enucs.enucoin.model.Block;

import java.util.List;

public interface BlockDAO {
    List<Block> selectAllBlocks();
}
