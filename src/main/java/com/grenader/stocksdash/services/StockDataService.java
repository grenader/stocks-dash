package com.grenader.stocksdash.services;

import com.grenader.stocksdash.models.StockData;
import org.springframework.stereotype.Service;
import yahoofinance.Stock;
import yahoofinance.YahooFinance;

import java.io.IOException;
import java.math.BigDecimal;

@Service
public class StockDataService {

    public StockData getStock(String ticker) {

        Stock stock = null;
        try {
            stock = YahooFinance.get(ticker);
        } catch (IOException e) {
            e.printStackTrace();
            throw new IllegalStateException(e);
        }

        BigDecimal change = stock.getQuote().getChangeInPercent();
        BigDecimal peg = stock.getStats().getPeg();
        BigDecimal dividend = stock.getDividend().getAnnualYieldPercent();

        stock.print();

        return StockData.builder().ticker(ticker).
                companyName(stock.getName()).
                currentPrice(stock.getQuote().getPrice().doubleValue()).
                todayChangePercents(stock.getQuote().getChangeInPercent().doubleValue()).
                build();
    }
}
