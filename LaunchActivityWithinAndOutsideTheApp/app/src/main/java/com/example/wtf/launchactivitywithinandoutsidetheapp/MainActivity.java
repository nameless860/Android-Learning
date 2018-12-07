package com.example.wtf.launchactivitywithinandoutsidetheapp;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Start an Activity within the current App
        Button startActivityBtn = (Button) findViewById(R.id.startActivityBtn);
        startActivityBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText messageText = (EditText) findViewById(R.id.messageText);
                String message = messageText.getText().toString();
                Intent startActityIntent = new Intent(getApplicationContext(),TheSecondActivity.class);
                if(message != "") {
                    startActityIntent.putExtra("message", message);
                }
                else {
                    startActityIntent.putExtra("message", "Nothing");
                }
                startActivity(startActityIntent);
            }
        });

        // Start an Activity outside of the currnt App
        Button startWebActivityBtn = (Button) findViewById(R.id.startWebActivityBtn);
        startWebActivityBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String webAddress = "https://www.google.com.vn/";
                Uri url = Uri.parse(webAddress);
                Intent webIntent = new Intent(Intent.ACTION_VIEW,url);
                if(webIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(webIntent);
                }
            }
        });
    }
}