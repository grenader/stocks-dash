package com.grenader.stocksdash.services;

import com.grenader.stocksdash.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Primary
public class RealProductService implements ProductService {

    @Autowired
    ConversionService conversionService;

    @Autowired
    StockDataService dataService;

    @Override
    public List<Product> listAllProducts() {

        final List<String> tickers = List.of("VMW", "MSFT", "DELL", "SOXS");

        return tickers.stream().map(t -> dataService.getStock(t)).
                map(s -> conversionService.convert(s, Product.class)).collect(Collectors.toList());

/*
        conversionService.convert

        return List.of(
                Product.builder().ticker("VMW").name("VMware Inc.").currentPrice(150d).build(),
                Product.builder().ticker("MSFT").name("Microsoft Inc.").currentPrice(250d).build(),
                Product.builder().ticker("DELL").name("DELL Inc.").currentPrice(100d).build()
        );
*/
    }
}
