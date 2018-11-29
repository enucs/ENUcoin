package com.enucs.enucoin.controller;

import com.enucs.enucoin.dao.BlockDAO;
import com.enucs.enucoin.model.Block;
import com.enucs.enucoin.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;

import java.time.Instant;
import java.util.List;


@RestController
@RequestMapping("blockchain")
public class BlockController {
    private final BlockDAO blockchain;
    private Block previousBlock;

    @Autowired
    public BlockController(BlockDAO blockchain) {
        this.blockchain = blockchain;
        previousBlock = new Block(0, Instant.EPOCH, new Transaction(null, null, Instant.EPOCH, 0.00), "0");
        blockchain.insert(previousBlock); //TODO: This will insert each restart, need a way to make this one off
    }

    @RequestMapping(
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<Block> getAllBlocks() {
        return blockchain.findAll();
    }

    @RequestMapping(
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    public void insertTransaction(@RequestBody Transaction transaction) {
        Block block = new Block(previousBlock.getIndex() + 1, Instant.now(), transaction, previousBlock.getPreviousHash());
        blockchain.insert(block);
        previousBlock = block;
    }
}
