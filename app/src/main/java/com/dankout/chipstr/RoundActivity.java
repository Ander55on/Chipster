package com.dankout.chipstr;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.dankout.chipstr.ui.HoleFragment;
import com.dankout.chipstr.viewmodel.RoundViewModel;

public class RoundActivity extends FragmentActivity {

    private RoundViewModel mRoundViewModel;
    private ViewPager2 mPager;
    private FragmentStateAdapter mPagerAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.round_activity);

        mRoundViewModel = new ViewModelProvider(this).get(RoundViewModel.class);
        mRoundViewModel.init();

        if(findViewById(R.id.fragment_container) != null) {
           //To prevent multiple fragments overlapping
            if(savedInstanceState != null) {
                return;
            }

            mPager = findViewById(R.id.fragment_container);
            mPagerAdapter = new HolePagerAdapter(this);
            mPager.setAdapter(mPagerAdapter);

        }

    }

    private class HolePagerAdapter extends FragmentStateAdapter {

        public HolePagerAdapter(@NonNull FragmentActivity fragmentActivity) {
            super(fragmentActivity);
        }

        @NonNull
        @Override
        public Fragment createFragment(int position) {
            return new HoleFragment();
        }

        @Override
        public int getItemCount() {
            return mRoundViewModel.getLastRound().getHoles().length;
        }
    }
}
