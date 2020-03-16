package com.example.timetable;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class ShowDatabase extends AppCompatActivity implements AdapterView.OnItemSelectedListener{


    private Spinner spinner,spinner1;
    Button button;
    private static final String[] courses = {"Select Course","Btech"};
    private static final String[] semesters = {"Select Semester",
                                                "Semester 1", "Semester 2",
                                               "Semester 3", "Semester 4",
                                               "Semester 5", "Semester 6",
                                               "Semester 7", "Semester 8"};

    String text1,text;
    @Override
    protected void onCreate(final Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_database);

        button = findViewById(R.id.submit);

        spinner = findViewById(R.id.spinner);
        ArrayAdapter<String>adapter = new ArrayAdapter<String>(ShowDatabase.this,android.R.layout.simple_spinner_item,semesters);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        spinner1 = findViewById(R.id.spinner1);
        ArrayAdapter<String>adapter1 = new ArrayAdapter<String>(ShowDatabase.this,android.R.layout.simple_spinner_item,courses);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter1);
        spinner1.setOnItemSelectedListener(this);


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
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


        switch (arg0.getId()){

            case R.id.spinner1:
                if(isEnabled(position)){
                    text1 = spinner1.getSelectedItem().toString();
                }

                break;
            case R.id.spinner:

                if(isEnabled(position))
                {
                    text = spinner.getSelectedItem().toString();

                }

                break;
        }
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ShowDatabase.this,Database.class);
                Bundle extras = new Bundle();
                extras.putString("Semester",text);
                extras.putString("Course",text1);
                intent.putExtras(extras);
                startActivity(intent);
                finish();
            }
        });

    }



    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO - Custom Code
    }

}