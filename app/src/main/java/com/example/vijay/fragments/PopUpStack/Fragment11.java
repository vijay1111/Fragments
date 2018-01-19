package com.example.vijay.fragments.PopUpStack;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.vijay.fragments.R;

/**
 * Created by vijay on 1/18/18.
 */

public class Fragment11 extends Fragment {

    private static final String COMMON_TAG = "Fragment11";
    private static final String FRAGMENT_NAME = Fragment11.class.getSimpleName();

    private static final String TAG = COMMON_TAG;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        Log.i(TAG, FRAGMENT_NAME +" onCreateView");
        return inflater.inflate(R.layout.fragment11,container,false);
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}
