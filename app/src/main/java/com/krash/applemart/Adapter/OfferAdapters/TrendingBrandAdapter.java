package com.krash.applemart.Adapter.OfferAdapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.krash.applemart.Model.OfferModels.TrendingOfferModel;
import com.krash.applemart.R;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class TrendingBrandAdapter extends RecyclerView.Adapter<TrendingBrandAdapter.ViewHolder> {

    Context context;
    ArrayList<TrendingOfferModel> list = new ArrayList<>();
    private OnItemClickListener itemClickListener;

    public TrendingBrandAdapter(Context context, ArrayList<TrendingOfferModel> list, OnItemClickListener itemClickListener) {
        this.context = context;
        this.list = list;
        this.itemClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_trending_brand,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        TrendingOfferModel model = list.get(position);
        holder.Img_back.setImageResource(model.getImg_brand());


        holder.itemView.setOnClickListener(view -> {
            itemClickListener.onItemClick(holder.getAdapterPosition());
        });


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public interface OnItemClickListener{
        void onItemClick(int position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView Img_back;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            Img_back = itemView.findViewById(R.id.img_brand);

        }
    }
}
