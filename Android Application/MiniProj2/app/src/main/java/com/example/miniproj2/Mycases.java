package com.example.miniproj2;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Calendar;

public class Mycases extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mycases);
        EditText t = findViewById(R.id.editTextTextPersonName9);
        EditText te = findViewById(R.id.editTextTextPersonName3);
        StringBuilder result = new StringBuilder();
        StringBuilder result1 = new StringBuilder();
        StringBuilder result2= new StringBuilder();
        StringBuilder result3 = new StringBuilder();
        StringBuilder result4 = new StringBuilder();
        Button b = findViewById(R.id.button6);

        b.setOnClickListener(v->{
            String partyname = t.getText().toString();
            String courtname = te.getText().toString();
            DBHelper db=new DBHelper(this);
            Laws L = db.getMod2(partyname,courtname);
            if(L!=null) {
                result.append("CNR : ").append(L.cnr).append("\n");
                result.append("CASE TYPE : ").append(L.casetype).append("\n");

                result1.append("PARTY NAME : ").append(L.partyname).append("\n");
                result1.append("ADVOCATE : ").append(L.advocate).append("\n");

                result2.append("SECTION : ").append(L.section).append("\n");
                result2.append("ACT : ").append(L.act).append("\n");

                result4.append("CASE STATUS : ").append(L.casestatus).append("\n");

                result3.append("REGISTRATION DATE : ").append(L.regdate).append("\n");
                result3.append("HEARING DATE : ").append(L.date).append("\n");

                Intent i=new Intent(getApplicationContext(),Mycases1.class);
                i.putExtra("v1",result.toString());
                i.putExtra("v2",result1.toString());
                i.putExtra("v3",result2.toString());
                i.putExtra("v4",result3.toString());
                i.putExtra("v5",result4.toString());
                startActivity(i);
            }
            else
            {
                Toast.makeText(getApplicationContext(),"No Records Available",Toast.LENGTH_SHORT).show();
            }

        });
    }
}
