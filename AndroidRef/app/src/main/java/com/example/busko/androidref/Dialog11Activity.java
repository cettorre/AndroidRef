package com.example.busko.androidref;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class Dialog11Activity extends AppCompatActivity {

    Button dialogButton;

    TimePickDialog tpdf;
    DatePickDialog dpd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog11);
        dialogButton = findViewById(R.id.buttonDialog);
    }

    public void showAlertDialogF(View v){
        AlertDialogFragment adf = new AlertDialogFragment();
        adf.show(getSupportFragmentManager(), "Adialog");
    }

    public void showTimePickDialogF(View v){
         tpdf = new TimePickDialog();
        tpdf.show(getSupportFragmentManager(), "TPdialog");
    }

    public void showDatePickDialog(View v){
        dpd = new DatePickDialog();
        dpd.show(getSupportFragmentManager(), "DPdialog");
    }



}
