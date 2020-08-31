package com.dankout.chipstr.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.dankout.chipstr.model.Hole;
import com.dankout.chipstr.model.Round;

import java.util.List;

public class RoundViewModel extends ViewModel {

    MutableLiveData<Round> mRound;
    MutableLiveData<List<Hole>> mHoles;

    public void addNewRound() {

    }
}
