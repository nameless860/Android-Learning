package com.example.wtf.sumupapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText firstNumber;
    EditText secondNumber;
    TextView resultTextView;
    Button resultButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstNumber = (EditText) findViewById(R.id.firstNumber);
        secondNumber = (EditText) findViewById(R.id.secondNumber);
        resultTextView = (TextView) findViewById(R.id.resultTextView);
        
/*        resultButton = (Button)findViewById(R.id.resultButton);
        resultButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int num1 = Integer.parseInt(firstNumber.getText().toString());
                int num2 = Integer.parseInt(secondNumber.getText().toString());
                int result = num1 + num2;

                resultTextView.setText(result + "");

                Toast.makeText(MainActivity.this, firstNumber.getText(), Toast.LENGTH_SHORT).show();
            }
        });*/
    }

    public void onClickButton(View v) {
        int num1 = Integer.parseInt(firstNumber.getText().toString());
        int num2 = Integer.parseInt(secondNumber.getText().toString());
        int result = num1 + num2;

        resultTextView.setText(result + "");

        Toast.makeText(MainActivity.this, "The result is: " + result, Toast.LENGTH_SHORT).show();
    }
}
