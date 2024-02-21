package com.krash.applemart.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.textview.MaterialTextView;
import com.krash.applemart.Model.ItemInHomeModel;
import com.krash.applemart.R;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class ItemInHomeAdapter extends RecyclerView.Adapter<ItemInHomeAdapter.ViewHolder> {

    Context context;
    private ArrayList<ItemInHomeModel> list;
    private OnItemClickListener itemClickListener;
    private final int limit = 12;

    public ItemInHomeAdapter(Context context, ArrayList<ItemInHomeModel> list, OnItemClickListener itemClickListener) {
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

        ItemInHomeModel model = list.get(position);
        holder.text_main.setText(model.getDescText());
        holder.img_main.setImageResource(model.getImage());
//        holder.img_main.setBackgroundResource(model.getImage());

        holder.itemView.setOnClickListener(view -> {
            itemClickListener.onItemClick(holder.getAdapterPosition());
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

        CircleImageView img_main;
        MaterialTextView text_main;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            img_main = itemView.findViewById(R.id.img_main);
            text_main = itemView.findViewById(R.id.text_main);
        }
    }
}
