package com.example.wia2007mad.socialmarket;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wia2007mad.R;

import java.util.ArrayList;

public class SuccessAdapter extends RecyclerView.Adapter<SuccessAdapter.ViewHolder> {
    private ArrayList<SuccessData> successStories = new ArrayList<>();

    private Context context;

    public SuccessAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.success_list, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.successTxt.setText(successStories.get(position).getSuccesstext());
        holder.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, successStories.get(position).getSuccesstext() + " Selected", Toast.LENGTH_SHORT).show();

            }
        });

        holder.successImage.setImageResource(successStories.get(position).getImageUrl());

    }

    @Override
    public int getItemCount() {
        return successStories.size();
    }

    public void setBlogs(ArrayList<SuccessData> successStories) {
        this.successStories = successStories;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView successTxt;
        private CardView parent;
        private ImageView successImage;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            successTxt = itemView.findViewById(R.id.successblogtext);
            parent = itemView.findViewById(R.id.parent);
            successImage = itemView.findViewById(R.id.successblogimage);
        }
    }
}
