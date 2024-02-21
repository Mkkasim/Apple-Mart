package com.krash.applemart.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.krash.applemart.Model.HomeBan1Model;
import com.krash.applemart.Model.ItemInHomeModel;
import com.krash.applemart.R;

import java.util.ArrayList;

public class HomeBan1Adapter extends RecyclerView.Adapter<HomeBan1Adapter.ViewHolder> {

    Context context;
    private ArrayList<HomeBan1Model> list;
    private OnItemClickListener itemClickListener;

    public HomeBan1Adapter(Context context, ArrayList<HomeBan1Model> list, OnItemClickListener itemClickListener) {
        this.context = context;
        this.list = list;
        this.itemClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_home_ban1,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        HomeBan1Model model = list.get(position);
        holder.banimg.setBackgroundResource(model.getBanImg());
        holder.title.setText(model.getTitle());
        holder.desc.setText(model.getDesc());

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

        ImageView banimg;
        TextView title,desc,btntext;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            banimg = itemView.findViewById(R.id.ban_img);
            title = itemView.findViewById(R.id.text_title_ban1);
            desc = itemView.findViewById(R.id.text_des_ban1);
            btntext = itemView.findViewById(R.id.text_btn_ban1);

        }
    }

}
