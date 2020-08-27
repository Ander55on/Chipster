package com.dankout.chipstr.model;

public class Hole {

    private int mPar;
    private int mAmount_of_putts;
    private int mScore;
    private int mIndex;

    public Hole(int par, int index) {
        this.mPar = par;
        this.mIndex = index;
    }

    public int getAmount_of_putts() {
        return mAmount_of_putts;
    }

    public int getPar() {
        return mPar;
    }

    public int getIndex() {
        return mIndex;
    }

    public void setIndex(int index) {
        mIndex = index;
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
