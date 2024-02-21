package com.krash.applemart;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.krash.applemart.Login.LoginActivity;
import com.krash.applemart.SessionManager.SessionManagement;
import com.krash.applemart.databinding.ActivitySplashBinding;

public class SplashActivity extends AppCompatActivity {

    ActivitySplashBinding binding;

    Animation left_to_right,right_to_left,fade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_splash);
        SessionManagement.init(this);

        left_to_right = AnimationUtils.loadAnimation(this,R.anim.enter_from_right);
        right_to_left = AnimationUtils.loadAnimation(this,R.anim.enter_from_left);
        fade = AnimationUtils.loadAnimation(this,R.anim.fadein);
        binding.imgSplash.startAnimation(left_to_right);
        binding.textMart.startAnimation(right_to_left);
        binding.textMartDes.startAnimation(fade);


        if (SessionManagement.isLogged() && SessionManagement.getNumber() != null) {

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent intent = new Intent(SplashActivity.this, LocationActivity.class);
                    startActivity(intent);
                    Animatoo.animateFade(SplashActivity.this);
                    finish();
                }
            }, 3000);

        } else {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
                    startActivity(intent);
                    Animatoo.animateFade(SplashActivity.this);
                    finish();
                }
            }, 3000);

        }
    }
}