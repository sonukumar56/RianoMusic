package com.rianoMusicskb.rianomusic;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import java.util.Objects;

public class Login_page extends AppCompatActivity {
    private static final String PREFS_NAME ="MyPrefsFile" ;
    Button login_btn;
    EditText inpemail, login_password;
    FirebaseAuth auth;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Objects.requireNonNull(getSupportActionBar()).hide();
        super.onCreate(savedInstanceState);
        progressDialog=new ProgressDialog(this);
        progressDialog.setMessage("please wait..");
        progressDialog.setCancelable(false);

        setContentView(R.layout.login_page);
        login_btn = findViewById(R.id.login_btnn);
        inpemail = findViewById(R.id.inpemail);
        auth=FirebaseAuth.getInstance();
        login_password = findViewById(R.id.loginPassword);

        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressDialog.show();
                String email = inpemail.getText().toString();
                String pass = login_password.getText().toString();

                if(TextUtils.isEmpty(email)||TextUtils.isEmpty(pass)){
                    progressDialog.dismiss();
                    inpemail.setError("Enter the email or password");
                    Toast.makeText(Login_page.this, "Enter email and password", Toast.LENGTH_SHORT).show();

                }else if(TextUtils.isEmpty(pass)){
                    progressDialog.dismiss();
                    inpemail.setError("Enter the password");
                    Toast.makeText(Login_page.this, "Please Enter password", Toast.LENGTH_SHORT).show();

                }
//                else if(!email.matches(emailPattern)){
//                    progressDialog.dismiss();
//                    inpemail.setError("Enter valid email");
//
//
//                }
                else if(pass.length()<6){
                    progressDialog.dismiss();
                    login_password.setError("Enter strong password");


                }
                else{


                    auth.signInWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                progressDialog.dismiss();
                                    Toast.makeText(Login_page.this, "Succesfully login", Toast.LENGTH_SHORT).show();
                                    Intent intent=new Intent(Login_page.this, dashboard.class);
                                    intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP |Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
                                    startActivity(intent);
                                    finish();

                            }
                            else {
                                progressDialog.dismiss();
                                Toast.makeText(Login_page.this, "Incorrect Email or Password", Toast.LENGTH_SHORT).show();
                            }

                        }
                    });

                }




            }
        });


    }
}
