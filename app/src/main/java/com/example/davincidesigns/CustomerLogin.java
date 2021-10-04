package com.example.davincidesigns;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.davincidesigns.Database.DBHelper;

public class CustomerLogin extends AppCompatActivity {

    EditText email, password;
    Button signin, signup;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_worker_loging);

        email = (EditText) findViewById(R.id.loginemailt);
        password = (EditText) findViewById(R.id.loginpasswordt);

        signin = (Button) findViewById(R.id.btnsignin);
        signup = (Button) findViewById(R.id.btnlogsignin);

        DB = new DBHelper(this);


        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String loginemail = email.getText().toString();
                String pword = password.getText().toString();


                if (loginemail.equals("") || pword.equals(""))
                    Toast.makeText(WorkerLoging.this, "Please enter all fields.", Toast.LENGTH_SHORT).show();
                else{
                    Boolean checkUserPass = DB.checkEmailPassword(loginemail,pword);
                    if (checkUserPass == true){

                        Toast.makeText(WorkerLoging.this, "Sign in successful", Toast.LENGTH_SHORT).show();
//                        Intent intent = new Intent(getApplicationContext(), WorkerProfileView.class);
//                        startActivity(intent);
                    }else{
                        Toast.makeText(WorkerLoging.this, "Invalid email or password!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (WorkerLoging.this, WorkerSignUp.class);
                startActivity(intent);
            }
        });

    }
}