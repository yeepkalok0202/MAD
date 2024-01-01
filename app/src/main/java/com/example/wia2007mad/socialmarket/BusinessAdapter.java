package com.example.wia2007mad.socialmarket;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wia2007mad.R;

import com.example.wia2007mad.databinding.BusinessListBinding;
import java.util.List;

public class BusinessAdapter extends RecyclerView.Adapter<BusinessAdapter.BusinessViewHolder> {

    private final List<BusinessData> businessDataList;
    private final BusinessListener businessListener;

    public BusinessAdapter(List<BusinessData> businessDataList, BusinessListener businessListener) {
        this.businessDataList = businessDataList;
        this.businessListener = businessListener;
    }

    @NonNull
    @Override
    public BusinessViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        BusinessListBinding businessListBinding = BusinessListBinding.inflate(
                LayoutInflater.from(parent.getContext()),
                parent,
                false
        );
        return new BusinessViewHolder(businessListBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull BusinessViewHolder holder, int position) {
        holder.setData(businessDataList.get(position));
    }

    @Override
    public int getItemCount() {
        return businessDataList.size();
    }

    class BusinessViewHolder extends RecyclerView.ViewHolder {
        BusinessListBinding binding;

        BusinessViewHolder(BusinessListBinding businessListBinding) {
            super(businessListBinding.getRoot());
            binding = businessListBinding;
        }

        void setData(BusinessData businessData) {
            Glide.with(binding.businessimageView.getContext())
                    .load(businessData.imageUrl)
                    .into(binding.businessimageView);
            binding.businessname.setText(businessData.name);
            binding.businesscourse.setText(businessData.course);
            binding.businessDesc.setText(businessData.businessDesc);
            binding.getRoot().setOnClickListener(view -> businessListener.onItemClicked(businessData));
        }
    }

    /*
    //old code
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

     */
}
