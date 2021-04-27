package com.flightbooking.fragments;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.Image;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.flightbooking.R;
import com.flightbooking.Utils;
import com.flightbooking.activies.CustomerLoginActivity;
import com.flightbooking.activies.MainActivity;


public class LogoutFragment extends Fragment {
    View view;
    ImageView img_logout;
    SharedPreferences sharedPreferences;


    public static LogoutFragment logoutFragment() {
        LogoutFragment fragment = new LogoutFragment();
        return fragment;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        view = inflater.inflate(R.layout.fragment_logout, container, false);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("Logout");
        img_logout=(ImageView)view.findViewById(R.id.img_logout);
        img_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sharedPreferences = getActivity().getSharedPreferences(Utils.SHREF, Context.MODE_PRIVATE);
                SharedPreferences.Editor et=sharedPreferences.edit();
                et.clear().apply();
                startActivity(new Intent(getContext(), MainActivity.class));
                ((Activity)getActivity()).finish();
            }
        });

        return view;
    }
}