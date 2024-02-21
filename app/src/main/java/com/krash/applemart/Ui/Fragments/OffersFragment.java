package com.krash.applemart.Ui.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.krash.applemart.Adapter.HomeBan1Adapter;
import com.krash.applemart.Adapter.MustTryHomeAdapter;
import com.krash.applemart.Adapter.OfferAdapters.TrendingBrandAdapter;
import com.krash.applemart.Adapter.OfferAdapters.TrendingOfferAdapter;
import com.krash.applemart.Model.HomeBan1Model;
import com.krash.applemart.Model.ItemInHomeModel;
import com.krash.applemart.Model.OfferModels.TrendingOfferModel;
import com.krash.applemart.R;
import com.krash.applemart.databinding.FragmentOffersBinding;

import java.util.ArrayList;


public class OffersFragment extends Fragment {

    FragmentOffersBinding binding;

    //OfferZone
    ArrayList<HomeBan1Model> offerModel = new ArrayList<>();
    HomeBan1Adapter offerAdapter;

    //bank wallet
    ArrayList<ItemInHomeModel> bankModel = new ArrayList<>();
    MustTryHomeAdapter bankAdapter;

    //Trending offers
    ArrayList<TrendingOfferModel> trendingOfferModels = new ArrayList<>();
    TrendingOfferAdapter trendingOfferAdapter;

    //Trending Brand
    ArrayList<TrendingOfferModel> trendingBrandModel = new ArrayList<>();
    TrendingBrandAdapter trendingBrandAdapter;


    public OffersFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentOffersBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        loadAll();
    }

    private void loadAll() {
        loadOfferZone();
        loadBankWallet();
        loadTrendingBrands();
        loadTrendingOffers();
    }

    private void loadOfferZone() {
        offerModel.add(new HomeBan1Model("sunny days\nare here !","make the most\nof summer","show now",R.drawable.apple_mart_logo));
        offerModel.add(new HomeBan1Model("sunny days\nare here !","make the most\nof summer","show now",R.drawable.apple_mart_logo));
        offerModel.add(new HomeBan1Model("sunny days\nare here !","make the most\nof summer","show now",R.drawable.apple_mart_logo));
        offerModel.add(new HomeBan1Model("sunny days\nare here !","make the most\nof summer","show now",R.drawable.apple_mart_logo));

        offerAdapter = new HomeBan1Adapter(getContext(), offerModel, new HomeBan1Adapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Toast.makeText(getContext(), ""+offerModel.get(position).getTitle(), Toast.LENGTH_SHORT).show();
            }
        });
        binding.recycOfferZone.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
        binding.recycOfferZone.setAdapter(offerAdapter);
        offerAdapter.notifyDataSetChanged();
    }

    private void loadBankWallet() {
        bankModel.add(new ItemInHomeModel("organic &\nhealthy living",R.drawable.apple_mart_logo));
        bankModel.add(new ItemInHomeModel("Consious \nfood",R.drawable.apple_mart_logo));
        bankModel.add(new ItemInHomeModel("Prasuma \nsince 1985",R.drawable.apple_mart_logo));
        bankModel.add(new ItemInHomeModel("Coolberg",R.drawable.apple_mart_logo));
        bankModel.add(new ItemInHomeModel("jade \nforest",R.drawable.apple_mart_logo));
        bankModel.add(new ItemInHomeModel("wickey &\ngud",R.drawable.apple_mart_logo));

        bankAdapter = new MustTryHomeAdapter(getContext(), bankModel, new HomeBan1Adapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Toast.makeText(getContext(), ""+bankModel.get(position).getMustTryText(), Toast.LENGTH_SHORT).show();
            }
        });

        binding.recycBank.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
        binding.recycBank.setAdapter(bankAdapter);
        bankAdapter.notifyDataSetChanged();
    }

    private void loadTrendingBrands() {
        trendingBrandModel.add(new TrendingOfferModel(R.drawable.apple_mart_logo));
        trendingBrandModel.add(new TrendingOfferModel(R.drawable.apple_mart_logo));
        trendingBrandModel.add(new TrendingOfferModel(R.drawable.apple_mart_logo));
        trendingBrandModel.add(new TrendingOfferModel(R.drawable.apple_mart_logo));
        trendingBrandModel.add(new TrendingOfferModel(R.drawable.apple_mart_logo));

        trendingBrandAdapter = new TrendingBrandAdapter(getContext(), trendingBrandModel, new TrendingBrandAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {

            }
        });

        binding.recycTrendingBrands.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL,false));
        binding.recycTrendingBrands.setAdapter(trendingBrandAdapter);
        trendingBrandAdapter.notifyDataSetChanged();

    }

    private void loadTrendingOffers() {
        trendingOfferModels.add(new TrendingOfferModel(R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,"upto 50% OFF"));
        trendingOfferModels.add(new TrendingOfferModel(R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,"upto 5% OFF"));
        trendingOfferModels.add(new TrendingOfferModel(R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,"upto 24% OFF"));
        trendingOfferModels.add(new TrendingOfferModel(R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,"upto 14% OFF"));
        trendingOfferModels.add(new TrendingOfferModel(R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,"upto 9% OFF"));
        trendingOfferModels.add(new TrendingOfferModel(R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,"upto 15% OFF"));

        trendingOfferAdapter=new TrendingOfferAdapter(getContext(), trendingOfferModels, new TrendingOfferAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {

            }
        });

        binding.recycTrendingOffer.setLayoutManager(new GridLayoutManager(getContext(),3));
        binding.recycTrendingOffer.setAdapter(trendingOfferAdapter);
        trendingOfferAdapter.notifyDataSetChanged();
    }
}