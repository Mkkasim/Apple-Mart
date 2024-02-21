package com.krash.applemart.Adapter;

import android.content.Context;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.textview.MaterialTextView;
import com.krash.applemart.Model.FruitsVegetablesModel;
import com.krash.applemart.Model.ItemInHomeModel;
import com.krash.applemart.R;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class FruitsVegetablesAdapter extends RecyclerView.Adapter<FruitsVegetablesAdapter.ViewHolder> {

    Context context;
    private ArrayList<FruitsVegetablesModel> list;
    private OnItemClickListener itemClickListener;
    private final int limit = 15;
    private int numberOrder = 1;

    public FruitsVegetablesAdapter(Context context, ArrayList<FruitsVegetablesModel> list, OnItemClickListener itemClickListener) {
        this.context = context;
        this.list = list;
        this.itemClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_all_products_buy,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        FruitsVegetablesModel model = list.get(position);
        holder.productName.setText(model.getProductShortName());
        holder.productsShortDes.setText(model.getProductShortdes());
        holder.productOffer.setText(model.getOfferPercent()+"\nOFF");
        holder.productActualAmount.setText(model.getProductActualAmount());
        holder.productFakeAmount.setText(model.getProductFakeAmount());
        holder.productFakeAmount.setPaintFlags(holder.productFakeAmount.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        holder.productImg.setBackgroundResource(model.getImage1());

        holder.itemView.setOnClickListener(view -> {
            itemClickListener.onItemClick(holder.getAdapterPosition());
        });



        holder.imgAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        holder.imgMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }

    @Override
    public int getItemCount() {

        if (list.size() > limit){
            return limit;
        }else {
            return list.size();
        }

    }

    public interface OnItemClickListener{
        void onItemClick(int position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView productImg,imgAdd,imgMinus;
        TextView productName,productsShortDes,productActualAmount,productFakeAmount,productOffer,counter;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            productImg = itemView.findViewById(R.id.productImg);
            imgAdd = itemView.findViewById(R.id.add);
            imgMinus = itemView.findViewById(R.id.minus);

            productName =itemView.findViewById(R.id.productName);
            productsShortDes =itemView.findViewById(R.id.productShortDes);
            productOffer =itemView.findViewById(R.id.productOfferText);
            productFakeAmount =itemView.findViewById(R.id.fakeFee);
            productActualAmount =itemView.findViewById(R.id.actualFee);
            counter =itemView.findViewById(R.id.counter);
        }
    }
}
