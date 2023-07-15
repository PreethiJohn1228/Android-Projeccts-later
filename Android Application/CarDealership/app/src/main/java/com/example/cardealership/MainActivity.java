package com.example.cardealership;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
    StringBuilder str=new StringBuilder();
    String tenure[]={"2","3","4"};
    static int count=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText ed1=findViewById(R.id.editTextTextPersonName);
        EditText ed2=findViewById(R.id.editTextTextPersonName2);
        EditText ed3=findViewById(R.id.editTextTextPersonName3);
        EditText ed4=findViewById(R.id.editTextTextPersonName4);
        Spinner s=findViewById(R.id.spinner);
        Button b=findViewById(R.id.button);
        ArrayAdapter a=new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item,tenure);
        a.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s.setAdapter(a);
        b.setOnClickListener(v->{
            count++;
            double principal=Double.parseDouble(ed4.getText().toString());
            double rate=0.09;
            double ten= Double.parseDouble(String.valueOf(s.getSelectedItem()));
            double interest=principal*rate*ten;
            double tax=0.07;
            interest+=interest*0.7;
            str.append("SNO             : ").append(count).append("\n");
            str.append("NAME            : ").append(ed1.getText().toString()).append("\n");
            str.append("PH NO           : ").append(ed2.getText().toString()).append("\n");
            str.append("PRINCIPAL       : ").append(ed4.getText().toString()).append("\n");
            str.append("DOWN PAYMENT    : ").append(ed3.getText().toString()).append("\n");
            str.append("TENURE          : ").append(s.getSelectedItem().toString()).append("\n");
            str.append("INTEREST        : ").append(interest).append("\n").append("\n").append("\n");
            Intent i=new Intent(getApplicationContext(),SecondActivity.class);
            i.putExtra("v1",str.toString());
            startActivity(i);

        });

    }
}