package com.example.aptivist_u002.communicatefragments;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.Date;


/**
 * A simple {@link Fragment} subclass.
 */
public class BlueFragment extends Fragment {

    private Button button;
    private OnCallbackClicked onCallbackClicked;
    public BlueFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_blue, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        button = (Button) view.findViewById(R.id.f_blue_btn1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onCallbackClicked.onCLick(new Date().toString());
            }
        });
    }

    //First step
    public interface OnCallbackClicked{
        void onCLick(String message);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        onCallbackClicked = (OnCallbackClicked) context;

    }
}
