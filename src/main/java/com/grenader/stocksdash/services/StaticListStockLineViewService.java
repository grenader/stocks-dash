package com.grenader.stocksdash.services;

import com.grenader.stocksdash.models.StockLine;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaticListStockLineViewService implements StockLineViewService {

    @Override
    public List<StockLine> listAllStockLines() {
        return List.of(
                StockLine.builder().ticker("VMware").name("VMware Inc.").currentPrice(150d).build(),
                StockLine.builder().ticker("MSFT").name("Microsoft Inc.").currentPrice(250d).build(),
                StockLine.builder().ticker("DELL").name("DELL Inc.").currentPrice(100d).build()
        );
    }
}
