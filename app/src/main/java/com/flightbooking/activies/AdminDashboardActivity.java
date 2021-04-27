package com.flightbooking.activies;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.flightbooking.R;
import com.flightbooking.Utils;

public class AdminDashboardActivity extends AppCompatActivity {
    CardView cdCustomerProfile,cdHoteInfo,cdRoute,cdFlightBooking;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_dashboard);

        getSupportActionBar().setTitle("Admin Dashboard");
       /* getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);*/

        cdCustomerProfile=(CardView)findViewById(R.id.cdCustomerProfile);
        cdCustomerProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(AdminDashboardActivity.this,GetCustomerProfileActivity.class);
                startActivity(intent);
                //finish();
            }
        });
        cdHoteInfo=(CardView)findViewById(R.id.cdHoteInfo);
        cdHoteInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(AdminDashboardActivity.this,HotelInfoActivity.class);
                startActivity(intent);
               // finish();
            }
        });

        cdRoute=(CardView)findViewById(R.id.cdRoute);
        cdRoute.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(AdminDashboardActivity.this,RouteInfoActivity.class);
                startActivity(intent);
               // finish();
            }
        });

        cdFlightBooking=(CardView)findViewById(R.id.cdFlightBooking);
        cdFlightBooking.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(AdminDashboardActivity.this,FlightBookingActivity.class);
                startActivity(intent);
                //finish();
            }
        });
        Button btnLogout=(Button)findViewById(R.id.btnLogout);
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getSharedPreferences(Utils.SHREF, Context.MODE_PRIVATE);
                sharedPreferences.edit().clear().commit();
                startActivity(new Intent(AdminDashboardActivity.this,AdminLoginActivity.class));
                finish();
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.admin_navbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id== R.id.menuLogout){
           SharedPreferences sharedPreferences = getSharedPreferences(Utils.SHREF, Context.MODE_PRIVATE);
            sharedPreferences.edit().clear().commit();
            startActivity(new Intent(AdminDashboardActivity.this,AdminLoginActivity.class));
            finish();
        }
        return super.onOptionsItemSelected(item);
    }}