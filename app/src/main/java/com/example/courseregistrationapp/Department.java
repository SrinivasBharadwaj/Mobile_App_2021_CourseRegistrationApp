package com.example.courseregistrationapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class Department extends AppCompatActivity {

    final static public String Dept_Key = "Department";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_department);
        setTitle("Department");
        RadioButton deptDefaultRadioButton;
        Button cancelButton;
        cancelButton = findViewById(R.id.buttonCancel);
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        deptDefaultRadioButton = findViewById(R.id.radioButtonComputerScience);
        deptDefaultRadioButton.setChecked(true);
        Button selectButton;
        selectButton = findViewById(R.id.buttonDeptSelect);
        selectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sendValueToRegistration = new Intent();
                Intent sendDeptValueToProfile = new Intent(Department.this, Profile.class);
                RadioGroup radioGroup = findViewById(R.id.RadioGroupDepartment);
                if(radioGroup.getCheckedRadioButtonId() == R.id.radioButtonComputerScience)
                {
                    sendValueToRegistration.putExtra(Dept_Key,"Computer Science");
                }
                if(radioGroup.getCheckedRadioButtonId() == R.id.radioButtonSoftwaresystems)
                {
                    sendValueToRegistration.putExtra(Dept_Key,"Software Info. Systems");
                }
                if(radioGroup.getCheckedRadioButtonId() == R.id.radioButtonBioInformatics)
                {
                    sendValueToRegistration.putExtra(Dept_Key,"Bio Informatics");
                }
                if(radioGroup.getCheckedRadioButtonId() == R.id.radioButtonDataScience)
                {
                    sendValueToRegistration.putExtra(Dept_Key,"Data Science");
                }
                setResult(RESULT_OK,sendValueToRegistration);
                finish();
            }
        });
    }
}