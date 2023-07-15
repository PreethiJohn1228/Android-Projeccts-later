package com.example.ticketreservation;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TimePicker;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Calendar;

public class Home extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Spinner fromSP;
    Spinner toSP;
    String[] from = {"Rajapalayam", "Madurai", "Chennai","Coimbatore"};
    String[] to = {"Rajapalayam", "Madurai", "Chennai","Coimbatore"};
    String x = "";
    String y = "";
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        StringBuilder result = new StringBuilder();
        final int[] mYear = new int[1];
        final int[] mMonth = new int[1];
        final int[] mDay = new int[1];
        final int[] mHour = new int[1];
        final int[] mMinute = new int[1];
        EditText name = findViewById(R.id.editTextTextPersonName2);
        EditText train = findViewById(R.id.editTextTextPersonName3);

        EditText txtDate = findViewById(R.id.editTextTextPersonName6);
        EditText txtTime = findViewById(R.id.editTextTextPersonName7);
        fromSP = findViewById(R.id.spinner);
        toSP = findViewById(R.id.spinner2);
        fromSP.setOnItemSelectedListener(this);
        ArrayAdapter ad = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, from);
        ad.setDropDownViewResource(
                android.R.layout
                        .simple_spinner_dropdown_item);
        fromSP.setAdapter(ad);
        toSP.setOnItemSelectedListener(this);
        ArrayAdapter ada = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, to);
        ada.setDropDownViewResource(
                android.R.layout
                        .simple_spinner_dropdown_item);
        toSP.setAdapter(ada);

        Button book = findViewById(R.id.button2);
        txtDate.setOnClickListener(new View.OnClickListener(){
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

                        txtDate.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                    }
                }, mYear[0], mMonth[0], mDay[0]);
                datePickerDialog.show();
            }

        });
        txtTime.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                final Calendar c = Calendar.getInstance();
                mHour[0] = c.get(Calendar.HOUR_OF_DAY);
                mMinute[0] = c.get(Calendar.MINUTE);

                // Launch Time Picker Dialog
                TimePickerDialog timePickerDialog = new TimePickerDialog(Home.this,
                        new TimePickerDialog.OnTimeSetListener() {

                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay,
                                                  int minute) {

                                txtTime.setText(hourOfDay + ":" + minute);
                            }
                        }, mHour[0], mMinute[0], false);
                timePickerDialog.show();
            }
      });
        book.setOnClickListener(view -> {
            result.append("Name : ").append(name.getText().toString()).append("\n");
            result.append("Train : ").append(train.getText().toString()).append("\n");
            result.append("Location From : ").append(fromSP.getSelectedItem().toString()).append("\n");
            result.append("Location To : ").append(toSP.getSelectedItem().toString()).append("\n");
            result.append("Date : ").append(txtDate.getText().toString()).append("\n");
            result.append("Time : ").append(txtTime.getText().toString()).append("\n");
            Intent i=new Intent(getApplicationContext(),Res.class);
            i.putExtra("v1",result.toString());
            startActivity(i);
        });
    }
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

        if(view==fromSP)
            x = from[i];
        else if(view==toSP)
            y=to[i];
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
