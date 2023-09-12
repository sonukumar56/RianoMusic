package com.rianoMusicskb.rianomusic;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.PhoneNumberFormattingTextWatcher;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Calendar;
import java.util.regex.Pattern;

public class signup_page extends AppCompatActivity {
    EditText iemail,iusername;
    TextView edtdob;
ImageButton idatebirth;
    FirebaseFirestore db;
   static String email;
    static String username;
    static String dob;
    String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_page);
        iemail=findViewById(R.id.iemail);
        iusername=findViewById(R.id.iusername);
        idatebirth=findViewById(R.id.idatebirth);
        edtdob=findViewById(R.id.edtdob);
        db= FirebaseFirestore.getInstance();

        Calendar c=Calendar.getInstance();
        int day=c.get(Calendar.DAY_OF_MONTH);
        int year=c.get(Calendar.YEAR);
        int month=c.get(Calendar.MONTH);

        idatebirth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog=new DatePickerDialog(signup_page.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        if(year<2005&&year>1950){

                            edtdob.setText(dayOfMonth+"/" + (month+1) +"/" +year);
                        }else{
                            edtdob.setError("Enter valid date of birth");
                        }

                    }
                },year,month,day);
                datePickerDialog.show();


            }
        });

    }




    public void Nextbtn(View view) {
       email=iemail.getText().toString();
        username=iusername.getText().toString();
         dob=edtdob.getText().toString();
         if(email.isEmpty()){
             iemail.setError("Please Enter Email id");
         }else if(!email.matches(emailPattern)){
             iemail.setError("invalid email");
         }
         else{
             if(username.isEmpty()){
                 iusername.setError("please Enter Username");
             }
             else if(dob.isEmpty()){
                 edtdob.setError("please Enter Date of Birth");
             }else{
                     Intent intent=new Intent(signup_page.this,signup2.class);
                     startActivity(intent);
                     finish();
                 }

             }

         }


        //userModel data=new userModel(email,username,dob,name);

//        db.collection("user").document().set(data).addOnCompleteListener(new OnCompleteListener<Void>() {
//            @Override
//            public void onComplete(@NonNull Task<Void> task) {
//                    if(task.isSuccessful()){
//                        Toast.makeText(signup_page.this, "added ", Toast.LENGTH_SHORT).show();
//                        Intent intent=new Intent(signup_page.this,signup2.class);
//                        startActivity(intent);
//                    }else{
//                        Toast.makeText(signup_page.this, "error", Toast.LENGTH_SHORT).show();
//                    }
//
//
//            }
//        });

    }