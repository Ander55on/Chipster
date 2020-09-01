package com.dankout.chipstr;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.NumberPicker;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.ViewModelProvider;

import com.dankout.chipstr.ui.HoleFragment;
import com.dankout.chipstr.viewmodel.RoundViewModel;



public class SetupRoundDialogFragment extends DialogFragment {

    private final int maximumSlopeValue = 155;
    private final int minimumSlopeValue = 55;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        View v = LayoutInflater.from(getActivity()).inflate(R.layout.setup_round_dialog_fragment, null);

        final RoundViewModel mRoundViewModel = new ViewModelProvider(getActivity()).get(RoundViewModel.class);
        mRoundViewModel.init();

        final NumberPicker numberPickerSlope = v.findViewById(R.id.numberPickerSlope);
        final NumberPicker numberPickerHoles = v.findViewById(R.id.numberPickerHoles);
        final String[] displayedHoleValues = {"9", "18"};

        numberPickerSlope.setMinValue(minimumSlopeValue);
        numberPickerSlope.setMaxValue(maximumSlopeValue);

        numberPickerHoles.setMinValue(0);
        numberPickerHoles.setMaxValue(1);

        numberPickerHoles.setDisplayedValues(displayedHoleValues);

        return new AlertDialog.Builder(getActivity())
                .setView(v)
                .setTitle("Setup Round")
                .setPositiveButton("OK", new OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                int holes = 9;

                if(numberPickerHoles.getValue() == 1) {
                    holes = 18;
                }

                mRoundViewModel.addNewRound(numberPickerSlope.getValue(), holes);
                HoleFragment fragment = new HoleFragment();
                getActivity().getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, fragment).commit();
            }
        })
                .setNegativeButton("Cancel", new OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        getActivity().finish();
                    }
                }).create();
    }
}
