package com.example.ex5;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class Insert extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.insert);
        final int[] mYear = new int[1];
        final int[] mMonth = new int[1];
        final int[] mDay = new int[1];
        final int[] mHour = new int[1];
        final int[] mMinute = new int[1];
        EditText txtDate = findViewById(R.id.editTextTextPersonName3);
        EditText txtDate1 = findViewById(R.id.editTextTextPersonName11);
        EditText e1=findViewById(R.id.editTextTextPersonName7); //id
        EditText e2=findViewById(R.id.editTextTextPersonName10); //title
        EditText e3=findViewById(R.id.editTextTextPersonName8);   //author
        EditText e4=findViewById(R.id.editTextTextPersonName9);     //price
        EditText e7=findViewById(R.id.editTextTextPersonName12);    //genre
        txtDate.setOnClickListener(view -> {
            final Calendar c = Calendar.getInstance();
            mYear[0] = c.get(Calendar.YEAR);
            mMonth[0] = c.get(Calendar.MONTH);
            mDay[0] = c.get(Calendar.DAY_OF_MONTH);


            DatePickerDialog datePickerDialog;
            datePickerDialog = new DatePickerDialog(Insert.this, new DatePickerDialog.OnDateSetListener() {

                @Override
                public void onDateSet(DatePicker view, int year,
                                      int monthOfYear, int dayOfMonth) {

                    txtDate.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                }
            }, mYear[0], mMonth[0], mDay[0]);
            datePickerDialog.show();
        });
        txtDate1.setOnClickListener(view -> {
            final Calendar c = Calendar.getInstance();
            mYear[0] = c.get(Calendar.YEAR);
            mMonth[0] = c.get(Calendar.MONTH);
            mDay[0] = c.get(Calendar.DAY_OF_MONTH);


            DatePickerDialog datePickerDialog;
            datePickerDialog = new DatePickerDialog(Insert.this, new DatePickerDialog.OnDateSetListener() {

                @Override
                public void onDateSet(DatePicker view, int year,
                                      int monthOfYear, int dayOfMonth) {

                    txtDate1.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                }
            }, mYear[0], mMonth[0], mDay[0]);
            datePickerDialog.show();
        });
        Button b=findViewById(R.id.button3);
        b.setOnClickListener(v -> {
            DataBaseHelper db=new DataBaseHelper(this);
            String id=e1.getText().toString();
            String title=e2.getText().toString();
            String author=e3.getText().toString();
            int price=Integer.parseInt(e4.getText().toString());
            String borrowdate = txtDate.getText().toString();
            String returndate = txtDate1.getText().toString();
            String genre=e7.getText().toString();
            Books a=new Books(title,author,price,borrowdate,returndate,genre);
            db.addBook(a);
            Toast.makeText(getApplicationContext(),"Inserted Successfully!", Toast.LENGTH_SHORT).show();

        });


    }
}
