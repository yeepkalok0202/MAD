package com.example.wia2007mad.socialmarket;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.wia2007mad.AllModules.webViewPage;
import com.example.wia2007mad.R;

import java.util.ArrayList;

public class MarketAdapter extends RecyclerView.Adapter<MarketAdapter.ViewHolder> {

    //private LayoutInflater layoutInflater;
    //MarketData[] marketData;
    private ArrayList<MarketData> marketData = new ArrayList<>();
    Context context;

    //private List<String> data;

    /*
    MarketAdapter(Context context, List<String> data){
        this.layoutInflater = LayoutInflater.from(context);
        this.data = data;
    }

     */

    /*
    public MarketAdapter(MarketData[] marketData, Context context){
        this.marketData = marketData;
        this.context = context;
    }\

     */

    public MarketAdapter(Context context) {
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
        //MarketData marketDataList = marketData[position];

        holder.name.setText(marketData.get(position).getName());
        holder.course.setText(marketData.get(position).getCourse());
        holder.marketDesc.setText(marketData.get(position).getMarketDesc());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, marketData.get(position).getName()+" Selected", Toast.LENGTH_SHORT).show();

                //go to webview page when clicked
                Intent intent = new Intent(context, webViewPage.class);
                //retrieve the url link
                String urlToLoad = marketData.get(position).getUrl();
                intent.putExtra("url", urlToLoad);
                context.startActivity(intent);
            }
        });

        //code for image
        Glide.with(context)
                .load(marketData.get(position).getImageUrl())
                .into(holder.cardImage);
    }

    @Override
    public int getItemCount() {
        return marketData.size();
    }

    public void setResources(ArrayList<MarketData> marketData) {
        this.marketData = marketData;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView name, course, marketDesc;
        private ImageView cardImage;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.marketingcardviewname);
            course = itemView.findViewById(R.id.marketingcardviewcourse);
            marketDesc = itemView.findViewById(R.id.marketDesc);
            cardImage = itemView.findViewById(R.id.marketingcardviewimage);


        }
    }


}
