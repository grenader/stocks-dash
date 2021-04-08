package com.grenader.stocksdash.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StockLine {
    private String ticker;
    private String name;
    private double currentPrice;
    private double todayChangePercents;
    private double yearHighPrice;
    private double yearHighChangePercents;
}
