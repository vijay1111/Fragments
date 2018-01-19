package com.example.vijay.fragments.DissectingBackStack;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.vijay.fragments.Backstack.FragmentTwo;
import com.example.vijay.fragments.R;
//video 7
public class DissectingBackStackActivity extends AppCompatActivity {
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    TextView textViewFragmentCount;
    static String TAG = "DissectingBackStackActivity.class ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dissecting_back_stack);
        textViewFragmentCount = findViewById(R.id.textview);
        fragmentManager = getSupportFragmentManager();
        textViewFragmentCount.setText("Fragment count in back stack: " + fragmentManager.getBackStackEntryCount());
        fragmentManager.addOnBackStackChangedListener(new FragmentManager.OnBackStackChangedListener() {
            @Override
            public void onBackStackChanged() {
                textViewFragmentCount.setText("Fragment count in back stack: " + fragmentManager.getBackStackEntryCount());
                StringBuilder backstackEntryMessage = new StringBuilder("Current status of fragment transaction back stack: " + fragmentManager.getBackStackEntryCount() + "\n");

                for (int index = (fragmentManager.getBackStackEntryCount() - 1); index >= 0; index--) {
                    FragmentManager.BackStackEntry entry = fragmentManager.getBackStackEntryAt(index);
                    backstackEntryMessage.append(entry.getName() + "\n");
                }
                Log.i(TAG, backstackEntryMessage.toString());
            }
        });

    }

    public void view_Click(View view) {
        switch (view.getId()) {
            case R.id.add:
                add();
                break;
        }
    }

    private void add() {
        Fragment fragment;
        fragment = fragmentManager.findFragmentById(R.id.fragmentContainer);
        if (fragment instanceof Fragment1) {
            fragment = new FragmentTwo();
        } else if (fragment instanceof Fragment2) {
            fragment = new Fragment3();
        } else if (fragment instanceof Fragment3) {
            fragment = new Fragment1();
        } else {
            fragment = new Fragment1();
        }

        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.container, fragment, "demofragment");
        fragmentTransaction.addToBackStack("Replace " + fragment.toString());
        fragmentTransaction.commit();

    }


    @Override
    public void onBackPressed() {
        fragmentTransaction = fragmentManager.beginTransaction();
        Fragment fragment = fragmentManager.findFragmentById(R.id.container);
        if (fragment != null) {
            fragmentTransaction.remove(fragment);
            fragmentTransaction.addToBackStack("Remove " + fragment.toString());
            fragmentTransaction.commit();
        } else {
            super.onBackPressed();
        }

    }
}
