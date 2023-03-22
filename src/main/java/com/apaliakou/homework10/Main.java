package com.apaliakou.homework10;

import java.math.BigDecimal;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {

        Card visa = new Card("PLATINUM", new BigDecimal(500));

        Atm addAtm1 = new AtmProducer(visa, "moneyProducer");
        Atm addAtm2 = new AtmProducer(visa, "moneyProducer");
        Atm addAtm3 = new AtmProducer(visa, "moneyProducer");
        Atm subtractAtm1 = new AtmConsumer(visa, "moneyConsumer");
        Atm subtractAtm2 = new AtmConsumer(visa, "moneyConsumer");
        Atm subtractAtm3 = new AtmConsumer(visa, "moneyConsumer");


        addAtm1.setCard(visa);
        addAtm2.setCard(visa);
        addAtm3.setCard(visa);

        subtractAtm1.setCard(visa);
        subtractAtm2.setCard(visa);
        subtractAtm3.setCard(visa);

        addAtm1.start();
        addAtm2.start();
        addAtm3.start();

        subtractAtm1.start();
        subtractAtm2.start();
        subtractAtm3.start();

//        ExecutorService executor = Executors.newFixedThreadPool(6);
//
//        for (int i = 0; i < 3; i++) {
//            executor.execute(new AtmProducer(visa, "moneyProducer"));
//        }
//
//        for (int i = 0; i < 3; i++) {
//            executor.execute(new AtmConsumer(visa, "moneyConsumer"));
//
//        }
    }
}
