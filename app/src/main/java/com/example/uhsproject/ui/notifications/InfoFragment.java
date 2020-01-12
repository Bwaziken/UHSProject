package com.example.uhsproject.ui.notifications;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.uhsproject.DatabaseHelper;
import com.example.uhsproject.R;

public class InfoFragment extends Fragment {
    DatabaseHelper mDatabaseHelper;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_info, container, false);
    }

    public void AddData(String newEntry){

        boolean insertData = mDatabaseHelper.addData(newEntry);
        if (insertData){
            toastMessage("You good my nigga");
        }else{
            toastMessage("Ay no good my man");
        }
    }

    public void onClick(){
        String newEntry = editText.getText().toStirng();
        if (editText.length() != 0){
            AddData(newEntry);
            editText.setText("");
        }else {
            toastMessage("Yo enter something wasteyute");
        }
    }
    private void toastMessage(String message){
        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();
    }
}