package com.calci;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText et, et1;
    TextView t;
    Button b, b1, b2, b3, b4, b5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addListenerOnButton();
    }

        public void addListenerOnButton () {
        et = (EditText) findViewById(R.id.editText);
        et1 = (EditText) findViewById(R.id.editText3);
        b = (Button) findViewById(R.id.button);
        b1 = (Button) findViewById(R.id.button2);
        b2 = (Button) findViewById(R.id.button3);
        b3 = (Button) findViewById(R.id.button4);
        b4 = (Button) findViewById(R.id.button5);
        t = (TextView) findViewById(R.id.textView);

        //Addison
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String value1 = et.getText().toString();
                String value2 = et1.getText().toString();
                int a = Integer.parseInt(value1);
                int b = Integer.parseInt(value2);
                int sum = a + b;
                t.setText(Integer.toString(sum));
            }
        });
        //Subtraction
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String value1 = et.getText().toString();
                String value2 = et1.getText().toString();
                int a = Integer.parseInt(value1);
                int b = Integer.parseInt(value2);
                int c = a - b;
                t.setText(Integer.toString(c));
            }
        });
        //Multiply
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String value1 = et.getText().toString();
                String value2 = et1.getText().toString();
                int a = Integer.parseInt(value1);
                int b = Integer.parseInt(value2);
                int c = a * b;
                t.setText(Integer.toString(c));
            }
        });
        // Divison
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String value1 = et.getText().toString();
                String value2 = et1.getText().toString();
                int a = Integer.parseInt(value1);
                int b = Integer.parseInt(value2);
                int c = a / b;
                t.setText(Integer.toString(c));
            }
        });
        //Reminder
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String value1 = et.getText().toString();
                String value2 = et1.getText().toString();
                int a = Integer.parseInt(value1);
                int b = Integer.parseInt(value2);
                int c = a % b;
                t.setText(Integer.toString(c));
            }
        });
    }
}
