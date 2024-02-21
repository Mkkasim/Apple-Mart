package com.krash.applemart.Ui.FiltersTabs;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.krash.applemart.R;
import com.krash.applemart.Ui.ProductsVariantsActivity;
import com.krash.applemart.Ui.SearchActivity;
import com.krash.applemart.databinding.ActivityFilterBinding;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import q.rorbin.verticaltablayout.TabAdapter;
import q.rorbin.verticaltablayout.VerticalTabLayout;

public class FilterActivity extends AppCompatActivity {

    ActivityFilterBinding binding;

    CheckBox brand1,brand2,brand3,brand4,type1,type2,type3,type4,type5,type6,pack1kg,pack2kg,pack3kg,pack4kg,pack5kg,pack6kg;
    String b1,b2,b3,b4,t1,t2,t3,t4,t5,t6,p1kg,p2kg,p3kg,p4kg,p5kg,p6kg;

    ArrayList<String> checks = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_filter);

//        initTab0();
//        initTab1();
//        initTab2();
        initTab3();

        binding.backBtn.setOnClickListener(view -> {

           onBackPressed();

        });

        binding.apply.setOnClickListener(view -> {

            StringBuilder stringBuilder = new StringBuilder();
            for (String s : checks)
                stringBuilder.append(s).append("\n");
            Toast.makeText(this, ""+stringBuilder.toString(), Toast.LENGTH_SHORT).show();

        });

        binding.search.setOnClickListener(view -> {

            Intent in = new Intent(this, SearchActivity.class);
            in.putExtra("comesfrom","filter");
            startActivity(in);
            Animatoo.animateSlideLeft(this);

        });

    }

