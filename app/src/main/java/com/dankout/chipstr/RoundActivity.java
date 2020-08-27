package com.dankout.chipstr;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;

import com.dankout.chipstr.ui.HoleFragment;

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

            HoleFragment fragment = new HoleFragment();
            getSupportFragmentManager().beginTransaction().add(R.id.fragment_container, fragment).commit();

        }
    }
}
