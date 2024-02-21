package com.krash.applemart.Ui.AllAccountActivities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.krash.applemart.R;
import com.krash.applemart.Ui.HomeActivity;
import com.krash.applemart.databinding.ActivityOrderHistoryBinding;

public class OrderHistoryActivity extends AppCompatActivity {

    ActivityOrderHistoryBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_order_history);



        binding.backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        binding.getStaertedBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(OrderHistoryActivity.this, HomeActivity.class);
                startActivity(in);
                Animatoo.animateSlideRight(OrderHistoryActivity.this);
                finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
        Animatoo.animateSlideRight(OrderHistoryActivity.this);
    }
}