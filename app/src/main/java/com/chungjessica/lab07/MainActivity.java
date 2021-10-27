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
        ft.add(R.id.fragment, FragmentB.newInstance(101, "to be replaced"), "Replace");
        ft.replace(R.id.fragment, FragmentB.newInstance(99, "RulerOfTheWorld"), "FragmentB");
        ft.add(R.id.fragment, FragmentB.newInstance(100, "Hello"), "Hello");
        ft.add(R.id.fragment, FragmentB.newInstance(102, "to be removed"), "Remove");
        //complete the changes added above
        ft.commit();

    }

    public void update(View view) {
        FragmentB fragmentB = (FragmentB)getSupportFragmentManager().findFragmentByTag("FragmentB");
        FragmentB greeting = (FragmentB)getSupportFragmentManager().findFragmentByTag("Hello");
        FragmentB toRemove = (FragmentB)getSupportFragmentManager().findFragmentByTag("Remove");
        ((TextView)fragmentB.view.findViewById(R.id.b_textview)).setText(R.string.rockstar);
        FragmentTransaction test = getSupportFragmentManager().beginTransaction();
        test.setCustomAnimations(R.anim.slide_in, R.anim.slide_out);
        if(toRemove != null)
            test.remove(toRemove);
        if(fragmentB.isAdded())
            test.hide(greeting);
            test.show(fragmentB);
        if(greeting.isHidden()) {
            test.hide(fragmentB);
            test.show(greeting);
        }
        if(fragmentB.isHidden()) {
            test.hide(greeting);
            test.show(fragmentB);
//            test.show(fragmentB);
        }
        test.commit();
    }
}