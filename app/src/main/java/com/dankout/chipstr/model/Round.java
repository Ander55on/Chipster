package com.dankout.chipstr.model;

import java.sql.Date;
import java.util.UUID;

public class Round {

    private Date mDatePlayed;

    //slope rating of the golf course
    private int mSlope;
    private Hole[] mHoles;
    private String mID;
    private boolean mFinished;

    public Round(Date date, int slope, int numberOfHoles) {
        mID = UUID.randomUUID().toString();
        mDatePlayed = date;
        mSlope = slope;
        mHoles = new Hole[numberOfHoles];

        mFinished = false;
    }

    public void setFinished(boolean finished) {
        mFinished = true;
    }

    public boolean isFinished() {
        return mFinished;
    }

    public String getID() {
        return mID;
    }

    public Date getDatePlayed() {
        return mDatePlayed;
    }

    public int getSlope() {
        return mSlope;
    }

    public Hole[] getHoles() {
        return mHoles;
    }
}
