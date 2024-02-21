package com.krash.applemart.Login;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Toast;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.krash.applemart.LocationActivity;
import com.krash.applemart.R;
import com.krash.applemart.SessionManager.SessionManagement;
import com.krash.applemart.SplashActivity;
import com.krash.applemart.Ui.HomeActivity;
import com.krash.applemart.databinding.ActivityOtpVerificationBinding;

import java.util.concurrent.TimeUnit;

public class OtpVerificationActivity extends AppCompatActivity {

    ActivityOtpVerificationBinding binding;

    private FirebaseAuth mAuth;
    private String mVerificationId;
    private String number;
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference userReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_otp_verification);

        SessionManagement.init(this);
        mAuth = FirebaseAuth.getInstance();
        firebaseDatabase =  FirebaseDatabase.getInstance();

        handleIntent();

        binding.otpPhoneNo.setText(number);
        binding.verifyOtp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String value = binding.otpView.getOTP();
                verifyVerificationCode(value);
            }
        });

        binding.resendCodeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.timer.setVisibility(View.VISIBLE);
                binding.resendCodeBtn.setVisibility(View.GONE);
                sentOtp(number);

            }
        });


    }



    private void handleIntent() {
        number = getIntent().getStringExtra("phone");
        sentOtp(number);
    }

    private void sentOtp(String number) {

        PhoneAuthOptions options =
                PhoneAuthOptions.newBuilder(mAuth)
                        .setPhoneNumber("+91" + number)            // Phone number to verify
                        .setTimeout(60L, TimeUnit.SECONDS) // Timeout and unit
                        .setActivity(this)                 // Activity (for callback binding)
                        .setCallbacks(mCallBack)           // OnVerificationStateChangedCallbacks
                        .build();
        PhoneAuthProvider.verifyPhoneNumber(options);

        new CountDownTimer(60 * 1000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                int timeLeft = (int) millisUntilFinished / 1000;
                binding.timer.setText( timeLeft + " s");
            }

            @Override
            public void onFinish() {
                binding.timer.setVisibility(View.INVISIBLE);
                binding.resendCodeBtn.setVisibility(View.VISIBLE);

//                binding.resendCodeBtn.setOnClickListener(view -> {
//                    sendVerificationCode(number);
//                });

            }
        }.start();

    }
    private PhoneAuthProvider.OnVerificationStateChangedCallbacks
            mCallBack = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {

        @Override
        public void onCodeSent(String s, PhoneAuthProvider.ForceResendingToken forceResendingToken) {
            super.onCodeSent(s, forceResendingToken);
            mVerificationId = s;

        }

        @Override
        public void onVerificationCompleted(PhoneAuthCredential phoneAuthCredential) {

            String code = phoneAuthCredential.getSmsCode();

            //sometime the code is not detected automatically
            //in this case the code will be null
            //so user has to manually enter the code
            if (code != null) {

                binding.otpView.setOTP(code);
                //verifying the code
                verifyVerificationCode(code);
            } else {
                binding.otpView.showError();
                Toast.makeText(OtpVerificationActivity.this, "Incorrect OTP", Toast.LENGTH_SHORT).show();
            }

        }

        @Override
        public void onVerificationFailed(FirebaseException e) {
            // Toast.makeText(OtpVerificationActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();


        }
    };



    private void verifyVerificationCode(String code) {

        if(code != null){
            PhoneAuthCredential credential = PhoneAuthProvider.getCredential(mVerificationId, code);

            //signing the user
            signInWithPhoneAuthCredential(credential);

        }else{
            Toast.makeText(this, "Please enter your otp", Toast.LENGTH_SHORT).show();
        }

    }

    private void signInWithPhoneAuthCredential(PhoneAuthCredential credential) {
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            binding.otpView.showSuccess();
                            storeDataFromFirebase();

                        } else {
                            // Toast.makeText(getApplicationContext(), "It seems like you entered a wrong otp", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    private void storeDataFromFirebase() {
        //FirebaseUtils.FAN_USERS_PROFILE
        userReference = firebaseDatabase.getReference("Users").child(number);
        userReference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (!snapshot.exists()) {
                    // SessionManagement.setLogin(true);
                    if (number != null) {
                        SessionManagement.saveUserNum(number);
                        Intent intent = new Intent(OtpVerificationActivity.this, LocationActivity.class);
                        intent.putExtra("number",""+number);
                        intent.putExtra("comesfrom","otpveri");
                        startActivity(intent);
                        Animatoo.animateSlideLeft(OtpVerificationActivity.this);
                        finish();
                    }
                } else {
                    if (number != null) {
                        SessionManagement.saveUserNum(number);
                        SessionManagement.setLogin(true);
                        Toast.makeText(getApplicationContext(), "Login Successful", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(OtpVerificationActivity.this, LocationActivity.class);
                        startActivity(intent);
                        Animatoo.animateSlideLeft(OtpVerificationActivity.this);
                        finish();
                    }
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        Intent in = new Intent(OtpVerificationActivity.this,LoginActivity.class);
        startActivity(in);
        finish();
        Animatoo.animateSlideRight(OtpVerificationActivity.this);

    }
}