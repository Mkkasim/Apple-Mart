package com.krash.applemart.Login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.google.android.material.snackbar.Snackbar;
import com.krash.applemart.BaseServices.AppConstants;
import com.krash.applemart.R;
import com.krash.applemart.SplashActivity;
import com.krash.applemart.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {

    ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login);

        
        binding.sendOtp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String value = binding.phoneEdt.getText().toString().trim();
                    if (!value.trim().isEmpty() && value.length()==10){
                        Intent intent = new Intent(getApplicationContext(),OtpVerificationActivity.class);
                        intent.putExtra("phone",value.trim());
                        startActivity(intent);
                        Animatoo.animateSlideLeft(LoginActivity.this);
                        finish();
                    }else {
                        Snackbar.make(binding.getRoot(),"Please enter a valid number",Snackbar.LENGTH_SHORT).show();
                    }
            }
        });
        
    }

    private void askUserLocationPermission() {

    }
}