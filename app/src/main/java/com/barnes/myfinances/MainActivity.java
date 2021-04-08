package com.barnes.myfinances;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Toast;

import com.barnes.myfinances.CD.CD;
import com.barnes.myfinances.Checking.Checking;
import com.barnes.myfinances.Loan.Loan;

public class MainActivity extends AppCompatActivity {
    Button btnSave,btnCancel;
    EditText etAccountNumber,etCurrentBal,etInitalBal,etInterestRate,etPayment;
    RadioButton rdCD,rdLoan,rdChecking;
    String value = "";
    LinearLayout lAccNum,lCurrBal,lInitialBal,lintRate,lPayment;

    void initView() {
        setContentView(R.layout.activity_main);
        btnSave = findViewById(R.id.btnSave);
        btnCancel = findViewById(R.id.btnCancel);
        etAccountNumber = findViewById(R.id.etAccNumber);
        etInitalBal = findViewById(R.id.etIntialBal);
        etCurrentBal = findViewById(R.id.etCurrentBal);
        etInterestRate = findViewById(R.id.etIntRate);
        etPayment = findViewById(R.id.etPayment);
        rdCD = findViewById(R.id.rdCD);
        rdLoan = findViewById(R.id.rdLoan);
        rdChecking = findViewById(R.id.rdChecking);
        lAccNum = findViewById(R.id.linearAccNum);
        lCurrBal = findViewById(R.id.linearCurrBal);
        lInitialBal = findViewById(R.id.linearIniBal);
        lintRate = findViewById(R.id.linearIntRate);
        lPayment = findViewById(R.id.linearPayment);

        rdCD.setChecked(true);
        lPayment.setVisibility(View.INVISIBLE);
        value = "rdCD";
    }

    void setEditTextBlank() {
        etInitalBal.setText("");
        etCurrentBal.setText("");
        etInterestRate.setText("");
        etPayment.setText("");
        etAccountNumber.setText("");
    }

    void showToast() {
        Toast.makeText(getApplicationContext(), "Operation Success", Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initView();

        //Clear View
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setEditTextBlank();
            }
        });

        //CD Radio Button Clicked
        rdCD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(rdCD.isChecked()) {
                    rdChecking.setChecked(false);
                    rdLoan.setChecked(false);
                    value = "rdCD";
                    lAccNum.setVisibility(View.VISIBLE);
                    lCurrBal.setVisibility(View.VISIBLE);
                    lInitialBal.setVisibility(View.VISIBLE);
                    lintRate.setVisibility(View.VISIBLE);
                    lPayment.setVisibility(View.INVISIBLE);
                }
            }
        });

        rdChecking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(rdChecking.isChecked()) {
                    rdCD.setChecked(false);
                    rdLoan.setChecked(false);
                    value = "rdChecking";
                    lAccNum.setVisibility(View.VISIBLE);
                    lCurrBal.setVisibility(View.VISIBLE);
                    lInitialBal.setVisibility(View.INVISIBLE);
                    lintRate.setVisibility(View.INVISIBLE);
                    lPayment.setVisibility(View.INVISIBLE);
                }
            }
        });

        rdLoan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(rdLoan.isChecked()) {
                    rdCD.setChecked(false);
                    rdChecking.setChecked(false);
                    value = "rdLoan";
                    lAccNum.setVisibility(View.VISIBLE);
                    lCurrBal.setVisibility(View.VISIBLE);
                    lInitialBal.setVisibility(View.VISIBLE);
                    lintRate.setVisibility(View.VISIBLE);
                    lPayment.setVisibility(View.VISIBLE);
                }
            }
        });


        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(value.contains("rdCD")) {
                    AsyncTask.execute(new Runnable() {
                        @Override
                        public void run() {
                            CD cd = new CD(Integer.parseInt(etAccountNumber.getText().toString()),
                                    Integer.parseInt(etInitalBal.getText().toString()),
                                    Integer.parseInt(etCurrentBal.getText().toString()),
                                    Integer.parseInt(etInterestRate.getText().toString()));
                            AppDatabase.getDatabase(getApplicationContext()).userDao().insertAll(cd);
                        }
                    });
                    showToast();
                }
               else if(value.contains("rdLoan")) {
                    AsyncTask.execute(new Runnable() {
                        @Override
                        public void run() {
                            Loan cd = new Loan(Integer.parseInt(etAccountNumber.getText().toString()),
                                    Integer.parseInt(etInitalBal.getText().toString()),
                                    Integer.parseInt(etCurrentBal.getText().toString()),
                                    Integer.parseInt(etInterestRate.getText().toString()),
                                    Integer.parseInt(etPayment.getText().toString()));
                            AppDatabase.getDatabase(getApplicationContext()).loanDao().insertAll(cd);
                        }
                    });
                    showToast();
                }
               else if(value.contains("rdChecking")){
                    AsyncTask.execute(new Runnable() {
                        @Override
                        public void run() {
                            Checking cd = new Checking(Integer.parseInt(etAccountNumber.toString()),
                                    Integer.parseInt(etCurrentBal.toString())
                                    );
                            AppDatabase.getDatabase(getApplicationContext()).checkingDAODao().insertAll(cd);
                        }
                    });
                    showToast();
                }

               setEditTextBlank();
            }


        });


    }
}