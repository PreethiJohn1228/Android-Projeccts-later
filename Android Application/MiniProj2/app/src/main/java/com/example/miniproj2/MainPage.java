package com.example.miniproj2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import androidx.appcompat.app.AppCompatActivity;

public class MainPage extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainpage);
        DBHelper db = new DBHelper(this);

        db.addDet(new Laws(1234567890,"Criminal","John","Theni","District Court","Robbery",
                "James","Done","Theni Court",
                "29-8-2019","2019","29-6-2019"," SECTION 390"));


        db.addDet(new Laws(1234567891,"Criminal","Ram","Chennai","High Court",
                "Death caused by act done with intent to cause miscarriage",
                "Yuvan","Incomplete","Chennai Court",
                "29-8-2019","2019","29-7-2019"," SECTION 314"));

        db.addDet(new Laws(1234567891,"Criminal","Rahul","Salem","District Court",
                "House-breaking by night",
                "Yuvan","Incomplete","Salem Court",
                "29-8-2019","2019","19-6-2019"," SECTION 446"));


        db.addDet(new Laws(1234567892,"Criminal","Ram","Chennai","District Court",
                "Cheating by personation",
                "Yuvan","Done","Theni High Court",
                "29-8-2019","2019","19-5-2019"," SECTION 416"));


        db.addDet(new Laws(1234567893,"Criminal","Laksh","Madurai","Subordinate Court",
                "Criminal breach of trust",
                "Harish","Done","Madurai Court",
                "29-8-2018","2018","29-8-2018"," SECTION 405"));


        db.addDet(new Laws(1234567894,"Criminal","Krish","Coimbatore","High Court","Dacoity",
                "Vijay","Incomplete","Kovai High Court",
                "29-2-2018","2018","29-7-2018"," SECTION 391"));


        db.addDet(new Laws(1234567895,"Criminal","Krish","Delhi","Supreme Court",
                "Punishment for assault or criminal force otherwise than on grave provocation",
                "Surya","Done","Indian Supreme Court",
                "29-1-2018","2018","29-6-2018"," SECTION 352"));


        db.addDet(new Laws(1234567896,"Civil","Ravi","Virudhunagar","High Court","Amount of fine",
                "Ajith","Incomplete","High Court",
                "29-4-2018","2018","29-5-2018"," SECTION 63"));


        db.addDet(new Laws(1234567897,"Civil","Ajay","Madurai","District Court","Omission",
                "Vishal","Done","District Court",
                "29-8-2017","2017","29-8-2017"," SECTION 33"));


        db.addDet(new Laws(1234567898,"Civil","Sam","Chennai","High Court","Public servant",
                "Jai","Incomplete","Theni High Court",
                "29-8-2017","2017","29-7-2017"," SECTION 21"));


        db.addDet(new Laws(1234567899,"Civil","Arun","Erode","Subordinate Court",
                "Wrongful gain",
                "Sai","Done","Erode Sub Court",
                "29-8-2017","2017","29-6-2017"," SECTION 23"));


        db.addDet(new Laws(1234567810,"Civil","Kannan","Thirunelveli","Supreme Court",
                "Servant of Government",
                "Diran","Incomplete","Thirunelveli Court",
                "29-8-2017","2017","29-5-2017"," SECTION 14"));


        db.addDet(new Laws(1234567811,"Civil","Kumar","Madurai","Supreme Court",
                "Document",
                "Diran","Incomplete","Madurai Court",
                "29-10-2020","2020","29-8-2020"," SECTION 29"));

        db.addDet(new Laws(1234567812,"Civil","Kannan","Dhindugal","High Court",
                " Property in possession of wife, clerk or servant",
                "Diran","Done","Dhindugal Court",
                "29-9-2020","2020","29-7-2020"," SECTION 27"));


        ImageButton b1=findViewById(R.id.imageButton3);
        ImageButton b2=findViewById(R.id.imageButton4);
        ImageButton b3=findViewById(R.id.imageButton5);
        ImageButton b4=findViewById(R.id.imageButton7);
        b1.setOnClickListener(v -> {
            Intent i=new Intent(getApplicationContext(), Cnr.class);
            startActivity(i);

        });
        b2.setOnClickListener(v -> {
            Intent i=new Intent(getApplicationContext(), Mycases.class);
            startActivity(i);

        });
        b3.setOnClickListener(v->{
            Intent i=new Intent(getApplicationContext(), Casestatus.class);
            startActivity(i);

        });
        b4.setOnClickListener(v->{
            Intent i=new Intent(getApplicationContext(), Causelist.class);
            startActivity(i);

        });
    }
}

