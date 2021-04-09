package com.grenader.stocksdash.controllers;

import com.grenader.stocksdash.services.StockLineViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class StocksController {

    @Autowired
    private StockLineViewService stockLineViewService;

    @GetMapping
    public ModelAndView method() {
        return new ModelAndView("redirect:" + "/stocks");
    }

    @GetMapping("/stocks")
    public String listProducts(Model model){
        model.addAttribute("stocks", stockLineViewService.listAllStockLines());
        return "stocks";
    }

}
