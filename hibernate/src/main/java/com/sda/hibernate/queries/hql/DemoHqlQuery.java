package com.sda.hibernate.queries.hql;

import java.util.List;

public class DemoHqlQuery {

    public static void main(String[] args) {
        // add 2 stock
        Stock stock1 = new Stock();
        stock1.setName("stock1");
        stock1.setStockCode("S0223");

        Stock stock2 = new Stock();
        stock2.setName("stock2");
        stock2.setStockCode("S0445");

        // save
        StockDao stockDao = new StockDao();
        stockDao.create(stock1);
        stockDao.create(stock2);

        // findAll
        List allStocks = stockDao.findAllWithHqlQuery();
        allStocks.forEach(stock -> System.out.println(stock));

        // findAll by stock code
        List filteredStocks = stockDao.findAllByStockCodeWithNamedQuery(stock2.getStockCode());
        System.out.println("--- filtered stocks: " + filteredStocks);
    }
}
