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

public class MarketAdapter extends RecyclerView.Adapter<MarketAdapter.ViewHolder> {

    //private LayoutInflater layoutInflater;
    MarketData[] marketData;
    Context context;

    //private List<String> data;

    /*
    MarketAdapter(Context context, List<String> data){
        this.layoutInflater = LayoutInflater.from(context);
        this.data = data;
    }

     */
    public MarketAdapter(MarketData[] marketData, Context context){
        this.marketData = marketData;
        this.context = context;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        //View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.marketing_list, parent, false);
        View view = layoutInflater.inflate(R.layout.marketing_list, parent, false);
        return new ViewHolder(view);
    }

    /*
    @Override
    public void onBindViewHolder(@NonNull MarketAdapter.ViewHolder holder, int position) {
        //bind the textView with data received
        String title = data.get(position);
        holder.name.setText(title);
    }*/
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        MarketData marketDataList = marketData[position];
        holder.name.setText(marketDataList.getName());
        holder.course.setText(marketDataList.getCourse());
        holder.marketDesc.setText(marketDataList.getMarketDesc());
        holder.cardImage.setImageResource(marketDataList.getImageUrl());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, marketDataList.getName()+" Selected", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return marketData.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView name, course, marketDesc;
        private ImageView cardImage;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            course = itemView.findViewById(R.id.course);
            marketDesc = itemView.findViewById(R.id.marketDesc);
            cardImage = itemView.findViewById(R.id.imageView);


        }
    }


}
