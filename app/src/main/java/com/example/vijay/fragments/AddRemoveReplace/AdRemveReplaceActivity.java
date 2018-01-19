package com.example.vijay.fragments.AddRemoveReplace;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.vijay.fragments.R;

//video 6
public class AdRemveReplaceActivity extends AppCompatActivity {
    private static final String TAG = AdRemveReplaceActivity.class.getSimpleName();
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    private TextView textViewFragmentCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ad_remve_replace);

        textViewFragmentCount = (TextView) findViewById(R.id.textViewFragmentCount);
        fragmentManager = getSupportFragmentManager();
        textViewFragmentCount.setText("Fragment count in back stack: " + fragmentManager.getBackStackEntryCount());
        fragmentManager.addOnBackStackChangedListener(new FragmentManager.OnBackStackChangedListener() {
            @Override
            public void onBackStackChanged() {
                textViewFragmentCount.setText("Fragment count in back stack: " + fragmentManager.getBackStackEntryCount());
            }
        });

        Log.i(TAG, "Initial BackStackEntryCount: " + fragmentManager.getBackStackEntryCount());
    }

    private void addFragment() {
        Fragment fragment;
        fragment = fragmentManager.findFragmentById(R.id.fragmentContainer);
        if (fragment instanceof BlankFragment1) {
            fragment = new BlankFragment2();
        } else if (fragment instanceof BlankFragment2) {
            fragment = new BlankFragment3();
        } else if (fragment instanceof BlankFragment3) {
            fragment = new BlankFragment1();
        } else {
            fragment = new BlankFragment1();
        }

        fragmentTransaction = fragmentManager.beginTransaction();
//
//        fragmentTransaction.add(R.id.fragmentContainer, fragment, "demofragment");
        //if you do not use multiple fragments then use replace method
        fragmentTransaction.replace(R.id.fragmentContainer, fragment, "demofragment");

        fragmentTransaction.commit();
    }

    @Override
    public void onBackPressed() {

        Fragment fragment = fragmentManager.findFragmentById(R.id.fragmentContainer);
        if (fragment != null) {
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.remove(fragment);
            fragmentTransaction.commit();
        } else {
            super.onBackPressed();
        }

    }

    public void view_Click(View view) {
        switch (view.getId()) {
            case R.id.buttonAddFragment:
                addFragment();
                break;
        }
    }
}
