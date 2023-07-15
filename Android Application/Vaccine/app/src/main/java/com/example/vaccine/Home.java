package com.example.vaccine;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class Home extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        StringBuilder result = new StringBuilder();
        RadioGroup dose = findViewById(R.id.dose);
        final int[] mYear = new int[1];
        final int[] mMonth = new int[1];
        final int[] mDay = new int[1];

        Spinner type = findViewById(R.id.spinner);
        String[] vacctype = {"Covaccine", "Covisheild"};

        ArrayAdapter ad = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, vacctype );
        ad.setDropDownViewResource(
                android.R.layout
                        .simple_spinner_dropdown_item);
        type.setAdapter(ad);

        EditText name = findViewById(R.id.editTextTextPersonName);
        EditText ph = findViewById(R.id.editTextTextPersonName2);
        EditText aadhar = findViewById(R.id.editTextTextPersonName3);
        EditText date = findViewById(R.id.editTextTextPersonName4);
        Button book = findViewById(R.id.button);
        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar c = Calendar.getInstance();
                mYear[0] = c.get(Calendar.YEAR);
                mMonth[0] = c.get(Calendar.MONTH);
                mDay[0] = c.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog datePickerDialog;
                datePickerDialog = new DatePickerDialog(Home.this, new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year,
                                          int monthOfYear, int dayOfMonth) {

                        date.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                    }
                }, mYear[0], mMonth[0], mDay[0]);
                datePickerDialog.show();

            }
        });
        book.setOnClickListener(view -> {
            String selected = "";
            if(dose.getCheckedRadioButtonId()== R.id.radioButton){
                selected = "DOSE I";
            }
            else if(dose.getCheckedRadioButtonId()== R.id.radioButton2){
                selected = "DOSE II";
            }
            else if(dose.getCheckedRadioButtonId()== R.id.radioButton3){
                selected = "DOSE III";
            }
            result.append("Name         : ").append(name.getText().toString()).append("\n");
            result.append("Phone no     : ").append(ph.getText().toString()).append("\n");
            result.append("Vaccine type : ").append(type.getSelectedItem().toString()).append("\n");
            result.append("Dose         : ").append(selected).append("\n");
            result.append("Date         : ").append(date.getText().toString()).append("\n");

            SmsManager sms = SmsManager.getDefault();
            sms.sendTextMessage(ph.getText().toString(),null,result.toString(),null,null);
        });
    }
}

