package com.example.courseregistrationapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Profile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        setTitle("Profile");
        TextView nameResultFromRegistration;
        TextView emailResultFromRegistration;
        TextView idResultFromRegistration;
        TextView deptResultFromDepartment;
        nameResultFromRegistration = findViewById(R.id.textViewProfileNameresult);
        emailResultFromRegistration = findViewById(R.id.textViewProfileEmailResult);
        idResultFromRegistration = findViewById(R.id.textViewProfileIDResult);
        deptResultFromDepartment = findViewById(R.id.textViewProfileDeptResult);
        if(getIntent() != null && getIntent().getExtras() != null && getIntent().hasExtra(MainActivity.USER_KEY))
        {
            User user = (User) getIntent().getSerializableExtra(MainActivity.USER_KEY);
            nameResultFromRegistration.setText(user.name);
            emailResultFromRegistration.setText(user.email);
            idResultFromRegistration.setText(String.valueOf(user.id));
            deptResultFromDepartment.setText(user.department);
        }
    }
}