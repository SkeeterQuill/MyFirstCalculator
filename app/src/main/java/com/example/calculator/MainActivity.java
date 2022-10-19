package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.nio.charset.StandardCharsets;


public class MainActivity extends AppCompatActivity {

    TextView mainDisplay;
    String numberString = "0";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainDisplay = findViewById(R.id.mainView);
    }

    void updateMainDisplay(int x){
        if(numberString.equals("0")){
            numberString = String.valueOf(x);
        }else if(numberString.length() >= 11){

        }
        else{
            numberString = numberString + String.valueOf(x);
        }
        mainDisplay.setText(numberString);
    }

    public void btn_1(View v) {
        updateMainDisplay(1);
    }

    public void btn_2(View v) {
        updateMainDisplay(2);
    }

    public void btn_3(View v) {
        updateMainDisplay(3);
    }

    public void btn_4(View v) {
        updateMainDisplay(4);
    }

    public void btn_5(View v) {
        updateMainDisplay(5);
    }

    public void btn_6(View v) {
        updateMainDisplay(6);
    }

    public void btn_7(View v) {
        updateMainDisplay(7);
    }

    public void btn_8(View v) {
        updateMainDisplay(8);
    }

    public void btn_9(View v) {
        updateMainDisplay(9);
    }

    public void btn_0(View v) {
        updateMainDisplay(0);
    }

    public void btn_Decimal(View v) {
        if(numberString.contains(".")){

        }else{
            numberString = numberString + ".";
            mainDisplay.setText(numberString);
        }
    }




    public void btn_Backspace(View v) {

        if(numberString.length() == 1){
            numberString = "0";
            mainDisplay.setText(numberString);


        }else if(numberString.length() > 1){
            StringBuilder numberS = new StringBuilder(numberString);

            numberS.deleteCharAt(numberString.length()-1);

            numberString = numberS.toString();



            mainDisplay.setText((numberString));
        }else{

            numberString = "0";
            mainDisplay.setText(numberString);
        }





    }

}