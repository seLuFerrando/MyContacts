package com.selumobileapps.mycontacts;

import android.app.DatePickerDialog;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    TextInputEditText name;
    TextInputEditText birthdate;
    TextInputEditText phone;
    TextInputEditText email;
    TextInputEditText desc;
    DatePickerDialog datePickerDialog;
    TextInputLayout tilBirthdate;
    int mDay, mMonth, mYear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Bundle extras = getIntent().getExtras();
        if(extras==null) {
            setToday();
        }else{
            //TODO bundle confirm
        }
        name = (TextInputEditText) findViewById(R.id.etName);
        birthdate = (TextInputEditText) findViewById(R.id.etBirthdate);
        phone = (TextInputEditText) findViewById(R.id.etTelephone);
        email = (TextInputEditText) findViewById(R.id.etEmail);
        desc = (TextInputEditText) findViewById(R.id.etDescription);
        tilBirthdate = (TextInputLayout) findViewById(R.id.tilBirthdate);
        birthdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                datePickerDialog = new DatePickerDialog(MainActivity.this, R.style.MyAlert,
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                // set day of month , month and year value in the edit text
                                birthdate.setText(dayOfMonth + "/"
                                        + (monthOfYear + 1) + "/" + year);
                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.setTitle(getResources().getString(R.string.birthdate));
                datePickerDialog.show();
            }
        });
    }

    private void setToday(){
        final Calendar c = Calendar.getInstance();
        mYear = c.get(Calendar.YEAR); // current year
        mMonth = c.get(Calendar.MONTH); // current month
        mDay = c.get(Calendar.DAY_OF_MONTH); // current day
    }
}
