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

        Stock stock;
        try {
            stock = YahooFinance.get(ticker);
        } catch (IOException e) {
            e.printStackTrace();
            return StockData.builder().ticker(ticker).build();
        }

  /*      BigDecimal change = stock.getQuote().getChangeInPercent();
        BigDecimal yearHigh = stock.getQuote().getYearHigh();
        BigDecimal yearHighChangePer = stock.getQuote().getChangeFromYearHighInPercent();
        BigDecimal peg = stock.getStats().getPeg();
        BigDecimal dividend = stock.getDividend().getAnnualYieldPercent();
*/
//        stock.print();

        if (stock == null)
            return StockData.builder().ticker(ticker).build();

        return StockData.builder().ticker(ticker).
                companyName(stock.getName()).
                currentPrice(stock.getQuote().getPrice().doubleValue()).
                todayChangePercents(stock.getQuote().getChangeInPercent().doubleValue()).
                yearHigh(stock.getQuote().getYearHigh().doubleValue()).
                yearHighChangePercent(stock.getQuote().getChangeFromYearHighInPercent().doubleValue()).
                build();
    }
}
