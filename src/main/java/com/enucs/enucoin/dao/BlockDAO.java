package com.enucs.enucoin.dao;

import com.enucs.enucoin.model.Block;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BlockDAO extends MongoRepository<Block, String> {
    //Add any other methods we need here
}
