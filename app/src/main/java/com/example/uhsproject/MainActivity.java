package com.example.uhsproject;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;

import com.example.uhsproject.ui.Chat.ChatFragment;
import com.example.uhsproject.ui.home.HomeFragment;
import com.example.uhsproject.ui.notifications.InfoFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper mDatabaseHelper;
    Button registerBtn;
    EditText nameField, descField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListFragment fragment= new ListFragment();
        FragmentManager fragmentManager= getFragmentManager();
        FragmentTransaction fragmentTransaction= fragmentManager.beginTransaction();

        fragmentTransaction.commit();
        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);


        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new HomeFragment()).commit();
        }
        mDatabaseHelper = new DatabaseHelper (this);
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
    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;

                    switch (item.getItemId()) {
                        case R.id.navigation_home:
                            selectedFragment = new HomeFragment();
                            break;
                        case R.id.navigation_chats:
                            selectedFragment = new ChatFragment();
                            break;
                        case R.id.navigation_info:
                            selectedFragment = new InfoFragment();
                            break;
                    }

                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            selectedFragment).commit();

                    return true;
                }
            };
}
