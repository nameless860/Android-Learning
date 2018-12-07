package com.example.wtf.launchactivitywithinandoutsidetheapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class TheSecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_the_second);

        if(getIntent().hasExtra("message")){
            TextView contentTV = (TextView) findViewById(R.id.contentTV);
            String message = getIntent().getExtras().getString("message");
            contentTV.setText(message);
        }
    }
}
