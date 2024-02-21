package com.krash.applemart.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.textview.MaterialTextView;
import com.krash.applemart.Model.ItemInHomeModel;
import com.krash.applemart.Model.ProductImagesOfferModel;
import com.krash.applemart.R;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class TrendingSearchAdapter extends RecyclerView.Adapter<TrendingSearchAdapter.ViewHolder> {

    Context context;
    private ArrayList<ProductImagesOfferModel> list;
    private OnItemClickListener itemClickListener;


    public TrendingSearchAdapter(Context context, ArrayList<ProductImagesOfferModel> list, OnItemClickListener itemClickListener) {
        this.context = context;
        this.list = list;
        this.itemClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_trending_search,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        ProductImagesOfferModel model = list.get(position);
        holder.text_search.setText(model.getTextSearch());
        holder.img_search.setBackgroundResource(model.getImgSearch());

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

        ImageView img_search;
        TextView text_search;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            img_search = itemView.findViewById(R.id.img_search);
            text_search = itemView.findViewById(R.id.text_search);
        }
    }
}
