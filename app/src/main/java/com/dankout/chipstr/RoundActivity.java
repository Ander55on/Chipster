package com.dankout.chipstr;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;

public class RoundActivity extends FragmentActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.round_activity);

        if(findViewById(R.id.fragment_container) != null) {
           //To prevent multiple fragments overlapping
            if(savedInstanceState != null) {
                return;
            }

            FragmentManager fm = getSupportFragmentManager();
            SetupRoundDialogFragment dialog = new SetupRoundDialogFragment();
            dialog.show(fm, null);

        }
    }
}
