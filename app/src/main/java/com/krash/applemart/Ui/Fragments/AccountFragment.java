package com.krash.applemart.Ui.Fragments;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.blogspot.atifsoftwares.animatoolib.Animatoo;
import com.krash.applemart.Login.LoginActivity;
import com.krash.applemart.R;
import com.krash.applemart.SessionManager.SessionManagement;
import com.krash.applemart.Ui.AllAccountActivities.AboutUsActivity;
import com.krash.applemart.Ui.AllAccountActivities.AddressBookActivity;
import com.krash.applemart.Ui.AllAccountActivities.CustomerSupportActivity;
import com.krash.applemart.Ui.AllAccountActivities.NotificationActivity;
import com.krash.applemart.Ui.AllAccountActivities.OrderHistoryActivity;
import com.krash.applemart.databinding.FragmentAccountBinding;


public class AccountFragment extends Fragment {

    FragmentAccountBinding binding;

    public AccountFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentAccountBinding.inflate(inflater,container,false);

        SessionManagement.init(requireActivity());

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if (SessionManagement.isLogged()) {
            binding.textWelcome.setText("Your Account");
            binding.textToView.setText(SessionManagement.getNumber());
            binding.loginBtn.setVisibility(View.GONE);
            binding.relateLogout.setVisibility(View.VISIBLE);
        }

        binding.loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent in = new Intent(getContext(), LoginActivity.class);
                startActivity(in);
                Animatoo.animateFade(getContext());
                requireActivity().finish();

            }
        });

        binding.relateOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(getContext(), OrderHistoryActivity.class);
                startActivity(in);
                Animatoo.animateSlideLeft(getContext());
            }
        });

        binding.relateAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(getContext(), AddressBookActivity.class);
                startActivity(in);
                Animatoo.animateSlideLeft(getContext());
            }
        });

        binding.relatePayments.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        binding.relateNotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(getContext(), NotificationActivity.class);
                startActivity(in);
                Animatoo.animateSlideLeft(getContext());
            }
        });

        binding.relateCustomer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(getContext(), CustomerSupportActivity.class);
                startActivity(in);
                Animatoo.animateSlideLeft(getContext());
            }
        });

        binding.relateRateUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog();
            }
        });

        binding.relateShareApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        binding.relateAboutus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(getContext(), AboutUsActivity.class);
                startActivity(in);
                Animatoo.animateSlideLeft(getContext());
            }
        });

        binding.relateLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        binding.relateAppversion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });



    }

    private void showDialog(){
        Dialog dialog = new Dialog(requireContext());
        dialog.setContentView(R.layout.layout_rateus_dialog);
        dialog.getWindow().setBackgroundDrawableResource(R.drawable.bg_border);
        dialog.show();

        ImageView closeBtn = dialog.findViewById(R.id.closeBtn);
        ImageView liked = dialog.findViewById(R.id.liked);
        ImageView unliked = dialog.findViewById(R.id.unliked);

        closeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        liked.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showLikedDialog();
                dialog.dismiss();
            }
        });
        unliked.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showUnLikeDialog();
                dialog.dismiss();
            }
        });
    }

    private void showLikedDialog(){
        Dialog Likeddialog = new Dialog(requireContext());
        Likeddialog.setContentView(R.layout.layout_give_star_dialog);
        Likeddialog.getWindow().setBackgroundDrawableResource(R.drawable.bg_border);
        Likeddialog.show();

        ImageView closeBtn = Likeddialog.findViewById(R.id.closeBtn);
        TextView yeahBtn = Likeddialog.findViewById(R.id.yeahBtn);
        TextView nopeBtn = Likeddialog.findViewById(R.id.nopeBtn);

        closeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Likeddialog.dismiss();
            }
        });
        yeahBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        nopeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Likeddialog.dismiss();
            }
        });
    }
    private void showUnLikeDialog(){
        Dialog unLikedDialog = new Dialog(requireContext());
        unLikedDialog.setContentView(R.layout.layout_helpus_dialog);
        unLikedDialog.getWindow().setBackgroundDrawableResource(R.drawable.bg_border);
        unLikedDialog.show();

        ImageView closeBtn = unLikedDialog.findViewById(R.id.closeBtn);
        TextView yeahBtn = unLikedDialog.findViewById(R.id.yeahBtn);
        TextView nopeBtn = unLikedDialog.findViewById(R.id.nopeBtn);

        closeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                unLikedDialog.dismiss();
            }
        });
        yeahBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        nopeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                unLikedDialog.dismiss();
            }
        });
    }
}