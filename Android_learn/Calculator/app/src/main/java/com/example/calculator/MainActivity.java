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
    private boolean IsResult = false;

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
                    if(IsResult){
                        edit.setText("");
                        IsResult = false;
                    }
                    edit.setText(edit.getText().toString()+1);
                }
                else if(v==button2){
                    if(IsResult){
                        edit.setText("");
                        IsResult = false;
                    }
                    edit.setText(edit.getText().toString()+2);
                }
                else if(v==button3){
                    if(IsResult){
                        edit.setText("");
                        IsResult = false;
                    }
                    edit.setText(edit.getText().toString()+3);
                }
                else if(v==button4){
                    if(IsResult){
                        edit.setText("");
                        IsResult = false;
                    }
                    edit.setText(edit.getText().toString()+4);
                }
                else if(v==button5){
                    if(IsResult){
                        edit.setText("");
                        IsResult = false;
                    }
                    edit.setText(edit.getText().toString()+5);
                }
                else if(v==button6){
                    if(IsResult){
                        edit.setText("");
                        IsResult = false;
                    }
                    edit.setText(edit.getText().toString()+6);
                }
                else if(v==button7){
                    if(IsResult){
                        edit.setText("");
                        IsResult = false;
                    }
                    edit.setText(edit.getText().toString()+7);
                }
                else if(v==button8){
                    if(IsResult){
                        edit.setText("");
                        IsResult = false;
                    }
                    edit.setText(edit.getText().toString()+8);
                }
                else if(v==button9){
                    if(IsResult){
                        edit.setText("");
                        IsResult = false;
                    }
                    edit.setText(edit.getText().toString()+9);
                }
                else if(v==button0){
                    if(IsResult){
                        edit.setText("");
                        IsResult = false;
                    }
                    edit.setText(edit.getText().toString()+0);
                }

                else if(v==buttonplus){
                    IsResult = false;
                    if(IsClick) calcmore();
                    a = Integer.valueOf(edit.getText().toString().trim());
                    edit.setText("");
                    where = 1;
                    IsClick = true;
                }
                else if(v==buttonMinus){
                    IsResult = false;
                    if(IsClick) calcmore();
                    a = Integer.valueOf(edit.getText().toString().trim());
                    edit.setText("");
                    where = 2;
                    IsClick = true;
                }
                else if(v==buttonmul){
                    IsResult = false;
                    if(IsClick) calcmore();
                    a = Integer.valueOf(edit.getText().toString().trim());
                    edit.setText("");
                    where = 3;
                    IsClick = true;
                }
                else if(v==buttondiv){
                    IsResult = false;
                    if(IsClick) calcmore();
                    a = Integer.valueOf(edit.getText().toString().trim());
                    edit.setText("");
                    where = 4;
                    IsClick = true;
                }

                if(v==buttonresult){
                    if(!IsResult){
                        calcmore();
                        edit.setText(Integer.toString(a));
                    }

                    IsResult = true;
                }

                else if(v==buttonclear){
                    edit.setText("");
                    a = 0;
                    IsResult = false;
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