package com.example.uhsproject.ui.home;

import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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

        RecyclerView recyclerView= (RecyclerView) view.findViewById(R.id.listRecyclerView);
        com.example.uhsproject.ListAdapter listAdapter=new com.example.uhsproject.ListAdapter();
        recyclerView.setAdapter(listAdapter);
        RecyclerView.LayoutManager layoutManager =new LinearLayoutManager(getActivity());

        recyclerView.setLayoutManager(layoutManager);


        super.onCreate(savedInstanceState);




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