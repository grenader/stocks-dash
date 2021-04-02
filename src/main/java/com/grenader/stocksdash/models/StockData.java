package com.grenader.stocksdash.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StockData {

    private String ticker;
    private String companyName;

    private double currentPrice;
    private double todayChangePercents;

}
