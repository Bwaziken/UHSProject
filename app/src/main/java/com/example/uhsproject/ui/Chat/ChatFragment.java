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
    String message,messageBefore,messageBeforeBefore,message3,message4;
    EditText messageBox;
    Button send;
    TextView top,one,two,three,four;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_chats, container, false);

        top = (TextView) view.findViewById(R.id.chatTop);//sent messages
        one = (TextView) view.findViewById(R.id.chatpt);//sent messages
        two = (TextView) view.findViewById(R.id.chatpt2);//sent messages
        three = (TextView) view.findViewById(R.id.chatpt3);
        four = (TextView) view.findViewById(R.id.chatpt4);

        messageBox = (EditText) view.findViewById(R.id.messageBox);//chat fragment stuff
        send = (Button) view.findViewById(R.id.send);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
                message4=message3;
                message3=messageBeforeBefore;
                messageBeforeBefore=messageBefore;
                messageBefore=message;

                message = messageBox.getText().toString();
                top.setText(message);
                one.setText(messageBefore);
                two.setText(messageBeforeBefore);
                three.setText(message3);
                four.setText(message4);
            }
        });
        return view;

    }
}

