package com.example.myfinanceapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.accntNumberText).setEnabled(false);
        findViewById(R.id.paymentAmtText).setEnabled(false);
        findViewById(R.id.initBalanceText).setEnabled(false);
        findViewById(R.id.currBalanceText).setEnabled(false);
        findViewById(R.id.interestRateText).setEnabled(false);

        initTextChangedEvent();
        initRadioButtonClick();
        initSaveButton();
        initClearButton();
    }

    private FinanceClass financeData = new FinanceClass();

    private void initTextChangedEvent(){
        final EditText txtaccountNum = findViewById(R.id.accntNumberText);
        txtaccountNum.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(!txtaccountNum.getText().toString().matches(""))
                    financeData.setAccountNumber(Double.valueOf(txtaccountNum.getText().toString()));
            }
        });
        final EditText txtinitBalance = findViewById(R.id.initBalanceText);
        txtinitBalance.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(!txtinitBalance.getText().toString().matches(""))
                    financeData.setInitBalance(Double.valueOf(txtinitBalance.getText().toString()));
            }
        });
        final EditText txtcurrBalance = findViewById(R.id.currBalanceText);
        txtcurrBalance.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(!txtcurrBalance.getText().toString().matches(""))
                    financeData.setCurrBalance(Double.valueOf(txtcurrBalance.getText().toString()));
            }
        });
        final EditText txtpaymentAmt = findViewById(R.id.paymentAmtText);
        txtpaymentAmt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(!txtpaymentAmt.getText().toString().matches(""))
                    financeData.setPaymentAmount(Double.valueOf(txtpaymentAmt.getText().toString()));
            }
        });
        final EditText txtinterestRate = findViewById(R.id.interestRateText);
        txtinterestRate.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(!txtinterestRate.getText().toString().matches(""))
                    financeData.setInterestRate(Double.valueOf(txtinterestRate.getText().toString()));
            }
        });
    }

    private void initRadioButtonClick()
    {
        RadioGroup accgrp = findViewById(R.id.accountSelectionRadioGrp);
        accgrp.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch(i){
                    case R.id.cdRadio:
                        findViewById(R.id.accntNumberText).setEnabled(true);
                        findViewById(R.id.initBalanceText).setEnabled(true);
                        findViewById(R.id.currBalanceText).setEnabled(true);
                        findViewById(R.id.interestRateText).setEnabled(true);
                        findViewById(R.id.paymentAmtText).setEnabled(false);
                        break;
                    case R.id.loanAccntRadio:
                        findViewById(R.id.accntNumberText).setEnabled(true);
                        findViewById(R.id.paymentAmtText).setEnabled(true);
                        findViewById(R.id.initBalanceText).setEnabled(true);
                        findViewById(R.id.currBalanceText).setEnabled(true);
                        findViewById(R.id.interestRateText).setEnabled(true);
                        break;
                    case R.id.checkingAccntRadio:
                        findViewById(R.id.accntNumberText).setEnabled(true);
                        findViewById(R.id.paymentAmtText).setEnabled(false);
                        findViewById(R.id.initBalanceText).setEnabled(false);
                        findViewById(R.id.currBalanceText).setEnabled(true);
                        findViewById(R.id.interestRateText).setEnabled(false);
                        break;
                    default:
                        findViewById(R.id.accntNumberText).setEnabled(false);
                        findViewById(R.id.paymentAmtText).setEnabled(false);
                        findViewById(R.id.initBalanceText).setEnabled(false);
                        findViewById(R.id.currBalanceText).setEnabled(false);
                        findViewById(R.id.interestRateText).setEnabled(false);
                        break;
                }
            }
        });
    }
    private void initSaveButton(){
        Button saveButton = findViewById((R.id.savebutton));
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean saveSuccess = false;
                DataSource ds = new DataSource(MainActivity.this);
                try{
                    ds.open();

                    if(financeData.getId() == -1){
                        saveSuccess = ds.insertAccount(financeData);
                    }
                    ds.close();
                }
                catch(Exception e){
                    saveSuccess = false;
                }

                if(saveSuccess){
                    Context context = getApplicationContext();
                    String text = "Account Saved!!";
                    int duration = Toast.LENGTH_LONG;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }
            }
        });
    }
    private void initClearButton(){
        Button clearButton = findViewById((R.id.clearbutton));
        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((RadioGroup)findViewById(R.id.accountSelectionRadioGrp)).clearCheck();
                findViewById(R.id.accntNumberText).setEnabled(false);
                ((EditText)findViewById(R.id.accntNumberText)).setText("0.0");
                findViewById(R.id.paymentAmtText).setEnabled(false);
                ((EditText)findViewById(R.id.paymentAmtText)).setText("0.0");
                findViewById(R.id.initBalanceText).setEnabled(false);
                ((EditText)findViewById(R.id.initBalanceText)).setText("0.0");
                findViewById(R.id.currBalanceText).setEnabled(false);
                ((EditText)findViewById(R.id.currBalanceText)).setText("0.0");
                findViewById(R.id.interestRateText).setEnabled(false);
                ((EditText)findViewById(R.id.interestRateText)).setText("0.0");
            }
        });
    }
}