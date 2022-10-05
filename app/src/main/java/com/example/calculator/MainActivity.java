package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //Different operation for numbers,signs,equal
    private EditText result;
    private EditText newNumber;
    private TextView displayOperation;
    //variables to hold the operations abouve
    private Double operation1 = null;
    private Double operation2 = null;
    private String  pendingOperation = "=";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        result = (EditText) findViewById(R.id.result);
        newNumber = (EditText) findViewById(R.id.newNumber);
        displayOperation = (TextView) findViewById(R.id.operation);

        Button button0 = (Button) findViewById(R.id.button0);
        Button button1 = (Button) findViewById(R.id.button1);
        Button button2 = (Button) findViewById(R.id.button2);
        Button button3 = (Button) findViewById(R.id.button3);
        Button button4 = (Button) findViewById(R.id.button4);
        Button button5 = (Button) findViewById(R.id.button5);
        Button button6 = (Button) findViewById(R.id.button6);
        Button button7 = (Button) findViewById(R.id.button7);
        Button button8 = (Button) findViewById(R.id.button8);
        Button button9 = (Button) findViewById(R.id.button9);
        Button buttonDott = (Button) findViewById(R.id.buttonDott);

        Button buttonEqual = (Button) findViewById(R.id.buttonEqual);
        Button buttonMultiply = (Button) findViewById(R.id.buttonMultiplication);
        Button buttonSubtraction = (Button) findViewById(R.id.buttonSubtraction);
        Button buttonDivide = (Button) findViewById(R.id.buttonDiviation);
        Button buttonPlus = (Button) findViewById(R.id.buttonPlus);
        Button buttonPercent = (Button) findViewById(R.id.buttonPercent);
        Button buttonPi = (Button) findViewById(R.id.buttonPi);
        Button buttonRoot = (Button) findViewById(R.id.buttonRoot);
        Button buttonPow = (Button) findViewById(R.id.button35);

        Button buttonErase = (Button) findViewById(R.id.eraseButton);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button b = (Button) view;
                newNumber.append(b.getText().toString());
            }
        };
        button0.setOnClickListener(listener);
        button1.setOnClickListener(listener);
        button2.setOnClickListener(listener);
        button3.setOnClickListener(listener);
        button4.setOnClickListener(listener);
        button5.setOnClickListener(listener);
        button6.setOnClickListener(listener);
        button7.setOnClickListener(listener);
        button8.setOnClickListener(listener);
        button9.setOnClickListener(listener);
        buttonDott.setOnClickListener(listener);




    }
   /* View.OnClickListener opListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Button b = (Button) view;
            String op = b.getText().toString();
            String value = newNumber.getText().toString();
            if (value.length() != 0){
                performOperation(value, op);
            }
            pendingOperation = op;
            displayOperation.setText(pendingOperation);

        }
    };*/
}

