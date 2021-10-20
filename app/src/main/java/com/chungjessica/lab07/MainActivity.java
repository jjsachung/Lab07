package com.chungjessica.lab07;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //begin transaction
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        //add contents to container
        ft.add(R.id.fragment, FragmentB.newInstance(99, "RulerOfTheWorld"), "FragmentB");
        //complete the changes added above
        ft.commit();
    }

    public void update(View view) {
        FragmentB fragmentB = (FragmentB)getSupportFragmentManager().findFragmentByTag("FragmentB");
        ((TextView)fragmentB.view.findViewById(R.id.b_textview)).setText(R.string.rockstar);

    }
}