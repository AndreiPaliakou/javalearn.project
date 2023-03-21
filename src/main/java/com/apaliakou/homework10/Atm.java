package com.apaliakou.homework10;

import com.apaliakou.homework10.Exceptions.AddSumRangeException;

import java.math.BigDecimal;

public abstract class Atm implements Runnable {

    private Card card;

    public static boolean isStopped = false;

    public Atm(Card card) {
        this.card = card;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public abstract Atm operation(BigDecimal sum) throws InterruptedException;

    public BigDecimal generateRandomSum(int minAddSum, int maxAddSum) {
        if (minAddSum >= 25 && maxAddSum <= 50) {
            int randomResult = (int) ((Math.random() * (maxAddSum - minAddSum)) + minAddSum);
            System.out.println("Current random number - " + randomResult);
            return new BigDecimal(randomResult);
        }
        String ADD_SUM_RANGE_EXCEPTION = "Add sum must be from 25 to 50 int type value range!";
        throw new AddSumRangeException(ADD_SUM_RANGE_EXCEPTION);
    }

    @Override
    public void run() {
        while (!isStopped) {
            synchronized (card) {
                if (!isStopped) {
                    try {
                        System.out.println(Thread.currentThread().getName());
                        operation(generateRandomSum(25, 50));
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        System.out.println(e.getMessage());
                        e.printStackTrace();
                        isStopped = true;
                    }
                } else {
                    Thread.currentThread().interrupt();
                    if(Thread.currentThread().isInterrupted()) {
                        System.out.println("THE NEXT THREAD WAS STOPPED!!!");
                    }
                }
            }
        }
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
