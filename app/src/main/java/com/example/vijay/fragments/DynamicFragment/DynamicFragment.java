package com.example.vijay.fragments.DynamicFragment;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.example.vijay.fragments.R;
public class DynamicFragment extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic_fragment);
        addFragment();
    }
    public void addFragment(){
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        DynamicFragments_Fragment dynamicFragments_fragment=new DynamicFragments_Fragment();
        fragmentTransaction.add(R.id.fragment_Container,dynamicFragments_fragment);
        fragmentTransaction.commit();
    }
}
