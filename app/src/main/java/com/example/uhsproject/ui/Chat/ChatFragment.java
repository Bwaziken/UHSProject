package com.example.uhsproject.ui.Chat;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.uhsproject.R;

public class ChatFragment extends Fragment {
    String message;
    static EditText messageBox;
    static Button send;
    TextView top;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_chats, container, false);
        top = (TextView) view.findViewById(R.id.chatTop);//sent messages
        messageBox = (EditText) view.findViewById(R.id.messageBox);//chat fragment stuff
        send = (Button) view.findViewById(R.id.send);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                message = messageBox.getText().toString();
                top.setText(message);
            }
        });
        return view;

    }
}

