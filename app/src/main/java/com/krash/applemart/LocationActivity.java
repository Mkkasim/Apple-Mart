package com.krash.applemart;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.krash.applemart.Login.LoginActivity;
import com.krash.applemart.SessionManager.SessionManagement;
import com.krash.applemart.Ui.HomeActivity;
import com.krash.applemart.databinding.ActivityLocationBinding;

public class LocationActivity extends AppCompatActivity {

    ActivityLocationBinding binding;
    String number,comesfrom;
    DatabaseReference userRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_location);
        SessionManagement.init(this);
        handleIntent();

        if (comesfrom != null && comesfrom.equalsIgnoreCase("otpveri")){
            setUserDetails();
        }


        binding.LoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(LocationActivity.this, HomeActivity.class);
                startActivity(in);
                Animatoo.animateSlideLeft(LocationActivity.this);
                finish();
            }
        });
    }



    private void handleIntent() {
        number = getIntent().getStringExtra("number");
        comesfrom = getIntent().getStringExtra("comesfrom");
        Log.d("TAG2","UserNumber "+number);
        Log.d("TAG2","ComesFrom "+comesfrom);
    }

    private void setUserDetails() {
        userRef = FirebaseDatabase.getInstance().getReference("Users").child(number);
        userRef.child("number").setValue(number);
        SessionManagement.setLogin(true);
    }

}