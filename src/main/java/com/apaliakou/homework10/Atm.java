package com.apaliakou.homework10;

import com.apaliakou.homework10.Exceptions.AddSumRangeException;

import java.math.BigDecimal;
import java.util.Random;

public abstract class Atm extends Thread {

    Card card;

    public Atm(Card card) {
        this.card = card;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public abstract void operation(Card card, BigDecimal operationSum);

    public BigDecimal generateRandomSum(int minAddSum, int maxAddSum) {
        if (minAddSum >= 25 && maxAddSum <= 50) {
            int randomResult = (int) ((Math.random() * (maxAddSum - minAddSum)) + minAddSum);
            return new BigDecimal(randomResult);
        }
        String ADD_SUM_RANGE_EXCEPTION = "Add sum must be from 25 to 50 int type value range!";
        throw new AddSumRangeException(ADD_SUM_RANGE_EXCEPTION);
    }

    @Override
    public void run() {
        while (Card.flag.get()) {
            operation(card, generateRandomSum(25, 50));
            try {
                sleep(new Random().nextInt(1000) + 500L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
