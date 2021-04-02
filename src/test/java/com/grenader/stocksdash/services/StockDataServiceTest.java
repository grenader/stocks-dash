package com.grenader.stocksdash.services;

import com.grenader.stocksdash.models.StockData;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.junit.jupiter.api.Assertions.*;

class StockDataServiceTest {

    private StockDataService service = new StockDataService();

    @Test
    public void testGetCurrentPrice()
    {
        StockData stock = service.getStock("MSFT");

        assertEquals("MSFT", stock.getTicker());
        assertEquals("Microsoft Corporation", stock.getCompanyName());
        assertThat(stock.getCurrentPrice(), greaterThan(100d));
    }

}