package com.krash.applemart.Ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.krash.applemart.Adapter.TrendingSearchAdapter;
import com.krash.applemart.Model.ProductImagesOfferModel;
import com.krash.applemart.R;
import com.krash.applemart.databinding.ActivitySearchBinding;

import java.util.ArrayList;

public class SearchActivity extends AppCompatActivity {

    ActivitySearchBinding binding;
    String comesfrom;

    //trending model
    ArrayList<ProductImagesOfferModel> searchModel = new ArrayList<>();
    TrendingSearchAdapter searchAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_search);

        handleIntent();
        loadTrendingResult();

    }

    private void handleIntent() {
        comesfrom = getIntent().getStringExtra("comesfrom");
    }

    private void loadTrendingResult() {

        searchModel.add(new ProductImagesOfferModel("sugar",R.drawable.apple_mart_logo));
        searchModel.add(new ProductImagesOfferModel("atta",R.drawable.apple_mart_logo));
        searchModel.add(new ProductImagesOfferModel("tea",R.drawable.apple_mart_logo));
        searchModel.add(new ProductImagesOfferModel("ghee",R.drawable.apple_mart_logo));
        searchModel.add(new ProductImagesOfferModel("mustard",R.drawable.apple_mart_logo));
        searchModel.add(new ProductImagesOfferModel("salt",R.drawable.apple_mart_logo));
        searchModel.add(new ProductImagesOfferModel("biscuit",R.drawable.apple_mart_logo));

        searchAdapter = new TrendingSearchAdapter(SearchActivity.this, searchModel, new TrendingSearchAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {


            }
        });
        binding.recycTrendingSearch.setLayoutManager(new LinearLayoutManager(SearchActivity.this,LinearLayoutManager.VERTICAL,false));
        binding.recycTrendingSearch.setAdapter(searchAdapter);
        searchAdapter.notifyDataSetChanged();

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        if (comesfrom.equalsIgnoreCase("variant")){
//            Intent in = new Intent(SearchActivity.this,ProductsVariantsActivity.class);
//            startActivity(in);
//            Animatoo.animateSlideRight(this);
            finish();
            Animatoo.animateSlideRight(this);
        }else if (comesfrom.equals("home")){
            Intent in = new Intent(SearchActivity.this,HomeActivity.class);
            startActivity(in);
            Animatoo.animateSlideRight(this);
            finish();
        }else if (comesfrom.equals("filter")){
            finish();
            Animatoo.animateSlideRight(this);
        }


    }
}