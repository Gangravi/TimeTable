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

    TextView t11,t21,t31,t41,t51,t61;
    TextView t12,t22,t32,t42,t52,t62;
    TextView t13,t23,t33,t43,t53,t63;
    TextView t14,t24,t34,t44,t54,t64;
    TextView t15,t25,t35,t45,t55,t65;
    TextView t16,t26,t36,t46,t56,t66;
    TextView t17,t27,t37,t47,t57,t67;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_table);


        t11 = findViewById(R.id.lecture11);
        t12 = findViewById(R.id.lecture12);
        t13 = findViewById(R.id.lecture13);
        t14 = findViewById(R.id.lecture14);
        t15 = findViewById(R.id.lecture15);
        t16 = findViewById(R.id.lecture16);
        t17 = findViewById(R.id.lecture17);

        t21 = findViewById(R.id.lecture21);
        t22 = findViewById(R.id.lecture22);
        t23 = findViewById(R.id.lecture23);
        t24 = findViewById(R.id.lecture24);
        t25 = findViewById(R.id.lecture25);
        t26 = findViewById(R.id.lecture26);
        t27 = findViewById(R.id.lecture27);

        t31 = findViewById(R.id.lecture31);
        t32 = findViewById(R.id.lecture32);
        t33 = findViewById(R.id.lecture33);
        t34 = findViewById(R.id.lecture34);
        t35 = findViewById(R.id.lecture35);
        t36 = findViewById(R.id.lecture36);
        t37 = findViewById(R.id.lecture37);

        t41 = findViewById(R.id.lecture41);
        t42 = findViewById(R.id.lecture42);
        t43 = findViewById(R.id.lecture43);
        t44 = findViewById(R.id.lecture44);
        t45 = findViewById(R.id.lecture45);
        t46 = findViewById(R.id.lecture46);
        t47 = findViewById(R.id.lecture47);


        t51 = findViewById(R.id.lecture51);
        t52 = findViewById(R.id.lecture52);
        t53 = findViewById(R.id.lecture53);
        t54 = findViewById(R.id.lecture54);
        t55 = findViewById(R.id.lecture55);
        t56 = findViewById(R.id.lecture56);
        t57 = findViewById(R.id.lecture57);

        t61 = findViewById(R.id.lecture61);
        t62 = findViewById(R.id.lecture62);
        t63 = findViewById(R.id.lecture63);
        t64 = findViewById(R.id.lecture64);
        t65 = findViewById(R.id.lecture65);
        t66 = findViewById(R.id.lecture66);
        t67 = findViewById(R.id.lecture67);

        ArrayList<Object> blockid = new ArrayList<Object>();

        blockid.add(t11);
        blockid.add(t12);
        blockid.add(t13);
        blockid.add(t14);
        blockid.add(t15);
        blockid.add(t16);
        blockid.add(t17);


        ArrayList<String> faculty = new ArrayList<String>();
        faculty.add("CC(AK)");
        faculty.add("DS(AD)");
        faculty.add("SC(SC)");
        faculty.add("AI(JP)");
        faculty.add("HV(SS)");

        Random rand =new Random();
        TextView obj;
        for(int i=0;i<7;i++)
        {
            obj = (TextView) blockid.get(rand.nextInt(blockid.size()));
            blockid.remove(obj);

            if(!faculty.isEmpty()) {
                String s = faculty.get(rand.nextInt(faculty.size()));
                obj.setText(s);

                faculty.remove(s);
            }
        }

        //Temp

        blockid.add(t21);
        blockid.add(t22);
        blockid.add(t23);
        blockid.add(t24);
        blockid.add(t25);
        blockid.add(t26);
        blockid.add(t27);

        faculty.add("CC(AK)");
        faculty.add("DS(AD)");
        faculty.add("SC(SC)");
        faculty.add("AI(JP)");
        faculty.add("HV(SS)");

        for(int i=0;i<7;i++)
        {
            obj = (TextView) blockid.get(rand.nextInt(blockid.size()));
            blockid.remove(obj);

            if(!faculty.isEmpty()) {
                String s = faculty.get(rand.nextInt(faculty.size()));
                obj.setText(s);

                faculty.remove(s);
            }


        }

        blockid.add(t31);
        blockid.add(t32);
        blockid.add(t33);
        blockid.add(t34);
        blockid.add(t35);
        blockid.add(t36);
        blockid.add(t37);

        faculty.add("CC(AK)");
        faculty.add("DS(AD)");
        faculty.add("SC(SC)");
        faculty.add("AI(JP)");
        faculty.add("HV(SS)");

        for(int i=0;i<7;i++)
        {
            obj = (TextView) blockid.get(rand.nextInt(blockid.size()));
            blockid.remove(obj);

            if(!faculty.isEmpty()) {
                String s = faculty.get(rand.nextInt(faculty.size()));
                obj.setText(s);

                faculty.remove(s);
            }

        }

