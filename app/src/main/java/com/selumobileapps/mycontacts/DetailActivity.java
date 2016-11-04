package com.selumobileapps.mycontacts;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    Context context;
    Bundle bundle;
    TextView tvName;
    TextView tvBirthDate;
    TextView tvPhone;
    TextView tvEmail;
    TextView tvDesc;
    Button btReturn;
    int mDay;
    int mMonth;
    int mYear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        context = this;
        bundle = getIntent().getExtras();
        tvName = (TextView) findViewById(R.id.tvNameDetail);
        tvBirthDate = (TextView) findViewById(R.id.tvBirthdateDetail);
        tvPhone = (TextView) findViewById(R.id.tvTelephoneDetail);
        tvEmail = (TextView) findViewById(R.id.tvEmailDetail);
        tvDesc = (TextView) findViewById(R.id.tvDescriptionDetail);
        btReturn = (Button) findViewById(R.id.btReturn);
        if(bundle!=null){
            tvName.setText(bundle.getString(getResources().getString(R.string.name)));
            mDay = bundle.getInt(getResources().getString(R.string.mDay));
            mMonth = bundle.getInt(getResources().getString(R.string.mMonth));
            mYear = bundle.getInt(getResources().getString(R.string.mYear));
            String date = mDay+"/"+mMonth+"/"+mYear;
            tvBirthDate.setText(date);
            tvPhone.setText(bundle.getString(getResources().getString(R.string.telephone)));
            tvEmail.setText(bundle.getString(getResources().getString(R.string.email)));
            tvDesc.setText(bundle.getString(getResources().getString(R.string.description)));
            Log.i("EH DETAILLLLLLLLLLL", tvName+":" + tvPhone+"//"+tvEmail+"  "+tvDesc+"HH");
            btReturn.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, MainActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putString(getResources().getString(R.string.name),tvName.getText().toString());
                    bundle.putInt(getResources().getString(R.string.mDay), mDay);
                    bundle.putInt(getResources().getString(R.string.mMonth), mMonth);
                    bundle.putInt(getResources().getString(R.string.mYear), mYear);
                    bundle.putString(getResources().getString(R.string.telephone),tvPhone.getText().toString());
                    bundle.putString(getResources().getString(R.string.email),tvEmail.getText().toString());
                    bundle.putString(getResources().getString(R.string.description),tvDesc.getText().toString());
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
            });

        }else{
            Log.i ("TONOTO TU", "titititititititit");
        }



    }
}
