package com.grenader.stocksdash.services;

import com.grenader.stocksdash.models.StockLine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Primary
public class RealStockLineViewService implements StockLineViewService {

    final GetTickersService tickersService;

    final ConversionService conversionService;

    final StockDataService dataService;

    public RealStockLineViewService(GetTickersService tickersService, ConversionService conversionService, StockDataService dataService) {
        this.tickersService = tickersService;
        this.conversionService = conversionService;
        this.dataService = dataService;
    }

    @Override
    public List<StockLine> listAllStockLines() {

        final List<String> tickers = List.of(tickersService.getDefaultTickersStr().split(","));

        return tickers.stream().map(t -> dataService.getStock(t)).
                map(s -> conversionService.convert(s, StockLine.class)).collect(Collectors.toList());
    }
}
