package com.example.miniproj2;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


public class Modify extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.modify);
        EditText e1=findViewById(R.id.editTextTextPersonName10);
        EditText e2=findViewById(R.id.editTextTextPersonName11);
        EditText e3=findViewById(R.id.editTextTextPersonName12);
        Button b=findViewById(R.id.button3);
        b.setOnClickListener(v ->{
            DBHelper db=new DBHelper(this);
            String partyname=e1.getText().toString();
            String casestatus=e2.getText().toString();
            String courttype=e3.getText().toString();

            Laws a=new Laws(partyname,casestatus,courttype);
            db.updateLaws(a);
            Toast.makeText(getApplicationContext(),"Updated Successfully!",Toast.LENGTH_SHORT).show();
        });


    }


}



