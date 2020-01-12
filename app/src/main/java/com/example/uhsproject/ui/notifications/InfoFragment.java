package com.example.uhsproject.ui.notifications;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.uhsproject.DatabaseHelper;
import com.example.uhsproject.R;

public class InfoFragment extends Fragment {
    DatabaseHelper mDatabaseHelper;
    Button registerBtn;
    EditText nameField;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_info, container, false);
        registerBtn = (Button) view.findViewById(R.id.registerBtn);
        nameField = (EditText) view.findViewById(R.id.nameField);
        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                String newEntry = nameField.getText().toString();
                if (nameField.length() != 0){
                    AddData(newEntry);
                    nameField.setText("");
                }else {
                    toastMessage("Yo enter something wasteyute");
                }
            }
        });
        return view;
    }

    public void AddData(String newEntry){

        boolean insertData = mDatabaseHelper.addData(newEntry);
        if (insertData){
            toastMessage("You good my nigga");
        }else{
            toastMessage("Ay no good my man");
        }
    }


    private void toastMessage(String message){
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
    }
}