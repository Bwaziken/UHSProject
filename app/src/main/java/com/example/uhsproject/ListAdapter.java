package com.example.uhsproject;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.app.FragmentManager;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.example.uhsproject.ui.home.HomeFragment;

import java.util.ArrayList;

public class ListAdapter extends RecyclerView.Adapter {
    private Context context;




    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //ListData.pullNames();
       // ListData.pullDesc();
        //ListData.passes();
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((ListViewHolder)holder).bindView(position);




    }

    @Override
    public int getItemCount() {
        return ListData.tutors.length;
    }
    public static int i;

    private class ListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private Context mContext;
        private TextView mItemText;
        private TextView mItemText2;
        private ImageView mItemImage;

        public ListViewHolder(View itemView){

            super(itemView);
            context = itemView.getContext();

            mItemText=(TextView) itemView.findViewById(R.id.itemText);
            mItemText2=(TextView) itemView.findViewById(R.id.itemText2);
            mItemImage=(ImageView) itemView.findViewById(R.id.itemImage);
            itemView.setClickable(true);
            itemView.setOnClickListener(this);

        }
        public void bindView(int position){
            mItemText.setText(ListData.tutors[position]);
            mItemText2.setText(ListData.tutorsdescription[position]);
            mItemImage.setImageResource(ListData.profilePicture[position]);
        }
        @Override


        public void onClick(View view){

            i=getPosition();
            AppCompatActivity activity = (AppCompatActivity) view.getContext();
            activity.getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new TutorFragment()).addToBackStack(null).commit();



        }

    }
    public interface  OnNoteListener{
        void onNoteClick(int position);
    }

}
