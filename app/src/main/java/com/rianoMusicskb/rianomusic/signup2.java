package com.rianoMusicskb.rianomusic;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;

import java.lang.ref.Reference;

public class signup2 extends AppCompatActivity {
    FirebaseFirestore db;
    EditText edtname,edtpassword;
    String name ,password;
    String email=signup_page.email;
    String username=signup_page.username;
    String dob=signup_page.dob;
    FirebaseAuth auth;
    FirebaseDatabase database;
    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup2);
        auth=FirebaseAuth.getInstance();
        database=FirebaseDatabase.getInstance();
        db= FirebaseFirestore.getInstance();
        edtname=findViewById(R.id.edtname);
        edtpassword=findViewById(R.id.edtpassword);

        progressDialog=new ProgressDialog(this);
        progressDialog.setMessage("please wait..");
        progressDialog.setCancelable(false);

    }

    public void resister(View view) {

        progressDialog.show();
        name=edtname.getText().toString();
        password=edtpassword.getText().toString();


        if(name.isEmpty()){
            progressDialog.dismiss();
            edtname.setError("Please enter name ");
        }else if(password.isEmpty()||password.length()<6){
            progressDialog.dismiss();
            edtpassword.setError("Please Enter Password");
        }
        else{
            auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful()){
                        progressDialog.dismiss();
                        DatabaseReference reference=database.getReference().child("user").child(auth.getUid());
                        userModel data=new userModel(auth.getUid(),email,username,dob,name,password);
                        reference.setValue(data).addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if(task.isSuccessful()){
                                    progressDialog.dismiss();
                                    Toast.makeText(signup2.this, "Succesfully Register", Toast.LENGTH_SHORT).show();
                                    Intent intent=new Intent(signup2.this,dashboard.class);
                                        startActivity(intent);
                                        finish();
                                }
                                else{
                                    progressDialog.dismiss();
                                    Toast.makeText(signup2.this, "Failed", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });

                    }
                    else{
                        progressDialog.dismiss();
                        Toast.makeText(signup2.this, "Email id Already Register", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }




//        db.collection("user").document().set(data).addOnCompleteListener(new OnCompleteListener<Void>() {
//            @Override
//            public void onComplete(@NonNull Task<Void> task) {
//                if(task.isSuccessful()){
//                    Toast.makeText(signup2.this, "Sab theek hai Bro", Toast.LENGTH_SHORT).show();
//                    Intent intent=new Intent(signup2.this,overlayScreen.class);
//                    startActivity(intent);
//                }
//                else{
//                    Toast.makeText(signup2.this, "kuch gadbad hai bhai", Toast.LENGTH_SHORT).show();
//                }
//            }
//        });
//

    }
}