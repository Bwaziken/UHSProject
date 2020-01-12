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
    EditText nameField, descField;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_info, container, false);
        mDatabaseHelper = new DatabaseHelper(getActivity().getApplicationContext());
        registerBtn = view.findViewById(R.id.registerBtn);
        nameField = view.findViewById(R.id.nameField);
        descField = view.findViewById(R.id.descField);
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
    return view;
    }
    private void toastMessage(String message){
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
    }
}