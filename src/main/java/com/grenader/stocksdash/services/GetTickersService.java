package com.grenader.stocksdash.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class GetTickersService {

    @Value("${stocks.list.default:VMW,DELL,INTC}")
    private String defaultTickersStr;

    public String getDefaultTickersStr() {
        return defaultTickersStr;
    }
}
