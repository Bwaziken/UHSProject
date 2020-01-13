package com.example.uhsproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginScreen extends AppCompatActivity {
    Button signin;
    DatabaseHelper mDatabaseHelper;
    Button registerBtn;
    EditText nameField, descField;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mDatabaseHelper = new DatabaseHelper(this);
        registerBtn = findViewById(R.id.registerBtn);
        nameField = findViewById(R.id.nameField);
        descField = findViewById(R.id.descField);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);
        signin=findViewById(R.id.signin);
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                if (nameField.length() != 0 && descField.length() != 0 ){
                    Intent intent = new Intent(LoginScreen.this, MainActivity.class);
                    startActivity(intent);
                }else {
                    toastMessage("Please enter all the required information");
                }
            }
        });

        registerBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v){
                    if (nameField.length() != 0 && descField.length() != 0 ){
                        boolean isInserted = mDatabaseHelper.addData(nameField.getText().toString(),descField.getText().toString());
                        if (isInserted){
                            toastMessage("Registration Successful");
                        }else{
                            toastMessage("An error has occured");
                        }
                        nameField.setText("");
                        descField.setText("");
                    }else {
                        toastMessage("Please enter all the required information");
                    }
                }
            });
        }
        private void toastMessage(String message){
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        }
    }

