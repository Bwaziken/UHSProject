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
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);
        signin=(Button) findViewById(R.id.signin);
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginScreen.this,MainActivity.class);
                startActivity(intent);
            }
        });

            mDatabaseHelper = new DatabaseHelper(this);
            registerBtn = findViewById(R.id.registerBtn);
            nameField = findViewById(R.id.nameField);
            descField = findViewById(R.id.descField);
            registerBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v){
                    if (nameField.length() != 0 && descField.length() != 0 ){
                        boolean isInserted = mDatabaseHelper.addData(nameField.getText().toString(),descField.getText().toString());
                        if (isInserted){
                            toastMessage("You good my nigga");
                        }else{
                            toastMessage("Ay no good my man");
                        }
                        nameField.setText("");
                        descField.setText("");
                    }else {
                        toastMessage("Yo enter something wasteyute");
                    }
                }
            });
        }
        private void toastMessage(String message){
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        }
    }

