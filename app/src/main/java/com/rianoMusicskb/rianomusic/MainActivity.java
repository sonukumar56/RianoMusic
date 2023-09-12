package com.rianoMusicskb.rianomusic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    TextView logscreen;
    FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        logscreen=findViewById(R.id.loginScreen_btn);
        auth = FirebaseAuth.getInstance();
        if (auth.getCurrentUser()!= null) {
            startActivity(new Intent(MainActivity.this,dashboard.class));
            finish();
        }

        logscreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,Login_page.class));
                finish();
            }
        });

    }

    public void signupbtn(View view) {
        Intent intent=new Intent(MainActivity.this,signup_page.class);
        startActivity(intent);
        finish();

    }
}