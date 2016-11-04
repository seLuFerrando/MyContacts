package com.selumobileapps.mycontacts;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    Context context;
    TextInputEditText name;
    TextInputEditText birthdate;
    TextInputEditText phone;
    TextInputEditText email;
    TextInputEditText desc;
    Button next;
    DatePickerDialog datePickerDialog;
    TextInputLayout tilBirthdate;
    Bundle bundle;
    int mDay, mMonth, mYear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        setContentView(R.layout.activity_main);
        bundle = getIntent().getExtras();
        name = (TextInputEditText) findViewById(R.id.etName);
        birthdate = (TextInputEditText) findViewById(R.id.etBirthdate);
        phone = (TextInputEditText) findViewById(R.id.etTelephone);
        email = (TextInputEditText) findViewById(R.id.etEmail);
        desc = (TextInputEditText) findViewById(R.id.etDescription);
        tilBirthdate = (TextInputLayout) findViewById(R.id.tilBirthdate);

        if(bundle==null) {
            setToday();
        }else{
            setData();
        }
        birthdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                datePickerDialog = new DatePickerDialog(context, R.style.AnConFormat,
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                // set day of month , month and year value in the edit text
                                mDay = dayOfMonth;
                                mMonth = monthOfYear + 1;
                                mYear = year;
                                birthdate.setText(mDay + "/"
                                        + (mMonth) + "/" + mYear);
                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.setTitle(getResources().getString(R.string.birthdate));
                datePickerDialog.show();
            }
        });
        next = (Button)findViewById(R.id.btNext);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString(getResources().getString(R.string.name),name.getText().toString());
                bundle.putInt(getResources().getString(R.string.mDay), mDay);
                bundle.putInt(getResources().getString(R.string.mMonth), mMonth);
                bundle.putInt(getResources().getString(R.string.mYear), mYear);
                bundle.putString(getResources().getString(R.string.telephone),phone.getText().toString());
                bundle.putString(getResources().getString(R.string.email),email.getText().toString());
                bundle.putString(getResources().getString(R.string.description),desc.getText().toString());
                Log.d("EHHHHHHHHHH", name+":" + phone+"//"+email+"  "+desc+"HH");
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }

    private void setData(){
        name.setText(bundle.getString(getResources().getString(R.string.name)));
        mDay = bundle.getInt(getResources().getString(R.string.mDay));
        mMonth = bundle.getInt(getResources().getString(R.string.mMonth));
        mYear = bundle.getInt(getResources().getString(R.string.mYear));
        String date = mDay+"/"+mMonth+"/"+mYear;
        birthdate.setText(date);
        phone.setText(bundle.getString(getResources().getString(R.string.telephone)));
        email.setText(bundle.getString(getResources().getString(R.string.email)));
        desc.setText(bundle.getString(getResources().getString(R.string.description)));

    }
    private void setToday(){
        final Calendar c = Calendar.getInstance();
        mYear = c.get(Calendar.YEAR); // current year
        mMonth = c.get(Calendar.MONTH); // current month
        mDay = c.get(Calendar.DAY_OF_MONTH); // current day
    }
}
