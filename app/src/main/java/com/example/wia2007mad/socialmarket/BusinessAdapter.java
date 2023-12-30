package com.example.wia2007mad.socialmarket;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wia2007mad.R;

public class BusinessAdapter extends RecyclerView.Adapter<BusinessAdapter.ViewHolder> {

    //private LayoutInflater layoutInflater;
    BusinessData[] businessData;
    Context context;

    //private List<String> data;

    public BusinessAdapter(BusinessData[] businessData, Context context){
        this.businessData = businessData;
        this.context = context;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.business_list, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        BusinessData businessDataList = businessData[position];
        holder.name.setText(businessDataList.getName());
        holder.course.setText(businessDataList.getCourse());
        holder.businessDesc.setText(businessDataList.getbusinessDesc());
        holder.cardImage.setImageResource(businessDataList.getImageUrl());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, businessDataList.getName()+" Selected", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return businessData.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView name, course, businessDesc;
        private ImageView cardImage;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.businessname);
            course = itemView.findViewById(R.id.businesscourse);
            businessDesc = itemView.findViewById(R.id.businessDesc);
            cardImage = itemView.findViewById(R.id.businessimageView);


        }
    }


}
