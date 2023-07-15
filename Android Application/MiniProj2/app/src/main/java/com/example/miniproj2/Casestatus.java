package com.example.miniproj2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Casestatus extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.casestatus);
        EditText t = findViewById(R.id.editTextTextPersonName7);
        EditText t1 = findViewById(R.id.editTextTextPersonName8);
        StringBuilder result = new StringBuilder();
        Button b = findViewById(R.id.button5);
        b.setOnClickListener(v->{
            String partyname = t.getText().toString();
            String advocate = t1.getText().toString();
            DBHelper db=new DBHelper(this);
            Laws L = db.getMod3(partyname,advocate);
            //String c=list.get(0);
            //String y=list.get(10);
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
                Intent i=new Intent(getApplicationContext(),Casestatus1.class);
                i.putExtra("v1",result.toString());
                startActivity(i);
            }
            else
            {
                Toast.makeText(getApplicationContext(),"No Records Available",Toast.LENGTH_SHORT).show();
            }

        });
    }
}
