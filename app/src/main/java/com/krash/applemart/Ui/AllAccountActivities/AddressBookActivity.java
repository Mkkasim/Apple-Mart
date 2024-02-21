package com.krash.applemart.Ui.AllAccountActivities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.krash.applemart.R;
import com.krash.applemart.databinding.ActivityAddressBookBinding;

public class AddressBookActivity extends AppCompatActivity {

    ActivityAddressBookBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_address_book);


        binding.backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        binding.relateAddAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
        Animatoo.animateSlideRight(AddressBookActivity.this);
    }
}