package com.example.miniproj2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Search extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    String arr[] = {" ","2017", "2018", "2019", "2020" , "2021"};
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search);
        EditText editText = findViewById(R.id.editTextTextPersonName4);
        StringBuilder result = new StringBuilder();
        StringBuilder result2 = new StringBuilder();
        Spinner s = findViewById(R.id.spinner2);
        Button b=findViewById(R.id.button2);
        s.setOnItemSelectedListener(this);
        ArrayAdapter a=new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item,arr);
        a.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s.setAdapter(a);
        b.setOnClickListener(v->{
            String cnr = editText.getText().toString();
            String year = s.getSelectedItem().toString();
            DBHelper db=new DBHelper(this);
            Laws L = db.searchMod(cnr,year);

            if(L!=null) {
                result.append("CNR               : ").append(L.cnr).append("\n");
                result2.append("SECTION          : ").append(L.section).append("\n");
                result2.append("ACT              : ").append(L.act).append("\n");
                result2.append("CASE STATUS      : ").append(L.casestatus).append("\n");
                result.append("REGISTRATION DATE : ").append(L.regdate).append("\n");
                result.append("HEARING DATE      : ").append(L.date).append("\n");
                Intent i=new Intent(getApplicationContext(),Search1.class);
                i.putExtra("v1",result.toString());
                i.putExtra("v3",result2.toString());
                startActivity(i);
            }
            else
            {
                Toast.makeText(getApplicationContext(),"No Records Available",Toast.LENGTH_SHORT).show();
            }

        });
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
