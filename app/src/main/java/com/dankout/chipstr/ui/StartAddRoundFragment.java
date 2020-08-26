package com.dankout.chipstr.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.dankout.chipstr.R;
import com.dankout.chipstr.RoundActivity;

public class StartAddRoundFragment extends Fragment {
    public static final String EXTRA_MESSAGE_FRAGMENT_TO_CREATE = "com.dankout.chipster.button_pressed";

    /*Used as extra messages so RoundActivity knows what kind of
    fragment to create*/
    public static final int ADD = 1;
    public static final int SHOW = 2;
    public static final  int START = 3;

    private Button mStartNewRoundButton;
    private Button mAddRoundButton;
    private Button mViewRoundsButton;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.start_add_round_fragment, container, false);

        mStartNewRoundButton = v.findViewById(R.id.start_round_button);
        mAddRoundButton = v.findViewById(R.id.add_round_button);
        mViewRoundsButton = v.findViewById(R.id.show_rounds_button);

        mStartNewRoundButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                startRoundActivity(mStartNewRoundButton);
            }
        });
        return v;
    }

    private void startRoundActivity(Button button) {
        int extraMessage = 0;

       if(button.equals(mStartNewRoundButton)) {
           extraMessage = START;
       } else if(button.equals(mAddRoundButton)) {
           extraMessage = ADD;
       } else if(button.equals(mViewRoundsButton)) {
           extraMessage = SHOW;
       }

       Intent intent = new Intent(getActivity(), RoundActivity.class);
       intent.putExtra(EXTRA_MESSAGE_FRAGMENT_TO_CREATE, extraMessage);
       startActivity(intent);
    }
}
