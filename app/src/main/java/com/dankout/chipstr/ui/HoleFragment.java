package com.dankout.chipstr.ui;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.dankout.chipstr.R;

import java.util.ArrayList;
import java.util.List;

public class HoleFragment extends Fragment {


    private List<CardView> mParCards;
    private List<CardView> mStrokeCards;
    private List<CardView> mPuttCards;

    private LinearLayout mStrokesCardRow;
    private LinearLayout mParCardRow;
    private LinearLayout mPuttsCardRow;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.hole_fragment, container, false);

        final CardView mCardViewPar3 = v.findViewById(R.id.cardView_par_value_3);
        final CardView mCardViewPar4 = v.findViewById(R.id.cardView_par_value_4);
        final CardView mCardViewPar5 = v.findViewById(R.id.cardView_par_value_5);
        final CardView mCardViewPar6 = v.findViewById(R.id.cardView_par_value_6);

        mParCardRow = v.findViewById(R.id.par_linear_layout);
        mStrokesCardRow = v.findViewById(R.id.strokes_linearLayout);
        mPuttsCardRow = v.findViewById(R.id.putts_linearLayout);

        mParCards = new ArrayList<>();
        mStrokeCards = new ArrayList<>();
        mPuttCards = new ArrayList<>();

        if (mParCards.isEmpty() && mStrokeCards.isEmpty() && mPuttCards.isEmpty()) {
            populateCardLists();
        }

        //regionONCLICKLISTENERS
        mCardViewPar3.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                toggleCard(mCardViewPar3);
            }
        });
        mCardViewPar4.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                toggleCard(mCardViewPar4);
            }
        });
        mCardViewPar5.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                toggleCard(mCardViewPar5);
            }
        });
        mCardViewPar6.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                toggleCard(mCardViewPar6);
            }
        });
        //endregion
        return v;
    }

    private void toggleCard(CardView card) {
        if (card.isSelected()) {
            return;
        }

        if (card.getParent().equals(mParCardRow)) {
            unSelectCardInRow(mParCards);
        } else if (card.getParent().equals(mStrokesCardRow)) {
            unSelectCardInRow(mStrokeCards);
        }

        card.setSelected(true);
        card.setCardBackgroundColor(getResources().getColor(R.color.toggledCardView));
    }

    private void unSelectCardInRow(List<CardView> row) {
        for (CardView c : row) {
            if (c.isSelected()) {
                c.setSelected(false);
                c.setCardBackgroundColor(Color.WHITE);
            }
        }
    }

    private void populateCardLists() {

        for (int i = 0; i < mParCardRow.getChildCount(); i++) {
            if (mParCardRow.getChildAt(i) instanceof CardView) {
                mParCards.add((CardView) mParCardRow.getChildAt(i));
            }
        }

        for (int i = 0; i < mStrokesCardRow.getChildCount(); i++) {
            if (mStrokesCardRow.getChildAt(i) instanceof CardView) {
                mStrokeCards.add((CardView) mStrokesCardRow.getChildAt(i));
            }
        }

        for (int i = 0; i < mPuttsCardRow.getChildCount(); i++) {
            if (mPuttsCardRow.getChildAt(i) instanceof CardView) {
                mPuttCards.add((CardView) mPuttsCardRow.getChildAt(i));
            }
        }
    }
}
