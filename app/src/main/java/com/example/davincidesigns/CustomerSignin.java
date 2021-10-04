package com.example.davincidesigns;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.work_byte.Database.DBHelper;


public class CustomerSignin extends AppCompatActivity{

    EditText cf_name, cl_name, cemail, cm_number, cwork_area, cpassword, cre_password;
    Button csign_up, csign_in;
    DBHelper DB;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_signin);

        cf_name = findViewById(R.id.f_name);
        cl_name = findViewById(R.id.l_name);
        cemail = findViewById(R.id.email);
        cm_number = findViewById(R.id.m_number);
        cwork_area = findViewById(R.id.work_area);
        cpassword = findViewById(R.id.password);
        cre_password = findViewById(R.id.re_password);
        csign_up = findViewById(R.id.btnsignup);
        csign_in = findViewById(R.id.btnlogsignin);
        DB = new DBHelper(this);


        csign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


//                String fname = f_name.getText().toString();
//                String lname = l_name.getText().toString();
//                String e_mail = email.getText().toString();
//                String mobile = m_number.getText().toString();
//                String workarea = work_area.getText().toString();
//                String p_word = password.getText().toString();
//                String re_p_word = re_password.getText().toString();

                if (cf_name.getText().toString().equals("") || cl_name.getText().toString().equals("") || cemail.getText().toString().equals("") || cm_number.getText().toString().equals("") || cwork_area.getText().toString().equals("") || cpassword.getText().toString().equals("") || cre_password.getText().toString().equals("")){
                    Toast.makeText(CustomerSignin.this, "Please enter all fields", Toast.LENGTH_SHORT).show();
                }
                else{
                    DBHelper dbHelper = new DBHelper(getApplicationContext());
                    dbHelper.insertCusData(cf_name.getText().toString(),
                            cl_name.getText().toString(),
                            cemail.getText().toString(),
                            cm_number.getText().toString(),
                            cwork_area.getText().toString(),
                            cpassword.getText().toString(),
                            cre_password.getText().toString());

                    if (cpassword.getText().toString().equals(cre_password.getText().toString())){
                        Boolean usercheck = DB.checkUseremail(cemail.getText().toString());
                        if (usercheck == false){
                          //  UserDetails.User newRowID = new UserDetails.User(f_name,l_name,
                            //        email,m_number,work_area,
                              //      password,re_password);
                            boolean insert = DB.insertCusData(cf_name.getText().toString(), cl_name.getText().toString() ,cemail.getText().toString(), cm_number.getText().toString(), cwork_area.getText().toString(), cpassword.getText().toString() ,cre_password.getText().toString());
                            if (insert == false){
                                Toast.makeText(CustomerSignin.this, "Registered Successfully", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                                startActivity(intent);
                            }else
                                Toast.makeText(CustomerSignin.this, "Registration Unsuccessful", Toast.LENGTH_SHORT).show();
                        }else
                            Toast.makeText(CustomerSignin.this, "Registered Successfully.", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                        startActivity(intent);
                    }else
                        Toast.makeText(CustomerSignin.this, "Passwords did not match", Toast.LENGTH_SHORT).show();
                }

            }
        });

        csign_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(CustomerSignin.this,CustomerLogin.class);
                startActivity(intent);
            }
        });
    }
}