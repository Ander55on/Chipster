package com.dankout.chipstr.model;

import java.sql.Date;

public class Round {

    private Date mDatePlayed;

    //slope rating of the golf course
    private int mSlope;
    private int[] mHoles;

    public Round(Date date, int slope, int numberOfHoles) {
        mDatePlayed = date;
        mSlope = slope;
        mHoles = new int[numberOfHoles];
    }

    public Date getDatePlayed() {
        return mDatePlayed;
    }

    public int getSlope() {
        return mSlope;
    }

    public int[] getHoles() {
        return mHoles;
    }
}
