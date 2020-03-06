package com.example.timetable;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class AddFaculty extends AppCompatActivity {

     EditText faculty,subject,load;
     Button save,back;
     String passedArg;
     int count=0;
     DatabaseReference databaseReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_faculty);

        passedArg = getIntent().getExtras().getString("Semester");

        faculty = findViewById(R.id.et1);
        subject = findViewById(R.id.et2);
        load = findViewById(R.id.et3);
        save = findViewById(R.id.button);
        back = findViewById(R.id.back);

//        databaseReference = FirebaseDatabase.getInstance().getReference().child("app").child(passedArg);
//        databaseReference.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//                if(dataSnapshot.exists())
//                    count= (int) dataSnapshot.getChildrenCount();
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        });

        databaseReference = FirebaseDatabase.getInstance().getReference("app");

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addFaculty();
            }
        });


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AddFaculty.this,Database.class);
                startActivity(intent);
                finish();
            }
        });
    }

    public void addFaculty()
    {
        String faculty_name = faculty.getText().toString().trim();
        String subject_name = subject.getText().toString().trim();
        String load_hours = load.getText().toString().trim();
        String id = databaseReference.push().getKey();

        if(TextUtils.isEmpty(faculty_name)){
            Toast.makeText(this, "Please enter the Faculty Name", Toast.LENGTH_SHORT).show();
            return;
        }

        if(TextUtils.isEmpty(subject_name)){
            Toast.makeText(this, "Please enter the Subject Name", Toast.LENGTH_SHORT).show();
            return;
        }

        if(TextUtils.isEmpty(load_hours)){
            Toast.makeText(this, "Please enter the Load Hours", Toast.LENGTH_SHORT).show();
            return;
        }

        FacultyModel facultyModel = new FacultyModel(id,faculty_name,subject_name,load_hours);
        //int check= count+1;
        databaseReference.child(passedArg).child(id).setValue(facultyModel);
        faculty.setText("");
        subject.setText("");
        load.setText("");
        Toast.makeText(this, "Faculty Added", Toast.LENGTH_SHORT).show();
    }


}
