package com.example.carspecs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    String cars[]={"---Select Any Car---","Honda Accord","Honda Civic","Toyota Corolla","Chevrolet Corvette","Ford Taurus"};
    Spinner s;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        s=findViewById(R.id.spinner);
        ArrayAdapter a=new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item,cars);
        a.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s.setOnItemSelectedListener(this);
        s.setAdapter(a);
        ;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if(s.getSelectedItem()=="Honda Accord")
        {
            Intent i=new Intent(getApplicationContext(),Accord.class);
            startActivity(i);

        }
        if(s.getSelectedItem()=="Honda Civic")
        {
            Intent i=new Intent(getApplicationContext(),Civic.class);
            startActivity(i);

        }
        if(s.getSelectedItem()=="Toyota Corolla")
        {
            Intent i=new Intent(getApplicationContext(),Corolla.class);
            startActivity(i);
        }
        if(s.getSelectedItem()=="Ford Taurus")
        {
            Intent i=new Intent(getApplicationContext(),Ford.class);
            startActivity(i);

        }
        if(s.getSelectedItem()=="Chevrolet Corvette")
        {
            Intent i=new Intent(getApplicationContext(),Chev.class);
            startActivity(i);

        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}