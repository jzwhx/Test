package com.example.tipcalculator;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }



    public void getAnswer(View view) {
        EditText amountInput = findViewById(R.id.checkAmountValue);
        EditText partySizeInput = findViewById(R.id.partySizeValue);
        EditText fifteenPercentTip = findViewById(R.id.fifteenPercentTipValue);
        EditText twentyPercentTip = findViewById(R.id.twentyPercentTipValue);
        EditText twentyfivePercentTip = findViewById(R.id.twentyfivePercentTipValue);
        EditText fifteenPercentTotal = findViewById(R.id.fifteenPercentTotalValue);
        EditText twentyPercentTotal = findViewById(R.id.twentyPercentTotalValue);
        EditText twentyfivePercentTotal = findViewById(R.id.twentyfivePercentTotalValue);

        String input1= amountInput.getText().toString();
        String input2 = partySizeInput.getText().toString();
        Double checkAmount = Double.parseDouble(input1);
        int partySize = Integer.parseInt(input2);
        int fifteenTip = (int) (checkAmount * 0.15 / partySize);
        int twentyTip = (int) (checkAmount * 0.20 / partySize);
        int twentyfiveTip = (int) (checkAmount * 0.25 / partySize);
        int totalWithoutTip = (int)(checkAmount / partySize);


        if(!isNumeric(input1) || !isNumeric(input2) || Integer.parseInt(input1) < 0 || Integer.parseInt(input2) < 0){
            return;
        }
        fifteenPercentTip.setText(""+fifteenTip);
        twentyPercentTip.setText(""+twentyTip);
        twentyfivePercentTip.setText(""+twentyfiveTip);
        fifteenPercentTotal.setText(""+(totalWithoutTip + fifteenTip));
        twentyPercentTotal.setText(""+(totalWithoutTip + twentyTip));
        twentyfivePercentTotal.setText(""+(totalWithoutTip + twentyfiveTip));

    }
}