//    private void initTab0() {
//        VerticalTabLayout tablayout = (VerticalTabLayout) findViewById(R.id.tablayout0);
//        tablayout.setTabAdapter(new MyTabAdapter(this));
//    }
//
//    private void initTab1() {
//        VerticalTabLayout tablayout = (VerticalTabLayout) findViewById(R.id.tablayout1);
//        tablayout.setTabAdapter(new MyTabAdapter(this));
//    }
//
//    private void initTab2() {
//        VerticalTabLayout tablayout = (VerticalTabLayout) findViewById(R.id.tablayout2);
//        tablayout.setTabAdapter(new MyTabAdapter(this));
//    }

    private void initTab3() {
        VerticalTabLayout tablayout = (VerticalTabLayout) findViewById(R.id.tablayout);
        ViewPager viewpager = (ViewPager) findViewById(R.id.viewpager);
        viewpager.setAdapter(new MyPagerAdapter(this));
        tablayout.setupWithViewPager(viewpager);
    }

    class MyTabAdapter implements TabAdapter {

        List<String> titles;
        Context context;

        MyTabAdapter(Context context){
            this.context = context;
        }


        {
            titles = new ArrayList<String>();
            Collections.addAll(titles, "Android", "IOS", "Web", "JAVA", "C++",
                    ".NET", "JavaScript", "Swift", "PHP", "Python", "C#", "Groovy", "SQL", "Ruby");
        }

        @Override
        public int getCount() {
            return 14;
        }

        @SuppressLint("InflateParams")
        @Override
        public View getTabItemView(int position) {
            LayoutInflater li = LayoutInflater.from(this.context);
            View v = li.inflate(R.layout.view_tab_item, null);
            TextView titleTv = v.findViewById(R.id.titleTv);
            titleTv.setText(titles.get(position));
            return v;
        }
    }

    class MyPagerAdapter extends PagerAdapter implements TabAdapter {
        List<MenuBean> menus;

        Context context;

        public MyPagerAdapter(Context context) {
            this.context = context;

            menus = new ArrayList<>();
            Collections.addAll(menus, new MenuBean("Sort By")
                    , new MenuBean("Brand")
                    , new MenuBean( "Type")
                    , new MenuBean("Pack Size"));
        }

        @Override
        public int getCount() {
            return 4;
        }

        @SuppressLint("InflateParams")
        @Override
        public View getTabItemView(int position) {
            LayoutInflater li = LayoutInflater.from(context);
            View v = li.inflate(R.layout.view_tab_item, null);


            TextView titleTv = v.findViewById(R.id.titleTv);

            MenuBean menu = menus.get(position);
            titleTv.setText(menu.mTitle);
//            imgView.setImageResource(menu.mNormalIcon);


            return v;
        }


        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
//            TextView tv = new TextView(FilterActivity.this);
//            tv.setText("" + position);
//            container.addView(tv);

            switch (position){
                case 0:
                    LayoutInflater li = LayoutInflater.from(context);
                    View v = li.inflate(R.layout.items_in_filter_tabs, null);

                    RelativeLayout relate_sort = v.findViewById(R.id.relate_sort);
                    relate_sort.setVisibility(View.VISIBLE);
                    container.addView(v);

                    return v;
                case 1:
                    LayoutInflater li1 = LayoutInflater.from(context);
                    View v1 = li1.inflate(R.layout.items_in_filter_tabs, null);

                    LinearLayout relate_brand = v1.findViewById(R.id.relate_brand);
                    relate_brand.setVisibility(View.VISIBLE);

                    brand1 = v1.findViewById(R.id.brand1);
                    brand2 = v1.findViewById(R.id.brand2);
                    brand3 = v1.findViewById(R.id.brand3);
                    brand4 = v1.findViewById(R.id.brand4);

                    checksClicks();

                    container.addView(v1);

                    return v1;
                case 2:
                    LayoutInflater li2 = LayoutInflater.from(context);
                    View v2 = li2.inflate(R.layout.items_in_filter_tabs, null);

                    type1 = v2.findViewById(R.id.Type1);
                    type2 = v2.findViewById(R.id.Type2);
                    type3 = v2.findViewById(R.id.Type3);
                    type4 = v2.findViewById(R.id.Type4);
                    type5 = v2.findViewById(R.id.Type5);
                    type6 = v2.findViewById(R.id.Type6);

                    checksClicks2();

                    LinearLayout relate_type = v2.findViewById(R.id.relate_type);
                    relate_type.setVisibility(View.VISIBLE);
                    container.addView(v2);

                    return v2;
                case 3:
                    LayoutInflater li3 = LayoutInflater.from(context);
                    View v3 = li3.inflate(R.layout.items_in_filter_tabs, null);
                    pack1kg = v3.findViewById(R.id.kg1);
                    pack2kg = v3.findViewById(R.id.kg2);
                    pack3kg = v3.findViewById(R.id.kg3);
                    pack4kg = v3.findViewById(R.id.kg4);
                    pack5kg = v3.findViewById(R.id.kg5);
                    pack6kg = v3.findViewById(R.id.kg6);

                    checksClicks3();

                    LinearLayout relate_packSize = v3.findViewById(R.id.relate_packSize);
                    relate_packSize.setVisibility(View.VISIBLE);
                    container.addView(v3);

                    return v3;
            }


            return container;
//            return tv;
        }

        private void checksClicks3() {
            pack1kg.setOnClickListener(view -> {
                if (pack1kg.isChecked()){
                    checks.add("1kg");
                }else{
                    checks.remove("1kg");
                }
            });
            pack2kg.setOnClickListener(view -> {
                if (pack2kg.isChecked()){
                    checks.add("2kg");
                }else{
                    checks.remove("2kg");
                }
            });
            pack3kg.setOnClickListener(view -> {
                if (pack3kg.isChecked()){
                    checks.add("3kg");
                }else{
                    checks.remove("3kg");
                }
            });
            pack4kg.setOnClickListener(view -> {
                if (pack4kg.isChecked()){
                    checks.add("4kg");
                }else{
                    checks.remove("4kg");
                }
            });
            pack5kg.setOnClickListener(view -> {
                if (pack5kg.isChecked()){
                    checks.add("5kg");
                }else{
                    checks.remove("5kg");
                }
            });
            pack6kg.setOnClickListener(view -> {
                if (pack6kg.isChecked()){
                    checks.add("6kg");
                }else{
                    checks.remove("6kg");
                }
            });
        }

        private void checksClicks2() {
            type1.setOnClickListener(view -> {
                if (type1.isChecked()){
                    checks.add("type1");
                }else{
                    checks.remove("type1");
                }
            });
            type2.setOnClickListener(view -> {
                if (type2.isChecked()){
                    checks.add("type2");
                }else{
                    checks.remove("type2");
                }
            });
            type3.setOnClickListener(view -> {
                if (type3.isChecked()){
                    checks.add("type3");
                }else{
                    checks.remove("type3");
                }
            });
            type4.setOnClickListener(view -> {
                if (type4.isChecked()){
                    checks.add("type4");
                }else{
                    checks.remove("type4");
                }
            });
            type5.setOnClickListener(view -> {
                if (type5.isChecked()){
                    checks.add("type5");
                }else{
                    checks.remove("type5");
                }
            });
            type6.setOnClickListener(view -> {
                if (type1.isChecked()){
                    checks.add("type6");
                }else{
                    checks.remove("type6");
                }
            });
        }

        private void checksClicks() {
            brand1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (brand1.isChecked()){
                        checks.add("brand1");
                    }else {
                        checks.remove("brand1");
                    }
                }
            });
            brand2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (brand2.isChecked()){
                        checks.add("brand2");
                    }else {
                        checks.remove("brand2");
                    }
                }
            });
            brand3.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (brand3.isChecked()){
                        checks.add("brand3");
                    }else {
                        checks.remove("brand3");
                    }
                }
            });
            brand4.setOnClickListener(view -> {
                if (brand4.isChecked()){
                    checks.add("brand4");
                }else {
                    checks.remove("brand4");
                }
            });

        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        finish();
        Animatoo.animateSlideRight(this);

    }
}