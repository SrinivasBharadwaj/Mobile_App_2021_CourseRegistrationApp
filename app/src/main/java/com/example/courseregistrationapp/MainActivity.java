/*
* Srinivas Bharadwaj Chintalapati
*/

package com.example.courseregistrationapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    final static public String USER_KEY = "USER";
    final static public int REQ_CODE = 100;
    EditText NameEntered;
    EditText EmailEntered;
    EditText IDEntered;
    TextView deptResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        NameEntered = findViewById(R.id.editTextName);
        EmailEntered = findViewById(R.id.editTextEmail);
        IDEntered = findViewById(R.id.editTextID);
        Button selectButton;
        selectButton = findViewById(R.id.buttonSelect);
        selectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(TextUtils.isEmpty(NameEntered.getText().toString()))
                {
                    Toast.makeText(selectButton.getContext(), "Please enter name", Toast.LENGTH_SHORT).show();
                } else if(TextUtils.isEmpty(EmailEntered.getText().toString()))
                {
                    Toast.makeText(selectButton.getContext(), "Please enter Email", Toast.LENGTH_SHORT).show();
                }
                else if(TextUtils.isEmpty(IDEntered.getText().toString()))
                {
                    Toast.makeText(selectButton.getContext(), "Please enter ID", Toast.LENGTH_SHORT).show();
                } else
                {
                    if(Patterns.EMAIL_ADDRESS.matcher(EmailEntered.getText().toString()).matches())
                    {
                        Intent selectDeptIntent = new Intent(MainActivity.this, Department.class);
                        // startActivityForResult() is deprecated
                        startActivityForResult(selectDeptIntent, REQ_CODE);
                    }else
                    {
                        Toast.makeText(selectButton.getContext(), "Please enter valid email", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        Button submitButton;
        submitButton = findViewById(R.id.buttonSubmit);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    if(TextUtils.isEmpty(NameEntered.getText().toString()))
                    {
                        Toast.makeText(submitButton.getContext(), "Please enter name", Toast.LENGTH_SHORT).show();
                    } else if(TextUtils.isEmpty(EmailEntered.getText().toString()))
                    {
                        Toast.makeText(submitButton.getContext(), "Please enter Email", Toast.LENGTH_SHORT).show();
                    }
                    else if(TextUtils.isEmpty(IDEntered.getText().toString()))
                    {
                        Toast.makeText(submitButton.getContext(), "Please enter ID", Toast.LENGTH_SHORT).show();
                    } else if(TextUtils.isEmpty(deptResult.getText().toString()))
                    {
                        Toast.makeText(submitButton.getContext(), "Please select a department", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        if(Patterns.EMAIL_ADDRESS.matcher(EmailEntered.getText().toString()).matches())
                        {
                            Intent submitProfile = new Intent(MainActivity.this, Profile.class);
                            submitProfile.putExtra(USER_KEY, new User(NameEntered.getText().toString(),EmailEntered.getText().toString(),Integer.parseInt(IDEntered.getText().toString()),deptResult.getText().toString()));
                            startActivity(submitProfile);
                        }else
                        {
                            Toast.makeText(submitButton.getContext(), "Please enter valid email", Toast.LENGTH_SHORT).show();
                        }
                    }
                } catch (NullPointerException e) {
                    Toast.makeText(submitButton.getContext(), "Please select a department", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100 && resultCode == Activity.RESULT_OK){
            deptResult = findViewById(R.id.textViewDeptResult);
            String deptName = data.getStringExtra(Department.Dept_Key).toString();
            deptResult.setText(deptName);
        }
    }

}