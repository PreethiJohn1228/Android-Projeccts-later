package com.example.mileage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner spinner, spinner2;
    TextView tv1;
    EditText ed1;
    Button calc;

    String[] type = {"2-Wheeler", "4-Wheeler"};
    String[] twoWheelerBrands = {"Honda", "Hero", "Yamaha", "RE"};
    String[] fourWheelerBrands = {"Rolls Royce", "Audi", "Benz", "BMW"};
    int mileage = 1;
    HashMap<String, Integer> map = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Get References
        spinner = findViewById(R.id.spinner);
        spinner2 = findViewById(R.id.spinner2);
        tv1 = findViewById(R.id.textView4);
        ed1 = findViewById(R.id.editTextNumber);
        calc = findViewById(R.id.button);

//        Mark entries for HashMap
        map.put("Honda", 50);
        map.put("Hero", 40);
        map.put("Yamaha", 30);
        map.put("RE", 25);
        map.put("Rolls Royce", 10);
        map.put("Audi", 18);
        map.put("Benz", 23);
        map.put("BMW", 20);

//        Complete Spinner part
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, type);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        calc.setOnClickListener(view -> {
//        Get the distance
            int dist = Integer.parseInt(String.valueOf(ed1.getText()));
            double cost = (dist / mileage) * 100.0;
//        Print the cost of fuel consumption
            Toast.makeText(this, "Cost: " + cost, Toast.LENGTH_LONG).show();
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

        ArrayAdapter<String> adapter;
        if(i == 0) {
            adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, twoWheelerBrands);
        }else {
            adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, fourWheelerBrands);
        }
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter);
        mileage = map.get(String.valueOf(spinner2.getSelectedItem()));
        tv1.setText("Mileage: " + mileage);

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}

