package com.example.calculator;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button button1,button2,button3,button4,button5,button6,button7,button8,button9,button0;
    private Button buttonplus,buttonMinus,buttonmul,buttondiv,buttonresult,buttonclear;

    private EditText edit, calctext; 

    private int a;
    private int where = 0;
    private boolean IsClick = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = (Button)findViewById(R.id.button1);
        button2 = (Button)findViewById(R.id.button2);
        button3 = (Button)findViewById(R.id.button3);
        button4 = (Button)findViewById(R.id.button4);
        button5 = (Button)findViewById(R.id.button5);
        button6 = (Button)findViewById(R.id.button6);
        button7 = (Button)findViewById(R.id.button7);
        button8 = (Button)findViewById(R.id.button8);
        button9 = (Button)findViewById(R.id.button9);
        button0 = (Button)findViewById(R.id.button0);

        buttonplus = (Button)findViewById(R.id.buttonPlus);
        buttonMinus = (Button)findViewById(R.id.buttonMinus);
        buttonmul = (Button)findViewById(R.id.buttonMult);
        buttondiv = (Button)findViewById(R.id.buttonDiv);
        buttonresult = (Button)findViewById(R.id.buttonresult);
        buttonclear = (Button)findViewById(R.id.buttonclear);

        edit = (EditText)findViewById(R.id.e1);
        edit.setCursorVisible(false);
        calctext = (EditText)findViewById(R.id.e2);
        calctext.setCursorVisible(false);


        View.OnClickListener cl = new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(v==button1){
                    edit.setText(edit.getText().toString()+1);
                    if(IsClick) calcmore();
                }
                else if(v==button2){
                    edit.setText(edit.getText().toString()+2);
                    if(IsClick) calcmore();
                }
                else if(v==button3){
                    edit.setText(edit.getText().toString()+3);
                    if(IsClick) calcmore();
                }
                else if(v==button4){
                    edit.setText(edit.getText().toString()+4);
                    if(IsClick) calcmore();
                }
                else if(v==button5){
                    edit.setText(edit.getText().toString()+5);
                    if(IsClick) calcmore();
                }
                else if(v==button6){
                    edit.setText(edit.getText().toString()+6);
                    if(IsClick) calcmore();
                }
                else if(v==button7){
                    edit.setText(edit.getText().toString()+7);
                    if(IsClick) calcmore();
                }
                else if(v==button8){
                    edit.setText(edit.getText().toString()+8);
                    if(IsClick) calcmore();
                }
                else if(v==button9){
                    edit.setText(edit.getText().toString()+9);
                    if(IsClick) calcmore();
                }
                else if(v==button0){
                    edit.setText(edit.getText().toString()+0);
                    if(IsClick) calcmore();
                }

                else if(v==buttonplus){
                    a = Integer.valueOf(edit.getText().toString().trim());
                    edit.setText("");
                    where = 1;
                    IsClick = true;
                }
                else if(v==buttonMinus){
                    a = Integer.valueOf(edit.getText().toString().trim());
                    edit.setText("");
                    where = 2;
                    IsClick = true;
                }
                else if(v==buttonmul){
                    a = Integer.valueOf(edit.getText().toString().trim());
                    edit.setText("");
                    where = 3;
                    IsClick = true;
                }
                else if(v==buttondiv){
                    a = Integer.valueOf(edit.getText().toString().trim());
                    edit.setText("");
                    where = 4;
                    IsClick = true;
                }

                if(v==buttonresult){
                    edit.setText(Integer.toString(a));

                }

                else if(v==buttonclear){
                    edit.setText("");
                }
            }
        };

        button1.setOnClickListener(cl);
        button2.setOnClickListener(cl);
        button3.setOnClickListener(cl);
        button4.setOnClickListener(cl);
        button5.setOnClickListener(cl);
        button6.setOnClickListener(cl);
        button7.setOnClickListener(cl);
        button8.setOnClickListener(cl);
        button9.setOnClickListener(cl);
        button0.setOnClickListener(cl);
        buttonplus.setOnClickListener(cl);
        buttonMinus.setOnClickListener(cl);
        buttonmul.setOnClickListener(cl);
        buttondiv.setOnClickListener(cl);
        buttonresult.setOnClickListener(cl);
        buttonclear.setOnClickListener(cl);
    }

    public void calcmore(){
        if(where==1){
            a = a + Integer.valueOf(edit.getText().toString().trim());
            edit.setText(Integer.toString(a));
        }

        else if(where==2){
            a = a - Integer.valueOf(edit.getText().toString().trim());
            edit.setText(Integer.toString(a));
        }

        else if(where==3){
            a = a * Integer.valueOf(edit.getText().toString().trim());
            edit.setText(Integer.toString(a));
        }

        else if(where==4){
            if(Integer.valueOf(edit.getText().toString().trim())!=0){
                a = a / Integer.valueOf(edit.getText().toString().trim());
                edit.setText(Integer.toString(a));
            }
        }

        IsClick = false;
    }
}