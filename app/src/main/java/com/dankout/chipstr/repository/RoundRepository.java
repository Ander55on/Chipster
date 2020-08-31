package com.dankout.chipstr.repository;

import com.dankout.chipstr.model.Hole;
import com.dankout.chipstr.model.Round;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RoundRepository {

    private static RoundRepository instance;
    private ArrayList<Round> mRounds = new ArrayList<>();
    private HashMap<String, Round> mRoundHashMap= new HashMap<>();

    public static RoundRepository getInstance() {
        if(instance == null) {
            instance = new RoundRepository();
        }
        return instance;
    }

    public List<Round> getRounds() {
        return mRounds;
    }

    public Hole[] getHoles(String ID) {
        //TODO handle nullPointerException with wrong ID argument
        return mRoundHashMap.get(ID).getHoles();
    }

    public void addNewRound(Date date, int slope, int numberOfHoles) {
        Round round = new Round(date, slope, numberOfHoles);
        mRounds.add(round);
        mRoundHashMap.put(round.getID(),round);
    }

}
