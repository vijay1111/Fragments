package com.example.vijay.fragments.Backstack;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.vijay.fragments.R;

//video 5
public class BackStackActivity extends AppCompatActivity {
    private static final String TAG = BackStackActivity.class.getSimpleName();
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    TextView textViewFragmentCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_back_stack);
        textViewFragmentCount = (TextView) findViewById(R.id.textViewFragmentCount);
        fragmentManager = getSupportFragmentManager();
        textViewFragmentCount.setText("Fragment count in back stack: " + fragmentManager.getBackStackEntryCount());

        //there is any changes in backstack the this will be invoked
        fragmentManager.addOnBackStackChangedListener(new FragmentManager.OnBackStackChangedListener() {
            @Override
            public void onBackStackChanged() {
                textViewFragmentCount.setText("Fragment count in back stack: " + fragmentManager.getBackStackEntryCount());
            }
        });

        Log.e(TAG, "number of fragments count: " + fragmentManager.getBackStackEntryCount());
    }

    private void addFragment() {
        Fragment fragment;
        switch (fragmentManager.getBackStackEntryCount()) {
            case 0:
                fragment = new BackstackFragment();
                break;
            case 1:
                fragment = new FragmentTwo();
                break;
            case 2:
                fragment = new FragmentThree();
                break;
            default:
                fragment = new BackstackFragment();
                break;
        }
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fragmentContainer, fragment, "demofragment");
        //if you are not using addToBackStack ,activity and fragment both can be removed
        //if we kept addToBackStack first fragment will removed and then the activity will removed
        //if you comment the addToBackStack the fragment will not added to the top of the fragment . because simple add method will not work
        //you have to use remove or replace method in the fragmentTransaction
        fragmentTransaction.addToBackStack(null);

        fragmentTransaction.commit();
    }

    public void view_Click(View view) {
        switch (view.getId()) {
            case R.id.buttonAddFragment:
                addFragment();
                break;
        }
    }
}
