package com.grenader.stocksdash.services;

import com.grenader.stocksdash.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaticListProductService implements ProductService {

    @Override
    public List<Product> listAllProducts() {
        return List.of(
                Product.builder().ticker("VMware").name("VMware Inc.").currentPrice(150d).build(),
                Product.builder().ticker("MSFT").name("Microsoft Inc.").currentPrice(250d).build(),
                Product.builder().ticker("DELL").name("DELL Inc.").currentPrice(100d).build()
        );
    }
}
