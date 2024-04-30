package com.jainsoham.lab07;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.add(R.id.fragment_container, FragmentB.newInstance(4,"You didn't click the text yet :("),"FragmentName");
        ft.commit();
    }

    public void update_greeting(View view) {
        FragmentB fragmentB = (FragmentB)getSupportFragmentManager().findFragmentByTag("FragmentName");
        if (fragmentB != null) {
            ((TextView)fragmentB.view.findViewById(R.id.b_textview)).setText(R.string.greeting);
        }
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.setCustomAnimations(R.animator.slide_up,R.animator.slide_down);
        ft.replace(R.id.fragment_container, FragmentB.newInstance(3,"You clicked it :)"),"BetterFragment");
        ft.commit();
    }

    public void fragment_button_onclick(View view) {
        ((Button)view).setText(R.string.clicked_message);
    }
}