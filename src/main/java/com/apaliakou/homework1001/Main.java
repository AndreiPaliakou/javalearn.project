package com.apaliakou.homework1001;

import java.math.BigDecimal;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {

        Card visa = new Card("PLATINUM", new BigDecimal(500));

        AtmProducer atmProducer = new AtmProducer(visa, "moneyProducer");
        AtmConsumer atmConsumer = new AtmConsumer(visa, "moneyConsumer");

        atmProducer.getAtmAddInfo();
        atmConsumer.getAtmSubtractInfo();

        ExecutorService executor = Executors.newFixedThreadPool(6);

        for (int i = 0; i < 3; i++) {
            executor.execute(new AtmProducer(visa, "moneyProducer"));
        }

        for (int i = 0; i < 3; i++) {
            executor.execute(new AtmConsumer(visa, "moneyConsumer"));
        }
    }
}
