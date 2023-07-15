package com.example.burgercalories;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    String arr[]={"Cheese Burger","Chicken Burger","Ham Burger"};
    TextView t;
    String arr2[]={"250","350","200"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Spinner s=findViewById(R.id.spinner);
        t=findViewById(R.id.textView4);
        CheckBox c1=findViewById(R.id.checkBox);
        CheckBox c2=findViewById(R.id.checkBox2);
        CheckBox c3=findViewById(R.id.checkBox3);
        RadioGroup r=findViewById(R.id.radioGroup);
        SeekBar sk=findViewById(R.id.seekBar);
        Button b=findViewById(R.id.button);
        s.setOnItemSelectedListener(this);
        ArrayAdapter a=new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item,arr);
        a.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s.setAdapter(a);
        b.setOnClickListener(v->{
            double calories=0.0;
            if(s.getSelectedItem()=="Cheese Burger")
            {
                calories+=250;
            }
            else if(s.getSelectedItem()=="Chicken Burger")
            {
                calories+=350;
            }
            else if(s.getSelectedItem()=="Ham Burger")
            {
                calories+=200;
            }
            if(c1.isChecked())
            {
                calories+=15;
            }
            if(c2.isChecked())
            {
                calories+=20;
            }
            if(c3.isChecked())
            {
                calories+=30;
            }
            if(r.getCheckedRadioButtonId()==R.id.radioButton)
            {
                calories+=100;
            }
            else if(r.getCheckedRadioButtonId()==R.id.radioButton2)
            {
                calories+=50;
            }
            calories+=sk.getProgress()*2.5;
            Toast.makeText(MainActivity.this,"Total Calories "+calories,Toast.LENGTH_LONG).show();
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        t.setText("Burger Calories "+arr2[position]);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}