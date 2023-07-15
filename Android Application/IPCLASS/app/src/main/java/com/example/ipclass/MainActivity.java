package com.example.ipclass;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText e=findViewById(R.id.etUsername);
        Button b=findViewById(R.id.button);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 String IP=e.getText().toString();
                String zeroTo255
                        = "(\\d{1,2}|(0|1)\\"
                        + "d{2}|2[0-4]\\d|25[0-5])";

                // Regex for a digit from 0 to 255 and
                // followed by a dot, repeat 4 times.
                // this is the regex to validate an IP address.
                String regex
                        = zeroTo255 + "\\."
                        + zeroTo255 + "\\."
                        + zeroTo255 + "\\."
                        + zeroTo255;
                Pattern p = Pattern.compile(regex);
                Matcher m=p.matcher(IP);
                if(m.matches())
                {
                    String Line[]=IP.split("\\.");
                    int one=Integer.parseInt(Line[0]);
                    if(one>0&&one<=127)
                    {
                        Toast.makeText(getApplicationContext(),"CLASS A",Toast.LENGTH_SHORT).show();
                    }
                    else if(one>127&&one<=191)
                    {
                        Toast.makeText(getApplicationContext(),"CLASS B",Toast.LENGTH_SHORT).show();
                    }
                    else if(one>191&&one<=223)
                    {
                        Toast.makeText(getApplicationContext(),"CLASS C",Toast.LENGTH_SHORT).show();
                    }
                    else if(one>223&&one<=239)
                    {
                        Toast.makeText(getApplicationContext(),"CLASS D",Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(),"CLASS E",Toast.LENGTH_SHORT).show();
                    }
                }
                else
                {
                    AlertDialog.Builder b=new AlertDialog.Builder(MainActivity.this);
                    b.setTitle("INVALID IP!");
                    b.setPositiveButton("RETRY", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    });
                    AlertDialog a= b.create();
                    a.show();

                }


            }
        });
    }
}