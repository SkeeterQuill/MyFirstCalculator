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

    static TextView mainDisplay;
    TextView calculationDisplay;
    String calculationString = "";
    String numberString = "0";
    ArrayList<Character> operatorsForCalculation = new ArrayList<>();
    ArrayList<Float> numbersForCalculation = new ArrayList<>();
    static boolean calcComplete = false;
    static boolean error = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainDisplay = findViewById(R.id.mainView);
        calculationDisplay = findViewById(R.id.calculationView);

    }
    // method for each numbered button
    void updateMainDisplay(int x){
        if (calcComplete){
            numberString = String.valueOf(x);
            calcComplete = false;
            calculationDisplay.setText("");
        }else if(numberString.equals("0")){
            numberString = String.valueOf(x);
        }else if(numberString.length() >= 11){
            Toast toast = Toast.makeText(getApplicationContext(), "Maximum number of digits reached", Toast.LENGTH_SHORT);
            toast.show();
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
            Toast toast = Toast.makeText(getApplicationContext(), "Cannot use decimal more than once", Toast.LENGTH_SHORT);
            toast.show();
        }else{
            numberString = numberString + ".";
            mainDisplay.setText(numberString);
        }
    }

    public void btn_Negate(View v){

        char ch = numberString.charAt(0);
        StringBuilder numStr = new StringBuilder(numberString);

        if(numberString.equals("0")){
            Toast toast = Toast.makeText(getApplicationContext(), "Cannot Negate 0", Toast.LENGTH_SHORT);
            toast.show();
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
        calculationDisplay.setText("");
    }

    public void operatorClicked(char operator){
        numbersForCalculation.add(Float.parseFloat(numberString));
        operatorsForCalculation.add(operator);
        calculationString = calculationString + numberString + " " + operator + " ";

        calculationDisplay.setText(calculationString);
        numberString = "0";
        mainDisplay.setText(numberString);
    }

    public void btn_Addition(View v){
        operatorClicked('+');
        calcComplete = false;
    }

    public void btn_Subtract(View v){
        operatorClicked('-');
        calcComplete = false;
    }

    public void btn_Multiply(View v){
        operatorClicked('*');
        calcComplete = false;
    }

    public void btn_Divide(View v){
        operatorClicked('/');
        calcComplete = false;
    }

    public void btn_Equals(View v){
        numbersForCalculation.add(Float.parseFloat(numberString));
        Float prosNumber = numbersForCalculation.get(0);
        calculationString = calculationString + numberString + " " + '=' + " ";


        for(int i = 1; i < numbersForCalculation.size();i++){

            if(operatorsForCalculation.get(0) == '+'){
                prosNumber = prosNumber + numbersForCalculation.get(i);
            }else if(operatorsForCalculation.get(0) == '-'){
                prosNumber = prosNumber - numbersForCalculation.get(i);
            }else if(operatorsForCalculation.get(0) == '/'){
                if(numbersForCalculation.get(i) == 0.0f){
                    Toast toast = Toast.makeText(getApplicationContext(), "Cannot Divide by Zero", Toast.LENGTH_SHORT);
                    toast.show();
                    //String error = "Error";
                    //MainActivity.mainDisplay.setText(error);
                    MainActivity.calcComplete = true;
                    MainActivity.error = true;


                }else {
                    prosNumber = prosNumber / numbersForCalculation.get(i);
                }
            }else if(operatorsForCalculation.get(0) == '*'){
                prosNumber = prosNumber * numbersForCalculation.get(i);
            }else{

            }

            operatorsForCalculation.remove(0);


        }
        float intTest;

        intTest = prosNumber - prosNumber.intValue();
        String calculationResult;
        if(intTest == 0) {

            calculationResult = String.valueOf(prosNumber.intValue());
        }else{
            calculationResult = String.valueOf(prosNumber);
        }

        if(error){
            mainDisplay.setText("error");
        }else{
        mainDisplay.setText(calculationResult);
        }
        calculationDisplay.setText(calculationString);
        calculationString = "";
        numbersForCalculation.clear();
        operatorsForCalculation.clear();
        numberString = calculationResult;
        //calculationResult = "";
        calcComplete = true;
        error = false;

    }

}