//        blockid.add(t31);
//        blockid.add(t32);
//        blockid.add(t33);
//        blockid.add(t34);
//        blockid.add(t35);
//        blockid.add(t36);
//        blockid.add(t37);
//
//        faculty.add("CC(AK)");
//        faculty.add("DS(AD)");
//        faculty.add("SC(SC)");
//        faculty.add("AI(JP)");
//        faculty.add("HV(SS)");
//
//        for(int i=0;i<7;i++)
//        {
//            obj = (TextView) blockid.get(rand.nextInt(blockid.size()));
//            blockid.remove(obj);
//
//            if(!faculty.isEmpty()) {
//                String s = faculty.get(rand.nextInt(faculty.size()));
//                obj.setText(s);
//
//                faculty.remove(s);
//            }
//
//        }

        blockid.add(t41);
        blockid.add(t42);
        blockid.add(t43);
        blockid.add(t44);
        blockid.add(t45);
        blockid.add(t46);
        blockid.add(t47);

        faculty.add("CC(AK)");
        faculty.add("DS(AD)");
        faculty.add("SC(SC)");
        faculty.add("AI(JP)");
        faculty.add("HV(SS)");

        for(int i=0;i<7;i++)
        {
            obj = (TextView) blockid.get(rand.nextInt(blockid.size()));
            blockid.remove(obj);

            if(!faculty.isEmpty()) {
                String s = faculty.get(rand.nextInt(faculty.size()));
                obj.setText(s);

                faculty.remove(s);
            }

        }

        blockid.add(t51);
        blockid.add(t52);
        blockid.add(t53);
        blockid.add(t54);
        blockid.add(t55);
        blockid.add(t56);
        blockid.add(t57);

        faculty.add("CC(AK)");
        faculty.add("DS(AD)");
        faculty.add("SC(SC)");
        faculty.add("AI(JP)");
        faculty.add("HV(SS)");

        for(int i=0;i<7;i++)
        {
            obj = (TextView) blockid.get(rand.nextInt(blockid.size()));
            blockid.remove(obj);

            if(!faculty.isEmpty()) {
                String s = faculty.get(rand.nextInt(faculty.size()));
                obj.setText(s);

                faculty.remove(s);
            }

        }

        blockid.add(t61);
        blockid.add(t62);
        blockid.add(t63);
        blockid.add(t64);
        blockid.add(t65);
        blockid.add(t66);
        blockid.add(t67);

        faculty.add("CC(AK)");
        faculty.add("DS(AD)");
        faculty.add("SC(SC)");
        faculty.add("AI(JP)");
        faculty.add("HV(SS)");

        for(int i=0;i<7;i++)
        {
            obj = (TextView) blockid.get(rand.nextInt(blockid.size()));
            blockid.remove(obj);

            if(!faculty.isEmpty()) {
                String s = faculty.get(rand.nextInt(faculty.size()));
                obj.setText(s);

                faculty.remove(s);
            }

        }

    }
}