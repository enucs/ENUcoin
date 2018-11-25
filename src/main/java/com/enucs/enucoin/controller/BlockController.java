package com.enucs.enucoin.controller;

import com.enucs.enucoin.model.Block;
import com.enucs.enucoin.service.BlockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;

import java.util.List;


@RestController
@RequestMapping("blockchain")
public class BlockController {
    private final BlockService blockService;

    @Autowired
    public BlockController(BlockService blockService) {
        this.blockService = blockService;
    }

    @RequestMapping(
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<Block> getAllBlocks() {
        return blockService.getAllBlocks();
    }
}
