package com.grenader.stocksdash.services;

import com.grenader.stocksdash.models.StockData;
import com.grenader.stocksdash.models.StockLine;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.core.convert.ConversionService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RealStockLineViewServiceTest {

    @Mock
    private GetTickersService tickersService;

    @Mock
    private StockDataService dataService;

    @Mock
    private ConversionService conversionService;

    @InjectMocks
    private RealStockLineViewService service;

    @BeforeEach
    public void setUp() {
        when(tickersService.getDefaultTickersStr()).thenReturn("MSFT, VMW");

        final StockData msftStock = StockData.builder().ticker("MSFT").companyName("Microsoft Inc.").build();
        final StockData vmwStock = StockData.builder().ticker("VMW").companyName("VMware Inc.").build();

        when(dataService.getStock("MSFT")).thenAnswer(invocationOnMock -> {
            if ("MSFT".equals(((String) invocationOnMock.getArguments()[0]))) {
                return msftStock;
            }
            return vmwStock;
        });

        when(conversionService.convert(any(StockData.class), eq(StockLine.class)))
                .thenAnswer(invocationOnMock -> {
                    if ("MSFT".equals(((StockData) invocationOnMock.getArguments()[0]).getTicker())) {
                        return StockLine.builder().ticker("MSFT").name("Microsoft Inc.").build();
                    }
                    return StockLine.builder().ticker("VMW").name("VMware Inc.").build();
                });
    }

    @Test
    void listAllStockLines() {

        final List<StockLine> stockLines = service.listAllStockLines();

        assertEquals(2, stockLines.size());
        assertEquals(StockLine.builder().ticker("MSFT").name("Microsoft Inc.").build(), stockLines.get(0));
    }
}