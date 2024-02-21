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
import com.krash.applemart.R;

import java.util.ArrayList;

public class GotCoveredAdapter extends RecyclerView.Adapter<GotCoveredAdapter.ViewHolder> {

    Context context;
    private ArrayList<HomeBan1Model> list;
    private HomeBan1Adapter.OnItemClickListener itemClickListener;

    public GotCoveredAdapter(Context context, ArrayList<HomeBan1Model> list, HomeBan1Adapter.OnItemClickListener itemClickListener) {
        this.context = context;
        this.list = list;
        this.itemClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_got_covered,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        HomeBan1Model model = list.get(position);
        holder.coveredImage.setBackgroundResource(model.getCoveredImg());
        holder.coveredText.setText(model.getCoveredtext());

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

        TextView coveredText;
        ImageView coveredImage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            coveredText = itemView.findViewById(R.id.coveredText);
            coveredImage = itemView.findViewById(R.id.coveredImg);

        }
    }
}
