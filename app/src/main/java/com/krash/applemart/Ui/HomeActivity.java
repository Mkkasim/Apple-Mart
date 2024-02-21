package com.krash.applemart.Ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.krash.applemart.R;
import com.krash.applemart.Ui.Fragments.AccountFragment;
import com.krash.applemart.Ui.Fragments.CategoryFragment;
import com.krash.applemart.Ui.Fragments.HomeFragment;
import com.krash.applemart.Ui.Fragments.OffersFragment;
import com.krash.applemart.databinding.ActivityHomeBinding;

public class HomeActivity extends AppCompatActivity {

    ActivityHomeBinding binding;
    int startingPosition = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(this,R.layout.activity_home);

//        getSupportFragmentManager().beginTransaction().replace(R.id.frag_cont,new HomeFragment()).commit();
        loadFragment(new HomeFragment(), 1);

        binding.chipBottomNav.setSelectedItemId(R.id.home);
        setBottomNav();




    }



    private void setBottomNav() {


        binding.chipBottomNav.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                Fragment fragment = null;
                int newPosition = 0;


                switch (item.getItemId()){
                    case R.id.home:
                        fragment = new HomeFragment();
                        newPosition = 1;
                        break;
                    case R.id.categories:
                        fragment = new CategoryFragment();
                        newPosition = 2;
                        break;
                    case R.id.search:
                        Intent in = new Intent(HomeActivity.this,SearchActivity.class);
                        in.putExtra("comesfrom","home");
                        startActivity(in);
                        finish();
                        break;
                    case R.id.offers:
                        fragment = new OffersFragment();
                        newPosition = 4;
                        break;
                    case R.id.account:
                        fragment = new AccountFragment();
                        newPosition = 5;
                        break;

                }
                loadFragment(fragment,newPosition);


                return true;
            }
        });

//        binding.chipBottomNav.setOnItemSelectedListener(new ChipNavigationBar.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(int i) {
//                Fragment fragment = null;
//                int newPosition = 0;
//
//
//                switch (i){
//                    case R.id.home:
//                        fragment = new HomeFragment();
//                        newPosition = 1;
//                        break;
//                    case R.id.categories:
//                        fragment = new CategoryFragment();
//                        newPosition = 2;
//                        break;
//                    case R.id.search:
//                        Intent in = new Intent(HomeActivity.this,SearchActivity.class);
//                        startActivity(in);
//                        finish();
//                        break;
//                    case R.id.offers:
//                        fragment = new HomeFragment();
//                        newPosition = 4;
//                        break;
//                    case R.id.account:
//                        fragment = new HomeFragment();
//                        newPosition = 5;
//                        break;
//
//                }
//                loadFragment(fragment,newPosition);
////                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
////                transaction.replace(R.id.frag_cont,fragment);
////                //transaction.setCustomAnimations(android.R.anim.slide_in_left,android.R.anim.slide_out_right);
////                transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
////                //transaction.setCustomAnimations(R.anim.enter_from_right,R.anim.exit_to_right,R.anim.enter_from_left,R.anim.exit_to_left);
////                transaction.commit();
//            }
//        });

    }

    private boolean loadFragment(Fragment fragment, int newPosition) {

        if(fragment != null) {
            if(startingPosition > newPosition) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.slide_out_right );
                transaction.replace(R.id.frag_cont, fragment);
                transaction.commit();
            }
            if(startingPosition < newPosition) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_left);
                transaction.replace(R.id.frag_cont, fragment);
                transaction.commit();
            }
            startingPosition = newPosition;
            return true;
        }
        return false;
    }

    @Override
    public void onBackPressed() {
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.chip_bottom_nav);
        int seletedItemId = bottomNavigationView.getSelectedItemId();
        if (R.id.home != seletedItemId) {
            setHomeItem(HomeActivity.this);
        } else {
            super.onBackPressed();
        }
    }

    public static void setHomeItem(Activity activity) {
        BottomNavigationView bottomNavigationView = (BottomNavigationView)
                activity.findViewById(R.id.chip_bottom_nav);
        bottomNavigationView.setSelectedItemId(R.id.home);
    }
}