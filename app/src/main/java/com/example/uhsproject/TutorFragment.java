package com.example.uhsproject;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;



public class TutorFragment extends Fragment implements View.OnClickListener{
Button book;
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {



        View view = inflater.inflate(R.layout.fragment_tutorinfo, container, false);

        book=(Button)view.findViewById(R.id.book);
        book.setOnClickListener(this);
        return view;
    }


    @Override
    public void onClick(View v) {
        Toast.makeText(getContext(),"Appointment Booked",Toast.LENGTH_LONG).show();
    }
}
