package com.krash.applemart.Ui.AllAccountActivities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.krash.applemart.R;
import com.krash.applemart.databinding.ActivityNotificationBinding;

public class NotificationActivity extends AppCompatActivity {

    ActivityNotificationBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_notification);


        binding.backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        finish();
        Animatoo.animateSlideRight(NotificationActivity.this);

    }
}