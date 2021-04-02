package com.grenader.stocksdash.converters;

import com.grenader.stocksdash.models.Product;
import com.grenader.stocksdash.models.StockData;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

@Service
public class StockDataToStockLineConverter implements Converter<StockData, Product> {

    @Override
    public Product convert(StockData stockData) {
        return Product.builder().
                ticker(stockData.getTicker()).
                name(stockData.getCompanyName()).
                currentPrice(stockData.getCurrentPrice()).
                todayChangePercents(stockData.getTodayChangePercents()).
                build();
    }
}
