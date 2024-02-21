package com.krash.applemart.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.krash.applemart.Model.FruitsVegetablesModel;
import com.krash.applemart.Model.HomeBan1Model;
import com.krash.applemart.R;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class SummerDrinksAdapter extends RecyclerView.Adapter<SummerDrinksAdapter.ViewHolder> {

    Context context;
    private ArrayList<FruitsVegetablesModel> list;
    private OnItemClickListener itemClickListener;

    public SummerDrinksAdapter(Context context, ArrayList<FruitsVegetablesModel> list, OnItemClickListener itemClickListener) {
        this.context = context;
        this.list = list;
        this.itemClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_in_main_home,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        FruitsVegetablesModel model = list.get(position);
        holder.drinkImg.setBackgroundResource(model.getDrinkImg());
        holder.drinkText.setText(model.getDrinkText());

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

        TextView drinkText;
        CircleImageView drinkImg;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            drinkImg = itemView.findViewById(R.id.img_main);
            drinkText = itemView.findViewById(R.id.text_main);

        }
    }
}
