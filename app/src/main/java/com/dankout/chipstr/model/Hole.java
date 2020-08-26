package com.dankout.chipstr.model;

public class Hole {

    private int mPar;
    private int mAmount_of_putts;
    private int mScore;

    public Hole(int par) {
        this.mPar = par;
    }

    public int getAmount_of_putts() {
        return mAmount_of_putts;
    }

    public int getScore() {
        return mScore;
    }

    public void setScore(int score) {
        mScore = score;
    }

    public void setAmount_of_putts(int amount_of_putts) {
        mAmount_of_putts = amount_of_putts;
    }

    public void setPar(int par) {
        mPar = par;
    }
}
