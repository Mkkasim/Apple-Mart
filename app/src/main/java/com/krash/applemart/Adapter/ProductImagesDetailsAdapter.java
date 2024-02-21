package com.krash.applemart.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.krash.applemart.Model.ProductImagesOfferModel;
import com.krash.applemart.R;

import java.util.ArrayList;

public class ProductImagesDetailsAdapter extends RecyclerView.Adapter<ProductImagesDetailsAdapter.ViewHolder> {

    Context context;
    ArrayList<ProductImagesOfferModel> imagesOfferModel = new ArrayList<>();

    public ProductImagesDetailsAdapter(Context context, ArrayList<ProductImagesOfferModel> imagesOfferModel) {
        this.context = context;
        this.imagesOfferModel = imagesOfferModel;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_imageview_product,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        ProductImagesOfferModel model = imagesOfferModel.get(position);
        holder.productOffer.setText(model.getOfferPercent());
        holder.productImg.setBackgroundResource(model.getImage1());

    }

    @Override
    public int getItemCount() {
        return imagesOfferModel.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView productImg;
        TextView productOffer;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            productImg = itemView.findViewById(R.id.imgDetails);
            productOffer = itemView.findViewById(R.id.offerDetails);

        }
    }
}
