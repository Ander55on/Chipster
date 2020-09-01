package com.dankout.chipstr.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.dankout.chipstr.model.Hole;
import com.dankout.chipstr.model.Round;
import com.dankout.chipstr.repository.RoundRepository;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

public class RoundViewModel extends ViewModel {

    List<Round> mRounds;
    MutableLiveData<List<Hole>> mHoles;
    private RoundRepository mRoundRepository;

    public void init() {
        if(mRounds != null) {
            return;
        }
        mRoundRepository = RoundRepository.getInstance();
        mRounds = mRoundRepository.getRounds();
    }

    public void addNewRound(int slope, int numberOfHoles) {
        Calendar cal = Calendar.getInstance();
        Date date = new Date(cal.getTimeInMillis());

        mRoundRepository.addNewRound(date, slope, numberOfHoles);
    }
}
