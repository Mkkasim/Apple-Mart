package com.krash.applemart.Ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Toast;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.krash.applemart.Adapter.CategoryAdapter;
import com.krash.applemart.Adapter.DropCategoryAdapter;
import com.krash.applemart.Adapter.VariantProductAdapter;
import com.krash.applemart.Adapter.VariantTopicAdapter;
import com.krash.applemart.Model.FruitsVegetablesModel;
import com.krash.applemart.Model.ItemInHomeModel;
import com.krash.applemart.R;
import com.krash.applemart.Ui.FiltersTabs.FilterActivity;
import com.krash.applemart.databinding.ActivityProductsVariantsBinding;

import java.util.ArrayList;

public class ProductsVariantsActivity extends AppCompatActivity {

    ActivityProductsVariantsBinding binding;
    String toolText,comesfrom;

    //Variant Topic
    ArrayList<ItemInHomeModel> topicList = new ArrayList<>();
    VariantTopicAdapter topicAdapter;

    //Variant Product
    ArrayList<FruitsVegetablesModel> productModel = new ArrayList<>();
    VariantProductAdapter productAdapter;

    //category
    DropCategoryAdapter categoryAapter;
    ArrayList<ItemInHomeModel> mainModel = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_products_variants);

        HanleIntent();
        loadVariantTopic();
        loadVariantProduct();

        binding.backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        binding.searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(ProductsVariantsActivity.this,SearchActivity.class);
                in.putExtra("comesfrom","variant");
                startActivity(in);
                Animatoo.animateSlideLeft(ProductsVariantsActivity.this);
            }
        });
        binding.imgFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent in = new Intent(ProductsVariantsActivity.this, FilterActivity.class);
                startActivity(in);
                Animatoo.animateSlideLeft(ProductsVariantsActivity.this);
            }
        });

        binding.topSheetCategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                showBottomDialog();
            }
        });

    }

    private void showBottomDialog() {

        Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.bottom_sheet_category_dialog);



        loadCategory(dialog);

        dialog.show();
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setBackgroundDrawableResource(R.drawable.bg_bottom_round);
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        dialog.getWindow().setGravity(Gravity.TOP);

    }

    private void loadCategory(Dialog dialog) {
        RecyclerView recyc_category = dialog.findViewById(R.id.recy_dialog_category);

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

        categoryAapter = new DropCategoryAdapter(ProductsVariantsActivity.this, mainModel, new DropCategoryAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent in = new Intent(ProductsVariantsActivity.this, ProductsVariantsActivity.class);
                in.putExtra("toolText",mainModel.get(position).getDescText());
                in.putExtra("comesfrom","category");
                startActivity(in);
                Animatoo.animateSlideLeft(ProductsVariantsActivity.this);
                dialog.dismiss();

            }
        });
        recyc_category.setLayoutManager(new GridLayoutManager(ProductsVariantsActivity.this, 4));
        recyc_category.setAdapter(categoryAapter);
        categoryAapter.notifyDataSetChanged();
    }

    private void HanleIntent() {
        toolText = getIntent().getStringExtra("toolText");
        comesfrom = getIntent().getStringExtra("comesfrom");
        binding.toolText.setText(toolText);
    }

    private void loadVariantTopic() {

        topicList.add(new ItemInHomeModel(R.drawable.vegetables_bg,"vegetables"));
        topicList.add(new ItemInHomeModel(R.drawable.fruits_bg,"friuts"));
        topicList.add(new ItemInHomeModel(R.drawable.apple_mart_logo,"exotic &\npremium"));
        topicList.add(new ItemInHomeModel(R.drawable.apple_mart_logo,"organic &\nhydroponic"));
        topicList.add(new ItemInHomeModel(R.drawable.apple_mart_logo,"freshly cut &\nsprouts"));
        topicList.add(new ItemInHomeModel(R.drawable.apple_mart_logo,"frozen veg"));

        topicAdapter = new VariantTopicAdapter(getApplicationContext(), topicList, new VariantTopicAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {

                Toast.makeText(ProductsVariantsActivity.this, ""+topicList.get(position).getDescText(), Toast.LENGTH_SHORT).show();

            }
        });
        binding.recycVariantMain.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false));
        binding.recycVariantMain.setAdapter(topicAdapter);
        topicAdapter.notifyDataSetChanged();

    }

    private void loadVariantProduct() {
        productModel.add(new FruitsVegetablesModel("14%","Ratnagiri Alphonso Mango","Ratnagiri Alphonso Mango",
                "4 pieces (0.8kg - 1kg)","Ratnagiri Alphonso Mango is famous and sweetest mango in india","₹469","₹539","3 days",
                "4 pieces (0.8kg -1kg)","","","","","Canada",
                "","Fruits & Vegetables","Apple Mart Private Limited","2120-03-21",
                R.drawable.apple_logo_bg_removed,R.drawable.apple_splash_logo,R.drawable.home,
                R.drawable.apple_logo_bg_removed));

        productModel.add(new FruitsVegetablesModel("10%","Ratnagiri Alphonso Mango","Ratnagiri Alphonso Mango",
                "4 pieces (0.8kg - 1kg)","Ratnagiri Alphonso Mango is famous and sweetest mango in india","₹469","₹539","3 days",
                "4 pieces (0.8kg -1kg)","","","","","",
                "","","","",
                R.drawable.apple_logo_bg_removed,R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,
                R.drawable.apple_mart_logo));

        productModel.add(new FruitsVegetablesModel("10%","Ratnagiri Alphonso Mango","Ratnagiri Alphonso Mango",
                "4 pieces (0.8kg - 1kg)","Ratnagiri Alphonso Mango is famous and sweetest mango in india","₹469","₹539","3 days",
                "4 pieces (0.8kg -1kg)","","","","","",
                "","","","",
                R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,
                R.drawable.apple_mart_logo));
        productModel.add(new FruitsVegetablesModel("10%","Ratnagiri Alphonso Mango","Ratnagiri Alphonso Mango",
                "4 pieces (0.8kg - 1kg)","Ratnagiri Alphonso Mango is famous and sweetest mango in india","₹469","₹539","3 days",
                "4 pieces (0.8kg -1kg)","","","","","",
                "","","","",
                R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,
                R.drawable.apple_mart_logo));
        productModel.add(new FruitsVegetablesModel("10%","Ratnagiri Alphonso Mango","Ratnagiri Alphonso Mango",
                "4 pieces (0.8kg - 1kg)","Ratnagiri Alphonso Mango is famous and sweetest mango in india","₹469","₹539","3 days",
                "4 pieces (0.8kg -1kg)","","","","","",
                "","","","",
                R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,
                R.drawable.apple_mart_logo));
        productModel.add(new FruitsVegetablesModel("10%","Ratnagiri Alphonso Mango","Ratnagiri Alphonso Mango",
                "4 pieces (0.8kg - 1kg)","Ratnagiri Alphonso Mango is famous and sweetest mango in india","₹469","₹539","3 days",
                "4 pieces (0.8kg -1kg)","","","","","",
                "","","","",
                R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,
                R.drawable.apple_mart_logo));
        productModel.add(new FruitsVegetablesModel("10%","Ratnagiri Alphonso Mango","Ratnagiri Alphonso Mango",
                "4 pieces (0.8kg - 1kg)","Ratnagiri Alphonso Mango is famous and sweetest mango in india","₹469","₹539","3 days",
                "4 pieces (0.8kg -1kg)","","","","","",
                "","","","",
                R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,
                R.drawable.apple_mart_logo));
        productModel.add(new FruitsVegetablesModel("10%","Ratnagiri Alphonso Mango","Ratnagiri Alphonso Mango",
                "4 pieces (0.8kg - 1kg)","Ratnagiri Alphonso Mango is famous and sweetest mango in india","₹469","₹539","3 days",
                "4 pieces (0.8kg -1kg)","","","","","",
                "","","","",
                R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,
                R.drawable.apple_mart_logo));
        productModel.add(new FruitsVegetablesModel("10%","Ratnagiri Alphonso Mango","Ratnagiri Alphonso Mango",
                "4 pieces (0.8kg - 1kg)","Ratnagiri Alphonso Mango is famous and sweetest mango in india","₹469","₹539","3 days",
                "4 pieces (0.8kg -1kg)","","","","","",
                "","","","",
                R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,
                R.drawable.apple_mart_logo));
        productModel.add(new FruitsVegetablesModel("10%","Ratnagiri Alphonso Mango","Ratnagiri Alphonso Mango",
                "4 pieces (0.8kg - 1kg)","Ratnagiri Alphonso Mango is famous and sweetest mango in india","₹469","₹539","3 days",
                "4 pieces (0.8kg -1kg)","","","","","",
                "","","","",
                R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,
                R.drawable.apple_mart_logo));

        productAdapter = new VariantProductAdapter(getApplicationContext(), productModel, new VariantProductAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {

                Bundle bundle = new Bundle();
                bundle.putString("offerPercent",productModel.get(position).getOfferPercent());
                bundle.putString("productShortName",productModel.get(position).getProductShortName());
                bundle.putString("productFullName",productModel.get(position).getProductFullName());
                bundle.putString("productShortdes",productModel.get(position).getProductShortdes());
                bundle.putString("productLongDes",productModel.get(position).getProductLongDes());
                bundle.putString("productActualAmount",productModel.get(position).getProductActualAmount());
                bundle.putString("productFakeAmount",productModel.get(position).getProductFakeAmount());
                bundle.putString("productsShelfLife",productModel.get(position).getProductsShelfLife());
                bundle.putString("productUnit",productModel.get(position).getProductUnit());
                bundle.putString("manufacturerDetails",productModel.get(position).getManufacturerDetails());
                bundle.putString("marketedBy",productModel.get(position).getMarketedBy());
                bundle.putString("fssaiLicense",productModel.get(position).getFssaiLicense());
                bundle.putString("productsDisclaimer",productModel.get(position).getProductsDisclaimer());
                bundle.putString("country",productModel.get(position).getCountry());
                bundle.putString("customerCareDetails",productModel.get(position).getCustomerCareDetails());
                bundle.putString("productsClass",productModel.get(position).getProductsClass());
                bundle.putString("seller",productModel.get(position).getSeller());
                bundle.putString("ExpiryDate",productModel.get(position).getExpiryDate());
                bundle.putInt("image1",productModel.get(position).getImage1());
                bundle.putInt("image2",productModel.get(position).getImage2());
                bundle.putInt("image3",productModel.get(position).getImage3());
                bundle.putInt("image4",productModel.get(position).getImage4());
                Intent in = new Intent(ProductsVariantsActivity.this,ProductDetailsActivity.class);
                in.putExtras(bundle);
                startActivity(in);
                Animatoo.animateSlideLeft(ProductsVariantsActivity.this);
                Toast.makeText(ProductsVariantsActivity.this, ""+productModel.get(position).getProductShortName(), Toast.LENGTH_SHORT).show();
            }
        });

        binding.recycVariantProduct.setLayoutManager(new GridLayoutManager(getApplicationContext(),2));
        binding.recycVariantProduct.setAdapter(productAdapter);
        productAdapter.notifyDataSetChanged();


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        if (comesfrom.equals("home")){
            Intent in = new Intent(ProductsVariantsActivity.this,HomeActivity.class);
            startActivity(in);
            Animatoo.animateSlideRight(ProductsVariantsActivity.this);
        }else if (comesfrom.equals("category")){
//            Intent in = new Intent(ProductsVariantsActivity.this,HomeActivity.class);
//            startActivity(in);
            finish();
            Animatoo.animateSlideRight(ProductsVariantsActivity.this);
        }

    }
}