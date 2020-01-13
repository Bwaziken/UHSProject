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


    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {



        View view = inflater.inflate(R.layout.fragment_tutorinfo, container, false);

        Button book=(Button)view.findViewById(R.id.book);
        book.setOnClickListener(this);

        TextView Name = (TextView)view.findViewById(R.id.infoName);
        TextView Grade = (TextView)view.findViewById(R.id.infoDesc1);
        TextView Subjects = (TextView)view.findViewById(R.id.infoDesc2);
        TextView Description = (TextView)view.findViewById(R.id.infoDesc3);

        Name.setText(ListData.tutors[ListAdapter.i]);
        Grade.setText(ListData.tutorsdescription2[ListAdapter.i]);
        Subjects.setText(ListData.tutorsdescription[ListAdapter.i]);
        Description.setText(ListData.tutorsdescription3[ListAdapter.i]);
        return view;
    }


    @Override
    public void onClick(View v) {
        Toast.makeText(getContext(),"Appointment Booked",Toast.LENGTH_LONG).show();
    }
}
