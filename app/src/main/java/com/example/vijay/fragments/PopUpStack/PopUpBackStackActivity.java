package com.example.vijay.fragments.PopUpStack;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.vijay.fragments.R;

//video 8
public class PopUpBackStackActivity extends AppCompatActivity {
    private static final String TAG = "PopUpBackStackActivity ";
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    private TextView textViewFragmentCount;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop_up_back_stack);
        textViewFragmentCount = (TextView) findViewById(R.id.textViewFragmentCount);
        fragmentManager = getSupportFragmentManager();
        textViewFragmentCount.setText("Fragment count in back stack: " + fragmentManager.getBackStackEntryCount());
        fragmentManager.addOnBackStackChangedListener(new FragmentManager.OnBackStackChangedListener() {
            @Override
            public void onBackStackChanged() {
                textViewFragmentCount.setText("Fragment count in back stack: " + fragmentManager.getBackStackEntryCount());

                StringBuilder stringBuilder = new StringBuilder("Current status of transaction back stack: " + fragmentManager.getBackStackEntryCount() + "\n");
                for (int i = (fragmentManager.getBackStackEntryCount() - 1); i >= 0; i--) {
                    FragmentManager.BackStackEntry backStackEntry = fragmentManager.getBackStackEntryAt(i);
                    stringBuilder.append(backStackEntry.getName() + "\n");
                }

                Log.i(TAG, stringBuilder.toString());

            }
        });

        Log.i(TAG, "Initial BackStackEntryCount: " + fragmentManager.getBackStackEntryCount());
    }

    private void addFragment() {
        Fragment fragment;
        if (fragmentManager.getBackStackEntryCount() > 0) {
            switch (fragmentManager.getBackStackEntryCount()) {
                case 0:
                    loadFragmentOne();
                    break;
                case 1:
                    loadFragmentTwo();
                    break;
                case 2:
                    loadFragmentThree();
                    break;
                default:
                    loadFragmentOne();
                    break;
            }
        } else {
            fragment = fragmentManager.findFragmentById(R.id.fragmentContainer);
            if (fragment instanceof Fragment11) {
                loadFragmentTwo();
            } else if (fragment instanceof Fragment22) {
                loadFragmentThree();
            } else if (fragment instanceof Fragment33) {
                loadFragmentOne();
            } else {
                loadFragmentOne();
            }
        }

    }

    private void loadFragmentOne() {
        Fragment fragment;
        fragmentTransaction = fragmentManager.beginTransaction();
        fragment = fragmentManager.findFragmentByTag("demofragment");
        /*if(fragment!=null){
            fragmentTransaction.remove(fragment);
        }*/
        fragment = new Fragment11();
        fragmentTransaction.replace(R.id.fragmentContainer, fragment, "demofragment");
        fragmentTransaction.addToBackStack("Add " + fragment.toString());
        fragmentTransaction.commit();
    }

    private void loadFragmentTwo() {

        Fragment fragment;
        fragmentTransaction = fragmentManager.beginTransaction();
        fragment = fragmentManager.findFragmentByTag("demofragment");
        /*if(fragment!=null){
            fragmentTransaction.remove(fragment);
        }*/
        fragment = new Fragment22();
        fragmentTransaction.replace(R.id.fragmentContainer, fragment, "demofragment");
        fragmentTransaction.addToBackStack("Add " + fragment.toString());
        fragmentTransaction.commit();

    }

    private void loadFragmentThree() {
        Fragment fragment;
        fragmentTransaction = fragmentManager.beginTransaction();
        fragment = fragmentManager.findFragmentByTag("demofragment");
        /*if(fragment!=null){
            fragmentTransaction.remove(fragment);
        }*/
        fragment = new Fragment33();
        fragmentTransaction.replace(R.id.fragmentContainer, fragment, "demofragment");
        fragmentTransaction.addToBackStack("Add " + fragment.toString());
        fragmentTransaction.commit();
    }


    public void view_Click(View view) {
        switch (view.getId()) {
            case R.id.buttonAddFragmentOne:
                addFragment();
                break;
            case R.id.buttonPopFragment:
                fragmentManager.popBackStack("Add SampleFragment", FragmentManager.POP_BACK_STACK_INCLUSIVE);
                break;
            case R.id.buttonRemoveFragment:
                fragmentTransaction = fragmentManager.beginTransaction();
                Fragment fragment = fragmentManager.findFragmentById(R.id.fragmentContainer);
                if (fragment != null) {
                    fragmentTransaction.remove(fragment);
                    fragmentTransaction.addToBackStack("Remove " + fragment.toString());
                    fragmentTransaction.commit();
                } else {
                    Toast.makeText(this, "No Fragment to remove", Toast.LENGTH_SHORT).show();
                }
                break;
            default:
                break;
        }
    }
}
