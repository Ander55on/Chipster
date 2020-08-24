package com.dankout.chipstr;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import com.dankout.chipstr.ui.UserFragment;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayout.Tab;
import com.google.android.material.tabs.TabLayoutMediator;
import com.google.android.material.tabs.TabLayoutMediator.TabConfigurationStrategy;

public class MainActivity extends FragmentActivity {

    private static final int NUMBER_OF_PAGES = 3;
    private ViewPager2 mPager;
    private FragmentStateAdapter mPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabLayout tabLayout = findViewById(R.id.tab_layout);
        mPager = findViewById(R.id.view_pager);
        mPagerAdapter = new MainScreenPagerAdapter(this);
        mPager.setAdapter(mPagerAdapter);

        new TabLayoutMediator(tabLayout, mPager, true, new TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull Tab tab, int position) {
                tab.setText("Page " + position);
            }
        }).attach();
    }

    private class MainScreenPagerAdapter extends FragmentStateAdapter {
        public MainScreenPagerAdapter(FragmentActivity fragmentActivity) {
            super(fragmentActivity);
        }

        @NonNull
        @Override
        public Fragment createFragment(int position) {
            return new UserFragment();
        }

        @Override
        public int getItemCount() {
            return NUMBER_OF_PAGES;
        }
    }


}
