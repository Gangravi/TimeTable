package com.example.timetable;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Database extends AppCompatActivity {

    TextView semester_name;
    Button button;
    String passedArg;

    ListView listView;
    List<FacultyModel> faculties;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database);


        passedArg = getIntent().getExtras().getString("Semester");

        faculties = new ArrayList<>();
        listView = findViewById(R.id.listview);

        semester_name = findViewById(R.id.sem_name);
        button = findViewById(R.id.button_add);
        semester_name.setText(passedArg);

        if (passedArg.equals("Semester 1"))
            passedArg = "Semester_1";
        if (passedArg.equals("Semester 2"))
            passedArg = "Semester_2";
        if (passedArg.equals("Semester 3"))
            passedArg = "Semester_3";
        if (passedArg.equals("Semester 4"))
            passedArg = "Semester_4";
        if (passedArg.equals("Semester 5"))
            passedArg = "Semester_5";
        if (passedArg.equals("Semester 6"))
            passedArg = "Semester_6";
        if (passedArg.equals("Semester 7"))
            passedArg = "Semester_7";
        if (passedArg.equals("Semester 8"))
            passedArg = "Semester_8";


        databaseReference = FirebaseDatabase.getInstance().getReference().child("app").child(passedArg);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Database.this, AddFaculty.class);
                intent.putExtra("Semester", passedArg);
                startActivity(intent);
            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                FacultyModel facultyModel = faculties.get(i);
                showUpdateDeleteDialog(facultyModel.getFaculty_id(), facultyModel.getFaculty_name());
                return true;
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                faculties.clear();

                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {

                    FacultyModel faculty1 = postSnapshot.getValue(FacultyModel.class);
                    faculties.add(faculty1);
                }

                FacultyAdapter listAdapter = new FacultyAdapter(Database.this, faculties);
                listView.setAdapter(listAdapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    private boolean deleteFaculty(String id)
    {

        DatabaseReference databaseReference1 = FirebaseDatabase.getInstance().getReference().child("app").child(passedArg).child(id);
        databaseReference1.removeValue();

        Toast.makeText(this, "Faculty Deleted", Toast.LENGTH_SHORT).show();

        return true;
    }

    private void showUpdateDeleteDialog(final String facultyId, String facultyName)
    {

        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.delete_dialog, null);
        dialogBuilder.setView(dialogView);

        final Button buttonDelete = dialogView.findViewById(R.id.delete);

        dialogBuilder.setTitle("Delete "+facultyName);
        final AlertDialog b = dialogBuilder.create();
        b.show();

        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                deleteFaculty(facultyId);
                b.dismiss();

            }
        });

    }
}
