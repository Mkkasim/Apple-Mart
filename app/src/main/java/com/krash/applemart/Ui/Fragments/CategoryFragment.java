package com.krash.applemart.Ui.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.krash.applemart.Adapter.CategoryAdapter;
import com.krash.applemart.Adapter.ItemInHomeAdapter;
import com.krash.applemart.Model.ItemInHomeModel;
import com.krash.applemart.R;
import com.krash.applemart.Ui.HomeActivity;
import com.krash.applemart.Ui.ProductsVariantsActivity;
import com.krash.applemart.databinding.FragmentCategoryBinding;

import java.util.ArrayList;

public class CategoryFragment extends Fragment {

    FragmentCategoryBinding binding;

    ///Category Item model and adapter
    CategoryAdapter categoryAapter;
    ArrayList<ItemInHomeModel> mainModel = new ArrayList<>();

    public CategoryFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
      binding = FragmentCategoryBinding.inflate(inflater,container,false);

      return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        loadCategory();

    }

    private void loadCategory() {
        mainModel.add(new ItemInHomeModel(R.drawable.fruits_bg,"vegetables & fruits"));
        mainModel.add(new ItemInHomeModel(R.drawable.apple_mart_logo,"tea,coffee & health"));
        mainModel.add(new ItemInHomeModel(R.drawable.apple_mart_logo,"cold drinks & juices"));
        mainModel.add(new ItemInHomeModel(R.drawable.apple_mart_logo,"sweet & icy"));
        mainModel.add(new ItemInHomeModel(R.drawable.apple_mart_logo,"atta, rice & dal"));
        mainModel.add(new ItemInHomeModel(R.drawable.apple_mart_logo,"masala, oil & more"));
        mainModel.add(new ItemInHomeModel(R.drawable.apple_mart_logo,"dairy, bread & e.."));
        mainModel.add(new ItemInHomeModel(R.drawable.apple_mart_logo,"munchies"));
        mainModel.add(new ItemInHomeModel(R.drawable.apple_mart_logo,"bakery & biscuits"));
        mainModel.add(new ItemInHomeModel(R.drawable.apple_mart_logo,"breakfast & instant."));
        mainModel.add(new ItemInHomeModel(R.drawable.apple_mart_logo,"sauces & spreads"));
        mainModel.add(new ItemInHomeModel(R.drawable.apple_mart_logo,"chicken meat & fruits"));
        mainModel.add(new ItemInHomeModel(R.drawable.apple_mart_logo,"oganic & healthy.."));
        mainModel.add(new ItemInHomeModel(R.drawable.apple_mart_logo,"gourmet & world food"));
        mainModel.add(new ItemInHomeModel(R.drawable.apple_mart_logo,"baby care"));
        mainModel.add(new ItemInHomeModel(R.drawable.apple_mart_logo,"pharma & wellness"));
        mainModel.add(new ItemInHomeModel(R.drawable.apple_mart_logo,"cleaning essential"));
        mainModel.add(new ItemInHomeModel(R.drawable.apple_mart_logo,"home & office"));
        mainModel.add(new ItemInHomeModel(R.drawable.apple_mart_logo,"personal care"));
        mainModel.add(new ItemInHomeModel(R.drawable.apple_mart_logo,"pet care"));

        categoryAapter = new CategoryAdapter(getContext(), mainModel, new CategoryAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent in = new Intent(getContext(), ProductsVariantsActivity.class);
                in.putExtra("toolText",mainModel.get(position).getDescText());
                in.putExtra("comesfrom","category");
                startActivity(in);
                Animatoo.animateSlideLeft(getContext());
//                requireActivity().finish();
                Toast.makeText(getContext(), ""+mainModel.get(position).getDescText(), Toast.LENGTH_SHORT).show();
            }
        });
        binding.recycCategory.setLayoutManager(new GridLayoutManager(getContext(), 4));
        binding.recycCategory.setAdapter(categoryAapter);
        categoryAapter.notifyDataSetChanged();


    }
}