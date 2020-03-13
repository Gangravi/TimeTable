package com.example.timetable;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class ShowDatabase extends AppCompatActivity implements AdapterView.OnItemSelectedListener{


    private Spinner spinner;
    Button button;
    private static final String[] semesters = {"Select Semester",
                                                "Semester 1", "Semester 2",
                                               "Semester 3", "Semester 4",
                                               "Semester 5", "Semester 6",
                                               "Semester 7", "Semester 8"};

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
        if(isEnabled(position))
        {
            Toast.makeText(getApplicationContext(), "Selected User: "+semesters[position] ,Toast.LENGTH_SHORT).show();

            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(ShowDatabase.this,Database.class);
                    String text = spinner.getSelectedItem().toString();
                    intent.putExtra("Semester",text);
                    startActivity(intent);
                    finish();
                }
            });
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO - Custom Code
    }



}