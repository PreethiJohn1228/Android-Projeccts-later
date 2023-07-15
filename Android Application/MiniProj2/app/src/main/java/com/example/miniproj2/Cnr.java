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
import java.util.ArrayList;

public class Cnr extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    String arr[] = {" ","2017", "2018", "2019", "2020" , "2021"};
    //ArrayList<String> list=new ArrayList<String>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cnr);
        EditText editText = findViewById(R.id.editTextTextPersonName4);
        StringBuilder result = new StringBuilder();
        StringBuilder result1 = new StringBuilder();
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
            Laws L = db.getMod1(cnr,year);
            //String c=list.get(0);
            //String y=list.get(10);
            if(L!=null) {
                result.append("CNR              : ").append(L.cnr).append("\n");
                result1.append("PARTY NAME       : ").append(L.partyname).append("\n");
                result1.append("ADVOCATE         : ").append(L.advocate).append("\n");
                result2.append("SECTION          : ").append(L.section).append("\n");
                result2.append("ACT              : ").append(L.act).append("\n");
                //result.append("TYPE OF COURT    : ").append(L.typeofcourt).append("\n");
                result2.append("CASE STATUS      : ").append(L.casestatus).append("\n");
                //result.append("CASE TYPE        : ").append(L.casetype).append("\n");
                result.append("REGISTRATION DATE: ").append(L.regdate).append("\n");
                result.append("HEARING DATE     : ").append(L.date).append("\n");
                //result.append("YEAR             : ").append(L.year).append("\n");
                //result.append("COURT NAME       : ").append(L.courtname).append("\n");
                //result.append("DISTRICT         : ").append(L.district).append("\n");
                Intent i=new Intent(getApplicationContext(),Cnr1.class);
                i.putExtra("v1",result.toString());
                i.putExtra("v2",result1.toString());
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
