package com.example.davincidesigns;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.work_byte.Database.DBHelper;

public class EditCustomerProfile extends AppCompatActivity {

    EditText e_mail, M_number, work_Area, Password, Re_password, Address, Experience;
    Button save, confirm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_customer_profile);

        e_mail = findViewById(R.id.emailsearch);
        M_number = findViewById(R.id.tele_edit);
        Address = findViewById(R.id.address_edit);
        work_Area = findViewById(R.id.work_areaedit);
        Password = findViewById(R.id.passwrdedit);
        Re_password = findViewById(R.id.retypepasswordedit);
        save = findViewById(R.id.btn_save);
        confirm = findViewById(R.id.btn_search);
        DBHelper dbHelper = new DBHelper(this);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = e_mail.getText().toString();
                String work_area = work_Area.getText().toString();
                String address = Address.getText().toString();
                String m_number = M_number.getText().toString();
                String password = Password.getText().toString();
                String re_password = Re_password.getText().toString();
                Boolean i = dbHelper.updateUserCus(email,  work_area,  m_number,
                        password,  re_password,
                        address);
                if (i == true)
                    Toast.makeText(EditCustomerProfile.this, "Update Successful", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(EditCustomerProfile.this, "Update Not Successful", Toast.LENGTH_SHORT).show();
            }
        });

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Confirmed!", Toast.LENGTH_SHORT).show();
            }
        });
    }
}