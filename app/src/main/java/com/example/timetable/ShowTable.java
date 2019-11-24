package com.example.timetable;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class ShowTable extends AppCompatActivity {
    private FirebaseDatabase mDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference mGetReference = mDatabase.getReference();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_table);

        mGetReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                if (dataSnapshot.exists()){
                    HashMap<String, Object> dataMap = (HashMap<String, Object>) dataSnapshot.getValue();

                    for (String key : dataMap.keySet()){

                        Object data = dataMap.get(key);

                        try{
                            HashMap<String, Object> userData = (HashMap<String, Object>) data;

                            User mUser = new User((String) userData.get("name"), (int) (long) userData.get("age"));
                            addTextToView(mUser.getName() + " - " + Integer.toString(mUser.getAge()));

                        }catch (ClassCastException cce){

// If the object can’t be casted into HashMap, it means that it is of type String.

                            try{

                                String mString = String.valueOf(dataMap.get(key));
                                addTextToView(mString);

                            }catch (ClassCastException cce2){

                            }
                        }

                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }
}
