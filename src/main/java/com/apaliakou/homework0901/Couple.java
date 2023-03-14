package com.apaliakou.homework0901;

public class Couple implements Comparable<Couple> {

    public Integer number;
    public Integer figuresSum;

    public Couple() {
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public void setFiguresSum(Integer figuresSum) {
        this.figuresSum = figuresSum;
    }

    public Integer getNumber() {
        return number;
    }

    public Integer getFiguresSum() {
        return figuresSum;
    }

    public int compareTo(Couple couple1) {
        return figuresSum.compareTo(couple1.figuresSum);
    }

    @Override
    public String toString() {
        return "Couple{" +
                "number=" + number +
                ", figuresSum=" + figuresSum +
                '}';
    }
}
