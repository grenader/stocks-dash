package com.grenader.stocksdash.converters;

import com.grenader.stocksdash.models.StockLine;
import com.grenader.stocksdash.models.StockData;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

@Service
public class StockDataToStockLineConverter implements Converter<StockData, StockLine> {

    @Override
    public StockLine convert(StockData stockData) {
        return StockLine.builder().
                ticker(stockData.getTicker()).
                name(stockData.getCompanyName()).
                currentPrice(stockData.getCurrentPrice()).
                todayChangePercents(stockData.getTodayChangePercents()).
                yearHighPrice(stockData.getYearHigh()).
                yearHighChangePercents(stockData.getYearHighChangePercent()).
                build();
    }
}
