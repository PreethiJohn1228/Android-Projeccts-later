package com.example.emi;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    String[] Loan = {"HOME", "CAR", "EDUCATION","PROPERTY"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText ed1=findViewById(R.id.editTextNumber);
        EditText ed2=findViewById(R.id.editTextNumberSigned);
        Spinner s=findViewById(R.id.spinner);
        Button b=findViewById(R.id.button);
        SeekBar s1=findViewById(R.id.seekBar);
        s.setOnItemSelectedListener(this);
        ArrayAdapter ad = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, Loan);
        ad.setDropDownViewResource(
                android.R.layout
                        .simple_spinner_dropdown_item);
        s.setAdapter(ad);
        s1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Toast.makeText(getApplicationContext(),"seekbar progress: "+progress, Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 double P=Double.parseDouble(ed1.getText().toString());
                double y=Double.parseDouble(ed2.getText().toString());
                y=y*12;
                double r=s1.getProgress()/12.00;
                r=r/100.00;
                double term1=P*r;
                double term2=((Math.pow(1+r,y))/(Math.pow(1+r,y)-1));
                double emi=term1*term2;
                emi=Math.round((emi*100.0)/100.0);

                AlertDialog.Builder b=new AlertDialog.Builder(MainActivity.this);
                b.setTitle("EMI");
                b.setMessage("You have to pay a sum of "+emi+" every Month");
                b.setCancelable(true);
                b.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                AlertDialog a=b.create();
                a.show();

            }
        });


    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(getApplicationContext(),Loan[position],Toast.LENGTH_SHORT).show();



    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}