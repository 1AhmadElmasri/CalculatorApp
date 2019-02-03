package com.course.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //Variables to hold the numbers and operations
    private EditText result;
    private TextView displayOperation;


    //Numbers to contain the information
    private Double numOne = null;
    private Double numTwo = null;
    private Double finalNum = null;
    private String pendingOperation = "";
    private boolean done = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        result = (EditText) findViewById(R.id.displayNumber);
        displayOperation = (TextView) findViewById(R.id.displayOperation);


        //All the numerical buttons on the screen
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

        //Operation Buttons
        Button buttonAdd = (Button) findViewById(R.id.buttonAdd);
        Button buttonSubtract = (Button) findViewById(R.id.buttonSubtract);
        Button buttonMultiply = (Button) findViewById(R.id.buttonMultiply);
        Button buttonDivide = (Button) findViewById(R.id.buttonDivide);
        Button buttonDot = (Button) findViewById(R.id.buttonDot);
        Button buttonEquals = (Button) findViewById(R.id.buttonEquals);
        Button buttonAns = (Button) findViewById(R.id.buttonAns);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (done) {
                    result.setText("");
                    done = false;
                }
                Button b = (Button) view;
                result.append(b.getText().toString());
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
        buttonDot.setOnClickListener(listener);

        View.OnClickListener operationListener = new View.OnClickListener() {
            @Override
            public void onClick(View view2) {
                Button a = (Button) view2;
                String operation = a.getText().toString();
                String value = result.getText().toString();


                if (operation.equals("ANS") && finalNum != null) {
                    result.setText(finalNum.toString());
                } else {
                    if (value.length() != 0) {
                        performOperation(value, operation);
                    }
                }


                displayOperation.setText(pendingOperation);
            }
        };
        buttonAdd.setOnClickListener(operationListener);
        buttonSubtract.setOnClickListener(operationListener);
        buttonMultiply.setOnClickListener(operationListener);
        buttonDivide.setOnClickListener(operationListener);
        buttonEquals.setOnClickListener(operationListener);
        buttonAns.setOnClickListener(operationListener);

    }

    private void performOperation(String value, String operation) {
        if (numOne == null) {
            numOne = Double.valueOf(value);
            pendingOperation = operation;
            result.setText("");


        } else {

            numTwo = Double.valueOf(value);
            switch (pendingOperation) {
                case "=":
                    finalNum = numTwo;
                    break;
                case "/":
                    if (numTwo == 0) {
                        finalNum = 0.0;
                    } else {
                        finalNum = numOne / numTwo;
                    }
                    break;
                case "x":
                    finalNum = numOne * numTwo;
                    break;
                case "+":
                    finalNum = numOne + numTwo;
                    break;
                case "-":
                    finalNum = numOne - numTwo;
                    break;
            }
            System.out.println(finalNum);
            numOne = null;
            numTwo = null;
            result.setText(finalNum.toString());
            done = true;


        }
    }
}
