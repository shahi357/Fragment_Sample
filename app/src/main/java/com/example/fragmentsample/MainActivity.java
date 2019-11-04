package com.example.fragmentsample;

import Fragments.Fragment_first;
import Fragments.Fragment_second;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button btn_fragment;
    private Boolean status = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_fragment = findViewById(R.id.btn_fragment);
        btn_fragment.setOnClickListener(this);
    }

    public void onClick(View v){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        if(status){
            Fragment_first frag1 = new Fragment_first();
            fragmentTransaction.add(R.id.fragment_container,frag1);
            fragmentTransaction.commit();
            btn_fragment.setText("Load second fragment");
            status = false;

        }else {
            Fragment_second frag2 = new Fragment_second();
            fragmentTransaction.add(R.id.fragment_container,frag2);
            fragmentTransaction.commit();
            btn_fragment.setText("Load first fragment");
            status = true;

        }
    }
}
