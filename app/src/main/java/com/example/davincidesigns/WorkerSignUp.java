package com.example.davincidesigns;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.davincidesigns.Database.DBHelper;

public class WorkerSignUp extends AppCompatActivity {

    EditText f_name, l_name, email, m_number, work_area, password, re_password, address, experience;
    Button sign_up, sign_in;
    DBHelper DB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_worker_sign_up);

        f_name = findViewById(R.id.f_name);
        l_name = findViewById(R.id.l_name);
        email = findViewById(R.id.email);
        m_number = findViewById(R.id.m_number);
        work_area = findViewById(R.id.work_area);
        password = findViewById(R.id.password);
        re_password = findViewById(R.id.re_password);
        address = findViewById(R.id.address);
        experience = findViewById(R.id.experience);
        sign_up = findViewById(R.id.btnsignup);
        sign_in = findViewById(R.id.btnlogsignin);
        DB = new DBHelper(this);
        sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (f_name.getText().toString().equals("") || l_name.getText().toString().equals("") || email.getText().toString().equals("") || m_number.getText().toString().equals("") || work_area.getText().toString().equals("") || password.getText().toString().equals("") || re_password.getText().toString().equals("") || address.getText().toString().equals("") || experience.getText().toString().equals("")){
                    Toast.makeText(WorkerSignUp.this, "Please enter all fields", Toast.LENGTH_SHORT).show();
                }
                else{
                    DBHelper dbHelper = new DBHelper(getApplicationContext());
                    dbHelper.insertData(f_name.getText().toString().trim(),
                            l_name.getText().toString().trim(),
                            email.getText().toString().trim(),
                            m_number.getText().toString().trim(),
                            work_area.getText().toString().trim(),
                            password.getText().toString().trim(),
                            re_password.getText().toString().trim(),
                            address.getText().toString().trim(),
                            experience.getText().toString().trim());
//

                    if (password.getText().toString().equals(re_password.getText().toString())){
                        Boolean usercheck = DB.checkUseremail(email.getText().toString());
                        if (usercheck == false){
//                            UserDetails.User newRowID = new UserDetails.User(f_name,l_name,
//                                    email,m_number,work_area,
//                                    password,re_password);
                            boolean insert = DB.insertData(f_name.getText().toString(), l_name.getText().toString() ,email.getText().toString(), m_number.getText().toString(), work_area.getText().toString(), password.getText().toString() ,re_password.getText().toString(), address.getText().toString(), experience.getText().toString());
                            if (insert == false){

                                Toast.makeText(WorkerSignUp.this, "Registered Successfully", Toast.LENGTH_SHORT).show();
//                                Intent intent = new Intent(getApplicationContext(), WorkerProfileView.class);
//                                startActivity(intent);
                            }else
                                Toast.makeText(WorkerSignUp.this, "Registration Unsuccessful", Toast.LENGTH_SHORT).show();
                        }else
                            Toast.makeText(WorkerSignUp.this, "Registered Successfully.", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), WorkerLoging.class);
                        startActivity(intent);
                    }else
                        Toast.makeText(WorkerSignUp.this, "Passwords did not match", Toast.LENGTH_SHORT).show();
                }

            }
        });

        sign_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (getApplicationContext(), WorkerLoging.class);
                startActivity(intent);
            }
        });
    }
}