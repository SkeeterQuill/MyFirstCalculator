package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    TextView mainDisplay;
    TextView calculationDisplay;
    String calculationString = "";
    String numberString = "0";
    ArrayList<Character> operatorsForCalculation = new ArrayList<>();
    ArrayList<Float> numbersForCalculation = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainDisplay = findViewById(R.id.mainView);
        calculationDisplay = findViewById(R.id.calculationView);

    }

    void updateMainDisplay(int x){
        if(numberString.equals("0")){
            numberString = String.valueOf(x);
        }else if(numberString.length() >= 11){

        }
        else{
            numberString = numberString + x;
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

    public void btn_Negate(View v){

        char ch = numberString.charAt(0);
        StringBuilder numStr = new StringBuilder(numberString);

        if(numberString.equals("0")){

        }else if (ch == '-') {
            numStr.deleteCharAt(0);
            numberString = numStr.toString();
        }else{
            numberString = "-" + numberString;
        }

        mainDisplay.setText(numberString);
    }


    public void btn_Backspace(View v) {
        char ch = numberString.charAt(0);

        if(numberString.length() == 1){
            numberString = "0";
            mainDisplay.setText(numberString);


        }else if(numberString.length() == 2 && ch == '-'){
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

    public void btn_Clear(View v){
        numbersForCalculation.clear();
        numberString = "0";
        mainDisplay.setText(numberString);
    }

    public void operatorClicked(char operator){
        numbersForCalculation.add(Float.parseFloat(numberString));
        operatorsForCalculation.add(operator);
        calculationString = calculationString + numberString + " " + operator + " ";
        mainDisplay.setText(numberString);
        calculationDisplay.setText(calculationString);
        numberString = "0";
    }

    public void btn_Addition(View v){
        operatorClicked('+');
    }

    public void btn_Subtract(View v){
        operatorClicked('-');
    }

    public void btn_Multiply(View v){
        operatorClicked('x');
    }

    public void btn_Divide(View v){
        operatorClicked('/');
    }

}