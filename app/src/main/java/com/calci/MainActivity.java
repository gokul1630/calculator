package com.calci;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText et, et1;
    private TextView t;
    private Button b, b1, b2, b3, b4, b5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
        b5.setOnClickListener(this);
    }
    
    private void initView(){
        et = (EditText) findViewById(R.id.editText);
        et1 = (EditText) findViewById(R.id.editText3);
        b = (Button) findViewById(R.id.button);
        b1 = (Button) findViewById(R.id.button2);
        b2 = (Button) findViewById(R.id.button3);
        b3 = (Button) findViewById(R.id.button4);
        b4 = (Button) findViewById(R.id.button5);
        t = (TextView) findViewById(R.id.textView);
    }

    @Override
    public void onClick (View v) {
        switch(v.getId()){
            case R.id.button:
                String value1 = et.getText().toString();
                String value2 = et1.getText().toString();
                int a = Integer.parseInt(value1);
                int b = Integer.parseInt(value2);
                int sum = a + b;
                t.setText(Integer.toString(sum));
                break;
             case R.id.button2:
                String value1 = et.getText().toString();
                String value2 = et1.getText().toString();
                int a = Integer.parseInt(value1);
                int b = Integer.parseInt(value2);
                int c = a - b;
                t.setText(Integer.toString(c));
                break;
              case R.id.button3:
                String value1 = et.getText().toString();
                String value2 = et1.getText().toString();
                int a = Integer.parseInt(value1);
                int b = Integer.parseInt(value2);
                int c = a * b;
                t.setText(Integer.toString(c));
                break;
              case R.id.button4:
                String value1 = et.getText().toString();
                String value2 = et1.getText().toString();
                int a = Integer.parseInt(value1);
                int b = Integer.parseInt(value2);
                int c = a / b;
                t.setText(Integer.toString(c));
                break;
              case R.id.button5:
                String value1 = et.getText().toString();
                String value2 = et1.getText().toString();
                int a = Integer.parseInt(value1);
                int b = Integer.parseInt(value2);
                int c = a % b;
                t.setText(Integer.toString(c));
        }
    }
}
