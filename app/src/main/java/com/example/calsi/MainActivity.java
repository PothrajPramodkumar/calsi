package com.example.calsi;

import androidx.appcompat.app.AppCompatActivity;
import org.mariuszgromada.math.mxparser.*;
import android.os.Bundle;
import android.text.Selection;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display = findViewById(R.id.input);
        display.setShowSoftInputOnFocus(false);

        display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (getString(R.string.display).equals(display.getText().toString())){
                    display.setText("");
                }
            }
        });
    }

    private void updatetext(String strToAdd){
        String oldstr =display.getText().toString();
        int cursorPos = display.getSelectionStart();
        String leftstr = oldstr.substring(0, cursorPos);
        String rightstr = oldstr.substring(cursorPos);
        if (getString(R.string.display).equals(display.getText().toString())){
            display.setText(strToAdd);
            display.setSelection(cursorPos + 1);

        }
        else {
            display.setText(String.format("%s%s%s",leftstr, strToAdd, rightstr));
            display.setSelection(cursorPos + 1);
        }

    }

    public void zeroBTN(View view){
        updatetext("0");

    }
    public void oneBTN(View view){
        updatetext("1");

    }
    public void twoBTN(View view){
        updatetext("2");

    }
    public void threeBTN(View view){
        updatetext("3");

    }
    public void fourBTN(View view){
        updatetext("4");

    }
    public void fiveBTN(View view){
        updatetext("5");

    }
    public void sixBTN(View view){
        updatetext("6");

    }
    public void sevenBTN(View view){
        updatetext("7");

    }
    public void eightBTN(View view){
        updatetext("8");

    }
    public void nineBTN(View view){
        updatetext("9");

    }
    public void addBTN(View view){
        updatetext("+");

    }
    public void subtractBTN(View view){
        updatetext("-");

    }
    public void divideBTN(View view){
        updatetext("/");

    }
    public void multiplyBTN(View view){
        updatetext("*");

    }
    public void bracketsBTN(View view){
        int cursorPos = display.getSelectionStart();
        int openPar = 0;
        int closePar = 0;
        int textLen = display.getText().length();

        for (int i = 0; i < cursorPos; i++){
            if (display.getText().toString().substring(i, i+1).equals("(")){
                openPar += 1;
            }
            if (display.getText().toString().substring(i, i+1).equals(")")) {
                closePar += 1;
            }
        }
        if (openPar == closePar || display.getText().toString().substring(textLen-1,textLen).equals("(")){
            updatetext("(");

        }
        if (closePar < openPar && !display.getText().toString().substring(textLen-1,textLen).equals(")")){
            updatetext(")");
        }
        display.setSelection(cursorPos + 1);



    }
    public void dotBTN(View view){
        updatetext(".");

    }
    public void equalBTN(View view){
        String userExp = display.getText().toString();

        Expression exp = new Expression(userExp);
        String result = String.valueOf(exp.calculate());

        display.setText(result);
        display.setSelection(result.length());

    }
    public void clearBTN(View view){
        display.setText("");

    }
    public void plusMinusBTN(View view){
        updatetext("+/-");

    }
    public void backspaceBTN(View view){
        int cursorPos = display.getSelectionStart();
        int textLen = display.getText().length();

        if (cursorPos != 0 && textLen != 0){
            SpannableStringBuilder selection =(SpannableStringBuilder) display.getText();
            selection.replace(cursorPos - 1, cursorPos,"");
            display.setText(selection);
            display.setSelection(cursorPos - 1);
        }

    }

}