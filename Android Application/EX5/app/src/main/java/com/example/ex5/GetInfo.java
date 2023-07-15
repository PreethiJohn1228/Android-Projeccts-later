package com.example.ex5;

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
            DataBaseHelper db=new DataBaseHelper(this);
            Books A = db.getBooks(name);
            if(A!=null) {
                t.setText(new StringBuilder().append("TITLE : ").append(A.title).append("\n").append("AUTHOR : ")
                        .append(A.author).append("\n").append("PRICE : ").append(A.price).append("\n").append("BORROWDATE : ")
                        .append(A.borrowdate).append("\n").append("RETURNDATE : ").append(A.returndate).append("\n")
                        .append("GENRE : ").append(A.genre).append("\n"));
            }
            else
            {
                Toast.makeText(getApplicationContext(),"No Records Available",Toast.LENGTH_SHORT).show();
            }
        });

    }
}
