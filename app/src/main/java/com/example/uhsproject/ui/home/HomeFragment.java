package com.example.uhsproject.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.uhsproject.R;

public class HomeFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.fragment_home, container, false);
        String[] tutorList={"People",  "More people","More people","More people","More people"};

        ListView listview=(ListView) view.findViewById(R.id.ListView);
        ArrayAdapter<String> tutorListAdapter = new ArrayAdapter <String>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                tutorList
        );

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
}