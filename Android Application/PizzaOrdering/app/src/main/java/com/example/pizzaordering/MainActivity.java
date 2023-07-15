package com.example.pizzaordering;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    StringBuilder str=new StringBuilder();
    String type[]={"Round","Ellipsoid","Triangle"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText ed1=findViewById(R.id.editTextTextPersonName);
        EditText ed2=findViewById(R.id.editTextTextPersonName2);
        CheckBox c1=findViewById(R.id.checkBox);
        CheckBox c2=findViewById(R.id.checkBox2);
        CheckBox c3=findViewById(R.id.checkBox3);
        CheckBox c4=findViewById(R.id.checkBox4);
        Spinner s=findViewById(R.id.spinner);
        ArrayAdapter a=new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item,type);
        a.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s.setAdapter(a);
        Button b=findViewById(R.id.button);
        b.setOnClickListener(v -> {
            if(!(c1.isChecked()||c2.isChecked()||c3.isChecked()||c4.isChecked())) {
                Toast.makeText(MainActivity.this, "Please Select a Topping", Toast.LENGTH_SHORT).show();

            }
            else if (ed1.getText().toString().equals("") || ed2.getText().toString().equals("")) {
                    Toast.makeText(MainActivity.this, "Please fill both name and number", Toast.LENGTH_SHORT).show();

                }

            else {
                str.append("Name : ").append(ed1.getText().toString()).append("\n");
                str.append("Phone no: ").append(ed2.getText().toString()).append("\n");
                str.append("Pizza Type ").append(s.getSelectedItem().toString()).append("\n").append("Toppings :");
                if (c1.isChecked()) {
                    str.append("Onions" + " ");
                }
                if (c2.isChecked()) {
                    str.append("Cheese" + " ");
                }
                if (c3.isChecked()) {
                    str.append("Spice" + " ");
                }
                if (c3.isChecked()) {
                    str.append("Fries" + " ");
                }
                Toast.makeText(getApplicationContext(), str, Toast.LENGTH_LONG).show();

            }});


    }
}