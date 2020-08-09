package com.sda.hibernate.queries.native_query;

import java.util.List;

public class DemoNativeQuery {

    public static void main(String[] args) {
        // add 2 trader
        Trader trader1 = new Trader();
        trader1.setName("trader1");

        Trader trader2 = new Trader();
        trader2.setName("trader2");

        // save
        TraderDao traderDao = new TraderDao();
        traderDao.create(trader1);
        traderDao.create(trader2);

        // findAll
        List allTraders = traderDao.findAllWithNativeQuery();
        allTraders.forEach(trader -> System.out.println(trader));

        // findAll by trader code
        List<Trader> filteredTraders = traderDao.findAllByNameWithNamedNativeQuery(trader1.getName());
        System.out.println("--- filtered traders: " + filteredTraders);
    }
}
