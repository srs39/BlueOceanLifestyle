package com.bol.blueoceanlifestyle;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class BPFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_b, container,false);
    }

    public String getDate(){
        return "date";
    }

    public String getTime(){
        return "time";
    }

    public int getSystolic(){
        return 1;
    }

    public int getDiastolic(){
        return 1;
    }
}
