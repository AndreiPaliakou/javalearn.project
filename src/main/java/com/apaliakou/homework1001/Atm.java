package com.apaliakou.homework1001;

import com.apaliakou.homework1001.Exceptions.AddSumRangeException;

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

    public abstract Atm operation (BigDecimal sum);

    public static BigDecimal generateRandomSum(int minAddSum, int maxAddSum) {
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
        synchronized (card) {
            while (!isStopped) {
                try {
                    System.out.println(Thread.currentThread().getName());
                    operation(generateRandomSum(25, 50));
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                    e.printStackTrace();
                    isStopped = true;
                }
            }
        }
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
