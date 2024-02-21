package com.krash.applemart.Ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.krash.applemart.Adapter.FruitsVegetablesAdapter;
import com.krash.applemart.Adapter.ProductImagesDetailsAdapter;
import com.krash.applemart.Model.FruitsVegetablesModel;
import com.krash.applemart.Model.ProductImagesOfferModel;
import com.krash.applemart.R;
import com.krash.applemart.databinding.ActivityProductDetailsBinding;

import java.util.ArrayList;

public class ProductDetailsActivity extends AppCompatActivity {

    ActivityProductDetailsBinding binding;
    Bundle bundle = new Bundle();

    String offerPercent,productShortName,productFullName,productShortdes,productLongDes,productActualAmount,productFakeAmount,
            productsShelfLife,productUnit,manufacturerDetails,marketedBy,fssaiLicense,productsDisclaimer,country,customerCareDetails,
            productsClass,seller,ExpiryDate;
    int Image1,Image2,Image3,Image4;

    //load frequent items
    ArrayList<FruitsVegetablesModel> frequentModel = new ArrayList<>();
    FruitsVegetablesAdapter frequentAdapter;

    //Product Images ans offer
    ArrayList<ProductImagesOfferModel> imageOfferModel = new ArrayList<>();
    ProductImagesDetailsAdapter imageOfferAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_product_details);

        handleIntent();
        loadFrequentItem();
        loadProductImages();

        binding.backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        binding.shareBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        binding.seedetaildown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.seedetaildown.setVisibility(View.GONE);
                binding.relateDetails.setVisibility(View.VISIBLE);
                binding.readlessup.setVisibility(View.VISIBLE);
            }
        });

        binding.readlessup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.readlessup.setVisibility(View.GONE);
                binding.relateDetails.setVisibility(View.GONE);
                binding.seedetaildown.setVisibility(View.VISIBLE);
            }
        });
        binding.addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.addBtn.setVisibility(View.GONE);
                binding.linearAddMinus.setVisibility(View.VISIBLE);
                binding.lineBottom.setVisibility(View.VISIBLE);
            }
        });

        binding.relatebtom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(ProductDetailsActivity.this, CartActivity.class);
                startActivity(in);
                Animatoo.animateSlideLeft(ProductDetailsActivity.this);
            }
        });


    }

    private void handleIntent() {

        bundle = getIntent().getExtras();
        offerPercent = bundle.getString("offerPercent");
        productShortName = bundle.getString("productShortName");
        productFullName = bundle.getString("productFullName");
        productShortdes = bundle.getString("productShortdes");
        productLongDes = bundle.getString("productLongDes");
        productActualAmount = bundle.getString("productActualAmount");
        productFakeAmount = bundle.getString("productFakeAmount");
        productsShelfLife = bundle.getString("productsShelfLife");
        productUnit = bundle.getString("productUnit");
        manufacturerDetails = bundle.getString("manufacturerDetails");
        marketedBy = bundle.getString("marketedBy");
        fssaiLicense = bundle.getString("fssaiLicense");
        productsDisclaimer = bundle.getString("productsDisclaimer");
        country = bundle.getString("country");
        customerCareDetails = bundle.getString("customerCareDetails");
        productsClass = bundle.getString("productsClass");
        seller = bundle.getString("seller");
        ExpiryDate = bundle.getString("ExpiryDate");
        Image1 = bundle.getInt("image1");
        Image2 = bundle.getInt("image2");
        Image3 = bundle.getInt("image3");
        Image4 = bundle.getInt("image4");


        binding.productName.setText(productFullName);
        binding.productShortDes.setText(productShortdes);
        binding.actualFee.setText(productActualAmount);
        binding.fakeFee.setText(productFakeAmount);
        binding.fakeFee.setPaintFlags(binding.fakeFee.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        binding.ProductLongDes.setText(productLongDes);
        binding.shelfLife.setText(productsShelfLife);
        binding.unit.setText(productUnit);
        binding.disclaimer.setText(productsDisclaimer);
        binding.customercare.setText(customerCareDetails);
        binding.productclass.setText(productsClass);
        binding.seller.setText(seller);
        binding.expiry.setText(ExpiryDate);



    }

    private void loadProductImages() {
        imageOfferModel.add(new ProductImagesOfferModel(offerPercent,Image1,Image2,Image3,Image4));

        imageOfferAdapter = new ProductImagesDetailsAdapter(ProductDetailsActivity.this,imageOfferModel);

        binding.recyProductImg.setLayoutManager(new LinearLayoutManager(ProductDetailsActivity.this,LinearLayoutManager.HORIZONTAL,false));
        binding.recyProductImg.setAdapter(imageOfferAdapter);
        imageOfferAdapter.notifyDataSetChanged();

    }

    private void loadFrequentItem() {
        frequentModel.add(new FruitsVegetablesModel("10%","Ratnagiri Alphonso Mango","Ratnagiri Alphonso Mango",
                "4 pieces (0.8kg - 1kg)","Ratnagiri Alphonso Mango is famous and sweetest mango in india","₹469","₹539","3 days",
                "4 pieces (0.8kg -1kg)","","","","","",
                "","","","",
                R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,
                R.drawable.apple_mart_logo));

        frequentModel.add(new FruitsVegetablesModel("12%","Ratnagiri Orange","Ratnagiri Orange",
                "10 pieces (0.8kg - 1kg)","Ratnagiri Alphonso Mango is famous and sweetest mango in india","₹599","₹639","3 days",
                "4 pieces (0.8kg -1kg)","","","","","",
                "","","","",
                R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,
                R.drawable.apple_mart_logo));

        frequentModel.add(new FruitsVegetablesModel("15%","Ratnagiri Banana","Ratnagiri Banana",
                "20 pieces (0.8kg - 1kg)","Ratnagiri Alphonso Mango is famous and sweetest mango in india","₹119","₹299","3 days",
                "20 pieces (0.8kg -1kg)","","","","","",
                "","","","",
                R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,
                R.drawable.apple_mart_logo));

        frequentModel.add(new FruitsVegetablesModel("15%","Ratnagiri Banana","Ratnagiri Banana",
                "20 pieces (0.8kg - 1kg)","Ratnagiri Alphonso Mango is famous and sweetest mango in india","₹119","₹299","3 days",
                "20 pieces (0.8kg -1kg)","","","","","",
                "","","","",
                R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,
                R.drawable.apple_mart_logo));

        frequentModel.add(new FruitsVegetablesModel("15%","Ratnagiri Banana","Ratnagiri Banana",
                "20 pieces (0.8kg - 1kg)","Ratnagiri Alphonso Mango is famous and sweetest mango in india","₹119","₹299","3 days",
                "20 pieces (0.8kg -1kg)","","","","","",
                "","","","",
                R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,
                R.drawable.apple_mart_logo));

        frequentAdapter = new FruitsVegetablesAdapter(ProductDetailsActivity.this, frequentModel, new FruitsVegetablesAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {

                Bundle bundle = new Bundle();
                bundle.putString("offerPercent",frequentModel.get(position).getOfferPercent());
                bundle.putString("productShortName",frequentModel.get(position).getProductShortName());
                bundle.putString("productFullName",frequentModel.get(position).getProductFullName());
                bundle.putString("productShortdes",frequentModel.get(position).getProductShortdes());
                bundle.putString("productLongDes",frequentModel.get(position).getProductLongDes());
                bundle.putString("productActualAmount",frequentModel.get(position).getProductActualAmount());
                bundle.putString("productFakeAmount",frequentModel.get(position).getProductFakeAmount());
                bundle.putString("productsShelfLife",frequentModel.get(position).getProductsShelfLife());
                bundle.putString("productUnit",frequentModel.get(position).getProductUnit());
                bundle.putString("manufacturerDetails",frequentModel.get(position).getManufacturerDetails());
                bundle.putString("marketedBy",frequentModel.get(position).getMarketedBy());
                bundle.putString("fssaiLicense",frequentModel.get(position).getFssaiLicense());
                bundle.putString("productsDisclaimer",frequentModel.get(position).getProductsDisclaimer());
                bundle.putString("country",frequentModel.get(position).getCountry());
                bundle.putString("customerCareDetails",frequentModel.get(position).getCustomerCareDetails());
                bundle.putString("productsClass",frequentModel.get(position).getProductsClass());
                bundle.putString("seller",frequentModel.get(position).getSeller());
                bundle.putString("ExpiryDate",frequentModel.get(position).getExpiryDate());
                bundle.putInt("image1",frequentModel.get(position).getImage1());
                Intent in = new Intent(ProductDetailsActivity.this,ProductDetailsActivity.class);
                in.putExtras(bundle);
                startActivity(in);
                Animatoo.animateSlideLeft(ProductDetailsActivity.this);

            }
        });
        binding.recycFrequent.setLayoutManager(new LinearLayoutManager(ProductDetailsActivity.this,LinearLayoutManager.HORIZONTAL,false));
        binding.recycFrequent.setAdapter(frequentAdapter);
        frequentAdapter.notifyDataSetChanged();


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        finish();
        Animatoo.animateSlideRight(ProductDetailsActivity.this);
    }
}