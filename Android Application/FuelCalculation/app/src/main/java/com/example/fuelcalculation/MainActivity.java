package com.example.fuelcalculation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    String vehicle[]={"Car","Lorry","Bike"};
    String brand[]={"Maruti","Swift","Leyland","Eicher","Apache","Duke"};
    String v="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView ans = findViewById(R.id.textView4);
        Button b=findViewById(R.id.button);
        EditText e=findViewById(R.id.editTextNumberSigned);
        EditText e1=findViewById(R.id.editTextNumberSigned2);
        Spinner s=findViewById(R.id.spinner);
        Spinner s1=findViewById(R.id.spinner2);
        ArrayAdapter a=new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item,vehicle);
        a.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s.setAdapter(a);
        s.setOnItemSelectedListener(this);
        ArrayAdapter a1=new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item,brand);
        a1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s1.setAdapter(a1);
        s1.setOnItemSelectedListener(this);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double d=Double.parseDouble(e.getText().toString());
                double f=Double.parseDouble(e1.getText().toString());
                double Mileage=d/f;
                ans.setText("Mileage "+Double.toString(Mileage));

            }
        });

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        v=vehicle[position];

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}