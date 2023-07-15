package com.example.miniproj2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Calendar;

public class Causelist extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    String arr[] = {" ","Civil", "Criminal"};
    String arr1[] = {" ","Incomplete", "Done"};
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.causelist);
        EditText editText = findViewById(R.id.editTextTextPersonName6);

        StringBuilder result = new StringBuilder();
        Spinner s = findViewById(R.id.spinner);
        Button b=findViewById(R.id.button4);
        Spinner s1 = findViewById(R.id.spinner3);
        s.setOnItemSelectedListener(this);
        ArrayAdapter a=new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item,arr);
        a.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s.setAdapter(a);

        s1.setOnItemSelectedListener(this);
        ArrayAdapter ar=new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item,arr1);
        ar.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s1.setAdapter(ar);
        b.setOnClickListener(v->{
            String cnr = editText.getText().toString();
            String casestatus = s1.getSelectedItem().toString();
            String casetype = s.getSelectedItem().toString();
            DBHelper db=new DBHelper(this);
            Laws L = db.getMod4(cnr,casestatus,casetype);
            if(L!=null) {
                result.append("CNR : ").append(L.cnr).append("\n");
                result.append("PARTY NAME : ").append(L.partyname).append("\n");
                result.append("ADVOCATE : ").append(L.advocate).append("\n");
                result.append("SECTION : ").append(L.section).append("\n");
                result.append("ACT : ").append(L.act).append("\n");
                result.append("TYPE OF COURT : ").append(L.typeofcourt).append("\n");
                result.append("CASE STATUS : ").append(L.casestatus).append("\n");
                result.append("CASE TYPE : ").append(L.casetype).append("\n");
                result.append("REGISTRATION DATE : ").append(L.regdate).append("\n");
                result.append("HEARING DATE : ").append(L.date).append("\n");
                result.append("YEAR : ").append(L.year).append("\n");
                result.append("COURT NAME : ").append(L.courtname).append("\n");
                result.append("DISTRICT : ").append(L.district).append("\n");
                Intent i=new Intent(getApplicationContext(),Cnr1.class);
                i.putExtra("v1",result.toString());
                startActivity(i);
            }
            else
            {
                Toast.makeText(getApplicationContext(),"No Records Available",Toast.LENGTH_SHORT).show();
            }

        });
    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);
    }
}
