package com.example.vijay.fragments.PopUpStack;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.vijay.fragments.R;

/**
 * Created by vijay on 1/18/18.
 */

public class Fragment22 extends Fragment {
    private static final String COMMON_TAG = "Fragment22";
    private static final String FRAGMENT_NAME = Fragment22.class.getSimpleName();

    private static final String TAG = COMMON_TAG;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment22, container, false);
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}
