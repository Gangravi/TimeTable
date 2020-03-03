package com.example.timetable;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ShowDatabase extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    ListView listView;
    List<Semester> semester;
    DatabaseReference databaseReference;

    private Spinner spinner;
    private static final String[] semesters = {"Select Semester",
                                                "semester 1", "semester 2",
                                               "semester 3", "semester 4",
                                               "semester 5", "semester 6",
                                               "semester 7", "semester 8"};

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_database);

        databaseReference = FirebaseDatabase.getInstance().getReference("app");
        semester =new ArrayList<>();
        listView = findViewById(R.id.listView);

        spinner = findViewById(R.id.spinner1);
        ArrayAdapter<String>adapter = new ArrayAdapter<String>(ShowDatabase.this,android.R.layout.simple_spinner_item,semesters);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

    }



    public boolean isEnabled(int position) {
        if (position == 0) {
            // Disable the first item from Spinner
            // First item will be use for hint
            return false;
        } else {
            return true;
        }
    }


    @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
        if(isEnabled(position))
        {
            Toast.makeText(getApplicationContext(), "Selected User: "+semesters[position] ,Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO - Custom Code
    }

    @Override
    protected void onStart() {
        super.onStart();
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                semester.clear();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {

                    Semester semester1 = snapshot.getValue(Semester.class);
                    semester.add(semester1);
                }

                SemesterData listAdapter = new SemesterData(ShowDatabase.this, semester);
                listView.setAdapter(listAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }

}