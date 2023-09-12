package com.rianoMusicskb.rianomusic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.ktx.Firebase;

public class dashboard extends AppCompatActivity {
        FirebaseAuth auth;
        Button logoutbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dashboard);
        logoutbtn=findViewById(R.id.logoutbtn);
        auth = FirebaseAuth.getInstance();
        if (auth.getCurrentUser() == null) {
            startActivity(new Intent(dashboard.this, MainActivity.class));
            finish();
        }

        logoutbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                auth.signOut();
                startActivity(new Intent(dashboard.this, MainActivity.class));
                finish();
            }
        });
    }

}