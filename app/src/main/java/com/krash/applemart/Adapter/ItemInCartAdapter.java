package com.krash.applemart.Adapter;

import android.content.Context;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.krash.applemart.Model.FruitsVegetablesModel;
import com.krash.applemart.R;

import java.util.ArrayList;

public class ItemInCartAdapter extends RecyclerView.Adapter<ItemInCartAdapter.ViewHolder> {

    Context context;
    private ArrayList<FruitsVegetablesModel> list;
    private OnItemClickListener itemClickListener;

    public ItemInCartAdapter(Context context, ArrayList<FruitsVegetablesModel> list, OnItemClickListener itemClickListener) {
        this.context = context;
        this.list = list;
        this.itemClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_in_cart,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        FruitsVegetablesModel model = list.get(position);
        holder.productName.setText(model.getProductShortName());
        holder.productsShortDes.setText(model.getProductShortdes());
//        holder.productOffer.setText(model.getOfferPercent()+"\nOFF");
        holder.productActualAmount.setText(model.getProductActualAmount());
        holder.productFakeAmount.setText(model.getProductFakeAmount());
        holder.productFakeAmount.setPaintFlags(holder.productFakeAmount.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        holder.variantImg.setBackgroundResource(model.getImage1());

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

        holder.addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context, ""+model.getProductShortName()+" Added to cart", Toast.LENGTH_SHORT).show();
                holder.addBtn.setVisibility(View.GONE);
                holder.linearAddMinus.setVisibility(View.VISIBLE);
            }
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

        ImageView variantImg,imgAdd,imgMinus;
        TextView productName,productsShortDes,productActualAmount,productFakeAmount,productOffer,counter,addBtn;
        LinearLayout linearAddMinus;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            variantImg = itemView.findViewById(R.id.cart_img);
            imgAdd = itemView.findViewById(R.id.add);
            imgMinus = itemView.findViewById(R.id.minus);

            productName =itemView.findViewById(R.id.item_name);
            productsShortDes =itemView.findViewById(R.id.item_des);
//            productOffer =itemView.findViewById(R.id.productOfferText);
            productFakeAmount =itemView.findViewById(R.id.item_fake_amnt);
            productActualAmount =itemView.findViewById(R.id.item_actual_amnt);
            counter =itemView.findViewById(R.id.counter);

            addBtn =itemView.findViewById(R.id.addBtn);

            linearAddMinus =itemView.findViewById(R.id.linearAddMinus);
        }
    }
}
