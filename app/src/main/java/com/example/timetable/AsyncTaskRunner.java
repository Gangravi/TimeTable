package com.example.timetable;

import android.os.AsyncTask;
import android.util.Log;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class AsyncTaskRunner extends AsyncTask<String, String, String> {

    private String value;

    @Override
    protected String doInBackground(String... params) {

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("app"); // fetch all student
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot snapshot:dataSnapshot.getChildren()){
                    Semester student = snapshot.getValue(Semester.class);
                    //Log.d("Child",""+student.getFaculty()+"-------->"+student.getLoad_hours()+"-------->"+student.getSubject());
//                        Toast.makeText(MainActivity.this, ""+student.getName(), Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        return value;
    }


    @Override
    protected void onPostExecute(String result) {

        //Log.d("himanshu",result);
    }

    @Override
    protected void onPreExecute() {

    }

    @Override
    protected void onProgressUpdate(String... text) {


    }
}
