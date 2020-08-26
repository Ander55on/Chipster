package com.dankout.chipstr.model;

import java.util.List;

public class User {

    private int mHcpIntegerPart;
    private int mHcpFractionPart;
    private List<Round> mRounds;

    public int getHcpIntegerPart() {
        return mHcpIntegerPart;
    }

    public int getHcpFractionPart() {
        return mHcpFractionPart;
    }

    public List<Round> getRounds() {
        return mRounds;
    }



}
