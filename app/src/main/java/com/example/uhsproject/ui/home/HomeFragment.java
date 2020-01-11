package com.example.uhsproject.ui.home;

import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.uhsproject.DatabaseHelper;
import com.example.uhsproject.R;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    DatabaseHelper mDatabaseHelper;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        mDatabaseHelper = new DatabaseHelper (getContext());
        View view=inflater.inflate(R.layout.fragment_home, container, false);
        String[] tutorList={"People",  "More people","More people","More people","More people"}; // placeholder for display

        super.onCreate(savedInstanceState);
        ListView listview=view.findViewById(R.id.ListView);


        ArrayAdapter<String> tutorListAdapter = new ArrayAdapter <>(getActivity(), android.R.layout.simple_list_item_1, tutorList);

        listview.setAdapter(tutorListAdapter);


        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){
                    Toast.makeText(getActivity(), "You cliked 0", Toast.LENGTH_LONG).show();

                }
                else if(position==1){
                    Toast.makeText(getActivity(), "You cliked 1", Toast.LENGTH_LONG).show();

                }
            }
        });
        return view;
    }
    public void populateListView() {
        Cursor data = mDatabaseHelper.getData();
        ArrayList<String> AccountName = new ArrayList<>();
        while (data.moveToNext()) {
            AccountName.add(data.getString(1));
        }
    }



}