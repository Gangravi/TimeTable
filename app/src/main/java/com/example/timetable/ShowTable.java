package com.example.timetable;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class ShowTable extends AppCompatActivity {

    TextView t11;
    TextView t12;
    TextView t13;
    TextView t14;
    TextView t15;
    TextView t16;
    TextView t17;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_table);
        ArrayList<Object> blockid = new ArrayList<Object>();
        t11 = findViewById(R.id.lecture11);
        t12 = findViewById(R.id.lecture12);
        t13 = findViewById(R.id.lecture13);
        t14 = findViewById(R.id.lecture14);
        t15 = findViewById(R.id.lecture15);
        t16 = findViewById(R.id.lecture16);
        t17 = findViewById(R.id.lecture17);

        blockid.add(t11);
        blockid.add(t12);
        blockid.add(t13);
        blockid.add(t14);
        blockid.add(t15);
        blockid.add(t16);
        blockid.add(t17);

        Random rand =new Random();
        //System.out.println(blockid.get(rand.nextInt(blockid.size())));
        TextView obj = (TextView) blockid.get(rand.nextInt(blockid.size()));
        blockid.remove(obj);

        ArrayList<String> faculty = new ArrayList<String>();
        faculty.add("CC(AK)");
        faculty.add("DS(AD)");
        faculty.add("SC(SC)");
        faculty.add("AI(JP)");
        faculty.add("HV(S)");

        //String s = faculty.get(rand.faculty);
        obj.setText("DS");

    }
}
