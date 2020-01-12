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
import com.example.uhsproject.MainActivity;
import com.example.uhsproject.R;

public class InfoFragment extends Fragment {

    DatabaseHelper mDatabaseHelper;
    Button registerBtn;
    EditText nameField, descField;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mDatabaseHelper = new DatabaseHelper (getActivity().getApplicationContext());
        View view =  inflater.inflate(R.layout.fragment_info, container, false);
        registerBtn = view.findViewById(R.id.registerBtn);
        nameField = view.findViewById(R.id.nameField);
        descField = view.findViewById(R.id.descField);
        adddata();
        return view;
    }
    public void adddata(){
        registerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                if (nameField.length() != 0 && descField.length() != 0 ){
                    String nameField1 = nameField.getText().toString();
                    String descField1 = descField.getText().toString();
                    Toast.makeText(getActivity(),nameField1,Toast.LENGTH_SHORT).show();
                    Toast.makeText(getActivity(),descField1,Toast.LENGTH_SHORT).show();

                    boolean isInserted = mDatabaseHelper.addData(nameField1,descField1);
                    if (isInserted==true){
                        toastMessage("You good my nigga");
                    }else {
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
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
    }
}