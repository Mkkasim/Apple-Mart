package com.krash.applemart.Ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.krash.applemart.Adapter.FruitsVegetablesAdapter;
import com.krash.applemart.Adapter.ItemInCartAdapter;
import com.krash.applemart.Model.FruitsVegetablesModel;
import com.krash.applemart.R;
import com.krash.applemart.databinding.ActivityCartBinding;

import java.util.ArrayList;

public class CartActivity extends AppCompatActivity {

    ActivityCartBinding binding;

    //checkout items
    ArrayList<FruitsVegetablesModel> checkoutModel = new ArrayList<>();
    FruitsVegetablesAdapter checkoutAdapter;

    //items in cart
    ArrayList<FruitsVegetablesModel> itemCartModel = new ArrayList<>();
    ItemInCartAdapter itemCartAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_cart);

        loadCartItems();
        loadBeforeCheckout();

        binding.backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

    }

    private void loadCartItems() {
        itemCartModel.add(new FruitsVegetablesModel("10%","Ratnagiri Alphonso Mango","Ratnagiri Alphonso Mango",
                "4 pieces (0.8kg - 1kg)","Ratnagiri Alphonso Mango is famous and sweetest mango in india","₹469","₹539","3 days",
                "4 pieces (0.8kg -1kg)","","","","","",
                "","","","",
                R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,
                R.drawable.apple_mart_logo));

        itemCartModel.add(new FruitsVegetablesModel("12%","Ratnagiri Orange","Ratnagiri Orange",
                "10 pieces (0.8kg - 1kg)","Ratnagiri Alphonso Mango is famous and sweetest mango in india","₹599","₹639","3 days",
                "4 pieces (0.8kg -1kg)","","","","","",
                "","","","",
                R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,
                R.drawable.apple_mart_logo));


        itemCartAdapter = new ItemInCartAdapter(CartActivity.this, itemCartModel, new ItemInCartAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
            }
        });
        binding.recycCartItem.setLayoutManager(new LinearLayoutManager(CartActivity.this, LinearLayoutManager.VERTICAL, false));
        binding.recycCartItem.setAdapter(itemCartAdapter);
        itemCartAdapter.notifyDataSetChanged();
    }

    private void loadBeforeCheckout() {
        checkoutModel.add(new FruitsVegetablesModel("10%","Ratnagiri Alphonso Mango","Ratnagiri Alphonso Mango",
                "4 pieces (0.8kg - 1kg)","Ratnagiri Alphonso Mango is famous and sweetest mango in india","₹469","₹539","3 days",
                "4 pieces (0.8kg -1kg)","","","","","",
                "","","","",
                R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,
                R.drawable.apple_mart_logo));

        checkoutModel.add(new FruitsVegetablesModel("12%","Ratnagiri Orange","Ratnagiri Orange",
                "10 pieces (0.8kg - 1kg)","Ratnagiri Alphonso Mango is famous and sweetest mango in india","₹599","₹639","3 days",
                "4 pieces (0.8kg -1kg)","","","","","",
                "","","","",
                R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,
                R.drawable.apple_mart_logo));

        checkoutModel.add(new FruitsVegetablesModel("15%","Ratnagiri Banana","Ratnagiri Banana",
                "20 pieces (0.8kg - 1kg)","Ratnagiri Alphonso Mango is famous and sweetest mango in india","₹119","₹299","3 days",
                "20 pieces (0.8kg -1kg)","","","","","",
                "","","","",
                R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,
                R.drawable.apple_mart_logo));

        checkoutModel.add(new FruitsVegetablesModel("15%","Ratnagiri Banana","Ratnagiri Banana",
                "20 pieces (0.8kg - 1kg)","Ratnagiri Alphonso Mango is famous and sweetest mango in india","₹119","₹299","3 days",
                "20 pieces (0.8kg -1kg)","","","","","",
                "","","","",
                R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,
                R.drawable.apple_mart_logo));

        checkoutModel.add(new FruitsVegetablesModel("15%","Ratnagiri Banana","Ratnagiri Banana",
                "20 pieces (0.8kg - 1kg)","Ratnagiri Alphonso Mango is famous and sweetest mango in india","₹119","₹299","3 days",
                "20 pieces (0.8kg -1kg)","","","","","",
                "","","","",
                R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,
                R.drawable.apple_mart_logo));

        checkoutAdapter = new FruitsVegetablesAdapter(CartActivity.this, checkoutModel, new FruitsVegetablesAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Toast.makeText(CartActivity.this, ""+checkoutModel.get(position).getProductShortName(), Toast.LENGTH_SHORT).show();
            }
        });
        binding.recycBeforeCheckout.setLayoutManager(new LinearLayoutManager(CartActivity.this,LinearLayoutManager.HORIZONTAL,false));
        binding.recycBeforeCheckout.setAdapter(checkoutAdapter);
        checkoutAdapter.notifyDataSetChanged();
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
        Animatoo.animateSlideRight(CartActivity.this);
    }
}