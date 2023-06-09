//Martin N, Daniel D, Mikael S
package com.example.calculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //References to store and show input from user and result at the top widget
    private EditText result;
    private EditText newNumber;
    private TextView displayOperation;

    //variables to hold the operations above
    private Double operation1 = null;
    private String pendingOperation = "=";
    //Variables for onsave and onrestore if you flip phone horizontal ex
    private static final String STATE_PENDING_OPERATION = "PendingOperation";
    private static final String STATE_OPERATION1 = "Operation1";

    //Finding all element from our design of activity_main below
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        result = findViewById(R.id.result);
        newNumber = findViewById(R.id.newNumber);
        displayOperation = findViewById(R.id.operation);

        Button button0 = findViewById(R.id.button0);
        Button button1 = findViewById(R.id.button1);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);
        Button button4 = findViewById(R.id.button4);
        Button button5 = findViewById(R.id.button5);
        Button button6 = findViewById(R.id.button6);
        Button button7 = findViewById(R.id.button7);
        Button button8 = findViewById(R.id.button8);
        Button button9 = findViewById(R.id.button9);
        Button buttonDott = findViewById(R.id.buttonDott);

        Button buttonEqual = findViewById(R.id.buttonEqual);
        Button buttonMultiply = findViewById(R.id.buttonMultiplication);
        Button buttonSubtraction = findViewById(R.id.buttonSubtraction);
        Button buttonDivide = findViewById(R.id.buttonDiviation);
        Button buttonPlus = findViewById(R.id.buttonPlus);
        Button buttonPercent = findViewById(R.id.buttonPercent);
        Button buttonPi = findViewById(R.id.buttonPi);
        Button buttonRoot = findViewById(R.id.buttonRoot);
        Button buttonPow = findViewById(R.id.button35);
        Button buttonErase = findViewById(R.id.eraseButton);

        //Clicklistener for number or dot
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
        buttonErase.setOnClickListener(listener);
        buttonErase.setOnClickListener(view -> {
            newNumber.getText().clear();
        });

        //Clicklistener for operation(math signs)
        View.OnClickListener opListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Button b = (Button) view;
                String op = b.getText().toString();
                String value = newNumber.getText().toString();
                //try/catch if you dot sign before any number
                try {
                    Double doubleValue = Double.valueOf(value);
                    performOperation(doubleValue, op);
                } catch (NumberFormatException e) {
                    newNumber.setText("");
                }
                pendingOperation = op;
                displayOperation.setText(pendingOperation);
            }
        };
        buttonEqual.setOnClickListener(opListener);
        buttonMultiply.setOnClickListener(opListener);
        buttonSubtraction.setOnClickListener(opListener);
        buttonDivide.setOnClickListener(opListener);
        buttonPlus.setOnClickListener(opListener);
        buttonPercent.setOnClickListener(opListener);
        buttonPi.setOnClickListener(opListener);
        buttonRoot.setOnClickListener(opListener);
        buttonPow.setOnClickListener(opListener);
        buttonErase.setOnClickListener(opListener);
        buttonErase.setOnClickListener(view -> {
            newNumber.getText().clear();
        });
    }

    //if operation1 isn't 0 the input should be stored in STATE_OPERATION1
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putString(PERFORMANCE_HINT_SERVICE, pendingOperation);
        if (operation1 != null) {
            outState.putDouble(STATE_OPERATION1, operation1);
        }
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        pendingOperation = savedInstanceState.getString(STATE_PENDING_OPERATION);
        operation1 = savedInstanceState.getDouble(STATE_OPERATION1);
        displayOperation.setText(pendingOperation);
    }

    private void performOperation(Double value, String operation) {

        if (null == operation1) {
            operation1 = value;
        } else {
            if (pendingOperation.equals("=")) {
                pendingOperation = operation;
            }
            switch (pendingOperation) {
                case "/":
                    //This if/else is for crash if you divide 0 with 0
                    if (value == 0) {
                        operation1 = 0.0;
                    } else {
                        operation1 /= value;
                    }
                    break;
                case "*":
                    operation1 *= value;
                    break;
                case "-":
                    operation1 -= value;
                    break;
                case "+":
                    operation1 += value;
                    break;
                case "%":
                    operation1 = operation1 * (value / 100);
                    break;
                case "x²":
                    operation1 = Math.pow((operation1), value);
                    break;
                case "π":
                    operation1 = Math.PI * (value);
                    break;
                case "√":
                    operation1 = (value) * Math.sqrt(operation1);
                    break;
                case "=":
                    operation1 = value;
                    break;

            }
        }
        result.setText(operation1.toString());
        newNumber.setText("");

    }
}