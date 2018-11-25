package com.enucs.enucoin.service;

import com.enucs.enucoin.dao.BlockDAO;
import com.enucs.enucoin.model.Block;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class BlockService {
    private final BlockDAO blockDao;

    @Autowired
    public BlockService(@Qualifier("dao") BlockDAO blockDao) {
        this.blockDao = blockDao;
    }

    public List<Block> getAllBlocks() { return blockDao.selectAllBlocks(); }
}
