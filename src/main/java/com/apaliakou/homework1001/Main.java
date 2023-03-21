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

        Thread addAtm1 = new Thread(new AtmProducer(visa, "moneyProducer"));
        Thread addAtm2 = new Thread(new AtmProducer(visa, "moneyProducer"));
        Thread addAtm3 = new Thread(new AtmProducer(visa, "moneyProducer"));
        Thread subtractAtm1 = new Thread(new AtmConsumer(visa, "moneyConsumer"));
        Thread subtractAtm2 = new Thread(new AtmConsumer(visa, "moneyConsumer"));
        Thread subtractAtm3 = new Thread(new AtmConsumer(visa, "moneyConsumer"));

        System.out.println(addAtm1.getName());
        System.out.println(addAtm2.getName());
        System.out.println(addAtm3.getName());
        System.out.println(subtractAtm1.getName());
        System.out.println(subtractAtm2.getName());
        System.out.println(subtractAtm3.getName());

        System.out.println("Priority - " + addAtm1.getPriority());
        System.out.println("Priority - " + addAtm2.getPriority());
        System.out.println("Priority - " + addAtm3.getPriority());
        System.out.println("Priority - " + subtractAtm1.getPriority());
        System.out.println("Priority - " + subtractAtm2.getPriority());
        System.out.println("Priority - " + subtractAtm3.getPriority());

        addAtm1.start();
        addAtm2.start();
        addAtm3.start();
        subtractAtm1.start();
        subtractAtm2.start();
        subtractAtm3.start();

//        ExecutorService executor = Executors.newFixedThreadPool(6);
//
//       for (int i = 0; i < 3; i++) {
//            executor.execute(new AtmProducer(visa, "moneyProducer"));
//        }
//
//        for (int i = 0; i < 3; i++) {
//            executor.execute(new AtmConsumer(visa, "moneyConsumer"));
//        }
    }
}
