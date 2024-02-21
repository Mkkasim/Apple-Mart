package com.krash.applemart.Ui.Fragments;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.krash.applemart.Adapter.FruitsVegetablesAdapter;
import com.krash.applemart.Adapter.GotCoveredAdapter;
import com.krash.applemart.Adapter.HomeBan1Adapter;
import com.krash.applemart.Adapter.ItemInHomeAdapter;
import com.krash.applemart.Adapter.MustTryHomeAdapter;
import com.krash.applemart.Adapter.SummerDrinksAdapter;
import com.krash.applemart.Model.FruitsVegetablesModel;
import com.krash.applemart.Model.HomeBan1Model;
import com.krash.applemart.Model.ItemInHomeModel;
import com.krash.applemart.R;
import com.krash.applemart.Ui.ProductDetailsActivity;
import com.krash.applemart.Ui.ProductsVariantsActivity;
import com.krash.applemart.Ui.SearchActivity;
import com.krash.applemart.databinding.FragmentHomeBinding;

import org.imaginativeworld.whynotimagecarousel.model.CarouselGravity;
import org.imaginativeworld.whynotimagecarousel.model.CarouselItem;
import org.imaginativeworld.whynotimagecarousel.model.CarouselType;
import org.imaginativeworld.whynotimagecarousel.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    FragmentHomeBinding binding;

    ///Main Item model and adapter
    ItemInHomeAdapter mainAapter;
    ArrayList<ItemInHomeModel> mainModel = new ArrayList<>();

    //Home Banner 1
    ArrayList<HomeBan1Model> ban1Model = new ArrayList<>();
    HomeBan1Adapter ban1Adapter;

    //Must Try
    ArrayList<ItemInHomeModel> mustModel = new ArrayList<>();
    MustTryHomeAdapter mustAdapter;

    //We Got Covered
    ArrayList<HomeBan1Model> coveredModel = new ArrayList<>();
    GotCoveredAdapter coveredAdapter;

    //Fruits & Vegetable
    ArrayList<FruitsVegetablesModel> vegetablesModel = new ArrayList<>();
    FruitsVegetablesAdapter vegetablesAdapter;

    //image Carausel 1
    List<CarouselItem> carouselList =new ArrayList<>();

    //Summer Drinks
    ArrayList<FruitsVegetablesModel> summerModel = new ArrayList<>();
    SummerDrinksAdapter summerAdapter;

    public HomeFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater,container,false);

        //binding.carousel.registerLifecycle(getViewLifecycleOwner());

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);



        loadAll();

        binding.searchClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(getContext(), SearchActivity.class);
                in.putExtra("comesfrom","home");
                startActivity(in);
                Animatoo.animateSlideLeft(getContext());
                requireActivity().finish();
            }
        });
        BottomNavigationView btmNav = getActivity().findViewById(R.id.chip_bottom_nav);

        binding.seeMoreMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                btmNav.setSelectedItemId(R.id.categories);

            }
        });

    }

    private void loadAll() {
        loadMainItem();
        loadHomeBan1();
        loadMustTry();
        loadGotCovered();
        loadFruitsProducts();
        loadImageCarausel1();
        loadSummerDrinks();
        loadJustChill();
        loadFeelFresh();
        loadSunSafe();
        loadTopSelling();
        loadEveryDayBuys();
        loadKwalityWalls();
        loadChemistStore();
        loadDailyEssential();
        loadBiscuitsSnacks();
        loadBreakFast();
        loadDrinks();
        loadNoodlesInstantFood();
        loadProductsSpotlight();
        loadOrganicHealthy();
        loadNonVegDelights();
        loadBestvalue();
        loadLowestprice();
        loadPersonalCare();
        loadHouseHoldItems();
        loadGroceryStaples();
        loadFrozenDelights();
        loadHouseHoldAcces();
        loadWellnessStore();
        loadKitchenEssential();
        loadBabyCare();
        loadKidsStore();

    }


    private void loadImageCarausel1() {


        binding.carousel.registerLifecycle(getViewLifecycleOwner());

        binding.carousel.setShowTopShadow(false);
        binding.carousel.setTopShadowAlpha(0.6f); // 0 to 1, 1 means 100%
        binding.carousel.setTopShadowHeight(Utils.dpToPx(32, getContext())); // px value of dp

        binding.carousel.setShowBottomShadow(false);
        binding.carousel.setBottomShadowAlpha(0.7f); // 0 to 1, 1 means 100%
        binding.carousel.setBottomShadowHeight(Utils.dpToPx(48, getContext())); // px value of dp

        binding.carousel.setShowCaption(false);
        binding.carousel.setCaptionMargin(Utils.dpToPx(8, getContext())); // px value of dp
        binding.carousel.setCaptionTextSize(Utils.spToPx(16, getContext())); // px value of sp

        binding.carousel.setShowIndicator(false);
        binding.carousel.setIndicatorMargin(Utils.dpToPx(0, getContext())); // px value of dp

        binding.carousel.setImageScaleType(ImageView.ScaleType.CENTER_CROP);

        binding.carousel.setCarouselBackground(new ColorDrawable(Color.parseColor("#ffffff")));
        binding.carousel.setImagePlaceholder(ContextCompat.getDrawable(
                getContext(),
                R.drawable.apple_mart_logo
        ));

//        binding.carousel.setCarouselPadding(Utils.dpToPx(0, context));
//        binding.carousel.setCarouselPaddingStart(Utils.dpToPx(0, context));
//        binding.carousel.setCarouselPaddingTop(Utils.dpToPx(0, context));
//        binding.carousel.setCarouselPaddingEnd(Utils.dpToPx(0, context));
//        binding.carousel.setCarouselPaddingBottom(Utils.dpToPx(0, context));
//
        binding.carousel.setShowNavigationButtons(false);
//        binding.carousel.setPreviousButtonLayout(R.layout.custom_previous_button_layout);
//        binding.carousel.setPreviousButtonId(R.id.custom_btn_previous);
//        binding.carousel.setPreviousButtonMargin(Utils.dpToPx(8, context)); // px value of dp
//        binding.carousel.setNextButtonLayout(R.layout.custom_next_button_layout);
//        binding.carousel.setNextButtonId(R.id.custom_btn_next);
//        binding.carousel.setNextButtonMargin(Utils.dpToPx(8, context)); // px value of dp

        binding.carousel.setCarouselType(CarouselType.SHOWCASE);

        binding.carousel.setCarouselGravity(CarouselGravity.CENTER);

        binding.carousel.setScaleOnScroll(true);
        binding.carousel.setScalingFactor(.15f);
        binding.carousel.setAutoWidthFixing(true);
        binding.carousel.setAutoPlay(true);
        binding.carousel.setAutoPlayDelay(2000); // Milliseconds
        binding.carousel.setInfiniteCarousel(true);
        binding.carousel.setTouchToPause(true);

//        CircleIndicator2 indicator = binding.customIndicator;
//        binding.carousel.setIndicator(indicator);
//
//        MaterialButton previousBtn = binding.btnGotoPrevious;
//        previousBtn.setOnClickListener(v -> binding.carousel.previous());
//
//        MaterialButton nextBtn = binding.btnGotoNext;
//        nextBtn.setOnClickListener(v -> binding.carousel.next());

//        List<CarouselItem> list = new ArrayList<>();

//        // Dummy header
//        Map<String, String> headers = new HashMap<>();
//        headers.put("header_key", "header_value");
//
//        int index = 1;
//        for (String item : DataSet.INSTANCE.getOne()) {
//            list.add(
//                    new CarouselItem(
//                            item,
//                            "Image " + index++ + " of " + DataSet.INSTANCE.getOne().size(),
//                            headers
//                    )
//            );
//        }
//
//        binding.carousel.setData(list);

        // ----------------------------------------------------------------

//        binding.fabPlay.setOnClickListener(v -> {
//            if (isStarted) {
//
//                isStarted = false;
//                binding.carousel.stop();
//
//                binding.fabPlay.setText("Start");
//
//            } else {
//
//                isStarted = true;
//                binding.carousel.start();
//
//                binding.fabPlay.setText("Stop");
//
//            }
//        });

        carouselList.add(new CarouselItem(R.drawable.apple_mart_logo));
        carouselList.add(new CarouselItem(R.drawable.apple_mart_logo));
        carouselList.add(new CarouselItem(R.drawable.apple_mart_logo));
        carouselList.add(new CarouselItem(R.drawable.apple_mart_logo));
        binding.carousel.addData(carouselList);
    }


    private void loadMainItem() {
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

        mainAapter = new ItemInHomeAdapter(getContext(), mainModel, new ItemInHomeAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {

                Intent in = new Intent(getContext(), ProductsVariantsActivity.class);
                in.putExtra("toolText",mainModel.get(position).getDescText());
                in.putExtra("comesfrom","home");
                startActivity(in);
                Animatoo.animateSlideLeft(getContext());
                requireActivity().finish();
                Toast.makeText(getContext(), ""+mainModel.get(position).getDescText(), Toast.LENGTH_SHORT).show();
            }
        });
        binding.recycAll.setLayoutManager(new GridLayoutManager(getContext(),4));
        binding.recycAll.setAdapter(mainAapter);
        mainAapter.notifyDataSetChanged();


    }

    private void loadHomeBan1() {
        ban1Model.add(new HomeBan1Model("sunny days\nare here !","make the most\nof summer","show now",R.drawable.apple_mart_logo));
        ban1Model.add(new HomeBan1Model("sunny days\nare here !","make the most\nof summer","show now",R.drawable.apple_mart_logo));
        ban1Model.add(new HomeBan1Model("sunny days\nare here !","make the most\nof summer","show now",R.drawable.apple_mart_logo));
        ban1Model.add(new HomeBan1Model("sunny days\nare here !","make the most\nof summer","show now",R.drawable.apple_mart_logo));

        ban1Adapter = new HomeBan1Adapter(getContext(), ban1Model, new HomeBan1Adapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Toast.makeText(getContext(), ""+ban1Model.get(position).getTitle(), Toast.LENGTH_SHORT).show();
            }
        });
        binding.recycHomeBan1.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
        binding.recycHomeBan1.setAdapter(ban1Adapter);
        ban1Adapter.notifyDataSetChanged();
    }

    private void loadMustTry() {
        mustModel.add(new ItemInHomeModel("organic &\nhealthy living",R.drawable.apple_mart_logo));
        mustModel.add(new ItemInHomeModel("Consious \nfood",R.drawable.apple_mart_logo));
        mustModel.add(new ItemInHomeModel("Prasuma \nsince 1985",R.drawable.apple_mart_logo));
        mustModel.add(new ItemInHomeModel("Coolberg",R.drawable.apple_mart_logo));
        mustModel.add(new ItemInHomeModel("jade \nforest",R.drawable.apple_mart_logo));
        mustModel.add(new ItemInHomeModel("wickey &\ngud",R.drawable.apple_mart_logo));

        mustAdapter = new MustTryHomeAdapter(getContext(), mustModel, new HomeBan1Adapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Toast.makeText(getContext(), ""+mustModel.get(position).getMustTryText(), Toast.LENGTH_SHORT).show();
            }
        });

        binding.recycMustry.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
        binding.recycMustry.setAdapter(mustAdapter);
        mustAdapter.notifyDataSetChanged();

    }

    private void loadGotCovered() {
        coveredModel.add(new HomeBan1Model("ice cream\nparlour",R.drawable.apple_mart_logo));
        coveredModel.add(new HomeBan1Model("party store",R.drawable.apple_mart_logo));
        coveredModel.add(new HomeBan1Model("paan corner",R.drawable.apple_mart_logo));
        coveredModel.add(new HomeBan1Model("chemist store",R.drawable.apple_mart_logo));
        coveredModel.add(new HomeBan1Model("cosmetic shop",R.drawable.apple_mart_logo));
        coveredModel.add(new HomeBan1Model("stationery &\ngames store",R.drawable.apple_mart_logo));
        coveredModel.add(new HomeBan1Model("office use",R.drawable.apple_mart_logo));

        coveredAdapter = new GotCoveredAdapter(getContext(), coveredModel, new HomeBan1Adapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Toast.makeText(getContext(), ""+coveredModel.get(position).getCoveredtext(), Toast.LENGTH_SHORT).show();
            }
        });

        binding.recycGotCovered.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
        binding.recycGotCovered.setAdapter(coveredAdapter);
        coveredAdapter.notifyDataSetChanged();

    }

    private void loadFruitsProducts() {
        vegetablesModel.add(new FruitsVegetablesModel("10%","Ratnagiri Alphonso Mango","Ratnagiri Alphonso Mango",
                "4 pieces (0.8kg - 1kg)","Ratnagiri Alphonso Mango is famous and sweetest mango in india","₹469","₹539","3 days",
                "4 pieces (0.8kg -1kg)","","","","","",
                "","","","",
                R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,
                R.drawable.apple_mart_logo));

        vegetablesModel.add(new FruitsVegetablesModel("12%","Ratnagiri Orange","Ratnagiri Orange",
                "10 pieces (0.8kg - 1kg)","Ratnagiri Alphonso Mango is famous and sweetest mango in india","₹599","₹639","3 days",
                "4 pieces (0.8kg -1kg)","","","","","",
                "","","","",
                R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,
                R.drawable.apple_mart_logo));

        vegetablesModel.add(new FruitsVegetablesModel("15%","Ratnagiri Banana","Ratnagiri Banana",
                "20 pieces (0.8kg - 1kg)","Ratnagiri Alphonso Mango is famous and sweetest mango in india","₹119","₹299","3 days",
                "20 pieces (0.8kg -1kg)","","","","","",
                "","","","",
                R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,
                R.drawable.apple_mart_logo));

        vegetablesModel.add(new FruitsVegetablesModel("15%","Ratnagiri Banana","Ratnagiri Banana",
                "20 pieces (0.8kg - 1kg)","Ratnagiri Alphonso Mango is famous and sweetest mango in india","₹119","₹299","3 days",
                "20 pieces (0.8kg -1kg)","","","","","",
                "","","","",
                R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,
                R.drawable.apple_mart_logo));

        vegetablesModel.add(new FruitsVegetablesModel("15%","Ratnagiri Banana","Ratnagiri Banana",
                "20 pieces (0.8kg - 1kg)","Ratnagiri Alphonso Mango is famous and sweetest mango in india","₹119","₹299","3 days",
                "20 pieces (0.8kg -1kg)","","","","","",
                "","","","",
                R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,
                R.drawable.apple_mart_logo));

        vegetablesAdapter = new FruitsVegetablesAdapter(getContext(), vegetablesModel, new FruitsVegetablesAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {

                Bundle bundle = new Bundle();
                bundle.putString("offerPercent",vegetablesModel.get(position).getOfferPercent());
                bundle.putString("productShortName",vegetablesModel.get(position).getProductShortName());
                bundle.putString("productFullName",vegetablesModel.get(position).getProductFullName());
                bundle.putString("productShortdes",vegetablesModel.get(position).getProductShortdes());
                bundle.putString("productLongDes",vegetablesModel.get(position).getProductLongDes());
                bundle.putString("productActualAmount",vegetablesModel.get(position).getProductActualAmount());
                bundle.putString("productFakeAmount",vegetablesModel.get(position).getProductFakeAmount());
                bundle.putString("productsShelfLife",vegetablesModel.get(position).getProductsShelfLife());
                bundle.putString("productUnit",vegetablesModel.get(position).getProductUnit());
                bundle.putString("manufacturerDetails",vegetablesModel.get(position).getManufacturerDetails());
                bundle.putString("marketedBy",vegetablesModel.get(position).getMarketedBy());
                bundle.putString("fssaiLicense",vegetablesModel.get(position).getFssaiLicense());
                bundle.putString("productsDisclaimer",vegetablesModel.get(position).getProductsDisclaimer());
                bundle.putString("country",vegetablesModel.get(position).getCountry());
                bundle.putString("customerCareDetails",vegetablesModel.get(position).getCustomerCareDetails());
                bundle.putString("productsClass",vegetablesModel.get(position).getProductsClass());
                bundle.putString("seller",vegetablesModel.get(position).getSeller());
                bundle.putString("ExpiryDate",vegetablesModel.get(position).getExpiryDate());
                bundle.putInt("image1",vegetablesModel.get(position).getImage1());
                bundle.putInt("image2",vegetablesModel.get(position).getImage2());
                bundle.putInt("image3",vegetablesModel.get(position).getImage3());
                bundle.putInt("image4",vegetablesModel.get(position).getImage4());
                Intent in = new Intent(getContext(), ProductDetailsActivity.class);
                in.putExtras(bundle);
                startActivity(in);
                Animatoo.animateSlideLeft(getContext());
                Toast.makeText(getContext(), ""+vegetablesModel.get(position).getProductShortName(), Toast.LENGTH_SHORT).show();
            }
        });
        binding.recycFruitsVegetables.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
        binding.recycFruitsVegetables.setAdapter(vegetablesAdapter);
        vegetablesAdapter.notifyDataSetChanged();


    }

    private void loadSummerDrinks() {
        summerModel.add(new FruitsVegetablesModel("soft drinks",R.drawable.apple_mart_logo));
        summerModel.add(new FruitsVegetablesModel("fruit juices",R.drawable.apple_mart_logo));
        summerModel.add(new FruitsVegetablesModel("milkshake",R.drawable.apple_mart_logo));
        summerModel.add(new FruitsVegetablesModel("lassi &\nbuttermilk",R.drawable.apple_mart_logo));
        summerModel.add(new FruitsVegetablesModel("energy\ndrinks",R.drawable.apple_mart_logo));
        summerModel.add(new FruitsVegetablesModel("soda &\nmixers",R.drawable.apple_mart_logo));
        summerModel.add(new FruitsVegetablesModel("ice cream",R.drawable.apple_mart_logo));
        summerModel.add(new FruitsVegetablesModel("yogurts",R.drawable.apple_mart_logo));

        summerAdapter = new SummerDrinksAdapter(getContext(), summerModel, new SummerDrinksAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {

                Toast.makeText(getContext(), ""+summerModel.get(position).getDrinkText(), Toast.LENGTH_SHORT).show();
            }
        });

        binding.recycSummerDrinks.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
        binding.recycSummerDrinks.setAdapter(summerAdapter);
        summerAdapter.notifyDataSetChanged();
    }

    private void loadJustChill() {
        vegetablesModel.add(new FruitsVegetablesModel("10%","Ratnagiri Alphonso Mango","Ratnagiri Alphonso Mango",
                "4 pieces (0.8kg - 1kg)","Ratnagiri Alphonso Mango is famous and sweetest mango in india","₹469","₹539","3 days",
                "4 pieces (0.8kg -1kg)","","","","","",
                "","","","",
                R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,
                R.drawable.apple_mart_logo));

        vegetablesModel.add(new FruitsVegetablesModel("12%","Ratnagiri Orange","Ratnagiri Orange",
                "10 pieces (0.8kg - 1kg)","Ratnagiri Alphonso Mango is famous and sweetest mango in india","₹599","₹639","3 days",
                "4 pieces (0.8kg -1kg)","","","","","",
                "","","","",
                R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,
                R.drawable.apple_mart_logo));

        vegetablesModel.add(new FruitsVegetablesModel("15%","Ratnagiri Banana","Ratnagiri Banana",
                "20 pieces (0.8kg - 1kg)","Ratnagiri Alphonso Mango is famous and sweetest mango in india","₹119","₹299","3 days",
                "20 pieces (0.8kg -1kg)","","","","","",
                "","","","",
                R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,
                R.drawable.apple_mart_logo));

        vegetablesModel.add(new FruitsVegetablesModel("15%","Ratnagiri Banana","Ratnagiri Banana",
                "20 pieces (0.8kg - 1kg)","Ratnagiri Alphonso Mango is famous and sweetest mango in india","₹119","₹299","3 days",
                "20 pieces (0.8kg -1kg)","","","","","",
                "","","","",
                R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,
                R.drawable.apple_mart_logo));

        vegetablesModel.add(new FruitsVegetablesModel("15%","Ratnagiri Banana","Ratnagiri Banana",
                "20 pieces (0.8kg - 1kg)","Ratnagiri Alphonso Mango is famous and sweetest mango in india","₹119","₹299","3 days",
                "20 pieces (0.8kg -1kg)","","","","","",
                "","","","",
                R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,
                R.drawable.apple_mart_logo));

        vegetablesAdapter = new FruitsVegetablesAdapter(getContext(), vegetablesModel, new FruitsVegetablesAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Toast.makeText(getContext(), ""+vegetablesModel.get(position).getProductShortName(), Toast.LENGTH_SHORT).show();
            }
        });
        binding.recycJustChill.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
        binding.recycJustChill.setAdapter(vegetablesAdapter);
        vegetablesAdapter.notifyDataSetChanged();


    }

    private void loadFeelFresh() {
        vegetablesModel.add(new FruitsVegetablesModel("10%","Ratnagiri Alphonso Mango","Ratnagiri Alphonso Mango",
                "4 pieces (0.8kg - 1kg)","Ratnagiri Alphonso Mango is famous and sweetest mango in india","₹469","₹539","3 days",
                "4 pieces (0.8kg -1kg)","","","","","",
                "","","","",
                R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,
                R.drawable.apple_mart_logo));

        vegetablesModel.add(new FruitsVegetablesModel("12%","Ratnagiri Orange","Ratnagiri Orange",
                "10 pieces (0.8kg - 1kg)","Ratnagiri Alphonso Mango is famous and sweetest mango in india","₹599","₹639","3 days",
                "4 pieces (0.8kg -1kg)","","","","","",
                "","","","",
                R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,
                R.drawable.apple_mart_logo));

        vegetablesModel.add(new FruitsVegetablesModel("15%","Ratnagiri Banana","Ratnagiri Banana",
                "20 pieces (0.8kg - 1kg)","Ratnagiri Alphonso Mango is famous and sweetest mango in india","₹119","₹299","3 days",
                "20 pieces (0.8kg -1kg)","","","","","",
                "","","","",
                R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,
                R.drawable.apple_mart_logo));

        vegetablesModel.add(new FruitsVegetablesModel("15%","Ratnagiri Banana","Ratnagiri Banana",
                "20 pieces (0.8kg - 1kg)","Ratnagiri Alphonso Mango is famous and sweetest mango in india","₹119","₹299","3 days",
                "20 pieces (0.8kg -1kg)","","","","","",
                "","","","",
                R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,
                R.drawable.apple_mart_logo));

        vegetablesModel.add(new FruitsVegetablesModel("15%","Ratnagiri Banana","Ratnagiri Banana",
                "20 pieces (0.8kg - 1kg)","Ratnagiri Alphonso Mango is famous and sweetest mango in india","₹119","₹299","3 days",
                "20 pieces (0.8kg -1kg)","","","","","",
                "","","","",
                R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,
                R.drawable.apple_mart_logo));

        vegetablesAdapter = new FruitsVegetablesAdapter(getContext(), vegetablesModel, new FruitsVegetablesAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Toast.makeText(getContext(), ""+vegetablesModel.get(position).getProductShortName(), Toast.LENGTH_SHORT).show();
            }
        });
        binding.recycFeelFresh.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
        binding.recycFeelFresh.setAdapter(vegetablesAdapter);
        vegetablesAdapter.notifyDataSetChanged();


    }

    private void loadSunSafe() {
        vegetablesModel.add(new FruitsVegetablesModel("10%","Ratnagiri Alphonso Mango","Ratnagiri Alphonso Mango",
                "4 pieces (0.8kg - 1kg)","Ratnagiri Alphonso Mango is famous and sweetest mango in india","₹469","₹539","3 days",
                "4 pieces (0.8kg -1kg)","","","","","",
                "","","","",
                R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,
                R.drawable.apple_mart_logo));

        vegetablesModel.add(new FruitsVegetablesModel("12%","Ratnagiri Orange","Ratnagiri Orange",
                "10 pieces (0.8kg - 1kg)","Ratnagiri Alphonso Mango is famous and sweetest mango in india","₹599","₹639","3 days",
                "4 pieces (0.8kg -1kg)","","","","","",
                "","","","",
                R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,
                R.drawable.apple_mart_logo));

        vegetablesModel.add(new FruitsVegetablesModel("15%","Ratnagiri Banana","Ratnagiri Banana",
                "20 pieces (0.8kg - 1kg)","Ratnagiri Alphonso Mango is famous and sweetest mango in india","₹119","₹299","3 days",
                "20 pieces (0.8kg -1kg)","","","","","",
                "","","","",
                R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,
                R.drawable.apple_mart_logo));

        vegetablesModel.add(new FruitsVegetablesModel("15%","Ratnagiri Banana","Ratnagiri Banana",
                "20 pieces (0.8kg - 1kg)","Ratnagiri Alphonso Mango is famous and sweetest mango in india","₹119","₹299","3 days",
                "20 pieces (0.8kg -1kg)","","","","","",
                "","","","",
                R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,
                R.drawable.apple_mart_logo));

        vegetablesModel.add(new FruitsVegetablesModel("15%","Ratnagiri Banana","Ratnagiri Banana",
                "20 pieces (0.8kg - 1kg)","Ratnagiri Alphonso Mango is famous and sweetest mango in india","₹119","₹299","3 days",
                "20 pieces (0.8kg -1kg)","","","","","",
                "","","","",
                R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,
                R.drawable.apple_mart_logo));

        vegetablesAdapter = new FruitsVegetablesAdapter(getContext(), vegetablesModel, new FruitsVegetablesAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Toast.makeText(getContext(), ""+vegetablesModel.get(position).getProductShortName(), Toast.LENGTH_SHORT).show();
            }
        });
        binding.recycSunSafe.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
        binding.recycSunSafe.setAdapter(vegetablesAdapter);
        vegetablesAdapter.notifyDataSetChanged();


    }

    private void loadTopSelling() {
        vegetablesModel.add(new FruitsVegetablesModel("10%","Ratnagiri Alphonso Mango","Ratnagiri Alphonso Mango",
                "4 pieces (0.8kg - 1kg)","Ratnagiri Alphonso Mango is famous and sweetest mango in india","₹469","₹539","3 days",
                "4 pieces (0.8kg -1kg)","","","","","",
                "","","","",
                R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,
                R.drawable.apple_mart_logo));

        vegetablesModel.add(new FruitsVegetablesModel("12%","Ratnagiri Orange","Ratnagiri Orange",
                "10 pieces (0.8kg - 1kg)","Ratnagiri Alphonso Mango is famous and sweetest mango in india","₹599","₹639","3 days",
                "4 pieces (0.8kg -1kg)","","","","","",
                "","","","",
                R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,
                R.drawable.apple_mart_logo));

        vegetablesModel.add(new FruitsVegetablesModel("15%","Ratnagiri Banana","Ratnagiri Banana",
                "20 pieces (0.8kg - 1kg)","Ratnagiri Alphonso Mango is famous and sweetest mango in india","₹119","₹299","3 days",
                "20 pieces (0.8kg -1kg)","","","","","",
                "","","","",
                R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,
                R.drawable.apple_mart_logo));

        vegetablesModel.add(new FruitsVegetablesModel("15%","Ratnagiri Banana","Ratnagiri Banana",
                "20 pieces (0.8kg - 1kg)","Ratnagiri Alphonso Mango is famous and sweetest mango in india","₹119","₹299","3 days",
                "20 pieces (0.8kg -1kg)","","","","","",
                "","","","",
                R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,
                R.drawable.apple_mart_logo));

        vegetablesModel.add(new FruitsVegetablesModel("15%","Ratnagiri Banana","Ratnagiri Banana",
                "20 pieces (0.8kg - 1kg)","Ratnagiri Alphonso Mango is famous and sweetest mango in india","₹119","₹299","3 days",
                "20 pieces (0.8kg -1kg)","","","","","",
                "","","","",
                R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,
                R.drawable.apple_mart_logo));

        vegetablesAdapter = new FruitsVegetablesAdapter(getContext(), vegetablesModel, new FruitsVegetablesAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Toast.makeText(getContext(), ""+vegetablesModel.get(position).getProductShortName(), Toast.LENGTH_SHORT).show();
            }
        });
        binding.recycTopSelling.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
        binding.recycTopSelling.setAdapter(vegetablesAdapter);
        vegetablesAdapter.notifyDataSetChanged();


    }

    private void loadEveryDayBuys() {
        vegetablesModel.add(new FruitsVegetablesModel("10%","Ratnagiri Alphonso Mango","Ratnagiri Alphonso Mango",
                "4 pieces (0.8kg - 1kg)","Ratnagiri Alphonso Mango is famous and sweetest mango in india","₹469","₹539","3 days",
                "4 pieces (0.8kg -1kg)","","","","","",
                "","","","",
                R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,
                R.drawable.apple_mart_logo));

        vegetablesModel.add(new FruitsVegetablesModel("12%","Ratnagiri Orange","Ratnagiri Orange",
                "10 pieces (0.8kg - 1kg)","Ratnagiri Alphonso Mango is famous and sweetest mango in india","₹599","₹639","3 days",
                "4 pieces (0.8kg -1kg)","","","","","",
                "","","","",
                R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,
                R.drawable.apple_mart_logo));

        vegetablesModel.add(new FruitsVegetablesModel("15%","Ratnagiri Banana","Ratnagiri Banana",
                "20 pieces (0.8kg - 1kg)","Ratnagiri Alphonso Mango is famous and sweetest mango in india","₹119","₹299","3 days",
                "20 pieces (0.8kg -1kg)","","","","","",
                "","","","",
                R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,
                R.drawable.apple_mart_logo));

        vegetablesModel.add(new FruitsVegetablesModel("15%","Ratnagiri Banana","Ratnagiri Banana",
                "20 pieces (0.8kg - 1kg)","Ratnagiri Alphonso Mango is famous and sweetest mango in india","₹119","₹299","3 days",
                "20 pieces (0.8kg -1kg)","","","","","",
                "","","","",
                R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,
                R.drawable.apple_mart_logo));

        vegetablesModel.add(new FruitsVegetablesModel("15%","Ratnagiri Banana","Ratnagiri Banana",
                "20 pieces (0.8kg - 1kg)","Ratnagiri Alphonso Mango is famous and sweetest mango in india","₹119","₹299","3 days",
                "20 pieces (0.8kg -1kg)","","","","","",
                "","","","",
                R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,
                R.drawable.apple_mart_logo));

        vegetablesAdapter = new FruitsVegetablesAdapter(getContext(), vegetablesModel, new FruitsVegetablesAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Toast.makeText(getContext(), ""+vegetablesModel.get(position).getProductShortName(), Toast.LENGTH_SHORT).show();
            }
        });
        binding.recycEverydayBuy.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
        binding.recycEverydayBuy.setAdapter(vegetablesAdapter);
        vegetablesAdapter.notifyDataSetChanged();


    }

    private void loadKwalityWalls() {
        vegetablesModel.add(new FruitsVegetablesModel("10%","Ratnagiri Alphonso Mango","Ratnagiri Alphonso Mango",
                "4 pieces (0.8kg - 1kg)","Ratnagiri Alphonso Mango is famous and sweetest mango in india","₹469","₹539","3 days",
                "4 pieces (0.8kg -1kg)","","","","","",
                "","","","",
                R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,
                R.drawable.apple_mart_logo));

        vegetablesModel.add(new FruitsVegetablesModel("12%","Ratnagiri Orange","Ratnagiri Orange",
                "10 pieces (0.8kg - 1kg)","Ratnagiri Alphonso Mango is famous and sweetest mango in india","₹599","₹639","3 days",
                "4 pieces (0.8kg -1kg)","","","","","",
                "","","","",
                R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,
                R.drawable.apple_mart_logo));

        vegetablesModel.add(new FruitsVegetablesModel("15%","Ratnagiri Banana","Ratnagiri Banana",
                "20 pieces (0.8kg - 1kg)","Ratnagiri Alphonso Mango is famous and sweetest mango in india","₹119","₹299","3 days",
                "20 pieces (0.8kg -1kg)","","","","","",
                "","","","",
                R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,
                R.drawable.apple_mart_logo));

        vegetablesModel.add(new FruitsVegetablesModel("15%","Ratnagiri Banana","Ratnagiri Banana",
                "20 pieces (0.8kg - 1kg)","Ratnagiri Alphonso Mango is famous and sweetest mango in india","₹119","₹299","3 days",
                "20 pieces (0.8kg -1kg)","","","","","",
                "","","","",
                R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,
                R.drawable.apple_mart_logo));

        vegetablesModel.add(new FruitsVegetablesModel("15%","Ratnagiri Banana","Ratnagiri Banana",
                "20 pieces (0.8kg - 1kg)","Ratnagiri Alphonso Mango is famous and sweetest mango in india","₹119","₹299","3 days",
                "20 pieces (0.8kg -1kg)","","","","","",
                "","","","",
                R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,
                R.drawable.apple_mart_logo));

        vegetablesAdapter = new FruitsVegetablesAdapter(getContext(), vegetablesModel, new FruitsVegetablesAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Toast.makeText(getContext(), ""+vegetablesModel.get(position).getProductShortName(), Toast.LENGTH_SHORT).show();
            }
        });
        binding.recycKwalityWalls.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
        binding.recycKwalityWalls.setAdapter(vegetablesAdapter);
        vegetablesAdapter.notifyDataSetChanged();


    }

    private void loadChemistStore() {
        vegetablesModel.add(new FruitsVegetablesModel("10%","Ratnagiri Alphonso Mango","Ratnagiri Alphonso Mango",
                "4 pieces (0.8kg - 1kg)","Ratnagiri Alphonso Mango is famous and sweetest mango in india","₹469","₹539","3 days",
                "4 pieces (0.8kg -1kg)","","","","","",
                "","","","",
                R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,
                R.drawable.apple_mart_logo));

        vegetablesModel.add(new FruitsVegetablesModel("12%","Ratnagiri Orange","Ratnagiri Orange",
                "10 pieces (0.8kg - 1kg)","Ratnagiri Alphonso Mango is famous and sweetest mango in india","₹599","₹639","3 days",
                "4 pieces (0.8kg -1kg)","","","","","",
                "","","","",
                R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,
                R.drawable.apple_mart_logo));

        vegetablesModel.add(new FruitsVegetablesModel("15%","Ratnagiri Banana","Ratnagiri Banana",
                "20 pieces (0.8kg - 1kg)","Ratnagiri Alphonso Mango is famous and sweetest mango in india","₹119","₹299","3 days",
                "20 pieces (0.8kg -1kg)","","","","","",
                "","","","",
                R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,
                R.drawable.apple_mart_logo));

        vegetablesModel.add(new FruitsVegetablesModel("15%","Ratnagiri Banana","Ratnagiri Banana",
                "20 pieces (0.8kg - 1kg)","Ratnagiri Alphonso Mango is famous and sweetest mango in india","₹119","₹299","3 days",
                "20 pieces (0.8kg -1kg)","","","","","",
                "","","","",
                R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,
                R.drawable.apple_mart_logo));

        vegetablesModel.add(new FruitsVegetablesModel("15%","Ratnagiri Banana","Ratnagiri Banana",
                "20 pieces (0.8kg - 1kg)","Ratnagiri Alphonso Mango is famous and sweetest mango in india","₹119","₹299","3 days",
                "20 pieces (0.8kg -1kg)","","","","","",
                "","","","",
                R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,
                R.drawable.apple_mart_logo));

        vegetablesAdapter = new FruitsVegetablesAdapter(getContext(), vegetablesModel, new FruitsVegetablesAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Toast.makeText(getContext(), ""+vegetablesModel.get(position).getProductShortName(), Toast.LENGTH_SHORT).show();
            }
        });
        binding.recycChemistStore.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
        binding.recycChemistStore.setAdapter(vegetablesAdapter);
        vegetablesAdapter.notifyDataSetChanged();


    }

    private void loadDailyEssential() {
        vegetablesModel.add(new FruitsVegetablesModel("10%","Ratnagiri Alphonso Mango","Ratnagiri Alphonso Mango",
                "4 pieces (0.8kg - 1kg)","Ratnagiri Alphonso Mango is famous and sweetest mango in india","₹469","₹539","3 days",
                "4 pieces (0.8kg -1kg)","","","","","",
                "","","","",
                R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,
                R.drawable.apple_mart_logo));

        vegetablesModel.add(new FruitsVegetablesModel("12%","Ratnagiri Orange","Ratnagiri Orange",
                "10 pieces (0.8kg - 1kg)","Ratnagiri Alphonso Mango is famous and sweetest mango in india","₹599","₹639","3 days",
                "4 pieces (0.8kg -1kg)","","","","","",
                "","","","",
                R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,
                R.drawable.apple_mart_logo));

        vegetablesModel.add(new FruitsVegetablesModel("15%","Ratnagiri Banana","Ratnagiri Banana",
                "20 pieces (0.8kg - 1kg)","Ratnagiri Alphonso Mango is famous and sweetest mango in india","₹119","₹299","3 days",
                "20 pieces (0.8kg -1kg)","","","","","",
                "","","","",
                R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,
                R.drawable.apple_mart_logo));

        vegetablesModel.add(new FruitsVegetablesModel("15%","Ratnagiri Banana","Ratnagiri Banana",
                "20 pieces (0.8kg - 1kg)","Ratnagiri Alphonso Mango is famous and sweetest mango in india","₹119","₹299","3 days",
                "20 pieces (0.8kg -1kg)","","","","","",
                "","","","",
                R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,
                R.drawable.apple_mart_logo));

        vegetablesModel.add(new FruitsVegetablesModel("15%","Ratnagiri Banana","Ratnagiri Banana",
                "20 pieces (0.8kg - 1kg)","Ratnagiri Alphonso Mango is famous and sweetest mango in india","₹119","₹299","3 days",
                "20 pieces (0.8kg -1kg)","","","","","",
                "","","","",
                R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,
                R.drawable.apple_mart_logo));

        vegetablesAdapter = new FruitsVegetablesAdapter(getContext(), vegetablesModel, new FruitsVegetablesAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Toast.makeText(getContext(), ""+vegetablesModel.get(position).getProductShortName(), Toast.LENGTH_SHORT).show();
            }
        });
        binding.recycDailyEssential.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
        binding.recycDailyEssential.setAdapter(vegetablesAdapter);
        vegetablesAdapter.notifyDataSetChanged();


    }

    private void loadBiscuitsSnacks() {
        vegetablesModel.add(new FruitsVegetablesModel("10%","Ratnagiri Alphonso Mango","Ratnagiri Alphonso Mango",
                "4 pieces (0.8kg - 1kg)","Ratnagiri Alphonso Mango is famous and sweetest mango in india","₹469","₹539","3 days",
                "4 pieces (0.8kg -1kg)","","","","","",
                "","","","",
                R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,
                R.drawable.apple_mart_logo));

        vegetablesModel.add(new FruitsVegetablesModel("12%","Ratnagiri Orange","Ratnagiri Orange",
                "10 pieces (0.8kg - 1kg)","Ratnagiri Alphonso Mango is famous and sweetest mango in india","₹599","₹639","3 days",
                "4 pieces (0.8kg -1kg)","","","","","",
                "","","","",
                R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,
                R.drawable.apple_mart_logo));

        vegetablesModel.add(new FruitsVegetablesModel("15%","Ratnagiri Banana","Ratnagiri Banana",
                "20 pieces (0.8kg - 1kg)","Ratnagiri Alphonso Mango is famous and sweetest mango in india","₹119","₹299","3 days",
                "20 pieces (0.8kg -1kg)","","","","","",
                "","","","",
                R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,
                R.drawable.apple_mart_logo));

        vegetablesModel.add(new FruitsVegetablesModel("15%","Ratnagiri Banana","Ratnagiri Banana",
                "20 pieces (0.8kg - 1kg)","Ratnagiri Alphonso Mango is famous and sweetest mango in india","₹119","₹299","3 days",
                "20 pieces (0.8kg -1kg)","","","","","",
                "","","","",
                R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,
                R.drawable.apple_mart_logo));

        vegetablesModel.add(new FruitsVegetablesModel("15%","Ratnagiri Banana","Ratnagiri Banana",
                "20 pieces (0.8kg - 1kg)","Ratnagiri Alphonso Mango is famous and sweetest mango in india","₹119","₹299","3 days",
                "20 pieces (0.8kg -1kg)","","","","","",
                "","","","",
                R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,
                R.drawable.apple_mart_logo));

        vegetablesAdapter = new FruitsVegetablesAdapter(getContext(), vegetablesModel, new FruitsVegetablesAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Toast.makeText(getContext(), ""+vegetablesModel.get(position).getProductShortName(), Toast.LENGTH_SHORT).show();
            }
        });
        binding.recycSnacks.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
        binding.recycSnacks.setAdapter(vegetablesAdapter);
        vegetablesAdapter.notifyDataSetChanged();


    }

    private void loadBreakFast() {
        vegetablesModel.add(new FruitsVegetablesModel("10%","Ratnagiri Alphonso Mango","Ratnagiri Alphonso Mango",
                "4 pieces (0.8kg - 1kg)","Ratnagiri Alphonso Mango is famous and sweetest mango in india","₹469","₹539","3 days",
                "4 pieces (0.8kg -1kg)","","","","","",
                "","","","",
                R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,
                R.drawable.apple_mart_logo));

        vegetablesModel.add(new FruitsVegetablesModel("12%","Ratnagiri Orange","Ratnagiri Orange",
                "10 pieces (0.8kg - 1kg)","Ratnagiri Alphonso Mango is famous and sweetest mango in india","₹599","₹639","3 days",
                "4 pieces (0.8kg -1kg)","","","","","",
                "","","","",
                R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,
                R.drawable.apple_mart_logo));

        vegetablesModel.add(new FruitsVegetablesModel("15%","Ratnagiri Banana","Ratnagiri Banana",
                "20 pieces (0.8kg - 1kg)","Ratnagiri Alphonso Mango is famous and sweetest mango in india","₹119","₹299","3 days",
                "20 pieces (0.8kg -1kg)","","","","","",
                "","","","",
                R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,
                R.drawable.apple_mart_logo));

        vegetablesModel.add(new FruitsVegetablesModel("15%","Ratnagiri Banana","Ratnagiri Banana",
                "20 pieces (0.8kg - 1kg)","Ratnagiri Alphonso Mango is famous and sweetest mango in india","₹119","₹299","3 days",
                "20 pieces (0.8kg -1kg)","","","","","",
                "","","","",
                R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,
                R.drawable.apple_mart_logo));

        vegetablesModel.add(new FruitsVegetablesModel("15%","Ratnagiri Banana","Ratnagiri Banana",
                "20 pieces (0.8kg - 1kg)","Ratnagiri Alphonso Mango is famous and sweetest mango in india","₹119","₹299","3 days",
                "20 pieces (0.8kg -1kg)","","","","","",
                "","","","",
                R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,
                R.drawable.apple_mart_logo));

        vegetablesAdapter = new FruitsVegetablesAdapter(getContext(), vegetablesModel, new FruitsVegetablesAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Toast.makeText(getContext(), ""+vegetablesModel.get(position).getProductShortName(), Toast.LENGTH_SHORT).show();
            }
        });
        binding.recycBreakfast.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
        binding.recycBreakfast.setAdapter(vegetablesAdapter);
        vegetablesAdapter.notifyDataSetChanged();


    }

    private void loadDrinks() {
        vegetablesModel.add(new FruitsVegetablesModel("10%","Ratnagiri Alphonso Mango","Ratnagiri Alphonso Mango",
                "4 pieces (0.8kg - 1kg)","Ratnagiri Alphonso Mango is famous and sweetest mango in india","₹469","₹539","3 days",
                "4 pieces (0.8kg -1kg)","","","","","",
                "","","","",
                R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,
                R.drawable.apple_mart_logo));

        vegetablesModel.add(new FruitsVegetablesModel("12%","Ratnagiri Orange","Ratnagiri Orange",
                "10 pieces (0.8kg - 1kg)","Ratnagiri Alphonso Mango is famous and sweetest mango in india","₹599","₹639","3 days",
                "4 pieces (0.8kg -1kg)","","","","","",
                "","","","",
                R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,
                R.drawable.apple_mart_logo));

        vegetablesModel.add(new FruitsVegetablesModel("15%","Ratnagiri Banana","Ratnagiri Banana",
                "20 pieces (0.8kg - 1kg)","Ratnagiri Alphonso Mango is famous and sweetest mango in india","₹119","₹299","3 days",
                "20 pieces (0.8kg -1kg)","","","","","",
                "","","","",
                R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,
                R.drawable.apple_mart_logo));

        vegetablesModel.add(new FruitsVegetablesModel("15%","Ratnagiri Banana","Ratnagiri Banana",
                "20 pieces (0.8kg - 1kg)","Ratnagiri Alphonso Mango is famous and sweetest mango in india","₹119","₹299","3 days",
                "20 pieces (0.8kg -1kg)","","","","","",
                "","","","",
                R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,
                R.drawable.apple_mart_logo));

        vegetablesModel.add(new FruitsVegetablesModel("15%","Ratnagiri Banana","Ratnagiri Banana",
                "20 pieces (0.8kg - 1kg)","Ratnagiri Alphonso Mango is famous and sweetest mango in india","₹119","₹299","3 days",
                "20 pieces (0.8kg -1kg)","","","","","",
                "","","","",
                R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,
                R.drawable.apple_mart_logo));

        vegetablesAdapter = new FruitsVegetablesAdapter(getContext(), vegetablesModel, new FruitsVegetablesAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Toast.makeText(getContext(), ""+vegetablesModel.get(position).getProductShortName(), Toast.LENGTH_SHORT).show();
            }
        });
        binding.recycDrinks.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
        binding.recycDrinks.setAdapter(vegetablesAdapter);
        vegetablesAdapter.notifyDataSetChanged();


    }

    private void loadNoodlesInstantFood() {
        vegetablesModel.add(new FruitsVegetablesModel("10%","Ratnagiri Alphonso Mango","Ratnagiri Alphonso Mango",
                "4 pieces (0.8kg - 1kg)","Ratnagiri Alphonso Mango is famous and sweetest mango in india","₹469","₹539","3 days",
                "4 pieces (0.8kg -1kg)","","","","","",
                "","","","",
                R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,
                R.drawable.apple_mart_logo));

        vegetablesModel.add(new FruitsVegetablesModel("12%","Ratnagiri Orange","Ratnagiri Orange",
                "10 pieces (0.8kg - 1kg)","Ratnagiri Alphonso Mango is famous and sweetest mango in india","₹599","₹639","3 days",
                "4 pieces (0.8kg -1kg)","","","","","",
                "","","","",
                R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,
                R.drawable.apple_mart_logo));

        vegetablesModel.add(new FruitsVegetablesModel("15%","Ratnagiri Banana","Ratnagiri Banana",
                "20 pieces (0.8kg - 1kg)","Ratnagiri Alphonso Mango is famous and sweetest mango in india","₹119","₹299","3 days",
                "20 pieces (0.8kg -1kg)","","","","","",
                "","","","",
                R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,
                R.drawable.apple_mart_logo));

        vegetablesModel.add(new FruitsVegetablesModel("15%","Ratnagiri Banana","Ratnagiri Banana",
                "20 pieces (0.8kg - 1kg)","Ratnagiri Alphonso Mango is famous and sweetest mango in india","₹119","₹299","3 days",
                "20 pieces (0.8kg -1kg)","","","","","",
                "","","","",
                R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,
                R.drawable.apple_mart_logo));

        vegetablesModel.add(new FruitsVegetablesModel("15%","Ratnagiri Banana","Ratnagiri Banana",
                "20 pieces (0.8kg - 1kg)","Ratnagiri Alphonso Mango is famous and sweetest mango in india","₹119","₹299","3 days",
                "20 pieces (0.8kg -1kg)","","","","","",
                "","","","",
                R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,
                R.drawable.apple_mart_logo));

        vegetablesAdapter = new FruitsVegetablesAdapter(getContext(), vegetablesModel, new FruitsVegetablesAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Toast.makeText(getContext(), ""+vegetablesModel.get(position).getProductShortName(), Toast.LENGTH_SHORT).show();
            }
        });
        binding.recycNoodles.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
        binding.recycNoodles.setAdapter(vegetablesAdapter);
        vegetablesAdapter.notifyDataSetChanged();


    }

    private void loadProductsSpotlight() {
        vegetablesModel.add(new FruitsVegetablesModel("10%","Ratnagiri Alphonso Mango","Ratnagiri Alphonso Mango",
                "4 pieces (0.8kg - 1kg)","Ratnagiri Alphonso Mango is famous and sweetest mango in india","₹469","₹539","3 days",
                "4 pieces (0.8kg -1kg)","","","","","",
                "","","","",
                R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,
                R.drawable.apple_mart_logo));

        vegetablesModel.add(new FruitsVegetablesModel("12%","Ratnagiri Orange","Ratnagiri Orange",
                "10 pieces (0.8kg - 1kg)","Ratnagiri Alphonso Mango is famous and sweetest mango in india","₹599","₹639","3 days",
                "4 pieces (0.8kg -1kg)","","","","","",
                "","","","",
                R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,
                R.drawable.apple_mart_logo));

        vegetablesModel.add(new FruitsVegetablesModel("15%","Ratnagiri Banana","Ratnagiri Banana",
                "20 pieces (0.8kg - 1kg)","Ratnagiri Alphonso Mango is famous and sweetest mango in india","₹119","₹299","3 days",
                "20 pieces (0.8kg -1kg)","","","","","",
                "","","","",
                R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,
                R.drawable.apple_mart_logo));

        vegetablesModel.add(new FruitsVegetablesModel("15%","Ratnagiri Banana","Ratnagiri Banana",
                "20 pieces (0.8kg - 1kg)","Ratnagiri Alphonso Mango is famous and sweetest mango in india","₹119","₹299","3 days",
                "20 pieces (0.8kg -1kg)","","","","","",
                "","","","",
                R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,
                R.drawable.apple_mart_logo));

        vegetablesModel.add(new FruitsVegetablesModel("15%","Ratnagiri Banana","Ratnagiri Banana",
                "20 pieces (0.8kg - 1kg)","Ratnagiri Alphonso Mango is famous and sweetest mango in india","₹119","₹299","3 days",
                "20 pieces (0.8kg -1kg)","","","","","",
                "","","","",
                R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,
                R.drawable.apple_mart_logo));

        vegetablesAdapter = new FruitsVegetablesAdapter(getContext(), vegetablesModel, new FruitsVegetablesAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Toast.makeText(getContext(), ""+vegetablesModel.get(position).getProductShortName(), Toast.LENGTH_SHORT).show();
            }
        });
        binding.recycProducts.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
        binding.recycProducts.setAdapter(vegetablesAdapter);
        vegetablesAdapter.notifyDataSetChanged();


    }

    private void loadOrganicHealthy() {
        vegetablesModel.add(new FruitsVegetablesModel("10%","Ratnagiri Alphonso Mango","Ratnagiri Alphonso Mango",
                "4 pieces (0.8kg - 1kg)","Ratnagiri Alphonso Mango is famous and sweetest mango in india","₹469","₹539","3 days",
                "4 pieces (0.8kg -1kg)","","","","","",
                "","","","",
                R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,
                R.drawable.apple_mart_logo));

        vegetablesModel.add(new FruitsVegetablesModel("12%","Ratnagiri Orange","Ratnagiri Orange",
                "10 pieces (0.8kg - 1kg)","Ratnagiri Alphonso Mango is famous and sweetest mango in india","₹599","₹639","3 days",
                "4 pieces (0.8kg -1kg)","","","","","",
                "","","","",
                R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,
                R.drawable.apple_mart_logo));

        vegetablesModel.add(new FruitsVegetablesModel("15%","Ratnagiri Banana","Ratnagiri Banana",
                "20 pieces (0.8kg - 1kg)","Ratnagiri Alphonso Mango is famous and sweetest mango in india","₹119","₹299","3 days",
                "20 pieces (0.8kg -1kg)","","","","","",
                "","","","",
                R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,
                R.drawable.apple_mart_logo));

        vegetablesModel.add(new FruitsVegetablesModel("15%","Ratnagiri Banana","Ratnagiri Banana",
                "20 pieces (0.8kg - 1kg)","Ratnagiri Alphonso Mango is famous and sweetest mango in india","₹119","₹299","3 days",
                "20 pieces (0.8kg -1kg)","","","","","",
                "","","","",
                R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,
                R.drawable.apple_mart_logo));

        vegetablesModel.add(new FruitsVegetablesModel("15%","Ratnagiri Banana","Ratnagiri Banana",
                "20 pieces (0.8kg - 1kg)","Ratnagiri Alphonso Mango is famous and sweetest mango in india","₹119","₹299","3 days",
                "20 pieces (0.8kg -1kg)","","","","","",
                "","","","",
                R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,
                R.drawable.apple_mart_logo));

        vegetablesAdapter = new FruitsVegetablesAdapter(getContext(), vegetablesModel, new FruitsVegetablesAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Toast.makeText(getContext(), ""+vegetablesModel.get(position).getProductShortName(), Toast.LENGTH_SHORT).show();
            }
        });
        binding.recycOrganic.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
        binding.recycOrganic.setAdapter(vegetablesAdapter);
        vegetablesAdapter.notifyDataSetChanged();


    }

    private void loadNonVegDelights() {
        vegetablesModel.add(new FruitsVegetablesModel("10%","Ratnagiri Alphonso Mango","Ratnagiri Alphonso Mango",
                "4 pieces (0.8kg - 1kg)","Ratnagiri Alphonso Mango is famous and sweetest mango in india","₹469","₹539","3 days",
                "4 pieces (0.8kg -1kg)","","","","","",
                "","","","",
                R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,
                R.drawable.apple_mart_logo));

        vegetablesModel.add(new FruitsVegetablesModel("12%","Ratnagiri Orange","Ratnagiri Orange",
                "10 pieces (0.8kg - 1kg)","Ratnagiri Alphonso Mango is famous and sweetest mango in india","₹599","₹639","3 days",
                "4 pieces (0.8kg -1kg)","","","","","",
                "","","","",
                R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,
                R.drawable.apple_mart_logo));

        vegetablesModel.add(new FruitsVegetablesModel("15%","Ratnagiri Banana","Ratnagiri Banana",
                "20 pieces (0.8kg - 1kg)","Ratnagiri Alphonso Mango is famous and sweetest mango in india","₹119","₹299","3 days",
                "20 pieces (0.8kg -1kg)","","","","","",
                "","","","",
                R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,
                R.drawable.apple_mart_logo));

        vegetablesModel.add(new FruitsVegetablesModel("15%","Ratnagiri Banana","Ratnagiri Banana",
                "20 pieces (0.8kg - 1kg)","Ratnagiri Alphonso Mango is famous and sweetest mango in india","₹119","₹299","3 days",
                "20 pieces (0.8kg -1kg)","","","","","",
                "","","","",
                R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,
                R.drawable.apple_mart_logo));

        vegetablesModel.add(new FruitsVegetablesModel("15%","Ratnagiri Banana","Ratnagiri Banana",
                "20 pieces (0.8kg - 1kg)","Ratnagiri Alphonso Mango is famous and sweetest mango in india","₹119","₹299","3 days",
                "20 pieces (0.8kg -1kg)","","","","","",
                "","","","",
                R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,
                R.drawable.apple_mart_logo));

        vegetablesAdapter = new FruitsVegetablesAdapter(getContext(), vegetablesModel, new FruitsVegetablesAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Toast.makeText(getContext(), ""+vegetablesModel.get(position).getProductShortName(), Toast.LENGTH_SHORT).show();
            }
        });
        binding.recycNonVeg.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
        binding.recycNonVeg.setAdapter(vegetablesAdapter);
        vegetablesAdapter.notifyDataSetChanged();


    }

    private void loadBestvalue() {
        vegetablesModel.add(new FruitsVegetablesModel("10%","Ratnagiri Alphonso Mango","Ratnagiri Alphonso Mango",
                "4 pieces (0.8kg - 1kg)","Ratnagiri Alphonso Mango is famous and sweetest mango in india","₹469","₹539","3 days",
                "4 pieces (0.8kg -1kg)","","","","","",
                "","","","",
                R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,
                R.drawable.apple_mart_logo));

        vegetablesModel.add(new FruitsVegetablesModel("12%","Ratnagiri Orange","Ratnagiri Orange",
                "10 pieces (0.8kg - 1kg)","Ratnagiri Alphonso Mango is famous and sweetest mango in india","₹599","₹639","3 days",
                "4 pieces (0.8kg -1kg)","","","","","",
                "","","","",
                R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,
                R.drawable.apple_mart_logo));

        vegetablesModel.add(new FruitsVegetablesModel("15%","Ratnagiri Banana","Ratnagiri Banana",
                "20 pieces (0.8kg - 1kg)","Ratnagiri Alphonso Mango is famous and sweetest mango in india","₹119","₹299","3 days",
                "20 pieces (0.8kg -1kg)","","","","","",
                "","","","",
                R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,
                R.drawable.apple_mart_logo));

        vegetablesModel.add(new FruitsVegetablesModel("15%","Ratnagiri Banana","Ratnagiri Banana",
                "20 pieces (0.8kg - 1kg)","Ratnagiri Alphonso Mango is famous and sweetest mango in india","₹119","₹299","3 days",
                "20 pieces (0.8kg -1kg)","","","","","",
                "","","","",
                R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,
                R.drawable.apple_mart_logo));

        vegetablesModel.add(new FruitsVegetablesModel("15%","Ratnagiri Banana","Ratnagiri Banana",
                "20 pieces (0.8kg - 1kg)","Ratnagiri Alphonso Mango is famous and sweetest mango in india","₹119","₹299","3 days",
                "20 pieces (0.8kg -1kg)","","","","","",
                "","","","",
                R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,
                R.drawable.apple_mart_logo));

        vegetablesAdapter = new FruitsVegetablesAdapter(getContext(), vegetablesModel, new FruitsVegetablesAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Toast.makeText(getContext(), ""+vegetablesModel.get(position).getProductShortName(), Toast.LENGTH_SHORT).show();
            }
        });
        binding.recycBestValue.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
        binding.recycBestValue.setAdapter(vegetablesAdapter);
        vegetablesAdapter.notifyDataSetChanged();


    }

    private void loadLowestprice() {
        vegetablesModel.add(new FruitsVegetablesModel("10%","Ratnagiri Alphonso Mango","Ratnagiri Alphonso Mango",
                "4 pieces (0.8kg - 1kg)","Ratnagiri Alphonso Mango is famous and sweetest mango in india","₹469","₹539","3 days",
                "4 pieces (0.8kg -1kg)","","","","","",
                "","","","",
                R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,
                R.drawable.apple_mart_logo));

        vegetablesModel.add(new FruitsVegetablesModel("12%","Ratnagiri Orange","Ratnagiri Orange",
                "10 pieces (0.8kg - 1kg)","Ratnagiri Alphonso Mango is famous and sweetest mango in india","₹599","₹639","3 days",
                "4 pieces (0.8kg -1kg)","","","","","",
                "","","","",
                R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,
                R.drawable.apple_mart_logo));

        vegetablesModel.add(new FruitsVegetablesModel("15%","Ratnagiri Banana","Ratnagiri Banana",
                "20 pieces (0.8kg - 1kg)","Ratnagiri Alphonso Mango is famous and sweetest mango in india","₹119","₹299","3 days",
                "20 pieces (0.8kg -1kg)","","","","","",
                "","","","",
                R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,
                R.drawable.apple_mart_logo));

        vegetablesModel.add(new FruitsVegetablesModel("15%","Ratnagiri Banana","Ratnagiri Banana",
                "20 pieces (0.8kg - 1kg)","Ratnagiri Alphonso Mango is famous and sweetest mango in india","₹119","₹299","3 days",
                "20 pieces (0.8kg -1kg)","","","","","",
                "","","","",
                R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,
                R.drawable.apple_mart_logo));

        vegetablesModel.add(new FruitsVegetablesModel("15%","Ratnagiri Banana","Ratnagiri Banana",
                "20 pieces (0.8kg - 1kg)","Ratnagiri Alphonso Mango is famous and sweetest mango in india","₹119","₹299","3 days",
                "20 pieces (0.8kg -1kg)","","","","","",
                "","","","",
                R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,
                R.drawable.apple_mart_logo));

        vegetablesAdapter = new FruitsVegetablesAdapter(getContext(), vegetablesModel, new FruitsVegetablesAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Toast.makeText(getContext(), ""+vegetablesModel.get(position).getProductShortName(), Toast.LENGTH_SHORT).show();
            }
        });
        binding.recycLowestPrice.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
        binding.recycLowestPrice.setAdapter(vegetablesAdapter);
        vegetablesAdapter.notifyDataSetChanged();


    }

    private void loadPersonalCare() {
        vegetablesModel.add(new FruitsVegetablesModel("10%","Ratnagiri Alphonso Mango","Ratnagiri Alphonso Mango",
                "4 pieces (0.8kg - 1kg)","Ratnagiri Alphonso Mango is famous and sweetest mango in india","₹469","₹539","3 days",
                "4 pieces (0.8kg -1kg)","","","","","",
                "","","","",
                R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,
                R.drawable.apple_mart_logo));

        vegetablesModel.add(new FruitsVegetablesModel("12%","Ratnagiri Orange","Ratnagiri Orange",
                "10 pieces (0.8kg - 1kg)","Ratnagiri Alphonso Mango is famous and sweetest mango in india","₹599","₹639","3 days",
                "4 pieces (0.8kg -1kg)","","","","","",
                "","","","",
                R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,
                R.drawable.apple_mart_logo));

        vegetablesModel.add(new FruitsVegetablesModel("15%","Ratnagiri Banana","Ratnagiri Banana",
                "20 pieces (0.8kg - 1kg)","Ratnagiri Alphonso Mango is famous and sweetest mango in india","₹119","₹299","3 days",
                "20 pieces (0.8kg -1kg)","","","","","",
                "","","","",
                R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,
                R.drawable.apple_mart_logo));

        vegetablesModel.add(new FruitsVegetablesModel("15%","Ratnagiri Banana","Ratnagiri Banana",
                "20 pieces (0.8kg - 1kg)","Ratnagiri Alphonso Mango is famous and sweetest mango in india","₹119","₹299","3 days",
                "20 pieces (0.8kg -1kg)","","","","","",
                "","","","",
                R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,
                R.drawable.apple_mart_logo));

        vegetablesModel.add(new FruitsVegetablesModel("15%","Ratnagiri Banana","Ratnagiri Banana",
                "20 pieces (0.8kg - 1kg)","Ratnagiri Alphonso Mango is famous and sweetest mango in india","₹119","₹299","3 days",
                "20 pieces (0.8kg -1kg)","","","","","",
                "","","","",
                R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,
                R.drawable.apple_mart_logo));

        vegetablesAdapter = new FruitsVegetablesAdapter(getContext(), vegetablesModel, new FruitsVegetablesAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Toast.makeText(getContext(), ""+vegetablesModel.get(position).getProductShortName(), Toast.LENGTH_SHORT).show();
            }
        });
        binding.recycPersonalCare.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
        binding.recycPersonalCare.setAdapter(vegetablesAdapter);
        vegetablesAdapter.notifyDataSetChanged();


    }

    private void loadHouseHoldItems() {
        vegetablesModel.add(new FruitsVegetablesModel("10%","Ratnagiri Alphonso Mango","Ratnagiri Alphonso Mango",
                "4 pieces (0.8kg - 1kg)","Ratnagiri Alphonso Mango is famous and sweetest mango in india","₹469","₹539","3 days",
                "4 pieces (0.8kg -1kg)","","","","","",
                "","","","",
                R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,
                R.drawable.apple_mart_logo));

        vegetablesModel.add(new FruitsVegetablesModel("12%","Ratnagiri Orange","Ratnagiri Orange",
                "10 pieces (0.8kg - 1kg)","Ratnagiri Alphonso Mango is famous and sweetest mango in india","₹599","₹639","3 days",
                "4 pieces (0.8kg -1kg)","","","","","",
                "","","","",
                R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,
                R.drawable.apple_mart_logo));

        vegetablesModel.add(new FruitsVegetablesModel("15%","Ratnagiri Banana","Ratnagiri Banana",
                "20 pieces (0.8kg - 1kg)","Ratnagiri Alphonso Mango is famous and sweetest mango in india","₹119","₹299","3 days",
                "20 pieces (0.8kg -1kg)","","","","","",
                "","","","",
                R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,
                R.drawable.apple_mart_logo));

        vegetablesModel.add(new FruitsVegetablesModel("15%","Ratnagiri Banana","Ratnagiri Banana",
                "20 pieces (0.8kg - 1kg)","Ratnagiri Alphonso Mango is famous and sweetest mango in india","₹119","₹299","3 days",
                "20 pieces (0.8kg -1kg)","","","","","",
                "","","","",
                R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,
                R.drawable.apple_mart_logo));

        vegetablesModel.add(new FruitsVegetablesModel("15%","Ratnagiri Banana","Ratnagiri Banana",
                "20 pieces (0.8kg - 1kg)","Ratnagiri Alphonso Mango is famous and sweetest mango in india","₹119","₹299","3 days",
                "20 pieces (0.8kg -1kg)","","","","","",
                "","","","",
                R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,
                R.drawable.apple_mart_logo));

        vegetablesAdapter = new FruitsVegetablesAdapter(getContext(), vegetablesModel, new FruitsVegetablesAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Toast.makeText(getContext(), ""+vegetablesModel.get(position).getProductShortName(), Toast.LENGTH_SHORT).show();
            }
        });
        binding.recycHousehholds.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
        binding.recycHousehholds.setAdapter(vegetablesAdapter);
        vegetablesAdapter.notifyDataSetChanged();


    }

    private void loadGroceryStaples() {
        vegetablesModel.add(new FruitsVegetablesModel("10%","Ratnagiri Alphonso Mango","Ratnagiri Alphonso Mango",
                "4 pieces (0.8kg - 1kg)","Ratnagiri Alphonso Mango is famous and sweetest mango in india","₹469","₹539","3 days",
                "4 pieces (0.8kg -1kg)","","","","","",
                "","","","",
                R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,
                R.drawable.apple_mart_logo));

        vegetablesModel.add(new FruitsVegetablesModel("12%","Ratnagiri Orange","Ratnagiri Orange",
                "10 pieces (0.8kg - 1kg)","Ratnagiri Alphonso Mango is famous and sweetest mango in india","₹599","₹639","3 days",
                "4 pieces (0.8kg -1kg)","","","","","",
                "","","","",
                R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,
                R.drawable.apple_mart_logo));

        vegetablesModel.add(new FruitsVegetablesModel("15%","Ratnagiri Banana","Ratnagiri Banana",
                "20 pieces (0.8kg - 1kg)","Ratnagiri Alphonso Mango is famous and sweetest mango in india","₹119","₹299","3 days",
                "20 pieces (0.8kg -1kg)","","","","","",
                "","","","",
                R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,
                R.drawable.apple_mart_logo));

        vegetablesModel.add(new FruitsVegetablesModel("15%","Ratnagiri Banana","Ratnagiri Banana",
                "20 pieces (0.8kg - 1kg)","Ratnagiri Alphonso Mango is famous and sweetest mango in india","₹119","₹299","3 days",
                "20 pieces (0.8kg -1kg)","","","","","",
                "","","","",
                R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,
                R.drawable.apple_mart_logo));

        vegetablesModel.add(new FruitsVegetablesModel("15%","Ratnagiri Banana","Ratnagiri Banana",
                "20 pieces (0.8kg - 1kg)","Ratnagiri Alphonso Mango is famous and sweetest mango in india","₹119","₹299","3 days",
                "20 pieces (0.8kg -1kg)","","","","","",
                "","","","",
                R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,
                R.drawable.apple_mart_logo));

        vegetablesAdapter = new FruitsVegetablesAdapter(getContext(), vegetablesModel, new FruitsVegetablesAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Toast.makeText(getContext(), ""+vegetablesModel.get(position).getProductShortName(), Toast.LENGTH_SHORT).show();
            }
        });
        binding.recycGrocery.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
        binding.recycGrocery.setAdapter(vegetablesAdapter);
        vegetablesAdapter.notifyDataSetChanged();


    }

    private void loadFrozenDelights() {
        vegetablesModel.add(new FruitsVegetablesModel("10%","Ratnagiri Alphonso Mango","Ratnagiri Alphonso Mango",
                "4 pieces (0.8kg - 1kg)","Ratnagiri Alphonso Mango is famous and sweetest mango in india","₹469","₹539","3 days",
                "4 pieces (0.8kg -1kg)","","","","","",
                "","","","",
                R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,
                R.drawable.apple_mart_logo));

        vegetablesModel.add(new FruitsVegetablesModel("12%","Ratnagiri Orange","Ratnagiri Orange",
                "10 pieces (0.8kg - 1kg)","Ratnagiri Alphonso Mango is famous and sweetest mango in india","₹599","₹639","3 days",
                "4 pieces (0.8kg -1kg)","","","","","",
                "","","","",
                R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,
                R.drawable.apple_mart_logo));

        vegetablesModel.add(new FruitsVegetablesModel("15%","Ratnagiri Banana","Ratnagiri Banana",
                "20 pieces (0.8kg - 1kg)","Ratnagiri Alphonso Mango is famous and sweetest mango in india","₹119","₹299","3 days",
                "20 pieces (0.8kg -1kg)","","","","","",
                "","","","",
                R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,
                R.drawable.apple_mart_logo));

        vegetablesModel.add(new FruitsVegetablesModel("15%","Ratnagiri Banana","Ratnagiri Banana",
                "20 pieces (0.8kg - 1kg)","Ratnagiri Alphonso Mango is famous and sweetest mango in india","₹119","₹299","3 days",
                "20 pieces (0.8kg -1kg)","","","","","",
                "","","","",
                R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,
                R.drawable.apple_mart_logo));

        vegetablesModel.add(new FruitsVegetablesModel("15%","Ratnagiri Banana","Ratnagiri Banana",
                "20 pieces (0.8kg - 1kg)","Ratnagiri Alphonso Mango is famous and sweetest mango in india","₹119","₹299","3 days",
                "20 pieces (0.8kg -1kg)","","","","","",
                "","","","",
                R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,
                R.drawable.apple_mart_logo));

        vegetablesAdapter = new FruitsVegetablesAdapter(getContext(), vegetablesModel, new FruitsVegetablesAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Toast.makeText(getContext(), ""+vegetablesModel.get(position).getProductShortName(), Toast.LENGTH_SHORT).show();
            }
        });
        binding.recycFrozen.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
        binding.recycFrozen.setAdapter(vegetablesAdapter);
        vegetablesAdapter.notifyDataSetChanged();


    }

    private void loadHouseHoldAcces() {
        vegetablesModel.add(new FruitsVegetablesModel("10%","Ratnagiri Alphonso Mango","Ratnagiri Alphonso Mango",
                "4 pieces (0.8kg - 1kg)","Ratnagiri Alphonso Mango is famous and sweetest mango in india","₹469","₹539","3 days",
                "4 pieces (0.8kg -1kg)","","","","","",
                "","","","",
                R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,
                R.drawable.apple_mart_logo));

        vegetablesModel.add(new FruitsVegetablesModel("12%","Ratnagiri Orange","Ratnagiri Orange",
                "10 pieces (0.8kg - 1kg)","Ratnagiri Alphonso Mango is famous and sweetest mango in india","₹599","₹639","3 days",
                "4 pieces (0.8kg -1kg)","","","","","",
                "","","","",
                R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,
                R.drawable.apple_mart_logo));

        vegetablesModel.add(new FruitsVegetablesModel("15%","Ratnagiri Banana","Ratnagiri Banana",
                "20 pieces (0.8kg - 1kg)","Ratnagiri Alphonso Mango is famous and sweetest mango in india","₹119","₹299","3 days",
                "20 pieces (0.8kg -1kg)","","","","","",
                "","","","",
                R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,
                R.drawable.apple_mart_logo));

        vegetablesModel.add(new FruitsVegetablesModel("15%","Ratnagiri Banana","Ratnagiri Banana",
                "20 pieces (0.8kg - 1kg)","Ratnagiri Alphonso Mango is famous and sweetest mango in india","₹119","₹299","3 days",
                "20 pieces (0.8kg -1kg)","","","","","",
                "","","","",
                R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,
                R.drawable.apple_mart_logo));

        vegetablesModel.add(new FruitsVegetablesModel("15%","Ratnagiri Banana","Ratnagiri Banana",
                "20 pieces (0.8kg - 1kg)","Ratnagiri Alphonso Mango is famous and sweetest mango in india","₹119","₹299","3 days",
                "20 pieces (0.8kg -1kg)","","","","","",
                "","","","",
                R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,
                R.drawable.apple_mart_logo));

        vegetablesAdapter = new FruitsVegetablesAdapter(getContext(), vegetablesModel, new FruitsVegetablesAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Toast.makeText(getContext(), ""+vegetablesModel.get(position).getProductShortName(), Toast.LENGTH_SHORT).show();
            }
        });
        binding.recycAccessories.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
        binding.recycAccessories.setAdapter(vegetablesAdapter);
        vegetablesAdapter.notifyDataSetChanged();


    }

    private void loadWellnessStore() {
        vegetablesModel.add(new FruitsVegetablesModel("10%","Ratnagiri Alphonso Mango","Ratnagiri Alphonso Mango",
                "4 pieces (0.8kg - 1kg)","Ratnagiri Alphonso Mango is famous and sweetest mango in india","₹469","₹539","3 days",
                "4 pieces (0.8kg -1kg)","","","","","",
                "","","","",
                R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,
                R.drawable.apple_mart_logo));

        vegetablesModel.add(new FruitsVegetablesModel("12%","Ratnagiri Orange","Ratnagiri Orange",
                "10 pieces (0.8kg - 1kg)","Ratnagiri Alphonso Mango is famous and sweetest mango in india","₹599","₹639","3 days",
                "4 pieces (0.8kg -1kg)","","","","","",
                "","","","",
                R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,
                R.drawable.apple_mart_logo));

        vegetablesModel.add(new FruitsVegetablesModel("15%","Ratnagiri Banana","Ratnagiri Banana",
                "20 pieces (0.8kg - 1kg)","Ratnagiri Alphonso Mango is famous and sweetest mango in india","₹119","₹299","3 days",
                "20 pieces (0.8kg -1kg)","","","","","",
                "","","","",
                R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,
                R.drawable.apple_mart_logo));

        vegetablesModel.add(new FruitsVegetablesModel("15%","Ratnagiri Banana","Ratnagiri Banana",
                "20 pieces (0.8kg - 1kg)","Ratnagiri Alphonso Mango is famous and sweetest mango in india","₹119","₹299","3 days",
                "20 pieces (0.8kg -1kg)","","","","","",
                "","","","",
                R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,
                R.drawable.apple_mart_logo));

        vegetablesModel.add(new FruitsVegetablesModel("15%","Ratnagiri Banana","Ratnagiri Banana",
                "20 pieces (0.8kg - 1kg)","Ratnagiri Alphonso Mango is famous and sweetest mango in india","₹119","₹299","3 days",
                "20 pieces (0.8kg -1kg)","","","","","",
                "","","","",
                R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,
                R.drawable.apple_mart_logo));

        vegetablesAdapter = new FruitsVegetablesAdapter(getContext(), vegetablesModel, new FruitsVegetablesAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Toast.makeText(getContext(), ""+vegetablesModel.get(position).getProductShortName(), Toast.LENGTH_SHORT).show();
            }
        });
        binding.recycWellness.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
        binding.recycWellness.setAdapter(vegetablesAdapter);
        vegetablesAdapter.notifyDataSetChanged();


    }

    private void loadKitchenEssential() {
        vegetablesModel.add(new FruitsVegetablesModel("10%","Ratnagiri Alphonso Mango","Ratnagiri Alphonso Mango",
                "4 pieces (0.8kg - 1kg)","Ratnagiri Alphonso Mango is famous and sweetest mango in india","₹469","₹539","3 days",
                "4 pieces (0.8kg -1kg)","","","","","",
                "","","","",
                R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,
                R.drawable.apple_mart_logo));

        vegetablesModel.add(new FruitsVegetablesModel("12%","Ratnagiri Orange","Ratnagiri Orange",
                "10 pieces (0.8kg - 1kg)","Ratnagiri Alphonso Mango is famous and sweetest mango in india","₹599","₹639","3 days",
                "4 pieces (0.8kg -1kg)","","","","","",
                "","","","",
                R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,
                R.drawable.apple_mart_logo));

        vegetablesModel.add(new FruitsVegetablesModel("15%","Ratnagiri Banana","Ratnagiri Banana",
                "20 pieces (0.8kg - 1kg)","Ratnagiri Alphonso Mango is famous and sweetest mango in india","₹119","₹299","3 days",
                "20 pieces (0.8kg -1kg)","","","","","",
                "","","","",
                R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,
                R.drawable.apple_mart_logo));

        vegetablesModel.add(new FruitsVegetablesModel("15%","Ratnagiri Banana","Ratnagiri Banana",
                "20 pieces (0.8kg - 1kg)","Ratnagiri Alphonso Mango is famous and sweetest mango in india","₹119","₹299","3 days",
                "20 pieces (0.8kg -1kg)","","","","","",
                "","","","",
                R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,
                R.drawable.apple_mart_logo));

        vegetablesModel.add(new FruitsVegetablesModel("15%","Ratnagiri Banana","Ratnagiri Banana",
                "20 pieces (0.8kg - 1kg)","Ratnagiri Alphonso Mango is famous and sweetest mango in india","₹119","₹299","3 days",
                "20 pieces (0.8kg -1kg)","","","","","",
                "","","","",
                R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,
                R.drawable.apple_mart_logo));

        vegetablesAdapter = new FruitsVegetablesAdapter(getContext(), vegetablesModel, new FruitsVegetablesAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Toast.makeText(getContext(), ""+vegetablesModel.get(position).getProductShortName(), Toast.LENGTH_SHORT).show();
            }
        });
        binding.recycKitchen.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
        binding.recycKitchen.setAdapter(vegetablesAdapter);
        vegetablesAdapter.notifyDataSetChanged();


    }

    private void loadBabyCare() {
        vegetablesModel.add(new FruitsVegetablesModel("10%","Ratnagiri Alphonso Mango","Ratnagiri Alphonso Mango",
                "4 pieces (0.8kg - 1kg)","Ratnagiri Alphonso Mango is famous and sweetest mango in india","₹469","₹539","3 days",
                "4 pieces (0.8kg -1kg)","","","","","",
                "","","","",
                R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,
                R.drawable.apple_mart_logo));

        vegetablesModel.add(new FruitsVegetablesModel("12%","Ratnagiri Orange","Ratnagiri Orange",
                "10 pieces (0.8kg - 1kg)","Ratnagiri Alphonso Mango is famous and sweetest mango in india","₹599","₹639","3 days",
                "4 pieces (0.8kg -1kg)","","","","","",
                "","","","",
                R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,
                R.drawable.apple_mart_logo));

        vegetablesModel.add(new FruitsVegetablesModel("15%","Ratnagiri Banana","Ratnagiri Banana",
                "20 pieces (0.8kg - 1kg)","Ratnagiri Alphonso Mango is famous and sweetest mango in india","₹119","₹299","3 days",
                "20 pieces (0.8kg -1kg)","","","","","",
                "","","","",
                R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,
                R.drawable.apple_mart_logo));

        vegetablesModel.add(new FruitsVegetablesModel("15%","Ratnagiri Banana","Ratnagiri Banana",
                "20 pieces (0.8kg - 1kg)","Ratnagiri Alphonso Mango is famous and sweetest mango in india","₹119","₹299","3 days",
                "20 pieces (0.8kg -1kg)","","","","","",
                "","","","",
                R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,
                R.drawable.apple_mart_logo));

        vegetablesModel.add(new FruitsVegetablesModel("15%","Ratnagiri Banana","Ratnagiri Banana",
                "20 pieces (0.8kg - 1kg)","Ratnagiri Alphonso Mango is famous and sweetest mango in india","₹119","₹299","3 days",
                "20 pieces (0.8kg -1kg)","","","","","",
                "","","","",
                R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,
                R.drawable.apple_mart_logo));

        vegetablesAdapter = new FruitsVegetablesAdapter(getContext(), vegetablesModel, new FruitsVegetablesAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Toast.makeText(getContext(), ""+vegetablesModel.get(position).getProductShortName(), Toast.LENGTH_SHORT).show();
            }
        });
        binding.recycBabyCare.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
        binding.recycBabyCare.setAdapter(vegetablesAdapter);
        vegetablesAdapter.notifyDataSetChanged();


    }

    private void loadKidsStore() {
        vegetablesModel.add(new FruitsVegetablesModel("10%","Ratnagiri Alphonso Mango","Ratnagiri Alphonso Mango",
                "4 pieces (0.8kg - 1kg)","Ratnagiri Alphonso Mango is famous and sweetest mango in india","₹469","₹539","3 days",
                "4 pieces (0.8kg -1kg)","","","","","",
                "","","","",
                R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,
                R.drawable.apple_mart_logo));

        vegetablesModel.add(new FruitsVegetablesModel("12%","Ratnagiri Orange","Ratnagiri Orange",
                "10 pieces (0.8kg - 1kg)","Ratnagiri Alphonso Mango is famous and sweetest mango in india","₹599","₹639","3 days",
                "4 pieces (0.8kg -1kg)","","","","","",
                "","","","",
                R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,
                R.drawable.apple_mart_logo));

        vegetablesModel.add(new FruitsVegetablesModel("15%","Ratnagiri Banana","Ratnagiri Banana",
                "20 pieces (0.8kg - 1kg)","Ratnagiri Alphonso Mango is famous and sweetest mango in india","₹119","₹299","3 days",
                "20 pieces (0.8kg -1kg)","","","","","",
                "","","","",
                R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,
                R.drawable.apple_mart_logo));

        vegetablesModel.add(new FruitsVegetablesModel("15%","Ratnagiri Banana","Ratnagiri Banana",
                "20 pieces (0.8kg - 1kg)","Ratnagiri Alphonso Mango is famous and sweetest mango in india","₹119","₹299","3 days",
                "20 pieces (0.8kg -1kg)","","","","","",
                "","","","",
                R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,
                R.drawable.apple_mart_logo));

        vegetablesModel.add(new FruitsVegetablesModel("15%","Ratnagiri Banana","Ratnagiri Banana",
                "20 pieces (0.8kg - 1kg)","Ratnagiri Alphonso Mango is famous and sweetest mango in india","₹119","₹299","3 days",
                "20 pieces (0.8kg -1kg)","","","","","",
                "","","","",
                R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,R.drawable.apple_mart_logo,
                R.drawable.apple_mart_logo));

        vegetablesAdapter = new FruitsVegetablesAdapter(getContext(), vegetablesModel, new FruitsVegetablesAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Toast.makeText(getContext(), ""+vegetablesModel.get(position).getProductShortName(), Toast.LENGTH_SHORT).show();
            }
        });
        binding.recycKidsStore.setLayoutManager(new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false));
        binding.recycKidsStore.setAdapter(vegetablesAdapter);
        vegetablesAdapter.notifyDataSetChanged();


    }

}