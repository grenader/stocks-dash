package com.grenader.stocksdash.services;

import com.grenader.stocksdash.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ProductService {

    List<Product> listAllProducts();

}
