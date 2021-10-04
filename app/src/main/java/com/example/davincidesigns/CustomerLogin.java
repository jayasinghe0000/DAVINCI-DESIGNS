package com.example.davincidesigns;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.work_byte.Database.DBHelper;

public class CustomerLogin extends AppCompatActivity {

    private EditText email, password;
    private Button signincc, signupcc;
    DBHelper DB;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_login);

        email =  findViewById(R.id.loginemailt);
        password = findViewById(R.id.loginpasswordt);

        signincc = (Button) findViewById(R.id.btn_cussignin);
        signupcc = (Button) findViewById(R.id.btn_cussign);

        DB = new DBHelper(this);


        signincc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String loginemail = email.getText().toString();
                String pword = password.getText().toString();


                if (loginemail.equals("") || pword.equals(""))
                    Toast.makeText(CustomerLogin.this, "Please enter all fields.", Toast.LENGTH_SHORT).show();
                else{
                    Boolean checkUserPass = DB.checkEmailPasswordCus(loginemail,pword);
                    if (checkUserPass == true){

                        Toast.makeText(CustomerLogin.this, "Sign in successful", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), CustomerProfile.class);
                        intent.putExtra("LoginEmail",loginemail);
                        startActivity(intent);
                    }else{
                        //Toast.makeText(CustomerLogin.this, "Invalid email or password!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        signupcc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // Intent intent = new Intent (CustomerLogin.this, CustomerSignin.class);
                //startActivity(intent);
                startActivity(new Intent(CustomerLogin.this, com.example.work_byte.CustomerSignin.class));
            }


        });


    }
}