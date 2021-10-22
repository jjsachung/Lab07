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
        //ft.hide(getSupportFragmentManager().findFragmentByTag("Hello"));
        //complete the changes added above
        ft.commit();

    }

    public void update(View view) {
        FragmentB fragmentB = (FragmentB)getSupportFragmentManager().findFragmentByTag("FragmentB");
        FragmentB greeting = (FragmentB)getSupportFragmentManager().findFragmentByTag("Hello");
        ((TextView)fragmentB.view.findViewById(R.id.b_textview)).setText(R.string.rockstar);
        FragmentTransaction test = getSupportFragmentManager().beginTransaction();
        if(fragmentB.isAdded())
            test.show(fragmentB);
        if(greeting.isAdded()) {
            test.hide(fragmentB);
        }
        if(fragmentB.isHidden()) {
            test.remove(greeting);
//            test.show(fragmentB);
        }
        test.commit();
    }
}