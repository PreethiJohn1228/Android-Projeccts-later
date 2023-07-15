package com.example.sportsquo;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

public class GetInfo extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.getinfo);
        EditText e=findViewById(R.id.editTextTextPersonName);
        TextView t=findViewById(R.id.textView2);
        Button b=findViewById(R.id.button5);
        b.setOnClickListener(v -> {
            String name=e.getText().toString();
            DataBaseHandler db=new DataBaseHandler(this);
            Athlete A = db.getAthlete(name);
            if(A!=null) {
                t.setText(new StringBuilder().append("NAME : ").append(A.name).append("\n").append("AGE : ").append(A.age).append("\n").append("HEIGHT : ").append(A.height).append("\n").append("WEIGHT : ").append(A.weight).append("\n").append("MATCHES PLAYED : ").append(A.Matches_played).append("\n").append("MATCHES WON : ").append(A.Matches_Won).append("\n").append("BEST RATING : ").append(A.Best_Rating).append("\n").append("TITLE : ").append(A.titles).append("\n").toString());
            }
            else
            {
                Toast.makeText(getApplicationContext(),"No Records Available",Toast.LENGTH_SHORT).show();
            }
        });

    }
}
