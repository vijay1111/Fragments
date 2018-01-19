package com.example.vijay.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.vijay.fragments.AddRemoveReplace.AdRemveReplaceActivity;
import com.example.vijay.fragments.Backstack.BackStackActivity;
import com.example.vijay.fragments.DissectingBackStack.DissectingBackStackActivity;
import com.example.vijay.fragments.DynamicFragment.DynamicFragment;
import com.example.vijay.fragments.LifeCycleFragments.LifeCycleFragmentsActivity;
import com.example.vijay.fragments.PopUpStack.PopUpBackStackActivity;
import com.example.vijay.fragments.StaticFragment.StaticFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void view_Click(View view) {
        Class clazz = null;
        switch (view.getId()) {
            case R.id.lifecycle:
                clazz = StaticFragment.class;
                break;
            case R.id.dynamic_fragment:
                clazz = DynamicFragment.class;
                break;
            case R.id.fragment_lifecycle:
                clazz = LifeCycleFragmentsActivity.class;
                break;
            case R.id.backstack:
                clazz = BackStackActivity.class;
                break;
            case R.id.addremovereplace:
                clazz = AdRemveReplaceActivity.class;
                break;
            case R.id.dissectingbackstack:
                clazz = DissectingBackStackActivity.class;
                break;
            case R.id.popupbackstack:
                clazz= PopUpBackStackActivity.class;
                break;
        }
        startActivity(new Intent(getApplicationContext(), clazz));
    }
}
