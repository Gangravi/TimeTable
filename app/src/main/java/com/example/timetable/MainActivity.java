package com.example.timetable;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    public static Button buttonlogin;
    public static Button buttonsignup;
    private FirebaseAuth auth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonlogin=findViewById(R.id.login_button);
        buttonsignup=findViewById(R.id.signup_button);

        buttonlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v){
                v.setSelected(true);
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
                overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);

            }
        });



        buttonsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                v.setSelected(true);
                Intent intent=new Intent(MainActivity.this,SignupActivity.class);
                startActivity(intent);
                overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.slide_out_right);

            }
        });

        auth = FirebaseAuth.getInstance();

        if (auth.getCurrentUser() != null) {
            startActivity(new Intent(MainActivity.this, HomePage.class));
            finish();
        }

    }

    public void onResume(){
        super.onResume();
        // put your code here...
        buttonlogin.setSelected(false);
        buttonsignup.setSelected(false);
    }


}
