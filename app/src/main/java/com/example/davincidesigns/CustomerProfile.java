package com.example.davincidesigns;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class CustomerProfile extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    Toolbar toolbar;
    Button editprofile, deleteprofile;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_profile);

        editprofile = findViewById(R.id.btneditacc);
        deleteprofile = findViewById(R.id.btndeleteacc);

        editprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CustomerProfile.this, com.example.work_byte.EditCustomerProfile.class);
                startActivity(intent);
            }
        });

        deleteprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), com.example.work_byte.ConfirmCustomerDeleteActivity.class);
                startActivity(intent);
            }
        });


        //Assign variable
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        //Add home
        bottomNavigationView.setSelectedItemId(R.id.home);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId())
                {
                    case R.id.nav_home:
                        startActivity(new Intent(getApplicationContext(),WorkerDashboard.class));
                        overridePendingTransition(0,0);
                        return true;

                    case R.id.nav_account:
                        return true;
                }
                return false;
            }
        });



    }
}