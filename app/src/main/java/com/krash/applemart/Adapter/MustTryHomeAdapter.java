package com.krash.applemart.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.krash.applemart.Model.ItemInHomeModel;
import com.krash.applemart.R;

import java.util.ArrayList;

public class MustTryHomeAdapter extends RecyclerView.Adapter<MustTryHomeAdapter.ViewHolder> {

    Context context;
    ArrayList<ItemInHomeModel> list = new ArrayList<>();
    private HomeBan1Adapter.OnItemClickListener itemClickListener;

    public MustTryHomeAdapter(Context context, ArrayList<ItemInHomeModel> list, HomeBan1Adapter.OnItemClickListener itemClickListener) {
        this.context = context;
        this.list = list;
        this.itemClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_must_try,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        ItemInHomeModel model = list.get(position);
        holder.mustTitle.setText(model.getMustTryText());
        holder.mustImg.setBackgroundResource(model.getMustImg());


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

        ImageView mustImg;
        TextView mustTitle;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            mustImg = itemView.findViewById(R.id.mustImg);
            mustTitle = itemView.findViewById(R.id.mustTitle);

        }
    }
}
