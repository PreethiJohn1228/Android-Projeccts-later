package com.example.miniproj2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.TreeMap;

public class Login1 extends AppCompatActivity {
    TreeMap<String, String> map = new TreeMap<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginlaw);
        Bundle extras = getIntent().getExtras();
        String u = extras.getString("v1");
        String p = extras.getString("v2");
        if(!u.equals("")){
            map.put(u,p);
        }
        Button b = findViewById(R.id.button);
        map.put("Raji", "1205");
        EditText e1 = findViewById(R.id.editTextTextPersonName2);
        EditText e2 = findViewById(R.id.editTextTextPassword);
        e1.setText("");
        e2.setText("");
        b.setOnClickListener(v -> {
            String usrname = String.valueOf(e1.getText());
            String pwd = e2.getText().toString();
            if (map.containsKey(usrname)) {
                if (!map.get(usrname).equals(pwd)) {
                    AlertDialog.Builder b1 = new AlertDialog.Builder(Login1.this);
                    b1.setTitle("Password Invalid!");
                    b1.setCancelable(false);
                    b1.setPositiveButton("Retry", (dialog, which) -> dialog.cancel());
                    AlertDialog a = b1.create();
                    a.show();
                } else {
                    //Main Page
                    Intent i = new Intent(getApplicationContext(), MainPagelaw.class);
                    i.putExtra("v1", usrname);
                    i.putExtra("v2", pwd);
                    startActivity(i);

                }
            } else {
                AlertDialog.Builder builder = new AlertDialog.Builder(Login1.this);
                builder.setTitle("UserName Invalid!");
                builder.setCancelable(true);
                builder.setPositiveButton("Retry", (dialog, which) -> dialog.cancel());
                AlertDialog al = builder.create();
                al.show();
            }

        });

    }
}